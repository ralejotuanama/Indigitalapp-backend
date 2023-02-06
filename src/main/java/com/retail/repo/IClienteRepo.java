package com.retail.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.retail.model.Cliente;




//@Respository
public interface IClienteRepo extends IGenericRepo<Cliente, Integer>{
	
	@Query("select p from Cliente p where p.email =:email OR p.dni =:dni")
	List<Cliente> BuscarPorCorreoyDni(@Param("email") String email, @Param("dni") String dni);
	
	
	@Query(value = "select * from fn_listarClientesNacidosMesAño2()", nativeQuery = true)
	List<Object[]> listarClientesMesAño();
	
	

}
