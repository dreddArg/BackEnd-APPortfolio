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
    public List<Proyectos> getProyectos() {
        return iProyectosRepository.findAll();
    }

    @Override
    public Optional<Proyectos> getOneProyecto(int id) {
        return iProyectosRepository.findById(id);
    }

    @Override
    public Optional<Proyectos> getByNombreProyecto(String nombreProyecto) {
        return iProyectosRepository.findByNombreProyecto(nombreProyecto);
    }

    @Override
    public void saveProyecto(Proyectos proyecto) {
        iProyectosRepository.save(proyecto);
    }

    @Override
    public void deleteProyecto(int id) {
        iProyectosRepository.deleteById(id);
    }

    @Override
    public boolean existsById(int id) {
        return iProyectosRepository.existsById(id);
    }

    @Override
    public boolean existsByNombreProyecto(String nombreProyecto) {
        return iProyectosRepository.existsByNombreProyecto(nombreProyecto);
    }
    
}
