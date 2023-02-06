package com.retail.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.retail.model.Cliente;
import com.retail.repo.IClienteRepo;
import com.retail.repo.IGenericRepo;
import com.retail.service.IClienteService;


@Service
public class ClienteServiceImpl extends CRUDImpl<Cliente, Integer> implements IClienteService{

	@Autowired
	private IClienteRepo repo;
	
	@Override
	protected IGenericRepo<Cliente, Integer> getRepo(){
		return repo;
	}

	@Override
	public Page<Cliente> listarPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@Override
	public List<Cliente> BuscarPorCorreoyDni(Cliente cliente) {
		// TODO Auto-generated method stub
		return repo.BuscarPorCorreoyDni(cliente.getEmail(), cliente.getDni());
	}
	
	/*@Override
	public Paciente registrar(Paciente obj) {
		return repo.save(obj);
	}

	@Override
	public Paciente modificar(Paciente obj) {
		return repo.save(obj);
	}	

	@Override
	public List<Paciente> listar() {
		return repo.findAll();
	}

	@Override
	public Paciente listarPorId(Integer id) {
		Optional<Paciente> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Paciente();
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
		
	}*/

}
