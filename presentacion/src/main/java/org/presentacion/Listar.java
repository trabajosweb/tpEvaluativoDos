package org.presentacion;
import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.dominio.Equipo;
import org.servicio.ServicioEquipo;


public class Listar extends WebPage{

	ServicioEquipo servicio= new ServicioEquipo();
	public Listar() {
		add(new Navegacion("navegacion"));
		List<Equipo> equipos = new ArrayList<Equipo>();
		equipos= servicio.listar();
		ListDataProvider<Equipo> listDataProvider = new ListDataProvider<Equipo>(equipos);
		DataView<Equipo> dataView = new DataView<Equipo>("filas", listDataProvider) {

		  @Override
		  protected void populateItem(Item<Equipo> item) {
		   Equipo equipo = item.getModelObject();
		    RepeatingView repeatingView = new RepeatingView("datosFila");

		    repeatingView.add(new Label(repeatingView.newChildId(), equipo.getNombre()));
		    repeatingView.add(new Label(repeatingView.newChildId(), equipo.getJugador().getNombre()));
		    repeatingView.add(new Label(repeatingView.newChildId(), equipo.getJugador().getApellido()));    
		    repeatingView.add(new Label(repeatingView.newChildId(), equipo.getJugador().getPosicion()));
		    item.add(repeatingView); 
		  }
		};
		add(dataView);
		
}
	


}