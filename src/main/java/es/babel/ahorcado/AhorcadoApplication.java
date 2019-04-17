package es.babel.ahorcado;

import es.babel.ahorcado.model.entities.Subject;
import es.babel.ahorcado.model.manager.ThemeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AhorcadoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AhorcadoApplication.class, args);
    }

}
