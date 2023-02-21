package com.bp.cbe.service;

import java.util.List;

public interface GenericCrudService<T, I> {

    List<T> listAll();

    T findById(I i);

    T create(T t);

    T update(T t);

    void delete(I i);
}
