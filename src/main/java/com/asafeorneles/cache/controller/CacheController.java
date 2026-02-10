package com.asafeorneles.cache.controller;

import com.asafeorneles.cache.entities.Empresa;
import com.asafeorneles.cache.service.CacheService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cache")
public class CacheController {

    final CacheService cacheService;

    public CacheController(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @PostMapping
    public void clear (@RequestParam String cacheName){
        cacheService.evictAllCacheValues(cacheName);
    }

    @PutMapping
    public List<Empresa> atualizarCacheDeEmpresas(){
        return cacheService.atualizarCacheEmpresas();
    }
}