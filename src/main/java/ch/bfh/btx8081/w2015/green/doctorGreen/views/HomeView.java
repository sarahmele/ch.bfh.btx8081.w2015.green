package ch.bfh.btx8081.w2015.green.doctorGreen.views;

import java.io.File;
import java.util.Date;
import java.util.GregorianCalendar;

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
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.components.calendar.CalendarComponentEvents;
import com.vaadin.ui.components.calendar.CalendarComponentEvents.EventClick;
import com.vaadin.ui.components.calendar.event.BasicEvent;

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
		cal.setFirstVisibleHourOfDay(7);
		cal.setLastVisibleHourOfDay(17);
		
		//cal.setHandler(new );
		
		cal.setHandler(new CalendarComponentEvents.EventClickHandler() {
			@Override
		    public void eventClick(EventClick event) {
		     //   BasicEvent e = (BasicEvent) event.getCalendarEvent();

		        // Do something with it
		        getUI().getNavigator().navigateTo(MyUI.PATIENTVIEW);
		        
		        /*Do something with it
		        new Notification("Event clicked: " + e.getCaption(),
		                e.getDescription()).show(Page.getCurrent());*/
		    }
		});
		
		
		// Add two events
		GregorianCalendar start = new GregorianCalendar();
		GregorianCalendar end   = new GregorianCalendar();
		start.set(2015, 11, 16, 9, 00);
		end.set(2015, 11, 16, 11, 00);
		cal.addEvent(new BasicEvent("John Teller",
				       "Watch the Case of John Teller",
				        start.getTime(), end.getTime()));
		
		start.set(2015, 11, 14, 13, 00);
		end.set(2015, 11, 14, 15, 00);
		cal.addEvent(new BasicEvent("Marlis Müller",
				       "Watch the Case of Marlis Müller",
				        start.getTime(), end.getTime()));
		
		
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
		backButton.addStyleName("green");
		
		Button homeButton = new Button("Home", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.HOMEVIEW);
			}
		});
		homeButton.addStyleName("green");
		
		Button patientView_Button = new Button("Case", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.CASEVIEW);
			}
		});
		
		layoutHeader.addComponent(backButton);
		layoutHeader.setComponentAlignment(backButton,Alignment.TOP_CENTER);
		layoutHeader.addComponent(image);
		layoutHeader.setComponentAlignment(image,Alignment.TOP_CENTER);
		
		layoutHeader.addComponent(homeButton);
		layoutHeader.setComponentAlignment(homeButton,Alignment.TOP_CENTER);
		
		layoutFooter.addComponent(patientView_Button);
		
		addComponent(layoutHeader);
		addComponent(cal);
		addComponent(layoutFooter);
		setComponentAlignment(cal,Alignment.MIDDLE_CENTER);
	
		
		
		
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		//Notification.show("Welcome! This is Home.");
	}
	

}

