package ch.bfh.btx8081.w2015.green.doctorGreen.views;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.btx8081.w2015.green.doctorGreen.MyUI;

@SuppressWarnings("serial")
@Theme("mytheme")
@Widgetset("ch.bfh.btx8081.w2015.green.doctorGreen.MyAppWidgetset")
public class PatientView extends VerticalLayout implements View {
	
	public PatientView() {
		setSizeFull();
		setSpacing(true);
	}
		// Have a panel to put stuff in
		Panel panel = new Panel();
		
		HorizontalSplitPanel hsplit = new HorizontalSplitPanel();
		
		panel.setContent(hsplit);
		
		Button homeView_Button = homeView_Button();
		
		hsplit.setFirstComponent(backButton);
		
		addComponent(hsplit);
		addComponent(cal);
		setComponentAlignment(cal,Alignment.MIDDLE_CENTER);
		
		
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

	private Button homeView_Button() {
		Button button = new Button("HomeView", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.HOMEVIEW);
			}
		});
		return button;
	}
}
