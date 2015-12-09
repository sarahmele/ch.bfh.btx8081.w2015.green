package ch.bfh.btx8081.w2015.green.doctorGreen.views;

import java.io.File;
import java.util.Date;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Image;
import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.btx8081.w2015.green.doctorGreen.MyUI;

import com.vaadin.ui.Calendar;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

/**
 *
 */
@SuppressWarnings("serial")
@Theme("mytheme")
@Widgetset("ch.bfh.btx8081.w2015.green.doctorGreen.MyAppWidgetset")
public class HomeView extends VerticalLayout implements View {
	
	public HomeView() {
		setSizeFull();
		setSpacing(true);
		
		// Have a panel to put stuff in
		Panel panel = new Panel();

		// Have a horizontal split panel as its content
		HorizontalSplitPanel hsplit = new HorizontalSplitPanel();
		HorizontalSplitPanel hsplit2 = new HorizontalSplitPanel();
		panel.setContent(hsplit);
		panel.setContent(hsplit2);
		
		Calendar cal = new Calendar("Patient-Calendar");
		cal.setStartDate(new Date());
		cal.setEndDate(new Date());
		
		// Find the application directory
		String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
		// Image as a file resource
		FileResource resource = new FileResource(new File(basepath + "/VAADIN/images/doctor_green_small.png"));
		// Show the image in the application
		Image image = new Image("",resource);
		Button backButton = backButton();
		Button caseView_Button = caseView_Button();
		Button patientView_Button = patientView_Button();
		
		hsplit.setFirstComponent(backButton);
		hsplit.setSecondComponent(image);
		
		hsplit2.setFirstComponent(caseView_Button);
		hsplit2.setSecondComponent(patientView_Button);
		
		addComponent(hsplit);
		addComponent(hsplit2);
		addComponent(cal);
		setComponentAlignment(cal,Alignment.MIDDLE_CENTER);
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("Welcome! This is Home.");
	}
	
	private Button backButton() {
		Button button = new Button("Back", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.LOGINVIEW);
			}
		});
		return button;
	}
	
	private Button caseView_Button() {
		Button button = new Button("CaseView", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.CASEVIEW);
			}
		});
		return button;
	}
	private Button patientView_Button() {
		Button button = new Button("patientView", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.PATIENTVIEW);
			}
		});
		return button;
	}
}

