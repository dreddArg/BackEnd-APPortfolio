package com.portfolio.BackEnd.Interface;

import com.portfolio.BackEnd.Entity.DatosWeb;
import java.util.List;

public interface IDatosWebService {
    
    public DatosWeb getDatosWeb(Integer id);
    
    public void saveDatosWeb(DatosWeb datosWeb);
}
