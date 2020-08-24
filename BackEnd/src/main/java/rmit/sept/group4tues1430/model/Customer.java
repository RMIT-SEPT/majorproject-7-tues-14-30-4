package rmit.sept.group4tues1430.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Customer extends User
{

    private String address;
//    private String[] bookingsList;

    public Customer() {

    }

    public Customer(String id, String firstName, String lastName, String password, String userType, String phone, String address) {
        super(id, firstName, lastName, password, userType, phone);
        this.address = address;

    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

}
