package com.gaysha.injection_component.services.impl.polish;

import com.gaysha.injection_component.services.BluePrinter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("polishBlue")
// @Profile("polish")
public class PolishBluePrinter implements BluePrinter {
    @Override
    public String print() {
        return "Niebieski";
    }
}
