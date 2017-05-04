package br.com.managerhotel.controller;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import br.com.managerhotel.R;
import br.com.managerhotel.model.GridMenuItem;
import br.com.managerhotel.model.Item;
import br.com.managerhotel.model.Pedido;

/**
 * Created by Charlle Daniel on 01/05/2017.
 */
public class SystemController {
    private List<GridMenuItem> menuItemList;
    private List<Item> menuAmenitiesList;
    private List<Pedido> pedidosList;
    private Context context;
    private List<Item> menuEnxovalList;
    private List<Item> menuLimpezaList;
    private List<Item> menuOutrosList;

    public SystemController(Context context){
        this.menuItemList = new ArrayList<>();
        this.menuAmenitiesList = new ArrayList<>();
        this.pedidosList = new ArrayList<>();
        this.menuEnxovalList = new ArrayList<>();
        this.menuLimpezaList = new ArrayList<>();
        this.menuOutrosList = new ArrayList<>();
        this.context = context;

    }

    public List<GridMenuItem> createMenuList(){

        String amenities = context.getString(R.string.menu_item_amenities);
        String enxoval = context.getString(R.string.menu_item_enxoval);
        String limpeza = context.getString(R.string.menu_item_limpeza);
        String outros = context.getString(R.string.menu_item_outros);

        menuItemList.add(new GridMenuItem(amenities, R.drawable.icon_amenties, "#99004C"));
        menuItemList.add(new GridMenuItem(enxoval, R.drawable.icon_enxoval, "#CCCC00"));
        menuItemList.add(new GridMenuItem(limpeza, R.drawable.icon_limpeza, "#CC6600"));
        menuItemList.add(new GridMenuItem(outros, R.drawable.icon_outros, "#990099"));

        return menuItemList;
    }

    public void createMenuAmenities(){
        menuAmenitiesList.clear();
        menuAmenitiesList.add(new Item("Sabonete",0, 0 ));
        menuAmenitiesList.add(new Item("Shampoo / Condicionador",0, 0 ));
        menuAmenitiesList.add(new Item("Touca de Banho",0, 0 ));
        menuAmenitiesList.add(new Item("Papel Higiênico",0, 0 ));
    }

    public List<GridMenuItem> getMenuItemList() {
        return menuItemList;
    }

    public List<Item> getMenuAmenitiesList() {
        return menuAmenitiesList;
    }

    public void enviarPedido(Pedido pedido) {
        pedidosList.add(pedido);
    }
    public List<Pedido> getPedidosList(){
        return this.pedidosList;
    }

    public List<Item> getMenuEnxovalList() {
        return menuEnxovalList;
    }

    public void createMenuEnxoval(){
        menuEnxovalList.clear();
        menuEnxovalList.add(new Item("Toalha de Banho",0, 0 ));
        menuEnxovalList.add(new Item("Toalha de Piso",0, 0 ));
        menuEnxovalList.add(new Item("Toalha de Rosto",0, 0 ));
        menuEnxovalList.add(new Item("Lençol de Solteiro",0, 0 ));
        menuEnxovalList.add(new Item("Lençol de Casal",0, 0 ));
        menuEnxovalList.add(new Item("Travesseiro",0, 0 ));
    }

    public void createMenuLimpeza() {
        menuLimpezaList.clear();
        menuLimpezaList.add(new Item("Não pertube",0, 0 ));
        menuLimpezaList.add(new Item("Limpar Quarto",0, 0 ));
        menuLimpezaList.add(new Item("Limpar Banheiro",0, 0 ));
        menuLimpezaList.add(new Item("Limpar Ar-Codicionado",0, 0 ));

    }

    public List<Item> getMenuLimpezaList() {
        return menuLimpezaList;
    }

    public void createMenuOutros() {
        menuLimpezaList.clear();
        menuLimpezaList.add(new Item("Enviar Reclamação", false));
        menuLimpezaList.add(new Item("Enviar Sugestão", false));
        menuLimpezaList.add(new Item("Enviar Elogio",false));

    }

    public List<Item> getMenuOutrosList() {
        return menuLimpezaList;
    }
}
