package com.uisrael.SpiritGear.modelo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.uisrael.SpiritGear.modelo.entidades.Proveedor;



@Repository
@Component
public interface IProveedorRepositorio  extends JpaRepository<Proveedor, Integer>{
	
	@Query("Select p from Proveedor p where p.NOMBRECOMERCIAL like %?1%")
	public List<Proveedor> listaProveedorNombreCm(String iNombreComecial);
	
	@Query("Select p from Proveedor p order by p.IDPROVEEDOR")
	public List<Proveedor> listaOrdenadaProveedor();
	
	@Query("Select p from Proveedor p where p.IDPROVEEDOR = ?1")
	public Proveedor buscarProveedorId(int iIdProveedorBuscar);	

	
	@Query("Select p from Proveedor p where p.IDPROVEEDOR = ?1")
	public List<Proveedor> listaIdProveedor(int idProveedorLst);
}
