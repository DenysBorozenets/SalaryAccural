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
    }
}
