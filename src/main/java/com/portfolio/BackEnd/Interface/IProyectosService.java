package com.portfolio.BackEnd.Interface;

import com.portfolio.BackEnd.Entity.Proyectos;
import java.util.List;
import java.util.Optional;

public interface IProyectosService {
    
    public List<Proyectos> getPro();
    
    public Optional<Proyectos> getOnePro(int id);
    
    public Optional<Proyectos> getByNombrePro(String nombrePro);
    
    public void savePro(Proyectos pro);
    
    public void deletePro(int id);
    
    public boolean existsById(int id);
    
    public boolean existsByNombrePro(String nombrePro);
    
}
