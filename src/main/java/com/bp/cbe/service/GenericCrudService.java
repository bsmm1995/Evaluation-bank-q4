package com.bp.cbe.service;

import java.util.List;

public interface GenericCrudService<T, ID> {

    public List<T> listAll() throws Exception;

    public T findById(ID id);

    public T create(T t) throws Exception;

    public T edit(T t) throws Exception;

    public void delete(ID id) throws Exception;

}
