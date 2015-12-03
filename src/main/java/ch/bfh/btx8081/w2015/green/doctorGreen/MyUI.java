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

import ch.bfh.btx8081.w2015.green.views.CaseView;
import ch.bfh.btx8081.w2015.green.views.HomeView;
import ch.bfh.btx8081.w2015.green.views.LoginView;
import ch.bfh.btx8081.w2015.green.views.TreatmentView;

/**
 *
 */
@SuppressWarnings("serial")
@Theme("mytheme")
@Widgetset("ch.bfh.btx8081.w2015.green.doctorGreen.MyAppWidgetset")
public class MyUI extends UI {

	public Navigator navigator;

	// Defining all views
	public static final String LOGINVIEW = "login";
	public static final String HOMEVIEW = "home";
	public static final String SEARCHVIEW = "search";
	public static final String CASEVIEW = "case";
	public static final String PATIENTVIEW = "patient";
	public static final String MESSAGEVIEW = "message";

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
	navigator.addView(LOGINVIEW, new LoginView());
	navigator.addView(HOMEVIEW, new HomeView());
	navigator.addView(CASEVIEW, new CaseView());
	//navigator.addView(PATIENTVIEW, new PatientView());

    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {

    }
}
