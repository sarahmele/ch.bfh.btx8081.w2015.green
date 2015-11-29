package ch.bfh.btx8081.w2015.green.doctorGreen;


import javax.servlet.annotation.WebServlet;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.Navigator.ComponentContainerViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import views.HomeView;
import views.LoginView;

/**
 *
 */
@SuppressWarnings("serial")
@Theme("mytheme")
@Widgetset("ch.bfh.btx8081.w2015.green.doctorGreen.MyAppWidgetset")
public class MyUI extends UI {

	public Navigator navigator;

	public static final String HOMEVIEW = "home";
	public static final String LOGINVIEW = "login";
	public static final String CASEVIEW = "caseview";
	public static final String MESSAGEVIEW = "messageview";
	public static final String TREATMENTVIEW = "treatmentview";

	@Override
	protected void init(VaadinRequest request) {
	final VerticalLayout layout = new VerticalLayout();
	layout.setWidth("320");
	layout.setMargin(false);
	layout.setSpacing(false);
	setContent(layout);
	ComponentContainerViewDisplay viewDisplay = new ComponentContainerViewDisplay(layout);
	navigator = new Navigator(UI.getCurrent(), viewDisplay);
	navigator.addView("", new LoginView());
	navigator.addView(HOMEVIEW, new HomeView());

    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {

    }
}
