package com.gaysha.injection_component;

import com.gaysha.injection_component.services.ColorPrinter;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log
public class InjectionComponentApplication implements CommandLineRunner {
	private final ColorPrinter colorPrinter;

	public InjectionComponentApplication(ColorPrinter colorPrinter) {
		this.colorPrinter = colorPrinter;
	}

	public static void main(String[] args) {
		SpringApplication.run(InjectionComponentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info(colorPrinter.print());
	}
}
