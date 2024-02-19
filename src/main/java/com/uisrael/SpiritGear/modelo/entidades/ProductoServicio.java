package com.uisrael.SpiritGear.modelo.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "TLRM07")
public class ProductoServicio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IDSERVICIO;
	
	
	private String IDTRABAJOSERVICIO;	     	     
	private String NMONICOSERVICIO;	     	     
	private String DESCRIPCION;	     	     
	private String SNREQUBICACION;	     	     
	private String BNDEXISTENCIA;	     	     
	private Double CONTADOREXIS;    
	private Double COSTOCOMPRA;    
	private Double COSTOVENTA;    	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="IDPROVEEDOR")
	
	private Proveedor fkProdServicio;
	
	
	//un suministro/repuesto/servicio puede estar en varios detalles
	//relacion onetoMany
	@OneToMany(mappedBy = "fkDetOrden", fetch = FetchType.LAZY)
	private List<DetOrden> listaDetOrden = new ArrayList<>();
}

