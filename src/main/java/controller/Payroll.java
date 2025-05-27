package controller;

import model.Employee;

import java.util.Arrays;
import java.util.List;

public class Payroll {
    private Attendance attendance;
    private Employee employee;

    private double lateDeductions;
    private double overTimeAdditions;
    private double basicSalary;
    private double sssDeduction;
    private double pagIbigDeduction;
    private double philHealthDeduction;
    private double tax;
    private double totalEarnings;
    private double totalDeductions;
    private double taxableIncome;
    private double netPay;
    private double weeklyEarnings;
    private double totalAllowances;

    private double riceSubsidy;
    private double phoneAllowance;
    private double clothingAllowance;

    public String startDate;
    public String endDate;

    private int searchKey;

    public Payroll(Employee employee, String startDate, String endDate) {

        this.startDate = startDate;
        this.endDate = endDate;
        searchKey = employee.getUserID();
        attendance = new Attendance(searchKey, startDate, endDate);
        this.basicSalary = employee.getBasicSalary();
        this.employee = employee;
    }

    public void runPayroll() {
        computeDeductions();
        computeEarnings();
    }

    private void computeDeductions() {
        setSssDeduction();
        setPhilHealthDeduction();
        setPagIbigDeduction();
        setLateDeductions();
        setTax();
        setTotalDeduction();
    }
    private void computeEarnings() {
        setOverTimeAdditions();
        setWeeklyEarnings();
        setTotalAllowances();
        setTotalEarnings();
    }


    private void setLateDeductions() {
        lateDeductions = (attendance.getTotalLateMinutes() / 60.0) * employee.getHourlyRate();
    }
    private void setOverTimeAdditions() {
        overTimeAdditions = (attendance.getTotalOvertimeMinutes() / 60.0) * employee.getHourlyRate();
    }
    private void setWeeklyEarnings() {
        weeklyEarnings = (attendance.getTotalWorkMinutes() / 60.0) * employee.getHourlyRate();
    }

    private void setSssDeduction() {
        int[] sssContributionMin = {3250, 3750, 4250, 4750, 5250, 5750, 6250, 6750, 7250, 7750, 8250, 8750, 9250, 9750,
                10250, 10750, 11250, 11750, 12250, 12750, 13250, 13750, 14250, 14750, 15250, 15750, 16250, 16750, 17250,
                17750, 18250, 18750, 19250, 19750, 20250, 20750, 21250, 21750, 22250, 22750, 23250, 23750, 24250};
        int[] sssContributionMax = {3750, 4250, 4750, 5250, 5750, 6250, 6750, 7250, 7750, 8250, 8750, 9250, 9750,
                10250, 10750, 11250, 11750, 12250, 12750, 13250, 13750, 14250, 14750, 15250, 15750, 16250, 16750, 17250,
                17750, 18250, 18750, 19250, 19750, 20250, 20750, 21250, 21750, 22250, 22750, 23250, 23750, 24250,
                24750};
        double[] sssContributionValue = {157.50, 180.00, 202.50, 225.00, 247.50, 270.00, 292.50, 315.00, 337.50,
                360.00, 382.50, 405.00, 427.50, 450.00, 472.50, 495.00, 517.50, 540.00, 562.50, 585.00, 607.50, 630.00,
                652.50, 675.00, 697.50, 720.00, 742.50, 765.00, 787.50, 810.00, 832.50, 855.00, 877.50, 900.00, 922.50,
                945.00, 967.50, 990.00, 1012.50, 1035.00, 1057.50, 1080.00, 1102.50};

        if (basicSalary < sssContributionMin[0]) {
            sssDeduction = 135.00;
        } else if (basicSalary > sssContributionMax[sssContributionMax.length - 1]) {
            sssDeduction = 1125.00;
        } else {
            for (int i = 0; i < sssContributionMin.length; i++) {
                if (basicSalary >= sssContributionMin[i] && basicSalary <= sssContributionMax[i]) {
                    sssDeduction = sssContributionValue[i];
                    break;
                }
            }
        }

    }

    private void setPhilHealthDeduction() {

        philHealthDeduction = (basicSalary * 0.03) / 2;
    }

    private void setPagIbigDeduction() {

        if (basicSalary > 999 && basicSalary <= 1500) {
            pagIbigDeduction = basicSalary * 0.01;
        } else if (basicSalary > 1500 && basicSalary <= 10000) {
            pagIbigDeduction = basicSalary * 0.02;
        } else if (basicSalary > 10000) {
            pagIbigDeduction = 100.0;
        } else pagIbigDeduction = 0.0;
    }

    private void setTax() {

        setTaxableIncome();

        double[] thresholds = {20833, 33333, 66667, 166667, 666667};
        double[] baseTax = {0.0, 2500.0, 10833.33, 40833.33, 200833.33};
        double[] rates = {0.20, 0.25, 0.30, 0.32, 0.35};

        if (taxableIncome <= thresholds[0]) {
            tax = 0.0;
            return;
        }

        for (int i = thresholds.length - 1; i >= 0; i--) {
            if (taxableIncome > thresholds[i]) {
                tax = baseTax[i] + (taxableIncome - thresholds[i]) * rates[i];
                break;
            }
        }
    }

    private void setTaxableIncome() {
        taxableIncome = basicSalary - (sssDeduction + philHealthDeduction + pagIbigDeduction);
    }
    private void setTotalDeduction() {
        this.totalDeductions = sssDeduction + philHealthDeduction + pagIbigDeduction + tax;
    }
    private void setTotalEarnings() {
        this.totalEarnings = weeklyEarnings + overTimeAdditions;
    }
    private void setTotalAllowances() {

        this.riceSubsidy = employee.getRiceSubsidy();
        this.phoneAllowance = employee.getPhoneAllowance();
        this.clothingAllowance = employee.getClothingAllowance();

        this.totalAllowances = riceSubsidy + phoneAllowance + clothingAllowance;
    }

    public double getWeeklyEarnings() {
        return weeklyEarnings;
    }
    public double getOvertimeAdditions() {
        return overTimeAdditions;
    }
    public double getLateDeductions() {
        return lateDeductions;
    }

    public double getSssDeduction() {
        return sssDeduction;
    }

    public double getPagIbigDeduction() {
        return pagIbigDeduction;
    }

    public double getPhilHealthDeduction() {
        return philHealthDeduction;
    }

    public double getTax() {
        return tax;
    }

    public double getNetPay() {
        return netPay = totalEarnings + (totalAllowances/4.33) - totalDeductions;
    }
    public double getRiceSubsidy() {
        return riceSubsidy;
    }

    public double getPhoneAllowance() {
        return phoneAllowance;
    }

    public double getClothingAllowance() {
        return clothingAllowance;
    }
    public double getTotalEarnings() {
        return totalEarnings;
    }
    public double getTotalDeductions() {
        return totalDeductions;
    }
    public double getTotalAllowances() {
        return totalAllowances;
    }

    //Employee related information
    public double getHourlyRate() {
        return employee.getHourlyRate();
    }
    public int getOvertimeHours() {
        return attendance.getTotalOvertimeMinutes()/60;
    }
    public int getWorkingHours() {
        return attendance.getTotalWorkMinutes()/60;
    }

}