package com.retail.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.retail.model.Cliente;

public interface IClienteService extends ICRUD<Cliente, Integer>{

	Page<Cliente> listarPageable(Pageable pageable);
	List<Cliente> BuscarPorCorreoyDni(Cliente cliente);

}
