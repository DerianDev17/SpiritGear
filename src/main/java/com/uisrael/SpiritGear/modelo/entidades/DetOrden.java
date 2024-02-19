package com.uisrael.SpiritGear.modelo.entidades;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "TLRM06")
public class DetOrden implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IDDETORDEN;
	
	private int ESTATUSDETORD;
	private String IDTRBSERV;
	private Double Precio;
	private int CANTIDAD;
	private String COMENTARIO;
	private String DIRECCIONDETORDEN;
	private String DIRLATITUD;
	private String DIRLONGUITUD;
	
	
	
	//un detalle tiene una orden
	//una orden tiene muchos detalles
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="IDORDEN")
	private CabOrden fkCabOrden;
	
	// un detalle 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="IDSERVICIO")
	
	private ProductoServicio fkDetOrden;	
}
