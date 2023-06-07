package com.portfolio.BackEnd.Service;

import com.portfolio.BackEnd.Entity.Educacion;
import com.portfolio.BackEnd.Interface.IEducacionService;
import com.portfolio.BackEnd.Repository.IEducacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpEducacionService implements IEducacionService{
    
    @Autowired
    public IEducacionRepository iEducacionRepository;
    
    @Override
    public List<Educacion> getEducacion(){
        return iEducacionRepository.findAll();
    }
    
    @Override
    public Optional<Educacion> getOneEducacion(int id){
        return iEducacionRepository.findById(id);
    }
    
    @Override
    public Optional<Educacion> getByNombreInstitucion(String nombreI){
        return iEducacionRepository.findByNombreInstitucion(nombreI);
    }
    
    @Override
    public void saveEducacion(Educacion edu){
        iEducacionRepository.save(edu);
    }
    
    @Override
    public void deleteEducacion(int id){
        iEducacionRepository.deleteById(id);
    }
    
    @Override
    public boolean existsById(int id){
        return iEducacionRepository.existsById(id);
    }
    
    @Override
    public boolean existsByNombreInstitucion(String nombreI){
        return iEducacionRepository.existsByNombreInstitucion(nombreI);
    }
}
