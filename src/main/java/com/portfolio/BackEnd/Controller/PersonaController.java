package com.portfolio.BackEnd.Controller;

import com.portfolio.BackEnd.Dto.DtoPersona;
import com.portfolio.BackEnd.Entity.Persona;
import com.portfolio.BackEnd.Interface.IPersonaService;
import com.portfolio.BackEnd.Security.Controller.Mensaje;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/personas")

public class PersonaController {
    @Autowired IPersonaService ipersonaServ;
    
    @GetMapping("/get/{id}")
    public ResponseEntity<Persona> datosPersona(@PathVariable int id){
        if(!ipersonaServ.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = ipersonaServ.findPersona(id);
        return new ResponseEntity(persona, HttpStatus.OK);
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
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePersona(@PathVariable("id") int id, @RequestBody DtoPersona dtoper){
        // Validamos si existe el Id pasado
        if (!ipersonaServ.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        // check si está en blanco algun dato
        if (StringUtils.isBlank(dtoper.getNombre())){
            return new ResponseEntity(new Mensaje("El Nombre no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoper.getBio())){
            return new ResponseEntity(new Mensaje("La Bio no puede estar vacía"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoper.getLongBio())){
            return new ResponseEntity(new Mensaje("La descripción no puede estar vacía"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoper.getFotoPerfilUrl())){
            return new ResponseEntity(new Mensaje("La imagen no puede estar vacía"), HttpStatus.BAD_REQUEST);
        }
        // armamos objeto con la informacion actual antes de actualizar
        Persona personaActualizada = ipersonaServ.findPersona(id);
        // asignamos datos del DTO al objeto a actualizar
        personaActualizada.setNombre(dtoper.getNombre());
        personaActualizada.setBio(dtoper.getBio());
        personaActualizada.setLongBio(dtoper.getLongBio());
        personaActualizada.setFotoPerfilUrl(dtoper.getFotoPerfilUrl());
        // grabamos
        ipersonaServ.savePersona(personaActualizada);
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }
    
}
