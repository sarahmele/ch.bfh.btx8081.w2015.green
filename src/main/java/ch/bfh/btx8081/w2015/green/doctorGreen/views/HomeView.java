package ch.bfh.btx8081.w2015.green.doctorGreen.views;

import java.io.File;
import java.util.Date;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Image;
import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.btx8081.w2015.green.doctorGreen.MyUI;

import com.vaadin.ui.Calendar;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

/**
 *
 */
@SuppressWarnings("serial")
@Theme("mytheme")
@Widgetset("ch.bfh.btx8081.w2015.green.doctorGreen.MyAppWidgetset")
public class HomeView extends VerticalLayout implements View {
	
	public HomeView() {
		setSizeFull();
		setSpacing(true);
		
		// layout for header and footer
		HorizontalLayout layoutHeader = new HorizontalLayout();
		HorizontalLayout layoutFooter = new HorizontalLayout();

		Calendar cal = new Calendar("Patient-Calendar");
		cal.setStartDate(new Date());
		cal.setEndDate(new Date());
		
		// Find the application directory
		String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
		// Image as a file resource
		FileResource resource = new FileResource(new File(basepath + "/VAADIN/images/doctor_green_small.png"));
		// Show the image in the application
		Image image = new Image("",resource);
		
		Button backButton = new Button("Back", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.LOGINVIEW);
			}
		});
		
		Button homeButton = new Button("Home", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.HOMEVIEW);
			}
		});
		
		Button caseView_Button = new Button("Case", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.CASEVIEW);
			}
		});
		
		Button patientView_Button = new Button("Patient", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.PATIENTVIEW);
			}
		});
		
		layoutHeader.addComponent(backButton);
		layoutHeader.addComponent(image);
		layoutHeader.addComponent(homeButton);
		layoutFooter.addComponent(caseView_Button);
		layoutFooter.addComponent(patientView_Button);
		
		addComponent(layoutHeader);
		addComponent(cal);
		addComponent(layoutFooter);
		setComponentAlignment(cal,Alignment.MIDDLE_CENTER);
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("Welcome! This is Home.");
	}
	

}

