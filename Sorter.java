/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_7;

/**
 *
 * @author dhruv
 */
public class Sorter<T extends Comparable<T>> {

    T[] data;

    public Sorter(T[] d) {
        data = d;
    }

    public T[] mergeSort() {
        mergeSort(0, data.length - 1);

        return data;
    }

    public void mergeSort(int start, int end) {
        // this.data or just data is our "arr"
        // actually perform mergeSort

        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);
            merge(start, mid, end);
        }
    }

    public void merge(int start, int mid, int end) {
        // this.data or just data is our "arr"

        // if you want to create an array of T
        // that is T[]
        // do this -
        // T[] newArray = (T[]) new Comparable[sizeOfArray];
        
        int left = mid - start + 1;
        int right = end - mid;
        
        T leftarray[] = (T[]) new Comparable[left];
        T rightarray[] = (T[]) new Comparable[right];

        for (int i = 0; i < left; i++) {
            leftarray[i] = data[start + i];
        }

        for (int i = 0; i < right; i++) {
            rightarray[i] = data[mid + i + 1];
        }
        int i = 0, j = 0, k = start;
        while (i < left && j < right) {
            if (leftarray[i].compareTo(rightarray[j]) < 0) {
                data[k] = leftarray[i];
                i++;
            } else {
                data[k] = rightarray[j];
                j++;
            }
            k++;
        }
        while (i < left) {
            data[k] = leftarray[i];
            i++;
            k++;
        }
        while (j < right) {
            data[k] = rightarray[j];
            k++;
            j++;
        }
    }

    public T[] quickSort() {
        quickSort(0, data.length - 1);

        return data;
    }

    public void quickSort(int start, int end) {
        // actually perform quickSort
        if (start < end) {
            int location = partition(start, end);
            quickSort(start, location - 1);
            quickSort(location + 1, end);
        }
    }

    public int partition(int start, int end) {
        // perform the partitioning algorithm and return the pivot
        T pivot = data[start];
        int left = start + 1;
        int right = end;

        while (left <= right) {
            while (left <= right && data[left].compareTo(pivot) <= 0) {
                left++;
            }
            while (left <= right && data[right].compareTo(pivot) > 0) {
                right--;
            }

            if (left < right) {
                T temp = data[left];
                data[left] = data[right];
                data[right] = temp;
            }
        }
        T temp = data[right];
        data[right] = data[start];
        data[start] = temp;
        return right;
    }
}
