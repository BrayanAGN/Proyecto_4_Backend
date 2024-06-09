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

import com.gonzalez.app.jpa.models.Habitaciones;
import com.gonzalez.app.jpa.services.HabitacionesService;

@RestController
@RequestMapping("/api/habitaciones")
@CrossOrigin(origins = "*") // Dar acceso a cualquier origen se puede poner en un acceso en especifico
public class HabitacionesController {
	
	
	@Autowired
    @Qualifier("ram6gb")
    private HabitacionesService habitacionesService;

    @PostMapping
    public Map<String, String> guardarHabitacion(@RequestBody Habitaciones habitacion) {
        habitacionesService.guardar(habitacion);
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("msg", "Guardado correctamente");
        return respuesta;
    }

    @GetMapping
    public List<Habitaciones> listarHabitaciones() {
        return habitacionesService.listar();
    }

    @DeleteMapping("/eliminar")
    public Map<String, String> eliminarHabitacion(@RequestParam(name = "id") Long id) {
        habitacionesService.eliminar(id);
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("msg", "Eliminado correctamente");
        return respuesta;
    }

    @GetMapping("/obtener/{id}")
    public Habitaciones obtenerHabitacionPorId(@PathVariable(name = "id") Long id) {
        Optional<Habitaciones> habitacion = habitacionesService.getById(id);
        if (!habitacion.isPresent()) {
            return null;
        }
        return habitacion.get();
    }

    @PutMapping("/actualizar/{id}")
    public Map<String, String> actualizarHabitacion(@RequestBody Habitaciones habitacion, @PathVariable(name = "id") Long id) {
        Optional<Habitaciones> habitacionExistente = habitacionesService.getById(id);
        if (habitacionExistente.isPresent()) {
            habitacion.setId(id);
            habitacionesService.guardar(habitacion);
            Map<String, String> respuesta = new HashMap<>();
            respuesta.put("msg", "Actualizado correctamente");
            return respuesta;
        } else {
            throw new RuntimeException("La habitación con ID " + id + " no existe en la base de datos");
        }
    }
}
