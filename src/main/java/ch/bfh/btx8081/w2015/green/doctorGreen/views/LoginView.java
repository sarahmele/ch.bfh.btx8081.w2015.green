package ch.bfh.btx8081.w2015.green.doctorGreen.views;

import java.io.File;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2015.green.doctorGreen.MyUI;
import ch.bfh.btx8081.w2015.green.doctorGreen.controller.LogAuthorDB;

/**
 * This class describes the Guy for Login in the Doctor Green Application <br>
 * <br>
 * 
 * @author Sarah Mele<br>
 * <br>
 * 
 *         instance variables:<br>
 *         - TextField username<br>
 *         - PasswordField password<br>
 *         - String MyResult<br>
 * <br>
 * 
 *         Methods:<br>
 *         - loginButton() returns Button<br>
 *         - enter(ViewChangeEvent event) no return value<br>
 */

@SuppressWarnings("serial")
@Theme("mytheme")
@Widgetset("ch.bfh.btx8081.w2015.green.doctorGreen.MyAppWidgetset")
public class LoginView extends VerticalLayout implements View {
	
	// Login Variables
	//--------------------------------------------------------------------------------
	private TextField username;
	private PasswordField password;
	private String MyResult = null;

	/**
	 * LoginView constructor<br>
	 * Creates the Guy for this view - for details see comments in the code 
	 * <br>
	 *
	 * @param none
	 */
	public LoginView() {
		setSizeFull();
		setSpacing(true);
		
		// Find the application directory
		String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
		 // Image as a file resource
        FileResource resource = new FileResource(new File(basepath + "/VAADIN/images/doctor_green.png"));
        // Show the image in the application
        Image image = new Image("",resource);
        
        // Username and Password - Fields
        username = new TextField("Username");
		password = new PasswordField("Password");
		
		// Create the Login Button with its functionality
		Button loginButton = loginButton();
		
		// add all components to the Layout
		addComponent(image);
		setComponentAlignment(image,Alignment.TOP_CENTER);
		addComponent(new Label("&nbsp;", ContentMode.HTML));
		addComponent(username);
		setComponentAlignment(username,Alignment.MIDDLE_CENTER);
		addComponent(new Label("&nbsp;", ContentMode.HTML));
		addComponent(password);
		setComponentAlignment(password,Alignment.MIDDLE_CENTER);
		addComponent(new Label("&nbsp;", ContentMode.HTML));
		addComponent(loginButton);
		setComponentAlignment(loginButton,Alignment.BOTTOM_CENTER);
	}
	
	/**
	 * loginButton Method<br>
	 * Creates the Login Button and adds its functionality<br>
	 * <br>
	 * 
	 * @param none
	 * @return Button - loginButton
	 *           
	 */
	private Button loginButton() {
		
		// Create a new Button
		Button button = new Button("Log In", new Button.ClickListener() {
			@Override
			
			// Click functionality
			public void buttonClick(ClickEvent event) {
				
				// get the Values from the User
				final String MyLog = username.getValue();
				final String MyPass = password.getValue();
				
				// check the Acces for the given Doctor
				LogAuthorDB logAuthor = new LogAuthorDB();
				logAuthor.CheckAcces(MyLog, MyPass);

				MyResult = logAuthor.getResult();

				if (MyResult == "true"){ 
				getUI().getNavigator().navigateTo(MyUI.HOMEVIEW);
				}
				else { Notification.show("Login is not correct.");
				System.out.println(MyResult);
			}
		}});
		
		// return the loginButton
		return button;
	}	

	/**
	 * enter Method<br>
	 * Overriding the enter Method from Superclass <br>
	 * 
	 * @param event - ViewChangeEvent
	 */
	@Override
	public void enter(ViewChangeEvent event) {
		
		// Welcome the Doctor
		Notification.show("Welcome Doctor! Please log in.");
	}
	
}
	
