package com.medicaApp.service;

import java.util.List;


//operaciones comunes
public interface ICRUD <T> {
	T registrar(T t);
	T modificar(T t);
	void eliminar(int id);
	List<T> listar();
	T listarPorId(int id);
}
