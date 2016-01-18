package ch.bfh.btx8081.w2015.green.doctorGreen.views;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import ch.bfh.btx8081.w2015.green.doctorGreen.MyUI;
import ch.bfh.btx8081.w2015.green.doctorGreen.persistence.Patient;
import ch.bfh.btx8081.w2015.green.doctorGreen.persistence.PatientCase;
import ch.bfh.btx8081.w2015.green.doctorGreen.persistence.Person;

import com.google.gwt.user.client.ui.VerticalSplitPanel;
import com.sun.javafx.scene.traversal.ParentTraversalEngine;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Sizeable;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * This class describes the Guy for the Case in the Doctor Green Application <br>
 * <br>
 * 
 * @author Shpend Vladi<br>
 * <br>
 * 
 *         instance variables:<br>
 *         - TextField username<br>
 *         - PasswordField password<br>
 *         - String MyResult<br>
 * <br>
 * 
 *         Methods:<br>
 *         - loginButton() returns Button<br>
 *         - enter(ViewChangeEvent event) no return value<br>
 */
@SuppressWarnings("serial")
@Theme("mytheme")
@Widgetset("ch.bfh.btx8081.w2015.green.doctorGreen.MyAppWidgetset")
public class CaseView extends VerticalLayout implements View {

	public CaseView() {
		setSizeFull(); 
		setSpacing(true);
		
		// Find the application directory
		String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();

		// set TextFields
		TextField textField_PatientCaseId = new TextField("Case Id: ");
		textField_PatientCaseId.setWidth("95%");
		textField_PatientCaseId.setValue("1111");
		
		TextField textField_Name = new TextField("Name: ");
		textField_Name.setWidth("95%");
		textField_Name.setValue("Patient Muster");
		
		// set TextAreas
		TextArea textArea_Anamnesis = new TextArea("Anamnesis: ");
		textArea_Anamnesis.setWidth("100%");
		textArea_Anamnesis.setValue("Patient Muster leidet seit Wochen an Schlafmangel");
		
		TextArea textArea_Diagnosis = new TextArea("Diagnosis: ");
		textArea_Diagnosis.setWidth("100%");
		textArea_Diagnosis.setValue("Patient Muster hat eine leichte psychische Depression");
		
		// Set DateFields
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		
		DateField dateField_FromDate = new DateField("Etry Date");
		dateField_FromDate.setWidth("95%");
		dateField_FromDate.setValue(new Date());
		
		DateField dateField_ToDate = new DateField("Leaving Date");
		dateField_ToDate.setWidth("95%");
		dateField_ToDate.setValue(new Date());
		
		// Save Button
		Button save_Button = new Button("Save Changes");
		save_Button.setWidth("100%");
		
		
		//textFieldBox
		HorizontalLayout textFieldBox = new HorizontalLayout();
		textFieldBox.setEnabled(false);
		textFieldBox.setWidth("320");
		
		textFieldBox.addComponent(textField_PatientCaseId);
		textFieldBox.addComponent(textField_Name);
		
		
		// dateFieldbox
		HorizontalLayout dateFieldBox = new HorizontalLayout();
		dateFieldBox.setEnabled(false);
		dateFieldBox.setWidth("320px");
		
		dateFieldBox.addComponent(dateField_FromDate);
		dateFieldBox.addComponent(dateField_ToDate);
		
		// textAreaBox
		VerticalLayout textAreaBox = new VerticalLayout();
		textAreaBox.setEnabled(false);
		textAreaBox.setWidth("320");
		
		textAreaBox.addComponent(textArea_Anamnesis);
		textAreaBox.addComponent(textArea_Diagnosis);
		
		// caseTab
		VerticalLayout caseTab = new VerticalLayout();
		caseTab.addComponent(textFieldBox);
		caseTab.addComponent(dateFieldBox);
		caseTab.addComponent(textAreaBox);
		caseTab.addComponent(save_Button);

		// caseViewTabs
		TabSheet caseViewTabs = new TabSheet();

		//////////////////////////////////////////////
		/* Start of Treatment View Tab code segment */
		//////////////////////////////////////////////

		Table treatmentTable = new Table("Treatment");
		treatmentTable.setWidth("320");
		

		// Define two columns for the built-in container
		treatmentTable.addContainerProperty("Date", DateField.class, null);
		treatmentTable.addContainerProperty("Medication", TextArea.class, null);

		/* Add a few items in the table. */

		// Create the fields for the current table row
		DateField medicationDate = new DateField();
		medicationDate.setWidth("50%");
		medicationDate.setValue(new Date());

		TextArea medicationField = new TextArea();
		medicationField.setWidth("100%");
		medicationField.setRows(3);

		/**
		 * Style change variables
		 */
		medicationDate.addStyleName("dateField");
		medicationField.addStyleName("medicationField");
		
		// The Table item identifier for the row.
		Integer itemId = new Integer(1);

		// Create the table row.
		treatmentTable.addItem(
				new Object[] { medicationDate, medicationField }, itemId);

		// Show exactly the currently contained rows (items)
		treatmentTable.setPageLength(treatmentTable.size());
		
        
		caseViewTabs.addTab(caseTab).setCaption("Case");
		caseViewTabs.addComponent(treatmentTable);
		
		
		GenericView header = new GenericView();
		HorizontalLayout layoutHeader = header.getHeader();
		
		addComponent(layoutHeader);
		addComponent(caseViewTabs);
		
		

		// Treatment Plan button
		// Button addTreatmentPlan = addTreatmentPlan();
		// hsplit.setSecondComponent(addTreatmentPlan);

		/* Method to add new Treatment rows */
		/*
		 * private void createNewTreatment() { //treatmentTable.addItem(); }
		 */

		/* Button to add new treatment plans */

		/*
		 * private Button addTreatmentPlan() { Button button = new
		 * Button("Add Treatment");
		 * 
		 * button.addClickListener(new Button.ClickListener() { public void
		 * buttonClick(ClickEvent event) { createNewTreatment(); }
		 * 
		 * }); return button; }
		 */

		/* End of Treatment View Tab code segment */

		// Back Button is Logout Button in this View
		header.getButton("back").addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.PATIENTVIEW);
			}
		});

		header.getButton("home").addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.HOMEVIEW);
			}
		});
		
		

	}


	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("PatientCase");
	}

}
