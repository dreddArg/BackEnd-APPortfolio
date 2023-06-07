package com.portfolio.BackEnd.Controller;

import com.portfolio.BackEnd.Dto.DtoExperiencia;
import com.portfolio.BackEnd.Entity.Experiencia;
import com.portfolio.BackEnd.Interface.IExperienciaService;
import com.portfolio.BackEnd.Security.Controller.Mensaje;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api/experiencia")

public class ExperienciaController {
    
    @Autowired IExperienciaService iExperienciaService;
    
    @GetMapping("/get")
    public ResponseEntity<List<Experiencia>> getExperiencia(){
        List<Experiencia> list = iExperienciaService.getExperiencia();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    //@GetMapping("/getexperiencia")
    //public List<Experiencia> getExperiencia(){
    //    return iExperienciaService.getExperiencia();
    //}

    @PostMapping("/save")
    public ResponseEntity<?> saveExperiencia(@RequestBody DtoExperiencia dtoexp){
        
        // validamos que el nombre de empresa no esté en blanco
        if (StringUtils.isBlank(dtoexp.getNombreEmpresa())){
            return new ResponseEntity(new Mensaje("El Nombre de Empresa es obligatorio."), HttpStatus.BAD_REQUEST);
        }
        // validamos que no exista el mismo nombre de empresa
        if (iExperienciaService.existsByNombreEmpresa(dtoexp.getNombreEmpresa())){
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe."), HttpStatus.BAD_REQUEST);
        }
        // pasamos datos del DTO a nuevo Objeto para grabarlo, respetar orden datos segun DTO
        Experiencia experienciaNueva = new Experiencia(dtoexp.getLogo(),
                                                     dtoexp.getNombreEmpresa(),
                                                     dtoexp.getFechaInicial(),
                                                     dtoexp.getFechaFinal(),
                                                     dtoexp.getDescripcion());
        iExperienciaService.saveExperiencia(experienciaNueva);
        
        return new ResponseEntity(new Mensaje("Experiencia creada"), HttpStatus.OK);
    }
    
    //@PostMapping("/saveexperiencia")
    //public void saveExperiencia(@RequestBody Experiencia experiencia){
    //    iExperienciaService.saveExperiencia(experiencia);
    //}

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateExperiencia(@PathVariable("id") int id, @RequestBody DtoExperiencia dtoexp){
        // Validamos si existe el Id pasado
        if (!iExperienciaService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        // Vemos si la experiencia ya existe en otro Id
        if (iExperienciaService.existsByNombreEmpresa(dtoexp.getNombreEmpresa()) && 
                iExperienciaService.getByNombreEmpresa(dtoexp.getNombreEmpresa()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Esa experiencia existe en otro registro"), HttpStatus.BAD_REQUEST);
        }
        // check si está en blanco el nombre
        if (StringUtils.isBlank(dtoexp.getNombreEmpresa())){
            return new ResponseEntity(new Mensaje("El Nombre no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }
        // armamos objeto con la informacion actual antes de actualizar
        Experiencia experienciaActualizada = iExperienciaService.getOneExperiencia(id).get();
        // asignamos datos del DTO al objeto a actualizar
        experienciaActualizada.setLogo(dtoexp.getLogo());
        experienciaActualizada.setNombreEmpresa(dtoexp.getNombreEmpresa());
        experienciaActualizada.setFechaInicial(dtoexp.getFechaInicial());
        experienciaActualizada.setFechaFinal(dtoexp.getFechaFinal());
        experienciaActualizada.setDescripcion(dtoexp.getDescripcion());
        // grabamos
        iExperienciaService.saveExperiencia(experienciaActualizada);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteExperiencia(@PathVariable("id") int id){
        // Validamos si existe el Id pasado
        if (!iExperienciaService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        iExperienciaService.deleteExperiencia(id);
        
        return new ResponseEntity(new Mensaje("Experiencia borrada"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        // Validamos si existe el Id pasado
        if (!iExperienciaService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        Experiencia expDetail = iExperienciaService.getOneExperiencia(id).get();
        return new ResponseEntity(expDetail, HttpStatus.OK);
        }
}
