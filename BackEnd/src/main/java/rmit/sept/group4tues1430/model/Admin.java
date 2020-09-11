package rmit.sept.group4tues1430.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

// Extends User, maps to own table
@Entity
public class Admin extends User
{
    private boolean privileges;

    public Admin() {
    }

    public Admin(String id, String firstName, String lastName, String password, String userType, String phone,
                 boolean privileges) {
        super(id, firstName, lastName, password, userType, phone);
        this.privileges = privileges;
    }

    public boolean getPrivileges() {
        return privileges;
    }

    public void  setPrivileges(boolean privileges) {
        this.privileges = privileges;
    }
}