package views;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
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
		
		Label label = new Label("Home");
		addComponent(label);
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("Welcome! This is Home.");
	}
	
	private Button homeButton() {
		Button button = new Button("Log In", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
			//	getUI().getNavigator().navigateTo(NavigationExampleUI.MAINVIEW);
			}
		});
		return button;
	}
}

