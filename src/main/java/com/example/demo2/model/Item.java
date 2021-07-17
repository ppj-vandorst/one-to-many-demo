package com.example.demo2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Item {

    @Id
    @GeneratedValue
    Long id;

    String content;

    @ManyToOne
    ItemList list;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ItemList getList() {
        return list;
    }

    public void setList(ItemList list) {
        this.list = list;
    }
}
