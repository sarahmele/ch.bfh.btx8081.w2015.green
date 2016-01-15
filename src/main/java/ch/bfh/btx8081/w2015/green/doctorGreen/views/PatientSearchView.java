package ch.bfh.btx8081.w2015.green.doctorGreen.views;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2015.green.doctorGreen.MyUI;

@SuppressWarnings("serial")
@Theme("mytheme")
@Widgetset("ch.bfh.btx8081.w2015.green.doctorGreen.MyAppWidgetset")
public class PatientSearchView extends VerticalLayout implements View {

	public PatientSearchView() {
		// layout for footer
		HorizontalLayout layoutFooter = new HorizontalLayout();
		
		setSizeFull();
		setSpacing(true);

		// Have a panel to put stuff in
		Panel panel = new Panel();
		HorizontalSplitPanel hsplit = new HorizontalSplitPanel();
		panel.setContent(hsplit);

		// -------------

		TextField firstname = new TextField("Vorname");
		TextField lastname = new TextField("Nachname");
		TextField casenumber = new TextField("Case");

		// --------------

		Table patientTable = new Table("Patient");

		// Define two columns for the built-in container
		patientTable.addContainerProperty("Firstname", String.class, null);
		patientTable.addContainerProperty("Lastname", String.class, null);
		patientTable.addContainerProperty("Case Number", String.class, null);

		// Add a few other rows using shorthand addItem()
		patientTable.addItem(new Object[] { "CaseNb", "1111" }, 2);
		patientTable.addItem(new Object[] { "Anamnese", "schmerzen" }, 3);
		patientTable.addItem(new Object[] { "Psychostatus", "Gefährlich" }, 4);
		patientTable.addItem(new Object[] { "Diagnose", "krank" }, 4);

		// Show exactly the currently contained rows (items)
		patientTable.setPageLength(patientTable.size());

		// ------

		TabSheet patientSearchTab = new TabSheet();

		GenericView header = new GenericView();
		HorizontalLayout layoutHeader = header.getHeader();

		layoutHeader.setMargin(true);
		header.getButton("home");
		header.getButton("back");

		patientSearchTab.addComponent(patientTable);

		patientSearchTab.addComponent(firstname);
		patientSearchTab.addComponent(lastname);
		patientSearchTab.addComponent(casenumber);

		layoutFooter.addComponent(patientSearchButton());
	}

	@Override
	public void enter(ViewChangeEvent event) {
	}

	private Button patientSearchButton() {
		Button button = new Button("Patient Suchen", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.PATIENTSEARCHVIEW);
			}
		});
		return button;
	}

}
