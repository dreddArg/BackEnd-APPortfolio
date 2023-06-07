package com.portfolio.BackEnd.Interface;

import com.portfolio.BackEnd.Entity.Experiencia;
import java.util.List;
import java.util.Optional;

public interface IExperienciaService {
    
    public List<Experiencia> getExperiencia();
    
    public Optional<Experiencia> getOneExperiencia(int id);
    
    public Optional<Experiencia> getByNombreEmpresa(String nombreEmpresa);
    
    public void saveExperiencia(Experiencia experiencia);
    
    public void deleteExperiencia(int id);
    
    public boolean existsById(int id);
    
    public boolean existsByNombreEmpresa(String nombreEmpresa);
    
}
