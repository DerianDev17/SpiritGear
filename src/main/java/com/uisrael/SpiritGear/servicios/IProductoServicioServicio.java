package com.uisrael.SpiritGear.servicios;

import java.util.List;

import com.uisrael.SpiritGear.modelo.entidades.ProductoServicio;


public interface IProductoServicioServicio {
	
	public void insertaProductoServicio(ProductoServicio nuevoProductoServicio);
	
	public List<ProductoServicio> listaProductoServicio();
	
	
	public List<ProductoServicio> listaProductoServicioDescrip(String iDescripcion);
	
	public List<ProductoServicio> listaProductoServicioOrden();
	
	public ProductoServicio buscarProdServicioId(int iIdProveedorBuscar);	
	
	public List<ProductoServicio> listaxIdProveedorPrdSrv(int idProveedor);
	
	public int borrarProdServId(ProductoServicio objBorraPrdSrv);		

}
