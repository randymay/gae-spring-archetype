package ${package}.dto;

import com.blaazinsoftware.centaur.data.dto.AbstractEntity;
import com.googlecode.objectify.annotation.Entity;

/**
 * @author Randy May
 *         Date: 16-01-04
 */
@Entity
public class UserProfile extends AbstractEntity {
    private String firstName = null;
    private String lastName = null;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
