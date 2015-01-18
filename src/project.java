class Project
{
  public static void main(String args[])
  {
    int set[]={1,2,3,4,5,6};
    intialize(set,3);
   }
  public static void intialize(int set[],int k)
   {
     int comb[]=new int[k];
     combinations(set,comb,0,0);
   }
  public static void combinations(int set[],int comb[],int size,int nextIndex)
   {
     if(size==comb.length)
     {
       print(comb);
      }
     else
      {
        for(int i=nextIndex;i<set.length;i++)
         {
           comb[size]=set[i];
           combinations(set,comb,size+1,i+1);
         }
      }
   }
  public static void print(int x[])
   {
     for(int i=0;i<x.length;i++)
      System.out.print(x[i]+" ");
     System.out.println();
   }
}