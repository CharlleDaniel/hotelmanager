package br.com.managerhotel.model;

/**
 * Created by Charlle Daniel on 01/05/2017.
 */
public class Item {
    private String name;
    private int qtd;
    private float value;

    public Item(String name, int qtd, float value) {
        this.name = name;
        this.qtd = qtd;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public float getValue() {
        return value;
    }


    public void setValue(float value) {
        this.value = value;
    }
}
