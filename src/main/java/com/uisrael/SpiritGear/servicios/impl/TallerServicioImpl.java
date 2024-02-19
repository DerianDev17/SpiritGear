package com.uisrael.SpiritGear.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uisrael.SpiritGear.modelo.entidades.Taller;
import com.uisrael.SpiritGear.modelo.repositorio.ITallerRepositorio;
import com.uisrael.SpiritGear.servicios.ITallerServicio;



@Service
@Component

public class TallerServicioImpl implements ITallerServicio {

	@Autowired
	private ITallerRepositorio varTallerRepositorio;
	
	@Override
	//@Transactional
	public void insertarTaller(Taller nuevoTaller) {
		// TODO Auto-generated method stub
		try {
			varTallerRepositorio.save(nuevoTaller);	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: " + e.getMessage());
		}
	}

	@Override
	public List<Taller> listarTaller() {
		// TODO Auto-generated method stub
		return varTallerRepositorio.findAll();
	}

	@Override
	public List<Taller> listarTallerNmonico(String inmonico) {
		// TODO Auto-generated method stub
		return varTallerRepositorio.listarTallerNmonico(inmonico);
	}

	@Override
	public List<Taller> listaOrdenadaTaller() {
		// TODO Auto-generated method stub
		return varTallerRepositorio.listaOrdenadaTaller();
	}

	@Override
	public Taller buscarTallerId(int iIdTallerBuscar) {
		// TODO Auto-generated method stub
		return varTallerRepositorio.buscarTallerId(iIdTallerBuscar) ;
	}

	@Override
	public void actualizarTaller(Taller nuevoTaller) {
	    // Check if the Taller exists in the database
        Taller existeTaller;
		try {
			existeTaller = varTallerRepositorio.buscarTallerId(nuevoTaller.getIDTALLER());
			    
			if (existeTaller!= null) {

	        // Update the existing Taller with new data
			
			existeTaller.setNMONICOTALLER( nuevoTaller.getNMONICOTALLER());
			existeTaller.setESTATUS( nuevoTaller.getESTATUS());
			existeTaller.setCALLEPRINCIPAL( nuevoTaller.getCALLEPRINCIPAL());
			existeTaller.setCALLESEGUNDARIA( nuevoTaller.getCALLESEGUNDARIA());
			
	
			existeTaller.setNUMEROUBICA( nuevoTaller.getNUMEROUBICA());
			existeTaller.setDESCRIPTALLER( nuevoTaller.getDESCRIPTALLER());

			}
        // Set other fields from 'taller' to 'existingTaller' as needed

        varTallerRepositorio.save(existeTaller);
        
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int actualizaEstatusTaller(Taller iObjEstatusTaller) {
		// TODO Auto-generated method stub
		Taller existeTaller;
		try {
			existeTaller = varTallerRepositorio.buscarTallerId(iObjEstatusTaller.getIDTALLER());
			if (existeTaller!= null) {
				existeTaller.setESTATUS(0);
				varTallerRepositorio.save(existeTaller);
			}
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public List<Taller> listaBuscarTallerId(int iIdListTaller) {
		// TODO Auto-generated method stub
		return varTallerRepositorio.listaBuscarTallerId(iIdListTaller);
	}
	
	
	

	

}