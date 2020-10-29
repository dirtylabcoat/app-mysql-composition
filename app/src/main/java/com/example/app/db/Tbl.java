package com.example.app.db;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tbl {

    @Id
    private Long id;
    private String msg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
