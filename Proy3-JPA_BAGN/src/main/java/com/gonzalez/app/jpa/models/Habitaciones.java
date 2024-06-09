package com.gonzalez.app.jpa.models;

import java.util.HashSet;
import java.util.Set;

import com.gonzalez.app.jpa.enums.THabitaciones;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "Habitaciones")
@Entity
public class Habitaciones {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "habitacion_seq")
    @SequenceGenerator(name = "habitacion_seq", sequenceName = "Habitaciones_Seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "Numero_Habitacion")
    private String numeroHabitacion;
    
    @Column(name = "Tipo_Habitacion")
    private THabitaciones  tipoHabitacion;
    
    @Column(name = "Estado")
    private Integer estado;
    
    @ManyToMany
    @JoinTable(
        name = "Pacientes_Habitaciones",
        joinColumns = @JoinColumn(name = "habitacion_id"),
        inverseJoinColumns = @JoinColumn(name = "paciente_id")
    )
    private Set<Pacientes> pacientes = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroHabitacion() {
		return numeroHabitacion;
	}

	public void setNumeroHabitacion(String numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}

	public THabitaciones getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(THabitaciones tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Set<Pacientes> getPacientes() {
		return pacientes;
	}

	public void setPacientes(Set<Pacientes> pacientes) {
		this.pacientes = pacientes;
	}
    
    
}
