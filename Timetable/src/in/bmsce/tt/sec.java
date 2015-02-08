package TT;
//This class represents a section and its timetable.
public class sec extends tt{
	subject in[];  // represents the list of subjects for a particular section
	int ctr,total=0;  
	sec(subject y[])
	{	super();
		in=y;
		for(int j=1;j<y.length;j++)
		{
			total+=in[j].hrs;
		}
		ctr=total; //total number of hours of teaching of all the subjects per week
	}
	void allot(int i, int j, int a)  //allot a subject to a slot and decrement the number of hours to be alloted
	{
		t[i][j]=in[a].subno;
		if(a!=0)
		{
			ctr--;
			
            in[a].hrs--;                  //also decrement the number of hours in subject object
		}		

}
	void unallot(int i,int j,int a)
	{
		t[i][j]=-1;
		if(a!=0)                    // reverese the alloting process
		{
			ctr++;
			
            in[a].hrs++;
		}		
	}
	boolean checkc(int i, int j, int a)
	{
		int flag=0;          
		if((35-(i)*7+(j))<ctr)
			return false;          // check if number of hrs to be alloted is less than no. of slots available
		
		for(int x=0;x<j;x++)
		{
			if(t[i][x]!=0&&flag==0)flag=1;     //check to make sure there is no gaps in the timetable for
			if(t[i][x]==0&&flag==1)flag=2;     // example: java free unix c++ is not allowed
			if(a!=0&&flag==2)return false;     // free java unix c++ is allowed
			if((t[i][x]==in[a].subno)&&(in[a].subno!=0))return false; // same subject cannot be alloted more than once per day
		}
		//if(in[a].flag>=1) {System.out.println("enter2");return false;}
        if(in[a].hrs==0) return false;
		return true;        //a subject can be alloted only and exactly as much as the prescribed no. of hrs
	}

}
