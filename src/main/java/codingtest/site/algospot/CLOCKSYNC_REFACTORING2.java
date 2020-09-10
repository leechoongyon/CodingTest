package codingtest.site.algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @file		algospot.CLOCKSYNC_REFACTORING2.java
 * @filetype	java source file
 * @brief
 * @author		lee
 * @version		0.1
 * @history
 * 버전			성명			일자			변경내용
 * 0.1			lee		2015. 9. 8.		신규작성
 * 
 * 기가막힌 로직이다.
 * 나랑 비슷한 로직인데 이것은 따로 저장공간을 두지 않음.
 * 재귀 패턴은 i = 0~3 까지 4의 10승 만큼 반복하는 것인데 
 * 4번을 눌렀을 때 리셋이 된다는 것을 가정하고 이렇게 만든 것이다.
 * 이 한가지 때문에 나랑 속도가 4배 차이남.
 * i = 0~3까지 10번을 조합하기에 모든 경우의수를 다 비교하는거지.
 * 
 * 이 부분도 정말 잘짰네.
 * ret = Math.min(ret, i+solve(buttonNum+1))
 * 
 * 이렇게 함으로써 누적된  ret가 차례대로 돌아옴.
 * 
 */
public class CLOCKSYNC_REFACTORING2{
	
    static int button[][] = new int[][]{
            {0, 1, 2},
            {3, 7, 9, 11},
            {4, 10, 14, 15},
            {0, 4, 5, 6, 7},
            {6, 7, 8, 10, 12},
            {0, 2, 14, 15},
            {3, 14, 15},
            {4, 5, 7, 14, 15},
            {1, 2, 3, 4, 5},
            {3, 4, 5, 9, 13}
    };
     
    static int clock[] = new int[16];
     
    public static void main(String args[]) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine().trim());
        while( T-- > 0 ){
            StringTokenizer st = new StringTokenizer(br.readLine());
             
            for(int i = 0; i < 16; i++)
                clock[i] = Integer.parseInt(st.nextToken());
             
            int ans = solve(0);
             
            if( ans < NOSOLVE )
                System.out.println(ans);
            else
                System.out.println(-1);
        }
    }
     
    public static boolean isOK(){
        boolean ret = true;
        for(int c : clock)
            ret &= (c == 12);
                 
        return ret;
    }
     
    // 버튼 누르기
    public static void push(int n){
        for(int b : button[n]){
            clock[b] += 3;
            if( clock[b] >= 15 )
                clock[b] = 3;
        }
    }
         
    static int NOSOLVE = 100000;
    public static int solve(int buttonNum){
        
    	System.out.println("buttonNum : " + buttonNum);
    	
     	int ret = NOSOLVE;
        if( buttonNum == 10 )
            return isOK() ? 0 : NOSOLVE;        
         
        for(int i = 0; i < 4; i++){
            ret = Math.min(ret, i + solve(buttonNum + 1));
            push(buttonNum);
        }
         
        return ret;
    }
}
