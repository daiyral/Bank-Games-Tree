package tree;
import java.util.Scanner;
public class ReversedWords {
	public static int checkReversed()
	{
		Node n=new Node();
		Scanner in=new Scanner(System.in);
		String revWord,currentWord="";
		int cnt=0;
		if(in.hasNext())
			currentWord= in.next();//get our word
		while(!currentWord.equals("X"))//while our word is not x
		{
			revWord=getRevWord(currentWord);//gets our reversed word
			if(n.num(revWord)>=1) cnt++;//if our word reversed is already in the tree we update our count
			n.add(currentWord);//add our word to the tree
			if(in.hasNext())
				currentWord= in.next();//get next word
		}
		in.close();
		return cnt;
	}
	private static String getRevWord(String str)
	{
		String temp="";
		for(int i=str.length()-1;i>=0;i--)//reverse our word
		{
			temp+=str.charAt(i);
		}
		return temp;
	}
}
