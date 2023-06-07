package com.portfolio.BackEnd.Service;

import com.portfolio.BackEnd.Entity.Habilidades;
import com.portfolio.BackEnd.Interface.IHabilidadesService;
import com.portfolio.BackEnd.Repository.IHabilidadesRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpHabilidadesService implements IHabilidadesService {

    @Autowired
    public IHabilidadesRepository iHabilidadesRepository;
    
    @Override
    public List<Habilidades> getHab() {
        return iHabilidadesRepository.findAll();
    }

    @Override
    public Optional<Habilidades> getOneHab(int id) {
        return iHabilidadesRepository.findById(id);
    }

    @Override
    public Optional<Habilidades> getByNombreHab(String nombreHab) {
        return iHabilidadesRepository.findByNombreHab(nombreHab);
    }

    @Override
    public void saveHab(Habilidades hab) {
        iHabilidadesRepository.save(hab);
    }

    @Override
    public void deleteHab(int id) {
        iHabilidadesRepository.deleteById(id);
    }

    @Override
    public boolean existsById(int id) {
        return iHabilidadesRepository.existsById(id);
    }

    @Override
    public boolean existsByNombreHab(String nombreHab) {
        return iHabilidadesRepository.existsByNombreHab(nombreHab);
    }
    
}
