
/**
 * StaffHire stores basic information about the position and the appointed staff member..
 
 * @author Gabriel
 * @version 2.0
 */
public class StaffHire
{
    private int vacancyNumber;
    private String designation;
    private String jobType;
    private String staffName;
    private String joiningDate;
    private String qualification;
    private String appointedBy;
    private boolean joined;

    /**
     * Creates a new StaffHire with the given vacancy number, designation, and job type.
     * staffName, joiningDate, qualification, appointedBy start empty,
     * and joined starts in false.
     *
     * @param vacancyNumber  the unique vacancy number
     * @param designation    the job designation
     * @param jobType        the type of job (e.g. "Full-Time", "Part-Time")
     */
    public StaffHire(int vacancyNumber, String designation, String jobType)
    {
        this.vacancyNumber = vacancyNumber;
        this.designation   = designation;
        this.jobType       = jobType;
        this.staffName     = "";
        this.joiningDate   = "";
        this.qualification = "";
        this.appointedBy   = "";
        this.joined        = false;
    }

    /**
     * Returns vacancy number.
     * @return vacancyNumber
     */
    public int getVacancyNumber()
    {
        return vacancyNumber;
    }

    /**
     * Returns designation.
     * @return designation
     */
    public String getDesignation()
    {
        return designation;
    }

    /**
     * Returns job type.
     * @return jobType
     */
    public String getJobType()
    {
        return jobType;
    }

    /**
     * Returns staff member’s name.
     * @return staffName
     */
    public String getStaffName()
    {
        return staffName;
    }

    /**
     * Returns joining date.
     * @return joiningDate
     */
    public String getJoiningDate()
    {
        return joiningDate;
    }

    /**
     * Returns qualification.
     * @return qualification
     */
    public String getQualification()
    {
        return qualification;
    }

    /**
     * Returns who appointed the staff.
     * @return appointedBy
     */
    public String getAppointedBy()
    {
        return appointedBy;
    }

    /**
     * Returns if staff has joined.
     * @return true if joined, false otherwise
     */
    public boolean isJoined()
    {
        return joined;
    }

    /**
     * Sets staff members name.
     * @param staffName
     */
    public void setStaffName(String staffName)
    {
        this.staffName = staffName;
    }

    /**
     * Sets joining date.
     * @param joiningDate
     */
    public void setJoiningDate(String joiningDate)
    {
        this.joiningDate = joiningDate;
    }

    /**
     * Sets the qualification.
     * @param qualification
     */
    public void setQualification(String qualification)
    {
        this.qualification = qualification;
    }

    /**
     * Sets who appointed the staff.
     * @param appointedBy 
     */
    public void setAppointedBy(String appointedBy)
    {
        this.appointedBy = appointedBy;
    }

    /**
     * Sets joined status.
     * @param joined  true if the staff has joined, false otherwise
     */
    public void setJoined(boolean joined)
    {
        this.joined = joined;
    }

    /**
     * Displays details of this vacancy and staff if joined.
     * If not joined, indicates that no staff has been appointed yet.
     */
    public void displayDetails()
    {
        System.out.println("\nVacancy Number: " + vacancyNumber);
        System.out.println("Designation:    " + designation);
        System.out.println("Job Type:       " + jobType);
        if (joined)
        {
            System.out.println("Staff Name:     " + staffName);
            System.out.println("Joining Date:   " + joiningDate);
            System.out.println("Qualification:  " + qualification);
            System.out.println("Appointed By:   " + appointedBy);
        }
        else
        {
            System.out.println("No staff has been appointed yet.");
        }
        System.out.println();
    }
}