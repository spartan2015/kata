package cross;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Purpose of Optimize is
 */
public class Optimize {

    @Test
    public void t1(){
        //assertEquals(5, new Optimize().solution(new int[]{4,6,2,2,6,6,4}));
        int[] s = new int[75000+1];
        for(int i =0; i< 75001; i++){
            s[i]=i;
        }
        assertEquals(75000, new Optimize().solution(s));
    }
    // problem
    // result is max of not equals - 2 element not the same - j-i  - max distance between 2 elements not the same

    // so what would be more efficient ? - removing duplicates - keep separate array with distances - having only the unique numbers... that would be more efficient
    // there is no need for duplicates... which makes me thinkg of bucket sort - with second bucket for actual distance
    // would that work - yes - bucket sort sort of ... unique numbers only -
    // but given again - max distance between any 2 distinct numbers
    // in a single walk..
    // eliminating duplicates would be step 1 -
    // can we do better ?  what about the case with unique numbers ? can we still do better there ?
    // unique afters - greatest distance sort - already sorting it...find greatest - farthest index diffrent thant current

    // starting at 0 - value 0 - > go from end - values 75 000 - value is diff - simply return

    // these 2 are proposed - eliminate duplication - adding simply the greatest distance ... for 2 - greatest is 3 for 6 greatest index is 5
    // what are you thinking about ... max no...
    // case 1 random - we don't know which distance is greater - dupes removal is one thing
    // was thinking about repeating dupes - like 6 - could just have single 6 with max index -
    // so unique no array... 4 6 2  ( what about the last 4 - hence the min max index - proposal
    // go through array once.. gather unique and min max index
    // the actual search N - > max of min max for different nos - 4  6 2 - start with first - 4 min index - all the rest maxIndex
    // what about min max heaps - holding at all time return min - max... yes but for multiple no ? do we actually need that ?
    // what about bucket sort... what do yuo think we would lose ? - 4 6 2  - still 2 for loops - so what is efficient - not duplicates
    // what else can we do ?
    // second opt - go from back of queue...start from 6th... since we have no dupes - would be 1 or 2 call...either 4 or 6 - that would be faster
    /**
     * was considering 2 2 2 2 2 4 - 2 - maxIndex 4  and - 4 max index 5
     *
     * we need min index also - min index - maxIndex for different
     */
// did all tests - 4 of them - this one was most prob - 80% - 90% - best - task 3 seems failues - 11% and task 4 - 25% success
    // so this is 25% success
    int solution(int[] A) {

        int N = A.length;
        int minIndexValue[] = new int[N];
        int maxIndexValue[] = new int[N];
        int minIndex = 0;
        int maxIndex = 0;
        int noDupes[] = new int[N];

        int noDupesIndex = 0;

        int k = 1;
        for (; k < N; k++){
            if (A[k] != A[k-1]){

                noDupes[noDupesIndex] = A[k-1];
                minIndexValue[noDupesIndex] = minIndex;
                maxIndexValue[noDupesIndex] = k -1;

                minIndex = k;
                noDupesIndex++;
            }

        }

        noDupes[noDupesIndex] = A[k-1];
        minIndexValue[noDupesIndex] = minIndex;
        maxIndexValue[noDupesIndex] = k-1;

        noDupesIndex++;


        int result = 0;
        for (int i = 0; i < noDupesIndex; i++)
            for (int j = noDupesIndex-1; j > i; j--)
                if (noDupes[i] != noDupes[j]) {
                    result = Math.max(result, maxIndexValue[j] - i);
                    break;
                }

        return result;
    }

}
