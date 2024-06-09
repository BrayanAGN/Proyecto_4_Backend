package com.gonzalez.app.jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.gonzalez.app.jpa.dao.IPacientesDao;
import com.gonzalez.app.jpa.models.Pacientes;

@Component
@Qualifier("ram12gb")
public class PacientesService implements IService<Pacientes, Pacientes>{

	@Autowired
	private IPacientesDao pacientesDao;
	
	@Override
	public List<Pacientes> listar() {
		// TODO Auto-generated method stub
		List<Pacientes> pacientes = new ArrayList();
		pacientes = (List<Pacientes>) pacientesDao.findAll();
		return pacientes;
	}

	@Override
	public Optional<Pacientes> getById(Long id) {
		// TODO Auto-generated method stub
		Optional<Pacientes> pacientes = pacientesDao.findById(id);
		return pacientes;
	}

	@Override
	public void guardar(Pacientes t) {
		// TODO Auto-generated method stub
		this.pacientesDao.save(t);
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		this.pacientesDao.deleteById(id);
	}

}
