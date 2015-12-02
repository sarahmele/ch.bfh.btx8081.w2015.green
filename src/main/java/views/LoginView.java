package views;

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
import controller.LogAuthor;

@SuppressWarnings("serial")
@Theme("mytheme")
@Widgetset("ch.bfh.btx8081.w2015.green.doctorGreen.MyAppWidgetset")
public class LoginView extends VerticalLayout implements View {
	
	private TextField username;
	private PasswordField password;
	private String MyResult = null;

	
	public LoginView() {
		setSizeFull();
		setSpacing(true);
		
		// Find the application directory
		String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
		 // Image as a file resource
        FileResource resource = new FileResource(new File(basepath + "/VAADIN/images/doctor_green.png"));
        // Show the image in the application
        Image image = new Image("",resource);
        
        // Username and Password
        username = new TextField("Username");
		password = new PasswordField("Password");
		// Put some initial content in it
		// password.setValue("Doctor Green");
		
		Button loginButton = loginButton();
		
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
	
	
	private Button loginButton() {
		Button button = new Button("Log In", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				System.out.println("value:"+username.getValue());
				
				/*final String MyLog = username.getValue();
				final String MyPass = password.getValue();
				LogAuthor logAuthor = new LogAuthor();
				logAuthor.CheckAcces(MyLog, MyPass);

				MyResult = logAuthor.getResult();

				if (MyResult == "true"){ 
				*/
				
				getUI().getNavigator().navigateTo(MyUI.HOMEVIEW);
				/*}
				else { Notification.show("Login is not correct.");
			}*/
		}});
		return button;
	}	

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("Welcome! Please log in.");
	}
	
}
	
