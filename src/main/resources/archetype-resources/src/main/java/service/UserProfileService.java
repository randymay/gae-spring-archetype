package ${package}.service;

import com.blaazinsoftware.centaur.service.CentaurService;
import com.blaazinsoftware.dto.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Randy May
 *         Date: 16-01-04
 */
@Service
public class UserProfileService {
    @Autowired
    private CentaurService service;

    public String saveProfile(UserProfile profile) {
        return service.saveForKey(profile);
    }

    public UserProfile getProfile(String profileKey) {
        return service.getEntity(profileKey);
    }

    public void deleteProfile(String profileKey) {
        service.deleteEntity(profileKey);
    }
}
