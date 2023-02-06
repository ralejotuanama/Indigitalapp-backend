package com.retail.repo;


import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.retail.model.Cliente;





public interface IIndicadorRepo  extends IGenericRepo<Cliente, Integer> {

	
	@Query(value = "select * from fn_listarClientesNacidosMesAño2()", nativeQuery = true)
	List<Object[]> listardoClientesAñoMes();
	
	@Query(value = "select * from fn_clientes_mayorcantidadnacidosañomes()", nativeQuery = true)
	List<Object[]> listardoMayorCantidadNacidosAñoMes();
	
	@Query(value = "select * from fn_clientes_menorcantidadnacidosañomes()", nativeQuery = true)
	List<Object[]> listardoMenorCantidadNacidosAñoMes();
	
	@Query(value = "select * from fn_clientes_tazanatalidad()", nativeQuery = true)
	List<Object[]> listardoTazaNatalidad();
	
}
