package com.intive.intivepatronage.feature;

import org.springframework.stereotype.Component;

@Component
public class ConsoleColors {
    private final String BLUE = "\033[0;34m";
    private final String CYAN = "\033[0;36m";
    private final String RED = "\033[0;31m";
    private final String GREEN_UNDERLINED = "\033[4;32m";
    private final String RESET = "\033[0m";

    public ConsoleColors() {
    }

    public String getBLUE() {
        return BLUE;
    }

    public String getCYAN() {
        return CYAN;
    }

    public String getRED() {
        return RED;
    }

    public String getGREEN_UNDERLINED() {
        return GREEN_UNDERLINED;
    }

    public String getRESET() {
        return RESET;
    }
}
