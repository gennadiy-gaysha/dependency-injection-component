package com.gaysha.injection_component.services.impl.english;

import com.gaysha.injection_component.services.BluePrinter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("englishBlue")
// @Profile("english")
public class EnglishBluePrinter implements BluePrinter {
    @Override
    public String print(){
        return "Blue";
    }
}
