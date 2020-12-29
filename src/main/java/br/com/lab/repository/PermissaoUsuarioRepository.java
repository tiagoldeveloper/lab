package br.com.lab.repository;

import br.com.lab.domain.model.Grupo;
import br.com.lab.domain.model.MenuItem;
import br.com.lab.domain.model.Permissao;
import br.com.lab.domain.model.Usuario;
import br.com.lab.model.MenuItemModel;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Join;
import java.util.List;

import static br.com.lab.util.LabConstantes.ATIVO;

@Repository
public class PermissaoUsuarioRepository extends LabRepository {

    public List<MenuItemModel> recuperaPermissoesPorMenuPorUsuario(Long usuarioId) {
        var criteriaBuilder = getManager().getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(MenuItemModel.class);
        var root = criteriaQuery.from(Usuario.class);
        Join<Usuario, Grupo> usuarioGrupoJoin = root.join("grupos");
        Join<Grupo, Permissao> grupoPermissaoJoin = usuarioGrupoJoin.join("permissoes");
        Join<Permissao, MenuItem> menuItemJoin = grupoPermissaoJoin.join("menuItems");

        criteriaQuery.select(criteriaBuilder.construct(MenuItemModel.class,
                menuItemJoin.get("nome"),
                menuItemJoin.get("icon"),
                menuItemJoin.get("link"),
                menuItemJoin.get("id"),
                menuItemJoin.get("tipoMenuItem"),
                menuItemJoin.get("menuItem").get("id")));

        var ativo = criteriaBuilder.parameter(Integer.class, ATIVO);
        criteriaQuery.where(
                criteriaBuilder.equal(root.get("ativo"), ativo),
                criteriaBuilder.equal(root.get("id"), usuarioId)
        );
        var typedQuery = getManager().createQuery(criteriaQuery);
        typedQuery.setParameter(ATIVO, 1);
        return typedQuery.getResultList();
    }
}