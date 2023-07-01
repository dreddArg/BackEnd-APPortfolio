package com.portfolio.BackEnd.Interface;

import com.portfolio.BackEnd.Entity.Proyectos;
import java.util.List;
import java.util.Optional;

public interface IProyectosService {
    
    public List<Proyectos> getProyectos();
    
    public Optional<Proyectos> getOneProyecto(int id);
    
    public Optional<Proyectos> getByNombreProyecto(String nombreProyecto);
    
    public void saveProyecto(Proyectos proyecto);
    
    public void deleteProyecto(int id);
    
    public boolean existsById(int id);
    
    public boolean existsByNombreProyecto(String nombreProyecto);
    
}
