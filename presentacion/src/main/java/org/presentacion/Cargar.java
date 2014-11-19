package org.presentacion;



import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.dominio.Equipo;
import org.servicio.ServicioEquipo;

public class Cargar extends WebPage {
	ServicioEquipo servicio= new ServicioEquipo();
	private TextField nombre;
	private TextField apellido;
	private List listaPosiciones = Arrays.asList(new String[] {"Arquero","Defensor","Medio Campista","Delantero"});
	private DropDownChoice posicion;
	private List listaEquipos = Arrays.asList(new String[] {"Boca","River","Independiente","Racing"});
	private DropDownChoice nombreEquipo;
	
	private PropertyModel nombreModelo;
	private PropertyModel apellidoModelo;
	private PropertyModel posicionModelo;
	private PropertyModel nombreEquipoModelo;
	
	public Cargar() {
		add(new Navegacion("navegacion"));
		final Equipo equipo = new Equipo();
		nombreModelo = new PropertyModel(equipo,"jugador.nombre");
		apellidoModelo = new PropertyModel(equipo,"jugador.apellido");
		posicionModelo= new PropertyModel(equipo,"jugador.posicion");
		nombreEquipoModelo = new PropertyModel(equipo, "nombre");
		 
		nombre = new TextField<String>("nombre",nombreModelo);
		apellido = new TextField<String>("apellido",apellidoModelo);
		posicion = new DropDownChoice("posicion",posicionModelo,listaPosiciones);
		nombreEquipo= new DropDownChoice("nombreEquipo",nombreEquipoModelo,listaEquipos);
		Form formulario = new Form("formCargar") {
			@Override
			public void onSubmit() {
				servicio.guardar(equipo);
				setResponsePage(new HomePage());
			}
		};
		
		formulario.add(nombre);
		formulario.add(apellido);
		formulario.add(posicion);
		formulario.add(nombreEquipo);
		add(formulario);
}
}
