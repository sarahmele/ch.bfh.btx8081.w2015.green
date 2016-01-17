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
import ch.bfh.btx8081.w2015.green.doctorGreen.views.*;

/**
 * This class is a Wrapper Class for all GUIS in the Doctor Green Application <br>
 * <br>
 * 
 * @author Sarah Mele<br>
 * <br>
 * 
 *         instance variables:<br>
 *         - String CASEVIEW<br>
 *         - String HOMEVIEW<br>
 *         - String LOGINVIEW<br>
 *         - String MESSAGEVIEW<br>
  *        - String PATIENTSEARCHVIEW<br>
 *         - String PATIENTVIEW<br>
 *         - Navigator navigator<br>
 * <br>
 * 
 *         Methods:<br>
 *         - init(VaadinRequest) no return value<br>
 */

@SuppressWarnings("serial")
@Theme("mytheme")
@Widgetset("ch.bfh.btx8081.w2015.green.doctorGreen.MyAppWidgetset")
public class MyUI extends UI {
	
	// MyUI Variables
	//--------------------------------------------------------------------------------
	public Navigator navigator;

	// Defining all views
	public static final String LOGINVIEW = "login";
	public static final String HOMEVIEW = "home";
	public static final String PATIENTSEARCHVIEW = "patientSearch";
	public static final String CASEVIEW = "case";
	public static final String PATIENTVIEW = "patient";
	public static final String MESSAGEVIEW = "message";

	/**
	 * init Method<br>
	 * Initializes Vaadin GUI <br>
	 * <br>
	 * 
	 * @param request - VaadinRequest
	 *           
	 */
	@Override
	// Init Vaadin
	protected void init(VaadinRequest request) {
		
	// Set the main layout
	final VerticalLayout layout = new VerticalLayout();
	layout.setWidth("320");
	layout.setMargin(false);
	layout.setSpacing(false);
	setContent(layout);
	ComponentContainerViewDisplay viewDisplay = new ComponentContainerViewDisplay(layout);
	
	// Create the Navigator to switch between Views
	navigator = new Navigator(UI.getCurrent(), viewDisplay);
	navigator.addView("", new LoginView());
	navigator.addView(LOGINVIEW, new LoginView());
	navigator.addView(HOMEVIEW, new HomeView());
	navigator.addView(CASEVIEW, new CaseView());
	navigator.addView(PATIENTSEARCHVIEW, new PatientSearchView());
	navigator.addView(PATIENTVIEW, new PatientView());

    }

	/**
	 * MyUIServlet class<br>
	 * Starts the VaadinServlet <br>
	 *           
	 */
    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {

    }
}
