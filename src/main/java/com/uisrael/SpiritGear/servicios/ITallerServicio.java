package com.uisrael.SpiritGear.servicios;

import java.util.List;

import com.uisrael.SpiritGear.modelo.entidades.Taller;

public interface ITallerServicio {
	
	public void insertarTaller(Taller nuevoTaller);
	
	public List<Taller> listarTaller();
	
	public List<Taller> listarTallerNmonico(String inmonico);
	
	public List<Taller> listaOrdenadaTaller();
	
	public Taller buscarTallerId(int iIdTallerBuscar);

	public void actualizarTaller(Taller nuevoTaller);
	
	public int actualizaEstatusTaller(Taller iInactivaTaller);
	
	public List<Taller> listaBuscarTallerId(int iIdListTaller);
	
}
