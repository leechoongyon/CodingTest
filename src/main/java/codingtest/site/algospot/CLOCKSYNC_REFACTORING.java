package codingtest.site.algospot;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @file		algospot.CLOCKSYNC_REFACTORING.java
 * @filetype	java source file
 * @brief
 * @author		lee
 * @version		0.1
 * @history
 * 버전			성명			일자			변경내용
 * 0.1			lee		2015. 9. 8.		신규작성
 *
 *
 * 이 방법은 수학적으로 푼 것임.
 * 특정 시계는 특정 스위치에만 연결되있다는 가정하에 이 문제를 풀었음.
 * 
 * 예를 들면, 8번 시계는 스위치 4번에만 연결되있다.
 * 이걸 바탕으로 4번 스위치를 몇 번 눌러야 8번을 만족하는지 조건이 나오고
 * 이에 따라 다른 것도 이와 비슷하게 풀어나가다보면 답 나옴.
 * 
 */
public class CLOCKSYNC_REFACTORING {
    static BufferedReader stdin
            = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int numTest = Integer.parseInt(stdin.readLine());
        int[] res = new int[numTest];
        for(int t = 0; t < numTest; t++) {
            String[] input = stdin.readLine().split(" ");
            for(int m = 0; m < 16; m++)
                clockTime[m] = (byte)(Byte.parseByte(input[m]) / 3 % 4);
            res[t] = solve();            
        }
        for(int r : res)
            System.out.println(r);
    }
    
    static int solve() {
    	
    	for (int i = 0 ; i < clockTime.length ; i++)
    		System.out.print(clockTime[i] + " ");
    	System.out.println();
    	
        int sum = 0;
        // 시계의 8번과 12번을 바꾸는 것은 스위치 4번이기에 다르면 무조건 잘못된 거다. 
        if(clockTime[8] != clockTime[12])
            return -1;
        sum += adjust(4, 8);
        sum += adjust(1, 11);
        if(clockTime[9] != clockTime[13])
            return -1;
        sum += adjust(9, 9);
        sum += adjust(2, 10);
        sum += adjust(3, 6);
        sum += adjust(7, 7);
        sum += adjust(8, 5);
        if(clockTime[4] != 0)
            return -1;
        sum += adjust(6, 3);
        sum += adjust(0, 1);
        sum += adjust(5, 2);
        if(clockTime[0] != 0 || clockTime[14] != 0 || clockTime[15] != 0)
            return -1;
        return sum;
    }
    
    static int adjust(int iSwitch, int iClock) {
        int numPress = (4 - clockTime[iClock]) % 4;
        for(int i = 0; i < switchToClocks[iSwitch].length; i++) {
            clockTime[switchToClocks[iSwitch][i]] += numPress;
            clockTime[switchToClocks[iSwitch][i]] %= 4;
        }
        return numPress;
    }
    
    static byte[] clockTime = new byte[16];   // [0] → 1 → 2 → 3 → [0]
    
    static int[][] switchToClocks = {
        {0, 1, 2},              // SWITCH 0
        {3, 7, 9, 11},          // SWITCH 1
        {4, 10, 14, 15},        // SWITCH 2
        {0, 4, 5, 6, 7},        // SWITCH 3
        {6, 7, 8, 10, 12},      // SWITCH 4
        {0, 2, 14, 15},         // SWITCH 5
        {3, 14, 15},            // SWITCH 6
        {4, 5, 7, 14, 15},      // SWITCH 7
        {1, 2, 3, 4, 5},        // SWITCH 8
        {3, 4, 5, 9, 13}        // SWITCH 9
    };
}
