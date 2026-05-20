package fabrication.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String etat;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate derniereMaintenance;


    public Machine() {
    }
    public Machine(Long id, String nom, String etat, LocalDate derniereMaintenance) {
        this.id = id;
        this.nom = nom;
        this.etat = etat;
        this.derniereMaintenance = derniereMaintenance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public LocalDate getDerniereMaintenance() {
        return derniereMaintenance;
    }

    public void setDerniereMaintenance(LocalDate derniereMaintenance) {
        this.derniereMaintenance = derniereMaintenance;
    }
}