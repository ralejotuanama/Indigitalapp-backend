package com.retail.service.impl;

import java.util.List;

import com.retail.repo.IGenericRepo;
import com.retail.service.ICRUD;

public abstract class CRUDImpl <T, ID> implements ICRUD<T, ID> {

	protected abstract IGenericRepo<T,ID> getRepo();
	
	@Override
	public T registrar(T obj) throws Exception {
		return getRepo().save(obj);
	}

	@Override
	public T modificar(T obj) throws Exception {
		return getRepo().save(obj);
	}

	@Override
	public List<T> listar() throws Exception {
		return getRepo().findAll();
	}
	
	@Override
	public T listarPorId(ID id) throws Exception {
		return getRepo().findById(id).orElse(null);		
	}
	
	@Override
	public void eliminar(ID id) throws Exception {
		getRepo().deleteById(id);
	}
}
