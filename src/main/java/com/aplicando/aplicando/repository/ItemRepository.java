package com.aplicando.aplicando.repository;

import com.aplicando.aplicando.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {

}
