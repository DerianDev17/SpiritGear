	package com.uisrael.SpiritGear.modelo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


import com.uisrael.SpiritGear.modelo.entidades.Taller;


@Repository
@Component
public interface ITallerRepositorio extends JpaRepository<Taller, Integer> {
	
	@Query("Select t from Taller t where t.NMONICOTALLER like %?1%")
	public List<Taller> listarTallerNmonico(String inmonico);
	
	@Query("Select t from Taller t order by t.IDTALLER")
	public List<Taller> listaOrdenadaTaller();

	@Query("Select t from Taller t where t.IDTALLER = ?1")
	public Taller buscarTallerId(int iIdTallerBuscar);
	
	@Query("Select tl from Taller tl where tl.IDTALLER = ?1")
	public List<Taller> listaBuscarTallerId(int idListTaller);

}
