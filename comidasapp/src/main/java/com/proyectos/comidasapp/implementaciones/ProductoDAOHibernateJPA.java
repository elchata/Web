package com.proyectos.comidasapp.implementaciones;

import org.springframework.stereotype.Repository;
 

import com.proyectos.comidasapp.clases.Producto;
import com.proyectos.comidasapp.daos.ProductoDAO;

@Repository(value = "productoModel")
public class ProductoDAOHibernateJPA extends GenericDAOHibernateJPA<Producto>  implements ProductoDAO {		
	
		public ProductoDAOHibernateJPA() {
			super(Producto.class);
		}

}
