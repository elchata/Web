package com.proyectos.comidasapp.web;

import java.util.Date; 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod;

import com.proyectos.comidasapp.clases.Categoria;
import com.proyectos.comidasapp.clases.User;
import com.proyectos.comidasapp.service.ProductManager;

@Controller
public class InventoryController {
    
    @Autowired
    private ProductManager productManager;
    
    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }    

    @RequestMapping(value="/hello.htm")
    public String printHello(ModelMap model) {    	
    	String now = (new Date()).toString();
        model.addAttribute("now", now); 
        return "hello";
    }
    
    @RequestMapping(value="/listar.htm")
    public String todosSocios(ModelMap model) { 
        model.addAttribute("categorias",this.productManager.recuperarTodasCategorias());
        model.addAttribute("prod",this.productManager.darProductos());
        return "listar";
    }
    
    @RequestMapping(value="/mostrarProducto.htm")
    public String mostrarProd(HttpServletRequest req, ModelMap model) { 
        Long val = Long.parseLong(req.getParameter("idCat"));
        model.addAttribute("categoria", this.productManager.darCategoria(val)); 
        model.addAttribute("categorias",this.productManager.recuperarTodasCategorias());
        return "verProductos";
    }
    
    @RequestMapping(value="/verCateg.htm")
    public String mostrarCategorias(ModelMap model) { 
        model.addAttribute("categorias",this.productManager.recuperarTodasCategorias());
        return "ABMcategorias";
    }
    
    @RequestMapping(value = "/nuevaCateg.htm", method = RequestMethod.GET)
    public String nuevaCategorias(ModelMap model) { 
    	model.addAttribute("command", new Categoria());
        model.addAttribute("categorias",this.productManager.recuperarTodasCategorias());
        return "editCategoria";
    }
    
    @RequestMapping(value = "/nuevitaCat.htm", method = RequestMethod.POST)
    public String creaCategoria(@ModelAttribute("command") Categoria cat, ModelMap model) { 
    	if (cat.getIdCategoria() != 0) {
    		Categoria papa = this.productManager.darCategoria(cat.getIdCategoria());
    		cat.setPadre(papa);
    	}
    	cat.setIdCategoria(null);    	
    	this.productManager.guardarCategoria(cat);
        model.addAttribute("categorias",this.productManager.recuperarTodasCategorias());
        return "ABMcategorias";
    }
    
    @RequestMapping(value="/editarCat.htm")
    public String verCategorias(HttpServletRequest req, ModelMap model) { 
    	Long val = Long.parseLong(req.getParameter("idCat"));
        model.addAttribute("categoria", this.productManager.darCategoria(val)); 
        return "verCategoria";
    }
    
    @RequestMapping(value="/eliminarCat.htm")
    public String eliminarCategoria(HttpServletRequest req, ModelMap model) { 
    	Long val = Long.parseLong(req.getParameter("idCat"));
    	/* borra directamente buscando la entidad involucrada
        	Categoria aux = this.productManager.darCategoria(val);    	
    		this.productManager.borrarCategoria(aux); */
    	
    	// borra por medio de id
    	this.productManager.borrarCategoria(val);
    	
        model.addAttribute("categorias", this.productManager.recuperarTodasCategorias()); 
        return "ABMcategorias";
    }
    
    @RequestMapping(value="/verProdCat.htm")
    public String verProductos(HttpServletRequest req, ModelMap model) { 
    	Long val = Long.parseLong(req.getParameter("idCat"));
        model.addAttribute("categoria", this.productManager.darCategoria(val)); 
        return "verProductos";
    }
    
    @RequestMapping(value="/verPedidos.htm")
    public String mostrarPedidos(ModelMap model) { 
        model.addAttribute("pedidos",this.productManager.darPedidos());
        return "verPedidos";
    }
    
    @RequestMapping(value="/login.htm")
    public String login(ModelMap model) { 
        return "iniciarSesion";
    }
    
    @RequestMapping(value="/salir.htm")
    public String salir(HttpServletRequest req, ModelMap model) { 
    	req.getSession().invalidate();
    	model.addAttribute("pedidos",this.productManager.darPedidos());
        return "verPedidos";
    }
    
    @RequestMapping(value="/inicio.htm")
    public String confirmar(HttpServletRequest req, ModelMap model) { 
    	
        String usuario= req.getParameter("usuario");
        String password= req.getParameter("password");
        
        if(usuario.equalsIgnoreCase("elchata5") &&  password.equalsIgnoreCase("bilardo")){
        	User user= new User();
        	user.setNombre(usuario);
        	user.setPassword(password);
        	HttpSession misession= req.getSession(true);     
        	misession.setAttribute("usuario",user);
        	model.addAttribute("pedidos",this.productManager.darPedidos());
        	return "verPedidos";
        }else{
        	
            model.addAttribute("mensaje", "Error Login Incorrecto!");
            
        }    return "iniciarSesion";            
        
    }
}