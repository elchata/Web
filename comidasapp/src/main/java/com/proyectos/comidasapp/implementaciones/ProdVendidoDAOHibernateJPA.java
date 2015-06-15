package com.proyectos.comidasapp.implementaciones;

import org.springframework.stereotype.Repository; 
import com.proyectos.comidasapp.clases.ProdVendido; 
import com.proyectos.comidasapp.daos.ProdVendidoDAO; 

@Repository(value = "prodVendidoModel")
public class ProdVendidoDAOHibernateJPA extends GenericDAOHibernateJPA<ProdVendido>  implements ProdVendidoDAO {		
	
		public ProdVendidoDAOHibernateJPA() {
			super(ProdVendido.class);
		}

}
