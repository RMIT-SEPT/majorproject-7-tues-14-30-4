package rmit.sept.group4tues1430.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity

public class Worker extends User
{
    private String days;
    private String times;
    private String company_ID;

    public Worker(Long id, String firstName, String lastName, String password, String userType, String phone,
                  String days, String times, String company_ID)
    {
        super(id, firstName, lastName, password, UserType, phone);
        this.days = days;
        this.times = times;
        this.company_ID = company_ID;
    }

    public String getDays(){
        return days;
    }

    public void setDays(String days){
        this.days = days;
    }

    public String getTimes(){
        return times;
    }

    public void setTimes(String times){
        this.times = times;
    }

    public String getCompany_ID()
    {
        return company_ID;
    }

    public void setCompany_ID(String company_ID)
    {
        this.company_ID;
    }

}