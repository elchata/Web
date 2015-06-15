package com.proyectos.comidasapp.implementaciones;

import org.springframework.stereotype.Repository;
 

import com.proyectos.comidasapp.clases.Categoria;
import com.proyectos.comidasapp.daos.CategoriaDAO;

@Repository(value = "categoriaModel")
public class CategoriaDAOHibernateJPA extends GenericDAOHibernateJPA<Categoria>  implements CategoriaDAO {		
	
		public CategoriaDAOHibernateJPA() {
			super(Categoria.class);
		}

}
