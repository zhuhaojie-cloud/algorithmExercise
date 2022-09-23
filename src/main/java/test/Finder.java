package test;

public class Finder {
    public static int findKth(int[] a, int n, int K) {
        // write code here
        return QuickSort(a,0,n-1)[K-1];
    }
    public static int[] QuickSort(int[] a, int s, int e){
        if(a.length<1||s<0||e>=a.length||s>e) return null;
        int smallIndex=partition(a,s,e);
        if(smallIndex>s){
            QuickSort(a,s,smallIndex-1);
        }
        if(smallIndex<e){
            QuickSort(a,smallIndex+1,e);
        }
        return a;
    }
    private static int partition(int[] a, int s, int e) {
        int pivot= (int) (s+Math.random()*(e-s+1));
        int smallIndex=s-1;
        swap(a,pivot,e);
        for(int i=s;i<=e;i++){
            if(a[i]<=a[e]){
                smallIndex++;
                if(i>smallIndex)  swap(a,i,smallIndex);
            }
        }
        return smallIndex;
    }
    private static void swap(int[] a, int i, int j) {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
