package com.example.demo2.controllers.dto;

import com.example.demo2.model.ItemList;

import java.util.List;
import java.util.stream.Collectors;

public class ListDto {
    public long id;
    public String name;
    public List<ItemDto> items;

    public static ListDto fromItemList(ItemList list) {
        var dto = new ListDto();
        dto.id = list.getId();
        dto.name = list.getName();
        dto.items = list.getItems().stream().map(ItemDto::fromItem).collect(Collectors.toList());
        return dto;
    }

    public static ItemList toItemList(ListDto dto) {
        var list = new ItemList();
        list.setId(dto.id);
        list.setName(dto.name);
        list.setItems(dto.items.stream().map(itemDto -> ItemDto.toItem(itemDto, list)).collect(Collectors.toList()));

        return list;
    }
}

