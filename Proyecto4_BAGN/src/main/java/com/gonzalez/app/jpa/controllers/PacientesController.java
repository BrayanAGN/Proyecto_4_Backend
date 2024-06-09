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

import com.gonzalez.app.jpa.models.Pacientes;
import com.gonzalez.app.jpa.services.PacientesService;

@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin(origins = "*") // Dar acceso a cualquier origen se puede poner en un acceso en especifico
public class PacientesController {
	
	@Autowired
    @Qualifier("ram12gb")
    private PacientesService pacientesService;

    @PostMapping
    public Map<String, String> guardarPaciente(@RequestBody Pacientes paciente) {
        pacientesService.guardar(paciente);
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("msg", "Guardado correctamente");
        return respuesta;
    }

    @GetMapping
    public List<Pacientes> listarPacientes() {
        return pacientesService.listar();
    }

    @DeleteMapping("/eliminar")
    public Map<String, String> eliminarPaciente(@RequestParam(name = "id") Long id) {
        pacientesService.eliminar(id);
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("msg", "Eliminado correctamente");
        return respuesta;
    }

    @GetMapping("/obtener/{id}")
    public Pacientes obtenerPacientePorId(@PathVariable(name = "id") Long id) {
        Optional<Pacientes> paciente = pacientesService.getById(id);
        if (!paciente.isPresent()) {
            return null;
        }
        return paciente.get();
    }

    @PutMapping("/actualizar/{id}")
    public Map<String, String> actualizarPaciente(@RequestBody Pacientes paciente, @PathVariable(name = "id") Long id) {
        Optional<Pacientes> pacienteExistente = pacientesService.getById(id);
        if (pacienteExistente.isPresent()) {
            paciente.setIdPaciente(id);
            pacientesService.guardar(paciente);
            Map<String, String> respuesta = new HashMap<>();
            respuesta.put("msg", "Actualizado correctamente");
            return respuesta;
        } else {
            throw new RuntimeException("El paciente con ID " + id + " no existe en la base de datos");
        }
    }
}
