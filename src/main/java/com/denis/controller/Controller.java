package com.denis.controller;

import com.denis.model.Department;
import com.denis.model.Fund;
import com.denis.model.ManagerDepartment;
import com.denis.model.Model;
import com.denis.model.pay.Payroll;
import com.denis.view.View;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        BigDecimal minValue = model.getMinFund();
        Fund fundCompany = initFundWithSize(scanner, View.COMPANY_NAME.toLowerCase(Locale.ROOT), minValue);
        model.setFund(fundCompany);
        initDepartmentTypeOfFund(scanner, model.getDepartmentList());
        model.setFundTypeForOthers(initOtherTypeOffFund(scanner));
        Payroll payroll = model.calculatePayroll(getUserCalcDateAnswer(scanner));
        view.printPayroll(payroll);

    }

    public void initDepartmentTypeOfFund(Scanner scanner, List<ManagerDepartment> departmentList) {
        for (ManagerDepartment d: departmentList) {
            Fund.Balance fundType = initFundType(scanner, d.getName().toLowerCase(Locale.ROOT));
            d.setFund(new Fund(fundType));
        }
    }

    public Fund.Balance initOtherTypeOffFund(Scanner scanner) {
        //Fund.Balance fund = initFundType(scanner, View.OTHER_NAME.toLowerCase(Locale.ROOT));
        return initFundType(scanner, View.OTHER_NAME.toLowerCase(Locale.ROOT));
    }

    public Fund initFundWithSize(Scanner scanner, String fundName, BigDecimal minValue) {

        BigDecimal sizeFund = new BigDecimal("0");
        view.printText(String.format(View.MIN_SALARY_FUND_MESSAGE, minValue.toString()));
        while ((sizeFund = getUserValueAnswer(scanner)).compareTo(minValue)<0){
            view.printText(View.WRONG_SALARY_FUND);
            view.printText(String.format(View.MIN_SALARY_FUND_MESSAGE, minValue.toString()));
        }
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

    public Date getUserCalcDateAnswer(Scanner sc){
        view.printText(View.INPUT_CALC_DATE);
        String input = "";
        Date date = null;
        boolean isNotExceptionParse = false;
        while (!isNotExceptionParse) {
            while (!(sc.hasNext() && ((input = sc.next()).matches(View.INPUT_CALC_DATE_REGEX)))) {
                view.printText(View.WRONG);
                view.printText(View.INPUT_CALC_DATE);
            }
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            isNotExceptionParse= true;
            try {
                date = formatter.parse(input);
            } catch (ParseException e) {
                view.printText(View.WRONG);
                view.printText(View.INPUT_CALC_DATE);
            }
        }

        return date;
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
