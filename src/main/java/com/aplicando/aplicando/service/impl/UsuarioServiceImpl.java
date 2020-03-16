package com.aplicando.aplicando.service.impl;

import com.aplicando.aplicando.execpitons.ErroExcepiton;
import com.aplicando.aplicando.model.entity.Usuario;
import com.aplicando.aplicando.repository.UsuarioRepository;
import com.aplicando.aplicando.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository repository;

    @Autowired
    public UsuarioServiceImpl (UsuarioRepository repository){
        super();
        this.repository = repository;
    }

    @Override
    @Transactional
    public Usuario salvar(Usuario usuario) {

        return repository.save(usuario);
    }

    @Override
    public Usuario autenticarUsuario(String email, String senha) {
        Optional<Usuario>usuario = repository.findByEmail(email);

        if(!usuario.isPresent()){
            throw new ErroExcepiton("Usuario não encontrado");
        }
        if(!usuario.get().getSenha().equals(senha)){
            throw new ErroExcepiton("Senha Incorreta");

        }

        return usuario.get();
    }

    @Override
    public Optional<Usuario> obterPorId(Long id) {

        return repository.findById(id);
    }

    @Override
    public void deletar(Usuario usuario) {
        Objects.requireNonNull(usuario);
        repository.delete(usuario);

    }
}
