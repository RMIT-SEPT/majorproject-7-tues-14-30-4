package rmit.sept.group4tues1430.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import rmit.sept.group4tues1430.exceptions.InvalidUserException;
import rmit.sept.group4tues1430.model.User;
import rmit.sept.group4tues1430.model.Worker;
import rmit.sept.group4tues1430.repositories.WorkerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Worker saveOrUpdateWorker(Worker worker) {

        if(worker.getName().isEmpty())
        {
            throw new IllegalArgumentException();
        }
        if(worker.getUserType().isEmpty())
        {
            throw new IllegalArgumentException();
        }

        try {
            worker.setUserIdentifier(worker.getUserIdentifier().toUpperCase());
            worker.setPassword(bCryptPasswordEncoder.encode(worker.getPassword()));

            return workerRepository.save(worker);
        } catch (Exception e)
        {
            throw new InvalidUserException("The Worker Identifier " +
                    worker.getUserIdentifier().toUpperCase() + " already exists.");
        }
    }

    public Worker getWorkerByName(String name) {

        return workerRepository.findByName(name);
    }

    public List<Worker> getWorkersByCompanyID(String id) {
        List<Worker> workers = new ArrayList<Worker>();
        workerRepository.findWorkersByCompanyID(id).forEach(workers::add);
        return workers;
    }

    public List<Worker> getWorkersByCompanyName(String name) {
        List<Worker> workers = new ArrayList<Worker>();
        workerRepository.findWorkersByCompanyName(name).forEach(workers::add);
        return workers;
    }

    public Worker getWorkerByID(String id) {
        return workerRepository.findByUserIdentifier(id);
    }

    public List<Worker> getAllWorkers() {
        List<Worker> workers = new ArrayList<Worker>();
        workerRepository.findAll().forEach(workers::add);
        return workers;
    }

    public Iterable<Worker> findAllWorkers(){

        return workerRepository.findAll();
    }

    public void deleteWorkerByIdentifier(String id){
        Worker worker = workerRepository.findByUserIdentifier(id);

//        if(person == null){
//            throw  new  PersonException("Cannot Person with ID '"+personId+"'. This person does not exist");
//        }

        workerRepository.delete(worker);
    }
}
