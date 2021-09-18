package com.denis;

import com.denis.controller.Controller;
import com.denis.model.Model;
import com.denis.model.database.DataBase;
import com.denis.model.exception.NotCorrectSalaryAmount;
import com.denis.view.View;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws NotCorrectSalaryAmount {
        Model model = new Model(DataBase.initDepart(), DataBase.initOther());
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.process();
    }
}
