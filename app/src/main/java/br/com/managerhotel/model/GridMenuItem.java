package br.com.managerhotel.model;

/**
 * Created by Charlle Daniel on 30/04/2017.
 */


public class GridMenuItem {
    private String label;
    private int idIcon;
    private String color;


    public GridMenuItem(String label, int idIcon, String color) {
        this.label = label;
        this.idIcon = idIcon;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getIdIcon() {
        return idIcon;
    }

    public void setIdIcon(int idIcon) {
        this.idIcon = idIcon;
    }
}
