package com.asafeorneles.cache.controller;

import com.asafeorneles.cache.entities.Empresa;
import com.asafeorneles.cache.service.EmpresaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    final
    EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping
    public ResponseEntity<List<Empresa>> findAll(){
        List<Empresa> all = empresaService.findAllComCache();
        return ResponseEntity.ok(all);
    }
}
