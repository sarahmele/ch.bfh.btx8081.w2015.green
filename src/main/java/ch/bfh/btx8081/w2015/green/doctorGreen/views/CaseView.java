package ch.bfh.btx8081.w2015.green.doctorGreen.views;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FileResource;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinService;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.AbstractSelect.NewItemHandler;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.btx8081.w2015.green.doctorGreen.MyUI;
import ch.bfh.btx8081.w2015.green.doctorGreen.persistence.PatientCase;

import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;
import com.vaadin.ui.themes.ValoTheme;

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
		
		Table caseViewTable = new Table("CaseData");
		Table editableCaseViewTable = new Table("CaseMedicalData");
		
		// Define two columns for the built-in container
		caseViewTable.addContainerProperty("Name", String.class, null);
		caseViewTable.addContainerProperty("Max Muster",  String.class, null);
		
		editableCaseViewTable.addContainerProperty("Name", String.class, null);
		editableCaseViewTable.addContainerProperty("Max Muster",  TextArea.class, null);
		editableCaseViewTable.addContainerProperty("Max Muster",  Button.class, null);
		
		TextArea diagnosisField = new TextArea();
	    diagnosisField.setRows(3);
	    diagnosisField.setValue("Blinddarmentzündung");
	    
	    TextArea anamnesisField = new TextArea();
	    anamnesisField.setRows(3);
	    anamnesisField.setValue("Schmerzen im unteren Abdomen");
	    anamnesisField.setReadOnly(true);
	    
	    Button changeDiagnosis_Button = changeDiagnosis_Button();

	    
	    
		// Add a few other rows using shorthand addItem()
		caseViewTable.addItem(new Object[]{"PatientCaseId",         "777"					}, 	1);
		caseViewTable.addItem(new Object[]{"FromDate",       		getCurrentDate()		}, 	2);
		caseViewTable.addItem(new Object[]{"ToDate",  				getCurrentDate()		}, 	3);
		editableCaseViewTable.addItem(new Object[]{"Diagnosis",     diagnosisField			}, 	4);
		editableCaseViewTable.addItem(new Object[]{"Anamnesis",     anamnesisField			}, 	5);
	
		
		// Show exactly the currently contained rows (items)
		editableCaseViewTable.setPageLength(caseViewTable.size());
		caseViewTable.setPageLength(caseViewTable.size());
		
		TabSheet caseViewTabs = new TabSheet();
		final VerticalLayout layout = new VerticalLayout();		
        layout.setMargin(true);       

        caseViewTabs.addComponents(caseViewTable);
		
		GenericView header = new GenericView();
		HorizontalLayout layoutHeader = header.getHeader();
		
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
		
		
		addComponent(layoutHeader);
        panel.setContent(caseViewTabs);
    	addComponent(caseViewTabs);
    	panel.setContent(editableCaseViewTable);
    	addComponent(editableCaseViewTable);

	}
	
		
	public String getCurrentDate(){	
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	   //get current date time with Date()
	   Date date = new Date();
	return dateFormat.format(date);
	}
	
	public String getAnamnesis (){
		return null;
	}

	
	private Button changeDiagnosis_Button() {
		Button button = new Button("HomeView", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.HOMEVIEW);
			}
		});
		return button;
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("PatientCase");
	}
	

}

