package com.uisrael.SpiritGear.servicios.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uisrael.SpiritGear.dto.ConsultaDisponibilidadDTO;
import com.uisrael.SpiritGear.dto.ConsultaJefeTallerDTO;
import com.uisrael.SpiritGear.modelo.repositorio.ICabOrdenRepositorio;





@Service
@Component
//public class CabOrdenServicioImpl implements ICabOrdenServicio{
public class CabOrdenServicioImpl{

	@Autowired
	private ICabOrdenRepositorio varICabOrdenRepositorio;
	
		
	public List<ConsultaJefeTallerDTO> getDatosConsulta(){
		List<Object[]> results = varICabOrdenRepositorio.reporteUsoTiempo();
		List<ConsultaJefeTallerDTO> dtos = new ArrayList<>();
		for(Object[] result : results) {
			dtos.add(new ConsultaJefeTallerDTO(
					((Integer) result[0]).intValue(),
					(String) result[1],
					((Integer) result[2]).intValue(),
					(String) result[3],
					((Integer) result[4]).intValue(),
					(String) result[5],
					(Date) result[6],
					(Date) result[7],
					((Integer) result[8]).intValue()
			));	
		}
		return dtos;
	}
	
	@Transactional(readOnly = true)
	public List<ConsultaDisponibilidadDTO> getDatosDisponible(){
		List<Object[]> results = varICabOrdenRepositorio.sp_GeneraDisponibilidad();
		List<ConsultaDisponibilidadDTO> dtos = new ArrayList<>();
		for(Object[] result : results) {
			dtos.add(new ConsultaDisponibilidadDTO(
					((Integer) result[0]).intValue(),
					(String) result[1],
					(String) result[2],
					(String) result[3],
					(String) result[4],
					(String) result[5],
					(String) result[6]
			));	
		}
		return dtos;		
	}
}
