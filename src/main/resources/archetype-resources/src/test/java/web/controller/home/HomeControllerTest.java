package ${package}.web.controller.home;

import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.google.appengine.tools.development.testing.LocalUserServiceTestConfig;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ModelMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:webApplicationContext.xml")
public class HomeControllerTest {

    // Required for local testing
    private LocalServiceTestHelper helper;

    @Autowired
    private HomeController controller;

    @After
    public void tearDown() {
        helper.tearDown();
    }

    @Test
    public void testNoUser() throws Exception {
        helper = new LocalServiceTestHelper(new LocalUserServiceTestConfig());
        helper.setUp();
        ModelMap modelMap = new ModelMap();

        String result = controller.home(modelMap);
        assertNotNull(result);
        assertEquals("home/homeNotSignedIn", result);
    }

    @Test
    public void testUserLoggedIn() throws Exception {
        helper = new LocalServiceTestHelper(new LocalUserServiceTestConfig());
        helper.setEnvIsLoggedIn(true);
        helper.setEnvEmail("email@address.com");
        helper.setEnvAuthDomain("domain");
        helper.setUp();
        ModelMap modelMap = new ModelMap();

        String result = controller.home(modelMap);
        assertNotNull(result);
        assertEquals("home/homeSignedIn", result);
    }
}