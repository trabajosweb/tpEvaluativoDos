package org.servicio;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.PropertyModel;
import org.dominio.Equipo;
import org.repositorio.IRepositorio;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ServicioEquipo extends WebPage {
	
	ApplicationContext context = new AnnotationConfigApplicationContext(
			ClaseConfiguracion.class);
	IRepositorio repositorio = (IRepositorio) context.getBean("RepositorioEquipo");
	
	
	public  void guardar(Equipo equipo){
		
		repositorio.guardar(equipo);
	}
	public List listar(){
		return repositorio.listar();
		
	}
	}
