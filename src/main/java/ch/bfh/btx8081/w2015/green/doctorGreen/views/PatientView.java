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
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2015.green.doctorGreen.controller.PatientSearchController;
import ch.bfh.btx8081.w2015.green.doctorGreen.persistence.Patient;
import ch.bfh.btx8081.w2015.green.doctorGreen.persistence.State;

/**
 * This class describes the GUI for PatientView in the Doctor Green Application
 * 
 * @author Yannis Portmann
 *
 */
@SuppressWarnings("serial")
@Theme("mytheme")
@Widgetset("ch.bfh.btx8081.w2015.green.doctorGreen.MyAppWidgetset")
public class PatientView extends VerticalLayout implements View {

	PatientSearchController controller = PatientSearchController.getInstance();

	// Status status = new Status();
	String dangerousness = "ungefährlich";

	Button save = new Button("Save", this::save);
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
	 * Constructor to add all Items
	 */
	public PatientView() {
		gender.addItem("m");
		gender.addItem("f");
		state.addItem("Harmless");
		state.addItem("Dangerous");
		state.addItem("Very Dangerous");
		HorizontalLayout actions = new HorizontalLayout(save);
		actions.setSpacing(true);
		addComponents(firstname, lastname, insuranceNb, birthDate, gender, state, actions);
	}

	/**
	 * Additional Notifications could be defined here.
	 */
	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("");
	}

	/**
	 * Method to save the Patient object
	 * 
	 * @param event
	 */
	public void save(Button.ClickEvent event) {
		try {
			System.out.println(state.getValue().toString());
			formFieldBindings.commit();
			controller.savePatient(patient);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * 
	 * Method which is called to edit the selected Patient from the list
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
