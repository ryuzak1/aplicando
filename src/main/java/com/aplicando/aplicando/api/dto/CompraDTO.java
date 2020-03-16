package com.aplicando.aplicando.api.dto;

import com.aplicando.aplicando.model.entity.Item;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Builder
@Data
public class CompraDTO {


    private Long idCompra;
    private String descricao;
    private Integer ano;
    private Long id_usuario;
    private List<Long>items;


}
