package com.gaysha.injection_component.services.impl.english;

import com.gaysha.injection_component.services.RedPrinter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("englishRed")
// @Profile("english")
public class EnglishRedPrinter implements RedPrinter {
    @Override
    public String print() {
        return "Red";
    }
}
