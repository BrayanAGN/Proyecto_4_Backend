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

import com.gonzalez.app.jpa.models.HistorialMedico;
import com.gonzalez.app.jpa.services.HistorialMedicoService;

@RestController
@RequestMapping("/api/historial")
@CrossOrigin(origins = "*") // Dar acceso a cualquier origen se puede poner en un acceso en especifico
public class HistorialMedicoController {

	@Autowired
    @Qualifier("ram8gb")
    private HistorialMedicoService historialMedicoService;

    @PostMapping
    public Map<String, String> guardarHistorialMedico(@RequestBody HistorialMedico historialMedico) {
        historialMedicoService.guardar(historialMedico);
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("msg", "Guardado correctamente");
        return respuesta;
    }

    @GetMapping
    public List<HistorialMedico> listarHistorialMedico() {
        return historialMedicoService.listar();
    }

    @DeleteMapping("/eliminar")
    public Map<String, String> eliminarHistorialMedico(@RequestParam(name = "id") Long id) {
        historialMedicoService.eliminar(id);
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("msg", "Eliminado correctamente");
        return respuesta;
    }

    @GetMapping("/obtener/{id}")
    public HistorialMedico obtenerHistorialMedicoPorId(@PathVariable(name = "id") Long id) {
        Optional<HistorialMedico> historialMedico = historialMedicoService.getById(id);
        if (!historialMedico.isPresent()) {
            return null;
        }
        return historialMedico.get();
    }

    @PutMapping("/actualizar/{id}")
    public Map<String, String> actualizarHistorialMedico(@RequestBody HistorialMedico historialMedico, @PathVariable(name = "id") Long id) {
        Optional<HistorialMedico> historialMedicoExistente = historialMedicoService.getById(id);
        if (historialMedicoExistente.isPresent()) {
            historialMedico.setId(id);
            historialMedicoService.guardar(historialMedico);
            Map<String, String> respuesta = new HashMap<>();
            respuesta.put("msg", "Actualizado correctamente");
            return respuesta;
        } else {
            throw new RuntimeException("El historial médico con ID " + id + " no existe en la base de datos");
        }
    }
}
