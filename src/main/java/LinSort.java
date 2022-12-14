import java.math.BigInteger;
import java.util.*;

public class LinSort {

    /**
     * LSDSort
     *      best: O(n)
     *      middle: O(n*max_radix)
     *      bad: O(n*max_radix)
     * MDSSort
     *      best: O(n)
     *      middle: O(n*max_radix)
     *      bad: O(n*max_radix)
     * CountSort
     *      best: O(n)
     *      middle: O(n)
     *      bad: O(n)
     */
    public LinSort() {
    }

    private static void LSDSort(String[] arr) {
        if(arr.length == 0) {
            return;
        }
        int radix = 0;
        boolean wasSort = true;
        myList<String>[] listsForDigits = new myList[11]; // from 0 to 9 and -1
        for (int i = 0; i < 11; i++) {
            listsForDigits[i] = new myList<>();
        }
        while(wasSort) {
            LSDSortByRadix(arr, radix, listsForDigits);
            wasSort = false;
            if(listsForDigits[0].size() == arr.length) {
                for(String str : arr) {
                    if (radix < str.length()) {
                        wasSort = true;
                        break;
                    }
                }
            } else {
                wasSort = true;
            }
            radix++;
            for(int i = 0; i < 11; i++) {
                listsForDigits[i].clear();
            }
        }
    }

    private static void LSDSortByRadix(String[] arr, int radix, myList<String>[] listsForDigits) {
        int digit;
        for (String s : arr) {
            if (radix >= s.length()) {
                listsForDigits[0].add(s);
                continue;
            }
            digit = s.charAt((s.length() - 1) - radix) - '0';
            if(digit == -3) { // digit is '-'
                digit = 10;
            }
            listsForDigits[digit].add(s);
        }
        int index = 0;
        for (ListIterator it = listsForDigits[10].listIterator(listsForDigits[10].size()); it.hasPrevious();) {
            arr[index] = (String) it.previous();
            index++;
        }
        for (int i = 0; i < 10; i++) {
            for (Iterator it = listsForDigits[i].iterator(); it.hasNext(); ) {
                arr[index] = (String) it.next();
                index++;
            }
        }
    }

    public static void LSDSort(Integer[] arr, int begin, int end) {
        if( begin < 0 || begin > arr.length || end < 0 || end > arr.length || end < begin) {
            throw new ArrayIndexOutOfBoundsException();
        }
        String[] arrStr = new String[end-begin];
        for(int i = begin; i < end; i++) {
            arrStr[i-begin] = arr[i].toString();
        }
        LSDSort(arrStr);
        for(int i = begin; i < end; i++) {
            arr[i] = Integer.valueOf(arrStr[i-begin]);
        }
    }

    public static void LSDSort(Integer[] arr) {
        LSDSort(arr, 0, arr.length);
    }

    public static void LSDSort(int[] arr, int begin, int end) {
        if( begin < 0 || begin > arr.length || end < 0 || end > arr.length || end < begin) {
            throw new ArrayIndexOutOfBoundsException();
        }
        String[] arrStr = new String[end-begin];
        for(int i = begin; i < end; i++) {
            arrStr[i-begin] = Integer.toString(arr[i]);
        }
        LSDSort(arrStr);
        for(int i = begin; i < end; i++) {
            arr[i] = Integer.parseInt(arrStr[i-begin]);
        }
    }

    public static void LSDSort(int[] arr) {
        LSDSort(arr, 0, arr.length);
    }

    public static void LSDSort(BigInteger[] arr, int begin, int end) {
        if( begin < 0 || begin > arr.length || end < 0 || end > arr.length || end < begin) {
            throw new ArrayIndexOutOfBoundsException();
        }
        String[] arrStr = new String[end-begin];
        for(int i = begin; i < end; i++) {
            arrStr[i-begin] = arr[i].toString();
        }
        LSDSort(arrStr);
        for(int i = begin; i < end; i++) {
            arr[i] = BigInteger.valueOf(Integer.parseInt(arrStr[i-begin]));
        }
    }

    public static void LSDSort(BigInteger[] arr) {
        LSDSort(arr, 0, arr.length);
    }

    private static void MSDSortR(String[] arr, int begin, int end, int radix) {
        if(begin == end || end - begin == 1) {
            return;
        }
        myList<String>[] listsForDigits = new myList[11]; // from 0 to 9 and -1
        for (int i = 0; i < 11; i++) {
            listsForDigits[i] = new myList<>();
        }
        for (int i = begin; i < end; i++) {
            if (radix < arr[i].length()) {
                int digit = arr[i].charAt((arr[i].length() - 1) - radix) - '0';
                if(digit == -3) { // digit is '-'
                    digit = 10;
                }
                listsForDigits[digit].add(arr[i]);
            } else {
                listsForDigits[0].add(arr[i]);
            }
        }
        int index = begin;
        for (ListIterator it = listsForDigits[10].listIterator(listsForDigits[10].size()); it.hasPrevious();) {
            arr[index] = (String) it.previous();
            index++;
        }
        MSDSortR(arr, begin, index, radix-1);
        for (int i = 0; i < (index-begin)/2; i++) { // reverse negative numbers
            String tmp = arr[i+begin];
            int indx = (index - begin) - 1 - i + begin;
            arr[i+begin] = arr[indx];
            arr[indx] = tmp;
        }
        for (int i = 0; i < 10; i++) {
            int beginIndex = index;
            for (Iterator it = listsForDigits[i].iterator(); it.hasNext(); ) {
                arr[index] = (String) it.next();
                index++;
            }
            MSDSortR(arr, beginIndex, index, radix-1);
        }
    }

    public static void MSDSort(Integer[] arr, int begin, int end) {
        if( begin < 0 || begin > arr.length || end < 0 || end > arr.length || end < begin) {
            throw new ArrayIndexOutOfBoundsException();
        }
        String[] arrStr = new String[end-begin];
        int max_length = 0;
        for(int i = begin; i < end; i++) {
            arrStr[i-begin] = arr[i].toString();
            if (arrStr[i-begin].length() > max_length) {
                max_length = arrStr[i-begin].length();
            }
        }
        MSDSortR(arrStr, 0, arrStr.length, max_length-1);
        for(int i = begin; i < end; i++) {
            arr[i] = Integer.valueOf(arrStr[i-begin]);
        }
    }

    public static void MSDSort(Integer[] arr) {
        MSDSort(arr, 0, arr.length);
    }

    public static void MSDSort(int[] arr, int begin, int end) {
        if( begin < 0 || begin > arr.length || end < 0 || end > arr.length || end < begin) {
            throw new ArrayIndexOutOfBoundsException();
        }
        String[] arrStr = new String[end-begin];
        int max_length = 0;
        for(int i = begin; i < end; i++) {
            arrStr[i-begin] = Integer.toString(arr[i]);
            if (arrStr[i-begin].length() > max_length) {
                max_length = arrStr[i-begin].length();
            }
        }
        MSDSortR(arrStr, 0, arrStr.length, max_length-1);
        for(int i = begin; i < end; i++) {
            arr[i] = Integer.parseInt(arrStr[i-begin]);
        }
    }

    public static void MSDSort(int[] arr) {
        MSDSort(arr, 0, arr.length);
    }

    public static void MSDSort(BigInteger[] arr, int begin, int end) {
        if( begin < 0 || begin > arr.length || end < 0 || end > arr.length || end < begin) {
            throw new ArrayIndexOutOfBoundsException();
        }
        String[] arrStr = new String[end-begin];
        int max_length = 0;
        for(int i = begin; i < end; i++) {
            arrStr[i-begin] = arr[i].toString();
            if (arrStr[i-begin].length() > max_length) {
                max_length = arrStr[i-begin].length();
            }
        }
        MSDSortR(arrStr, 0, arrStr.length, max_length-1);
        for(int i = begin; i < end; i++) {
            arr[i] = BigInteger.valueOf(Integer.parseInt(arrStr[i-begin]));
        }
    }

    public static void MSDSort(BigInteger[] arr) {
        MSDSort(arr, 0, arr.length);
    }

    public static void CountSort(Integer[] arr, int begin, int end) {
        if( begin < 0 || begin > arr.length || end < 0 || end > arr.length || end < begin) {
            throw new ArrayIndexOutOfBoundsException();
        }
        TreeMap<Integer, Integer> tree = new TreeMap<>(Comparator.comparingInt(I -> I));
        for(int i  = begin; i < end; i++) {
            if(tree.containsKey(arr[i])) {
                tree.put(arr[i], tree.get(arr[i])+1);
            } else {
                tree.put(arr[i], 1);
            }
        }
        int index = begin;
        for (Iterator it = tree.keySet().iterator(); it.hasNext();) {
            Integer key = (Integer) it.next();
            for(int i = 0; i < tree.get(key); i++) {
                arr[index++] = key;
            }
        }
    }

    public static void CountSort(Integer[] arr) {
        CountSort(arr, 0, arr.length);
    }

    public static void CountSort(int[] arr, int begin, int end) {
        Integer[] newArr = new Integer[arr.length];
        for(int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        CountSort(newArr, begin, end);
        for(int i = 0; i < arr.length; i++) {
            arr[i] = newArr[i];
        }
    }

    public static void CountSort(int[] arr) {
        CountSort(arr, 0, arr.length);
    }

    public static void CountSort(BigInteger[] arr, int begin, int end) {
        if( begin < 0 || begin > arr.length || end < 0 || end > arr.length || end < begin) {
            throw new ArrayIndexOutOfBoundsException();
        }
        TreeMap<BigInteger, Integer> tree = new TreeMap<>(new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                return ((BigInteger)o1).compareTo((BigInteger)o2);
            }
        });
        for(int i  = begin; i < end; i++) {
            if(tree.containsKey(arr[i])) {
                tree.put(arr[i], tree.get(arr[i])+1);
            } else {
                tree.put(arr[i], 1);
            }
        }
        int index = begin;
        for (Iterator it = tree.keySet().iterator(); it.hasNext();) {
            BigInteger key = (BigInteger) it.next();
            for(int i = 0; i < tree.get(key); i++) {
                arr[index++] = key;
            }
        }
    }

    public static void CountSort(BigInteger[] arr) {
        CountSort(arr, 0, arr.length);
    }
}
