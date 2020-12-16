package br.com.lab.domain.model;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Calendar;

@MappedSuperclass
public class LabBase {

    @Column(name = "ATIVO")
    private Integer ativo = 1;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_ULT_ALTERACAO")
    private Calendar dataUltAlteracao = Calendar.getInstance();

    @Version
    @Column(name = "VERSAO")
    private Integer versao;

    @Column(name = "USUARIO_ULT_ALTERACAO")
    private String usuarioUtilmaAlteracao;

    public LabBase() {
        setUsuarioSecurity();
    }

    public LabBase(Integer ativo, Calendar dataUltAlteracao, Integer versao, String usuarioUtilmaAlteracao) {
        this.ativo = ativo;
        this.dataUltAlteracao = dataUltAlteracao;
        this.versao = versao;
        this.usuarioUtilmaAlteracao = usuarioUtilmaAlteracao;
    }

    public Integer getAtivo() {
        return ativo;
    }

    public void setAtivo(Integer ativo) {
        this.ativo = ativo;
    }

    public Calendar getDataUltAlteracao() {
        return dataUltAlteracao;
    }

    public void setDataUltAlteracao(Calendar dataUltAlteracao) {
        this.dataUltAlteracao = dataUltAlteracao;
    }

    public Integer getVersao() {
        return versao;
    }

    public void setVersao(Integer versao) {
        this.versao = versao;
    }

    public String getUsuarioUtilmaAlteracao() {
       return usuarioUtilmaAlteracao;
    }

    public void setUsuarioUtilmaAlteracao(String usuarioUtilmaAlteracao) {
           this.usuarioUtilmaAlteracao = usuarioUtilmaAlteracao;
    }

    //TODO: colcoar em outra classe.
    private void setUsuarioSecurity(){
        if(SecurityContextHolder.getContext() !=null && SecurityContextHolder.getContext().getAuthentication() !=null &&
                SecurityContextHolder.getContext().getAuthentication().getPrincipal() !=null){
            UserDetails usuarioDetais = null;
            Object userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if(userDetails instanceof UserDetails){
                usuarioDetais = (UserDetails) userDetails;
            }
            if(usuarioDetais !=null){
                usuarioUtilmaAlteracao = usuarioDetais.getUsername();
            }
        }
    }

}