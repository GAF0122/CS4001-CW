
/**
 * Write a description of class RecruitmentSystem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class RecruitmentSystem implements ActionListener {
    private JFrame frame;
    private JTextField vacancyField, nameField, dateField, salaryField, shiftField, indexField;
    private JButton addFTButton, addPTButton, displayButton, setSalaryButton, setShiftButton, terminateButton, clearButton;
    private JTextArea outputArea;
    
    private ArrayList<StaffHire> staffList;
    
    public RecruitmentSystem(){
    staffList = new ArrayList<>();
    createGUI();
}   

   private void createGUI() {
       frame = new JFrame("Recruitment System");
       frame.setSize(500, 400);
       frame.setLayout(new FlowLayout());
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       frame.add(new JLabel("Vacancy No:"));
       vacancyField = new JTextField(5);
       frame.add(vacancyField);
       
       frame.add(new JLabel("Staff Name:"));
       nameField = new JTextField(10);
       frame.add(vacancyField);
       
       frame.add(new JLabel("Joining Date:"));
       dateField = new JTextField(8);
       frame.add(dateField);
       
       frame.add(new JLabel("Salary:"));
       salaryField = new JTextField (6);
       frame.add(salaryField);
       
       frame.add(new JLabel("Shift (PT):"));
       shiftField = new JTextField(5);
       frame.add(shiftField);
       
       frame.add(new JLabel("Index to Display:"));
       indexField = new JTextField(3);
       frame.add(indexField);
       
       
       
       
       addFTButton = new JButton("Add FT");
       addFTButton.addActionListener(this);
       frame.add(addFTButton);
       
       addPTButton = new JButton("Add PT");
       addPTButton.addActionListener(this);
       frame.add(addPTButton);
       
       setSalaryButton = new JButton("Set Salary");
       setSalaryButton.addActionListener(this);
       frame.add(setSalaryButton);
       
       setShiftButton = new JButton("Shift set");
       setShiftButton.addActionListener(this);
       frame.add(setShiftButton);
       
       terminateButton = new JButton("Terminate");
       terminateButton.addActionListener(this);
       frame.add(terminateButton);
       
       displayButton = new JButton("Display");
       displayButton.addActionListener(this);
       frame.add(displayButton);
       
       clearButton = new JButton("Clear");
       clearButton.addActionListener(this);
       frame.add(clearButton);
       
       outputArea = new JTextArea(10, 40);
       outputArea.setEditable(false);
       frame.add(new JScrollPane(outputArea));
       
       frame.setVisible(true);
   }
   
   public void actionPerformed(ActionEvent e) {
        try {
            String cmd = e.getActionCommand();
            int vacancy = Integer.parseInt(vacancyField.getText());

            if (cmd.equals("Add FT")) {
                FullTimeStaffHire ft = new FullTimeStaffHire(vacancy, "Dev", "Full-Time", Integer.parseInt(salaryField.getText()), 40);
                ft.setStaffName(nameField.getText());
                ft.setJoiningDate(dateField.getText());
                ft.setJoined(true);
                staffList.add(ft);
                outputArea.setText("Full-time staff added.\n");

            } else if (cmd.equals("Add PT")) {
                PartTimeStaffHire pt = new PartTimeStaffHire(vacancy, "Support", "Part-Time", 20, 10, shiftField.getText());
                pt.setStaffName(nameField.getText());
                pt.setJoiningDate(dateField.getText());
                pt.setJoined(true);
                staffList.add(pt);
                outputArea.setText("Part-time staff added.\n");

            } else if (cmd.equals("Set Salary")) {
                int newSalary = Integer.parseInt(salaryField.getText());
                for (StaffHire s : staffList) {
                    if (s instanceof FullTimeStaffHire && s.getVacancyNumber() == vacancy) {
                        ((FullTimeStaffHire) s).setSalary(newSalary);
                        outputArea.setText("Salary updated.\n");
                        return;
                    }
                }
                outputArea.setText("FT staff not found.\n");

            } else if (cmd.equals("Set Shift")) {
                for (StaffHire s : staffList) {
                    if (s instanceof PartTimeStaffHire && s.getVacancyNumber() == vacancy) {
                        ((PartTimeStaffHire) s).setShifts(shiftField.getText());
                        outputArea.setText("Shift updated.\n");
                        return;
                    }
                }
                outputArea.setText("PT staff not found.\n");

            } else if (cmd.equals("Terminate")) {
                for (StaffHire s : staffList) {
                    if (s instanceof PartTimeStaffHire && s.getVacancyNumber() == vacancy) {
                        ((PartTimeStaffHire) s).terminateStaff();
                        outputArea.setText("Part-time staff terminated.\n");
                        return;
                    }
                }
                outputArea.setText("PT staff not found.\n");

            } else if (cmd.equals("Display")) {
                int index = Integer.parseInt(indexField.getText());
                if (index >= 0 && index < staffList.size()) {
                    outputArea.setText("Showing staff at index " + index + ":\n");
                    staffList.get(index).showDetails();
                } else {
                    outputArea.setText("Invalid index.\n");
                }

            } else if (cmd.equals("Clear")) {
                vacancyField.setText("");
                nameField.setText("");
                dateField.setText("");
                salaryField.setText("");
                shiftField.setText("");
                indexField.setText("");
                outputArea.setText("");
            }

        } catch (NumberFormatException ex) {
            outputArea.setText("Please enter valid numbers.\n");
        }
    }

    public static void main(String[] args) {
        new RecruitmentSystem();
    }
}