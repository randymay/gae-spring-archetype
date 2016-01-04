package ${package}.service;

import com.blaazinsoftware.centaur.service.DefaultCentaurServiceImpl;
import ${package}.dto.UserProfile;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.util.Closeable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author Randy May
 *         Date: 16-01-04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class UserProfileServiceTest {

    // Required for local testing
    private final LocalServiceTestHelper helper =
            new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

    private Closeable session;

    @Autowired
    private UserProfileService service;

    @Before
    public void setUp() {
        helper.setUp();

        session = ObjectifyService.begin();

        ObjectifyService.register(UserProfile.class);
    }

    @After
    public void tearDown() {
        helper.tearDown();

        session.close();
    }

    @Test
    public void testUserProfileCRUD() throws Exception {
        final String firstName = "firstName";
        final String lastName = "lastName";

        UserProfile userProfile = new UserProfile();
        userProfile.setFirstName(firstName);
        userProfile.setLastName(lastName);

        String key = service.saveProfile(userProfile);
        UserProfile loadedProfile = service.getProfile(key);
        assertNotNull(loadedProfile);
        assertEquals(firstName, loadedProfile.getFirstName());
        assertEquals(lastName, loadedProfile.getLastName());

        assertEquals(userProfile, loadedProfile);
        service.deleteProfile(key);
        assertNull(service.getProfile(key));
    }

}