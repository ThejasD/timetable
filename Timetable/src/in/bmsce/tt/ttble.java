package TT;
//takes lists of section and faculty and generates the timetable
public class ttble {
	sec s[];teacher t[];
	ttble(sec s[],teacher t[])
	{
		this.s=s;
		this.t=t;
	}
/* a backtracking algorithm which fills the sections timetable slot by slot taking one section at a time and corresponding faculty timetable.
if at any stage it finds out that timetable cannot be alloted further it reverts back one step and allots a different subject. this process continues
recursively */
	boolean ttb(int z,int i,int j)
	{
		if(s.length==z) return true;
		for(int k=s[z].in.length-1;k>=0;k--)
 		{
			if(s[z].checkc(i,j,k))
			{
				if(t[s[z].in[k].faculty].checkc(i,j))
				{				
					s[z].allot(i,j,k);
					if(k!=0)
					  t[s[z].in[k].faculty].allot(i,j,z);
					if(s[z].ctr==0) 
					{					
						if(ttb(z+1,0,0)) return true; //move to next section
						else
						{
							s[z].unallot(i,j,k);
							 t[s[z].in[k].faculty].unallot(i,j);
						}
						
					}
					if(j==6) 
					{
						
						if(ttb(z,i+1,0)) return true;  // move to next next day of the week
						else
						{
							s[z].unallot(i,j,k);
							 t[s[z].in[k].faculty].unallot(i,j);
						}
						
					}
					else
					{
						if(ttb(z,i,j+1)) return true;	//move to next period
						else
						{
							s[z].unallot(i,j,k);
							 t[s[z].in[k].faculty].unallot(i,j);
						}
						
					}
				}	
				
			}
		}
	
		return false;
	}

}
