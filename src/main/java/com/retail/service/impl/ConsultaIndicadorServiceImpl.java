package com.retail.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail.dto.ConsultaListadoFechaAnoDto;
import com.retail.repo.IIndicadorRepo;
import com.retail.service.IConsultaIndicadorService;

@Service
public class ConsultaIndicadorServiceImpl implements IConsultaIndicadorService {

	@Autowired
	private IIndicadorRepo repo;

	@Override
	public List<ConsultaListadoFechaAnoDto> listadoFechaAño() {
		// TODO Auto-generated method stub
		List<ConsultaListadoFechaAnoDto> consultas = new ArrayList<>();
		repo.listardoClientesAñoMes().forEach(x -> {
			ConsultaListadoFechaAnoDto cr = new ConsultaListadoFechaAnoDto();
			cr.setCantidad(Integer.parseInt(String.valueOf(x[0])));
			cr.setFecha(String.valueOf(x[1]));
			consultas.add(cr);
		});

		return consultas;
	}

	@Override
	public List<ConsultaListadoFechaAnoDto> MayorCantidadNacidosAñoMes() {
		// TODO Auto-generated method stub

		List<ConsultaListadoFechaAnoDto> consultas = new ArrayList<>();
		repo.listardoMayorCantidadNacidosAñoMes().forEach(x -> {
			ConsultaListadoFechaAnoDto cr = new ConsultaListadoFechaAnoDto();
			cr.setCantidad(Integer.parseInt(String.valueOf(x[0])));
			cr.setFecha(String.valueOf(x[1]));
			consultas.add(cr);
		});

		return consultas;
	}

	@Override
	public List<ConsultaListadoFechaAnoDto> MenorCantidadNacidosAñoMes() {
		// TODO Auto-generated method stub
		List<ConsultaListadoFechaAnoDto> consultas = new ArrayList<>();
		repo.listardoMenorCantidadNacidosAñoMes().forEach(x -> {
			ConsultaListadoFechaAnoDto cr = new ConsultaListadoFechaAnoDto();
			cr.setCantidad(Integer.parseInt(String.valueOf(x[0])));
			cr.setFecha(String.valueOf(x[1]));
			consultas.add(cr);
		});

		return consultas;
	}

	@Override
	public List<ConsultaListadoFechaAnoDto> TazaNatalidad() {
		// TODO Auto-generated method stub
		List<ConsultaListadoFechaAnoDto> consultas = new ArrayList<>();
		repo.listardoTazaNatalidad().forEach(x -> {
			ConsultaListadoFechaAnoDto cr = new ConsultaListadoFechaAnoDto();
			cr.setCantidad(Integer.parseInt(String.valueOf(x[0])));
			cr.setFecha(String.valueOf(x[1]));
			consultas.add(cr);
		});

		return consultas;
	}

}
