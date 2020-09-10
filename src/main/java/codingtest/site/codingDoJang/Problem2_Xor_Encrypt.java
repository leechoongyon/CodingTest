package codingtest.site.codingDoJang;

import java.io.*;

public class Problem2_Xor_Encrypt {
	public static void main(String[] args) {
		
		Problem2_Xor_Encrypt xorEncrypt = new Problem2_Xor_Encrypt();
		xorEncrypt.process();
	}

	public void process() {
		
		// 1. File Read
		
		String inputStr = FileContentRead(".\\file\\input\\txt\\cipher.txt");

		// 2. Split Part by delimeter ','
	
		String totalStr[] = inputStr.split(",");

		// 3. Search Valid Secret Key

		String secretKey = "";

		for(int i = 0 ; i < 3 ; i++) {
			secretKey += searchSecretKey(i, totalStr);
		}
		// 4. Decrypt ( Orginal -> ASCII ^ SecretKey = Decrypt )
		
		for(int i = 0 ; i < totalStr.length ; i++) {
			if(i % 3 == 0)
				System.out.print((char) (Integer.parseInt(totalStr[i]) ^ (int) secretKey.charAt(0)));
			if(i % 3 == 1)
				System.out.print((char) (Integer.parseInt(totalStr[i]) ^ (int) secretKey.charAt(1)));
			if(i % 3 == 2)
				System.out.print((char) (Integer.parseInt(totalStr[i]) ^ (int) secretKey.charAt(2)));
		}	
	}

	public char searchSecretKey(int startIndex, String[] totalStr) {

		int valid = 0;
		int count = 0;
		int max = 0;
		char picked = 0;

		for(char a = 'a' ; a <= 'z' ; a++) {
			for(int i = startIndex ; i < totalStr.length / 3; i = i + 3) {
				valid = Integer.parseInt(totalStr[i]) ^ (int) a;
				if(valid == 32)
					count++;
			}
			if(count > max) {
				picked = a;
				max = count;
			}
			count = 0;
		}
		return picked;
	}


	public static String FileContentRead(String fileName) {
		BufferedReader br = null;

		InputStreamReader isr = null;

		FileInputStream fis = null;

		File file = new File(fileName);
	
		String temp = "";

		StringBuffer content = new StringBuffer();

		try {
			fis = new FileInputStream(file);
	
			isr = new InputStreamReader(fis, "UTF-8");

			br = new BufferedReader(isr);

			while(( temp = br.readLine()) != null) {
				content.append(temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				isr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			return content.toString();
		}
	}
}
