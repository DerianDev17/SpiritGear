package com.uisrael.SpiritGear.controlador;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.uisrael.SpiritGear.dto.ConsultaDisponibilidadDTO;
import com.uisrael.SpiritGear.dto.ConsultaJefeTallerDTO;
import com.uisrael.SpiritGear.servicios.impl.CabOrdenServicioImpl;


@Controller
public class CabOrdenControlador implements Serializable {

	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private  CabOrdenServicioImpl varCabOrdenServicio;
	
	

	
	//private List<ConsultaJefeTallerDTO> detConsultaJefeT= new ArrayList<>();
	
	
	@GetMapping("/consultaJTaller")
	public String consultaControladorTaller(Model modelo) {
		List<ConsultaJefeTallerDTO> consDetalle = varCabOrdenServicio.getDatosConsulta();
		modelo.addAttribute("consultaJTallerUno", consDetalle);
		return("/spiritGear/reportes");
	}

	@GetMapping("/consultaDispo")
	public String consultaDisponibilidad(Model modeloDispo) {
		List<ConsultaDisponibilidadDTO> consDispo = varCabOrdenServicio.getDatosDisponible();
		modeloDispo.addAttribute("consultaDispo", consDispo);
		return("/spiritGear/reportesDispo");
	}
	
}
