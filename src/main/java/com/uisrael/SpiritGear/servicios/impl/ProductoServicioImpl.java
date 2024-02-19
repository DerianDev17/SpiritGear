package com.uisrael.SpiritGear.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uisrael.SpiritGear.modelo.entidades.ProductoServicio;
import com.uisrael.SpiritGear.modelo.repositorio.IProductoServicioRepositorio;
import com.uisrael.SpiritGear.servicios.IProductoServicioServicio;

import jakarta.transaction.Transactional;

@Service
@Component
public class ProductoServicioImpl implements IProductoServicioServicio {

	@Autowired
	IProductoServicioRepositorio varProductoServicioRepositorio;
	
	@Override
	@Transactional
	public void insertaProductoServicio(ProductoServicio nuevoProductoServicio) {
		// TODO Auto-generated method stub
		try {
			varProductoServicioRepositorio.save(nuevoProductoServicio);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: " + e.getMessage());
		}
	}

	@Override
	public List<ProductoServicio> listaProductoServicio() {
		// TODO Auto-generated method stub
		return varProductoServicioRepositorio.findAll();
	}

	@Override
	public List<ProductoServicio> listaProductoServicioDescrip(String iDescripcion) {
		// TODO Auto-generated method stub
		return varProductoServicioRepositorio.listaProductoServicioDescrip(iDescripcion);
	}

	@Override
	public List<ProductoServicio> listaProductoServicioOrden() {
		// TODO Auto-generated method stub
		return varProductoServicioRepositorio.listaProductoServicioOrden();
	}

	@Override
	public ProductoServicio buscarProdServicioId(int iIdProveedorBuscar) {
		// TODO Auto-generated method stub
		return varProductoServicioRepositorio.buscarProdServicioId(iIdProveedorBuscar);
	}

	@Override
	public List<ProductoServicio> listaxIdProveedorPrdSrv(int idProveedor) {
		// TODO Auto-generated method stub
		return varProductoServicioRepositorio.listaxIdProveedorPrdSrv(idProveedor);
	}

	@Override
	public int borrarProdServId(ProductoServicio objBorraPrdSrv) {
		try {
			varProductoServicioRepositorio.delete(objBorraPrdSrv);
			return 1;
		} catch (Exception e) {
			System.out.println("Error al eliminar registro " + e.getMessage());
			return 0;
		}
	}

}
