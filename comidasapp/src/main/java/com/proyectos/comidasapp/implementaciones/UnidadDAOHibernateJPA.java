package com.proyectos.comidasapp.implementaciones;

import org.springframework.stereotype.Repository;
 

import com.proyectos.comidasapp.clases.Unidad;
import com.proyectos.comidasapp.daos.UnidadDAO;

@Repository(value = "unidadHome")
public class UnidadDAOHibernateJPA extends GenericDAOHibernateJPA<Unidad>  implements UnidadDAO {		
	
		public UnidadDAOHibernateJPA() {
			super(Unidad.class);
		}

}
