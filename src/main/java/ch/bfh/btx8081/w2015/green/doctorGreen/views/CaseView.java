package ch.bfh.btx8081.w2015.green.doctorGreen.views;

import java.io.File;

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

import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Table;
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
		HorizontalSplitPanel hsplit = new HorizontalSplitPanel();
		panel.setContent(hsplit);		
		
		Table caseViewTable = new Table("Case");
		
		// Define two columns for the built-in container
		caseViewTable.addContainerProperty("Name", String.class, null);
		caseViewTable.addContainerProperty("Albina Shabani",  String.class, null);
		
		// Add a few other rows using shorthand addItem()
		caseViewTable.addItem(new Object[]{"CaseNb",         "1111"}, 2);
		caseViewTable.addItem(new Object[]{"Anamnese",       "schmerzen"}, 3);
		caseViewTable.addItem(new Object[]{"Psychostatus",   "Gefährlich"}, 4);
		caseViewTable.addItem(new Object[]{"Diagnose",       "krank"}, 4);
		
		// Show exactly the currently contained rows (items)
		caseViewTable.setPageLength(caseViewTable.size());
		
		Table treatmentTable = new Table("Treatment");
		
		// Define two columns for the built-in container
		treatmentTable.addContainerProperty("Name", String.class, null);
		treatmentTable.addContainerProperty("Ardit",  String.class, null);
		
		// Add a few other rows using shorthand addItem()
		treatmentTable.addItem(new Object[]{"Date",         "1111"}, 2);
		treatmentTable.addItem(new Object[]{"Medication",   "schmerzen"}, 3);
		
		// Show exactly the currently contained rows (items)
		treatmentTable.setPageLength(treatmentTable.size());
		
		TabSheet caseViewTabs = new TabSheet();
		final VerticalLayout layout = new VerticalLayout();		
        layout.setMargin(true);       
        
        caseViewTabs.addComponent(caseViewTable);
        caseViewTabs.addComponent(treatmentTable);
        
        Button homeView_Button = homeView_Button();
		hsplit.setFirstComponent(homeView_Button);
		
		addComponent(hsplit);
        panel.setContent(caseViewTabs);
    	addComponent(caseViewTabs);

	}


	private Button homeView_Button() {
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

