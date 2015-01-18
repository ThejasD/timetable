package TT;

public class teacher extends tt {
	int flag[][]=new int[5][7];
	teacher()
	{	super();
		for(int i=0;i<5;i++)
			for(int j=0;j<7;j++)
				flag[i][j]=0;
	}
	boolean checkc(int i, int j)
	{
		if(flag[i][j]==1) return false;
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
