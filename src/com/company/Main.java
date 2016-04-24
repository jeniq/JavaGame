package com.company;

import javax.xml.bind.SchemaOutputResolver;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Initialization
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        // Run
        controller.processUser();
    }

}
