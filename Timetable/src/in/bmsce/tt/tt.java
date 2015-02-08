package TT;
//This contains the time table matrix
public class tt {
	int t[][]=new int[5][7];// 7 periods a day,5 days per week 
	tt()
	{
		for(int i=0;i<5;i++)
			for(int j=0;j<7;j++)
				t[i][j]=-1;
	}	
	/*void allot(int i,int j,int a)
	{
		t[i][j]=a;
	}*/
	void display()
	{
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<7;j++)
				System.out.print(t[i][j]+"     ");
			System.out.println();
		}
	}


}
