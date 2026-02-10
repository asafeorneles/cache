package com.asafeorneles.cache.service;

import com.asafeorneles.cache.cloud.Ibge;
import com.asafeorneles.cache.cloud.IbgeResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IbgeService {

    final private Ibge ibge;

    public IbgeService(Ibge ibge) {
        this.ibge = ibge;
    }


    @Cacheable(value = "estados", condition = "#estado.equalsIgnoreCase('SP')") // Vai deixar no cache, todos as cidades de MG
    public List<IbgeResponse> findAllCidades(String estado) {
        System.out.println("vai buscar no IBGE");
        return ibge.findAllCidades(estado);
    }
}
