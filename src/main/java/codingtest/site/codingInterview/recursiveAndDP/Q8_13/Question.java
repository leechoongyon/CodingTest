package codingtest.site.codingInterview.recursiveAndDP.Q8_13;

import java.util.ArrayList;
import java.util.List;

public class Question
{
	private static List<Box> list = new ArrayList<Box>();
	private static int cache[] = new int[4];
	
	public static void main(String [] args)
	{
		Box boxs[] = new Box[4];
		Box box1 = new Box(7, 7, 10);
		Box box2 = new Box(8, 8, 9);
		Box box3 = new Box(5, 5, 8);
		Box box4 = new Box(3, 3, 1);
		boxs[0]= box1;
		boxs[1] = box2;
		boxs[2] = box3;
		boxs[3] = box4;
		
		System.out.println(getHeightestBox(boxs));
	}
	
	public static int getHeightestBox(Box boxs[])
	{
		return getHeightestBox(boxs, 0);
	}

	public static int getHeightestBox(Box boxs[], int index)
	{
		/**
		 * 	이런 문제를 풀기 전, 반드시 점화식을 그려보고 수행. 또는 실제로 작은 케이스를 만들어 풀어보기.
		 * 	이 문제는 재귀로 푼 문제이며, 끝에서부터 위로 올라오는 down-top 방식임.
		 * 	끝에서 부터 해당 index 의 maxHeight 를 위로 올려보내며, maxHeight 를 받아 
		 * 	현재 boxs[i].h 와 계산해서 위로 올려보내는거임. 또한, 계산 과정에 각 높이에서의
		 * 	maxHeight 를 구하는게 중복이니 이를 memorization 을 통해 품.
		 *  예를 들면, 아래 문제를 보면 box3 과 box4 가 공통임. 그러하기에 이를 index 를 통해 cache 사용 
		 *  	box1 --> box3 --> box4
		 *  	box2 --> box3 --> box4
		 *     
		 *  
		 * 	1. 높이를 정렬.
		 * 	2. for (0 ~ n) 순회하면서 밑에서부터 높은 것을 쌓아나감.
		 * 	3. 메소드의 return 값은 해당 index 의 maxHeight 값임.
		 * 		- 이렇게 해야 memorization 에서 index 로 캐시 쓸 수 있음.
		 */
		
		int height = 0;
		int maxHeight = 0;
		
		/** Memorization */
		if (cache[index] != 0) return cache[index];

		/** 종료 조건 */
		if (index > boxs.length - 1) return boxs[index].h;
		
		
		for (int i = index ; i < boxs.length ; i++)
		{
			if (list.isEmpty() || isValidate(list.get(list.size() - 1), boxs[i]))
			{
				list.add(boxs[i]);
				height = getHeightestBox(boxs, index + 1);
				list.remove(list.size() - 1);
				maxHeight = Math.max(height + boxs[i].h, maxHeight);
			}
		}
		return (cache[index] = maxHeight);
	}
	
	public static boolean isValidate(Box befBox, Box curBox)
	{
		if (befBox.d > curBox.d && befBox.w > curBox.w &&
			befBox.h > curBox.h)
		{
			return true;
		}
		return false;
	}
	
	public static class Box
	{
		int w;
		int d;
		int h;

		public Box(int w, int d, int h)
		{
			this.w = w;
			this.d = d;
			this.h = h;
		}
	}
}
