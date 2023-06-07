package com.portfolio.BackEnd.Dto;

import javax.validation.constraints.NotBlank;

public class DtoExperiencia {
    @NotBlank
    private String logo;
    @NotBlank
    private String nombreEmpresa;
    @NotBlank
    private String fechaInicial;
    @NotBlank
    private String fechaFinal;
    @NotBlank
    private String descripcion;
    
    //constructors
    public DtoExperiencia() {
    }

    public DtoExperiencia(String logo, String nombreEmpresa, String fechaInicial, String fechaFinal, String descripcion) {
        this.logo = logo;
        this.nombreEmpresa = nombreEmpresa;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.descripcion = descripcion;
    }
    
    //getters setters

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(String fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
