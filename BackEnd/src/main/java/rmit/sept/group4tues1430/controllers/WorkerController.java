package rmit.sept.group4tues1430.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import rmit.sept.group4tues1430.model.User;
import rmit.sept.group4tues1430.model.Worker;
import rmit.sept.group4tues1430.services.MapValidationErrorService;
import rmit.sept.group4tues1430.services.WorkerService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/worker")
@CrossOrigin("*")
public class WorkerController {
    @Autowired
    private WorkerService workerService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewWorker(@Valid @RequestBody Worker worker, BindingResult result) {
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null) {
            return errorMap;
        }

        Worker worker1 = workerService.saveOrUpdateWorker((worker));
        return new ResponseEntity<User>(worker1, HttpStatus.CREATED);
    }
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

    @GetMapping("/byCompanyName/{name}")
    public List<Worker> getWorkersByCompanyName(@PathVariable String name)
    {
        return workerService.getWorkersByCompanyName(name);
    }

    @GetMapping("/byCompanyID/{id}")
    public List<Worker> getCompanyWorkers(@PathVariable String id)
    {
        return workerService.getWorkersByCompanyID(id);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?>  getWorkerByID(@PathVariable String id)
    {
        Worker worker = workerService.getWorkerByID(id);
        return new ResponseEntity<Worker>(worker, HttpStatus.OK);
    }


    @DeleteMapping("/id/{id}")
    public void deleteWorkerByIdentifier(@PathVariable String id)
    {
        workerService.deleteWorkerByIdentifier(id);
    }

}
