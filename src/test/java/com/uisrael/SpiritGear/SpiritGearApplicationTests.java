package com.uisrael.SpiritGear;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.uisrael.SpiritGear.servicios.ITallerServicio;
import com.uisrael.SpiritGear.servicios.IUsuarioServicio;

@SpringBootTest
class SpiritGearApplicationTests {

	@Autowired
	IUsuarioServicio varServicioUsuario;
	
	@Autowired
	ITallerServicio varServicioTaller;
	
	@Test
	void contextLoads() {
	//Taller nuevo = new Taller();
	//nuevo.setNMONICATALLER("TRLL03");
	//nuevo.setCALLEPRINCIPAL("10 de Agosto");
	//nuevo.setCALLESEGUNDARIA("Atahualpa");
	//nuevo.setNUMEROUBICA("N34-896");
	//nuevo.setDESCRIPTALLER("PruebaTres");
	
	//varServicioTaller.insertarTaller(nuevo);
	
		
		
	}

}
