package br.com.lab.repository;

import br.com.lab.domain.model.Mensagem;
import br.com.lab.model.MensagemModel;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class MensagemRepository extends LabRepository{

    public Map<String, String> recuperaMensagens(){

        CriteriaBuilder criteriaBuilder = getManager().getCriteriaBuilder();
        CriteriaQuery<MensagemModel> criteriaQuery = criteriaBuilder.createQuery(MensagemModel.class);
        Root<Mensagem> root = criteriaQuery.from(Mensagem.class);

        criteriaQuery.select(criteriaBuilder.construct(MensagemModel.class, root.get("chave"), root.get("valor")));

        ParameterExpression<Integer> ativo = criteriaBuilder.parameter(Integer.class, "ativo");
        criteriaQuery.where(criteriaBuilder.equal(root.get("ativo"), ativo));

        TypedQuery<MensagemModel> typedQuery = getManager().createQuery(criteriaQuery);
        typedQuery.setParameter("ativo", Integer.valueOf(1));

        return typedQuery.getResultList().stream().collect(Collectors.toMap(MensagemModel::getChave, MensagemModel::getValor));
    }


}
