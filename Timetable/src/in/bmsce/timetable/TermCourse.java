package in.bmsce.timetable;

import java.util.ArrayList;
import java.util.List;


/* Course represents semester in this case */
public class TermCourse extends Term {
	int course_id;
	String course_name;
	List<TermSubject> subjects;
	private TimeTable tt = new TimeTable();

	public TermCourse(int term_id, int course_id, String course_name, List<TermSubject> sub) {
		super(term_id);
		this.course_id = course_id;		
		this.course_name = course_name;
		this.subjects = sub; 
	}	

	
	// Schedule slot for the given subject
	public boolean schedule_subject(TermSubject sub){
		ArrayList<Integer> faculty_free_slots = sub.faculty.free_slots();
		
		int prev_slot = 0;
		
		for (Integer slot : faculty_free_slots) {
			if (tt.check_slot(slot)) {
				if(prev_slot == 0) {
					tt.allot(slot, sub);
					sub.faculty.allot(slot, sub);
					prev_slot = slot;
				}
				else if((slot - prev_slot) >= TimeTable.PERIODS_PER_DAY) {
					tt.allot(slot, sub);
					sub.faculty.allot(slot, sub);
					prev_slot = slot;
				}
				else {
					System.out.print("Slot are on same day");
				}
			}
		}	
		return true;
	}
	
	// Schedule timetable for all the subject in the course
	public boolean schedule()
	{
		for (TermSubject sub : subjects) {
			if (sub.faculty.available_slots() < 1)
				continue;
			else {
				schedule_subject(sub);					
			}
		}	
		return true;
	}	
}
