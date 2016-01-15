import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DeDup {	

    public int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
                                   20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
                                   13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};

    //Below is the best way to remove the duplicates in integer array in original order 
    public int[] removeDupsInInsertionOrder1(int[] dupArr) {    	
    	Set<Integer> set = new LinkedHashSet<Integer>();    	
    	int[] deDupArr = new int[dupArr.length];
        int i = 0;
        for (int value : dupArr) {
            if (set.add(value)) {
            	deDupArr[i++] = value;
            }
        }
        deDupArr = Arrays.copyOf(deDupArr, i);
        System.out.println("Deduped Array In Insertion Order1: "+Arrays.toString(deDupArr));
        return deDupArr;
    }    
  //Another way to remove the duplicates in integer array in original order.But this will take more time compare with the method1
    public int[] removeDupsInInsertionOrder2(int[] dupArr) {
        List<Integer> list = new ArrayList<Integer>();
        int[] deDupArr = new int[dupArr.length];
        int i = 0;
        for (int value : dupArr) {
            if (!list.contains(value)) {
            	list.add(value);
            	deDupArr[i++] = value;
            }
        }
        deDupArr = Arrays.copyOf(deDupArr, i);
        System.out.println("Deduped Array In Insertion Order2: "+Arrays.toString(deDupArr));
        return deDupArr;
    }
  //Below is way to remove the duplicates in integer array in ascending order
    public int[] removeDupsInAscendingOrder(int[] dupArr) {
    	Set<Integer> set = new TreeSet<Integer>();
    	for(int i : dupArr) {
    		set.add(i);
    	}
    	int[] deDupArr = new int[set.size()];
        int input = 0;
        for (Integer j : set) {
        	deDupArr[input++] = j;
        }
        System.out.println("Deduped Array In Assending Order: "+Arrays.toString(deDupArr));
        return deDupArr;
    }
   
    public static void main(String [] args) {
    	DeDup obj = new DeDup();
    	try {
	    	obj.removeDupsInInsertionOrder1(obj.randomIntegers);
	    	obj.removeDupsInInsertionOrder2(obj.randomIntegers);
	    	obj.removeDupsInAscendingOrder(obj.randomIntegers);
    	}
    	catch(Exception e) {
    		System.out.println("Your array is not initialized properly - Please check the array.");
    		throw e;
    	}
    }
}
