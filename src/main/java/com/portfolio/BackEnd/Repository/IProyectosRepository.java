package com.portfolio.BackEnd.Repository;

import com.portfolio.BackEnd.Entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectosRepository extends JpaRepository<Proyectos, Integer>{
    
    public Optional<Proyectos> findByNombrePro(String nombrePro);
    
    public boolean existsByNombrePro(String nombrePro);
    
}
