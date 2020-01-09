package com.medicaApp.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicaApp.dao.ISignosVitalesDao;
import com.medicaApp.model.SignosVitales;
import com.medicaApp.service.ISignosVitalesService;

@Service
public class SignosVitalesServiceImpl implements ISignosVitalesService{

	@Autowired
	private ISignosVitalesDao dao;

	@Override
	public SignosVitales registrar(SignosVitales t) {
		return dao.save(t);
	}

	@Override
	public SignosVitales modificar(SignosVitales t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(Integer id) {
		dao.deleteById(id);		
	}

	@Override
	public List<SignosVitales> listar() {
		return dao.findAll();
	}

	@Override
	public SignosVitales listarPorId(Integer id) {
		Optional<SignosVitales> element = dao.findById(id);
		return element.isPresent() ? element.get() : new SignosVitales();

	}

	@Override
	public List<SignosVitales> filtro(LocalDate fecha, Integer id, String nombre) {
		LocalDateTime fechaFin = null;
		LocalDateTime fechaInicio = null;
		if(fecha != null) {
			fechaFin = LocalDateTime.of(fecha, LocalTime.MAX);
			fechaInicio = LocalDateTime.of(fecha, LocalTime.MIN);	
		}
		return dao.filtro(fechaInicio,fechaFin,id,nombre);		
	}
}