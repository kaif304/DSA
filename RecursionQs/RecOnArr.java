package RecursionQs;

import java.util.ArrayList;

public class RecOnArr {
    // Array is sorted or not
    public static void main(String[] args) {
        int[] arr = {1, 5,5,10};
//        System.out.println(isSorted(arr,0));
//        System.out.println(find(arr, 0, 5));
//        System.out.println(findIndex(arr, 0, 5));
        System.out.println(findAllIndex(arr,0,5,new ArrayList<>()));
        System.out.println(findAllIndex2(arr,0,5));
    }

    static boolean isSorted(int[] arr, int i) {
        if (i == arr.length - 1) {
            return true;
        }
        return arr[i] < arr[i + 1] && isSorted(arr, i + 1);
    }

    // Search if the element is present or not/find the element
    static boolean find(int[] arr, int i, int target) {
        if (i == arr.length) {
            return false;
        }
        return arr[i] == target || find(arr, i + 1, target);
    }

    static int findIndex(int[] arr, int i, int target) {
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == target) {
            return i;
        } else {
            return findIndex(arr, i + 1, target);
        }
    }
//    static ArrayList<Integer> list = new ArrayList<>();
//    static void findAllIndex(int[] arr, int i, int target) {
//        if (i == arr.length) {
//            return;
//        }
//        if (arr[i] == target) {
//            list.add(i);
//        }
//        findAllIndex(arr, i + 1, target);
//    }
    static ArrayList<Integer> findAllIndex(int[] arr, int i, int target,ArrayList<Integer> list) {
        if (i == arr.length) {
            return list;
        }
        if (arr[i] == target) {
            list.add(i);
        }
        return findAllIndex(arr, i + 1, target,list);
    }
    static ArrayList<Integer> findAllIndex2(int[] arr, int i, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        if (i == arr.length) {
            return list;
        }
        if (arr[i] == target) {
            list.add(i);
        }
        boolean ret = list.addAll(findAllIndex2(arr, i + 1, target));
        System.out.println(ret);
        return list;
    }
}
