package com.infraleap.animatecss;

import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.dependency.CssImport;

@CssImport("./animate.css")
public interface Animated extends HasStyle {

    default void animate(Animation anim){
        animate(this, anim);
    }

    default void animate(Animation anim, Modifier mod){
        animate(this, anim, mod);
    }

    default void removeAnimations(){
        removeAnimations(this);
    }

    static void animate(HasStyle component, Animation anim){
        removeAnimations(component);
        component.addClassName("animate__"+anim.toString());
        component.addClassName("animate__animated");
    }

    static void animate(HasStyle component, Animation anim, Modifier mod){
        animate(component, anim);
        component.addClassName("animate__"+mod.toString());
    }

    static void removeAnimations(HasStyle component){
        for (Animation anim : Animation.values()) {
            component.removeClassName("animate__"+anim.toString());
        }
        for (Modifier mod : Modifier.values()) {
            component.removeClassName("animate__"+mod.toString());
        }
        component.removeClassName("animate__animated");
    }

    enum Animation {
        BOUNCE("bounce"),
        FLASH("flash"),
        PULSE("pulse"),
        RUBBER_BAND("rubberBand"),
        SHAKE_X("shakeX"),
        SHAKE_Y("shakeY"),
        HEADSHAKE("headShake"),
        SWING("swing"),
        TADA("tada"),
        WOBBLE("wobble"),
        JELLO("jello"),
        HEART_BEAT("heartBeat"),
        BACK_IN_DOWN("backInDown"),
        BACK_IN_LEFT("backInLeft"),
        BACK_IN_RIGHT("backInRight"),
        BACK_IN_UP("backInUp"),
        BACK_OUT_DOWN("backOutDown"),
        BACK_OUT_LEFT("backOutLeft"),
        BACK_OUT_RIGHT("backOutRight"),
        BACK_OUT_UP("backOutUp"),
        BOUNCE_IN("bounceIn"),
        BOUNCE_IN_DOWN("bounceInDown"),
        BOUNCE_IN_LEFT("bounceInLeft"),
        BOUNCE_IN_RIGHT("bounceInRight"),
        BOUNCE_IN_UP("bounceInUp"),
        BOUNCE_OUT("bounceOut"),
        BOUNCE_OUT_DOWN("bounceOutDown"),
        BOUNCE_OUT_LEFT("bounceOutLeft"),
        BOUNCE_OUT_RIGHT("bounceOutRight"),
        BOUNCE_OUT_UP("bounceOutUp"),
        FADE_IN("fadeIn"),
        FADE_IN_DOWN("fadeInDown"),
        FADE_IN_DOWN_BIG("fadeInDownBig"),
        FADE_IN_LEFT("fadeInLeft"),
        FADE_IN_LEFT_BIG("fadeInLeftBig"),
        FADE_IN_RIGHT("fadeInRight"),
        FADE_IN_RIGHT_BIG("fadeInRightBig"),
        FADE_IN_UP("fadeInUp"),
        FADE_IN_UP_BIG("fadeInUpBig"),
        FADE_IN_TOP_LEFT("fadeInTopLeft"),
        FADE_IN_TOP_RIGHT("fadeInTopRight"),
        FADE_IN_BOTTOM_LEFT("fadeInBottomLeft"),
        FADE_IN_BOTTOM_RIGHT("fadeInBottomRight"),
        FADE_OUT("fadeOut"),
        FADE_OUT_DOWN("fadeOutDown"),
        FADE_OUT_DOWN_BIG("fadeOutDownBig"),
        FADE_OUT_LEFT("fadeOutLeft"),
        FADE_OUT_LEFT_BIG("fadeOutLeftBig"),
        FADE_OUT_RIGHT("fadeOutRight"),
        FADE_OUT_RIGHT_BIG("fadeOutRightBig"),
        FADE_OUT_UP("fadeOutUp"),
        FADE_OUT_UP_BIG("fadeOutUpBig"),
        FADE_OUT_TOP_LEFT("fadeOutTopLeft"),
        FADE_OUT_TOP_RIGHT("fadeOutTopRight"),
        FADE_OUT_BOTTOM_LEFT("fadeOutBottomLeft"),
        FADE_OUT_BOTTOM_RIGHT("fadeOutBottomRight"),
        FLIP("flip"),
        FLIP_IN_X("flipInX"),
        FLIP_IN_Y("flipInY"),
        FLIP_OUT_X("flipOutX"),
        FLIP_OUT_Y("flipOutY"),
        LIGHT_SPEED_IN("lightSpeedIn"),
        LIGHT_SPEED_OUT("lightSpeedOut"),
        ROTATE_IN("rotateIn"),
        ROTATE_IN_DOWN_LEFT("rotateInDownLeft"),
        ROTATE_IN_DOWN_RIGHT("rotateInDownRight"),
        ROTATE_IN_UP_LEFT("rotateInUpLeft"),
        ROTATE_IN_UP_RIGHT("rotateInUpRight"),
        ROTATE_OUT("rotateOut"),
        ROTATE_OUT_DOWN_LEFT("rotateOutDownLeft"),
        ROTATE_OUT_DOWN_RIGHT("rotateOutDownRight"),
        ROTATE_OUT_UP_LEFT("rotateOutUpLeft"),
        ROTATE_OUT_UP_RIGHT("rotateOutUpRight"),
        SLIDE_IN_UP("slideInUp"),
        SLIDE_IN_DOWN("slideInDown"),
        SLIDE_IN_LEFT("slideInLeft"),
        SLIDE_IN_RIGHT("slideInRight"),
        SLIDE_OUT_UP("slideOutUp"),
        SLIDE_OUT_DOWN("slideOutDown"),
        SLIDE_OUT_LEFT("slideOutLeft"),
        SLIDE_OUT_RIGHT("slideOutRight"),
        ZOOM_IN("zoomIn"),
        ZOOM_IN_DOWN("zoomInDown"),
        ZOOM_IN_LEFT("zoomInLeft"),
        ZOOM_IN_RIGHT("zoomInRight"),
        ZOOM_IN_UP("zoomInUp"),
        ZOOM_OUT("zoomOut"),
        ZOOM_OUT_DOWN("zoomOutDown"),
        ZOOM_OUT_LEFT("zoomOutLeft"),
        ZOOM_OUT_RIGHT("zoomOutRight"),
        ZOOM_OUT_UP("zoomOutUp"),
        HINGE("hinge"),
        JACK_IN_THE_BOX("jackInTheBox"),
        ROLL_IN("rollIn"),
        ROLL_OUT("rollOut");

        private final String classname;
        Animation(String classname){
            this.classname = classname;
        }

        public String toString(){
            return classname;
        }
    }

    enum Modifier {
        INFINITE("infinite"),
        REPEAT_1("repeat-1"),
        REPEAT_2("repeat-2"),
        REPEAT_3("repeat-3"),
        DELAY_1S("delay-1s"),
        DELAY_2S("delay-2s"),
        DELAY_3S("delay-3s"),
        DELAY_4S("delay-4s"),
        DELAY_5S("delay-5s"),
        FASTER("faster"),
        FAST("fast"),
        SLOW("slow"),
        SLOWER("slower");

        private final String classname;
        Modifier(String classname){
            this.classname = classname;
        }

        public String toString(){
            return classname;
        }
    }

}
