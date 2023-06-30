package com.portfolio.BackEnd.Service;

import com.portfolio.BackEnd.Entity.Proyectos;
import com.portfolio.BackEnd.Interface.IProyectosService;
import com.portfolio.BackEnd.Repository.IProyectosRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpProyectosService implements IProyectosService {

    @Autowired
    public IProyectosRepository iProyectosRepository;
    
    @Override
    public List<Proyectos> getPro() {
        return iProyectosRepository.findAll();
    }

    @Override
    public Optional<Proyectos> getOnePro(int id) {
        return iProyectosRepository.findById(id);
    }

    @Override
    public Optional<Proyectos> getByNombrePro(String nombrePro) {
        return iProyectosRepository.findByNombrePro(nombrePro);
    }

    @Override
    public void savePro(Proyectos pro) {
        iProyectosRepository.save(pro);
    }

    @Override
    public void deletePro(int id) {
        iProyectosRepository.deleteById(id);
    }

    @Override
    public boolean existsById(int id) {
        return iProyectosRepository.existsById(id);
    }

    @Override
    public boolean existsByNombrePro(String nombrePro) {
        return iProyectosRepository.existsByNombrePro(nombrePro);
    }
    
}
