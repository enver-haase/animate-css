package com.infraleap.animatecss.demo;

import com.infraleap.animatecss.Animated;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * The main view contains a button and a click listener.
 */
@Route("")
public class MainView extends VerticalLayout {

    int count = 0;
    public MainView() {

        this.setSizeFull();
        this.setJustifyContentMode(JustifyContentMode.CENTER);

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setWidthFull();
        horizontalLayout.setJustifyContentMode(JustifyContentMode.CENTER);

        AnimSpan sandbox = new AnimSpan();
        sandbox.add(new H1("Animate.CSS"));

        horizontalLayout.add(sandbox);
        add(horizontalLayout);

        Button nextButton = new Button("Next Animation");
        add(nextButton);

        ComboBox<Animated.Animation> comboBox = new ComboBox<>();
        comboBox.setItems(Animated.Animation.values());
        comboBox.setItemLabelGenerator(Enum::name);
        comboBox.addValueChangeListener(event -> {
            Notification.show(event.getValue().name()+" (\""+event.getValue().toString()+"\")",5000, Notification.Position.BOTTOM_STRETCH );
            sandbox.animate(event.getValue());
        });
        comboBox.setValue(Animated.Animation.ROLL_IN);
        comboBox.setWidth("300px");
        add(comboBox);

        nextButton.addClickListener( e -> {
            count++;
            if (count >= Animated.Animation.values().length){
                count = 0;
            }
            comboBox.setValue(Animated.Animation.values()[count]);
        });
    }
}
