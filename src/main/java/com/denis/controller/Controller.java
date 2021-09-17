package com.denis.controller;

import com.denis.model.Model;
import com.denis.view.View;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void process() {
        Scanner scanner = new Scanner(System.in);
        fund(scanner);
    }

    public void fund(Scanner scanner) {
        view.printText(".....");
        model.setCompanyFond(getAnswer(scanner));
    }

    public boolean getAnswer(Scanner scanner) {
        view.printText(View.CHOOSE_YES_OR_NOT);
        String input = "";
        while (!(scanner.hasNext()
                && ((input = scanner.nextLine()).equalsIgnoreCase("Yes")
                || input.equalsIgnoreCase("No")))){
            view.printText(View.WRONG);
            view.printText(View.CHOOSE_YES_OR_NOT);
        }
        if (input.equalsIgnoreCase("Yes")) {
            return true;
        } else {
            return false;
        }
    }
}
