package com.asafeorneles.cache.service;

import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CacheService {

    final CacheManager cacheManager;

    public CacheService(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public void evictAllCacheValues(String cacheName){
        Objects.requireNonNull(cacheManager.getCache(cacheName)).clear();
    }

}