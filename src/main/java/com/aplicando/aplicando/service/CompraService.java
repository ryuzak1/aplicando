package com.aplicando.aplicando.service;

import com.aplicando.aplicando.model.entity.Compra;
import com.aplicando.aplicando.model.entity.Item;
import com.aplicando.aplicando.model.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface CompraService {

    Compra salvarCompra(Compra compra);
    Compra atualizarCompra(Compra compra);
    void deletarCompra(Compra compra);
    List<Compra> bucarCompra(Compra compraFiltro);
    Optional<Compra> buscarCompraId(Long id);
}
