import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class DeDup {	

    public int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
                                   20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
                                   13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};

    //Below is the best way to remove the duplicates in integer array in original order using collections
    public int[] removeDupsInInsertionOrder1(int[] dupArr) {    	
    	Set<Integer> set = new LinkedHashSet<Integer>();    	
    	int[] deDupArr = new int[dupArr.length];
        int i = 0;
        for (int j : dupArr) {
            if (set.add(j)) {
            	deDupArr[i++] = j;
            }
        }
        deDupArr = Arrays.copyOf(deDupArr, i);
        set.clear();
        System.out.println("Deduped Array In Insertion Order1: "+Arrays.toString(deDupArr));
        return deDupArr;
    }    
    //Another way to remove the duplicates in integer array in original order without using collections.
    public int[] removeDupsInInsertionOrder2(int[] dupArr) {
        int deDupArr[] = new int[dupArr.length];
        int j=0;
        boolean flag = false;
        for (int i : dupArr) {
        	for (int k : deDupArr) {
        		if(k == i) {
        			flag = true;
        			break;
        		}
        		else
        			flag = false;
        	}
        	if(!flag) {
        		deDupArr[j++] = i;
    		}
        }
        deDupArr = Arrays.copyOf(deDupArr, j);
        System.out.println("Deduped Array In Insertion Order2: "+Arrays.toString(deDupArr));
        return deDupArr;
    }
    //Below is the best way to remove the duplicates in integer array in ascending order using collections
    public int[] removeDupsInAscendingOrder(int[] dupArr) {
    	Set<Integer> set = new TreeSet<Integer>();
    	for(int i : dupArr) {
    		set.add(i);
    	}
    	int[] deDupArr = new int[set.size()];
        int j = 0;
        for (Integer k : set) {
        	deDupArr[j++] = k;
        }
        set.clear();
        System.out.println("Deduped Array In Ascending Order: "+Arrays.toString(deDupArr));
        return deDupArr;
    }    
       
    public static void main(String[] args) {
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
