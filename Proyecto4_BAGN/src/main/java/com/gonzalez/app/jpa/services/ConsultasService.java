package com.gonzalez.app.jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.gonzalez.app.jpa.dao.IConsultasDao;
import com.gonzalez.app.jpa.models.Consultas;

@Component
@Qualifier("ram4gb")
public class ConsultasService implements IService<Consultas, Consultas>{

	@Autowired
	private IConsultasDao consultasDao;
	
	@Override
	public List<Consultas> listar() {
		// TODO Auto-generated method stub
		List<Consultas> consultas = new ArrayList();
		consultas = (List<Consultas>) consultasDao.findAll();
		return consultas;
	}

	@Override
	public Optional<Consultas> getById(Long id) {
		// TODO Auto-generated method stub
		Optional<Consultas> consultas = consultasDao.findById(id);
		return consultas;
	}

	@Override
	public void guardar(Consultas t) {
		// TODO Auto-generated method stub
		this.consultasDao.save(t);
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		this.consultasDao.deleteById(id);
	}

	

}
