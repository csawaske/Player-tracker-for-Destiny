import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapSorted {

	private static BufferedReader in;

	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader("filePath\\fileName.txt"));
		String str;
		
		//read list and convert to HashMap
		
		Map<String, Integer> myMap = new HashMap<String, Integer>();
		myMap.put("", 1);
		while((str = in.readLine()) != null){
			if (myMap.containsKey(str)) {
				int currentCount = (int) myMap.get(str);
				currentCount++;
				myMap.remove(str);
				myMap.put(str, currentCount);}
			else {
				myMap.put(str, 1);}
		}
		
		//print sorted HashMap
		
		Map<Integer, String> newMap = sortByValues(myMap); 
		System.out.println("After Sorting:");
		Set set = newMap.entrySet();
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			Map.Entry me = (Map.Entry)iterator.next();
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue());
		}
	}
	
	
		//method for sorting a HashMap according to its values
	
	  private static HashMap sortByValues(Map myMap) { 
	       List list = new LinkedList(myMap.entrySet());
	       // Defined Custom Comparator here
	       Collections.sort(list, new Comparator() {
	            public int compare(Object o1, Object o2) {
	               return ((Comparable) ((Map.Entry) (o1)).getValue())
	                  .compareTo(((Map.Entry) (o2)).getValue());
	            }
	       });


	       HashMap sortedHashMap = new LinkedHashMap();
	       for (Iterator it = list.iterator(); it.hasNext();) {
	              Map.Entry entry = (Map.Entry) it.next();
	              sortedHashMap.put(entry.getKey(), entry.getValue());
	       } 
	       return sortedHashMap;
	  }
		
		
		
		
		
		
	}

