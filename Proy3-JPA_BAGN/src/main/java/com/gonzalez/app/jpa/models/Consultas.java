package com.gonzalez.app.jpa.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Consultas")
public class Consultas {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consulta_seq")
    @SequenceGenerator(name = "consulta_seq", sequenceName = "Consultas_Seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "Paciente_id")
    private Pacientes paciente;
    
    @ManyToOne
    @JoinColumn(name = "Medico_id")
    private Medicos medico;
    
    @Column(name = "Fecha")
    private Date fecha;
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pacientes getPaciente() {
		return paciente;
	}

	public void setPaciente(Pacientes paciente) {
		this.paciente = paciente;
	}

	public Medicos getMedico() {
		return medico;
	}

	public void setMedico(Medicos medico) {
		this.medico = medico;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
    
}
