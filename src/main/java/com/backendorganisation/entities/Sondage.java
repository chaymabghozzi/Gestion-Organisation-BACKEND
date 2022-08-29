package com.backendorganisation.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="sondage")
public class Sondage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "{task.name.not.empty}")
    private String name;




    @Column(length = 5)
    private String reponse;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dateSondage;


    @Column(length = 1200)
    @Size(max = 1200, message = "{task.description.size}")
    private String isCompleted;

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<User> user;


    public Sondage() {

    }

    public Sondage(String name,  String reponse, String dateSondage, String isCompleted, Collection<User> user) {
        this.name = name;

        this.reponse = reponse;
        this.dateSondage = dateSondage;
        this.isCompleted = isCompleted;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public String getDateSondage() {
        return dateSondage;
    }

    public void setDateSondage(String dateSondage) {
        this.dateSondage = dateSondage;
    }

    public String getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(String isCompleted) {
        this.isCompleted = isCompleted;
    }

    public Collection<User> getUser() {
        return user;
    }

    public void setUser(Collection<User> user) {
        this.user = user;
    }

}
