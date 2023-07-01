package com.portfolio.BackEnd.Controller;

import com.portfolio.BackEnd.Dto.DtoProyectos;
import com.portfolio.BackEnd.Entity.Proyectos;
import com.portfolio.BackEnd.Interface.IProyectosService;
import com.portfolio.BackEnd.Security.Controller.Mensaje;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/proyectos")

public class ProyectosController {

    @Autowired IProyectosService iProyectosService;
    
    @GetMapping("/get")
    public ResponseEntity<List<Proyectos>> getProyectos(){
        List<Proyectos> list = iProyectosService.getProyectos();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/save")
    public ResponseEntity<?> saveProyecto(@RequestBody DtoProyectos dtopro) {
        //revisamos q no tenga valores en blanco
        if (StringUtils.isBlank(dtopro.getUrlImg())){
            return new ResponseEntity(new Mensaje("La URL de imagen no puede estar vacía"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtopro.getNombreProyecto())){
            return new ResponseEntity(new Mensaje("El nombre del proyecto no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtopro.getDescripcion())){
            return new ResponseEntity(new Mensaje("La descripción no puede estar vacía"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtopro.getLink())){
            return new ResponseEntity(new Mensaje("El link URL no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }
        //vemos q no se repita el nombre de proyecto
        if (iProyectosService.existsByNombreProyecto(dtopro.getNombreProyecto())){
            return new ResponseEntity(new Mensaje("El nombre de Proyecto ya existe"),HttpStatus.BAD_REQUEST);
        }
        //si no hubo errores pasamos datos del dto a objeto a grabar
        Proyectos proyectoNuevo = new Proyectos(dtopro.getUrlImg(),dtopro.getNombreProyecto(),dtopro.getDescripcion(),dtopro.getLink());
        iProyectosService.saveProyecto(proyectoNuevo);
        return new ResponseEntity(new Mensaje("Proyecto guardado correctamente"),HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProyecto(@PathVariable("id") int id, @RequestBody DtoProyectos dtopro){
        // check del id en path
        if (!iProyectosService.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        // revisamos q el nombre del proyecto no exista en otro registro
        if (iProyectosService.existsByNombreProyecto(dtopro.getNombreProyecto()) &&
                iProyectosService.getByNombreProyecto(dtopro.getNombreProyecto()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre de proyecto existe en otro registro"), HttpStatus.BAD_REQUEST);
        }
        // revisamos no tener campos vacios
        if (StringUtils.isBlank(dtopro.getUrlImg())){
            return new ResponseEntity(new Mensaje("La Url de imagen no puede estar vacia"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtopro.getNombreProyecto())){
            return new ResponseEntity(new Mensaje("El nombre del proyecto no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtopro.getDescripcion())){
            return new ResponseEntity(new Mensaje("La descripcion no puede estar vacia"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtopro.getLink())){
            return new ResponseEntity(new Mensaje("El enlade de Url no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        // armamos objeto con la info actual previo a modificar
        Proyectos proyectoActualizado = iProyectosService.getOneProyecto(id).get();
        // asignamos datos del DTO al objeto a actualizar
        proyectoActualizado.setUrlImg(dtopro.getUrlImg());
        proyectoActualizado.setNombreProyecto(dtopro.getNombreProyecto());
        proyectoActualizado.setDescripcion(dtopro.getDescripcion());
        proyectoActualizado.setLink(dtopro.getLink());
        // grabamos
        iProyectosService.saveProyecto(proyectoActualizado);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProyecto(@PathVariable("id") int id){
        // validamos si existe el id en path
        if (!iProyectosService.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        // si no hay error borramos
        iProyectosService.deleteProyecto(id);
        return new ResponseEntity(new Mensaje("Proyecto Eliminado"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id){
        // validamos si existe el id en path
        if (!iProyectosService.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        Proyectos proDetail = iProyectosService.getOneProyecto(id).get();
        return new ResponseEntity(proDetail, HttpStatus.OK);
    }
}
