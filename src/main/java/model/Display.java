package model;
import controller.Payroll;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Display {

    public void showEmployeeProfile(Employee employee, JTextArea textArea) {
        String message = "EMPLOYEE PROFILE\n\n"

                + "Personal Information\n\n"
                + "Full name: " + employee.getFullName() + "\n"
                + "Date of Birth: " + employee.getBirthDay() + "\n"
                + "Address: " + employee.getAddress() + "\n"
                + "Phone No.: +" + employee.getPhoneNumber() + "\n"
                + "SSS No.: " + employee.getSSSNumber() + "\n"
                + "Pagibig No.: " + employee.getPagIbigNumber() + "\n"
                + "Philhealth No.: " + employee.getPhilHealthNumber() + "\n"
                + "Tax No.: " + employee.getTINNumber() + "\n\n"

                + "Employment Information\n\n"
                + "Position: " + employee.getPosition() + "\n"
                + "Status: " + employee.getStatus() + "\n"
                + "Supervisor: " + employee.getSupervisor() + "\n\n"

                + "Compensation and Benefits\n\n"
                + "Basic Salary: Php " + employee.getBasicSalary() + "\n"
                + "Rice Subsidy: Php " + employee.getRiceSubsidy() + "\n"
                + "Phone: Php " + employee.getPhoneAllowance() + "\n"
                + "Clothing: Php " + employee.getClothingAllowance() + "\n"
                + "Hourly Rate: Php " + employee.getHourlyRate();

        textArea.setText(message);
    }





}
