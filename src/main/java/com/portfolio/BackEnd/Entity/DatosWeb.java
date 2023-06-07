package com.portfolio.BackEnd.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DatosWeb {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private String logoPrincipalUrl;
    private String hrefPrincipal;
    private String imagenPrincipalUrl;
    private String experienciaTitulo;
    private String educacionTitulo;
    private String habilidadesTitulo;
    private String proyectosTitulo;
    private String footerAutor;
    private String footerLocalidad;
    private int personaActiva_id;
    
    //constructor

    public DatosWeb() {
    }

    public DatosWeb(String titulo, String logoPrincipalUrl, String hrefPrincipal, String imagenPrincipalUrl, String experienciaTitulo, String educacionTitulo, String habilidadesTitulo, String proyectosTitulo, String footerAutor, String footerLocalidad, int personaActiva_id) {
        this.titulo = titulo;
        this.logoPrincipalUrl = logoPrincipalUrl;
        this.hrefPrincipal = hrefPrincipal;
        this.imagenPrincipalUrl = imagenPrincipalUrl;
        this.experienciaTitulo = experienciaTitulo;
        this.educacionTitulo = educacionTitulo;
        this.habilidadesTitulo = habilidadesTitulo;
        this.proyectosTitulo = proyectosTitulo;
        this.footerAutor = footerAutor;
        this.footerLocalidad = footerLocalidad;
        this.personaActiva_id = personaActiva_id;
    }

    //getters setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLogoPrincipalUrl() {
        return logoPrincipalUrl;
    }

    public void setLogoPrincipalUrl(String logoPrincipalUrl) {
        this.logoPrincipalUrl = logoPrincipalUrl;
    }

    public String getHrefPrincipal() {
        return hrefPrincipal;
    }

    public void setHrefPrincipal(String hrefPrincipal) {
        this.hrefPrincipal = hrefPrincipal;
    }

    public String getImagenPrincipalUrl() {
        return imagenPrincipalUrl;
    }

    public void setImagenPrincipalUrl(String imagenPrincipalUrl) {
        this.imagenPrincipalUrl = imagenPrincipalUrl;
    }

    public String getExperienciaTitulo() {
        return experienciaTitulo;
    }

    public void setExperienciaTitulo(String experienciaTitulo) {
        this.experienciaTitulo = experienciaTitulo;
    }

    public String getEducacionTitulo() {
        return educacionTitulo;
    }

    public void setEducacionTitulo(String educacionTitulo) {
        this.educacionTitulo = educacionTitulo;
    }

    public String getHabilidadesTitulo() {
        return habilidadesTitulo;
    }

    public void setHabilidadesTitulo(String habilidadesTitulo) {
        this.habilidadesTitulo = habilidadesTitulo;
    }

    public String getProyectosTitulo() {
        return proyectosTitulo;
    }

    public void setProyectosTitulo(String proyectosTitulo) {
        this.proyectosTitulo = proyectosTitulo;
    }

    public String getFooterAutor() {
        return footerAutor;
    }

    public void setFooterAutor(String footerAutor) {
        this.footerAutor = footerAutor;
    }

    public String getFooterLocalidad() {
        return footerLocalidad;
    }

    public void setFooterLocalidad(String footerLocalidad) {
        this.footerLocalidad = footerLocalidad;
    }

    public int getPersonaActiva_id() {
        return personaActiva_id;
    }

    public void setPersonaActiva_id(int personaActiva_id) {
        this.personaActiva_id = personaActiva_id;
    }

}
