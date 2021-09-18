package com.denis.controller;

import com.denis.model.Department;
import com.denis.model.Fund;
import com.denis.model.Model;
import com.denis.view.View;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
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
        Fund fundCompany = initFundWithSize(scanner, "company");
        model.setFund(fundCompany);
        initDepartmentTypeOffFund(scanner, model.getDepartmentList());
        model.setFundTypeForOthers(initOtherTypeOffFund(scanner));

    }

    public void initDepartmentTypeOffFund(Scanner scanner, List<Department> departmentList) {
        for (Department d:model.getDepartmentList()) {
//            Fund fund = initFundWithSize(scanner, d.getName().toLowerCase(Locale.ROOT));
//            d.setFund(fund);
            Fund.Balance fundType = initFundType(scanner, d.getName().toLowerCase(Locale.ROOT));
            d.setFund(new Fund(fundType));
        }
    }

    public Fund.Balance initOtherTypeOffFund(Scanner scanner) {
        //Fund.Balance fund = initFundType(scanner, View.OTHER_NAME.toLowerCase(Locale.ROOT));
        return initFundType(scanner, View.OTHER_NAME.toLowerCase(Locale.ROOT));
    }

    public Fund initFundWithSize(Scanner scanner, String fundName) {
        BigDecimal sizeFund = getUserValueAnswer(scanner);
//        view.printText(String.format(View.IS_BALANCED_MASSAGE, fundName));
//        boolean isBalanced = getAnswer(scanner);
//        Fund.Balance balance = Fund.Balance.UNBALANCED;
//        if (isBalanced) {
//            balance = Fund.Balance.BALANCED;
//        }
        Fund.Balance balance = initFundType(scanner, fundName);
        return new Fund(sizeFund,balance);

    }

    public boolean getAnswer(Scanner scanner) {
        view.printText(View.CHOOSE_YES_OR_NOT);
        String input = "";
        while (!(scanner.hasNext() && ((input = scanner.next()).equalsIgnoreCase("Yes")
                || input.equalsIgnoreCase("No")))){
            view.printText(View.WRONG);
            view.printText(View.CHOOSE_YES_OR_NOT);
        }
        return false;
    }

    public BigDecimal getUserValueAnswer(Scanner scanner) {
        view.printText(View.INPUT_SALARY_FUND);
        String input = "";

        while (!scanner.hasNextDouble()) {
            view.printText(View.WRONG);
            view.printText(View.INPUT_SALARY_FUND);
            scanner.next();
        }

        return new BigDecimal(scanner.nextDouble());
    }

    public Fund.Balance initFundType(Scanner scanner, String fundName) {
        view.printText(String.format(View.IS_BALANCED_MASSAGE, fundName));
        boolean isBalanced = getAnswer(scanner);
        Fund.Balance balance = Fund.Balance.UNBALANCED;
        if (isBalanced){
            balance = Fund.Balance.BALANCED;
        }
        return balance;
    }

}
