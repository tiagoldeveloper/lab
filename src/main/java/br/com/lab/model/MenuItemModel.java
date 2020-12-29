package br.com.lab.model;

import br.com.lab.types.TipoMenuItem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MenuItemModel {

    @JsonProperty("label")
    private String nome;

    @JsonProperty("icon")
    private String icon;

    @JsonProperty("routerLink")
    private String link;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("items")
    private List<MenuItemModel> itemMenu;

    @JsonIgnore
    private Long id;

    @JsonIgnore
    private TipoMenuItem tipoMenuItem;

    @JsonIgnore
    private Long menuItemId;

    public MenuItemModel(){}

    public MenuItemModel(String nome, String icon, String link, Long id, TipoMenuItem tipoMenuItem, Long menuItemId) {
        this.nome = nome;
        this.icon = icon;
        this.link = link;
        this.id = id;
        this.tipoMenuItem = tipoMenuItem;
        this.menuItemId = menuItemId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoMenuItem getTipoMenuItem() {
        return tipoMenuItem;
    }

    public void setTipoMenuItem(TipoMenuItem tipoMenuItem) {
        this.tipoMenuItem = tipoMenuItem;
    }

    public Long getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(Long menuItemId) {
        this.menuItemId = menuItemId;
    }

    public List<MenuItemModel> getItemMenu() {
        return itemMenu;
    }

    public void setItemMenu(List<MenuItemModel> itemMenu) {
        this.itemMenu = itemMenu;
    }
}