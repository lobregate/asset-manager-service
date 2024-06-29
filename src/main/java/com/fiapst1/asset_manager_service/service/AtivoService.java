package com.fiapst1.asset_manager_service.service;

import com.fiapst1.asset_manager_service.domain.Ativo;
import com.fiapst1.asset_manager_service.dtos.AssetDto;
import com.fiapst1.asset_manager_service.repository.AtivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AtivoService {
    @Autowired
    AtivoRepository ativoRepository;

    public Optional<Ativo> getAtivoById(Long id) {
        return ativoRepository.findById(id);
    }

    public Ativo save_asset(AssetDto data){
        Ativo ativo = new Ativo();
        ativo.setNome(data.getNome());
        ativo.setStatus(data.getStatus());
        ativoRepository.save(ativo);
        return ativo;
    }

    public Iterable<Ativo> getAllAssets(){
        Iterable<Ativo> ativos = ativoRepository.findAll();
        return ativos;
    }

    public String updateAsset(AssetDto data){
        Optional<Ativo> optionalFoundAsset = ativoRepository.findById(data.getId());
        if (optionalFoundAsset.isPresent()){
            Ativo foundAsset = optionalFoundAsset.get();
            foundAsset.setNome(data.getNome());
            foundAsset.setStatus(data.getStatus());
            ativoRepository.save(foundAsset);
            return "Updated";
        } else {
            return "Asset not found";
        }

    }

    public String deleteAsset(Long id){
        Optional<Ativo> optionalAsset = ativoRepository.findById(id);
        if (optionalAsset.isPresent()){
            Ativo asset = optionalAsset.get();
            ativoRepository.delete(asset);
            return "deleted";
        }else {
            return "Asset not found";
        }
    }
}
