package fabrication.controller;

import fabrication.entity.Produit;
import fabrication.repository.ProduitRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produits")
@CrossOrigin("*")
public class ProduitController {

    private final ProduitRepository produitRepository;

    public ProduitController(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @PostMapping
    public Produit ajouterProduit(@RequestBody Produit produit) {
        return produitRepository.save(produit);
    }

    @GetMapping
    public List<Produit> getProduits() {
        return produitRepository.findAll();
    }

    @GetMapping("/{id}")
    public Produit getProduitById(@PathVariable Long id) {
        return produitRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Produit modifierProduit(@PathVariable Long id,
                                   @RequestBody Produit nouveauProduit) {

        Produit produit = produitRepository.findById(id).orElse(null);

        if (produit != null) {
            produit.setNom(nouveauProduit.getNom());
            produit.setType(nouveauProduit.getType());
            produit.setStock(nouveauProduit.getStock());
            produit.setFournisseur(nouveauProduit.getFournisseur());

            return produitRepository.save(produit);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public void supprimerProduit(@PathVariable Long id) {
        produitRepository.deleteById(id);
    }

}