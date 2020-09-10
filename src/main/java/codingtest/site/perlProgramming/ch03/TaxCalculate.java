package codingtest.site.perlProgramming.ch03;

public class TaxCalculate
{
	public static void main(String[] args)
	{
		int inputIncome = 2300;
	
		int income[] = {2200, 2700, 3200, 3700};
		int tax[] = {0, 70, 145, 225};
		double taxRate[] = {0.14, 0.15, 0.16, 0.17};
		
		double result = 0;

		final int LimitVariable = 4;

		for (int  i = 1 ; i < LimitVariable ; i++)
		{
			if(inputIncome <= income[i])
			{
				result = tax[i] + taxRate[i] * ( inputIncome - income[i-1]);
				break;
			}
			else if( i == (LimitVariable -1))
			{
				result = 295 + 0.70 * (inputIncome - 1000);
			}
		}
	
		System.out.println("Tax : " + result);
	}
}
