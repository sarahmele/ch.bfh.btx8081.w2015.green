package ch.bfh.btx8081.w2015.green.doctorGreen.views;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import ch.bfh.btx8081.w2015.green.doctorGreen.MyUI;

import com.google.gwt.user.client.ui.VerticalSplitPanel;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

/**
 *
 */
@SuppressWarnings("serial")
@Theme("mytheme")
@Widgetset("ch.bfh.btx8081.w2015.green.doctorGreen.MyAppWidgetset")
public class CaseView extends VerticalLayout implements View {

	public CaseView() {
		setSizeFull();
		setSpacing(true);

		// Have a panel to put stuff in
		Panel panel = new Panel();    
		
		
		Table CaseViewTable = new Table("CaseData");

		// Define two columns for the built-in container

		CaseViewTable.addContainerProperty("Name", String.class, null);
		CaseViewTable.addContainerProperty("Max Muster",TextArea.class, null);

		TextArea diagnosisField = new TextArea();
		diagnosisField.setRows(3);
		diagnosisField.setValue("Blinddarmentzündung");

		TextArea anamnesisField = new TextArea();
		anamnesisField.setRows(3);
		anamnesisField.setValue("Schmerzen im unteren Abdomen");
		anamnesisField.setReadOnly(true);
		
		TextArea patientCaseId = new TextArea();
		diagnosisField.setRows(3);
		diagnosisField.setValue("Blinddarmentzündung");
		
		
		

		// Button changeDiagnosis_Button = changeDiagnosis_Button();

		// Add a few other rows using shorthand addItem()
		CaseViewTable.addItem(new Object[] { "PatientCaseId", patientCaseId }, 1);
	//	CaseViewTable.addItem(new Object[] { "FromDate", getCurrentDate() }, 2);
	//	CaseViewTable.addItem(new Object[] { "ToDate", getCurrentDate() }, 3);
		CaseViewTable.addItem(new Object[] { "Diagnosis",
				diagnosisField }, 4);
		CaseViewTable.addItem(new Object[] { "Anamnesis",
				anamnesisField }, 5);


		TabSheet caseViewTabs = new TabSheet();
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);

		caseViewTabs.addComponents(CaseViewTable);

		GenericView header = new GenericView();
		HorizontalLayout layoutHeader = header.getHeader();

		/* Start of Treatment View Tab code segment */

		Table treatmentTable = new Table("Treatment");

		// Define two columns for the built-in container
		treatmentTable.addContainerProperty("Date", DateField.class, null);
		treatmentTable.addContainerProperty("Medication", TextArea.class, null);

		/* Add a few items in the table. */

		// Create the fields for the current table row
		DateField medicationDate = new DateField();
		medicationDate.setValue(new Date());

		TextArea medicationField = new TextArea();
		medicationField.setRows(3);

		// The Table item identifier for the row.
		Integer itemId = new Integer(1);

		// Create the table row.
		treatmentTable.addItem(
				new Object[] { medicationDate, medicationField }, itemId);

		// Show exactly the currently contained rows (items)
		treatmentTable.setPageLength(treatmentTable.size());
		
        
		caseViewTabs.addComponent(CaseViewTable);
		caseViewTabs.addComponent(treatmentTable);
		
		panel.setContent(caseViewTabs);
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

	public String getCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		// get current date time with Date()
		Date date = new Date();
		return dateFormat.format(date);
	}

	public String getAnamnesis() {
		return null;
	}

	// private Button changeDiagnosis_Button() {
	// Button button = new Button("HomeView", new Button.ClickListener() {
	// @Override
	// public void buttonClick(ClickEvent event) {
	// getUI().getNavigator().navigateTo(MyUI.HOMEVIEW);
	// }
	// });
	// return button;
	// }

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("PatientCase");
	}

}
