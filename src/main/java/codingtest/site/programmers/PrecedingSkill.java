package codingtest.site.programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lee
 * 
 * CBD [BACDE, CBADF, AECB, BDA] 2
 * 
 */

public class PrecedingSkill
{
	public static void main(String [] args)
	{
		String skill = "CBD";
//		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		String[] skill_trees = {"AECB", "C", "CB", "CBD"};
//		String[] skill_trees = {"B"};
		int answer = new PrecedingSkill().solution(skill, skill_trees);
		System.out.println(answer);
	}

	public int solution(String skill, String[] skill_trees) 
	{
		/**
		 * 	1. HashMap 에 순서 저장. HashMap<Character, Integer>
		 * 	2. skill_tree 를 순회하며, 임시 array 에 순서를 집어넣음.
		 * 	3. 임시 array 를 순회하며, 값이 순서대로 들어가있는지 확인.
		 * 		- 1 --> 2 --> 3 이면 OK. 1 --> 3 이면 에러.
		 * 
		 */
		int answer = 0;
		int order = 1;
		int[] orderArray;
		int curOrder;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0 ; i < skill.length() ; i++)
			map.put(skill.charAt(i), order++);
		
		for (String s : skill_trees)
		{
			orderArray = new int[s.length()];
			curOrder = 0;
			for (int i = 0 ; i < s.length() ; i++)
			{
				if (map.containsKey(s.charAt(i)))
					orderArray[i] = map.get(s.charAt(i));
				else
					orderArray[i] = 0;
			}
			
			/** 마지막 구간을 확인하기 위해 orderArray.length 까지 순회 */
			for (int i = 0 ; i <= orderArray.length ; i++)
			{
				if (i == orderArray.length)
				{
					answer++;
					break;
				}
				
				if (orderArray[i] <= curOrder)
					continue;
				else
				{
					if (orderArray[i] - 1 == curOrder)
					{
						curOrder = orderArray[i];
						if (curOrder == skill.length())
						{
							answer++;
							break;
						}
					}
					else
						break;
				}
			}
		}
		return answer;
	}
}
