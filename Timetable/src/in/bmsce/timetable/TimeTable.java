package in.bmsce.timetable;

import java.awt.List;
import java.util.ArrayList;

public class TimeTable {
	public static final int NUM_OF_DAYS = 6;
	public static final int PERIODS_PER_DAY = 5;
	
	// Matrix representation time table
	private int _timetable[] = null;	

	TimeTable() {
		this._timetable = (new int[NUM_OF_DAYS * PERIODS_PER_DAY]);

		for(int i = 0;i < NUM_OF_DAYS * PERIODS_PER_DAY; i++)
				get_timetable()[i]=-1;
	}

	public int[] get_timetable() {
		return _timetable;
	}
	
	public boolean check_slot(int slot) {
		return (_timetable[slot] > 0) ? true : false;		
	}
	
	// Mark slot for the provided subject
	public void allot(int slot, TermSubject sub)
	{
		this._timetable[slot] = sub.subject_id;		
	}
	
	
	// Cancel all the slot for the week for the given subject
	public void cancel_slot(TermSubject sub)
	{
		for(int i = 0; i < _timetable.length; i++) {
			if (this._timetable[i] == sub.subject_id) {
				this._timetable[i] = 0;				
			}
		}		
	}
	
	// Cancel only one particular slot
	public void cancel_slot(int slot)
	{
		this._timetable[slot] = 0;
	}
	
	// Returns number of free slots
	public int available_slots() {
		int count = 0;
		for(int i = 0; i < _timetable.length; i++) {
			if (this._timetable[i] == 0) {
				count++;				
			}		
		}
		return count;
	}
	
	// Returns number of free slots
	public ArrayList<Integer> free_slots() {
		ArrayList<Integer> slots = new ArrayList<Integer>();
		
		for(int slot = 0; slot < _timetable.length; slot++) {
			if (this._timetable[slot] == 0) {
				slots.add(slot);				
			}
		}
		return slots;
	}
	
	
	
	
	/* Based on the first day of the slot, the rest of the slot
	 * for the given subject will be marked has allocated.
	 * This is just an assumption for time being
	 */
	public void schedule_slot(int[] slots) {
		for(int i = 0; i < slots.length; i++) {
				this._timetable[slots[i]] = 1;			
		}		
	}
	
	
	/* Display time table snapshot  for a week */
	public void display() {
		for(int i = 0; i < NUM_OF_DAYS * PERIODS_PER_DAY ; i++)
		{			
				System.out.print(_timetable[i] + "    ");
				if ((i % PERIODS_PER_DAY) == 0) {
					System.out.println();
				}
		}
	}
}
