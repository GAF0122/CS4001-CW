
/**
 * FullTimeStaffHire, a subclass of of StaffHire represents a full-time staff  member and it manages more attributes such as salary and weekly working hours and ensures 
 * salary can only be set before a staff member has been hired.
 *
 * @GabrielCoelho 
 * @1.0
 */

public class FullTimeStaffHire extends StaffHire 
{
    
//Instance variables
private int salary;
private int weeklyHours;
    
    
public FullTimeStaffHire(int vacancyNumber, String designation, String jobType, int salary, int weeklyHours) 
    {
        super(vacancyNumber, designation, jobType);
        this.salary = salary;
        this.weeklyHours = weeklyHours;
    }
    
    
//Accessor methods
public int getSalary()
{
    return this.salary;
}

public int getWeeklyHours() 
{
    return this.weeklyHours;
}

/**
 * Updates the salary if the staff member has not yet joined.
 * @param salary The new salary to be set.
 */
    //Mutator methods
    public void setSalary(int salary) 
    {
        if (!isJoined()) {
            this.salary = salary;
        } else {
                System.out.println("Error! Unable to change salary after staff is appointed.");
        }
    }

public void setWeeklyHours(int hours) 
    {
        this.weeklyHours = hours;
    }
    
    @Override
    public void displayDetails() 
    { 
    System.out.println("\n\n");
    super.displayDetails();
        if (isJoined()) {
        System.out.println("Salary:" + this.salary);
        System.out.println("Weekly Hours: " + this.weeklyHours);
    }
    System.out.println("\n\n");
}
}
