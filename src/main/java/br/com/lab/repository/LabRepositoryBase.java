package br.com.lab.repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface LabRepositoryBase {
    public <T> T salvar(T t);
    public void remove(Object t);
    public <T> T recupera(Class<T> classe, Long id);
    public <T> List<T> recupera(Class<T> classe, List<Long> ids);
    public <T> List<T> recuperaNotIn(Class<T> classe, List<Long> ids);
    public <T> List<T> recupera(Class<T> classe);
    public <T> List<T> recupera(Class<T> classe, Pageable pageable);
}