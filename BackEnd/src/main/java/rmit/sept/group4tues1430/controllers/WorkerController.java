package rmit.sept.group4tues1430.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rmit.sept.group4tues1430.model.Customer;
import org.springframework.http.HttpStatus;
import rmit.sept.group4tues1430.model.Worker;
import rmit.sept.group4tues1430.services.CustomerService;
import rmit.sept.group4tues1430.services.WorkerService;

import java.util.List;

@RestController
@RequestMapping("/api/worker")
@CrossOrigin("*")
public class WorkerController {
    @Autowired
    private WorkerService workerService;

    @GetMapping("/all")
    public List<Worker> getAllWorkers()
    {
        return workerService.getAllWorkers();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getWorkerByName(@PathVariable String name)
    {
        Worker worker = workerService.getWorkerByName(name);

        return new ResponseEntity<Worker>(worker, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?>  getWorkerByID(@PathVariable String id)
    {
        Worker worker = workerService.getWorkerByID(id);
        return new ResponseEntity<Worker>(worker, HttpStatus.OK);
    }

    // I think we don't need this as it is similar to getAllWorkers()?
//    @GetMapping("/allWorkers")
//    public Iterable<Worker> findAllWorkers()
//    {
//        return workerService.findAllWorkers();
//    }

    @DeleteMapping("/id/{id}")
    public void deleteWorkerByIdentifier(@PathVariable String id)
    {
        workerService.deleteWorkerByIdentifier(id);
    }

//    @GetMapping("/{worker}")
//    public  ResponseEntity<?> saveOrUpdateWorker(Worker worker)
//    {
//        Worker worker1 = workerService.saveOrUpdateWorker(worker);
//        return new ResponseEntity<Worker>(worker1, HttpStatus.OK);
//    }
}
