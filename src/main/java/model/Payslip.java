package model;

import controller.Payroll;

import javax.swing.*;
import java.awt.*;

public class Payslip {

    public void generatePayslip(Payroll p, JTextArea textArea) {

        String message = "----- PAYSLIP -----\n" +
                "Pay Period: " + p.startDate + " to " + p.endDate + "\n\n" +

                "Earnings\n" +
                String.format("Hourly Rate:\t\t%.2f\n", p.getHourlyRate()) +
                String.format("Total Hours Worked:\t%d\n", p.getWorkingHours()) +
                String.format("Overtime Hours:\t\t%d\n", p.getOvertimeHours()) +
                String.format("Basic Pay:\t\t%.2f\n", p.getWeeklyEarnings()) +
                String.format("Overtime Pay:\t\t%.2f\n", p.getOvertimeAdditions()) +
                String.format("Total Earnings:\t\t%.2f\n", p.getTotalEarnings()) + "\n" +

                "Benefits\n" +
                String.format("Rice Subsidy:\t\t%.2f\n", p.getRiceSubsidy()/4.33) +
                String.format("Phone Allowance:\t%.2f\n", p.getPhoneAllowance()/4.33) +
                String.format("Clothing Allowance:\t%.2f\n", p.getClothingAllowance()/4.33) +
                String.format("Total Benefits:\t\t%.2f\n", p.getTotalAllowances()/4.33) + "\n" +

                "Deductions\n" +
                String.format("Late Deductions:\t%.2f\n", p.getLateDeductions()) +
                String.format("SSS:\t\t\t%.2f\n", p.getSssDeduction() / 4.33) +
                String.format("PhilHealth:\t\t%.2f\n", p.getPhilHealthDeduction() / 4.33) +
                String.format("Pag-IBIG:\t\t%.2f\n", p.getPagIbigDeduction() / 4.33) +
                String.format("Tax:\t\t\t%.2f\n", p.getTax() / 4.33) +
                String.format("Total Deductions:\t%.2f\n", p.getTotalDeductions()) + "\n" +

                "Summary\n" +
                String.format("Total Earnings:\t\t%.2f\n", p.getTotalEarnings()) +
                String.format("Total Benefits:\t\t%.2f\n", p.getTotalAllowances()/4.33) +
                String.format("Total Deductions:\t%.2f\n", p.getTotalDeductions()) +
                String.format("Net Pay:\t\t\t%.2f\n", p.getNetPay());

        textArea.setText(message);
    }
}
