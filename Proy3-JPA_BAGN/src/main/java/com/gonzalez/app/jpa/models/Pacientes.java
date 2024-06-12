package com.gonzalez.app.jpa.models;

import java.sql.Date;
import java.util.List;

import com.gonzalez.app.jpa.enums.Genero;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

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
    private Genero genero;
    
    @Column(name = "Telefono")
    private String telefono;
    
    @Column(name = "Correo_Electronico")
    private String correoElectronico;
    
    @OneToMany(mappedBy = "paciente")
    private List<Habitaciones> habitaciones;

    @Column(name = "id_habitacion")
    private Long idHabitacion;

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

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
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

	public List<Habitaciones> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(List<Habitaciones> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public Long getIdHabitacion() {
		return idHabitacion;
	}

	public void setIdHabitacion(Long idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	
}
