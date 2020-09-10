package codingtest.site.solveProblemsExample;

import java.util.ArrayList;

public class Q24_Sushi {
	
	
	public static void main(String[] args) {
		ArrayList<DataSet> list = new ArrayList<DataSet>();
		int budget = 543975612;
		int satisfaction = 0;

		Q24_Sushi calculateSushiPrice = new Q24_Sushi();
		calculateSushiPrice.init(list);
		satisfaction = calculateSushiPrice.process(list,budget);

		System.out.println("satisfactin : " + satisfaction);

	}
	
	public void init(ArrayList<DataSet> list) {
		DataSet dataSet = new DataSet();
		dataSet.price = 2500; dataSet.satisfaction = 7;
		list.add(dataSet);
		

		DataSet dataSet1 = new DataSet();
		dataSet1.price = 3000; dataSet1.satisfaction = 9;
		list.add(dataSet1);

		DataSet dataSet2 = new DataSet();
		dataSet2.price = 4000; dataSet2.satisfaction = 10;
		list.add(dataSet2);

		DataSet dataSet3 = new DataSet();
		dataSet3.price = 5000; dataSet3.satisfaction = 12;
		list.add(dataSet3);

		DataSet dataSet4 = new DataSet();
		dataSet4.price = 10000; dataSet4.satisfaction = 20;
		list.add(dataSet4);

		DataSet dataSet5 = new DataSet();
		dataSet5.price = 15000; dataSet5.satisfaction = 1;
		list.add(dataSet5);
	}

	public int sushi() {
		return 0;
	}
	
	public int process(ArrayList<DataSet> list, int budget) {

		// 1. calculate (Budget / Each Item Price)
		// 2 if there is some money left, calculate other item satisfaction

		int totalItemSatisfaction = 0;

		int oddBudget = 0;
		int itemCount = 0;
		int itemPrice = 0;

		// 3. check stopCondition
	
		if(checkStopCondition(list, budget))
			return 0;

		for(int i = 0 ; i < list.size() ; i++) {
			int eachItemSatisfaction = 0;

			itemPrice = list.get(i).price;
			itemCount = budget / itemPrice;

			if(itemPrice > budget)
				continue;
			
			eachItemSatisfaction = itemCount * list.get(i).satisfaction;
			oddBudget = budget - (itemCount * itemPrice);
			System.out.println("itemPrice : " + itemPrice + " \t itemCount : " + itemCount + " \t budget : " + budget + " \t oddBudget : " + oddBudget);

			totalItemSatisfaction = Math.max(totalItemSatisfaction, process(list, oddBudget) + eachItemSatisfaction);

		}
		return totalItemSatisfaction;
	}

	public boolean checkStopCondition(ArrayList<DataSet> list, int budget) {
		boolean status = true;

		for(int i = 0 ; i < list.size() ; i++) {
			if(list.get(i).price < budget)
				status = false;
		}
		return status;
	}

	class DataSet {
		int price;
		int satisfaction;
	}
}		
