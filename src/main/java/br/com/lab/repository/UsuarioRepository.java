package br.com.lab.repository;

import br.com.lab.domain.model.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

@Repository
public class UsuarioRepository extends  LabRepository{

    public  Usuario logar(String usuarioLogin){

        CriteriaBuilder criteriaBuilder = getManager().getCriteriaBuilder();
        CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);
        Root<Usuario> root = criteriaQuery.from(Usuario.class);

        criteriaQuery.select(root);

        ParameterExpression<Integer> ativo = criteriaBuilder.parameter(Integer.class, "ativo");
        ParameterExpression<String> usuarioLoginParametro = criteriaBuilder.parameter(String.class, "usuarioLogin");
        criteriaQuery.where(
                criteriaBuilder.equal(root.get("ativo"), ativo),
                criteriaBuilder.equal(root.get("login"), usuarioLoginParametro));

        TypedQuery<Usuario> typedQuery = getManager().createQuery(criteriaQuery);
        typedQuery.setParameter(ativo, Integer.valueOf(1));
        typedQuery.setParameter(usuarioLoginParametro, usuarioLogin);

        return typedQuery.getSingleResult();
    }

}
