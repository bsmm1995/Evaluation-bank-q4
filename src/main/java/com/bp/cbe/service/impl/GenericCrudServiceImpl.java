package com.bp.cbe.service.impl;

import com.bp.cbe.service.GenericCrudService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class GenericCrudServiceImpl<T, ID> implements GenericCrudService<T, ID> {

    protected abstract JpaRepository<T, ID> getRepository();

    @Override
    public List<T> listAll() throws Exception {
        return getRepository().findAll();
    }

    @Override
    public T findById(ID id) {
        return getRepository().findById(id).orElse(null);
    }

    @Override
    public T create(T t) throws Exception {
        return getRepository().save(t);
    }

    @Override
    public T edit(T t) throws Exception {
        return getRepository().save(t);
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepository().deleteById(id);

    }

}
