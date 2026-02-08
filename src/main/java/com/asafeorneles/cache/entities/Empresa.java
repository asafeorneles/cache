package com.asafeorneles.cache.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Empresa {

    @Id
    private Long id;

    private String nome;
}
