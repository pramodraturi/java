import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

//public class ListAndAsListDifference {
//	
//	//asList method from Arrays.
//	//List from collection.
//	
//	
//	public static void main(String args[]) {
//		List<String> arrayList = new ArrayList<>();
//		arrayList.add("A");
//		arrayList.add("B");
//		arrayList.add("C");
//		arrayList.add("D");
//		arrayList.add("E");
//		
//		String[] strArray = new String[] {"A","B","C","D","E"};
//		
//		List<String> strArrayList = Arrays.asList("A","B","C","D","E"); 
//		
//		System.out.println("Array Hashcode: "+strArray.hashCode());
//		System.out.println("Array Hashcode: "+strArrayList.hashCode());
//		System.out.println("......");
//		
//	}
//
//}

public class ListAndAsListDifference {

    public static void main(String[] args) {
        List<Integer> list1, list2 = null;
        Integer[] intarr = { 3, 4, 2, 1 };
        list1 = Arrays.asList(intarr);
        intarr[1]=500;
       
       list1.add(1,50);
        Iterator<Integer> itr1 = list1.iterator();
        while (itr1.hasNext()) {
            System.out.println(itr1.next());
        }
        System.out.println(intarr);
    }
}