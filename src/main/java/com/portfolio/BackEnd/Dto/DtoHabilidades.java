package com.portfolio.BackEnd.Dto;

import javax.validation.constraints.NotBlank;

public class DtoHabilidades {
    @NotBlank
    private String nombreHab;
    @NotBlank
    private int porcentaje;
    
    //constructos

    public DtoHabilidades() {
    }

    public DtoHabilidades(String nombreHab, int porcentaje) {
        this.nombreHab = nombreHab;
        this.porcentaje = porcentaje;
    }
    //getters setters

    public String getNombreHab() {
        return nombreHab;
    }

    public void setNombreHab(String nombreHab) {
        this.nombreHab = nombreHab;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    
}
