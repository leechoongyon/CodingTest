package codingtest.site.util;

public class ByteUtils 
{
	public static void byteClear(byte[] data)
	{
		for(int i = 0 ; i < data.length ; i++)
			data[i] = ' ';
	}
}
