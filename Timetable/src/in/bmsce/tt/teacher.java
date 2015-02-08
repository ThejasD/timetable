package TT;
//contains the timetable for a teacher i.e the sections she is handling at each time slot
public class teacher extends tt {
	int flag[][]=new int[5][7];
	teacher()   // initializing all the periods to free period (subject 0 is considered as free period)
	{	super();                             
		for(int i=0;i<5;i++)
			for(int j=0;j<7;j++)
				flag[i][j]=0;
	}
	boolean checkc(int i, int j)
	{
		if(flag[i][j]==1) return false;  //checks if a slot is vacant or not
		else 
		return true;
	}
    void allot(int i,int j,int a)
    {
    	t[i][j]=a;
    	flag[i][j]=1;
    }
    void unallot(int i,int j)
    {
    	t[i][j]=-1;
    	flag[i][j]=0;
    
    }
}
