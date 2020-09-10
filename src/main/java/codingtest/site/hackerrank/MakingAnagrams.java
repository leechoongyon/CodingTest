package codingtest.site.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @file	hackerrank.MakingAnagrams.java
 * @filetype	java source file
 * @brief
 * @author		USER
 * @version		0.1
 * @history
 * 버전			성명			일자			변경내용
 * 0.1			USER		2018. 1. 30.		신규작성
 *
 *
 * point & feedback
 * 1. 처음에는 sort 한 뒤 각각 캐릭터 비교해서 풀었음. 근데 안풀림.
 * 2. 두번쨰로 각 캐릭터 숫자를 세서 풀음. 알파벳이 26자리이므로 시간복잡도가 O(n) 임.
 */
public class MakingAnagrams
{
    public static int numberNeeded(String first, String second) 
    {
	char alpa[] = new char[26];
	int fCount[] = new int[26];
	int sCount[] = new int[26];
	
	for (int i = 0; i < alpa.length; i++) 
	{
            alpa[i] = (char) (i + 97); 
        }
	
	for (int i = 0 ; i < alpa.length ; i++)
	{
	    for (int j = 0 ; j < first.length() ; j++)
	    {
		if (alpa[i] == first.charAt(j))
		    fCount[i]++;
	    }
	    
	    for (int j = 0 ; j < second.length() ; j++)
	    {
		if (alpa[i] == second.charAt(j))
		    sCount[i]++;
	    }
	}
	
	int sum = 0;
	for (int i = 0 ; i < 26 ; i++)
	{
	    if (fCount[i] >= sCount[i])
		sum += sCount[i];
	    else
		sum += fCount[i];
	}
	
	return first.length() + second.length() - (2 * sum);
    }
    
    public static int numberNeeded2(String first, String second) 
    {
	char firstChars[] = first.toCharArray();
	char secondChars[] = second.toCharArray();
	
	Arrays.sort(firstChars);
	Arrays.sort(secondChars);
	
	int equalCount = 0;
	
	if (firstChars.length >= secondChars.length)
	{
	    int fIndex = 0 ;
	    for (int sIndex = 0 ; sIndex < secondChars.length ; sIndex++)
	    {
		if (secondChars[sIndex] == firstChars[fIndex])
		{
		    fIndex++;
		    equalCount++;
		}
	    }
	}
	else
	{
	    int sIndex = 0;
	    for (int fIndex = 0 ; fIndex < firstChars.length ; fIndex++)
	    {
		if (secondChars[sIndex] == firstChars[fIndex])
		{
		    sIndex++;
		    equalCount++;
		}
	    }
	}
	
	return firstChars.length + secondChars.length - 2 * equalCount;
    }
    
    public static void main(String[] args)
    {
	Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}


