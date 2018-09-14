package edu.bsu.cs222;

public class QuickSort {
    private Integer[] arr;


    public QuickSort(Integer[] arr){
        this.arr = arr;

    }

    public  Integer[] quickSort(Integer[] arr,int low, int high) {
        if(low<high){
            int q = PARTITION(arr,low,high);
            quickSort(arr,low,q-1);
            quickSort(arr,q+1,high);
        }else {
            return arr;
        }
        this.arr = arr;
        return arr;
    }
    public static Integer PARTITION(Integer[] arr, int low, int high){
        int x = arr[high];
        int i = low-1;
        for(int j=low;j<high-1;j++){
            if(arr[j] <= x){
                i+=1;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }int temp2 = arr[high];
        arr[high]=arr[i+1];
        arr[i+1] = temp2;
        return i+1;
    }

    public String toString(){
        String result ="";
        for(int i =0;i<arr.length;i++){
            result += arr[i];
        }
        return result;
    }
}

