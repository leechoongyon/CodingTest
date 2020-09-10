package codingtest.site.acmicpc;

import java.util.Scanner;

public class Num1004
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int x1, y1, x2, y2, n, count = 0;
		Planet planet;
		for (int i = 0 ; i < T ; i++)
		{
			count = 0;
			
			x1 = sc.nextInt();
			y1 = sc.nextInt();
			x2 = sc.nextInt();
			y2 = sc.nextInt();
			
			n = sc.nextInt();
			
			for (int j = 0 ; j < n ; j++)
			{
				planet = new Planet(sc.nextInt(), sc.nextInt(), sc.nextInt());
				count += solve(x1, y1, x2, y2, planet);
			}
			System.out.println(count);
		}
	}
	
	public static int solve(int x1, int y1, int x2, int y2, Planet planet)
	{
		int d1 = (planet.cx - x1) * (planet.cx - x1) + (planet.cy - y1) * (planet.cy - y1);
		int d2 = (planet.cx - x2) * (planet.cx - x2) + (planet.cy - y2) * (planet.cy - y2);
		
		int r = planet.r * planet.r;
		if ( (d1 > r && d2 < r) || (d1 < r && d2 > r) )
			return 1;
		else
			return 0;
	}
	
	/*public static int solve1(int x1, int y1, int x2, int y2, Planet planet)
	{
		if ( (planet.cx - planet.r < x1 && x1 < planet.cx + planet.r && planet.cy - planet.r < y1 && y1 < planet.cy + planet.r)
			 && ( !(planet.cx - planet.r < x2 && x2 < planet.cx + planet.r) || !(planet.cy - planet.r < y2 && y2 < planet.cy + planet.r)))
		{
			return 1;
		}
		else if ( ( !(planet.cx - planet.r  < x1 && x1 < planet.cx + planet.r) || !(planet.cy - planet.r < y1 && y1 < planet.cy + planet.r) )
				&& (planet.cx - planet.r < x2 && x2 < planet.cx + planet.r  && planet.cy - planet.r < y2 && y2 < planet.cy + planet.r) )
		{
			return 1;
		}
		else
			return 0;
		
	}*/
}

class Planet
{
	int cx;
	int cy;
	int r;
	
	public Planet(int cx, int cy, int r)
	{
		this.cx = cx;
		this.cy = cy;
		this.r = r;
	}
}
