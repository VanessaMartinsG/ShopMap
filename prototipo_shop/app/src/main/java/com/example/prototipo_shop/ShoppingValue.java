package com.example.prototipo_shop;

import java.util.ArrayList;
import java.util.List;

public class ShoppingValue implements java.io.Serializable{

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id;
    private String nome;
    private List<LojaValue> lojas = new ArrayList<>();

    public String getFav() {
        return fav;
    }

    public void setFav(String fav) {
        this.fav = fav;
    }

    private String fav ;

    public ShoppingValue() {
    }





    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<LojaValue> getLojas() {
        return lojas;
    }

    public void setLojas(List<LojaValue> lojas) {
        this.lojas = lojas;
    }

}
