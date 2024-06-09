package com.gonzalez.app.jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.gonzalez.app.jpa.dao.IHistorialMedicoDao;
import com.gonzalez.app.jpa.models.HistorialMedico;

@Component
@Qualifier("ram8gb")
public class HistorialMedicoService implements IService<HistorialMedico, HistorialMedico> {
	
	@Autowired
	private IHistorialMedicoDao historialMedicoDao;
	
	@Override
	public List<HistorialMedico> listar() {
		// TODO Auto-generated method stub
		List<HistorialMedico> historialMedico = new ArrayList();
		historialMedico = (List<HistorialMedico>)historialMedicoDao.findAll();
		return historialMedico;
	}

	@Override
	public Optional<HistorialMedico> getById(Long id) {
		// TODO Auto-generated method stub
		Optional<HistorialMedico> historialMedico = historialMedicoDao.findById(id);
		return historialMedico;
	}

	@Override
	public void guardar(HistorialMedico t) {
		// TODO Auto-generated method stub
		this.historialMedicoDao.save(t);
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		this.historialMedicoDao.deleteById(id);
	}
}
