package fabrication.controller;

import fabrication.entity.OrdreFabrication;
import fabrication.repository.OrdreFabricationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordres")
@CrossOrigin("*")
public class OrdreFabricationController {

    private final OrdreFabricationRepository ordreFabricationRepository;

    public OrdreFabricationController(OrdreFabricationRepository ordreFabricationRepository) {
        this.ordreFabricationRepository = ordreFabricationRepository;
    }

    @GetMapping
    public List<OrdreFabrication> getOrdres() {
        return ordreFabricationRepository.findAll();
    }

    @PostMapping
    public OrdreFabrication addOrdre(@RequestBody OrdreFabrication ordreFabrication) {
        return ordreFabricationRepository.save(ordreFabrication);
    }

    @PutMapping("/{id}")
    public OrdreFabrication updateOrdre(@PathVariable Long id,
                                        @RequestBody OrdreFabrication ordreFabrication) {
        ordreFabrication.setId(id);
        return ordreFabricationRepository.save(ordreFabrication);
    }

    @DeleteMapping("/{id}")
    public void deleteOrdre(@PathVariable Long id) {
        ordreFabricationRepository.deleteById(id);
    }
}