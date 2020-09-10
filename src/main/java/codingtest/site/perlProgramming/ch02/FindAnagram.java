package codingtest.site.perlProgramming.ch02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FindAnagram
{
	public static void main(String[] args)
	{
		
		//StringBuilder는 동기화를 안해주니 단일 쓰레드에서 사용.
		Map<String, StringBuilder> markVar = new HashMap<String, StringBuilder>();
		
		FindAnagram findAnagram = new FindAnagram();

		
		// 1. 전철어구 표시

		try {
			String inputFilePath = ".\\file\\input\\perl\\ch2\\perlInput.txt";
			String outputFilePath = ".\\file\\output\\perl\\ch2\\perlOutput.txt";

			BufferedReader in = FileInOutProcess.FileInputProcess(inputFilePath);
			BufferedWriter out = FileInOutProcess.FileOutputProcess(outputFilePath);

			String s;
			String output;

			while ((s = in.readLine()) != null)
			{
				output = findAnagram.MarkAnagram(s);
				out.write(output); out.newLine();
			}

			in.close();
			out.close();

		// 2. 전철어구합치기.
	
			BufferedReader refineIn = FileInOutProcess.FileInputProcess(outputFilePath);
			
			String ss;
			String arrayOutput[];
			
			
		// 이 부분이 좀 까다로운데 map의 Value에 주소값을 저장해두고 꺼내다가 append시키는 원리임. 이래야 전철어구를 종합해서 표현할 수 있음.
			
			while ((ss = refineIn.readLine()) != null)
			{
				
				StringBuilder strBuilder;
				arrayOutput = ss.split("\t");
				
				if(!markVar.containsKey(arrayOutput[1]))
				{
					strBuilder = new StringBuilder();
					
					strBuilder.append(arrayOutput[0]).append(" ");
					markVar.put(arrayOutput[1], strBuilder);
				}
				else
				{
					strBuilder = markVar.get(arrayOutput[1]);
					strBuilder.append(arrayOutput[0]).append(" ");
					markVar.put(arrayOutput[1], strBuilder);
				}
			}
			
			
			Set keySet = markVar.keySet();
			Iterator<String> iterKey = keySet.iterator();
			
			while(iterKey.hasNext())
			{
				String key = iterKey.next();
				System.out.println("Key : " + key);
				System.out.println("Value : " + markVar.get(key));
				System.out.println();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public String MarkAnagram(String s)
	{
//		String sortedStr = BubbleSort.BubbleSorting(s, s.length());
//		String wordCount = PatternCount.PatternCount(sortedStr);
//		return s + "\t" + wordCount;
		return null;
	}
	
}

