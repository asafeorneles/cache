package com.asafeorneles.cache.service;

import com.asafeorneles.cache.entities.Empresa;
import com.asafeorneles.cache.repository.EmpresaRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    final
    EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository){
        this.empresaRepository = empresaRepository;
    }

    @Cacheable("empresas")
    public List<Empresa> findAll(){
        return empresaRepository.findAll();
    }
}
