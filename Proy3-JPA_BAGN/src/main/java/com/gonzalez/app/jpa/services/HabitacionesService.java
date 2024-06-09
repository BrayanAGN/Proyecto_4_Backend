package com.gonzalez.app.jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.gonzalez.app.jpa.dao.IHabitacionesDao;
import com.gonzalez.app.jpa.models.Habitaciones;

@Component
@Qualifier("ram6gb")
public class HabitacionesService implements IService<Habitaciones, Habitaciones>{
	
	@Autowired
	private IHabitacionesDao habitacionesDao;

	@Override
	public List<Habitaciones> listar() {
		// TODO Auto-generated method stub
		List<Habitaciones> habitaciones = new ArrayList();
		habitaciones = (List<Habitaciones>) habitacionesDao.findAll();
		return habitaciones;
	}

	@Override
	public Optional<Habitaciones> getById(Long id) {
		// TODO Auto-generated method stub
		Optional<Habitaciones> habitaciones = habitacionesDao.findById(id);
		return habitaciones;
	}

	@Override
	public void guardar(Habitaciones t) {
		// TODO Auto-generated method stub
		this.habitacionesDao.save(t);
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		this.habitacionesDao.deleteById(id);
	}
}
