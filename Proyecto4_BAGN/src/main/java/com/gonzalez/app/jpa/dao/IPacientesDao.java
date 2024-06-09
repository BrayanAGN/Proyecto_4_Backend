package com.gonzalez.app.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.gonzalez.app.jpa.models.Pacientes;

public interface IPacientesDao extends CrudRepository<Pacientes, Long>{

}
