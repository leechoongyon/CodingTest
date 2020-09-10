package codingtest.site.solveProblemsExample;

import java.util.ArrayList;


/*
 *	소스 설명 : 스위치를 눌러 시계를 전부 12시로 맞춰라. 스위치 한 번 누를 때 해당 스위치에 연결된 시계가 3시간 이동
 *	결정적 요소 : 스위치를 4번 누르면 한바퀴 돌기에 스위치는 4번을 넘길수 없겠지.
 *			이 이유에 의해 완전탐색이 가능하다. 4의 10승이니
 * 
 *	n : 전체 원소의 갯수
 *	picked : 어떤 스위치를 몇 번 눌렀는지를 나타내는 변수 (경우의수 담음)
 *	totalList : 어떤 스위치를 눌렀을 때 어떤 시계가 연결되있는지를 나타내주는 변수
 */

public class Q4_SearchWatchTime
{
	static int n = 10;
	static int sum = 0;

	static int minValueTotalCount = Integer.MAX_VALUE;
	static ArrayList<Integer> minPicked;
	
	static int watch[] = {12,9,3,12,6,6,9,3,12,9,12, 9,12,12,6,6};

	static ArrayList<ArrayList<Integer>> totalList;

	public static void main(String[] args)
	{
		totalList = new ArrayList<ArrayList<Integer>>();
		assembleData(totalList);

		ArrayList<Integer> picked = new ArrayList<Integer>();
		permutation(picked);

		System.out.println("Min : " + minValueTotalCount);
		System.out.println("Sum : " + sum);
		System.out.println("Min Picked : " + minPicked);
	}

	//순열 , 스위치를 몇번 눌렀는지를 picked에 담는 함수
	public static void permutation( ArrayList<Integer> picked)
	{
		if(picked.size() == n)
		{
			searchMinValue(picked);
			return ;
		}
		
		//next를 4번 돌리는건 이 문제가 스위치 한 번에 3시간이니 4번 돌면 원점으로 돌아오기 때문에
		// 또한 ArrayList에 add한 뒤 remove를 하는건 모든 경우의 수를 표현하기 위함.
		// 만약 remove안해버리고 add만 해버리면 OutOfMemory 남.
		for(int next = 0 ; next < 4 ; next++)
		{	
			picked.add(next);
			permutation( new ArrayList<Integer>(picked));
			picked.remove(picked.size() - 1);
		}
	}

	public static void searchMinValue(ArrayList<Integer> picked)
	{
		int temp[] = watch;
		
		boolean status = true;

		// i : 스위치, get(i) : 스위치 누른 횟수, j : 스위치 누른 횟수	
		for(int i = 0 ; i < picked.size() ; i++)
		{
			if(picked.get(i) >= 1)
			{
				for(int j = 0 ; j < (totalList.get(i)).size() ; j++)
				{
					temp[(totalList.get(i)).get(j)] = (watch[(totalList.get(i)).get(j)]) + (picked.get(i) * 3);
				}
			}
		}

		for(int i = 0 ; i < temp.length ; i++)
		{
			if(temp[i] % 12 != 0)
				status = false;
		}
	
		if(status == true)
		{
			int tempSum = 0;
	
			for(int i = 0 ; i < picked.size() ; i++)
			{
				tempSum += picked.get(i);
			}

			System.out.println(picked);

			sum += 1;
		}
	}

	public static void assembleData(ArrayList totalList)
	{
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(0); list1.add(1); list1.add(2);
		totalList.add(list1);
	
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(3); list2.add(7); list2.add(9); list2.add(11);
		totalList.add(list2);		

		ArrayList<Integer> list3 = new ArrayList<Integer>();
		list3.add(4); list3.add(10); list3.add(14); list3.add(15);
		totalList.add(list3);

		ArrayList<Integer> list4 = new ArrayList<Integer>();
		list4.add(0); list4.add(4); list4.add(5); list4.add(6); list4.add(7);
		totalList.add(list4);

		ArrayList<Integer> list5 = new ArrayList<Integer>();
		list5.add(6); list5.add(7); list5.add(8); list5.add(10); list5.add(12);
		totalList.add(list5);

		ArrayList<Integer> list6 = new ArrayList<Integer>();
		list6.add(0); list6.add(2); list6.add(14); list6.add(15);
		totalList.add(list6);

		ArrayList<Integer> list7 = new ArrayList<Integer>();
		list7.add(3); list7.add(14); list7.add(15);
		totalList.add(list7);

		ArrayList<Integer> list8 = new ArrayList<Integer>();
		list8.add(4); list8.add(5); list8.add(7); list8.add(14); list8.add(15);
		totalList.add(list8);

		ArrayList<Integer> list9 = new ArrayList<Integer>();
		list9.add(1); list9.add(2); list9.add(3); list9.add(4); list9.add(5);
		totalList.add(list9);

		ArrayList<Integer> list10 = new ArrayList<Integer>();
		list10.add(3); list10.add(4); list10.add(5); list10.add(9); list10.add(13);
		totalList.add(list10);
	}
}
