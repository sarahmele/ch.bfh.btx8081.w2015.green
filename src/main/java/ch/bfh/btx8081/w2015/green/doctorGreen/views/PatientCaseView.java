package ch.bfh.btx8081.w2015.green.doctorGreen.views;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

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

	/**
	 * 
	 */
	public PatientCaseView() {
		patientCaseGrid.setContainerDataSource(new BeanItemContainer<>(PatientCase.class));
		patientCaseGrid.setColumnOrder("patientCaseId", "fromDate", "toDate");

		patientCaseGrid.removeColumn("anamnesis");
		patientCaseGrid.removeColumn("diagnosis");
		patientCaseGrid.removeColumn("treatmentList");

		patientCaseGrid.setSelectionMode(Grid.SelectionMode.SINGLE);
		// patientCaseGrid.addSelectionListener(e -> patientView.edit((Patient)
		// patientListGrid.getSelectedRow()));
		// Todo Weiterleitung an CaseView

		addComponent(patientCaseGrid);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("");
	}
}