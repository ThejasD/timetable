package TT;
///This class represents one subject that is to be alloted to a section
public class subject {
	int subno;  //subject number-a key that represents a subject
	int faculty; //faculty handling this subject
	int hrs;     // number of hours per week
	//int alloted=0;
	subject(int e,int f,int h)
	{
		subno=e;
		faculty=f;
		hrs=h;
	}


}
