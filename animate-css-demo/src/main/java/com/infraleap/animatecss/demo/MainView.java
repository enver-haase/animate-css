package com.infraleap.animatecss.demo;

import com.infraleap.animatecss.Animated;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.router.Route;

import java.lang.annotation.ElementType;

/**
 * The main view contains a button and a click listener.
 */
@Route("")
public class MainView extends VerticalLayout {

    public MainView() {

        this.setSizeFull();
        this.setJustifyContentMode(JustifyContentMode.CENTER);

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setWidthFull();
        horizontalLayout.setJustifyContentMode(JustifyContentMode.CENTER);

        HorizontalLayout sandbox = new HorizontalLayout();
        sandbox.add(new H1("Animate.CSS"));

        horizontalLayout.add(sandbox);
        add(horizontalLayout);

        Button nextButton = new Button("Next Animation");
        add(nextButton);

        ComboBox<Animated.Animation> comboBox = new ComboBox<>();
        comboBox.setItems(Animated.Animation.values());
        comboBox.setItemLabelGenerator(Enum::name);
        comboBox.setWidth("300px");
        add(comboBox);

        ComboBox<Animated.Modifier> modifierComboBox = new ComboBox<>();
        modifierComboBox.setItems(Animated.Modifier.values());
        modifierComboBox.setItemLabelGenerator(Enum::name);
        modifierComboBox.setValue(Animated.Modifier.REPEAT_1);
        modifierComboBox.setWidth("300px");
        add(modifierComboBox);

        nextButton.addClickListener( e -> {
            int nextOrdinal = (comboBox.getValue().ordinal() + 1) % Animated.Animation.values().length;
            comboBox.setValue(Animated.Animation.values()[nextOrdinal]);
        });
        comboBox.addValueChangeListener(event -> {
            Animated.animate(sandbox, event.getValue(), modifierComboBox.getValue());
        });
        modifierComboBox.addValueChangeListener (event-> {
            Animated.animate(sandbox, comboBox.getValue(), event.getValue());
        } );

        comboBox.setValue(Animated.Animation.ROLL_IN);
    }
}
