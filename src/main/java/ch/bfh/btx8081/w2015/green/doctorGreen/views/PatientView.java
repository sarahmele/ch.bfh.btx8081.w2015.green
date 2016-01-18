package ch.bfh.btx8081.w2015.green.doctorGreen.views;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2015.green.doctorGreen.MyUI;
import ch.bfh.btx8081.w2015.green.doctorGreen.controller.PatientController;
import ch.bfh.btx8081.w2015.green.doctorGreen.persistence.Patient;
import ch.bfh.btx8081.w2015.green.doctorGreen.persistence.PersistenceUnit;

@SuppressWarnings("serial")
@Theme("mytheme")
@Widgetset("ch.bfh.btx8081.w2015.green.doctorGreen.MyAppWidgetset")
public class PatientView extends VerticalLayout implements View {
	PatientController patientController = new PatientController();
	Patient patient = new Patient();
	// Status status = new Status();
	String dangerousness = "ungefährlich";

	public PatientView() {

		// get the Header
		GenericView header = new GenericView();
		HorizontalLayout layoutHeader = header.getHeader();

		// Back Button is Logout Button in this View
		header.getButton("home").setCaption("Home");
		header.getButton("home").addClickListener(new Button.ClickListener() {
			@Override
		    public void buttonClick(ClickEvent event) {
		        getUI().getNavigator().navigateTo(MyUI.HOMEVIEW);
		    }
		});
		header.getButton("back").setVisible(false);
		addComponent(layoutHeader);

		setSizeFull();
		setSpacing(true);

		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);

		addComponent(new Label("Patient XY"));
		addComponent(new TextField("Firstname", "Testpatient"));
		addComponent(new TextField("Lastname", "Testpatient"));
		addComponent(new TextField("Birthdate", "01.01.1951"));
		addComponent(new TextField("Adress", "Musterstrasse 12, 2502 Biel"));
		addComponent(new TextField("Case", "1234"));

		ComboBox box = new ComboBox();
		box.addItem("Harmless");
		box.addItem("Dangerous");
		box.addItem("Very Dangerous");
		addComponent(box);

		box.getId();

		Button store = new Button();
		PersistenceUnit unit = PersistenceUnit.getInstance();

		// Store Button
		store.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
			}
		});

	}

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("");
	}

}
