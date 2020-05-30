package org.saclex.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@XmlRootElement
@Table(name = "evaluation")
public class Evaluation implements Serializable {
    public enum statuEval{
        Reussi,Echoué
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_evaluation")
    private Long idEvaluation;

    @ManyToOne
    @JoinColumn(name = "type_evaluation")
    private TypeEvaluation typeEvaluation;

    @Column(name = "total")
    private int total;

    @Column(name = "statut")
    @Enumerated(EnumType.STRING)
    private statuEval statut;

    @Column(name = "date_creation")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateCreation;

    @Column(name = "date_modification")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateModification;

    @JsonIgnore
    @OneToMany(mappedBy = "eval",fetch=FetchType.LAZY)
    private List<EvalQuestRep> evalQuest = new ArrayList<>();

    public Evaluation() {
    }

    public Evaluation(TypeEvaluation typeEvaluation, int total, statuEval statut, Date dateCreation, Date dateModification) {
        this.typeEvaluation = typeEvaluation;
        this.total = total;
        this.statut = statut;
        this.dateCreation = dateCreation;
        this.dateModification = dateModification;
    }

    public Evaluation(TypeEvaluation typeEvaluation, Date dateCreation, Date dateModification) {
        this.typeEvaluation = typeEvaluation;
        this.dateCreation = dateCreation;
        this.dateModification = dateModification;
    }

    public Long getIdEvaluation() {
        return idEvaluation;
    }

    public void setIdEvaluation(Long idEvaluation) {
        this.idEvaluation = idEvaluation;
    }

    public TypeEvaluation getTypeEvaluation() {
        return typeEvaluation;
    }

    public void setTypeEvaluation(TypeEvaluation typeEvaluation) {
        this.typeEvaluation = typeEvaluation;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public statuEval getStatut() {
        return statut;
    }

    public void setStatut(statuEval statut) {
        this.statut = statut;
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

    public List<EvalQuestRep> getEvalQuest() {
        return evalQuest;
    }

    public void setEvalQuest(List<EvalQuestRep> evalQuest) {
        this.evalQuest = evalQuest;
    }
}
