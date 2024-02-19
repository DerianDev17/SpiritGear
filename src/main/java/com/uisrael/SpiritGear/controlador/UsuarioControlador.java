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
import org.springframework.web.bind.annotation.PostMapping;

import com.uisrael.SpiritGear.modelo.entidades.Parametros;
import com.uisrael.SpiritGear.modelo.entidades.Taller;
import com.uisrael.SpiritGear.modelo.entidades.Usuario;
import com.uisrael.SpiritGear.servicios.IParametrosServicio;
import com.uisrael.SpiritGear.servicios.ITallerServicio;
import com.uisrael.SpiritGear.servicios.IUsuarioServicio;

@Controller
public class UsuarioControlador implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private IParametrosServicio varIParamServicio;	
	
	@Autowired
	private IUsuarioServicio varIUsrServicio;
	
	@Autowired
	private ITallerServicio varITallerServicio;
	
	
	private List<Usuario> detUsuario = new ArrayList<>();
	private List<Parametros> detParamFiltro = new ArrayList<>();
	private List<Taller> detTaller = new ArrayList<>();
	
	@GetMapping("/listarusuarios")
	public String listarUsuarios(Model modeloUsuario) {
		detUsuario = varIUsrServicio.listaOrdenadaUsuario();
		modeloUsuario.addAttribute("listausuarios",detUsuario);
		return ("spiritGear/Usuario");
	}
	
	//para enviar los objetos  a HTML
	@GetMapping("/nuevousuario")
	public String forInsNuevoUsuario(Model modelObjUsuario) {
		Usuario objNuevoUsuario = new Usuario();
		modelObjUsuario.addAttribute("objUsuarioNuevo", objNuevoUsuario);
		//listasdet		
		detParamFiltro = varIParamServicio.listarParamNmonico("IDPERFILES");
		detTaller = varITallerServicio.listaOrdenadaTaller();
		modelObjUsuario.addAttribute("listaTaller", detTaller);
		modelObjUsuario.addAttribute("listaParam", detParamFiltro);
		return("/spiritGear/nuevousuario");
	}

	
	//EDITAR TALLER
	@GetMapping("/editarUsuario/{idUsuarioEditar}")
	public String editarUsuario(@PathVariable(value="idUsuarioEditar") int idUsrEditar, Model objModelUsrEdit) {
		Usuario objUsuario = varIUsrServicio.buscarUsuarioId(idUsrEditar);
		objModelUsrEdit.addAttribute("objUsuarioNuevo", objUsuario);
		//lista de talleres
		detTaller  = varITallerServicio.listaOrdenadaTaller();
		//lista de parametros		
		detParamFiltro = varIParamServicio.listarParamNmonico("IDPERFILES");
		
		objModelUsrEdit.addAttribute("listaTaller", detTaller);
		objModelUsrEdit.addAttribute("listaParam", detParamFiltro);				
		return("/spiritGear/nuevousuario");
	}	
	
	
	@GetMapping("/eliminarUsuario/{idUsuarioDel}")
	public String eliminarObjUsuario(@PathVariable(value="idUsuarioDel") int idUsuarioEliminar) {
		Usuario objUsuario = new Usuario();
		objUsuario.setIDUSUARIO(idUsuarioEliminar);
		varIUsrServicio.borrarUsuarioId(objUsuario);
		return("redirect:/listarusuarios");
	}
	
	//insertar Usuario
	@PostMapping("/insertarUsuario")
	public String ingresarUsuarioNuevo(@ModelAttribute("objUsuarioNuevo") Usuario nuevoUsuarioIns) {
		//if (nuevoUsuarioObj!= null && nuevoUsuarioObj.getIDUSUARIO() > 0) {			
		//	varIUsrServicio.actualizarUsuario(nuevoUsuarioObj);
		//}else {
			//nuevoUsuarioIns.setIDUSUARIO(1);
			//nuevoTallerObj.setESTATUS(1);
			varIUsrServicio.insertarUsuario(nuevoUsuarioIns);
		//}				
		return ("redirect:/listarusuarios");		
	}
}
























