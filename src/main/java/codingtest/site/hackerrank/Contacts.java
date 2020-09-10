package codingtest.site.hackerrank;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * @author lee
 * @point & feedback
 * 
 * 1. contact 프로그램 개발
 * 2. add, find 두 함수 있음.
 * 3. add 는 연락처에 저장
 * 4. find 는 연락처들중 입력된 문자열로 시작하는 것이 몇 개 인지 print
 * 5. name 중복 X
 * 
4
add hacb
add haca
find hac
find hak
 */
public class Contacts 
{	
	private static Map<Character, ContactStore> contactStores = new HashMap<Character, ContactStore>();
	
	public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++)
        {
            String op = in.next();
            String contact = in.next();
            
            solve(op, contact);
            
//            print();
        }
    }
    
	public static void print()
	{
		Iterator<Character> iter = contactStores.keySet().iterator();
		Character c = iter.next();
		System.out.print(c + " ");
		ContactStore contactStore = contactStores.get(c);
		ContactStore c1 = contactStore.childContactStore.get('a');
		ContactStore c2 = c1.childContactStore.get('c');
		ContactStore c3 = c2.childContactStore.get('b');
		System.out.println(c1.c);
		System.out.println(c2.c);
		System.out.println(c3.c);
	}
	
    public static void solve(String op, String contact)
    {
    	if ("add".equals(op))
    	{
    		if (contactStores.containsKey(contact.charAt(0)))
    		{
    			ContactStore contactStore = contactStores.get(contact.charAt(0));
    			contactStore.add(contact);
    		}
    		else
    		{
    			ContactStore contactStore = new ContactStore();
    			contactStore.add(contact);
    			contactStores.put(contact.charAt(0), contactStore);
    		}
    	}
    	else if ("find".equals(op))
    	{
    		if (contactStores.containsKey(contact.charAt(0)))
    		{
    			System.out.println(contactStores.get(contact.charAt(0)).find(contact));
    		}
    		else
    			System.out.println(0);
    		
    	}
    	else
    		throw new IllegalArgumentException("Invalid argument...");
    }
}

class ContactStore
{
	char c;
	int count;
	Map<Character, ContactStore> childContactStore = new HashMap<Character, ContactStore>();
	
	public void add(String contact)
	{
		count++;
		this.c = contact.charAt(0);
		
		if (contact.length() == 1)
			return ;
			
		if (contact.length() > 1 && 
			childContactStore.containsKey(contact.charAt(1)))
		{
			childContactStore.get(contact.charAt(1)).add(contact.substring(1));
		}
		else
		{
			ContactStore contactStore = new ContactStore();
			contactStore.add(contact.substring(1));
			childContactStore.put(contact.charAt(1), contactStore);
		}
	}
	
	public int find(String contact)
	{
		ContactStore store = this;
		for (int i = 1 ; i < contact.length() ; i++)
		{
			if (store.childContactStore.containsKey(contact.charAt(i)))
			{
				store = store.childContactStore.get(contact.charAt(i));
			}
			else
				return 0;
		}
		
		if (store != null)
			return store.count;
		
		return count;
	}
}
