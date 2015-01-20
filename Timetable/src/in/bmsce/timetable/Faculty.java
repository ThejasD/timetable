package in.bmsce.timetable;


//TODO: Are you sure about extending TimeTable class
// 		because teacher has many timetables associated. I would suggest you should make
//		timetable has associate class
public class Faculty extends TimeTable {	
	private int faculty_id;
	private String faculty_name;
	private int priority;
	
	Faculty()
	{
		super();
	}
}
