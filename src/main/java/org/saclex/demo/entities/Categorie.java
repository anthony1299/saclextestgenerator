package org.saclex.demo.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@XmlRootElement
@Table(name = "categorie")
public class Categorie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_categorie")
    private Long idCategorie;

    @Column(name = "libelle",nullable = false)
    private String libelle;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "theme",nullable = false)
    private Theme theme;

    @Column(name = "date_creation")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateCreation;

    @OneToMany(mappedBy = "categorie",fetch=FetchType.LAZY)
    private List<Question> questions = new ArrayList<>();

    @Column(name = "date_modification")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateModification;

    public Categorie() {
    }

    public Categorie(String libelle, String description, Theme theme, Date dateCreation, Date dateModification) {
        this.libelle = libelle;
        this.description = description;
        this.theme = theme;
        this.dateCreation = dateCreation;
        this.dateModification = dateModification;
    }

    public Long getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Long idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }
}

