package ch.bfh.btx8081.w2015.green.doctorGreen.views;

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
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * This class describes the GUI for the Case in the Doctor Green Application. The CaseView automatically gets<br>
 * the Name and Patient case Identification number. Also the anamnesis, diagnosis, entry date and leaving date<br>
 * are taken if they exist in the database. The User can make changes in the anamnesis, diagnosis and the date fields.<br>
 * By clicking the save Button all changes are saved and the database is update. If the user wants again to change something<br>
 * he can click on the edit Button and go on with his work.<br>
 * <br>
 * 
 * @author Shpend Vladi<br>
 * @author Luca Ramos Brito<br>
 * <br>
 * 
 *         instance variables:<br>
 *         - PatientCaseController pc<br>
 *         - int pid<br>
 *         - String caseId <br>
 *         - String patientname<br>
 *         - String anamnesis<br>
 *         - String diagnosis<br>
 *         - java.sql.Date fromdate<br>
 *         - java.sql.Date todate<br>
 *         - private String changedAnamnesis;<br>
 *         - private String changedDiagnosis;<br>
 *         - private String changedFromDate;<br>
 *         - private String changedToDate;<br>
 * <br>
 * 
 *         Methods:<br>
 *         - header.getButton("back").addClickListener(new Button.ClickListener() no return value<br>
 *         - header.getButton("home").addClickListener(new Button.ClickListener() no return value<br>
 *         - header.getButton("home").addClickListener(new Button.ClickListener() no return value<br>
 *         - textArea_Anamnesis.addListener(new Property.ValueChangeListener() no return value<br>
 *         - textArea_Diagnosis.addListener(new Property.ValueChangeListener() no return value<br>
 *         - dateField_FromDate.addListener(new Property.ValueChangeListener() no return value<br>
 *         - dateField_ToDate.addListener(new Property.ValueChangeListener() no return value<br>
 *         - save_Button.addClickListener(new Button.ClickListener() no return value<br>
 *         - save_Button.addClickListener(new Button.ClickListener() no return value<br>
 *         - enter(ViewChangeEvent event) no return value<br>
 */
@SuppressWarnings("serial")
@Theme("mytheme")
@Widgetset("ch.bfh.btx8081.w2015.green.doctorGreen.MyAppWidgetset")
public class CaseView extends VerticalLayout implements View {
	
	// Getting the instance of the Patiencasecontroller to use its methods
	PatientCaseController pc = PatientCaseController.getInstance();
	
	// The Patient Identification number is setted 1, he should be taken from the PatientSearchView
	private int pid = 1;
	
	// Declaring the Strings and date formats which are used to fill the textfield datefields etc.
	//--------------------------------------------------------------------------------
	private int caseId = pc.getCaseID(pid);
	private String patientname = pc.getPersonName(pid);
	private String anamnesis = pc.getAnamnesis(caseId);
	private String diagnosis = pc.getDiagnosis(caseId);
	private java.sql.Date fromdate = pc.getFromDate(caseId);
	private java.sql.Date todate = pc.getToDate(caseId);
	
	// Declaring the values which will be changed by the user and saved on the database
	//--------------------------------------------------------------------------------
	private String changedAnamnesis;
	private String changedDiagnosis;
	private Date changedFromDate = new Date();
	private Date changedToDate = new Date();
	
	
	
	/**
	 * CaseView constructor<br>
	 * Creates the GUI for this view - for details see comments in the code<br>
	 * <br>
	 *
	 * @param none
	 */
	@SuppressWarnings("deprecation")
	public CaseView()  {
		
		// if the date values aren't changed from the user they should be the ones from the database, in this part we set the start values
		changedFromDate = pc.getFromDate(caseId);
		changedToDate = pc.getToDate(caseId);
		
		// setting the TextFields for the GUI
		TextField textField_PatientCaseId = new TextField("Case Id: ");
		textField_PatientCaseId.setWidth("95%");
		textField_PatientCaseId.setValue(Integer.toString(caseId));
		textField_PatientCaseId.setEnabled(false);
		
		TextField textField_Name = new TextField("Name: ");
		textField_Name.setWidth("95%");
		textField_Name.setValue(patientname);
		textField_Name.setEnabled(false);
		
		
		// setting the TextAreas for the GUI 
		TextArea textArea_Anamnesis = new TextArea("Anamnesis: ");
		textArea_Anamnesis.setWidth("100%");
		textArea_Anamnesis.setValue(anamnesis);
		
		TextArea textArea_Diagnosis = new TextArea("Diagnosis: ");
		textArea_Diagnosis.setWidth("100%");
		textArea_Diagnosis.setValue(diagnosis);
		
		// Setting the DateFields for the GUI	
		DateField dateField_FromDate = new DateField("Etry Date");
		dateField_FromDate.setWidth("95%");
		dateField_FromDate.setValue(fromdate);
		dateField_FromDate.setEnabled(false);

		DateField dateField_ToDate = new DateField("Leaving Date");
		dateField_ToDate.setWidth("95%");
		dateField_ToDate.setValue(todate);

		
		// Setting Buttons vor the GUI
		Button save_Button = new Button("Save Changes");
		save_Button.setWidth("100%");
		
		Button edit_Button = new Button("edit Fields");
		save_Button.setWidth("100%");
		
		// Putting the Buttons in a HorizontalLayout Box
		HorizontalLayout caseButtonBox = new HorizontalLayout();
		caseButtonBox.setWidth("320px");
		caseButtonBox.addComponent(edit_Button);
		caseButtonBox.addComponent(save_Button);
		
		// Putting the Textfields in a HorizontalLayout Box
		HorizontalLayout textFieldBox = new HorizontalLayout();
		textFieldBox.setWidth("320px");
		textFieldBox.addComponent(textField_PatientCaseId);
		textFieldBox.addComponent(textField_Name);
		
		
		// Putting the dateField in a HorizontalLayout Box
		HorizontalLayout dateFieldBox = new HorizontalLayout();
		dateFieldBox.setWidth("320px");
		dateFieldBox.addComponent(dateField_FromDate);
		dateFieldBox.addComponent(dateField_ToDate);
		
		// Putting the textAreas in a VerticalLayout Box
		VerticalLayout textAreaBox = new VerticalLayout();;
		textAreaBox.setWidth("320px");
		textAreaBox.addComponent(textArea_Anamnesis);
		textAreaBox.addComponent(textArea_Diagnosis);
		
		// putting all the boxes together in the caseTab
		VerticalLayout caseTab = new VerticalLayout();
		caseTab.addComponent(textFieldBox);
		caseTab.addComponent(dateFieldBox);
		caseTab.addComponent(textAreaBox);
		caseTab.addComponent(caseButtonBox);

		// defining the caseViewTabs
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

		/**
		 * Clicking the "back" button triggers the event to<br>  
		 * go to the View the user was before. In this case its the Patiensearchview<br>
		 * @param event - ClickEvent
		 */
		header.getButton("back").addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.PATIENTSEARCHVIEW);
			}
		});
		
		/**
		 * Clicking the "home" button triggers the event to<br> 
		 * go to the home View.<br>
		 * @param event - ClickEvent
		 * <br>
		 */
		header.getButton("home").addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.HOMEVIEW);
			}
		});
		
		/**
		 * This method gets the input from the user in the anamnesis textArea and saves it<br>
		 * in the String changedAnamnesis<br>
		 * @param event - ValueChangeEvent
		 * <br>
		 */
		textArea_Anamnesis.addListener(new Property.ValueChangeListener()
	    {
	        private static final long serialVersionUID =
	        1L;
	        
			@Override
			public void valueChange(com.vaadin.data.Property.ValueChangeEvent event) {
				changedAnamnesis = (String)event.getProperty().getValue();
			}
	   });
		
		/**
		 * This method gets the input from the user in the diagnosis textArea<br>
		 * and saves it in the String changedDiagnosis<br>
		 * @param event - ValueChangeEvent
		 * <br>
		 */
		textArea_Diagnosis.addListener(new Property.ValueChangeListener()
	    {
	        private static final long serialVersionUID =
	        1L;
	        
			@Override
			public void valueChange(com.vaadin.data.Property.ValueChangeEvent event) {
				changedDiagnosis = (String)event.getProperty().getValue();
			}
	   });
		
		/**
		 * This method gets the input from the user in the entry date field  (dateField_FromDate)<br>
		 * and saves it in the date format changedFromDate<br>
		 * @param event - ValueChangeEvent
		 * <br>
		 */
		dateField_FromDate.addListener(new Property.ValueChangeListener()
	    {
	        private static final long serialVersionUID =
	        1L;
	        
			@Override
			public void valueChange(com.vaadin.data.Property.ValueChangeEvent event) {
				changedFromDate = (Date)event.getProperty().getValue();
			}
	   });
		
		/**
		 * This method gets the input from the user in the leaving date field  (dateField_ToDate)
		 * and saves it in the date format changedTodate<br>
		 * * @param event - ValueChangeEvent
		 * <br>
		 */
		dateField_ToDate.addListener(new Property.ValueChangeListener()
	    {
	        private static final long serialVersionUID =
	        1L;
	        
			@Override
			public void valueChange(com.vaadin.data.Property.ValueChangeEvent event) {
				changedToDate = (Date)event.getProperty().getValue();
			}
	   });
		
		/**
		 * This save_Button listener method saves all new inputs from the user in all editable Fields to the database<br>
		 * with the PatientController methods it is possible to update tables in the database.<br>
		 * First the method checks if the user changed something. If not he keeps the database data.<br>
		 * If yes he updates the changes. And at the end he makes all fields disable.<br>
		 * @param event - ClickEvent<br>
		 * <br>
		 */
		save_Button.addClickListener(new Button.ClickListener() {
		    public void buttonClick(ClickEvent event) {
		    	
		        java.sql.Date sqlToDate = new java.sql.Date(changedToDate.getTime());
		        java.sql.Date sqlFromDate = new java.sql.Date(changedFromDate.getTime());
		    
		    	pc.upDateFromDate(sqlFromDate, caseId);
		    	pc.upDateToDate(sqlToDate, caseId);
		    	
		    	if (changedAnamnesis ==null)
		    	{
		    		pc.upDateAnamnesis(anamnesis, caseId);
		    	}else{
		    		pc.upDateAnamnesis(changedAnamnesis, caseId);
		    	}
		    	
		    	if (changedDiagnosis ==null)
		    	{
		    		pc.upDateDiagnosis(diagnosis, caseId);
		    	}else{
		    		pc.upDateDiagnosis(changedDiagnosis, caseId);
		    	}
		    	
		    	textArea_Anamnesis.setEnabled(false);
		    	textArea_Diagnosis.setEnabled(false);
		    	dateField_FromDate.setEnabled(false);
		    	dateField_ToDate.setEnabled(false);
		    	
		    }
		});
		
		/**
		 * This method makes all needed Fields editable again when the Button edit is clicked<br>
		 * @param event - ClickEvent<br>
		 * <br>
		 */
		edit_Button.addClickListener(new Button.ClickListener() {
		    public void buttonClick(ClickEvent event) {
		    	
		    	dateField_FromDate.setEnabled(true);
		    	textArea_Anamnesis.setEnabled(true);
		    	textArea_Diagnosis.setEnabled(true);
		    	dateField_ToDate.setEnabled(true);
		    }
		});
		
		

	}

	/**
	 * This method shows the title of the view by entering it for a moment.<br>
	 * @param event - ViewChangeEvent
	 * <br>
	 */
	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("PatientCase");
	}

}
