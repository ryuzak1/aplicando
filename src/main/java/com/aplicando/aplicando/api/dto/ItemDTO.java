package com.aplicando.aplicando.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
public class ItemDTO {
    private String nome;
    private String descricao;
    private BigDecimal valor;
}
