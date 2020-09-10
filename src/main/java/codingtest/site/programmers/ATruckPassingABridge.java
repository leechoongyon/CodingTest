package codingtest.site.programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lee

bridge_length	weight	truck_weights	return
2	10	[7,4,5,6]	8
100	100	[10]	101
100	100	[10,10,10,10,10,10,10,10,10,10]	110

 
 */
public class ATruckPassingABridge
{
	public static void main(String [] args)
	{
		/** Testcase 1 **/
		int[] truck_weights = new int[] {7,4,5,6};
		int bridge_length = 2;
		int weight = 10;
		
		/** TestCase 2 */
		/*int[] truck_weights = new int[] {10};
		int bridge_length = 100;
		int weight = 100;*/
		
		/** TestCase 3 */
		/*int[] truck_weights = new int[] {10,10};
		int bridge_length = 100;
		int weight = 100;*/
		
		/** TestCase 4 */
/*		int[] truck_weights = new int[] {10,10,10,10,10,10,10,10,10,10};
		int bridge_length = 100;
		int weight = 100;*/
		
		int answer = new ATruckPassingABridge().solution(bridge_length, weight, truck_weights);
		System.out.println(answer);
	}
	
    public int solution(int bridge_length, int weight, int[] truck_weights) 
    {
    	Queue<Integer> weightQueue = new LinkedList<>();
    	Queue<Integer> timeQueue = new LinkedList<>();
    	
    	int truckPos = 0;
    	int answer = 0;
    	/**
    	 * 	Sol1
    	 * 	1. bridge 안에 data 가 존재하면 1칸씩 이동. 
    	 * 		- bridge 마지막에 있는 것이 나올려고 한다면 제거
    	 * 	2. bridge 첫 번째에 다음 truck 을 올릴 수 있는지 확인
    	 * 		- bridge 에 올리면 truckPos++
    	 * 
    	 * 	Sol2
    	 * 	Bridge 를 int 배열이 아니라 Queue 를 사용하는 방법
    	 * 	데이터를 queue 에 집어넣음.
    	 * 	빼는 순간과 넣는 순간을 알아야 됨. 큐를 2개 운용 함.
    	 * 	- 하나는 버스 무게를 담는 큐. (WeightQueue)
    	 * 	- 또 하나는 버스가 끝에 도달할 때의 초 (TimeQueue)
    	 * 
    	 * 	1. 버스를 큐2개에 집어넣음. 
    	 * 		1) 넣을 수 있을 때
    	 * 			- WeightQueue 에 7을 집어넣음. 로컬변수(weight) 에 7을 기록
    	 * 			- timeQueue 에 3를 집어넣음. time 변수에 3을 기록
    	 * 		2) 넣을 수 없을 때
    	 * 			- 로컬변수(weight) 가 다리 무게를 초과
    	 * 	2. time 이 while 문 한바퀴 돌면 time++ 이 됨.
    	 * 
    	 * 	상황시뮬레이션
    	 * 	1. 한바퀴 돌음.
    	 * 		- WeightQueue 에 7을 집어넣음. 로컬변수(weight) 에 7을 기록
    	 * 		- timeQueue 에 3를 집어넣음. time 변수에 3을 기록
    	 * 	2. 2초
    	 * 		- currentTime = 2, extracTime = 3
    	 * 	3. 3초
    	 * 		- currentTime = 3, extracTime = 3
    	 * 		- 시간이 같으니 weightQueue 에서 값을 빼서 로컬변수에 차감을 해줌.
    	 * 		- 새로운 버스를 WeightQueue 에 집어넣음. weight 6 기록.
    	 * 		- 새로운 버스를 TimeQueue 에 집어넣음. currentTime + bridge_length + 1
    	 */
    	
    	int currentWeight = 0;
    	int currentTime = 0;
    	int extractTime = 0;
    	while (truckPos < truck_weights.length)
    	{
    		/** 
    		 * 	0초일 때, 7트럭이 다리에 올라감.
    		 * 	1초일 때, 스킵
    		 * 	2초일 때, 스킵
    		 * 	3초일 떄, 7이 빠지고, 4초가 올라감. 이 때, extractTime 은 5가 되야 됨.
    		 * 	4초일 때, 4,5 순으로 다리에 오름.
    		 * 	5초일 때, 4가 빠짐.
    		 * 	6초일 때, 5가 빠짐. 6이 오름.
    		 * 	7초일 때, 스킵
    		 * 	8초일 때, 6이 빠짐. 
    		 */
    		currentTime++;
    		if ( !timeQueue.isEmpty() && extractTime == 0)
    			extractTime = timeQueue.poll();
    		if ( !weightQueue.isEmpty() && currentTime == extractTime)
    		{
    			currentWeight -= weightQueue.poll();
    			extractTime = 0;
    		}
    		
    		if (currentWeight + truck_weights[truckPos] <= weight)
    		{
    			weightQueue.add(truck_weights[truckPos]);
   				timeQueue.add(currentTime + bridge_length);
    			
    			currentWeight += truck_weights[truckPos];
    			truckPos++;
    		}
    	}
    	
    	/** queue 에 남아있으면 빼서 더해주기. */
    	if ( !weightQueue.isEmpty() && !timeQueue.isEmpty())
    	{
    		while ( !timeQueue.isEmpty())
    		{
    			answer = timeQueue.poll();
    		}
    	}
    	else 
    		answer = currentTime;
	    return answer;
	}
}
