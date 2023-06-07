package com.portfolio.BackEnd.Interface;

import com.portfolio.BackEnd.Entity.RedesSociales;
import java.util.List;

public interface IRedesSocialesService {
    
    public List<RedesSociales> getRedesSociales();
    
    public void saveRedesSociales(RedesSociales redesSociales);
    
    public void deleteRedesSociales(int id);
    
}
