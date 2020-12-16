package br.com.lab.repository;

import br.com.lab.domain.model.Usuario;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public class UsuarioRepository extends  LabRepository{

    public Usuario logar(String usuarioLogin){

        var criteriaBuilder = getManager().getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(Usuario.class);
        var root = criteriaQuery.from(Usuario.class);
        criteriaQuery.select(root);
        var ativo = criteriaBuilder.parameter(Integer.class, "ativo");
        var usuarioLoginParametro = criteriaBuilder.parameter(String.class, "usuarioLogin");
        criteriaQuery.where(
                criteriaBuilder.equal(root.get("ativo"), ativo),
                criteriaBuilder.equal(root.get("login"), usuarioLoginParametro)
        );

        var typedQuery = getManager().createQuery(criteriaQuery);
        typedQuery.setParameter(ativo, 1);
        typedQuery.setParameter(usuarioLoginParametro, usuarioLogin);
        return Optional.of(typedQuery.getSingleResult()).orElse(null);
    }
}