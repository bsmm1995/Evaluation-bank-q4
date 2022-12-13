package com.bp.cbe.service.impl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bp.cbe.service.GenericCrudService;

public abstract class GenericCrudServiceImpl<T, ID> implements GenericCrudService<T, ID> {

	protected abstract JpaRepository<T, ID> getRepository();

	@Override
	public List<T> listAll() throws Exception {
		return getRepository().findAll();
	}

	@Override
	public T findById(ID id) throws Exception {
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
