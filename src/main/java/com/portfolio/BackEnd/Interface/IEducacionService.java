package com.portfolio.BackEnd.Interface;

import com.portfolio.BackEnd.Entity.Educacion;
import java.util.List;
import java.util.Optional;

public interface IEducacionService {
    
    public List<Educacion> getEducacion();
    
    public Optional<Educacion> getOneEducacion(int id);
    
    public Optional<Educacion> getByNombreInstitucion(String nombreInstitucion);
    
    public void saveEducacion(Educacion edu);
    
    public void deleteEducacion(int id);
    
    public boolean existsById(int id);
    
    public boolean existsByNombreInstitucion(String nombreInstitucion);
}
