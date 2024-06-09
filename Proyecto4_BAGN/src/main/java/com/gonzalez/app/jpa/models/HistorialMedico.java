package com.gonzalez.app.jpa.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Historial_Medico")
public class HistorialMedico {
	 @Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "historial_seq")
	 @SequenceGenerator(name = "historial_seq", sequenceName = "Historial_Medico_Seq", allocationSize = 1)
	 @Column(name = "id")
	 private Long id;
	    
	 @ManyToOne
	 @JoinColumn(name = "Paciente_id")
	 private Pacientes paciente;
	    
	 @Column(name = "Diagnostico")
	 private String diagnostico;
	    
	 @Column(name = "Tratamiento")
	 private String tratamiento;
	    
	 @Column(name = "Resultados_Examenes")
	 private String resultadosExamenes;
	 
		// Getters and setters

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

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

	public String getResultadosExamenes() {
		return resultadosExamenes;
	}

	public void setResultadosExamenes(String resultadosExamenes) {
		this.resultadosExamenes = resultadosExamenes;
	}
	 	 
	 
}

