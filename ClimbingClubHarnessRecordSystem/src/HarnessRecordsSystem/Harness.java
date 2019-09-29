package HarnessRecordsSystem;

public class Harness {
	public static int MAX_USES_OF_HARNESS = 25;
	
	private String make;
	private int modelNumber;
	int timesUsed;
	String lastCheckedBy;
	Boolean onLoan;
	String borrower;
		
	Harness(String make, int modelNumber, int timesUsed, String lastCheckedBy, Boolean onLoan, String borrower){
		this.make = make;
		this.modelNumber = modelNumber;
		this.timesUsed = timesUsed;
		this.lastCheckedBy = lastCheckedBy;
		this.onLoan = onLoan;
		this.borrower = borrower;
	}
	Harness(String make, int modelNumber, String lastCheckedBy){
		this.make = make;
		this.modelNumber = modelNumber;
		this.timesUsed = 0;
		this.lastCheckedBy = lastCheckedBy;
		this.onLoan = false;
		this.borrower = null;
	}
	void checkHarrness(String instructor){
		if (this.isHarnessOnLoan()==false) {
			this.lastCheckedBy = instructor;
			this.timesUsed = 0;
		}
	}
	boolean isHarnessOnLoan() {
		return this.onLoan;
	}
	boolean canHarnessBeLoaned(){
		if (!(this.isHarnessOnLoan()) && (timesUsed<MAX_USES_OF_HARNESS)) {
			return true;
		}
		else {
			return false;
		}	
	}
	void loanHarness(String borrower){
		this.borrower = borrower;	
		this.onLoan = true;
		this.timesUsed = this.timesUsed+1;
	}
	void returnHarness() {
		if (this.isHarnessOnLoan()) {
			this.onLoan = false;
			this.borrower = null;
		}
	}
	public String toString(){
		return "Model: " + make + ", Model Number: " + modelNumber + ", Number of Times Used: " + timesUsed + ", Last Checked By: " + lastCheckedBy
		+ ", On Loan: " + (this.isHarnessOnLoan()?"Yes":"No") + ", Borrower: " + borrower;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public int getModelNumber() {
		return modelNumber;
	}
	public void setModelNumber(int modelNumber) {
		this.modelNumber = modelNumber;
	}
	public int getTimesUsed() {
		return timesUsed;
	}
	public void setTimesUsed(int timesUsed) {
		this.timesUsed = timesUsed;
	}
	public String getLastCheckedBy() {
		return lastCheckedBy;
	}
	public void setLastCheckedBy(String lastCheckedBy) {
		this.lastCheckedBy = lastCheckedBy;
	}
	public Boolean getOnLoan() {
		return onLoan;
	}
	public void setOnLoan(Boolean onLoan) {
		this.onLoan = onLoan;
	}
	public String getBorrower() {
		return borrower;
	}
	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}
}
