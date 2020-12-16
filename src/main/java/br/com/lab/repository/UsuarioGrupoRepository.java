package br.com.lab.repository;

import br.com.lab.domain.model.Grupo;
import br.com.lab.domain.model.Usuario;
import br.com.lab.model.*;
import org.springframework.stereotype.Repository;
import javax.persistence.criteria.Join;
import java.util.List;
import static br.com.lab.util.LabConstantes.*;

@Repository
public class UsuarioGrupoRepository extends LabRepository{

    public List<UsuarioGrupoModel> recuperaGruposPorUsuario(Long usuarioId){
        var criteriaBuilder = getManager().getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(UsuarioGrupoModel.class);
        var root = criteriaQuery.from(Usuario.class);
        Join<Usuario, Grupo> usuarioGrupoJoin = root.join("grupos");
        criteriaQuery.select(criteriaBuilder.construct(UsuarioGrupoModel.class, usuarioGrupoJoin.get("id"), usuarioGrupoJoin.get("nome")));
        var parametroAtivo = criteriaBuilder.parameter(Integer.class, ATIVO);

        criteriaQuery.where(
                criteriaBuilder.equal(root.get(ATIVO), parametroAtivo),
                criteriaBuilder.equal(root.get("id"), usuarioId)
        );
        criteriaQuery.groupBy(usuarioGrupoJoin.get("id"));
        var typedQuery = getManager().createQuery(criteriaQuery);
        typedQuery.setParameter(ATIVO, 1);
        return typedQuery.getResultList();
    }

    public List<GrupoModel> recuperaGruposUsuario(Long usuarioId){
        var criteriaBuilder = getManager().getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(GrupoModel.class);
        var root = criteriaQuery.from(Usuario.class);
        Join<Usuario, Grupo> usuarioGrupoJoin = root.join("grupos");
        criteriaQuery.select(criteriaBuilder.construct(GrupoModel.class, usuarioGrupoJoin.get("id"), usuarioGrupoJoin.get("nome"), usuarioGrupoJoin.get("descricao")));
        var parametroAtivo = criteriaBuilder.parameter(Integer.class, ATIVO);
        criteriaQuery.where(
                criteriaBuilder.equal(root.get(ATIVO), parametroAtivo),
                criteriaBuilder.equal(root.get("id"), usuarioId)
        );
        criteriaQuery.groupBy(usuarioGrupoJoin.get("id"));
        var typedQuery = getManager().createQuery(criteriaQuery);
        typedQuery.setParameter(ATIVO, 1);
        return typedQuery.getResultList();
    }
}