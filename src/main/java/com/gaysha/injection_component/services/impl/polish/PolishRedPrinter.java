package com.gaysha.injection_component.services.impl.polish;

import com.gaysha.injection_component.services.RedPrinter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("polishRed")
// @Profile("polish")
public class PolishRedPrinter implements RedPrinter {
    @Override
    public String print() {
        return "Czerwony";
    }
}
