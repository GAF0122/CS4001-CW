
/**
 * RecruitmentSystem provides a Swing GUI for adding, updating,
 * terminating and displaying full- and part-time staff information.
 *
 * @Gabriel
 * @1.0
 */

    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.*;
    import java.util.ArrayList;
    
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
        
        public RecruitmentSystem()
    {
        staffList = new ArrayList<>();
        createGUI();
    } 
    
/**
 * This method creates the GUI layout and initializes all components.
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
           
           frame.add(new JLabel("Salary:"));
           salaryField = new JTextField (3);
           frame.add(salaryField);
           
           frame.add(new JLabel("Shift (PT):"));
           shiftField = new JTextField(4);
           frame.add(shiftField);
           
           frame.add(new JLabel("Designation:"));
           designationField = new JTextField(8);
           frame.add(designationField);
           
           frame.add(new JLabel("Qualification:"));
           qualificationField = new JTextField(10);
           frame.add(qualificationField);
           
           frame.add(new JLabel("Appointed By:"));
           appointedByField = new JTextField(10);
           frame.add(appointedByField);

           frame.add(new JLabel("Index to Display:"));
           indexField = new JTextField(5);
           frame.add(indexField);
           
           
           
           //Frame buttons 
           addFTButton = new JButton("Add FT");
           addFTButton.addActionListener(this);
           frame.add(addFTButton);
           
           addPTButton = new JButton("Add PT");
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
       
       public void actionPerformed(ActionEvent e)
    {
        try {
            String cmd = e.getActionCommand();
            int vacancy = Integer.parseInt(vacancyField.getText());

            if (cmd.equals("Add FT")) {
                FullTimeStaffHire ft = new FullTimeStaffHire(
                    vacancy,
                    designationField.getText(),
                    "Full-Time",
                    Integer.parseInt(salaryField.getText()),
                    40
                );
                ft.setStaffName(nameField.getText());
                ft.setJoiningDate(dateField.getText());
                ft.setQualification(qualificationField.getText());
                ft.setAppointedBy(appointedByField.getText());
                ft.setJoined(true);
                staffList.add(ft);
                outputArea.setText("Full-time staff added.\n");
            } else if (cmd.equals("Add PT")) {
                PartTimeStaffHire pt = new PartTimeStaffHire(
                    vacancy,
                    designationField.getText(),
                    "Part-Time",
                    20,
                    10,
                    shiftField.getText()
                );
                pt.setStaffName(nameField.getText());
                pt.setJoiningDate(dateField.getText());
                pt.setQualification(qualificationField.getText());
                pt.setAppointedBy(appointedByField.getText());
                pt.setJoined(true);
                staffList.add(pt);
                outputArea.setText("Part-time staff added.\n");
            }  else if (cmd.equals("Set Salary")) {
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
                        outputArea.setText("Shift updated to:" + shiftField.getText() + "\n");
                        s.displayDetails();
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
            outputArea.setText("Please enter valid numbers.\n");
        }
    }
    
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
        indexField.setText("");
    }

    
        public static void main(String[] args) 
        {
            new RecruitmentSystem();
        }
    }