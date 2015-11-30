package views;

import java.io.File;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FileResource;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Button;
import com.vaadin.ui.Image;
import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.btx8081.w2015.green.doctorGreen.MyUI;

import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

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
		TabSheet tabsheet = new TabSheet();
		
		// Have a horizontal split panel as its content
		HorizontalSplitPanel hsplit = new HorizontalSplitPanel();
		panel.setContent(hsplit);
		

		// Create the treatmentTab
		VerticalLayout treatmentTab = new VerticalLayout();
		treatmentTab.addComponent(new Embedded(null,
		        new ThemeResource("img/planets/Mercury.jpg")));
		tabsheet.addTab(treatmentTab, "Treatment",
		        new ThemeResource("img/planets/Mercury_symbol.png"));
		
		
		
		// Find the application directory
		String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
		// Image as a file resource
		FileResource resource = new FileResource(new File(basepath + "/VAADIN/images/doctor_green_small.png"));
		// Show the image in the application
		Image image = new Image("",resource);
		Button backButton = backButton();
		
		hsplit.setFirstComponent(backButton);
		hsplit.setSecondComponent(image);
		
		addComponent(hsplit);

		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("Welcome! This is Home.");
	}
	
	private Button backButton() {
		Button button = new Button("Back", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.HOMEVIEW);
			}
		});
		return button;
	}
}

