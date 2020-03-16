package com.aplicando.aplicando.api.resource;

import com.aplicando.aplicando.api.dto.ItemDTO;
import com.aplicando.aplicando.execpitons.ErroExcepiton;
import com.aplicando.aplicando.model.entity.Item;
import com.aplicando.aplicando.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/item")
@RequiredArgsConstructor
public class ItemResource {

    private final ItemService service;

    @PostMapping
    public ResponseEntity salvar(@RequestBody ItemDTO itemDTO){
        Item item = Item.builder().nome(itemDTO.getNome()).
                descricao(itemDTO.getDescricao()).
                valor(itemDTO.getValor()).build();
        try{
            Item retorno  = service.salvarItem(item);
            return new ResponseEntity(retorno, HttpStatus.CREATED);

        }catch (ErroExcepiton e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
    @DeleteMapping("{id}")
    public ResponseEntity deletar(@PathVariable("id") Long id){
        return service.buscarItemId(id).map(entidade->{
            service.deletarItem(entidade);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }).orElseGet(()->new ResponseEntity("Item não encontrado",HttpStatus.BAD_REQUEST));


    }



}
