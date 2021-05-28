package tree;
public class Node {
	private int count;	
	private Node[] children;
		public Node()//initializen node with count of 0 and an array of all other nodes as it's children that array is null
		{
				count=0;
				children=new Node['z'-'a'+1];
		}
			
		public void add(String s)
		{
			if(s.isEmpty()) //if our string is empty return up the recursion tree
			{
				(this).count++; //updates count for our word
				return;
			}
			char first=s.charAt(0);//first letter
			String strRem=s.substring(1);//remaining string without the first letter
			if(children[first-'a']==null)//
			{
				children[first-'a']=new Node();//create a node in first letters position 
			}
			children[first-'a'].add(strRem);//add our word with out first letter to the node we have created
			
		}
		public int num(String s){
			if(s.isEmpty()) 
			{
				return count; //returns the amount of times our word appears in the tree
			}
			char first=s.charAt(0);
			String strRem=s.substring(1);
			if(children[first-'a']!=null)
				return children[first-'a'].num(strRem);//move forward in our tree
			return 0;
		}
	
	}
