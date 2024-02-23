package com.uisrael.SpiritGear.controlador;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uisrael.SpiritGear.modelo.entidades.Usuario;
import com.uisrael.SpiritGear.servicios.IUsuarioServicio;

import jakarta.servlet.http.HttpSession;

@Controller
public class IndexControlador implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
    private IUsuarioServicio usuarioServicio;
	
	@GetMapping("index")
	public String iniciaPrincipal(HttpSession session) {
		// Usuario usuarioEncontrado = (Usuario) session.getAttribute("usuarioEncontrado");
		return("/plantilla/plantillaPrincipal");
	}
	
	@GetMapping("login")
	public String iniciaLogin() {
		return("/spiritGear/login");
	}
	
	@PostMapping("/Ilogin")
	public String processLogin(@RequestParam("usuario") String usuario,
	                           @RequestParam("contrasena") String contrasena,
	                           RedirectAttributes attributes,
	                           HttpSession session) {
	    // Lógica de autenticación
	    Usuario usuarioEncontrado = usuarioServicio.buscarUsuarioNombre(usuario); // Corregido
	    if (usuarioEncontrado != null && usuarioEncontrado.getCLAVEUSR().equals(contrasena)) {
	        
	        String perfil = usuarioEncontrado.getCODPERFIL();
	        session.setAttribute("usuarioEncontrado", usuarioEncontrado); // Almacenar usuarioEncontrado en la sesión
	        
	        if ("PRF002".equals(perfil) || "PRF001".equals(perfil) || "PRF003".equals(perfil)) {
	            return "redirect:/index"; // Redirigir a la página correspondiente al perfil
	        } else {
	            return "redirect:/"; // Redirigir a la página principal por defecto
	        }
	    } else {
	        // Autenticación fallida, mostrar mensaje de error y redirigir de nuevo al formulario de inicio de sesión
	        attributes.addFlashAttribute("error", "Usuario o contraseña incorrectos");
	        return "redirect:/login";
	    }
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
	    session.invalidate();
	    return "redirect:/login";
	}



}
