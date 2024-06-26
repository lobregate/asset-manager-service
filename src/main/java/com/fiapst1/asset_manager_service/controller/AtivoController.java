package com.fiapst1.asset_manager_service.controller;

import com.fiapst1.asset_manager_service.domain.Ativo;
import com.fiapst1.asset_manager_service.service.AtivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AtivoController {

    @Autowired
    AtivoService ativoService;

    @RequestMapping(value = "/ativo/healthcheck", method = RequestMethod.GET)
    public ResponseEntity healthCheck(){
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @RequestMapping(value = "/ativo/{id}/", method = RequestMethod.GET)
    public Optional<Ativo> findByAtivoId(@PathVariable Long id){
        return ativoService.getUsuarioById(id);
    }

}
