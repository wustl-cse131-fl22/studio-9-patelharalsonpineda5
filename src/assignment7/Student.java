package assignment7;

public class Student {
	private String firstName;
	private String lastName;
	private int id;
	private int attemptedCredits;
	private int passingCredits;
	private double totalGradeQualityPoints;
	private double bbBalance;
	
	public Student(String firstName, String lastName, int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}
	
	public Student createLegacy(String firstName, Student other, boolean isHyphenated, int id) {
		String lastName;
		if (isHyphenated) {
			lastName = this.lastName + "-" + other.lastName;
		}
		else {
			lastName = this.lastName;
		}
		Student legacy = new Student(firstName, lastName, id);
		legacy.depositBearBucks(this.cashOutBearBucks() + other.cashOutBearBucks());
		return legacy;
	}
	
	/**
	 * 
	 * @return full name, first last
	 */
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	/**
	 * 
	 * @return student id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * 
	 * @return total attempted credits by student
	 */
	public int getTotalAttemptedCredits() {
		return attemptedCredits;
	}
	
	/**
	 * 
	 * @return total passing credits by students
	 */
	public int getTotalPassingCredits() {
		return passingCredits;
	}
	
	/**
	 * 
	 * @return class standing (first year, sophomore, junior, or senior) of student
	 */
	public String getClassStanding() {
		if (passingCredits >= 90) {
			return "Senior";
		}
		else if (passingCredits >= 60) {
			return "Junior";
		}
		else if (passingCredits >=30) {
			return "Sophomore";
		}
		else {
			return "First Year";
		}
				
	}
	
	/**
	 * 
	 * @return whether or not student is eligible for phi beta kappa
	 */
	public boolean isEligibleForPhiBetaKappa() {
		if (passingCredits >= 98 && this.calculateGradePointAverage() >= 3.60) {
			return true;
		}
		else if (passingCredits >= 75 && this.calculateGradePointAverage() >= 3.80) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * change number of total quality points, based on the grade a student receives in a course and its associated number of credits
	 * @param grade
	 * @param credits
	 */
	public void submitGrade(double grade, int credits) {
		double qualityPoints = grade * credits;
		attemptedCredits += credits;
		if (grade >= 1.7) {
			passingCredits += credits;
		}
		totalGradeQualityPoints += qualityPoints;
	}
	
	/**
	 * 
	 * @param deposit amount
	 * @return amount of bear bucks after deposit amount is added
	 */
	public void depositBearBucks(double amount) {
		bbBalance += amount;
	}
	
	/**
	 * 
	 * @param withdraw amount
	 * @return amount of bear bucks balance after withdraw amount is subtracted
	 */
	public void deductBearBucks(double amount) {
		bbBalance -= amount;
	}
	
	/**
	 * 
	 * @return bear bucks balance
	 */
	public double getBearBucksBalance() {
		return bbBalance;
	}
	
	/**
	 * 
	 * @return number of bear bucks cashed out, with a $10 fee
	 */
	public double cashOutBearBucks() {
		double refund;
		if (bbBalance <=10) {
			refund = 0;
		}
		else {
			refund = bbBalance - 10;
		}
		bbBalance = 0;
		return refund;
	}
	
	/**
	 * 
	 * @return GPA
	 */
	public double calculateGradePointAverage() {
		
		return totalGradeQualityPoints/attemptedCredits;
	}
	
	/**
	 * @return student's full name and id
	 */
	public String toString() {
		return this.getFullName() + this.getId();
	}
}
