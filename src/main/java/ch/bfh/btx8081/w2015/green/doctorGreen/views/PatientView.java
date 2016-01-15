package ch.bfh.btx8081.w2015.green.doctorGreen.views;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2015.green.doctorGreen.MyUI;
import ch.bfh.btx8081.w2015.green.doctorGreen.controller.PatientController;
import ch.bfh.btx8081.w2015.green.doctorGreen.persistence.Patient;

@SuppressWarnings("serial")
@Theme("mytheme")
@Widgetset("ch.bfh.btx8081.w2015.green.doctorGreen.MyAppWidgetset")
public class PatientView extends VerticalLayout implements View {
	PatientController patientController = new PatientController();
	Patient patient = new Patient();
	// Status status = new Status();
	String dangerousness = "ungefährlich";

	public PatientView() {
		// status.setStatusId(1);
		// patient.setStatus(status);

		setSizeFull();
		setSpacing(true);

		// Have a panel to put stuff in
		Panel panel = new Panel();
		HorizontalSplitPanel hsplit = new HorizontalSplitPanel();
		panel.setContent(hsplit);

		// -------------

		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);

		Button homeButton = homeButton();
		Button backButton = backButton();
		hsplit.setFirstComponent(homeButton);
		hsplit.addComponent(backButton);

		addComponent(hsplit);

		addComponent(new Label("Patient XY"));
		addComponent(new TextField("Firstname", "Testpatient"));
		addComponent(new TextField("Lastname", "Testpatient"));
		addComponent(new TextField("Birthdate", "01.01.1951"));
		addComponent(new TextField("Adress", "Musterstrasse 12, 2502 Biel"));
		addComponent(new TextField("Case", "1234"));

		addComponent(new TextField("Status", dangerousness));
		VaadinService service = VaadinService.getCurrent();

		HorizontalLayout horLayout = new HorizontalLayout();
		horLayout.addComponent(changeStatusButtonRiskPlus(service));
		horLayout.addComponent(changeStatusButtonRiskMinus(service));

		panel.setContent(horLayout);
		addComponent(horLayout);

		VaadinService.getCurrentRequest().getWrappedSession().setAttribute("patient", patient);

	}

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("");
	}

	private Button backButton() {
		Button button = new Button("Back", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.PATIENTSEARCHVIEW);
			}
		});
		return button;
	}

	private Button homeButton() {
		Button button = new Button("Home", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.HOMEVIEW);
			}
		});
		return button;
	}

	private Button changeStatusButtonRiskPlus(VaadinService service) {
		Button button = new Button("+", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				System.out.println(dangerousness);
				getUI().getNavigator().navigateTo(MyUI.PATIENTVIEW);
			}
		});
		return button;
	}

	private Button changeStatusButtonRiskMinus(VaadinService service) {
		Button button = new Button("-", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				System.out.println(dangerousness);
				getUI().getNavigator().navigateTo(MyUI.PATIENTVIEW);
			}
		});
		return button;
	}

}
