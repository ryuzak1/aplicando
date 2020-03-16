package com.aplicando.aplicando.service.impl;

import com.aplicando.aplicando.model.entity.Compra;
import com.aplicando.aplicando.repository.CompraRepository;
import com.aplicando.aplicando.service.CompraService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CompraServiceImpl implements CompraService {

    private CompraRepository repository;

    public CompraServiceImpl(CompraRepository repository){

        this.repository = repository;
    }


    @Override
    @Transactional
    public Compra salvarCompra(Compra compra) {
        return repository.save(compra);
    }

    @Override
    @Transactional
    public Compra atualizarCompra(Compra compra) {
        Objects.requireNonNull(compra.getIdCompra());
        return repository.save(compra);
    }

    @Override
    @Transactional
    public void deletarCompra(Compra compra) {
        Objects.requireNonNull(compra.getIdCompra());
        repository.delete(compra);

    }

    @Override
    public List<Compra> bucarCompra(Compra compraFiltro) {
        Example example = Example.of(compraFiltro,
                ExampleMatcher.matching().
                        withIgnoreCase().
                        withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING));

        return repository.findAll(example);
    }

    @Override
    public Optional<Compra> buscarCompraId(Long id) {
        return repository.findById(id);
    }
}
