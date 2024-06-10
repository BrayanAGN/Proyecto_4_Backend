package com.gonzalez.app.jpa.models;

import java.util.Date;

import com.gonzalez.app.jpa.enums.Especialidades;
import com.gonzalez.app.jpa.enums.Genero;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "Medicos")
@Entity
public class Medicos {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medico_seq")
	 @SequenceGenerator(name = "medico_seq", sequenceName = "Medicos_Seq", allocationSize = 1)
	 @Column(name = "id")
	 private Long id;
	    
	 @Column(name = "Nombre")
	 private String nombre;
	    
	 @Column(name = "Especialidad", length = 10)
	 private Especialidades especialidad;
	 
	 @Column(name = "Genero")
	    private Genero genero;
	 
	 @Column(name = "Horario")
	 private String horario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Especialidades getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidades especialidad) {
		this.especialidad = especialidad;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

}
