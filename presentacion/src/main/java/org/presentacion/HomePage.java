package org.presentacion;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage() {
		add(new Navegacion("navegacion"));
    }
}
