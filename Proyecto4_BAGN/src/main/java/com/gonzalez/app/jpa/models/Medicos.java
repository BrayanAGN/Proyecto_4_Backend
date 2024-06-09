package com.gonzalez.app.jpa.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.gonzalez.app.jpa.enums.Especialidad;
import com.gonzalez.app.jpa.enums.Sexo;

@Entity
@Table(name = "Medicos")
public class Medicos {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medico_seq")
	 @SequenceGenerator(name = "medico_seq", sequenceName = "Medicos_Seq", allocationSize = 1)
	 @Column(name = "id")
	 private Long id;
	    
	 @Column(name = "Nombre")
	 private String nombre;
	    
	 @Column(name = "Especialidad")
	 private Especialidad especialidad;
	 
	 @Column(name = "Genero")
	    private Sexo genero;
	 
	 @Column(name = "Horario")
	 private Date horario;
	 
	// Getters and setters

	public Long getIdMedico() {
		return id;
	}

	public void setIdMedico(Long idMedico) {
		this.id = idMedico;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public Sexo getGenero() {
		return genero;
	}

	public void setGenero(Sexo genero) {
		this.genero = genero;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}
	    
	    
	 
	 
	
}
