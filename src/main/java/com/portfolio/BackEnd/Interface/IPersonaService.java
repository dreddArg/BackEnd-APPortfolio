package com.portfolio.BackEnd.Interface;

import com.portfolio.BackEnd.Entity.Persona;
import java.util.List;

public interface IPersonaService {
    //Muestra lista de personas
    public List<Persona> getPersona();
    
    //Guarda objeeto de tipo Persona
    public void savePersona(Persona persona);
    
    //Eliminar objeto x ID
    public void deletePersona(Integer id);
    
    //Busca persona x ID
    public Persona findPersona(Integer id);
}
