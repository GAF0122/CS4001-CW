
/**
 * Write a description of class PartTimeStaffHire here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PartTimeStaffHire extends StaffHire {
    //Instance variables
    private int workingHours;
    private int wagesPerHour;
    private String shifts;
    private boolean terminated;
    
    
    public PartTimeStaffHire(int vacancyNumber, String designation, String jobType, int workingHours, int wagesPerHour, String shifts) {
        super(vacancyNumber, designation, jobType);
        this.workingHours = workingHours;
        this.wagesPerHour = wagesPerHour;
        this.shifts = shifts;
        this.terminated = false;
    }
    
    //Accessor Methods
    public int getWorkingHours(){
        return this.wagesPerHour;
    }
    
    public int getWagesPerHour() {
        return this.wagesPerHour;
    }
    
    public String getShifts() {
        return this.shifts;
    }
    
    public boolean isTerminated() {
        return this.terminated;
    }
    
    //Mutator methods 
    public void terminateStaff() {
        if (!terminated) {
            this.shifts = shifts;
        } else {
            System.out.println("Error! Cannot change shift, staff terminated.");
        }
        
        
    }

}


