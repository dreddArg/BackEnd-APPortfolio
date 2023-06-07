package com.portfolio.BackEnd.Dto;

import javax.validation.constraints.NotBlank;

public class DtoEducacion {
    @NotBlank
    private String nombreInstitucion;
    @NotBlank
    private String fecha;
    @NotBlank
    private String descripcion;
    
    //contructor
    public DtoEducacion() {
    }

    public DtoEducacion(String nombreInstitucion, String fecha, String descripcion) {
        this.nombreInstitucion = nombreInstitucion;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
    //getters setters

    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
