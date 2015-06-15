package com.proyectos.comidasapp.implementaciones;

import org.springframework.stereotype.Repository; 
import com.proyectos.comidasapp.clases.Pedido; 
import com.proyectos.comidasapp.daos.PedidoDAO;

@Repository(value = "pedidoModel")
public class PedidoDAOHibernateJPA extends GenericDAOHibernateJPA<Pedido>  implements PedidoDAO {		
	
		public PedidoDAOHibernateJPA() {
			super(Pedido.class);
		}

}
