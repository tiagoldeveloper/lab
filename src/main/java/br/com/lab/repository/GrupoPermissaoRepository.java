package br.com.lab.repository;

import br.com.lab.domain.model.Grupo;
import br.com.lab.domain.model.Permissao;
import br.com.lab.model.PermissaoModel;
import br.com.lab.model.PermissaoGrupoModel;
import org.springframework.stereotype.Repository;
import javax.persistence.criteria.Join;
import java.util.List;

import static br.com.lab.util.LabConstantes.*;

@Repository
public class GrupoPermissaoRepository extends LabRepository{

    public List<PermissaoGrupoModel> recuperaPermissoesPorGrupo(Long grupoId){
        var criteriaBuilder = getManager().getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(PermissaoGrupoModel.class);
        var root = criteriaQuery.from(Grupo.class);
        Join<Grupo, Permissao> grupoPermissaoJoin = root.join("permissoes");
        criteriaQuery.select(criteriaBuilder.construct(PermissaoGrupoModel.class, grupoPermissaoJoin.get("id"), grupoPermissaoJoin.get("url"), grupoPermissaoJoin.get("nome")));
        var parametroAtivo = criteriaBuilder.parameter(Integer.class, ATIVO);
        criteriaQuery.where(
                criteriaBuilder.equal(root.get(ATIVO), parametroAtivo),
                criteriaBuilder.equal(root.get("id"), grupoId)
        );
        criteriaQuery.groupBy(grupoPermissaoJoin.get("id"));
        var typedQuery = getManager().createQuery(criteriaQuery);
        typedQuery.setParameter(ATIVO, 1);
        return typedQuery.getResultList();
    }

    public List<PermissaoModel> recuperaPermissoesGrupo(Long grupoId){
        var criteriaBuilder = getManager().getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(PermissaoModel.class);
        var root = criteriaQuery.from(Grupo.class);
        Join<Grupo, Permissao> grupoPermissaoJoin = root.join("permissoes");
        criteriaQuery.select(criteriaBuilder.construct(PermissaoModel.class, grupoPermissaoJoin.get("id"), grupoPermissaoJoin.get("url"), grupoPermissaoJoin.get("nome")));
        var parametroAtivo = criteriaBuilder.parameter(Integer.class, ATIVO);
        criteriaQuery.where(
                criteriaBuilder.equal(root.get(ATIVO), parametroAtivo),
                criteriaBuilder.equal(root.get("id"), grupoId)
        );
        criteriaQuery.groupBy(grupoPermissaoJoin.get("id"));
        var typedQuery = getManager().createQuery(criteriaQuery);
        typedQuery.setParameter(ATIVO, 1);
        return typedQuery.getResultList();
    }
}