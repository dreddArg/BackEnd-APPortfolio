package com.portfolio.BackEnd.Dto;

import javax.validation.constraints.NotBlank;

public class DtoPersona {
    
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String bio;
    
    @NotBlank
    private String longBio;
    
    @NotBlank
    private String fotoPerfilUrl;

    //contructors
    public DtoPersona() {
    }

    public DtoPersona(String nombre, String bio, String longBio, String fotoPerfilUrl) {
        this.nombre = nombre;
        this.bio = bio;
        this.longBio = longBio;
        this.fotoPerfilUrl = fotoPerfilUrl;
    }
    //getters setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLongBio() {
        return longBio;
    }

    public void setLongBio(String longBio) {
        this.longBio = longBio;
    }

    public String getFotoPerfilUrl() {
        return fotoPerfilUrl;
    }

    public void setFotoPerfilUrl(String fotoPerfilUrl) {
        this.fotoPerfilUrl = fotoPerfilUrl;
    }
    
}
