package com.gonzalez.app.jpa.services;

import java.util.List;
import java.util.Optional;

public interface IService <T, S>{
	///nuevo
	List<T> listar();
	Optional<T> getById(Long id);
	void guardar(S t);
	void eliminar(Long id);

}
