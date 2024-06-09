package com.gonzalez.app.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.gonzalez.app.jpa.models.Medicos;

public interface IMedicosDao extends CrudRepository<Medicos, Long>{

}
