package com.aplicando.aplicando.service.impl;

import com.aplicando.aplicando.model.entity.Item;
import com.aplicando.aplicando.repository.ItemRepository;
import com.aplicando.aplicando.service.ItemService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository repository;

    public ItemServiceImpl(ItemRepository repository){
        this.repository = repository;
    }


    @Override
    @Transactional
    public Item salvarItem(Item item) {

        return repository.save(item);
    }

    @Override
    public Item atualizarItem(Item item) {
        Objects.requireNonNull(item.getIdItem());
        return repository.save(item);
    }

    @Override
    @Transactional
    public void deletarItem(Item item) {

        Objects.requireNonNull(item);
        repository.delete(item);

    }

    @Override
    @Transactional(readOnly = true)
    public List<Item> buscarItem(Item filtroItem) {
        Example example = Example.of(filtroItem,
                ExampleMatcher.matching().
                        withIgnoreCase().
                        withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING));

        return repository.findAll(example);
    }

    @Override
    public Optional<Item> buscarItemId(Long id) {

        return repository.findById(id);
    }
}
