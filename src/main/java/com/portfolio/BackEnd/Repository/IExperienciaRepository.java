package com.portfolio.BackEnd.Repository;

import com.portfolio.BackEnd.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaRepository extends JpaRepository<Experiencia, Integer> {
    
    public Optional<Experiencia> findByNombreEmpresa(String nombreEmpresa);
    
    public boolean existsByNombreEmpresa(String nombreEmpresa);
}
