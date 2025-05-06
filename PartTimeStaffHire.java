
/**
 * PartTimeStaffHire, subclass of StaffHire used to hire part-time employees.
 * Manages attributes like working hours, wages per hour, shifts, and termination status.
 *
 * @author Gabriel
 * @version 2.0
 */
public class PartTimeStaffHire extends StaffHire
{
    private int workingHours;
    private double wagesPerHour;
    private String shifts;
    private boolean terminated;

    /**
     * Constructs a PartTimeStaffHire with all details.
     *
     * @param vacancyNumber   inherited vacancy number
     * @param designation     inherited designation
     * @param jobType         inherited job type
     * @param staffName       inherited staff name
     * @param joiningDate     inherited joining date
     * @param qualification   inherited qualification
     * @param appointedBy     inherited appointed-by
     * @param joined          inherited joined status
     * @param workingHours    the number of daily working hours
     * @param wagesPerHour    the hourly wage
     * @param shifts          the working shift
     */
    public PartTimeStaffHire(
        int vacancyNumber,
        String designation,
        String jobType,
        String staffName,
        String joiningDate,
        String qualification,
        String appointedBy,
        boolean joined,
        int workingHours,
        double wagesPerHour,
        String shifts
    )
    {
        super(vacancyNumber, designation, jobType);
        setStaffName(staffName);
        setJoiningDate(joiningDate);
        setQualification(qualification);
        setAppointedBy(appointedBy);
        setJoined(joined);
        this.workingHours = workingHours;
        this.wagesPerHour = wagesPerHour;
        this.shifts = shifts;
        this.terminated = false;
    }

    /**
     * Returns the working hours per day.
     * @return workingHours
     */
    public int getWorkingHours()
    {
        return workingHours;
    }

    /**
     * Returns the hourly wage.
     * @return wagesPerHour
     */
    public double getWagesPerHour()
    {
        return wagesPerHour;
    }

    /**
     * Returns the shift.
     * @return shifts
     */
    public String getShifts()
    {
        return shifts;
    }

    /**
     * Returns if staff has been terminated.
     * @return terminated
     */
    public boolean isTerminated()
    {
        return terminated;
    }

    /**
     * Changes PT shift, if the staff has not been terminated.
     * @param shifts 
     */
    public void setShifts(String shifts)
    {
        if (!terminated)
        {
            this.shifts = shifts;
        }
        else
        {
            System.out.println("Error! Cannot change shift after termination.");
        }
    }

    /**
     * Terminates the PT staff member.
     * Clears personal details and sets joined to false.
     */
    public void terminateStaff()
    {
        if (!terminated)
        {
            setStaffName("");
            setJoiningDate("");
            setQualification("");
            setAppointedBy("");
            setJoined(false);
            terminated = true;
        }
        else
        {
            System.out.println("Staff already terminated.");
        }
    }

    /**
     * Displays PT staff details, including computed income per day,
     * only if the staff has joined.
     */
    @Override
    public void displayDetails()
    {
        super.displayDetails();
        if (isJoined())
        {
            System.out.println("Working Hours:  " + workingHours);
            System.out.println("Wages Per Hour: " + wagesPerHour);
            System.out.println("Shifts:         " + shifts);
            System.out.println("Terminated:     " + terminated);
            System.out.println("Income per Day: " + (wagesPerHour * workingHours));
        }
    }
}