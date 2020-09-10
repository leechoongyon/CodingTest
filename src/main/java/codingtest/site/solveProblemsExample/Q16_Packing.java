package codingtest.site.solveProblemsExample;

import java.util.ArrayList;
import java.util.List;

public class Q16_Packing 
{
	static List<DataSet> list = new ArrayList<DataSet>();
	static int cache[] = new int[10];
	static int choices[] = new int[10];
	static int limitVolume = 10;


	public static void main(String[] args)
	{
		Q16_Packing pack = new Q16_Packing();
		pack.init();
		pack.start();
		pack.reconstruct(0, choices);
	}

	public void start()
	{
		int max = 0;
		int temp = 0;

		for(int i = 0 ; i < list.size() ; i++)
		{
			temp = packing(i, list.get(i).volume);
			if(max < temp)
			{
				max = temp;
				choices[i] = i;
			}
		}

		System.out.println("Max : " + max);
	}

	public int packing(int start, int sumVolume)
	{
		int cand = 0;
		int bestRoute = 0;

		if(cache[start] != 0) return cache[start];

		cache[start] = list.get(start).immience;

		for(int next = start + 1 ; next < list.size() ; next++)
		{
			int partSumVolume = list.get(next).volume + sumVolume;
			if(partSumVolume <= limitVolume)
				cand = Math.max(cache[start], packing(next, partSumVolume) + list.get(start).immience);

			if(cand > cache[start])
			{
				cache[start] = cand;
				choices[start+1] =  next;
			}
		}

		return cache[start];
	}

		public void reconstruct(int start, int choices[])
		{
			for(int i = 0 ; i < choices.length ; i++)
			{
				if(choices[i] != -1)
					System.out.println(choices[i]);
				else
					break;
			}
		}

		public void init()
		{
			DataSet dataSet = new DataSet();
			dataSet.item = "laptop";
			dataSet.volume = 4;
			dataSet.immience = 7;
			list.add(dataSet);
			
			DataSet dataSet1 = new DataSet();
			dataSet1.item = "camera";
			dataSet1.volume = 2;
			dataSet1.immience = 10;
			list.add(dataSet1);
			
			DataSet dataSet3 = new DataSet();
			dataSet3.item = "xbox";
			dataSet3.volume = 6;
			dataSet3.immience = 6;
			list.add(dataSet3);
			
			DataSet dataSet4 = new DataSet();
			dataSet4.item = "grinder";
			dataSet4.volume = 4;
			dataSet4.immience = 7;
			list.add(dataSet4);
			
			DataSet dataSet5 = new DataSet();
			dataSet5.item = "dumbell";
			dataSet5.volume = 2;
			dataSet5.immience = 5;
			list.add(dataSet5);
			
			DataSet dataSet6 = new DataSet();
			dataSet6.item = "encyclopedia";
			dataSet6.volume = 10;
			dataSet6.immience = 4;
			list.add(dataSet6);
		}
		
	}//class Q16

class DataSet
{
    String item;
    int volume;
    int immience;
}
