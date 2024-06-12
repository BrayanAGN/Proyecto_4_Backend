package com.gonzalez.app.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.gonzalez.app.jpa.enums.EstadoHabitacion;
import com.gonzalez.app.jpa.models.Habitaciones;

public interface IHabitacionesDao extends CrudRepository<Habitaciones, Long>{
	@Query("SELECT h FROM Habitaciones h WHERE h.estado = :estado")
    List<Habitaciones> findHabitacionesDisponibles(@Param("estado") EstadoHabitacion estado);

}
