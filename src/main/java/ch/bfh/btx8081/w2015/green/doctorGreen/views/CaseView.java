package ch.bfh.btx8081.w2015.green.doctorGreen.views;

//import java.text.SimpleDateFormat;
import java.util.Date;

import ch.bfh.btx8081.w2015.green.doctorGreen.MyUI;
//<<<<<<< .mine
import ch.bfh.btx8081.w2015.green.doctorGreen.controller.PatientCaseController;

//=======

//>>>>>>> .r286
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.data.Property;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Field.ValueChangeEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TabSheet;
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
	
	PatientCaseController pc = PatientCaseController.getInstance();
	
	@SuppressWarnings("deprecation")
	public CaseView()  {
		
		// set TextFields
		TextField textField_PatientCaseId = new TextField("Case Id: ");
		textField_PatientCaseId.setWidth("95%");
		textField_PatientCaseId.setValue(pc.getCaseID(1));
		textField_PatientCaseId.setEnabled(false);
		
		TextField textField_Name = new TextField("Name: ");
		textField_Name.setWidth("95%");
		textField_Name.setValue(pc.getPersonName(1));
		textField_Name.setEnabled(false);
		
		
		// set TextAreas
		TextArea textArea_Anamnesis = new TextArea("Anamnesis: ");
		textArea_Anamnesis.setWidth("100%");
		textArea_Anamnesis.setValue(pc.getAnamnesis(1));
		
		TextArea textArea_Diagnosis = new TextArea("Diagnosis: ");
		textArea_Diagnosis.setWidth("100%");
		textArea_Diagnosis.setValue(pc.getDiagnosis(1));
		
		// Set DateFields
		//SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		
		DateField dateField_FromDate = new DateField("Etry Date");
		dateField_FromDate.setWidth("95%");
		dateField_FromDate.setValue(pc.getFromDate(1));
		dateField_FromDate.setEnabled(false);
		
		DateField dateField_ToDate = new DateField("Leaving Date");
		dateField_ToDate.setWidth("95%");
		dateField_ToDate.setValue(pc.getToDate(1));
		
		// Buttons
		Button save_Button = new Button("Save Changes");
		save_Button.setWidth("100%");
		
		Button edit_Button = new Button("edit all fields");
		save_Button.setWidth("100%");
		
		
		HorizontalLayout caseButtonBox = new HorizontalLayout();
		caseButtonBox.setWidth("320px");
		caseButtonBox.addComponent(edit_Button);
		caseButtonBox.addComponent(save_Button);
		
		//textFieldBox
		HorizontalLayout textFieldBox = new HorizontalLayout();
		textFieldBox.setWidth("320px");
		textFieldBox.addComponent(textField_PatientCaseId);
		textFieldBox.addComponent(textField_Name);
		
		
		// dateFieldbox
		HorizontalLayout dateFieldBox = new HorizontalLayout();
		dateFieldBox.setWidth("320px");
		dateFieldBox.addComponent(dateField_FromDate);
		dateFieldBox.addComponent(dateField_ToDate);
		
		// textAreaBox
		VerticalLayout textAreaBox = new VerticalLayout();;
		textAreaBox.setWidth("320");
		textAreaBox.addComponent(textArea_Anamnesis);
		textAreaBox.addComponent(textArea_Diagnosis);
		
		// caseTab
		VerticalLayout caseTab = new VerticalLayout();
		caseTab.addComponent(textFieldBox);
		caseTab.addComponent(dateFieldBox);
		caseTab.addComponent(textAreaBox);
		caseTab.addComponent(caseButtonBox);

		// caseViewTabs
		TabSheet caseViewTabs = new TabSheet();

		//////////////////////////////////////////////
		/* Start of Treatment View Tab code segment */
		//////////////////////////////////////////////

		/**
		 * Defines the datefield that marks the start of a treatment
		 */
		DateField treatDate = new DateField("Date");
		treatDate.setValue(new Date());
		treatDate.setWidth("80%");

		/**
		 * Defines the textarea where the treatment plan is written down
		 */
		TextArea medicationPlan = new TextArea("Medication Plan");
		medicationPlan.setWidth("100%");
		medicationPlan.setRows(3);

		/**
		 * Defines the button that saves the treatmentplan in the database
		 */
		Button saveTreatButton = new Button("Save Treatment");

		/**
		 * Defines the button that is supposed to add additional datefields and textareas
		 */
		Button newTreatButton = new Button("New Treatment");

		HorizontalLayout infoBox = new HorizontalLayout();
		infoBox.setWidth("320px");
		infoBox.addComponent(treatDate);
		infoBox.addComponent(medicationPlan);

		
		HorizontalLayout buttonBox = new HorizontalLayout();
		buttonBox.setWidth("320px");
		buttonBox.addComponent(saveTreatButton);
		buttonBox.addComponent(newTreatButton);
		

		VerticalLayout treatTab = new VerticalLayout();
		treatTab.addComponent(infoBox);
		treatTab.addComponent(buttonBox);
		//treatTab.addComponent(saveTreatButton);
		//treatTab.addComponent(newTreatButton);

		/**
		 * Clicking the "New Treatment" button triggers the event to show 
		 * another DateField and TextArea
		 */
		newTreatButton.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(final ClickEvent event) {
				
			}
		});

		caseViewTabs.addTab(caseTab).setCaption("Case");
		caseViewTabs.addTab(treatTab).setCaption("Treatment");

		GenericView header = new GenericView();
		HorizontalLayout layoutHeader = header.getHeader();

		addComponent(layoutHeader);
		addComponent(caseViewTabs);

		////////////////////////////////////////////
		/* End of Treatment View Tab code segment */
		////////////////////////////////////////////

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
		
		
		textField_PatientCaseId.addListener(new Property.ValueChangeListener()
	    {
	        private static final long serialVersionUID =
	        1L;
	        
			@Override
			public void valueChange(com.vaadin.data.Property.ValueChangeEvent event) {
				String caseIdChanged = (String)event.getProperty().getValue();
			}
	   });
		
		save_Button.addClickListener(new Button.ClickListener() {
		    public void buttonClick(ClickEvent event) {
		    	save_Button.setCaption("saved!");
		    }
		});
		
		edit_Button.addClickListener(new Button.ClickListener() {
		    public void buttonClick(ClickEvent event) {
		    	save_Button.setCaption("saved!");
		    	textFieldBox.setEnabled(true);
		    	dateField_FromDate.setEnabled(true);
		    }
		});
		
		

	}

	
	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("PatientCase");
	}

}
