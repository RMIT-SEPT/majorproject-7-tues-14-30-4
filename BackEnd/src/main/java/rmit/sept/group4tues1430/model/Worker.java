package rmit.sept.group4tues1430.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Worker extends User
{
    private String days;
    private String times;
    private String companyID;
    private String companyName;
    private String[] availableDays;

    public Worker() {

    }

     public Worker(String id, String firstName, String lastName, String password, String userType, String phone,
                   String days, String times, String companyID, String[] availableDays)
     {
         super(id, firstName, lastName, password, userType, phone);
         this.days = days;
         this.times = times;
         this.companyID = companyID;
         this.availableDays = availableDays;
     }

    public String getDays(){
        return days;
    }

    public void setDays(String days){
        this.days = days;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTimes(){
        return times;
    }

    public void setTimes(String times){
        this.times = times;
    }

    public String getCompany_ID()
    {
        return companyID;
    }

    public void setCompany_ID(String company_ID)
    {
        this.companyID = company_ID;
    }

    public String[] getAvailableDays() { return availableDays; }

    public void setAvailableDays(String[] availableDays) { this.availableDays = availableDays; }
}