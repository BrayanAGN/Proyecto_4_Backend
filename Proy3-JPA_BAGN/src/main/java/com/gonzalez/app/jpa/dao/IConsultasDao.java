package com.gonzalez.app.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.gonzalez.app.jpa.models.Consultas;

public interface IConsultasDao extends CrudRepository<Consultas, Long>{

}
