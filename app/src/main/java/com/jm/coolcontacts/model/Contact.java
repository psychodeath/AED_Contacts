package com.jm.coolcontacts.model;

/**
 * Created by joaomota on 02/02/2017.
 */

public class Contact {
    private String nome;
    private long id;

    public Contact(String nome, long id){
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
