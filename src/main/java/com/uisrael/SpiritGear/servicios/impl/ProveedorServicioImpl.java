package com.uisrael.SpiritGear.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uisrael.SpiritGear.modelo.entidades.Proveedor;
import com.uisrael.SpiritGear.modelo.repositorio.IProveedorRepositorio;
import com.uisrael.SpiritGear.servicios.IProveedorServicio;

import jakarta.transaction.Transactional;


@Service
@Component
public class ProveedorServicioImpl implements IProveedorServicio {
	
	@Autowired
	private IProveedorRepositorio varProveedorRepositorio;
	
	
	@Override
	@Transactional
	public void insertaProveedor(Proveedor nuevoProveedor) {
		// TODO Auto-generated method stub
		try {
			varProveedorRepositorio.save(nuevoProveedor);	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: " + e.getMessage());
		}
	}

	@Override
	public List<Proveedor> listaProveedor() {
		// TODO Auto-generated method stub
		return varProveedorRepositorio.findAll();
	}

	@Override
	public List<Proveedor> listaProveedorNombreCm(String iNombreComecial) {
		// TODO Auto-generated method stub
		return varProveedorRepositorio.listaProveedorNombreCm(iNombreComecial);
	}

	@Override
	public List<Proveedor> listaOrdenadaProveedor() {
		// TODO Auto-generated method stub
		return varProveedorRepositorio.listaOrdenadaProveedor();
	}

	@Override
	public Proveedor buscarProveedorId(int iIdProveedorBuscar) {
		// TODO Auto-generated method stub
		return varProveedorRepositorio.buscarProveedorId(iIdProveedorBuscar);
	}

	@Override
	public List<Proveedor> listaIdProveedor(int idProveedorLst) {
		// TODO Auto-generated method stub
		return varProveedorRepositorio.listaIdProveedor(idProveedorLst);
	}

	@Override
	public int borrarProveedorId(Proveedor objBorraProveedor) {
		try {
			varProveedorRepositorio.delete(objBorraProveedor);
			return 1;
		} catch (Exception e) {
			System.out.println("Error al eliminar registro " + e.getMessage());
			return 0;
		}
	}

}
