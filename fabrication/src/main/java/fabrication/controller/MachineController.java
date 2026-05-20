package fabrication.controller;

import fabrication.entity.Machine;
import fabrication.repository.MachineRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/machines")
@CrossOrigin("*")
public class MachineController {

    private final MachineRepository machineRepository;

    public MachineController(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }

    @PostMapping
    public Machine ajouterMachine(@RequestBody Machine machine) {
        return machineRepository.save(machine);
    }

    @GetMapping
    public List<Machine> getMachines() {
        return machineRepository.findAll();
    }

    @GetMapping("/{id}")
    public Machine getMachineById(@PathVariable Long id) {
        return machineRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Machine modifierMachine(@PathVariable Long id,
                                   @RequestBody Machine nouvelleMachine) {

        Machine machine = machineRepository.findById(id).orElse(null);

        if (machine != null) {

            machine.setNom(nouvelleMachine.getNom());
            machine.setEtat(nouvelleMachine.getEtat());
            machine.setDerniereMaintenance(nouvelleMachine.getDerniereMaintenance());

            return machineRepository.save(machine);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public void supprimerMachine(@PathVariable Long id) {
        machineRepository.deleteById(id);
    }
}