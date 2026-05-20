package fabrication.controller;

import fabrication.entity.Employe;
import fabrication.repository.EmployeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employes")
@CrossOrigin("*")
public class EmployeController {

    private final EmployeRepository employeRepository;

    public EmployeController(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    @GetMapping
    public List<Employe> getEmployes() {
        return employeRepository.findAll();
    }

    @PostMapping
    public Employe addEmploye(@RequestBody Employe employe) {
        return employeRepository.save(employe);
    }

    @PutMapping("/{id}")
    public Employe updateEmploye(@PathVariable Long id, @RequestBody Employe employe) {
        employe.setId(id);
        return employeRepository.save(employe);
    }

    @DeleteMapping("/{id}")
    public void deleteEmploye(@PathVariable Long id) {
        employeRepository.deleteById(id);
    }
}