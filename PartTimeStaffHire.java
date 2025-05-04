
/**
 * PartTimeStaffHire, a subclass of StaffHire used to hire part-time employees.
 * It manages attributes like working hours, wages per hour, shifts, and termination status.
 *
 * @Gabriel
 * @1.0
 */
public class PartTimeStaffHire extends StaffHire 
{
    //Instance variables
    private int workingHours;
    private int wagesPerHour;
    private String shifts;
    private boolean terminated;
    
    
    public PartTimeStaffHire(int vacancyNumber, String designation, String jobType, int workingHours, int wagesPerHour, String shifts) 
    {
        super(vacancyNumber, designation, jobType);
        this.workingHours = workingHours;
        this.wagesPerHour = wagesPerHour;
        this.shifts = shifts;
        this.terminated = false;
    }
    
    //Accessor Methods
    public int getWorkingHours()
    {
        return this.workingHours;
    }
    
    public int getWagesPerHour() 
    {
        return this.wagesPerHour;
    }
    
    public String getShifts() 
    {
        return this.shifts;
    }
    
    public boolean isTerminated() 
    {
        return this.terminated;
    }
    
    //Mutator methods 
    public void setShifts(String shift) 
    {
        if (!terminated) 
        {
            this.shifts = shift;
        } else 
        {
            System.out.println("Error! Cannot change shift, staff terminated.");
        }
    }
        public void terminateStaff() 
        {
            if (!terminated) 
            {
                setStaffName("");
                setJoiningDate("");
                setQualification("");
                setAppointedBy("");
                setJoined(false);
                this.terminated = true;
            }   else 
            {
                System.out.println("Staff has already been terminated.");
            }
        }
        
        @Override
        public void displayDetails() {
            super.displayDetails();
            if (isJoined()) {
                System.out.println("Working hours: " + this.workingHours);
                System.out.println("Wages per hour: " + this.wagesPerHour);
                System.out.println("Shifts: " + this.shifts);
                System.out.println("Terminated: " + this.terminated);
            }
        }
    

}


