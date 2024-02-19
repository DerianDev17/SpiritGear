package com.uisrael.SpiritGear.modelo.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="TLRM04")
public class Vehiculo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//private static final long serialVer
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IDVEHICULO;
	
	
	private String CODMARCA;
	private String CODMODELO;
	private int ANIOFABRICA;
	private String PAISORIGEN;
	private int CILINDRAJE;
	private String COLOR;
	private String CODTIPOCOMBUSTIBLE;
	private String SNASEGURADO;
	private int FECHACOMPRA;
	private String PLACA;
	
	//un vehiculo puede tener muchas ordenes
	// una orden tiene un solo vehiculo
	//relacion onetoMany
	@OneToMany(mappedBy = "fkVehiculo", fetch = FetchType.LAZY)
	private List<CabOrden> listaCabOrdenes = new ArrayList<>();
}
