package com.portfolio.BackEnd.Service;

import com.portfolio.BackEnd.Entity.DatosWeb;
import com.portfolio.BackEnd.Interface.IDatosWebService;
import com.portfolio.BackEnd.Repository.IDatosWebRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpDatosWebService implements IDatosWebService {
    
    @Autowired
    public IDatosWebRepository iDatosWebRepository;

    @Override
    public DatosWeb getDatosWeb(Integer id) {
        return iDatosWebRepository.findById(id).orElse(null);
    }

    @Override
    public void saveDatosWeb(DatosWeb datosWeb) {
        iDatosWebRepository.save(datosWeb);
    }
    
}
