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
@Table(name = "TLRM05")
public class CabOrden implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IDORDEN;
	
	private int ESTATUS;
	private int FECHA;	
	private String HORAINICIO;
	private int KILOMETRAJE;
	private int PORCENTAJECOMB;
	private String ODTIPOSERVICIO;
	private String OBSERVACION;
	private String RECOMENDACION;
	private String CELULARTERCERO;
	private int FECHA_CIERRE;
	
	//una cabcera orden tiene un vehiculo
	//un  vehiculo puede estar en muchas ordenes 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="IDVEHICULO")	
	private Vehiculo fkVehiculo;
	
	//una cabecera orden tiene un usuario
	//un usuario puede tener muchas ordenes
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="IDUSUARIO")
	private Usuario fkUsuario;
	
	
	//una cabecera tiene varios detalles
	//relacion onetoMany
	@OneToMany(mappedBy = "fkCabOrden", fetch = FetchType.LAZY)
	private List<DetOrden> listaDetOrden = new ArrayList<>();	
	
}
