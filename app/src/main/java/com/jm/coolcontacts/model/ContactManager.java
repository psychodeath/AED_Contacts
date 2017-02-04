package com.jm.coolcontacts.model;

import pt.ipleiria.estg.dei.colecoes.ComparacaoLimite;
import pt.ipleiria.estg.dei.colecoes.ListaSimplesCircularBaseLimite;

/**
 * Created by joaomota on 03/02/2017.
 */

public enum ContactManager {
    INSTANCE;

    private ListaSimplesCircularBaseLimite<Contact> contactos;

    ContactManager(){
        contactos = new ListaSimplesCircularBaseLimite<Contact>(OrderDescName.INSTANCE);
    }

    public void add(Contact c){
        contactos.inserir(c);
    }

    public ListaSimplesCircularBaseLimite<Contact> getAllContactsByName(){
        return contactos;
    }


}
