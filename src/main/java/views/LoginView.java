package views;

import java.io.File;
import com.vaadin.annotations.Theme;

import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2015.green.doctorGreen.MyUI;

@SuppressWarnings("serial")
@Theme("mytheme")
@Widgetset("ch.bfh.btx8081.w2015.green.doctorGreen.MyAppWidgetset")
public class LoginView extends VerticalLayout implements View {
	
	public LoginView() {
		setSizeFull();
		setSpacing(true);
		
		// Find the application directory
		String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
		 // Image as a file resource
        FileResource resource = new FileResource(new File(basepath + "/VAADIN/images/doctor_green.png"));
        // Show the image in the application
        Image image = new Image("",resource);
        
        TextField username = new TextField("Username");
		PasswordField password = new PasswordField("Password");
		// Put some initial content in it
		password.setValue("Doctor Green");
		
		addComponent(image);
		addComponent(new Label("&nbsp;", ContentMode.HTML));
		addComponent(username);
		addComponent(new Label("&nbsp;", ContentMode.HTML));
		addComponent(password);
		addComponent(new Label("&nbsp;", ContentMode.HTML));
		addComponent(loginButton());
	}
	
	
	private Button loginButton() {
		Button button = new Button("Log In", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.HOMEVIEW);
			}
		});
		return button;
	}	

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("Welcome! Please log in.");
	}
	
}
	
