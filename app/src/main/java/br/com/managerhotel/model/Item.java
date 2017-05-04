package br.com.managerhotel.model;

/**
 * Created by Charlle Daniel on 01/05/2017.
 */
public class Item {
    private String name;
    private int qtd;
    private float value;
    private boolean isSelected;
    private boolean enableSelected;

    public Item(String name, int qtd, float value) {
        this.name = name;
        this.qtd = qtd;
        this.value = value;
        this.isSelected = false;
        this.enableSelected = true;
    }
    public Item(String name, boolean enableSelected) {
        this.name = name;
        this.isSelected = enableSelected;
    }

    public boolean isEnableSelected() {
        return enableSelected;
    }

    public void setEnableSelected(boolean enableSelected) {
        this.enableSelected = enableSelected;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
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
