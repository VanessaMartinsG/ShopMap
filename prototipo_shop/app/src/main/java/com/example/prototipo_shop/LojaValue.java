package com.example.prototipo_shop;

import java.util.ArrayList;
import java.util.List;

public class LojaValue implements java.io.Serializable{

    private Integer id;
    private String nome;
    private  String Cupons;
    private boolean Fav;

    public LojaValue(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCupons() {
        return Cupons;
    }

    public void setCupons(String cupons) {
        Cupons = cupons;
    }

    public boolean isFav() {
        return Fav;
    }

    public void setFav(boolean fav) {
        Fav = fav;
    }

}
