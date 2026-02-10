package com.asafeorneles.cache.controller;

import com.asafeorneles.cache.cloud.IbgeResponse;
import com.asafeorneles.cache.service.IbgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ibge")
public class IbgeController {

    private final IbgeService ibgeService;
    public IbgeController(IbgeService ibgeService) {
        this.ibgeService = ibgeService;
    }

    @GetMapping
    public ResponseEntity<List<IbgeResponse>> findAllCidades(@RequestParam String estado) {
        return ResponseEntity.ok(ibgeService.findAllCidades(estado));
    }
}
