package com.stocksellproduct.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String categoria;
    private String marca;
    private double precoVenda;
    private double precoCusto;
    private int estoqueAtual;
    private LocalDate dataCriacao;

}
