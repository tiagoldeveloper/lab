package br.com.lab.domain.model;

import br.com.lab.types.TipoMenuItem;

import javax.persistence.*;

@Entity
@Table(name = "TB_MENU_ITEM")
@SequenceGenerator(name = "MENU_ITEM_SEQ", sequenceName = "MIT_SEQ", allocationSize = 2)
public class MenuItem extends LabBase{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MENU_ITEM_SEQ")
    @Column(name = "MIT_ID")
    private Long id;

    @Column(name = "MIT_NOME", length = 100)
    private String nome;

    @Column(name = "MIT_ICON", length = 100)
    private String icon;

    @Column(name = "MIT_LINK", length = 100)
    private String link;

    @ManyToOne(targetEntity = MenuItem.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "MIT_MITID")
    private MenuItem menuItem;

    @Column(name = "MIT_TIPO_MENU", length = 100)
    @Enumerated(EnumType.STRING)
    private TipoMenuItem tipoMenuItem;

    @ManyToOne(targetEntity = Permissao.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "MIT_PERID")
    private Permissao permissao;

    public MenuItem(){}

    public MenuItem(Long id, String nome, String icon, String link, MenuItem menuItem, TipoMenuItem tipoMenuItem) {
        this.id = id;
        this.nome = nome;
        this.icon = icon;
        this.link = link;
        this.menuItem = menuItem;
        this.tipoMenuItem = tipoMenuItem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public TipoMenuItem getTipoMenuItem() {
        return tipoMenuItem;
    }

    public void setTipoMenuItem(TipoMenuItem tipoMenuItem) {
        this.tipoMenuItem = tipoMenuItem;
    }
}
