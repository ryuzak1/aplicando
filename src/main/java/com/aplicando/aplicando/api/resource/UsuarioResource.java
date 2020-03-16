package com.aplicando.aplicando.api.resource;

import com.aplicando.aplicando.api.dto.UsuarioDTO;
import com.aplicando.aplicando.execpitons.ErroExcepiton;
import com.aplicando.aplicando.model.entity.Usuario;
import com.aplicando.aplicando.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
@RequiredArgsConstructor
public class UsuarioResource {
    private final UsuarioService service;

    @PostMapping
    public ResponseEntity salvar(@RequestBody UsuarioDTO usuarioDTO){
        Usuario usuario = Usuario.builder()
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha()).build();
        try{
            Usuario resultado = service.salvar(usuario);
            return new ResponseEntity(resultado, HttpStatus.CREATED);

        }catch (ErroExcepiton e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
    @DeleteMapping("{id}")
    public ResponseEntity deletar(@PathVariable("id") Long id){
        return service.obterPorId(id).map(entidade->{
            service.deletar(entidade);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }).orElseGet(()->new ResponseEntity("Lançamento",HttpStatus.BAD_REQUEST));

    }
}
