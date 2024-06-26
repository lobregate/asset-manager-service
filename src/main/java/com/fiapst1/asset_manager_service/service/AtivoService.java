package com.fiapst1.asset_manager_service.service;

import com.fiapst1.asset_manager_service.domain.Ativo;
import com.fiapst1.asset_manager_service.repository.AtivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AtivoService {
    @Autowired
    AtivoRepository ativoRepository;

    public Optional<Ativo> getUsuarioById(Long id) {
        return ativoRepository.findById(id);
    }
}
