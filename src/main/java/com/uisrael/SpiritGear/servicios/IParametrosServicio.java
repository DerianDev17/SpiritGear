package com.uisrael.SpiritGear.servicios;

import java.util.List;

import com.uisrael.SpiritGear.modelo.entidades.Parametros;


public interface IParametrosServicio {
	
	public void insertaParametro(Parametros nuevoParametro);
	
	public int eliminarParametro(Parametros elimParametro);
	
	public List<Parametros> listarParamNmonico(String inmonico);
	
	public List<Parametros> listarParametros();

	public Parametros buscarParamIdParametro(int iIdParam);
}
