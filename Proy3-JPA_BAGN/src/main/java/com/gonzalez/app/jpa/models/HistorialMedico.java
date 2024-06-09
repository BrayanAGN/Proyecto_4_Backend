package com.gonzalez.app.jpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "Historial_Medico")
@Entity
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
