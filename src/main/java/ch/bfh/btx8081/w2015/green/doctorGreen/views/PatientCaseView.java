package ch.bfh.btx8081.w2015.green.doctorGreen.views;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.btx8081.w2015.green.doctorGreen.MyUI;

@SuppressWarnings("serial")
@Theme("mytheme")
@Widgetset("ch.bfh.btx8081.w2015.green.doctorGreen.MyAppWidgetset")
public class PatientCaseView extends VerticalLayout implements View {
	Grid patientCaseGrid = new Grid();

	public PatientCaseView() {
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
	}

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("");
	}

}
