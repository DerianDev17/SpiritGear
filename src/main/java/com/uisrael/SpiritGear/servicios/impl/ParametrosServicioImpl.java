package com.uisrael.SpiritGear.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uisrael.SpiritGear.modelo.entidades.Parametros;
import com.uisrael.SpiritGear.modelo.repositorio.IParametrosRepositorio;
import com.uisrael.SpiritGear.servicios.IParametrosServicio;

@Service
@Component
public class ParametrosServicioImpl implements IParametrosServicio{

	@Autowired
	private IParametrosRepositorio varIntParamRepositorio;
	
	@Override
	public List<Parametros> listarParamNmonico(String inmonico) {
		// TODO Auto-generated method stub
		return varIntParamRepositorio.listarParamNmonico(inmonico);
	}
}
