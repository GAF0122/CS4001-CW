
/**
 * The StaffHire class has eight attributes, which correspond to the Vacancy number,
 Designation, Job Type and the
 staffName, joiningDate, qualification, appointedBy and joined.
 *
 * @Gabriel
 * @25/04/2025
 */
public class StaffHire {
    //Instance Variables
    
    private int vacancyNumber;
    private String designation;
    private String JobType;
    private String staffName;
    private String joiningDate;
    private String qualification;
    private String appointedBy;
    private boolean joined;
    
    public StaffHire (int vacancyNumber, String designation, String jobType) {
        //Constructors
        
        this.vacancyNumber = vacancyNumber;
        this.designation = designation;
        this.JobType = JobType;
        this.staffName = "";
        this.joiningDate = "";
        this.qualification = "";
        this.appointedBy = "";
        this.joined = false;
        }
        
        //Accessor Methods
        
        public int getVacancyNumber(){
            return this.vacancyNumber;
        }
        
        public int getDesignation(){
            return this.designation;
        }
        
        public int getJobType(){
            return this.JobType;
        }
        
        public int getStaffName(){
            return this.staffName;
        }
        
        public int getJoiningDate(){
            return this.joiningDate;
        }
        
        public int getQualification(){
            return this.qualification;
        }
        
        public int getAppointedBy(){
            return this.appintedBy;
        }
        
        public int getJoined(){
            return this.joined;
        }
        
        //Mutator method
        
        public void setStaffName(String name) {
                this.StaffName = name;
        }
        
        public void setJoiningDate(String name){
            this.
        }
        
        
        