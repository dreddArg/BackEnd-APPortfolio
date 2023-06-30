package com.portfolio.BackEnd.Dto;

import javax.validation.constraints.NotBlank;

public class DtoProyectos {
    @NotBlank
    private String urlImg;
    @NotBlank
    private String nombreProyecto;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String link;

    //contructor
    public DtoProyectos() {
    }

    public DtoProyectos(String urlImg, String nombreProyecto, String descripcion, String link) {
        this.urlImg = urlImg;
        this.nombreProyecto = nombreProyecto;
        this.descripcion = descripcion;
        this.link = link;
    }

    //getters setters
    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
}
