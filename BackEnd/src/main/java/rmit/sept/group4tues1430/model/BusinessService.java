package rmit.sept.group4tues1430.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;


// Represents a Service provided by the system
@Entity
public class BusinessService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Business Service identifier must not be blank")
    private String businessIdentifier;

    @NotBlank(message = "Business Service name must not be blank")
    private String name;

    @NotBlank(message = "For each business service there must be an admin ID corresponding to it")
    private String adminId;

    public BusinessService() {
    }

    public BusinessService(String name, String businessIdentifier, String adminId) {
      this.name = name;
      this.businessIdentifier = businessIdentifier;
      this.adminId = adminId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusinessIdentifier() { return businessIdentifier; }

    public void setBusinessIdentifier(String businessIdentifier) { this.businessIdentifier = businessIdentifier; }

    public String getAdminId() { return adminId; }

    public void setAdminId(String adminId) { this.adminId = adminId; }
}