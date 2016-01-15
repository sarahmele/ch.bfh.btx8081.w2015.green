package ch.bfh.btx8081.w2015.green.doctorGreen.views;

import java.util.Date;
import java.util.GregorianCalendar;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.btx8081.w2015.green.doctorGreen.MyUI;

import com.vaadin.ui.Calendar;
import com.vaadin.ui.HorizontalLayout;
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
		
		// layout for footer
		HorizontalLayout layoutFooter = new HorizontalLayout();

		// Make a new Calendar - Date Today - Hours of the Day seen 7.00am - 5.00pm
		Calendar cal = new Calendar();
		cal.setStartDate(new Date());
		cal.setEndDate(new Date());
		cal.setFirstVisibleHourOfDay(7);
		cal.setLastVisibleHourOfDay(17);
		
		//Set EventHandler to the Calendar - if you Click on an Event, a new View is Opened
		cal.setHandler(new CalendarComponentEvents.EventClickHandler() {
			@Override
		    public void eventClick(EventClick event) {
		        getUI().getNavigator().navigateTo(MyUI.PATIENTVIEW);
		    }
		});
		
		
		// Add two events for today
		GregorianCalendar start = new GregorianCalendar();
		GregorianCalendar end   = new GregorianCalendar();
		start.set(2016, 01, 21, 9, 00);
		end.set(2016, 01, 21, 11, 00);
		cal.addEvent(new BasicEvent("John Teller",
				       "Watch the Case of John Teller",
				        start.getTime(), end.getTime()));
		
		start.set(2016, 01, 21, 13, 00);
		end.set(2016, 01, 21, 15, 00);
		cal.addEvent(new BasicEvent("Marlis Müller",
				       "Watch the Case of Marlis Müller",
				        start.getTime(), end.getTime()));
		
		//Button to enter SearchView
		Button patientSearchButton = new Button("Search", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.PATIENTSEARCHVIEW);
			}
		});
		patientSearchButton.addStyleName("green");
		
		//Button for Vladi to watch the PatientView --> IMPORTANT: DELETE, WHEN IMPLEMENTED
		Button patientViewButton = new Button("Case", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.CASEVIEW);
			}
		});
		patientViewButton.addStyleName("green");
		
		
		// make the Footer
		layoutFooter.addComponent(patientViewButton);
		layoutFooter.addComponent(new Label("&nbsp;", ContentMode.HTML));
		layoutFooter.addComponent(patientSearchButton);
		
		// get the Header
		GenericView header = new GenericView();
		HorizontalLayout layoutHeader = header.getHeader();
		
		// Back Button is Logout Button in this View
		header.getButton("back").setCaption("Logout");
		header.getButton("back").addClickListener(new Button.ClickListener() {
			@Override
		    public void buttonClick(ClickEvent event) {
		        getUI().getNavigator().navigateTo(MyUI.LOGINVIEW);
		    }
		});
		
		// no home Button in this View
		header.getButton("home").setVisible(false);
		
		// add all components to the Layout
		addComponent(layoutHeader);
		addComponent(cal);
		addComponent(layoutFooter);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		//Notification.show("Welcome! This is Home.");
	}
	

}

