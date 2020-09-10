package codingtest.site.perlProgramming.ch02;

import java.io.*;

public class FileInOutProcess
{
	public static BufferedReader FileInputProcess(String filePath)
	{
		BufferedReader in = null;
		
		try {
			in = new BufferedReader(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
		return in;
	}

	public static BufferedWriter FileOutputProcess(String filePath)
	{
		BufferedWriter out = null;
		
		try {
			out = new BufferedWriter(new FileWriter(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return out;
	}
}

