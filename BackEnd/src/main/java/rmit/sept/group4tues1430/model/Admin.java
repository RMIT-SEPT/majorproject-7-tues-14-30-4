package rmit.sept.group4tues1430.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

// Extends User, maps to own table
@Entity
public class Admin extends User
{
    private boolean privileges;
    private String company_ID;

    public Admin() {
    }

     public Admin(String id, String firstName, String lastName, String password, String userType, String phone,
                  boolean privileges, String company_ID) {
         super(id, firstName, lastName, password, userType, phone);
         this.privileges = privileges;
         this.company_ID = company_ID;
     }

    public boolean getPrivileges() {
        return privileges;
    }

    public void  setPrivileges(boolean privileges) {
        this.privileges = privileges;
    }

    public String getCompany_ID() { return company_ID; }
}