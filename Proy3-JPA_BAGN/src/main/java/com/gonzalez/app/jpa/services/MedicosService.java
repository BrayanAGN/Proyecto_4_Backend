package com.gonzalez.app.jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.gonzalez.app.jpa.dao.IMedicosDao;
import com.gonzalez.app.jpa.models.Medicos;

@Component
@Qualifier("ram10gb")
public class MedicosService implements IService<Medicos, Medicos>{
	
	@Autowired
	private IMedicosDao medicosDao;
	
	@Override
	public List<Medicos> listar() {
		// TODO Auto-generated method stub
		List<Medicos> medicos = new ArrayList();
		medicos = (List<Medicos>) medicosDao.findAll();
		return medicos;
	}

	@Override
	public Optional<Medicos> getById(Long id) {
		// TODO Auto-generated method stub
		Optional<Medicos> medicos = medicosDao.findById(id);
		return medicos;
	}

	@Override
	public void guardar(Medicos t) {
		// TODO Auto-generated method stub
		this.medicosDao.save(t);
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		this.medicosDao.deleteById(id);
	}
}
