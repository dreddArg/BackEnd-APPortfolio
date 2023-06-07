package com.portfolio.BackEnd.Controller;

import com.portfolio.BackEnd.Entity.Persona;
import com.portfolio.BackEnd.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api/personas")

public class PersonaController {
    @Autowired IPersonaService ipersonaServ;
    
    @GetMapping("/get/{id}")
    public Persona datosPersona(@PathVariable Integer id){
       // persona = ;
        return ipersonaServ.findPersona(id);
    }
    
    @GetMapping("/lista")
    public List<Persona> getPersona(){
        return ipersonaServ.getPersona();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public String savePersona(@RequestBody Persona persona){
        ipersonaServ.savePersona(persona);
        return "Persona creada.";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public String deletePersona(@PathVariable Integer id){
        ipersonaServ.deletePersona(id);
        return "Persona borrada.";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public String editPersona(@PathVariable Integer id,
                              @RequestParam("nombre") String newnombre,
                              @RequestParam("bio") String newbio,
                              @RequestParam("longbio") String newlongbio,
                              @RequestParam("fotoPerfilUrl") String newfotoPerfilUrl
                              ){
        Persona newpersona = ipersonaServ.findPersona(id);
        newpersona.setNombre(newnombre);
        newpersona.setBio(newbio);
        newpersona.setLongBio(newlongbio);
        newpersona.setFotoPerfilUrl(newfotoPerfilUrl);
        
        ipersonaServ.savePersona(newpersona);
        
        return "Persona modificada.";
    }
    
}
