package views;

import java.io.File;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 *
 */
@Theme("mytheme")
@Widgetset("ch.bfh.btx8081.w2015.green.doctorGreen.MyAppWidgetset")
public class HomeView extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);
        
        // Find the application directory
        String basepath = VaadinService.getCurrent()
                          .getBaseDirectory().getAbsolutePath();
        
        System.out.println(basepath);

        // Image as a file resource
        FileResource resource = new FileResource(new File(basepath +
                                "/VAADIN/images/doctor_green_small.png"));

        // Show the image in the application
        Image image = new Image("",resource);
        
        
        TextField usernameTextfield = new TextField("Username");
        PasswordField passwordDoctor = new PasswordField("Password");
       
        // Put some initial content in it
        usernameTextfield.setValue("Doctor Green");
  
        Button loginButton = new Button("Login");
        loginButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
            	Notification.show("Wrong Login");
            }
        });
        layout.addComponent(image);
        layout.addComponent(new Label("&nbsp;", ContentMode.HTML));
        layout.addComponent(usernameTextfield);
        layout.addComponent(new Label("&nbsp;", ContentMode.HTML));
        layout.addComponent(passwordDoctor);
        layout.addComponent(new Label("&nbsp;", ContentMode.HTML));
        layout.addComponent(loginButton);

    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = HomeView.class, productionMode = false)
    public static class LoginUIServlet extends VaadinServlet {
    }
}

