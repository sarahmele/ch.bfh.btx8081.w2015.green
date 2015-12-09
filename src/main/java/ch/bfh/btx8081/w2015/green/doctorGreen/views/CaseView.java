package ch.bfh.btx8081.w2015.green.doctorGreen.views;

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
import com.vaadin.ui.Label;
import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.btx8081.w2015.green.doctorGreen.MyUI;

import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;

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

		// Have a horizontal split panel as its content
		VerticalSplitPanel vsplit = new VerticalSplitPanel();
		
		panel.setContent(vsplit);
		
		TabSheet tabsheet = new TabSheet();
		tabsheet.setSizeUndefined();
		VerticalLayout tabs = new VerticalLayout();

		
		tabs.addComponent(new Label("Hello, I am a Tab!"));
		
		tabsheet.addTab(tabs);
		
		tabsheet.getTab(tabs).setCaption("My Tab");
		
		vsplit.setFirstComponent(tabs);
		addComponent(tabsheet);
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("PatientCase");
	}
	

}

