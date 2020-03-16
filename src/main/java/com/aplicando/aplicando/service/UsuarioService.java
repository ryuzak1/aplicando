package com.aplicando.aplicando.service;

import com.aplicando.aplicando.model.entity.Usuario;

import java.util.Optional;

public interface UsuarioService {

    Usuario salvar(Usuario usuario);

    Usuario autenticarUsuario(String email, String senha);

    Optional<Usuario> obterPorId(Long id);

    void deletar(Usuario usuario);

}
