package com.portfolio.BackEnd.Service;

import com.portfolio.BackEnd.Entity.RedesSociales;
import com.portfolio.BackEnd.Interface.IRedesSocialesService;
import com.portfolio.BackEnd.Repository.IRedesSocialesRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpRedesSocialesService implements IRedesSocialesService {
    
    @Autowired
    public IRedesSocialesRepository iRedesSocialesRepository;

    @Override
    public List<RedesSociales> getRedesSociales() {
        return iRedesSocialesRepository.findAll();
    }

    @Override
    public void saveRedesSociales(RedesSociales redesSociales) {
        iRedesSocialesRepository.save(redesSociales);
    }
    
    @Override
    public void deleteRedesSociales(int id){
        iRedesSocialesRepository.deleteById(id);
    }
}
