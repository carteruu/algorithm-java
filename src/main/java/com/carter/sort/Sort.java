package com.carter.sort;

public class Sort {

    /**
     * 冒泡排序
     *
     * @param a
     * @param n
     */
    public void bubbleSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j + 1]) {
                    // 交换
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    // 表示有数据交换
                    flag = true;
                }
            }
            if (!flag) {
                break;  // 没有数据交换，提前退出
            }
        }
    }


    /**
     * 插入排序
     *
     * @param a
     * @param n
     */
    public void insertionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    //数据移动
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            // 插入数据
            a[j + 1] = value;
        }
    }

    /**
     * 选择排序
     *
     * @param a
     * @param n
     */
    public void selectionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = a[i];
            a[i] = a[minIdx];
            a[minIdx] = temp;
        }
    }

    /**
     * 归并排序
     *
     * @param a
     * @param l
     * @param r
     */
    public void mergeSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(a, l, mid);
        mergeSort(a, mid + 1, r);
        merge(a, l, mid, r);
    }

    private void merge(int[] a, int l, int mid, int r) {
        int i = l;
        int j = mid + 1;
        int idx = 0;
        int[] temp = new int[r - l + 1];
        while (i <= mid && j <= r) {
            if (a[i] <= a[j]) {
                temp[idx++] = a[i++];
            } else {
                temp[idx++] = a[j++];
            }
        }
        while (i <= mid) {
            temp[idx++] = a[i++];
        }
        while (j <= r) {
            temp[idx++] = a[j++];
        }
        System.arraycopy(temp, 0, a, l, r - l + 1);
    }

    /**
     * 快速排序
     *
     * @param a
     * @param l
     * @param r
     */
    public void quicksort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int q = partition(a, l, r);
        quicksort(a, l, q - 1);
        quicksort(a, q + 1, r);
    }

    /**
     * 获取分区点
     *
     * @param a
     * @param l
     * @param r
     * @return
     */
    private int partition(int[] a, int l, int r) {
        int pivot = a[r];
        int i = l;
        for (int j = l; j < r; j++) {
            if (a[j] < pivot) {
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
                i++;
            }
        }
        a[r] = a[i];
        a[i] = pivot;
        return i;
    }


    /**
     * 计数排序
     *
     * @param a
     * @param n
     */
    public void countingSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        // 查找数组中数据的范围
        int max = a[0];
        for (int i = 1; i < n; ++i) {
            if (max < a[i]) {
                max = a[i];
            }
        }

        // 申请一个计数数组c，下标大小[0,max]
        int[] c = new int[max + 1];
        for (int i = 0; i <= max; ++i) {
            c[i] = 0;
        }

        // 计算每个元素的个数，放入c中
        for (int i = 0; i < n; ++i) {
            c[a[i]]++;
        }

        // 依次累加
        for (int i = 1; i <= max; ++i) {
            c[i] = c[i - 1] + c[i];
        }

        // 临时数组r，存储排序之后的结果
        int[] r = new int[n];
        // 计算排序的关键步骤，有点难理解
        for (int i = n - 1; i >= 0; --i) {
            //a[i]是原值,c是前缀和,储存有多少个元素比a[i]小,从而确定a[i]的下标
            int index = c[a[i]] - 1;
            r[index] = a[i];
            c[a[i]]--;
        }

        // 将结果拷贝给a数组
        System.arraycopy(r, 0, a, 0, n);
    }
}