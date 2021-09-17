package com.denis;

import com.denis.controller.Controller;
import com.denis.model.Model;
import com.denis.view.View;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Model model = new Model(new ArrayList<>(), new ArrayList<>());
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.process();
    }
}
