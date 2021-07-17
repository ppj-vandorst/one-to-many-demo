package com.example.demo2.controllers.dto;

import com.example.demo2.model.Item;
import com.example.demo2.model.ItemList;

public class ItemDto {
    public long id;
    public String content;

    public static ItemDto fromItem(Item item) {
        var dto = new ItemDto();
        dto.id = item.getId();
        dto.content = item.getContent();
        return dto;
    }

    public static Item toItem(ItemDto dto, ItemList list) {
        var item = new Item();
        item.setId(dto.id);
        item.setContent(dto.content);

        // this is the important bit, Item owns the relation!!!
        item.setList(list);

        return item;
    }
}
