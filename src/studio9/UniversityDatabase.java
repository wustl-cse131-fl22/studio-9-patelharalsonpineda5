package studio9;

import java.util.HashMap;
import java.util.Map;

import assignment7.Student;

public class UniversityDatabase {
	private final Map<String, Student> map;
	
	public UniversityDatabase() {
		this.map = new HashMap<String, Student>();
	}

	public void addStudent(String accountName, Student student) {
		map.put(accountName, student);
	}

	public int getStudentCount() {
		return map.size();
	}

	public String lookupFullName(String accountName) {
		if (map.containsKey(accountName)) {
			return map.get(accountName).getFullName();
		}
		else {
			return null;
		}
	}

	public double getTotalBearBucks() {
		double bbAmt = 0;
		for (String account : map.keySet()) {
			bbAmt += map.get(account).getBearBucksBalance();
		}
		return bbAmt;
	}
}
