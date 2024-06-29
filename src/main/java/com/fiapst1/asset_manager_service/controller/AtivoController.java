package com.fiapst1.asset_manager_service.controller;

import com.fasterxml.jackson.core.util.RecyclerPool;
import com.fiapst1.asset_manager_service.domain.Ativo;
import com.fiapst1.asset_manager_service.dtos.AssetDto;
import com.fiapst1.asset_manager_service.service.AtivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AtivoController {

    @Autowired
    AtivoService ativoService;

    @RequestMapping(value = "/ativo/healthcheck", method = RequestMethod.GET)
    public ResponseEntity healthCheck(){
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @RequestMapping(value = "/ativo/{id}", method = RequestMethod.GET)
    public Optional<Ativo> findByAtivoId(@PathVariable Long id){
        return ativoService.getAtivoById(id);
    }

    @RequestMapping(value = "/ativo", method = RequestMethod.POST)
    public ResponseEntity save_asset(@RequestBody AssetDto data){
        Ativo resp = ativoService.save_asset(data);
        return new ResponseEntity<>(resp, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/ativo", method = RequestMethod.GET)
    public ResponseEntity getAllAssets(){
        Iterable<Ativo> ativos = ativoService.getAllAssets();
        return new ResponseEntity<>(ativos, HttpStatus.OK);
    }

    @RequestMapping(value = "/ativo/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteAsset(@PathVariable Long id){
        String resp = ativoService.deleteAsset(id);
        if ("deleted".equals(resp)) {
            return new ResponseEntity<>(resp, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/ativo", method = RequestMethod.PUT)
    public ResponseEntity updateAsset(@RequestBody AssetDto data){
        String resp = ativoService.updateAsset(data);
        if ("updated".equals(resp)){
            return new ResponseEntity<>(resp, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
        }
    }

}
