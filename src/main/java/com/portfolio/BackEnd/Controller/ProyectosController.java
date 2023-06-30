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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/proyectos")

public class ProyectosController {

    @Autowired
    IProyectosService iProyectosService;
    
    @GetMapping("/get")
    public ResponseEntity<List<Proyectos>> getPro(){
        List<Proyectos> list = iProyectosService.getPro();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/save")
    public ResponseEntity<?> savePro(@RequestBody DtoProyectos dtopro) {
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
        if (iProyectosService.existsByNombrePro(dtopro.getNombreProyecto())){
            return new ResponseEntity(new Mensaje("El nombre de Proyecto ya existe"),HttpStatus.BAD_REQUEST);
        }
        //si no hubo errores pasamos datos del dto a objeto a grabar
        Proyectos proyectoNuevo = new Proyectos(dtopro.getUrlImg(),dtopro.getNombreProyecto(),dtopro.getDescripcion(),dtopro.getLink());
        iProyectosService.savePro(proyectoNuevo);
        return new ResponseEntity(new Mensaje("Proyecto guardado correctamente"),HttpStatus.OK);
    }
    
}
