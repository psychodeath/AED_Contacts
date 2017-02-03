package com.jm.coolcontacts.model;

import pt.ipleiria.estg.dei.colecoes.ComparacaoLimite;

/**
 * Created by joaomota on 03/02/2017.
 *
 * Define a condição limite para ordenação descendente de contactos por nome
 *
 */

public enum OrderDescName implements ComparacaoLimite<Contact>{
    INSTANCE;

    private static final Contact LIMITE = new Contact("",-1);

    @Override
    public int comparar(Contact o1, Contact o2) {
        return o2.getNome().compareToIgnoreCase(o1.getNome());
    }

    @Override
    public Contact getLimite() {
        return LIMITE;
    }

    @Override
    public boolean isElementoValido(Contact elem) {
        return (elem != null && comparar(elem, LIMITE) < 0);
    }

}
