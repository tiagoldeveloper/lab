package br.com.lab.domain.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_MENSAGEM")
@SequenceGenerator(name = "mensagem_seq", sequenceName = "men_seq", allocationSize = 2)
public class Mensagem extends LabBase{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mensagem_seq")
    @Column(name = "MEN_ID")
    private Long id;

    @Column(name = "MEN_CHAVE")
    private String chave;

    @Column(name = "MEN_VALOR")
    private String valor;

    public Mensagem() {}

    public Mensagem(Long id, String chave, String valor) {
        super();
        this.id = id;
        this.chave = chave;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}