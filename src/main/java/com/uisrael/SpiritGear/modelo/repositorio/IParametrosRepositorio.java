package com.uisrael.SpiritGear.modelo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.uisrael.SpiritGear.modelo.entidades.Parametros;


@Repository
@Component
public interface IParametrosRepositorio extends JpaRepository<Parametros, Integer> {

	@Query("Select p from Parametros p where p.NMONICOPARAMETRO = ?1")
	public List<Parametros> listarParamNmonico(String inmonico);

}
