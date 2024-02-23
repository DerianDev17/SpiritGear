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

	@Override
	public void insertaParametro(Parametros nuevoParametro) {
		try {
			varIntParamRepositorio.save(nuevoParametro);
		}
		catch (Exception e) {
			System.out.println("Error Inserta Parametro "+ e.getMessage());
		}
	}

	@Override
	public int eliminarParametro(Parametros elimParametro) {
		try {
			varIntParamRepositorio.delete(elimParametro);
			return 1;
		} catch (Exception e) {
			return 0;
		}
		
	}

	@Override
	public List<Parametros> listarParametros() {
		return varIntParamRepositorio.findAll();
	}

	@Override
	public Parametros buscarParamIdParametro(int iIdParam) {
		return varIntParamRepositorio.buscarParamIdParametro(iIdParam);
	}
}
