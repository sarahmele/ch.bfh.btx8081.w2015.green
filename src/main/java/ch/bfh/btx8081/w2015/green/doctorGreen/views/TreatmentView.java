package ch.bfh.btx8081.w2015.green.doctorGreen.views;

import java.io.File;
import java.util.Date;

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

@SuppressWarnings("serial")
@Theme("mytheme")
@Widgetset("ch.bfh.btx8081.w2015.green.doctorGreen.MyAppWidgetset")
public class TreatmentView extends VerticalLayout implements View {

	public TreatmentView() {
		setSizeFull();
		setSpacing(true);
		
		// Panel to write down patient's treatment plan or whatever, I'm not a doc
		Panel treatmentPanel = new Panel();
		TabSheet tabsheet = new TabSheet();
		
		/* backButton is acting like a little faggot, will fix later 
		Button backButton = backButton();
		*/
		
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
