package com.portfolio.BackEnd.Controller;

import com.portfolio.BackEnd.Entity.RedesSociales;
import com.portfolio.BackEnd.Interface.IRedesSocialesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api/redessociales")

public class RedesSocialesController {
    
    @Autowired IRedesSocialesService iRedesSocialesService;
    
    @GetMapping("/get")
    public List<RedesSociales> getRedesSociales(){
        return iRedesSocialesService.getRedesSociales();
    }
    
    @PostMapping("/save")
    public void saveRedesSociales(@RequestBody RedesSociales redesSociales){
        iRedesSocialesService.saveRedesSociales(redesSociales);
    }
    
}
