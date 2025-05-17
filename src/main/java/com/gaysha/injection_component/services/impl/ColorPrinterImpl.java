package com.gaysha.injection_component.services.impl;

import com.gaysha.injection_component.services.BluePrinter;
import com.gaysha.injection_component.services.ColorPrinter;
import com.gaysha.injection_component.services.GreenPrinter;
import com.gaysha.injection_component.services.RedPrinter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ColorPrinterImpl implements ColorPrinter {
    private final RedPrinter redPrinter;
    private final BluePrinter bluePrinter;
    private final GreenPrinter greenPrinter;

    public ColorPrinterImpl(
            @Qualifier("englishRed") RedPrinter redPrinter,
            @Qualifier("englishBlue") BluePrinter bluePrinter,
            @Qualifier("englishGreen") GreenPrinter greenPrinter
//            @Qualifier("polishRed") RedPrinter redPrinter,
//            @Qualifier("polishBlue") BluePrinter bluePrinter,
//            @Qualifier("polishGreen") GreenPrinter greenPrinter
    ) {
        this.redPrinter = redPrinter;
        this.bluePrinter = bluePrinter;
        this.greenPrinter = greenPrinter;
    }

    @Override
    public String print() {
        return "INFO: " + String.join(
                ", ",
                redPrinter.print(),
                bluePrinter.print(),
                greenPrinter.print());
    }
}
