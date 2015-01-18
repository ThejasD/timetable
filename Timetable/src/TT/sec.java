package TT;

public class sec extends tt{
	subject in[];
	int ctr,total=0;
	sec(subject y[])
	{	super();
		in=y;
		for(int j=1;j<y.length;j++)
		{
			total+=in[j].hrs;
		}
		ctr=total;
	}
	void allot(int i, int j, int a)
	{
		t[i][j]=in[a].subno;
		if(a!=0)
		{
			ctr--;
			
            in[a].hrs--;
		}		

}
	void unallot(int i,int j,int a)
	{
		t[i][j]=-1;
		if(a!=0)
		{
			ctr++;
			
            in[a].hrs++;
		}		
	}
	boolean checkc(int i, int j, int a)
	{
		int flag=0;
		if((35-(i)*7+(j))<ctr)
			return false;
		
		/*if(j==0) { 
			for(int var=0;var<in.length;var++){
			in[var].flag=0;
			}}	*/
		for(int x=0;x<j;x++)
		{
			if(t[i][x]!=0&&flag==0)flag=1;
			if(t[i][x]==0&&flag==1)flag=2;
			if(a!=0&&flag==2)return false;
			if((t[i][x]==in[a].subno)&&(in[a].subno!=0))return false;
		}
		//if(in[a].flag>=1) {System.out.println("enter2");return false;}
        if(in[a].hrs==0) return false;
		return true;
	}

}
