package com.example.ecepfe.agilit;

import java.util.List;

/**
 * Created by Jean on 16/01/2018.
 */

public class ContainerTache {

    //Attribut

    private List<String> utilisateurs;
    private String etatdelatache;
    private String tache;
    private Integer remaining;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(List<String> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    public String getEtatdelatache() {
        return etatdelatache;
    }

    public void setEtatdelatache(String etatdelatache) {
        this.etatdelatache = etatdelatache;
    }

    public String getTache() {
        return tache;
    }

    public void setTache(String tache) {
        this.tache = tache;
    }

    public Integer getRemaining() {
        return remaining;
    }

    public void setRemaining(Integer remaining) {
        this.remaining = remaining;
    }
}
