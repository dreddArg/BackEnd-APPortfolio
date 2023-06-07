package com.portfolio.BackEnd.Repository;

import com.portfolio.BackEnd.Entity.RedesSociales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRedesSocialesRepository extends JpaRepository<RedesSociales, Integer> {
    
}
