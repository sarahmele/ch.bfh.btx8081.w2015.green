package ch.bfh.btx8081.w2015.green.doctorGreen.views;

import java.io.File;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FileResource;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinService;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.btx8081.w2015.green.doctorGreen.MyUI;

import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;
import com.vaadin.ui.themes.ValoTheme;

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

		
		
		
		
		TabSheet caseTab = new TabSheet();
		caseTab.setHeight(100.0f, Unit.PERCENTAGE);
		caseTab.addStyleName(ValoTheme.TABSHEET_FRAMED);
		caseTab.addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);
 

            final VerticalLayout layout = new VerticalLayout(new Label(
            getLoremContent(), ContentMode.HTML));		
            layout.setMargin(true);
            caseTab.addTab(layout, "Case");
            caseTab.addTab(layout, "Treatment");
		
            panel.setContent(layout);
		
    		addComponent(layout);

	}

	// for testing purposes. Delete when test was successfull
	private String getLoremContent() {
		String testString = "potato potato potato potato";
		return testString;
	}
	
	// Dummy test Button
			private Button testButton() {
				Button button = new Button("CaseView", new Button.ClickListener() {
					@Override
					public void buttonClick(ClickEvent event) {
						getUI().getNavigator().navigateTo(MyUI.HOMEVIEW);
					}
				});
				return button;
			}

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("PatientCase");
	}
	

}

