
/**
 * FullTimeStaffHire, a subclass of of StaffHire represents a full-time staff  member.
 * Manages more attributes such as salary and weekly working hours.
 * Salary can only be set before a staff member has been hired.
 *
 * @author GabrielCoelho 
 * @version 2.0
 */

public class FullTimeStaffHire extends StaffHire
{
    private double salary;
    private double weeklyFractionalHours;

    /**
     * Constructs a FullTimeStaffHire with all details.
     *
     * @param vacancyNumber           inherited vacancy number
     * @param designation             inherited designation
     * @param jobType                 inherited job type
     * @param staffName               inherited staff name
     * @param joiningDate             inherited joining date
     * @param qualification           inherited qualification
     * @param appointedBy             inherited appointed-by
     * @param joined                  inherited joined status
     * @param salary                  the full-time salary
     * @param weeklyFractionalHours   the full-time weekly hours
     */
    public FullTimeStaffHire(
        int vacancyNumber,
        String designation,
        String jobType,
        String staffName,
        String joiningDate,
        String qualification,
        String appointedBy,
        boolean joined,
        double salary,
        double weeklyFractionalHours
    )
    {
        super(vacancyNumber, designation, jobType);
        setStaffName(staffName);
        setJoiningDate(joiningDate);
        setQualification(qualification);
        setAppointedBy(appointedBy);
        setJoined(joined);
        this.salary = salary;
        this.weeklyFractionalHours = weeklyFractionalHours;
    }

    /**
     * Returns the salary.
     * @return salary
     */
    public double getSalary()
    {
        return salary;
    }

    /**
     * Returns the weekly fractional hours.
     * @return weeklyFractionalHours
     */
    public double getWeeklyFractionalHours()
    {
        return weeklyFractionalHours;
    }

    /**
     * Sets a new salary, only if the staff has not yet joined.
     * @param salary 
     */
    public void setSalary(double salary)
    {
        if (!isJoined())
        {
            this.salary = salary;
        }
        else
        {
            System.out.println("Error! Cannot change salary after appointment.");
        }
    }

    /**
     * Sets new weekly fractional hours.
     * @param hours
     */
    public void setWeeklyFractionalHours(double hours)
    {
        this.weeklyFractionalHours = hours;
    }

    /**
     * Displays the full-time staff details, including salary & hours,
     * only if staff has joined.
     */
    @Override
    public void displayDetails()
    {
        super.displayDetails();
        if (isJoined()) {
            System.out.println("Salary:                   " + salary);
            System.out.println("Weekly Fractional Hours:  " + weeklyFractionalHours);
        }
    }
}