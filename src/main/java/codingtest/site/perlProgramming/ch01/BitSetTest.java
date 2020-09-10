package codingtest.site.perlProgramming.ch01;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;

public class BitSetTest 
{
	public static void main(String[] args) 
	{
		BitSetTest bitSetTest = new BitSetTest();
		
		HashSet<Integer> set = new HashSet<Integer>();
		
		bitSetTest.MakeSampleData(set);
		
		BitSet bitSet = new BitSet();
		
		bitSetTest.SortBitSet(set, bitSet);
		
		bitSetTest.printBitSetData(set, bitSet);
	}
	
	public void printBitSetData(HashSet<Integer> set, BitSet bitSet)
	{
		
		
		for(int i = 0 ; i < 1000 ; i++)
		{
			if(bitSet.get(i) == true)
				System.out.println(i);
		}
		
		System.out.println();
	}
	
	
	public void MakeSampleData(HashSet<Integer> set)
	{
		
		
		while(set.size()< 1000) 
		{
			set.add((int)(Math.random() * 1000) + 1);
		}
	}
	
	public void SortBitSet(HashSet<Integer> set, BitSet bitSet)
	{
		int setCount = set.size();
		
		Iterator<Integer> iter = set.iterator();
		
		while(iter.hasNext())
		{
			bitSet.set(iter.next());
		}
	}
	
	
}
