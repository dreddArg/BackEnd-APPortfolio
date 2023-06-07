package com.portfolio.BackEnd.Repository;

import com.portfolio.BackEnd.Entity.DatosWeb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDatosWebRepository extends JpaRepository<DatosWeb, Integer> {
    
}
