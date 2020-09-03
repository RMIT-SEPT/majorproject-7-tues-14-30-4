package rmit.sept.group4tues1430.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Size(min = 3, max = 20, message = "Please enter 3 to 20 characters") // doesn't seem to work?
    @NotBlank(message = "Name is required")
    private String name;

    private String userType;

    @NotBlank
    @Column(updatable = false, unique = true)
    private String userIdentifier;

    @JsonFormat(pattern ="yyyy-mm-dd")
    private Date created_At;

    @JsonFormat(pattern ="yyyy-mm-dd")
    private Date updated_At;

    @NotBlank
    private String phone;

    @NotBlank(message = "Password is required")
    private String password;

    public User() {
    }

    public User(String id, String firstName, String lastName, String password, String userType, String phone) {
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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public void setUserIdentifier(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword(String password) {
        return password;
    }

    public Date getUpdated_At() {
        return updated_At;
    }

    public void setUpdated_At(Date updated_At) {
        this.updated_At = updated_At;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    @PrePersist
    protected void onCreate() {
        this.created_At = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated_At = new Date();
    }

}