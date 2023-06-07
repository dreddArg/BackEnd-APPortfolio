package com.portfolio.BackEnd.Repository;

import com.portfolio.BackEnd.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducacionRepository extends JpaRepository<Educacion, Integer>{
    
    public Optional<Educacion> findByNombreInstitucion(String nombreInstitucion);
    
    public boolean existsByNombreInstitucion(String nombreInstitucion);
}
