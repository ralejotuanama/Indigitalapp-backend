package com.retail.service;

import java.util.List;

import com.retail.dto.ConsultaListadoFechaAnoDto;


public interface IConsultaIndicadorService {

	
	List<ConsultaListadoFechaAnoDto> listadoFechaAño();
	
	List<ConsultaListadoFechaAnoDto> MayorCantidadNacidosAñoMes();
	
	List<ConsultaListadoFechaAnoDto> MenorCantidadNacidosAñoMes();
	
	List<ConsultaListadoFechaAnoDto> TazaNatalidad();
	
}
