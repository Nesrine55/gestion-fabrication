package fabrication.entity;

import jakarta.persistence.*;

@Entity
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String poste;

    @ManyToOne
    @JoinColumn(name = "machine_id")
    private Machine machine;

    public Employe() {
    }

    public Employe(Long id, String nom, String poste, Machine machine) {
        this.id = id;
        this.nom = nom;
        this.poste = poste;
        this.machine = machine;
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

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }
}