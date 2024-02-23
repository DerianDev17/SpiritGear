package com.uisrael.SpiritGear.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.uisrael.SpiritGear.modelo.entidades.Parametros;
import com.uisrael.SpiritGear.servicios.IParametrosServicio;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class ParametrosControlador implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IParametrosServicio varIParametrosServicios;
	private List<Parametros> lstParametros = new ArrayList<>();
	
	
	@GetMapping("/listarparametros")
	public String listarParametros(Model modeloParametro) {
		lstParametros = varIParametrosServicios.listarParametros();
		modeloParametro.addAttribute("listaparametros", lstParametros);
		return "spiritGear/Parametro";
	}
	
	//edit 
	@GetMapping("/editarparametro/{idParametroEdit}")
	public String editParametro(@PathVariable(value="idParametroEdit") int idEditParam, Model modelObjParametro) {
		Parametros objParametro = varIParametrosServicios.buscarParamIdParametro(idEditParam);
		modelObjParametro.addAttribute("objParamNvMd", objParametro);
		return("/spiritGear/nuevoparametro");
	}	

	//para enviar los objetos  a HTML
	@GetMapping("/nuevoparametro")
	public String forInsNuevoParametro(Model modelObjParametro) {
		Parametros objNuevoParametros = new Parametros();
		modelObjParametro.addAttribute("objParamNvMd", objNuevoParametros);
		return("/spiritGear/nuevoparametro");
	}

	@GetMapping("/eliminarParametro/{idParamDel}")
	public String eliminarObjUsuario(@PathVariable(value="idParamDel") int idParametroEliminar) {
		Parametros objParametro = new Parametros();
		objParametro.setIDPARAMETRO(idParametroEliminar);
		varIParametrosServicios.eliminarParametro(objParametro);
		return("redirect:/listarparametros");
	}
	
	
	@PostMapping("/insertarParametro")
	public String insertarParametroNuevo(@ModelAttribute("objParamNvMd") Parametros nuevoParamObj) {
		varIParametrosServicios.insertaParametro(nuevoParamObj);
		return ("redirect:/listarparametros");
	}
	
}
