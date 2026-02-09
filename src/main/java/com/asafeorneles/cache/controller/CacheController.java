package com.asafeorneles.cache.controller;

import com.asafeorneles.cache.service.CacheService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}