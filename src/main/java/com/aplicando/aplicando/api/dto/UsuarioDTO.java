package com.aplicando.aplicando.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UsuarioDTO {
    private String nome;
    private String senha;
    private String email;
}
