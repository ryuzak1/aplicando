package com.aplicando.aplicando.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "item",schema = "public")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idItem;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descircao")
    private String descricao;

    @Column(name = "valor")
    private BigDecimal valor;
}
