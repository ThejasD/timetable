package in.bmsce.timetable;

public class TermSubject extends Term {
	int subject_id;
	String subject_name;
	int num_hours;
	Faculty faculty;

	
	TermSubject(int parTermid)
	{	
		super(parTermid);				
	}
	
	public boolean save(String sub_name, int teaching_hrs, Faculty fact) {
		this.subject_name = sub_name;
		this.num_hours = teaching_hrs;
		this.faculty = fact;
		// Add new subject details	with term id
		return true;		
	}
	
	public boolean update(String sub_name, int teaching_hrs, Faculty fact) {
		// Update subject details with term id
		this.subject_name = sub_name;
		this.num_hours = teaching_hrs;
		this.faculty = fact;
		return true;		
	}
}
