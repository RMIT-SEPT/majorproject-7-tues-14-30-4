package rmit.sept.group4tues1430.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;


/*
 * This represents a booking in the system
 * Hence an association between a customer, a worker and a service
 * Also stores the date/time of the booking
 */
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String customerUserIdentifier;

    private String workerUserIdentifier;

    private Date dateAndTime;

    private String serviceName;

    public Booking() {
    }

    public Booking(String id, String customerUserIdentifier, String workerUserIdentifier,
                   Date date, String serviceName) {
        this.id = id;
        this.customerUserIdentifier = customerUserIdentifier;
        this.workerUserIdentifier = workerUserIdentifier;
        this.dateAndTime = date;
        this.serviceName = serviceName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setCustomerUserIdentifier(String customerUserIdentifier) {
        this.customerUserIdentifier = customerUserIdentifier;
    }

    public String getCustomerUserIdentifier() {
        return customerUserIdentifier;
    }

    public void setWorkerUserIdentifier(String workerUserIdentifier) {
        this.workerUserIdentifier = workerUserIdentifier;
    }

    public String getWorkerUserIdentifier() {
        return workerUserIdentifier;
    }

    public void setDate(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }
}
