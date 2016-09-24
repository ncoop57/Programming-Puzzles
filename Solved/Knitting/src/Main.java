import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Hello Knitter! Please specify the number of stitches in the first row\n"
						  + "followed by the number of rows in the entire project\n"
						  + "followed by the number of rows that the pattern will repeat for\n"
						  + "Example:\n\t\t3 3 1\n\t\t2");
		
		int rows = 0;
		int total = 0;
		String pattern1 = scan.nextLine();
		String pattern2 = scan.nextLine();
		
		while(!(pattern1.equals("0 0 0") || pattern1.equals("0 0 0")) )
		{
			String[] tokens1 = pattern1.split(" ");
			String[] tokens2 = pattern2.split(" ");
			int[] nums1 = new int[tokens1.length];
			int[] nums2 = new int[tokens2.length];
			
			for(int i = 0; i < tokens1.length; i++)
			{
				nums1[i] = Integer.parseInt(tokens1[i]);
			}
			for(int i = 0; i < tokens2.length; i++)
			{
				nums2[i] = Integer.parseInt(tokens2[i]);
			}
			
			for(int i = 0; i < nums1.length; i++)
			{
				for(int j = 0; j < nums1[i]; j++)
				{
					
				}
			}
			
			
			pattern1 = scan.nextLine();
			pattern2 = scan.nextLine();
		}
		
		System.out.println(total);
	}
}
