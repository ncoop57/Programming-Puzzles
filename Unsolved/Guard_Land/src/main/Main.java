package main;

import java.awt.geom.Rectangle2D;

public class Main
{
	
	public static void main()
	{
		
		//Main[] pts = new Main[];
		int n = 2;
		int[][][] pts = new int[n][2][4];
		
		for(int i = 0; i < n; i++)
		{
			Rectangle2D rect1 = new Rectangle2D.Double(pts[n][0][0], pts[n][0][3], pts[n][0][2] - pts[n][0][0], pts[n][0][3] - pts[n][0][1]);
			Rectangle2D rect2 = new Rectangle2D.Double(pts[n][1][0], pts[n][1][3], pts[n][1][2] - pts[n][1][0], pts[n][1][3] - pts[n][1][1]);
		}
		
		
		
	}
	
}
