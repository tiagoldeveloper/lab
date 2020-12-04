package br.com.lab.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.Arrays;
import java.util.List;

@Repository
public class LabRepository implements LabRepositoryBase {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public <T> T salvar(T t) {
        try {
            return manager.merge(t);
        }catch (Exception ex){
            throw ex;
        }
    }

    @Override
    public void remove(Object t) {
        try {
            manager.remove(manager.merge(t));
        }catch (Exception ex){
            throw ex;
        }
    }

    @Override
    public <T> T recupera(Class<T> classe, Long id) {
        try {
            CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
            CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(classe);
            Root<T> root = criteriaQuery.from(classe);

            criteriaQuery.select(root);
            ParameterExpression<Integer> ativo = criteriaBuilder.parameter(Integer.class, "ativo");
            criteriaQuery.where(criteriaBuilder.equal(root.get("ativo"), ativo), criteriaBuilder.equal(root.get("id"), id));

            TypedQuery<T> typedQuery = manager.createQuery(criteriaQuery);
            typedQuery.setParameter("ativo", Integer.valueOf(1));

            return typedQuery.getSingleResult();

        }catch (Exception ex){
            throw ex;
        }
    }

    @Override
    public <T> List<T> recupera(Class<T> classe, List<Long> ids) {
        try {
            CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
            CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(classe);
            Root<T> root = criteriaQuery.from(classe);
            criteriaQuery.select(root);
            ParameterExpression<Integer> ativo = criteriaBuilder.parameter(Integer.class, "ativo");
            criteriaQuery.where(criteriaBuilder.equal(root.get("ativo"), ativo), root.get("id").in(ids));
            TypedQuery<T> typedQuery = manager.createQuery(criteriaQuery);
            typedQuery.setParameter("ativo", Integer.valueOf(1));

            return typedQuery.getResultList();

        }catch (Exception ex){
            throw ex;
        }
    }



    @Override
    public <T> List<T> recupera(Class<T> classe, Pageable pageable) {
        try {
        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(classe);
        Root<T> root = criteriaQuery.from(classe);

        criteriaQuery.select(root);
        ParameterExpression<Integer> ativo = criteriaBuilder.parameter(Integer.class, "ativo");
        criteriaQuery.where(criteriaBuilder.equal(root.get("ativo"), ativo));


        TypedQuery<T> typedQuery = manager.createQuery(criteriaQuery);
        typedQuery.setParameter("ativo", Integer.valueOf(1));
        typedQuery.setMaxResults(pageable.getPageSize());

        return typedQuery.getResultList();

        }catch (Exception ex){
            throw ex;
        }
    }


    public EntityManager getManager() {
        return manager;
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }
}
