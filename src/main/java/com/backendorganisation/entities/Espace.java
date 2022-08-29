package com.backendorganisation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Lob;

@Entity
@Table(name="espace")
public class Espace implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private String presentation;
    private String objectifs;

    @Lob
    private String logo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public Espace() {

    }

    public Espace(String libelle, String presentation, String objectifs, String logo, User user) {
        this.libelle = libelle;
        this.presentation = presentation;
        this.objectifs = objectifs;
        this.logo = logo;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getPresentation() {
        return presentation;
    }

    public String getObjectifs() {
        return objectifs;
    }

    public String getLogo() {
        return logo;
    }

    public User getUser() {
        return user;
    }
}
