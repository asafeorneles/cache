package com.asafeorneles.cache.service;

import com.asafeorneles.cache.entities.Empresa;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CacheService {

    final CacheManager cacheManager;
    final EmpresaService empresaService;

    public CacheService(CacheManager cacheManager, EmpresaService empresaService) {
        this.cacheManager = cacheManager;
        this.empresaService = empresaService;
    }

    public void evictAllCacheValues(String cacheName){
        Objects.requireNonNull(cacheManager.getCache(cacheName)).clear();
    }

    @CachePut("empresas")
    public List<Empresa> atualizarCacheEmpresas(){
        return empresaService.findAll();
    }

}