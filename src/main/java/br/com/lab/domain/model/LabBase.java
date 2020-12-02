package br.com.lab.domain.model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@MappedSuperclass
public class LabBase {

    @Column(name = "ATIVO")
    private Integer ativo = 1;

    @Column(name = "DATA_ULT_ALTERACAO")
    @Temporal(TemporalType.DATE)
    private Date dataUltAlteracao = Calendar.getInstance().getTime();

    @Version
    private Integer versao;

    public LabBase() {}

    public LabBase(Integer ativo, Date dataUltAlteracao, Integer versao) {
        this.ativo = ativo;
        this.dataUltAlteracao = dataUltAlteracao;
        this.versao = versao;
    }

    public Integer getAtivo() {
        return ativo;
    }

    public void setAtivo(Integer ativo) {
        this.ativo = ativo;
    }

    public Date getDataUltAlteracao() {
        return dataUltAlteracao;
    }

    public void setDataUltAlteracao(Date dataUltAlteracao) {
        this.dataUltAlteracao = dataUltAlteracao;
    }

    public Integer getVersao() {
        return versao;
    }

    public void setVersao(Integer versao) {
        this.versao = versao;
    }
}
