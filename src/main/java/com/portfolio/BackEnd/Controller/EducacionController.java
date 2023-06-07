package com.portfolio.BackEnd.Controller;

import com.portfolio.BackEnd.Dto.DtoEducacion;
import com.portfolio.BackEnd.Entity.Educacion;
import com.portfolio.BackEnd.Interface.IEducacionService;
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
@RequestMapping("/api/educacion")

public class EducacionController {
    
    @Autowired IEducacionService iEducacionService;
    
    @GetMapping("/get")
    public ResponseEntity<List<Educacion>> getEducacion(){
        List<Educacion> list = iEducacionService.getEducacion();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/save")
    public ResponseEntity<?> saveEducacion(@RequestBody DtoEducacion dtoedu){
        
        // validamos que el nombre de institucion no esté en blanco
        if (StringUtils.isBlank(dtoedu.getNombreInstitucion())){
            return new ResponseEntity(new Mensaje("El Nombre de Institucion es obligatorio."), HttpStatus.BAD_REQUEST);
        }
        // validamos que no exista el mismo nombre de institucion
        if (iEducacionService.existsByNombreInstitucion(dtoedu.getNombreInstitucion())){
            return new ResponseEntity(new Mensaje("Esa Institucion ya existe."), HttpStatus.BAD_REQUEST);
        }
        // pasamos datos del DTO a nuevo Objeto para grabarlo, respetar orden datos segun DTO
        Educacion educacionNueva = new Educacion(dtoedu.getNombreInstitucion(),
                                                     dtoedu.getFecha(),
                                                     dtoedu.getDescripcion());
        iEducacionService.saveEducacion(educacionNueva);
        
        return new ResponseEntity(new Mensaje("Registro de Educacion creada"), HttpStatus.OK);
    }
    
    //@PostMapping("/saveexperiencia")
    //public void saveExperiencia(@RequestBody Experiencia experiencia){
    //    iExperienciaService.saveExperiencia(experiencia);
    //}

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEducacion(@PathVariable("id") int id, @RequestBody DtoEducacion dtoedu){
        // Validamos si existe el Id pasado
        if (!iEducacionService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        // Vemos si la experiencia ya existe en otro Id
        if (iEducacionService.existsByNombreInstitucion(dtoedu.getNombreInstitucion()) && 
                iEducacionService.getByNombreInstitucion(dtoedu.getNombreInstitucion()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Esa Institucion ya existe en otro registro"), HttpStatus.BAD_REQUEST);
        }
        // check si está en blanco el nombre
        if (StringUtils.isBlank(dtoedu.getNombreInstitucion())){
            return new ResponseEntity(new Mensaje("El Nombre de Institucion no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }
        // armamos objeto con la informacion actual antes de actualizar
        Educacion educacionActualizada = iEducacionService.getOneEducacion(id).get();
        // asignamos datos del DTO al objeto a actualizar
        educacionActualizada.setNombreInstitucion(dtoedu.getNombreInstitucion());
        educacionActualizada.setFecha(dtoedu.getFecha());
        educacionActualizada.setDescripcion(dtoedu.getDescripcion());
        // grabamos
        iEducacionService.saveEducacion(educacionActualizada);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEducacion(@PathVariable("id") int id){
        // Validamos si existe el Id pasado
        if (!iEducacionService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        iEducacionService.deleteEducacion(id);
        
        return new ResponseEntity(new Mensaje("Educacion borrada"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        // Validamos si existe el Id pasado
        if (!iEducacionService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        Educacion eduDetail = iEducacionService.getOneEducacion(id).get();
        return new ResponseEntity(eduDetail, HttpStatus.OK);
        }
}
