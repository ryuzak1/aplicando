package com.aplicando.aplicando.service;

import com.aplicando.aplicando.model.entity.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    Item salvarItem(Item item);
    Item atualizarItem(Item item);
    void deletarItem(Item item);
    List<Item> buscarItem(Item filtroItem);
    Optional<Item> buscarItemId(Long id);

}
