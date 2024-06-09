package com.gonzalez.app.jpa.models;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.gonzalez.app.jpa.enums.Sexo;

@Entity
@Table(name = "Pacientes")
public class Pacientes {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente_seq")
    @SequenceGenerator(name = "paciente_seq", sequenceName = "Pacientes_Seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "Nombre")
    private String nombre;
    
    @Column(name = "Fecha_Nacimiento")
    private Date fechaNacimiento;
    
    @Column(name = "Genero")
    private Sexo genero;
    
    @Column(name = "Telefono")
    private String telefono;
    
    @Column(name = "Correo_Electronico")
    private String correoElectronico;
    
    @ManyToMany
    @JoinTable(
        name = "Asignaciones_Habitaciones",
        joinColumns = @JoinColumn(name = "ID_Paciente"),
        inverseJoinColumns = @JoinColumn(name = "ID_Habitacion")
    )
    private Set<Habitaciones> habitaciones = new HashSet<>();
    
    // Getters and setters

	public Long getIdPaciente() {
		return id;
	}

	public void setIdPaciente(Long idPaciente) {
		this.id = idPaciente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Sexo getGenero() {
		return genero;
	}

	public void setGenero(Sexo genero) {
		this.genero = genero;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public Set<Habitaciones> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(Set<Habitaciones> habitaciones) {
		this.habitaciones = habitaciones;
	}
    
    
	

}
