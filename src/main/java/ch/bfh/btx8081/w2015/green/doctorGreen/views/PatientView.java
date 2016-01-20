package ch.bfh.btx8081.w2015.green.doctorGreen.views;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2015.green.doctorGreen.controller.PatientController;
import ch.bfh.btx8081.w2015.green.doctorGreen.persistence.Patient;
import ch.bfh.btx8081.w2015.green.doctorGreen.persistence.State;

/**
 * 
 * @author Yannis
 *
 */
@SuppressWarnings("serial")
@Theme("mytheme")
@Widgetset("ch.bfh.btx8081.w2015.green.doctorGreen.MyAppWidgetset")
public class PatientView extends VerticalLayout implements View {
	PatientController patientController = new PatientController();
	// Status status = new Status();
	String dangerousness = "ungefährlich";

	Button save = new Button("Save", this::save);
	Button cancel = new Button("Cancel", this::cancel);
	TextField firstname = new TextField("First name");
	TextField lastname = new TextField("Last name");
	TextField insuranceNb = new TextField("Insurance Number");
	DateField birthDate = new DateField("Birth date");
	ComboBox gender = new ComboBox("Gender");
	ComboBox state = new ComboBox("State");

	Patient patient;

	BeanFieldGroup<Patient> formFieldBindings;
	private State stateObj;

	/**
	 * 
	 */
	public PatientView() {

		gender.addItem("m");
		gender.addItem("f");
		state.addItem("Harmless");
		state.addItem("Dangerous");
		state.addItem("Very Dangerous");
		HorizontalLayout actions = new HorizontalLayout(save, cancel);
		actions.setSpacing(true);
		addComponents(firstname, lastname, insuranceNb, birthDate, gender, state, actions);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("");
	}

	/**
	 * 
	 * @param event
	 */
	public void save(Button.ClickEvent event) {
		try {
			formFieldBindings.commit();

			// getUI().service.save(contact);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * 
	 * @param event
	 */
	public void cancel(Button.ClickEvent event) {
		Notification.show("Cancelled", Type.TRAY_NOTIFICATION);
	}

	/**
	 * 
	 * @param patient
	 */
	void edit(Patient patient) {
		this.patient = patient;
		if (patient != null) {
			formFieldBindings = BeanFieldGroup.bindFieldsBuffered(patient, this);
			firstname.focus();
		}
		setVisible(patient != null);
	}

}
