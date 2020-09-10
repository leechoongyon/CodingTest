package codingtest.site.algospot;

import java.util.*;

/*
  	
2
4 6
cl bom dara minzy
2 dara minzy
2 cl minzy
2 cl dara
cl
2 bom dara
2 bom minzy
10 7
a b c d e f g h i j
6 a c d h i j
3 a d i
7 a	c f g h i j
3 b d g
5 b c f h i
4 b e g j
5 b c g h i 
	
예제	 출력
2
3

*/


public class ALLERGY {
	
	private static int min = Integer.MAX_VALUE;
	private static int[] resultList;
	
	public static void main(String[] args) {
		
		int caseNum = 0;

		int friendNum = 0; int foodNum = 0;
		
		Map<String, String> friendMap = new HashMap<String, String>();
		List<Food> foodList = new ArrayList<Food>();
		
		// 1. Input
		Scanner scan = new Scanner(System.in);
		
		caseNum = scan.nextInt();
		
		for (int i = 0 ; i < caseNum ; i++) {
			String temp = scan.next();
			friendNum = Integer.parseInt(temp);
			foodNum = Integer.parseInt(scan.next());

			for (int k = 0 ; k < friendNum ; k++) {
				friendMap.put(scan.next(), "X");
			}
			
			scan.nextLine();
			
			for (int j = 0 ; j < foodNum ; j++) {
				
				String temp1 = scan.nextLine();
				String temp2[] = temp1.split(" ");
				
				Food food = new Food();
				
				for (int t = 1 ; t < temp2.length ; t++) {
					food.satisfiedFreiend.add(temp2[t]);
				}
				foodList.add(food);
			}
				/*printFriendMap(friendMap); printFriendList(foodList);*/ 
				foodCombination(friendMap, foodList, foodNum);
				System.out.println(min);
				reset(friendMap, foodList);
		}
	}
	
	public static void reset(Map<String, String> friendMap, List<Food> foodList) {
		
		min = Integer.MAX_VALUE;
		
		// reset friendMap
		friendMap.clear();
		
		// reset foodList
		foodList.clear();
		
	}
	
	public static void printFriendList(List<Food> foodList) {
		
		System.out.println("printFriendList");
		
		for (int i = 0 ; i < foodList.size(); i++) {
			for (int j = 0 ; j < foodList.get(i).satisfiedFreiend.size(); j++) {
				System.out.print(foodList.get(i).satisfiedFreiend.get(j) + "\t");
			}
			System.out.println();
		}
	}
	
	public static void printFriendMap(Map<String, String> friendMap) {
		Iterator<String> iter = friendMap.keySet().iterator();
		System.out.println("printFriendMap");
		while(iter.hasNext()) {
			System.out.print(iter.next() +" ");
		}
		System.out.println();
	}
	
	public static void printPickedArray(int picked[]) {
	
		System.out.println("printPickedArray");
		for (int i = 0 ; i < picked.length ; i++) 
			System.out.print(picked[i] + " ");
		System.out.println();
			
	}
	
	public static void foodCombination(Map<String, String> friendMap, List<Food> foodList, int n) {
		
		int picked[]; 
		
		for (int r = 1 ; r < n; r++) {
	    	picked = createPointerList(r);
	    	/*printPickedArray(picked);*/
	    	do { 
	    		for (int i = 0 ; i < picked.length ; i++) {
	    			List<String> tempList = foodList.get(picked[i]).satisfiedFreiend;
	    			int foodListSize = tempList.size();
	    			for (int j = 0 ; j < foodListSize ; j++) {
	    				friendMap.put(tempList.get(j), "O");
	    			}
	    		}
	    		
	    		if (min < picked.length)
	    			return;
	    		if (picked.length != 0) 
	    			checkSatisfication(friendMap, foodList, picked);
	    	} while (next(n, picked)); 
	    }
		
		
	}
	
	public static void checkSatisfication(Map<String, String> friendMap, List<Food> foodList, int [] pickedList) {
		
		int pickedSize = pickedList.length;
		for (int i = 0 ; i < pickedSize ; i++) {
			List<String> tempList = foodList.get(pickedList[i]).satisfiedFreiend;
			int foodListSize = tempList.size();
			for (int j = 0 ; j < foodListSize ; j++) {
				friendMap.put(tempList.get(j), "O");
			}
		}
		
		if (isSatisfied(friendMap)) 
			min = pickedList.length;
			/*resultList = pickedList;*/
		
		reset(friendMap);
	}
	
	public static boolean isSatisfied(Map<String, String> friendMap) {
		return !(friendMap.containsValue("X"));
	}
	
	public static void reset(Map<String, String> friendMap) {
		Iterator<String> iter = friendMap.keySet().iterator();
		while (iter.hasNext()) {
			friendMap.put(iter.next(), "X");
		}
	}
	
	public static void print(int [] picked) {
		for (int i = 0 ; i < picked.length ; i++) {
			System.out.print(picked[i]);
		}
	}
	
	public static int[] createPointerList(int n) { 
	    int[] ptrList = new int[n];
	    for(int i = 0; i < n; i++) 
	        ptrList[i] = n - 1 - i; 
	    return ptrList; 
	}
	
	public static boolean next(int N, int[] ptrList) {  
	    for(int i = 0; i < ptrList.length; i++) {  
	        if(ptrList[i] < N - 1 - i) {  
	            ptrList[i]++;  
	            for(int j = i - 1; j >= 0; j--)  
	                ptrList[j] = ptrList[i] + (i - j);  
	            return true;  
	        }                  
	    } 
	    return false;
	}
}

class Food {
	List<String> satisfiedFreiend = new ArrayList<String>();
}


