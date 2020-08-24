package rmit.sept.group4tues1430.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Admin extends User
{
    private boolean priviledges;

    public Admin(String id, String firstName, String lastName, String password, String userType, String phone,
                 boolean priviledges) {
        super(id, firstName, lastName, password, userType, phone);
        this.priviledges = priviledges;
    }

    public boolean getPriviledges() {
        return priviledges;
    }

    public void  setPriviledges(boolean priviledges) {
        this.priviledges = priviledges;
    }
}