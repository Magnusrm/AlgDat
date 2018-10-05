package Øving3;

import java.util.Date;
import java.util.Random;

public class SortTest {
    private static Random r = new Random();


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    private static int splitt(int[] t, int v, int h) {
        int iv, ih;
        int m = median3sort(t, v, h);
        int dv = t[m];
        swap(t, m, h - 1);
        for (iv = v, ih = h - 1; ; ) {
            while (t[++iv] < dv) ;
            while (t[--ih] > dv) ;
            if (iv >= ih) break;
            swap(t, iv, ih);
        }
        swap(t, iv, h - 1);
        return iv;
    }

    private static int median3sort(int[] t, int v, int h) {
        int m = (v + h) / 2;
        if (t[v] > t[m]) swap(t, v, m);
        if (t[m] > t[v]) {
            swap(t, m, h);
            if (t[v] > t[m]) swap(t, v, m);
        }
        return m;
    }
/*
    private static void quickSort(int[] t, int v, int h) {
        if (h - v > 2) {
            int delePos = splitt(t, v, h);
            quickSort(t, v, delePos - 1);
            quickSort(t, delePos + 1, h);
        } else {
            median3sort(t, v, h);
        }
    }
*/
    private static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)

        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }


    private static void quickSort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    private static void dualPivotQuickSort(int[] arr, int lowIndex, int highIndex) {
        if(highIndex <= lowIndex) {
            return;
        }
        if(arr[lowIndex] > arr[highIndex]) {
            swap(arr, lowIndex, highIndex);
        }
        int pivot1 = arr[lowIndex];
        int pivot2 = arr[highIndex];

        int lt = lowIndex + 1;
        int gt = highIndex - 1;
        int i = lowIndex + 1;

        while(i <= gt) {
            if(arr[i] < pivot1) {
                swap(arr, i, lt);
                lt++;
                i++;
            } else if(arr[i] > pivot2) {
                swap(arr, i, gt);
                gt--;
            } else {
                i++;
            }
        }
        swap(arr, lowIndex, lt-1);
        swap(arr, gt+1, highIndex);

        lt--;
        gt++;

        dualPivotQuickSort(arr, lowIndex, lt-1);
        dualPivotQuickSort(arr, lt+1, gt-1);
        dualPivotQuickSort(arr, gt+1, highIndex);

    }

    private static int[] randomTable(int length){
        int[] t = new int[length];
        for (int i = 0; i < length; i++){
            t[i] = r.nextInt(1000);
        }
        return t;
    }

    private static int[] duplicateValueTable(int length){
        boolean a = false;
        int[] t = new int[length];
        for (int i = 0; i < length; i++){
            if(a){
                t[i] = 10;
                a = false;
            } else {
                t[i] = i;
                a = true;
            }
        }
        return t;
    }

    private static int[] incrementingTable(int length){
        int[] t = new int[length];
        for (int i = 0; i < length; i++){
            t[i] = i;
        }
        return t;
    }

    private static boolean sortOk(int[] t){
        for (int i = 0; i < t.length -2; i++){
            if (t[i + 1] < t[i]){
                System.out.println("feil på index: " + i);
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int size = 10000;

        int[] t1 = incrementingTable(size);
        int[] t2 = duplicateValueTable(size);
        int[] t3 = randomTable(size);

        int rounds;
        double time;
        Date stop;
        double r;

        Date start = new Date();

        rounds = 0;
        do {
            quickSort(t1, 0, size -1);
            stop = new Date();
            ++rounds;
        } while (stop.getTime()-start.getTime() < 0);
        time = (double)
                (stop.getTime()-start.getTime()) / rounds;
        System.out.println("Sortert fra før: Millisekund pr. runde: \n     " + time);
        if (sortOk(t1)){
            System.out.println("Sortering ok." + "\n");
        } else {
            System.out.println("Sortering ikke ok." + "\n");
        }
/*
        start = new Date();
        rounds = 0;
        do {
        quickSort(t2, 0, size -1);
        stop = new Date();
            ++rounds;
        } while (stop.getTime()-start.getTime() < 1000);
        time = (double)
                (stop.getTime()-start.getTime())  / rounds ;
        System.out.println("Sortert fra før: Millisekund pr. runde: \n     " + time);
        if (sortOk(t1)){
            System.out.println("Sortering ok." + "\n");
        } else {
            System.out.println("Sortering ikke ok." + "\n");
        }

        start = new Date();
        rounds = 0;
        do {
            quickSort(t3, 0, size -1);
            stop = new Date();
            ++rounds;
        } while (stop.getTime()-start.getTime() < 1000);
        time = (double)
                (stop.getTime()-start.getTime()) / rounds;
        System.out.println("Sortert fra før: Millisekund pr. runde: \n     " + time);
        if (sortOk(t1)){
            System.out.println("Sortering ok." + "\n");
        } else {
            System.out.println("Sortering ikke ok." + "\n");
        }
        */
    }
}

/* 20 000
dual pivot
    1: 84.41666
    2: 71.13333
    3: 72.26666

quick
    1:
    2:
    3:
 */