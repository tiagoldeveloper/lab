package br.com.lab.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import static br.com.lab.util.LabConstantes.*;

@Repository
public class LabRepository implements LabRepositoryBase {

    @PersistenceContext
    public EntityManager manager;

    @Override
    public <T> T salvar(T t) {
        return manager.merge(t);
    }

    @Override
    public void remove(Object t) {
        manager.remove(manager.merge(t));
    }

    @Override
    public <T> T recupera(Class<T> classe, Long id) {
        var criteriaBuilder = manager.getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(classe);
        var root = criteriaQuery.from(classe);
        criteriaQuery.select(root);
        var parameterAtivo = criteriaBuilder.parameter(Integer.class, ATIVO);
        criteriaQuery.where(criteriaBuilder.equal(root.get(ATIVO), parameterAtivo), criteriaBuilder.equal(root.get("id"), id));
        var typedQuery = manager.createQuery(criteriaQuery);
        typedQuery.setParameter(ATIVO, 1);
        return typedQuery.getSingleResult();
    }

    @Override
    public <T> List<T> recupera(Class<T> classe, List<Long> ids) {
        var criteriaBuilder = manager.getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(classe);
        var root = criteriaQuery.from(classe);
        criteriaQuery.select(root);
        var parametroAtivo = criteriaBuilder.parameter(Integer.class, ATIVO);
        criteriaQuery.where(criteriaBuilder.equal(root.get(ATIVO), parametroAtivo), root.get("id").in(ids));
        var typedQuery = manager.createQuery(criteriaQuery);
        typedQuery.setParameter(ATIVO, 1);
        return typedQuery.getResultList();
    }

    @Override
    public <T> List<T> recuperaNotIn(Class<T> classe, List<Long> ids) {
        var criteriaBuilder = manager.getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(classe);
        var root = criteriaQuery.from(classe);
        criteriaQuery.select(root);
        var parametroAtivo = criteriaBuilder.parameter(Integer.class, ATIVO);
        criteriaQuery.where(criteriaBuilder.equal(root.get(ATIVO), parametroAtivo), criteriaBuilder.not(root.get("id").in(ids)));
        var typedQuery = manager.createQuery(criteriaQuery);
        typedQuery.setParameter(ATIVO, 1);
        return typedQuery.getResultList();
    }

    @Override
    public <T> List<T> recupera(Class<T> classe, Pageable pageable) {
        var criteriaBuilder = manager.getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(classe);
        var root = criteriaQuery.from(classe);
        criteriaQuery.select(root);
        var parametroAtivo = criteriaBuilder.parameter(Integer.class, ATIVO);
        criteriaQuery.where(criteriaBuilder.equal(root.get(ATIVO), parametroAtivo));
        var typedQuery = manager.createQuery(criteriaQuery);
        typedQuery.setParameter(ATIVO, 1);
        typedQuery.setMaxResults(pageable.getPageSize());
        return typedQuery.getResultList();
    }

    public <T> List<T> recupera(Class<T> classe) {
        var criteriaBuilder = manager.getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(classe);
        var root = criteriaQuery.from(classe);
        criteriaQuery.select(root);
        var parametroAtivo = criteriaBuilder.parameter(Integer.class, ATIVO);
        criteriaQuery.where(criteriaBuilder.equal(root.get(ATIVO), parametroAtivo));
        var typedQuery = manager.createQuery(criteriaQuery);
        typedQuery.setParameter(ATIVO, 1);
        return typedQuery.getResultList();
    }

    public EntityManager getManager() {
        return manager;
    }
}