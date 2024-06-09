package com.gonzalez.app.jpa.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Habitaciones")
public class Habitaciones {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "habitacion_seq")
    @SequenceGenerator(name = "habitacion_seq", sequenceName = "Habitaciones_Seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "Numero_Habitacion")
    private String numeroHabitacion;
    
    @Column(name = "Tipo_Habitacion")
    private Habitaciones tipoHabitacion;
    
    @Column(name = "Estado")
    private Integer estado;
    
    @ManyToMany(mappedBy = "habitaciones")
    private Set<Pacientes> pacientes = new HashSet<>();
    
    // Getters and setters

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

	public Habitaciones getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(Habitaciones tipoHabitacion) {
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

