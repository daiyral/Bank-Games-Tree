package tasks;
/*this class represent Tasks with names so its inherit from Tasks*/
public class NamedTasks extends Tasks {

	private String[]names;
	public NamedTasks(String[]names) {
		super(names.length);//using Tasks constructor
		this.names= new String[names.length];
		for(int i=0;i<names.length;i++)
			this.names[i]=names[i];
	}
	public boolean dependsOn(String task1, String task2)
	{
		int indexTask1=-1,indexTask2=-1;
		for(int i=0;i<names.length;i++)//find the index of the two tasks
		{
			if(names[i].compareTo(task1)==0) indexTask1=i;
			if(names[i].compareTo(task2)==0) indexTask2=i;
		}
		return super.dependsOn(indexTask1, indexTask2);//add the dependency using Tasks dependsOn
		
	}
	/*this func sets an order of an optional way of execute the tasks*/
	public String[] nameOrder()
	{
		int[] intOrder= super.order();//sets the order using Tasks Order function
		if(intOrder==null) return null;
		String [] res=new String[names.length];
		for(int i=0;i<res.length;i++)//we want to return our order in the form of names not integers
		{
			res[i]=names[intOrder[i]];//we put in each place the correct name by the indexes we got as integers
		}
		return res;
	}

}
