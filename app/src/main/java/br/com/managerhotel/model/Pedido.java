package br.com.managerhotel.model;

import java.util.List;

/**
 * Created by Charlle Daniel on 01/05/2017.
 */
public class Pedido {
    private String flat;
    private String session;
    private List<Item> itens;

    public Pedido(String flat, String session, List<Item> itens) {
        this.flat = flat;
        this.session = session;
        this.itens = itens;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}
