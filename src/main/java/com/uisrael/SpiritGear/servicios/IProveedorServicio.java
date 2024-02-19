package com.uisrael.SpiritGear.servicios;

import java.util.List;

import com.uisrael.SpiritGear.modelo.entidades.Proveedor;


public interface IProveedorServicio {

	public void insertaProveedor(Proveedor nuevoProveedor);
	
	public List<Proveedor> listaProveedor();
	
	public List<Proveedor> listaProveedorNombreCm(String iNombreComecial);	
	
	public List<Proveedor> listaOrdenadaProveedor();
	
	public Proveedor buscarProveedorId(int iIdProveedorBuscar);	
	
	public List<Proveedor> listaIdProveedor(int idProveedorLst);
	
	public int borrarProveedorId(Proveedor objBorraProveedor);	
}
