package com.retail.service;

import java.util.List;

import com.retail.dto.ConsultaListadoFechaAnoDto;


public interface IConsultaIndicadorService {

	
	List<ConsultaListadoFechaAnoDto> listadoFechaAĆ±o();
	
	List<ConsultaListadoFechaAnoDto> MayorCantidadNacidosAĆ±oMes();
	
	List<ConsultaListadoFechaAnoDto> MenorCantidadNacidosAĆ±oMes();
	
	List<ConsultaListadoFechaAnoDto> TazaNatalidad();
	
}
