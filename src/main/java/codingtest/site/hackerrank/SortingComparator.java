package codingtest.site.hackerrank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @file hackerrank.SortingComparator.java
 * @filetype java source file
 * @brief
 * @author USER
 * @version 0.1
 * @history 버전 성명 일자 변경내용 0.1 USER 2018. 2. 3. 신규작성
 *
 * @desc 1. 기본지식이 있어야 함. - 쉽게 생각하자. b1, b2 를 비교하는데 b2-b1 은 내림차순, b1-b2 는 오름차순
 */
public class SortingComparator
{
	public static void main(String [] args)
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		Player [] player = new Player [n];
		Checker checker = new Checker();

		for (int i = 0; i < n; i++)
		{
			player[i] = new Player(scan.next(), scan.nextInt());
		}
		scan.close();

		Arrays.sort(player, checker);
		for (int i = 0; i < player.length; i++)
		{
			System.out.printf("%s %s\n", player[i].name, player[i].score);
		}
	}
}

class Checker implements Comparator<Player>
{
	@Override
	public int compare(Player a, Player b)
	{
		if (a.score != b.score) { return b.score - a.score; }
		return a.name.compareTo(b.name);
	}
}

class Player
{
	String name;
	int score;

	Player(String name, int score)
	{
		this.name = name;
		this.score = score;
	}
}