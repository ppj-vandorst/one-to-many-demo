package com.example.demo2.repositories;

import com.example.demo2.model.ItemList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListRepository extends JpaRepository<ItemList, Long> {
}
