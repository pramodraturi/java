import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

import org.csdc.threads.Thread1;
import org.csdc.threads.Thread2;
import org.csdc.threads.Thread3;
import org.csdc.threads.Thread4;

public class TestCoreJava {
	
	public static void main(String args[]) {
		/*Map<String, Integer> map =  new HashMap<String, Integer>();
		map.put("`", 1);
		map.put(null, 3);
		map.put("a", 2);
		Hashtable<String, Integer> hashTable = new Hashtable<>();
		String s1="asdf";
		String s2 = new String("asdf");
		if(s1==s2) {
			System.out.println("equals");
		}else {
			System.out.println("not equals");
		}*/
		/*LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
		linkedHashMap.put("A", 1);
		linkedHashMap.put("B", 2);
		linkedHashMap.put("C", 3);
		System.out.println("...");*/
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		Map<String, Integer> synchronizedMap = Collections.synchronizedMap(map);
		
		Thread1 t1 = new Thread1(synchronizedMap);
		Thread2 t2 = new Thread2(synchronizedMap);
		Thread3 t3 = new Thread3(synchronizedMap);
		Thread4 t4 = new Thread4(synchronizedMap);
		
		for(Map.Entry<String, Integer> entry : synchronizedMap.entrySet()) {
			System.out.println("Key:"+entry.getKey() + ", Value: " + entry.getValue());
			
		}
		
		
		
	}

}
