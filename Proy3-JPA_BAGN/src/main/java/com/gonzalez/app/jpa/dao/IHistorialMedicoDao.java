package com.gonzalez.app.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.gonzalez.app.jpa.models.HistorialMedico;

public interface IHistorialMedicoDao extends CrudRepository<HistorialMedico, Long>{

}
