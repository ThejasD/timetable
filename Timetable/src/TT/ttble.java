package TT;

public class ttble {
	sec s[];teacher t[];
	ttble(sec s[],teacher t[])
	{
		this.s=s;
		this.t=t;
	}
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
						if(ttb(z+1,0,0)) return true;
						else
						{
							s[z].unallot(i,j,k);
							 t[s[z].in[k].faculty].unallot(i,j);
						}
						
					}
					if(j==6) 
					{
						
						if(ttb(z,i+1,0)) return true;
						else
						{
							s[z].unallot(i,j,k);
							 t[s[z].in[k].faculty].unallot(i,j);
						}
						
					}
					else
					{
						if(ttb(z,i,j+1)) return true;	
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
