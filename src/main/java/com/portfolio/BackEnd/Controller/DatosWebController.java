package com.portfolio.BackEnd.Controller;

import com.portfolio.BackEnd.Entity.DatosWeb;
import com.portfolio.BackEnd.Interface.IDatosWebService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api/datosweb")

public class DatosWebController {
    @Autowired IDatosWebService iDatosWebService;
    
    @GetMapping("/get/{id}")
    private DatosWeb getDatosWeb(@PathVariable Integer id){
        return iDatosWebService.getDatosWeb(id);
    }
    
    @PostMapping("/save")
    private void saveDatosWeb(@RequestBody DatosWeb datosWeb){
        iDatosWebService.saveDatosWeb(datosWeb);
    }
}
