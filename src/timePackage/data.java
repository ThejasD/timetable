package timePackage;

public class data {
	String st[][];
	int d[][]=new int[6][8];
	
	public  data(){
		     st=new String[6][8];
			
			for(int i=0;i<6;i++)
				for(int j=0;j<8;j++)
				{
					d[i][j]=((int)(100*Math.random())%5);
					switch(d[i][j]){
								case 0:{
									st[i][j]=new String("JAVA");
									break;
								}
								case 1:{
									st[i][j]=new String("DBMS");
									break;
								}
								case 3:{
									st[i][j]=new String("SS");
									break;
								}
								case 4:{
									st[i][j]=new String("OS");
									break;
								}
								case 2:{
									st[i][j]=new String("DC");
									break;
								}
					}
				}
	}
}
