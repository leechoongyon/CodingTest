package codingtest.site.codingInterview.sort.Q10_07;

public class Question
{
	/**
	 * 	1GB --> 1024MB --> 1024 * 1024 KB --> 1024 * 1024 * 1024 byte --> 1024 * 1024 * 1024 * 8 bit
	 * 	--> 80억 비트
	 */
	private static byte bitFields[] = new byte[Integer.MAX_VALUE / 4];
	
	public static void main(String [] args)
	{
		int n = 1;
		bitFields [0] |= 1 << (n % 8);
		System.out.println((bitFields[0] & 1) == 0);
		System.out.println((bitFields[0] & 2) == 0);
	}
	
	public static void findOpenNumber()
	{
		int count = 0;
		/** set bit */
		int n = 0; // 파일 n
		bitFields [n / 8] |= 1 << (n % 8);        
		
		/** get bit */
		for (int i = 0 ; i < bitFields.length ; i++)
		{
			for (int j = 0 ; j < 8 ; j++)
			{
				/** 빠진 숫자 채워넣기. */
				if ((bitFields[i] & (1 << j)) == 0)
					count++;
			}
		}
	}
}
