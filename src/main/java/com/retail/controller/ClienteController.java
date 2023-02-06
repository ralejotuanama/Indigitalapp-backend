package com.retail.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.retail.exception.ModeloNotFoundException;
import com.retail.model.Cliente;
import com.retail.service.IClienteService;

@RestController
@RequestMapping("/clientes")
//@CrossOrigin(origins = "localhost:4200")
public class ClienteController {

	@Autowired
	private IClienteService service;

	@GetMapping
	public ResponseEntity<List<Cliente>> listar() throws Exception {
		List<Cliente> lista = service.listar();
		return new ResponseEntity<List<Cliente>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> listarPorId(@PathVariable("id") Integer id) throws Exception {
		Cliente obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Cliente>(obj, HttpStatus.OK);
	}

	@GetMapping("/hateoas/{id}")
	public EntityModel<Cliente> listarPorIdHateoas(@PathVariable("id") Integer id) throws Exception {
		Cliente obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		// localhost:8080/pacientes/{id}
		EntityModel<Cliente> recurso = EntityModel.of(obj);
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));

		recurso.add(linkTo.withRel("paciente-recurso"));

		return recurso;
	}

	@PostMapping
	public ResponseEntity<Void> registrar(@Valid @RequestBody Cliente cliente) throws Exception {
		Cliente obj = service.registrar(cliente);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCliente())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Cliente> modificar(@Valid @RequestBody Cliente cliente) throws Exception {
		Cliente obj = service.modificar(cliente);
		return new ResponseEntity<Cliente>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		Cliente obj = service.listarPorId(id);
		if (obj.getIdCliente() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/pageable")
	public ResponseEntity<Page<Cliente>> listarPageable(Pageable pageable) throws Exception {
		Page<Cliente> clientes = service.listarPageable(pageable);
		return new ResponseEntity<Page<Cliente>>(clientes, HttpStatus.OK);
	}

	@PostMapping("/buscar")
	public List<Cliente> buscar(@RequestBody Cliente cliente) {
		List<Cliente> lista = new ArrayList<>();
		lista = service.BuscarPorCorreoyDni(cliente);
		return lista;
	}
}
