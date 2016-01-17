package ch.bfh.btx8081.w2015.green.doctorGreen.views;

import java.io.File;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;

import ch.bfh.btx8081.w2015.green.doctorGreen.MyUI;

import com.vaadin.ui.HorizontalLayout;

/**
 * This class describes the Guy for GenerivView for all further Views in the Doctor Green Application <br>
 * <br>
 * 
 * @author Sarah Mele<br>
 * <br>
 * 
 *        instance variables:<br>
 *         	- HorizontalLayout layoutHeader<br>
			- HorizontalLayout layoutFooter<br>
			- Button backButton<br>
			- Button homeButton<br>
 * <br>
 * 
 *         Methods:<br>
 *         - getButton(String button) returns Button<br>
 *         - getHeader() returns Button HorizontalLayout<br>
 */

@SuppressWarnings("serial")
@Theme("mytheme")
@Widgetset("ch.bfh.btx8081.w2015.green.doctorGreen.MyAppWidgetset")
public class GenericView extends MyUI{
	
	
	// GenericView Variables
	//--------------------------------------------------------------------------------
	
	HorizontalLayout layoutHeader;
	HorizontalLayout layoutFooter;
	Button backButton;
	Button homeButton;
	
	/**
	 * GenericView constructor<br>
	 * Creates the Guy for this view - for details see comments in the code 
	 * <br>
	 *
	 * @param none
	 */
	public GenericView() {
		
		// layout for header and footer
		layoutHeader = new HorizontalLayout();
		layoutFooter = new HorizontalLayout();

		// Find the application directory for images
		String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
		// Image as a file resource
		FileResource resource = new FileResource(new File(basepath + "/VAADIN/images/doctor_green_small.png"));
		// Make a new Image Object with the Logo
		Image image = new Image("",resource);
		
		//Navigation Buttons on Top --> Back/Home
		backButton = new Button("Back");
		backButton.addStyleName("green");
		
		homeButton = new Button("Home");
		homeButton.addStyleName("green");
		
		//Add all the Elements to the View
		layoutHeader.addComponent(backButton);
		layoutHeader.addComponent(new Label("&nbsp;", ContentMode.HTML));
		layoutHeader.addComponent(new Label("&nbsp;", ContentMode.HTML));
		layoutHeader.addComponent(new Label("&nbsp;", ContentMode.HTML));
		layoutHeader.addComponent(image);
		layoutHeader.addComponent(new Label("&nbsp;", ContentMode.HTML));
		layoutHeader.addComponent(new Label("&nbsp;", ContentMode.HTML));
		layoutHeader.addComponent(new Label("&nbsp;", ContentMode.HTML));
		layoutHeader.addComponent(homeButton);

	}
	
	/**
	 * getButton Method<br>
	 * get your prefered Button (back and home)<br>
	 * <br>
	 * 
	 * @param button - String
	 * @return Button - as prefered (default: back)
	 *           
	 */
	public Button getButton(String button){
		
		// choose back or homeButton
		if (button.equals("back")){
			return backButton;
		}
		else if (button.equals("home")){
			return homeButton;
		}
		else{
			// default
			return backButton;
		}
		
	}
	
	/**
	 * getHeader Method<br>
	 * gets the Generic Header as a layout<br>
	 * <br>
	 * 
	 * @param none 
	 * @return HorizontalLayout - layoutHeader
	 *           
	 */
	public HorizontalLayout getHeader(){
		return layoutHeader;
	}

}

