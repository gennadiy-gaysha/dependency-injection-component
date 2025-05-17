package com.gaysha.injection_component.services.impl.english;

import com.gaysha.injection_component.services.GreenPrinter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("englishGreen")
// @Profile("english")
public class EnglishGreenPrinter implements GreenPrinter {
    @Override
    public String print(){
        return "Green";
    }
}
