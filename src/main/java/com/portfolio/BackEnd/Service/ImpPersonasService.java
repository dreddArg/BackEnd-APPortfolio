package com.portfolio.BackEnd.Service;

import com.portfolio.BackEnd.Entity.Persona;
import com.portfolio.BackEnd.Interface.IPersonaService;
import com.portfolio.BackEnd.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpPersonasService implements IPersonaService {
    
    @Autowired
    public IPersonaRepository ipersonaRepository;

    @Override
    public List<Persona> getPersona() {
        return ipersonaRepository.findAll();
    }

    @Override
    public void savePersona(Persona persona) {
        ipersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(int id) {
        ipersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(int id) {
        return ipersonaRepository.findById(id).orElse(null);
    }
    
    @Override
    public boolean existsById(int id) {
        return ipersonaRepository.existsById(id);
    }
    
    @Override
    public boolean existsByNombre(String nombre) {
        return ipersonaRepository.existsByNombre(nombre);
    }
}
