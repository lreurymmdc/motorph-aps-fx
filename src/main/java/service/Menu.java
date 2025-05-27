package service;

import controller.Payroll;
import model.Display;
import model.Employee;
import model.Payslip;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class Menu extends JFrame {
    private JPanel menuWindow;
    private JPanel profileBtnPanel;
    private JButton displayBtn;
    private JLabel displayProfileLabel;
    private JComboBox comboBox1;
    private JTextArea displayText;
    private JPanel displayScreen;

    private Employee employee;
    private Display display;
    private Payslip payslip;

    public Menu(Employee employee) {
        setTitle("MotorPH APS - Welcome");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 640);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setContentPane(menuWindow);

        JScrollPane scrollPane = new JScrollPane(displayText);
        displayScreen.add(scrollPane, BorderLayout.CENTER);

        this.employee = employee;

        setupDisplayBtn();
        setupComboBox1();

    }
    private void setupDisplayBtn() {
        displayBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == displayBtn) {
                    display = new Display();
                    display.showEmployeeProfile(employee, displayText);
                }
            }
        });
    }
    private void setupComboBox1() {
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) comboBox1.getSelectedItem();
                String startDate = payslips.get(selectPayslip(selectedItem))[1];
                String endDate = payslips.get(selectPayslip(selectedItem))[2];

                Payroll payroll = new Payroll(employee, startDate, endDate);
                payroll.runPayroll();

               payslip =    new Payslip();
               payslip.generatePayslip(payroll, displayText);
            }
        });
    }
    private static List<String[]> payslips = Arrays.asList(
            new String[]{"Payslip 1", "06/03/2024", "06/09/2024"},
            new String[]{"Payslip 2", "06/10/2024", "06/16/2024"},
            new String[]{"Payslip 3", "06/17/2024", "06/23/2024"},
            new String[]{"Payslip 4", "06/24/2024", "06/30/2024"},
            new String[]{"Payslip 5", "07/01/2024", "07/07/2024"},
            new String[]{"Payslip 6", "07/08/2024", "07/14/2024"},
            new String[]{"Payslip 7", "07/15/2024", "07/21/2024"},
            new String[]{"Payslip 8", "07/22/2024", "07/28/2024"},
            new String[]{"Payslip 9", "07/29/2024", "08/04/2024"},
            new String[]{"Payslip 10", "08/05/2024", "08/11/2024"},
            new String[]{"Payslip 11", "08/12/2024", "08/18/2024"},
            new String[]{"Payslip 12", "08/19/2024", "08/25/2024"},
            new String[]{"Payslip 13", "08/26/2024", "09/01/2024"},
            new String[]{"Payslip 14", "09/02/2024", "09/08/2024"},
            new String[]{"Payslip 15", "09/09/2024", "09/15/2024"},
            new String[]{"Payslip 16", "09/16/2024", "09/22/2024"},
            new String[]{"Payslip 17", "09/23/2024", "09/29/2024"},
            new String[]{"Payslip 18", "09/30/2024", "10/06/2024"},
            new String[]{"Payslip 19", "10/07/2024", "10/13/2024"},
            new String[]{"Payslip 20", "10/14/2024", "10/20/2024"},
            new String[]{"Payslip 21", "10/21/2024", "10/27/2024"},
            new String[]{"Payslip 22", "10/28/2024", "11/03/2024"},
            new String[]{"Payslip 23", "11/04/2024", "11/10/2024"},
            new String[]{"Payslip 24", "11/11/2024", "11/17/2024"},
            new String[]{"Payslip 25", "11/18/2024", "11/24/2024"},
            new String[]{"Payslip 26", "11/25/2024", "12/01/2024"},
            new String[]{"Payslip 27", "12/02/2024", "12/08/2024"},
            new String[]{"Payslip 28", "12/09/2024", "12/15/2024"},
            new String[]{"Payslip 29", "12/16/2024", "12/22/2024"},
            new String[]{"Payslip 30", "12/23/2024", "12/29/2024"},
            new String[]{"Payslip 31", "12/30/2024", "12/31/2024"}
    );
    private int selectPayslip(String period) {
        String[] payslipOptions = {
                "Payslip 1 - 06/03/2024 to 06/09/2024",
                "Payslip 2 - 06/10/2024 to 06/16/2024",
                "Payslip 3 - 06/17/2024 to 06/23/2024",
                "Payslip 4 - 06/24/2024 to 06/30/2024",
                "Payslip 5 - 07/01/2024 to 07/07/2024",
                "Payslip 6 - 07/08/2024 to 07/14/2024",
                "Payslip 7 - 07/15/2024 to 07/21/2024",
                "Payslip 8 - 07/22/2024 to 07/28/2024",
                "Payslip 9 - 07/29/2024 to 08/04/2024",
                "Payslip 10 - 08/05/2024 to 08/11/2024",
                "Payslip 11 - 08/12/2024 to 08/18/2024",
                "Payslip 12 - 08/19/2024 to 08/25/2024",
                "Payslip 13 - 08/26/2024 to 09/01/2024",
                "Payslip 14 - 09/02/2024 to 09/08/2024",
                "Payslip 15 - 09/09/2024 to 09/15/2024",
                "Payslip 16 - 09/16/2024 to 09/22/2024",
                "Payslip 17 - 09/23/2024 to 09/29/2024",
                "Payslip 18 - 09/30/2024 to 10/06/2024",
                "Payslip 19 - 10/07/2024 to 10/13/2024",
                "Payslip 20 - 10/14/2024 to 10/20/2024",
                "Payslip 21 - 10/21/2024 to 10/27/2024",
                "Payslip 22 - 10/28/2024 to 11/03/2024",
                "Payslip 23 - 11/04/2024 to 11/10/2024",
                "Payslip 24 - 11/11/2024 to 11/17/2024",
                "Payslip 25 - 11/18/2024 to 11/24/2024",
                "Payslip 26 - 11/25/2024 to 12/01/2024",
                "Payslip 27 - 12/02/2024 to 12/08/2024",
                "Payslip 28 - 12/09/2024 to 12/15/2024",
                "Payslip 29 - 12/16/2024 to 12/22/2024",
                "Payslip 30 - 12/23/2024 to 12/29/2024",
                "Payslip 31 - 12/30/2024 to 12/31/2024"
        };

        String cleanInput = cleanText(period);

        for (int i = 0; i < payslipOptions.length; i++) {
            String cleanOption = cleanText(payslipOptions[i]);
            if (cleanInput.equals(cleanOption)) {
                return i;
            }
        }

        System.out.println("Payslip period not found: " + period);
        return -1;
    }

    private String cleanText(String str) {
        return str == null
                ? ""
                : str.trim()
                .replaceAll("\\s+", " ")
                .replaceAll("[–—−]", "-");
    }



}
