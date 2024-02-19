package com.uisrael.SpiritGear.modelo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.uisrael.SpiritGear.modelo.entidades.ProductoServicio;

@Repository
@Component
public interface IProductoServicioRepositorio extends JpaRepository<ProductoServicio, Integer> {
	
	@Query("Select ps from ProductoServicio ps where ps.DESCRIPCION like %?1%")
	public List<ProductoServicio> listaProductoServicioDescrip(String iDescripcion);
	
	
	@Query("Select ps from ProductoServicio ps order by ps.IDSERVICIO")
	public List<ProductoServicio> listaProductoServicioOrden();

	@Query("Select ps from ProductoServicio ps where ps.IDSERVICIO = ?1")
	public ProductoServicio buscarProdServicioId(int iIdProveedorBuscar);	


	
	@Query("select ps from ProductoServicio ps WHERE ps.fkProdServicio.IDPROVEEDOR = ?1")
	public List<ProductoServicio> listaxIdProveedorPrdSrv(int idProveedor);
}
