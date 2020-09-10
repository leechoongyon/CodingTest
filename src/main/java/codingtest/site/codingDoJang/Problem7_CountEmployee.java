package codingtest.site.codingDoJang;

import java.util.Arrays;

public class Problem7_CountEmployee {
	/*
	  * desc : t 이전 출근자수 - t 이전 퇴근자수
	  * 이걸 정렬하고 이진탐색트리로 찾기. 
	  * 
	  * ver2가 제일 최선의 답
	  * ver1은 내가 푼 답
	  */

		public static void main(String[] args) {
			String timeSheet[] = {"10:34:31 11:20:10", "10:34:01 13:23:40", "09:12:23 11:14:35"};
			String specificTime = "11:22:20";

			Problem7_CountEmployee countEmployee = new Problem7_CountEmployee();
			
			int numRemainMember = countEmployee.process_ver2(timeSheet, specificTime);

			System.out.println("Remain Member : " + numRemainMember);
		}

		public int process_ver2(String timeSheet[], String specificTime) {
			String beforeAttendance[] = new String[3];
			String afterUnAttendance[] = new String[3];

			String temp[];

			for(int i = 0 ; i < timeSheet.length ; i++) {
				temp = timeSheet[i].split(" ");
				beforeAttendance[i] = temp[0];
				afterUnAttendance[i] = temp[1];
			}
			Arrays.sort(beforeAttendance);
			Arrays.sort(afterUnAttendance);

			int numAttendance = 0;
			int numUnAttendance = 0;

			numAttendance = SpecialBinarySearch(beforeAttendance, specificTime, 0, beforeAttendance.length-1);
			numUnAttendance = SpecialBinarySearch(afterUnAttendance, specificTime, 0, afterUnAttendance.length-1);
		
			return numAttendance - numUnAttendance;
		}
		
		public int SpecialBinarySearch(String[] numbers, String key, int min, int max) {
			if(min > max)
				return min;
			int mid = (min + max) / 2;
			
			if(key.compareTo(numbers[mid]) > 0) 
				return SpecialBinarySearch(numbers,key,mid+1,max);
			else if(key.compareTo(numbers[mid]) < 0) 
				return SpecialBinarySearch(numbers,key,min,mid-1);
			else if(key == numbers[mid])
				return mid;
			else
				throw new RuntimeException("Not Found");
		}

		/*public class CountEmployee {
			static int count = 0;

			public static void main(String[] args) {
				String timeSheet[] = new String[3];
				String specificTime = "11:05:20";
				
				CountEmployee countEmployee = new CountEmployee();
				CountEmployee.init(timeSheet);
				CountEmployee.process(timeSheet, specificTime);

				System.out.println("Remain Member : " + count);
			}

			public void init(String timeSheet[]) {
				timeSheet[0] = "09:12:23 11:14:35"; timeSheet[1] = "10:34:01 13:23:40"; timeSheet[2] = "10:34:31 11:20:10";
			}
				
			public void process(String timeSheet[], String specificTime) {
				String temp[];

				for(int i = 0 ; i < timeSheet.length ; i++) {
					temp = timeSheet[i].split(" ");
			
					if(changeStringToTime(temp[0]) < changeStringToTime(specificTime) && changeStringToTime(specificTime) < changeStringToTime(temp[1]))
					count++;
				}
			}

			public int changeStringToTime(String time) {
				String NEW_FORMAT = "HH:mm:ss";
				int totalSecond = 0;
			
				SimpleDateFormat transFormat = new SimpleDateFormat(NEW_FORMAT);
				
				Date to = null;
			
				try {
					to = transFormat.parse((time));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				totalSecond = (to.getHours() * 60 * 60 + to.getMinutes() * 60 + to.getSeconds());

				return totalSecond;
			}
		}
*/
		
}
