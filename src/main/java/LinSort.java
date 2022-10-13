import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class LinSort {

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

    public static void LSDSort(Integer[] arr, int begin, int end) throws ArrayIndexOutOfBoundsException {
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
}
