package com.asafeorneles.cache.service;

import com.asafeorneles.cache.entities.Empresa;
import com.asafeorneles.cache.repository.EmpresaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EmpresaService {

    final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository){
        this.empresaRepository = empresaRepository;
    }

    @Cacheable("empresas")
    public List<Empresa> findAllComCache(){
        return findAll();
    }

    public List<Empresa> findAll(){
        log.info("Foi buscar empresas no banco");
        return empresaRepository.findAll();
    }
}
