package rmit.sept.group4tues1430.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import rmit.sept.group4tues1430.model.Customer;
import org.springframework.http.HttpStatus;
import rmit.sept.group4tues1430.model.Worker;
import rmit.sept.group4tues1430.services.CustomerService;
import rmit.sept.group4tues1430.services.WorkerService;

import java.util.List;

public class WorkerController {
    @Autowired
    private WorkerService workerService;

    @GetMapping("/users")
    public List<Worker> getAllWorkers()
    {
        return workerService.getAllWorkers();
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getWorkerByName(String name)
    {
        Worker worker = workerService.getWorkerByName(name);

        return new ResponseEntity<Worker>(worker, HttpStatus.OK);
    }

    @GetMapping("/{personId}")
    public ResponseEntity<?>  getWorkerByID(String id)
    {
        Worker worker = workerService.getWorkerByID(id);
        return new ResponseEntity<Worker>(worker, HttpStatus.OK);
    }

    @GetMapping("/users")
    public Iterable<Worker> findAllWorkers()
    {
        return workerService.findAllWorkers();
    }

    @GetMapping("/{personId}")
    public void deleteWorkerByIdentifier(String id)
    {
        workerService.deleteWorkerByIdentifier(id);
    }

    @GetMapping("/{worker}")
    public  ResponseEntity<?> saveOrUpdateWorker(Worker worker)
    {
        Worker worker1 = workerService.saveOrUpdateWorker(worker);
        return new ResponseEntity<Worker>(worker1, HttpStatus.OK);
    }
}
