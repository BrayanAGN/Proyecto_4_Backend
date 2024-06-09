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

import com.gonzalez.app.jpa.models.Medicos;
import com.gonzalez.app.jpa.services.MedicosService;

@RestController
@RequestMapping("/api/medicos")
@CrossOrigin(origins = "*") // Dar acceso a cualquier origen se puede poner en un acceso en especifico
public class MedicosController {

	 @Autowired
	    @Qualifier("ram10gb")
	    private MedicosService medicosService;

	    @PostMapping
	    public Map<String, String> guardarMedico(@RequestBody Medicos medico) {
	        medicosService.guardar(medico);
	        Map<String, String> respuesta = new HashMap<>();
	        respuesta.put("msg", "Guardado correctamente");
	        return respuesta;
	    }

	    @GetMapping
	    public List<Medicos> listarMedicos() {
	        return medicosService.listar();
	    }

	    @DeleteMapping("/eliminar")
	    public Map<String, String> eliminarMedico(@RequestParam(name = "id") Long id) {
	        medicosService.eliminar(id);
	        Map<String, String> respuesta = new HashMap<>();
	        respuesta.put("msg", "Eliminado correctamente");
	        return respuesta;
	    }

	    @GetMapping("/obtener/{id}")
	    public Medicos obtenerMedicoPorId(@PathVariable(name = "id") Long id) {
	        Optional<Medicos> medico = medicosService.getById(id);
	        if (!medico.isPresent()) {
	            return null;
	        }
	        return medico.get();
	    }

	    @PutMapping("/actualizar/{id}")
	    public Map<String, String> actualizarMedico(@RequestBody Medicos medico, @PathVariable(name = "id") Long id) {
	        Optional<Medicos> medicoExistente = medicosService.getById(id);
	        if (medicoExistente.isPresent()) {
	            medico.setIdMedico(id);
	            medicosService.guardar(medico);
	            Map<String, String> respuesta = new HashMap<>();
	            respuesta.put("msg", "Actualizado correctamente");
	            return respuesta;
	        } else {
	            throw new RuntimeException("El médico con ID " + id + " no existe en la base de datos");
	        }
	    }
}
