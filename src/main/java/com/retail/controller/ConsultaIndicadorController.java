package com.retail.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retail.dto.ConsultaListadoFechaAnoDto;
import com.retail.service.IConsultaIndicadorService;

@RestController
@RequestMapping("/consultasindicador")
public class ConsultaIndicadorController {

	@Autowired
	private IConsultaIndicadorService service;

	@GetMapping(value = "/listarClientesAnoMes")
	public ResponseEntity<List<ConsultaListadoFechaAnoDto>> listaclientesAnoMes() {
		List<ConsultaListadoFechaAnoDto> consultas = new ArrayList<>();
		consultas = service.listadoFechaAño();
		return new ResponseEntity<List<ConsultaListadoFechaAnoDto>>(consultas, HttpStatus.OK);
	}

	@GetMapping(value = "/MayorCantidadNacimiento")
	public ResponseEntity<List<ConsultaListadoFechaAnoDto>> listarMayorCantidadNacimiento() {
		List<ConsultaListadoFechaAnoDto> consultas = new ArrayList<>();
		consultas = service.MayorCantidadNacidosAñoMes();
		return new ResponseEntity<List<ConsultaListadoFechaAnoDto>>(consultas, HttpStatus.OK);
	}

	@GetMapping(value = "/MenorCantidadNacimiento")
	public ResponseEntity<List<ConsultaListadoFechaAnoDto>> listarMenorCantidadNacimiento() {
		List<ConsultaListadoFechaAnoDto> consultas = new ArrayList<>();
		consultas = service.MenorCantidadNacidosAñoMes();
		return new ResponseEntity<List<ConsultaListadoFechaAnoDto>>(consultas, HttpStatus.OK);
	}

	@GetMapping(value = "/tazaNatalidad")
	public ResponseEntity<List<ConsultaListadoFechaAnoDto>> Natalidad() {
		List<ConsultaListadoFechaAnoDto> consultas = new ArrayList<>();
		consultas = service.TazaNatalidad();
		return new ResponseEntity<List<ConsultaListadoFechaAnoDto>>(consultas, HttpStatus.OK);
	}

}
