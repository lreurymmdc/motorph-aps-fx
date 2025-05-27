package model;

import repository.FileHandler;

import javax.swing.*;
import java.util.List;

class User {

    private boolean isUserIDValid = false;
    private boolean isBirthdayValid = false;

    protected int userID;
    protected String birthday;

    private final FileHandler fileHandler =  new FileHandler("HR");
    private final List<String[]> employeeList = fileHandler.getRecords();

    private int searchKey;

    public User(int userID, String birthday) {
        setUserId(userID);
        setBirthday(birthday);
    }
    public User(int userID) {
        setUserId(userID);
        searchKey = getIndexOfUserID(userID);
        setBirthday(employeeList.get(searchKey)[3]);
    }
    public boolean getCredentialsValid() {
        if (isUserIDValid && isBirthdayValid) {
            return true;
        }
        return false;
    }
    private void setUserId(int userID) {
        if(validateCredentials(String.valueOf(userID))){
            this.userID = userID;
            isUserIDValid = true;
        }
        else {
            JOptionPane.showMessageDialog(null, "Invalid User ID");
        }
    }
    private void setBirthday(String birthday) {
        if (validateCredentials(birthday)) {
           searchKey = getIndexOfUserID(userID);
            if (birthday.equalsIgnoreCase(employeeList.get(searchKey)[3])) {
                this.birthday = birthday;
                isBirthdayValid = true;
            }
            else {
                JOptionPane.showMessageDialog(null, "Birthday did not match" + searchKey, "Error: Records did not match", JOptionPane.ERROR_MESSAGE);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Birthday is not found", "Error: Records is not found", JOptionPane.ERROR_MESSAGE);
        }


    }
    private boolean validateCredentials(String data) {
        return fileHandler.validateData(data);
    }
    private int getIndexOfUserID(int userID) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i)[0].equals(String.valueOf(userID))) {
                return i;
            }
        }
        return -1;
    }

    protected String setEmployeeData(int userID, int field) {
        searchKey = getIndexOfUserID(userID);
        return employeeList.get(searchKey)[field];
    }
}
