package com.example.demo2.controllers;

import com.example.demo2.controllers.dto.ListDto;
import com.example.demo2.exceptions.NotFoundException;
import com.example.demo2.model.Item;
import com.example.demo2.model.ItemList;
import com.example.demo2.repositories.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("list")
public class ItemListController {
    private ListRepository repository;

    @Autowired
    public ItemListController(ListRepository repository) {
        this.repository = repository;
    }

    @GetMapping("{id}")
    public ListDto getList(@PathVariable long id) {
        var optionalList = repository.findById(id);

        if (optionalList.isPresent()) {
            return ListDto.fromItemList(optionalList.get());
        } else {
            throw new NotFoundException();
        }
    }

    @PostMapping
    public ListDto createList(@RequestBody ListDto listDto) {
        var itemList = ListDto.toItemList(listDto);
        var savedList = this.repository.save(itemList);
        return ListDto.fromItemList(savedList);
    }
}
