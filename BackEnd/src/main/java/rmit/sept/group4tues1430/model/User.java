package rmit.sept.group4tues1430.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Date;

/*
 * Represents all registered users of the system
 * Parent class - extended by the different types of User - Customer, Admin, Worker
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    // Full name
    @NotBlank(message = "Name is required")
    private String name;

    // Column that indicates whether user is Customer, Admin or Worker
    private String userType;

    // the username used for login - therefore, must be unique
    @NotBlank
    @Column(updatable = false, unique = true)
    private String userIdentifier;

    @JsonFormat(pattern ="yyyy-mm-dd")
    private Date created_At;

    @JsonFormat(pattern ="yyyy-mm-dd")
    private Date updated_At;

    private String phone;

    @NotBlank(message = "Password is required")
    private String password;

    public User() {

    }

     public User(String id, String firstName, String lastName, String password, String userType, String phone) {
     }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}