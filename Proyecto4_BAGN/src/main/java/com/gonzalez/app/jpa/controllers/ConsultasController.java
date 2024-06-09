package com.gonzalez.app.jpa.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gonzalez.app.jpa.models.Consultas;
import com.gonzalez.app.jpa.services.ConsultasService;

@RestController
@RequestMapping("/consultas")
@CrossOrigin(origins = "*")  //dar acceso a cualquier origen se puede poner en un acceso en especifico
public class ConsultasController {

	@Autowired
	@Qualifier("ram4gb")
	private ConsultasService consultasService;
	
	@PostMapping
    public Map<String, String> guardarConsulta(@RequestBody Consultas consulta) {
        consultasService.guardar(consulta);
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("msg", "Guardado correctamente");
        return respuesta;
    }

    @GetMapping
    public List<Consultas> listarConsultas() {
        return consultasService.listar();
    }

    @DeleteMapping("/eliminar")
    public Map<String, String> eliminarConsulta(@RequestParam(name = "id") Long id) {
        consultasService.eliminar(id);
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("msg", "Eliminado correctamente");
        return respuesta;
    }

    @GetMapping("/obtener/{id}")
    public Consultas obtenerConsultaPorId(@PathVariable(name = "id") Long id) {
        Optional<Consultas> consulta = consultasService.getById(id);
        if (!consulta.isPresent()) {
            return null;
        }
        return consulta.get();
    }

    @PutMapping("/actualizar/{id}")
    public Map<String, String> actualizarConsulta(@RequestBody Consultas consulta, @PathVariable(name = "id") Long id) {
        Optional<Consultas> consultaExistente = consultasService.getById(id);
        if (consultaExistente.isPresent()) {
            consulta.setId(id);
            consultasService.guardar(consulta);
            Map<String, String> respuesta = new HashMap<>();
            respuesta.put("msg", "Actualizado correctamente");
            return respuesta;
        } else {
            throw new RuntimeException("La consulta con ID " + id + " no existe en la base de datos");
        }
    }
	
}
