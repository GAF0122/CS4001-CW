
/**
 * The StaffHire class has eight attributes, which correspond to the Vacancy number,
 Designation, Job Type and the
 staffName, joiningDate, qualification, appointedBy and joined.
 *
 * @Gabriel
 * @1.0
 */
public class StaffHire 
{
    //Instance Variables
    
    private int vacancyNumber;
    private String designation;
    private String jobType;
    private String staffName;
    private String joiningDate;
    private String qualification;
    private String appointedBy;
    private boolean joined;
    
    public StaffHire (int vacancyNumber, String designation, String jobType) 
    {
        //Constructors
        
        this.vacancyNumber = vacancyNumber;
        this.designation = designation;
        this.jobType = jobType;
        this.staffName = "";
        this.joiningDate = "";
        this.qualification = "";
        this.appointedBy = "";
        this.joined = false;
    }
        
        //Accessor Methods
        
    public int getVacancyNumber()
    {
            return this.vacancyNumber;
    }
        
    public String getDesignation()
    {
            return this.designation;
    }
        
    public String getJobType()
    {
            return this.jobType;
    }
        
    public String getStaffName()
    {
            return this.staffName;
    }
        
    public String getJoiningDate()
    {
            return this.joiningDate;
    }
        
    public String getQualification()
    {
            return this.qualification;
    }
        
    public String getAppointedBy()
    {
            return this.appointedBy;
    }
        
    public boolean isJoined()
    {
            return this.joined;
    }
        
        //Mutator method
        
        public void setStaffName(String name)
        {
            this.staffName = name;
        }
        
        public void setJoiningDate(String date)
        {
            this.joiningDate = date;
        }
        
        public void setQualification(String qualification) 
        {
            this.qualification = qualification;
        }
        
        public void setAppointedBy(String appointedBy) 
        {
            this.appointedBy = appointedBy;
        }
        
        public void setJoined(boolean status) 
        {
            this.joined = status;
        }
        
        
    public void displayDetails() 
    { 
        System.out.println("\n\n");
       //Shows staff details only after joining 
       
       System.out.println("Vacancy Number: " + this.vacancyNumber);
       System.out.println("Designation: " + this.designation);
       System.out.println("Job Type: " + this.jobType);
       if (this.joined)
       {
           System.out.println("Staff Name: " + this.staffName);          
           System.out.println("Joining Date: " + this.joiningDate);          
           System.out.println("Qualification: " + this.qualification);
           System.out.println("Appointed By: " + this.appointedBy);
           
       } else 
       {
           System.out.println("Unable to locate staff member, vacancy not taken.");
       }
       System.out.println("\n\n");
    }
}       
        
        