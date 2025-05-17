package com.gaysha.injection_component.services.impl.polish;

import com.gaysha.injection_component.services.GreenPrinter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("polishGreen")
// @Profile("polish")
public class PolishGreenPrinter implements GreenPrinter {
    @Override
    public String print() {
        return "Zielony";
    }
}
