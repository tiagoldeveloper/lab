package br.com.lab.repository;

import br.com.lab.domain.model.Grupo;
import br.com.lab.domain.model.Usuario;
import org.springframework.stereotype.Repository;
import javax.persistence.criteria.*;
import java.util.List;
import static br.com.lab.util.LabConstantes.*;

@Repository
public class GrupoRepository extends LabRepository{

    public List<Grupo> recuperaGruposPorUsuario(Long usuarioId){
        var criteriaBuilder = getManager().getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(Grupo.class);
        var root = criteriaQuery.from(Usuario.class);
        Join<Usuario, Grupo> usuarioGrupoJoin = root.join("grupos");
        criteriaQuery.select(root.get("grupos"));
        var parametroAtivo = criteriaBuilder.parameter(Integer.class, ATIVO);
        criteriaQuery.where(
                criteriaBuilder.equal(root.get(ATIVO), parametroAtivo),
                criteriaBuilder.equal(root.get("id"), usuarioId)
        );
        var typedQuery = getManager().createQuery(criteriaQuery);
        typedQuery.setParameter(ATIVO, 1);
        return typedQuery.getResultList();
    }
}
