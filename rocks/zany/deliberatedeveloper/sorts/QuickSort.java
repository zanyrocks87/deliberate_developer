package rocks.zany.deliberatedeveloper.sorts;
import java.util.Arrays;

import rocks.zany.deliberatedeveloper.Util;

class QuickSort{

    public void sort(int[] array, int l, int h ){
        if(l < h){
            int pi=partition(array, l, h);
            sort(array, l, pi-1);
            sort(array, pi+1, h);
        }
    }

    private int partition(int[] array, int l, int h){
        int p = array[h];
        int i = l-1;
        //Note: h is highest index not the size!
        for(int j=l; j < h; j++){
            if(array[j] <= p){
                Util.swap(array,++i,j);
            }
        }
        Util.swap(array, ++i, h);
        return i;
    }

   

    public static void main(String[] args) {
		int[] array = Arrays.copyOf(Util.unsortedArray, Util.unsortedArray.length);

		Util.print(array, "Before Sorting");
        QuickSort quickSort=new QuickSort();
        quickSort.sort(array, 0, array.length-1);
		Util.print(array, "QuickSort");
    }
}
