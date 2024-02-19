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
@Table(name = "TLRM02")
public class Usuario  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IDUSUARIO;
	
	private String NMONICOUSUARIO;
	private String IDENTIFICACION;
	private String NOMBRES;
	private String APELLIDOS;
	private String TELCONTACTO;
	private String CODPERFIL;
	private String CLAVEUSR;
	private int ESTATUSUSR;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="IDTALLER")
	
	private Taller fkTaller;
	
	//un usuario puede tener muchas ordenes
	//una orden tiene un solo usuario 
	@OneToMany(mappedBy = "fkUsuario", fetch = FetchType.LAZY)
	private List<CabOrden> listaCabOrden = new ArrayList<>();	

}




