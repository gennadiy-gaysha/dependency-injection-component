# InjectionComponentApplication

## Overview

This Spring Boot project demonstrates the use of **Dependency Injection** leveraging the `@Component` annotation to wire beans automatically. The application is designed with educational purposes in mind, illustrating how to use both the `@Qualifier` and `@Profile` annotations to manage multiple bean implementations and activate different profiles.

---

## Key Features

* **Dependency Injection with `@Component`**
  Beans are created and managed by Spring’s IoC container using the `@Component` annotation for automatic detection and wiring.

* **Use of `@Qualifier` Annotation**
  Demonstrates resolving ambiguity when multiple beans of the same type exist by specifying bean names using `@Qualifier`.

* **Use of `@Profile` Annotation (commented for testing)**
  Shows how to separate bean definitions by environment or profile, allowing runtime selection of the active profile.

* **CommandLineRunner Integration**
  Application implements `CommandLineRunner` to execute logic at startup and demonstrate the injected beans’ functionality.

---

## Code Structure

### InjectionComponentApplication.java

```java
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
```

* The main application class uses constructor injection to obtain an instance of `ColorPrinter`.
* Implements `CommandLineRunner` to invoke `colorPrinter.print()` upon startup.

---

### ColorPrinterImpl.java

```java
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
```

* Implements the `ColorPrinter` interface.
* Uses constructor injection with `@Qualifier` annotations to specify which bean implementations should be injected.
* For educational purposes, alternative qualifiers for different profiles (e.g., Polish vs. English) are commented out, enabling easy switching for testing.

---

## Profiles and Qualifiers

The project supports multiple implementations of printers differentiated by qualifiers or profiles:

* **Qualifiers:**
  Used to explicitly specify which bean instance should be injected when multiple implementations exist.

* **Profiles:**
  Beans can be annotated with `@Profile` to be activated only under certain Spring profiles. This is useful to switch between different language sets or environments.

Example `application.properties` for activating a profile:

```properties
# Uncomment one to activate profile
# spring.profiles.active=english
# spring.profiles.active=polish
```

---

## How to Run

1. Clone the repository.
2. Uncomment the desired `@Qualifier` or set the active profile in `application.properties`.
3. Build and run the application with:

```bash
./mvnw spring-boot:run
```

4. Observe the logged output showcasing the injected bean behaviors.

---

## Educational Notes

* This project is designed for learning and demonstration.
* Switching between `@Qualifier` and `@Profile` strategies is made simple by commenting/uncommenting relevant code sections.
* It illustrates clean separation of concerns and flexible configuration of beans in Spring.

---
