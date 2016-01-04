package ${package}.web.controller.home;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
@Controller
public class HomeController {

    Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @RequestMapping(value = {"/", "/home"})
    public String home(ModelMap modelMap) {
        UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        modelMap.put("user", user);

        if (user != null) {
            log.log(Level.INFO, "User '" + user.getEmail() + "' is using the system.");
            modelMap.put("loginUrl", userService.createLoginURL("/home"));

            return "home/homeSignedIn";
        }
        // User has not signed in

        return "home/homeNotSignedIn";
    }
}
