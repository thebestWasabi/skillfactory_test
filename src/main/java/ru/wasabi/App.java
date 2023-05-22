package ru.wasabi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.wasabi.config.AppConfig;
import ru.wasabi.ui.MainMenu;

public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MainMenu menu = context.getBean(MainMenu.class);
        menu.printMenu();
        context.close();
    }
}
