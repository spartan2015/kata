package y2020;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class AlmostSorted {

    static void almostSorted(int[] arr) {

        System.out.println(almostSortedStr(arr));

    }

    @Test
    public void t1(){
        // fundamental flaw in my understanding - swapping can be any 2 elements...in any position - in this case found first swap - could go on on a streak...or not
        // we can still do a moving swap - 11 - move the 894 -> another case swap 12 in position

        assertEquals("no",almostSortedStr(new int[]{3,1,2}));

        assertEquals("yes\nreverse 3 6",almostSortedStr(new int[]{8,12,16,15,14,13}));

        assertEquals("no",almostSortedStr(new int[]{2,4,6,5,8,10,9}));




        assertEquals("yes\nswap 1 4",almostSortedStr(new int[]{4,2,3,1}));

            assertEquals("yes\nswap 12 95",almostSortedStr(new int[]{
                    4104 ,8529 ,49984 ,54956 ,63034 ,82534 ,84473 ,86411 ,92941 ,95929 ,
                    108_831 ,
                    894_947
                    ,125_082 ,
                    137_123
                    ,137_276 ,142534 ,149840 ,154703 ,174744 ,180537 ,207563 ,221088 ,223069 ,231982 ,249517 ,252211 ,255192 ,260283 ,261543 ,262406 ,270616 ,274600 ,274709 ,283838 ,289532 ,295589 ,310856 ,314991 ,322201 ,339198 ,343271 ,383392 ,385869 ,389367 ,403468 ,441925 ,444543 ,454300 ,455366 ,469896 ,478627 ,479055 ,484516 ,499114 ,512738 ,543943 ,552836 ,560153 ,578730 ,579688 ,591631 ,594436 ,606033 ,613146 ,621500 ,627475 ,631582 ,643754 ,658309 ,666435 ,667186 ,671190 ,674741 ,685292 ,702340 ,705383 ,722375 ,722776 ,726812 ,748441 ,790023 ,795574 ,797416 ,813164 ,813248 ,827778 ,839998 ,843708 ,851728 ,857147 ,860454 ,861956 ,864994 ,868755 ,116375 ,911042 ,912634 ,914500 ,920825 ,979477
        }));
        assertEquals("no",almostSortedStr(new int[]{4,6,8,1}));
        assertEquals("yes\nswap 3 4",almostSortedStr(new int[]{4,6,8,7}));
        assertEquals("no",almostSortedStr(new int[]{8,12,16,11}));

        assertEquals("no",almostSortedStr(new int[]{8,12,16,15,14,13,7}));
        assertEquals("no",almostSortedStr(new int[]{8,12,16,15,14,13,11}));
        assertEquals("no",almostSortedStr(new int[]{8,12,16,15,14,13,10}));
        assertEquals("no",almostSortedStr(new int[]{8,12,16,15,14,13,9}));
        assertEquals("no",almostSortedStr(new int[]{8,12,16,15,14,13,7}));

        // the must be smaller than all precedents
        assertEquals("no",almostSortedStr(new int[]{3,4,2,1}));

        assertEquals("no",almostSortedStr(new int[]{3,4,2,1,0}));

        assertEquals("yes",almostSortedStr(new int[]{1}));
        assertEquals("yes",almostSortedStr(new int[]{1,2}));
        assertEquals("yes",almostSortedStr(new int[]{1,2,3,6,8,10,1000}));
        assertEquals("yes\nswap 4 5",almostSortedStr(new int[]{1,2,3,6,5}));
        assertEquals("yes\nswap 4 5",almostSortedStr(new int[]{1,2,3,6,5,7,8}));
        assertEquals("no",almostSortedStr(new int[]{1,2,3,6,5,7,8,1}));

        assertEquals("no",almostSortedStr(new int[]{2,4,6,5,1,7}));
        assertEquals("yes\nswap 3 4",almostSortedStr(new int[]{2,4,6,5,7}));
        assertEquals("no",almostSortedStr(new int[]{2,4,6,5,8,10,12, 11}));
        assertEquals("yes\nswap 3 4",almostSortedStr(new int[]{2,3,5,4}));
        assertEquals("yes\nswap 1 2",almostSortedStr(new int[]{4,2}));



        assertEquals("no",almostSortedStr(new int[]{9,3,6}));

        assertEquals("yes",almostSortedStr(new int[]{1}));
        assertEquals("yes\nreverse 2 5",almostSortedStr(new int[]{1,5,4,3,2,6}));

        assertEquals("yes\nreverse 1 4",almostSortedStr(new int[]{5,4,3,2,6}));
        assertEquals("yes\nreverse 1 4",almostSortedStr(new int[]{5,4,3,2,7}));
        assertEquals("yes\nreverse 1 5",almostSortedStr(new int[]{7,5,4,3,2}));
    }

    @Test
    public void t2(){
        assertEquals(0, rankReverse(new int[]{3,2,1}, 0,2,3));
        assertEquals(2, rankReverse(new int[]{3,2,1}, 0,2,1));
        assertEquals(1, rankReverse(new int[]{3,2,1}, 0,2,2));
    }

    public int rankReverse(int[] arr, int start, int end, int key){
        while (start<=end){
            int mid = start + (end - start)/2;
            if (arr[mid] == key){
                return mid;
            }else if (key < arr[mid]){
                start = mid+1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }

    private static String almostSortedStr(int[] arr) {
        boolean shouldSwap = false;
        int[] swapIndices = new int[]{0,0};
        boolean streak = false; // so streak is when we have more than 2 consecutive are lower than the previous
        int countLower = 1;
        boolean swapEnded = false;
        for (int i = 1; i < arr.length; i++){
            // rethinking the alog ... with the new info in mind -
            if (shouldSwap && !swapEnded){
                    if (smallerThan(arr[i], arr, swapIndices[0], i-1)) {
                        countLower++;
                        if (countLower > 2){
                            streak = true;
                        }
                        // not recognizing streak when 2 consecutives must be swapped  4 2 3 1 is not but 4 3 2 5 is swap also 4 3 2 1 5 - now is streak
                        if (swapIndices[0] > 0 && arr[swapIndices[0]-1] > arr[i]){
                            return "no";
                        }else { // SO QUESTION when is streak and when is swap -  when it is trully a streak -
                            swapIndices[1] = i; // but right now we need t ocheck all previous rank reverse between indices
                        }
                    } else {
                        countLower = 0;
                        if (arr[i] > arr[swapIndices[0]]) {
                            swapEnded = true;
                        } else {
                            if (arr[swapIndices[0]]< arr[i] || (arr[i] > arr[i-1] && i == arr.length-1)) { // 4,2,3,1 without failing 3 1 2

                                return "no";
                            }else{ // at this branch in 3 1 2 swap 3 with 2 is not allowed because
                                swapIndices[1]=i;
                            }
                        }
                    }
            }else{
                if (arr[i] < arr[i-1]){

                    if (swapEnded || (i-2 >= 0 && arr[i] < arr[i-2])){
                        return "no";
                    }else {
                        shouldSwap = true;
                        swapIndices = new int[]{i - 1, i};
                    }
                }
            }
        }

        if (shouldSwap ){
            if (!streak) {
                return "yes\nswap " + (swapIndices[0]+1) + " " + (swapIndices[1]+1);
            }else{
                return "yes\nreverse " + (swapIndices[0]+1) + " " + (swapIndices[1]+1);
            }
        }
        return "yes";
    }

    private static boolean smallerThan(int key, int[] arr, int start, int end) {
        for (int i = start; i <= end; i++){
            if (key > arr[i]){
                return false;
            }
        }
        return true;
    }


}
