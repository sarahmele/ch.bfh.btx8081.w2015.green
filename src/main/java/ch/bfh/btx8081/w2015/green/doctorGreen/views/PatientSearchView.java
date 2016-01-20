package ch.bfh.btx8081.w2015.green.doctorGreen.views;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2015.green.doctorGreen.MyUI;
import ch.bfh.btx8081.w2015.green.doctorGreen.controller.PatientSearchController;
import ch.bfh.btx8081.w2015.green.doctorGreen.persistence.Patient;

/**
 * This class describes the GUI for HomeView in the Doctor Green Application
 * 
 * @author Yannis Portmann
 *
 */
@SuppressWarnings("serial")
@Theme("mytheme")
@Widgetset("ch.bfh.btx8081.w2015.green.doctorGreen.MyAppWidgetset")
public class PatientSearchView extends VerticalLayout implements View {
	PatientSearchController controller = PatientSearchController.getInstance();

	TextField filter = new TextField();
	Grid patientListGrid = new Grid();

	PatientView patientView = new PatientView();
	PatientCaseView patientCaseView = new PatientCaseView();

	/**
	 * Constructor to add all Items
	 */
	public PatientSearchView() {

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

		layout.addComponents(filter, patientListGrid);

		configureComponents();

		// Tab Sheet to put in the Tabs
		TabSheet viewTabs = new TabSheet();

		VerticalLayout patientSearchTab = new VerticalLayout();
		patientSearchTab.addComponent(layout);

		VerticalLayout patientTab = new VerticalLayout();
		patientTab.addComponents(patientView);

		VerticalLayout patientCaseTab = new VerticalLayout();
		patientCaseTab.addComponents(patientCaseView);

		viewTabs.addTab(patientSearchTab).setCaption("Suchen");
		viewTabs.addTab(patientTab).setCaption("Patient");
		viewTabs.addTab(patientCaseTab).setCaption("Patient Cases");

		addComponent(viewTabs);
	}

	/**
	 * Describes the List Entrys
	 */
	private void configureComponents() {
		filter.setInputPrompt("Filter patients...");
		filter.addTextChangeListener(e -> refreshPatients(e.getText()));

		patientListGrid.setContainerDataSource(new BeanItemContainer<>(Patient.class));
		patientListGrid.setColumnOrder("firstName", "lastName", "insuranceNb", "birthDate", "gender");

		patientListGrid.removeColumn("address");
		patientListGrid.removeColumn("phoneNb");
		patientListGrid.removeColumn("username");
		patientListGrid.removeColumn("password");
		patientListGrid.removeColumn("doctorList");
		patientListGrid.removeColumn("patientCaseList");

		patientListGrid.setSelectionMode(Grid.SelectionMode.SINGLE);
		patientListGrid.addSelectionListener(e -> patientView.edit((Patient) patientListGrid.getSelectedRow()));

		refreshPatients();
	}

	/**
	 * Method to refresh the table
	 */
	void refreshPatients() {
		refreshPatients(filter.getValue());
	}

	/**
	 * Apply the current filter entries
	 * 
	 * @param stringFilter
	 */
	private void refreshPatients(String stringFilter) {
		patientListGrid.setContainerDataSource(new BeanItemContainer<>(Patient.class, controller.getPatientList()));
	}

	/**
	 * Needs to be implemented
	 */
	@Override
	public void enter(ViewChangeEvent event) {
	}

}
