package com.portfolio.BackEnd.Interface;

import com.portfolio.BackEnd.Entity.Habilidades;
import java.util.List;
import java.util.Optional;

public interface IHabilidadesService {
    
    public List<Habilidades> getHab();
    
    public Optional<Habilidades> getOneHab(int id);
    
    public Optional<Habilidades> getByNombreHab(String nombreHab);
    
    public void saveHab(Habilidades hab);
    
    public void deleteHab(int id);
    
    public boolean existsById(int id);
    
    public boolean existsByNombreHab(String nombreHab);
}
