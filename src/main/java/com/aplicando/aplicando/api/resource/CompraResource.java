package com.aplicando.aplicando.api.resource;


import com.aplicando.aplicando.api.dto.CompraDTO;
import com.aplicando.aplicando.api.dto.UsuarioDTO;
import com.aplicando.aplicando.execpitons.ErroExcepiton;
import com.aplicando.aplicando.model.entity.Compra;
import com.aplicando.aplicando.model.entity.Item;
import com.aplicando.aplicando.model.entity.Usuario;
import com.aplicando.aplicando.repository.UsuarioRepository;
import com.aplicando.aplicando.service.CompraService;
import com.aplicando.aplicando.service.ItemService;
import com.aplicando.aplicando.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/compra")
@RequiredArgsConstructor
public class CompraResource {

    private final CompraService services;
    private final UsuarioService usuarioService;
    private final ItemService itemService;

    @PostMapping
    public ResponseEntity salvar(@RequestBody CompraDTO compraDTO){
        List<Item> items = new ArrayList<>();
        for (Long id : compraDTO.getItems()) {
            Optional<Item> item = itemService.buscarItemId(id);
            if (!item.isPresent()) {
                throw new RuntimeException("O item não existe");
            }
            items.add(item.get());
        }

        Usuario usuario = usuarioService.obterPorId(compraDTO.getId_usuario()).
        orElseThrow(() -> new RuntimeException("Usuario não encontrado pelo id inforado"));
        Compra compra = Compra.builder().ano(compraDTO.getAno()).descricao(compraDTO.getDescricao()).usuario(usuario).items(items).build();
        try{
            Compra resultado = services.salvarCompra(compra);
            return new ResponseEntity(resultado, HttpStatus.CREATED);

        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());

        }

    }

//    private Compra converte (CompraDTO compraDTO){
//        Compra compra = new Compra();
//        compra.setAno(compraDTO.getAno());
//        compra.setIdCompra(compraDTO.getIdCompra());
//        compra.setDescricao(compraDTO.getDescricao());
//
//        Usuario usuario = usuarioService.obterPorId(compraDTO.getId_usuario()).
//                orElseThrow(() -> new RuntimeException("Usuario não encontrado pelo id inforado"));
//
//        System.out.println("usuario");
//        compra.setUsuario(usuario);
//        return compra;
//
//
//    }




}
