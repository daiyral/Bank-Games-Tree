package tasks;
import java.util.Arrays;
/*this class represent a series of tasks with dependencies between them*/
public class Tasks {
	private int num;
	private int [][] dependency;
	/*builder of Tasks class with the number of tasks an a matrix to represent the dependency*/
	public Tasks(int num) {
		this.num=num;
		dependency=new int[num][num];
	}
	/*this func gets two tasks and add the dependency to the matrix, task1 is depend on task2
	 * return true if succeed,false else*/
	public boolean dependsOn(int task1, int task2){
		if((task1<0||task1>num)||(task2<0||task2>num))//check if the given tasks are valid
			return false;
		dependency[task1][task2]=1;
		return true;
	}
	/*this func set an optional order in which the tasks can be executed, return it as an int array */
	public int[] order()
	{
		int [] myOrder=new int[num];
		int flag=1;//flag=0 means we have not added anything to our myOrder array;
		Arrays.fill(myOrder, -1);//set all the array to -1
		int k=0;
		while((myOrder[num-1]==-1)&&flag==1)//as long we didnt finished insert all the tasks and in the last loop we added a new task to the order
		{
			flag=0;
			for(int i=0;i<num;i++)
			{
				int j=0;
				while(j<num&&dependency[i][j]!=1) j++; //check that the line is all zeros,that means the current task is not depended at all
				if(j==num) 
				{
					if(checkInArray(myOrder,i)==false)//if our task is not already in our answer array we add it
					{
						myOrder[k++]=i;//if j==num the entire line is zeros
						flag=1;//sets flag to one to say we added a new task to order in this loop run
					}
					for(j=0;j<num;j++) dependency[j][i]=0;//now we can clear tasks that depend on the task we solved
				}
			}		
		}	
		if(flag==0) return null;
		return myOrder;
	}
	/*checks if a given number is in the given array, return true if yes*/
	private Boolean checkInArray(int []arr,int num)
	{
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==num) return true;
		}
		return false;
	}

}
