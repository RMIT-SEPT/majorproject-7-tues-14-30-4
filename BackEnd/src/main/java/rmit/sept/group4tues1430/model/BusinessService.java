package rmit.sept.group4tues1430.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;


@Entity
public class BusinessService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@NotBlank(message = "Service name must not be blank")
    private String name;

    //private List<Worker> serviceWorkers; //this doesn't work?

    public BusinessService() {

    }

    public BusinessService(String name, Long id) {
        this.name = name;
        this.id = id;
        //serviceWorkers = new ArrayList<Worker>();
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

//    public void addWorker(Worker worker) {
//        serviceWorkers.add(worker);
//    }
}