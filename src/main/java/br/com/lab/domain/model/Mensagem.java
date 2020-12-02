package br.com.lab.domain.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_MENSAGEM")
@SequenceGenerator(name = "mensagem_seq", sequenceName = "men_seq", initialValue = 1, allocationSize = 2)
public class Mensagem extends LabBase{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mensagem_seq")
    @Column(name = "MEN_ID")
    private Long id;

    @Column(name = "MEN_CHAVE", length = 100)
    private String chave;

    @Column(name = "MEN_VALOR", length = 255)
    private String valor;

    public Mensagem() {}

    public Mensagem(Integer ativo, Date dataUltAlteracao, Integer versao, Long id, String chave, String valor) {
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
