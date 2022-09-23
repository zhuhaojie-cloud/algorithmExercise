package test.search;

public class BinSearch {

    /***
     * 二叉搜索
     * 非递归实现：
     * @param array
     * @param key
     * @return
     */
    public static int binSearch(int[] array, int key) {
        int start = 0;
        int mid;
        int end = array.length - 1;
        while (start <= end) {
            mid = (end - start) / 2 + start;
            if (key < array[mid]) {
                end = mid - 1;
            } else if (key > array[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 递归实现
     * @param array
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static int binSearch1(int[] array, int key, int start, int end) {
        int mid = (end - start) / 2 + start;
        if (key == array[mid]) {
            return mid;
        } else if (start >= end) {
            return -1;
        } else if (key > array[mid]) {
            return binSearch1(array, key, mid +1 , end);
        } else if (key < array[mid]) {
            return binSearch1(array, key, start, mid - 1);
        }
        return -1;
    }
}
