package model;

public class Employee extends User {

    private int riceSubsidy, phoneAllowance, clothingAllowance;
    private double hourlyRate, basicSalary;
    private String position, lastName, firstName, address, status, supervisor, fullName, phoneNumber, sssNumber, philhealthNumber, tinNumber, pagIbigNumber;


    public Employee(int userID, String birthDay, String lastName, String firstName, String position, String address, String phoneNumber,
                    String sssNumber, String philhealthNumber, String tinNumber, String pagibigNumber, String status,
                    String supervisor, int basicSalary, int riceSubsidy, int phoneAllowance, int clothingAllowance,
                    double hourlyRate) {
        super(userID, birthDay);
        this.position = position;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.sssNumber = sssNumber;
        this.philhealthNumber = philhealthNumber;
        this.tinNumber = tinNumber;
        this.pagIbigNumber = pagibigNumber;
        this.status = status;
        this.supervisor = supervisor;
        this.basicSalary = basicSalary;
        this.riceSubsidy = riceSubsidy;
        this.phoneAllowance = phoneAllowance;
        this.clothingAllowance = clothingAllowance;
        this.hourlyRate = hourlyRate;
    }
    public Employee(int userID, String birthDay, boolean isNewEmployee) {
        super(userID, birthDay);
        if (!isNewEmployee) {
            setEmployeeInformation();
        }
    }
    public Employee(int userID, boolean isNewEmployee) {
        super(userID);
    }
    public int getUserID() {
        return userID;
    }
    public String getBirthDay() {
        return birthday;
    }
    public int getRiceSubsidy() {
        return riceSubsidy;
    }

    public int getPhoneAllowance() {
        return phoneAllowance;
    }

    public int getClothingAllowance() {
        return clothingAllowance;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public String getPosition() {
        return position;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAddress() {
        return address;
    }

    public String getStatus() {
        return status;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSSSNumber() {
        return sssNumber;
    }

    public String getPhilHealthNumber() {
        return philhealthNumber;
    }

    public String getTINNumber() {
        return tinNumber;
    }

    public String getPagIbigNumber() {
        return pagIbigNumber;
    }



    private void setEmployeeInformation() {
        setFullName();
        setAddress();
        setPhoneNumber();
        setSSSNumber();
        setPagIbigNumber();
        setPhilHealthNumber();
        setTINNumber();
        setPosition();
        setStatus();
        setImmediateSupervisor();
        setBasicSalary();
        setRiceSubsidy();
        setPhoneAllowance();
        setClothingAllowance();
        setHourlyRate();
    }

    private void setFullName() {
        lastName = setEmployeeData(userID, 1);
        firstName = setEmployeeData(userID, 2);

        this.fullName = lastName + " " + firstName;
    }
    private void setAddress() {
        this.address = setEmployeeData(userID, 4);
    }
    private void setPhoneNumber() {
        this.phoneNumber = setEmployeeData(userID, 5);
    }

    private void setSSSNumber() {
        this.sssNumber = setEmployeeData(userID, 6);
    }

    private void setPhilHealthNumber() {
        this.philhealthNumber = setEmployeeData(userID, 7);
    }

    private void setTINNumber() {
        this.tinNumber = setEmployeeData(userID, 8);
    }

    private void setPagIbigNumber() {
        this.pagIbigNumber = setEmployeeData(userID, 9);
    }

    private void setStatus() {
        this.status = setEmployeeData(userID, 10);
    }

    private void setPosition() {
        this.position = setEmployeeData(userID, 11);
    }

    private void setImmediateSupervisor() {
        this.supervisor = setEmployeeData(userID, 12);
    }

    private void setBasicSalary() {
        this.basicSalary = Integer.parseInt(setEmployeeData(userID, 13).replace(",", ""));
    }

    private void setRiceSubsidy() {
        this.riceSubsidy = Integer.parseInt(setEmployeeData(userID, 14).replace(",", ""));
    }

    private void setPhoneAllowance() {
        this.phoneAllowance = Integer.parseInt(setEmployeeData(userID, 15).replace(",", ""));
    }

    private void setClothingAllowance() {
        this.clothingAllowance = Integer.parseInt(setEmployeeData(userID, 16).replace(",", ""));
    }

    private void setHourlyRate() {
        this.hourlyRate = Double.parseDouble(setEmployeeData(userID, 17));
    }




}
