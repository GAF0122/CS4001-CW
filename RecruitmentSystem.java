import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.ArrayList;
    
/**
 * RecruitmentSystem provides a Swing GUI for adding, updating,
 * terminating and displaying full- and part-time staff information.
 *
 * @author Gabriel
 * @version 2.0
 */

    
    public class RecruitmentSystem implements ActionListener 
    {
        
        //Input Fields
        private JTextField vacancyField;
        private JTextField nameField;
        private JTextField dateField;
        private JTextField salaryField;
        private JTextField shiftField; 
        private JTextField indexField;
        private JTextField designationField;
        private JTextField qualificationField;
        private JTextField appointedByField;
        private JTextField workingHoursField;
        private JTextField wagesPerHourField;
        
        
        //Buttons
        private JButton addFTButton;
        private JButton addPTButton; 
        private JButton displayButton;
        private JButton setSalaryButton;
        private JButton setShiftButton;
        private JButton terminateButton;
        private JButton clearButton;
        
        //Frame
        private JFrame frame;
        private JTextArea outputArea;
        private ArrayList<StaffHire> staffList;
        
    /**
     * Begins the staff list and builds the GUI.
     */
        public RecruitmentSystem()
    {
        staffList = new ArrayList<>();
        createGUI();
    } 
    
/**
 * This method creates the GUI layout and initializes swing components.
 */
       private void createGUI() 
       {
           //Frame input fields
           frame = new JFrame("Recruitment System");
           frame.setSize(450, 400);
           frame.setLayout(new FlowLayout());
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
           frame.add(new JLabel("Vacancy No:"));
           vacancyField = new JTextField(2);
           frame.add(vacancyField);
           
           frame.add(new JLabel("Staff Name:"));
           nameField = new JTextField(20);
           frame.add(nameField);
           
           frame.add(new JLabel("Joining Date:"));
           dateField = new JTextField(8);
           frame.add(dateField);
           
           frame.add(new JLabel("Salary: £"));
           salaryField = new JTextField (3);
           frame.add(salaryField);
           
           frame.add(new JLabel("Shift (PT):"));
           shiftField = new JTextField(6);
           frame.add(shiftField);
           
           frame.add(new JLabel("Designation:"));
           designationField = new JTextField(8);
           frame.add(designationField);
           
           frame.add(new JLabel("Qualification:"));
           qualificationField = new JTextField(13);
           frame.add(qualificationField);
           
           frame.add(new JLabel("Appointed By:"));
           appointedByField = new JTextField(12);
           frame.add(appointedByField);
           
           frame.add(new JLabel("Working Hours (PT):"));
           workingHoursField = new JTextField(5);
           frame.add(workingHoursField);

           frame.add(new JLabel("Wages Per Hour (PT) £:"));
           wagesPerHourField = new JTextField(9);
           frame.add(wagesPerHourField);

           frame.add(new JLabel("Index to Display:"));
           indexField = new JTextField(5);
           frame.add(indexField);
           
           
           
           //Frame buttons 
           addFTButton = new JButton("Add Full-Time Staff");
           addFTButton.addActionListener(this);
           frame.add(addFTButton);
           
           addPTButton = new JButton("Add Part-Time Staff");
           addPTButton.addActionListener(this);
           frame.add(addPTButton);
           
           setSalaryButton = new JButton("Set Salary");
           setSalaryButton.addActionListener(this);
           frame.add(setSalaryButton);
           
           setShiftButton = new JButton("Set Shift");
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
       
    /**
     * Responds to all button presses by performing the appropriate action.
     *
     * @param ActionEvent e
     */
       @Override
       public void actionPerformed(ActionEvent e)
    {
        try {
            String cmd = e.getActionCommand();
            int vacancy = Integer.parseInt(vacancyField.getText());
            String name = nameField.getText();
            String date = dateField.getText();
            String designation = designationField.getText();
            String qualification = qualificationField.getText();
            String appointedBy = appointedByField.getText();

            if (cmd.equals("Add Full-Time Staff")) {
                double salary = Double.parseDouble(salaryField.getText());
                FullTimeStaffHire ft = new FullTimeStaffHire(
                    vacancy,
                    designation,
                    "Full-Time",
                    name,
                    date,
                    qualification,
                    appointedBy,
                    true,
                    salary,
                    40 //Full-time staff have fixed weekly hours.
                );
                staffList.add(ft);
                outputArea.setText("Full-time staff added.\n");
            } else if (cmd.equals("Add Part-Time Staff")) {
                int workingHours = Integer.parseInt(workingHoursField.getText());
                double wagesPerHour = Double.parseDouble(wagesPerHourField.getText());
                String shift = shiftField.getText();
                
                PartTimeStaffHire pt = new PartTimeStaffHire(
                    vacancy,
                    designation,
                    "Part-Time",
                    name,
                    date,
                    qualification,
                    appointedBy,
                    true,
                    workingHours,
                    wagesPerHour,
                    shift
                );
                staffList.add(pt);
                outputArea.setText("Part-time staff added.\n");
                
            }  else if (cmd.equals("Set Salary")) {
                double newSalary = Double.parseDouble(salaryField.getText());
                for (StaffHire s : staffList) {
                    if (s instanceof FullTimeStaffHire && s.getVacancyNumber() == vacancy) {
                        ((FullTimeStaffHire) s).setSalary(newSalary);
                        outputArea.setText("Salary updated.\n");
                        return;
                    }
                }
                outputArea.setText("Full-Time staff not found.\n");
            } else if (cmd.equals("Set Shift")) {
                for (StaffHire s : staffList) {
                    if (s instanceof PartTimeStaffHire && s.getVacancyNumber() == vacancy) {
                        ((PartTimeStaffHire) s).setShifts(shiftField.getText());
                        outputArea.setText("Shift updated \n");
                        return;
                    }
                }
                outputArea.setText("Part-Time staff not found.\n");
            } else if (cmd.equals("Terminate")) {
                for (StaffHire s : staffList) {
                    if (s instanceof PartTimeStaffHire && s.getVacancyNumber() == vacancy) {
                        ((PartTimeStaffHire) s).terminateStaff();
                        outputArea.setText("Part-time staff terminated.\n");
                        return;
                    }
                }
                outputArea.setText("Part-Time staff not found.\n");
            }
            else if (cmd.equals("Display")) {
                int index = Integer.parseInt(indexField.getText());
                if (index >= 0 && index < staffList.size()) {
                    outputArea.setText("Showing staff at index " + index + ":\n");
                    staffList.get(index).displayDetails();
                } else {
                    outputArea.setText("Invalid index.\n");
                }
            } else if (cmd.equals("Clear")) {
                clearFields();
                outputArea.setText("");
            }
        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                frame,
                "Please enter valid numeric values in the highlighted fields.",
                "Input Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    /**
     * Clears all input text fields.
     */
    private void clearFields()
    {
        vacancyField.setText("");
        nameField.setText("");
        dateField.setText("");
        salaryField.setText("");
        shiftField.setText("");
        designationField.setText("");
        qualificationField.setText("");
        appointedByField.setText("");
        workingHoursField.setText("");
        wagesPerHourField.setText("");
        indexField.setText("");
    }

    /**
     * Launches the Recruitment System GUI.
     * @param args      
    */
        public static void main(String[] args) 
        {
            new RecruitmentSystem();
        }
    }