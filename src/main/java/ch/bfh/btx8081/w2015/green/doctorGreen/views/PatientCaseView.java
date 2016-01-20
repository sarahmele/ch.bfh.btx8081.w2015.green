package ch.bfh.btx8081.w2015.green.doctorGreen.views;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2015.green.doctorGreen.controller.PatientSearchController;
import ch.bfh.btx8081.w2015.green.doctorGreen.persistence.PatientCase;

/**
 * 
 * @author Yannis
 *
 */
@SuppressWarnings("serial")
@Theme("mytheme")
@Widgetset("ch.bfh.btx8081.w2015.green.doctorGreen.MyAppWidgetset")
public class PatientCaseView extends VerticalLayout implements View {
	Grid patientCaseGrid = new Grid();
	PatientCase patientCase;
	BeanFieldGroup<PatientCase> formFieldBindings;
	TextField filter = new TextField();

	PatientSearchController controller = PatientSearchController.getInstance();

	/**
	 * 
	 */
	public PatientCaseView() {
		filter.setInputPrompt("Filter patientCases...");
		patientCaseGrid.setContainerDataSource(new BeanItemContainer<>(PatientCase.class));
		patientCaseGrid.setColumnOrder("patientCaseId", "fromDate", "toDate");

		patientCaseGrid.removeColumn("anamnesis");
		patientCaseGrid.removeColumn("diagnosis");
		patientCaseGrid.removeColumn("treatmentList");

		patientCaseGrid.setSelectionMode(Grid.SelectionMode.SINGLE);
		patientCaseGrid.addSelectionListener(e -> this.edit(patientCase));
		// patientListGrid.getSelectedRow()));
		// Todo Weiterleitung an CaseView

		addComponents(filter, patientCaseGrid);
		refreshPatientCases();
	}

	/**
	 * 
	 * @param patient
	 */
	void edit(PatientCase patientCase) {
		this.patientCase = patientCase;
		if (patientCase != null) {
			formFieldBindings = BeanFieldGroup.bindFieldsBuffered(patientCase, this);
		}
		setVisible(patientCase != null);
	}

	/**
	 * 
	 */
	void refreshPatientCases() {
		refreshPatientCases(filter.getValue());
	}

	/**
	 * 
	 * @param stringFilter
	 */
	private void refreshPatientCases(String stringFilter) {
		patientCaseGrid
				.setContainerDataSource(new BeanItemContainer<>(PatientCase.class, controller.getPatientCaseList()));
	}

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("");
	}
}