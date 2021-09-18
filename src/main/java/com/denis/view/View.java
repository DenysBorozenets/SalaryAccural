package com.denis.view;

import com.denis.model.pay.PayForOne;
import com.denis.model.pay.Payroll;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import de.vandermeer.asciitable.AsciiTable;

public class View {

    public static String CHOOSE_YES_OR_NOT = "Choose yes or not ";
    public static String MIN_SALARY_FUND_MESSAGE = "Min value is %s ";
    public static String WRONG = "Some  error ";
    public static String INPUT_CALC_DATE = "Input a calculated date in format [dd/mm/yyyy] ";
    public static String INPUT_CALC_DATE_REGEX = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$";
    public static String WRONG_SALARY_FUND = "Salary fund is less than need";
    public static String INPUT_SALARY_FUND = "Input salary fund company ";
    public static String IS_BALANCED_MASSAGE = "Is balanced %s fund?";
    public static String OTHER_NAME = "Others";
    public static String COMPANY_NAME = "Company";
    public void printText(String message) {
        System.out.println(message);
    }

    public void printPayroll(Payroll payroll){
        AsciiTable at = new AsciiTable();

        at.addRule();
        at.addRow(generateFirstRow(new String[]{"Name", "Department", "Rate", "Salary","Premium"}));
        at.addRule();

        for (PayForOne person: payroll.personList){
            at.addRow(generateRow(person));
            at.addRule();
        }

        at.addRow(generateFinalRow(payroll));
        at.addRule();
        this.printText(at.render());
    }


    private static String[] generateFirstRow(String[] collumName){
        List<String> firstRow = new ArrayList<>();
        for (String moveTmp: collumName) {
            firstRow.add(moveTmp);
        }
        return firstRow.toArray(new String[0]);
    }

    private static String[] generateRow(PayForOne payForOnePerson){
        List<String> row = new ArrayList<>();
        row.add(payForOnePerson.getEmployee().getName());
        row.add(payForOnePerson.getDepartmentName());
        row.add(payForOnePerson.getEmployee().getSalary().toString());
        row.add(payForOnePerson.getSalary().toString());
        row.add(payForOnePerson.getPremium().toString());

        return row.toArray(new String[0]);
    }

    private static String[] generateFinalRow(Payroll payroll){
        List<String> finalRow = new ArrayList<>();

        BigDecimal rate = new BigDecimal("0");
        BigDecimal salary = new BigDecimal("0");
        BigDecimal premium = new BigDecimal("0");

        for(PayForOne person: payroll.personList){
            rate = rate.add(person.getEmployee().getSalary());
            salary = salary.add(person.getSalary());
            premium = premium.add(person.getPremium());
        }

        finalRow.add("-");
        finalRow.add("-");
        finalRow.add(rate.toString());
        finalRow.add(salary.toString());
        finalRow.add(premium.toString());

        return finalRow.toArray(new String[0]);
    }
}
