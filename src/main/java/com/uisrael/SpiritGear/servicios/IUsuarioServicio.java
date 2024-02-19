package com.uisrael.SpiritGear.servicios;

import java.util.List;


import com.uisrael.SpiritGear.modelo.entidades.Usuario;



public interface IUsuarioServicio {

	public void insertarUsuario(Usuario nuevoUsuario);
		
	public List<Usuario> listaOrdenadaUsuario();
	
	public List<Usuario> listarUsuarioApellido(String iapellido);
	
	public Usuario buscarUsuarioId(int iIdUsuarioBuscar);
	
	public void actualizarUsuario(Usuario nuevoUsuario);

	public int borrarUsuarioId(Usuario objBorraUsuario);
}
