package rank.dynamicprogramming;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import javax.xml.transform.sax.SAXSource;
import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Created on 6/9/2017.
 * <p>
 * you need to hit a target -
 * array of n - to meet
 * <p>
 * Rules:
 * assign +1 to every other - than the chosen one
 * <p>
 * except a chosen one - you can give 1, 2 or 5
 * - minimize numbers of operations - the coins given
 * <p>
 * <p>
 * Timeout:
 * <p>
 * <p>
 * 5
 * 110
 * 53 361 188 665 786 898 447 562 272 123 229 629 670 848 994 54 822 46 208 17 449 302 466 832 931 778 156 39 31 777 749 436 138 289 453 276 539 901 839 811 24 420 440 46 269 786 101 443 832 661 460 281 964 278 465 247 408 622 638 440 751 739 876 889 380 330 517 919 583 356 83 959 129 875 5 750 662 106 193 494 120 653 128 84 283 593 683 44 567 321 484 318 412 712 559 792 394 77 711 977 785 146 936 914 22 942 664 36 400 857
 * 82
 * 520 862 10 956 498 956 991 542 523 664 378 194 76 90 753 868 837 830 932 814 616 78 103 882 452 397 899 488 149 108 723 22 323 733 330 821 41 322 715 917 986 93 111 63 535 864 931 372 47 215 539 15 294 642 897 98 391 796 939 540 257 662 562 580 747 893 401 789 215 468 58 553 561 169 616 448 385 900 173 432 115 712
 * 199
 * 761 706 697 212 97 845 151 637 102 165 200 34 912 445 435 53 12 255 111 565 816 632 534 617 18 786 790 802 253 502 602 15 208 651 227 305 848 730 294 303 895 846 337 159 291 125 565 655 380 28 221 549 13 107 166 31 245 308 185 498 810 139 865 370 790 444 27 639 174 321 294 421 168 631 933 811 756 498 467 137 878 40 686 891 499 204 274 744 512 460 242 674 599 108 396 742 552 423 733 79 96 27 852 264 658 785 76 415 635 895 904 514 935 942 757 434 498 32 178 10 844 772 36 795 880 432 537 785 855 270 864 951 649 716 568 308 854 996 75 489 891 331 355 178 273 113 612 771 497 142 133 341 914 521 488 147 953 26 284 160 648 500 463 298 568 31 958 422 379 385 264 622 716 619 800 341 732 764 464 581 258 949 922 173 470 411 672 423 789 956 583 789 808 46 439 376 430 749 151
 * 161
 * 134 415 784 202 34 584 543 119 701 7 700 959 956 975 484 426 738 508 201 527 816 136 668 624 535 108 1 965 857 152 478 344 567 262 546 953 199 90 72 900 449 773 211 758 100 696 536 838 204 738 717 21 874 385 997 761 845 998 78 703 502 557 47 421 819 945 375 370 35 799 622 837 924 834 595 24 882 483 862 438 221 931 811 448 317 809 561 162 159 640 217 662 197 616 435 368 562 162 739 949 962 713 786 238 899 733 263 781 217 477 220 790 409 383 590 726 192 152 240 352 792 458 366 341 74 801 709 988 964 800 938 278 514 76 516 413 810 131 547 379 609 119 169 370 502 112 448 695 264 688 399 408 498 765 749 925 918 458 913 234 611
 * 51
 * 512 125 928 381 890 90 512 789 469 473 908 990 195 763 102 643 458 366 684 857 126 534 974 875 459 892 686 373 127 297 576 991 774 856 372 664 946 237 806 767 62 714 758 258 477 860 253 287 579 289 496
 * <p>
 * Expected Output
 * 10605
 * 8198
 * 18762
 * 16931
 * 5104
 */
public class Equals {

    @Test
    public void t1() {
        compute(new int[]{2, 2, 3, 7});
        assertEquals(Integer.valueOf(2), Integer.valueOf(minSteps));
    }

    @Test
    public void t2() {
        compute(new int[]{520, 862, 10, 956, 498, 956, 991, 542, 523, 664, 378, 194, 76, 90, 753, 868, 837, 830, 932, 814, 616, 78, 103, 882, 452, 397, 899, 488, 149, 108, 723, 22, 323, 733, 330, 821, 41, 322, 715, 917, 986, 93, 111, 63, 535, 864, 931, 372, 47, 215, 539, 15, 294, 642, 897, 98, 391, 796, 939, 540, 257, 662, 562, 580, 747, 893, 401, 789, 215, 468, 58, 553, 561, 169, 616, 448, 385, 900, 173, 432, 115, 712});

        assertEquals(Integer.valueOf(8198), Integer.valueOf(minSteps));
    }

    @Test
    public void t3() {
        Scanner output = new Scanner(this.getClass().getResourceAsStream("equals.output.2.txt"));
        Arrays.stream(withScanner(new Scanner(this.getClass().getResourceAsStream("equals.input.2.txt"))).split("[^\\d]+")).forEach(s -> {
            System.out.println(s + " -> " + output.next());
        });
    }

    static int computationSteps = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(withScanner(sc));
    }

    private static String withScanner(Scanner sc) {
        int n = sc.nextInt();
        StringBuilder sb =new StringBuilder();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int[] target = readArray(sc, m);
            minSteps = Integer.MAX_VALUE;
            compute(target);
            sb.append(minSteps + " ");
        }
        return sb.toString();
    }

    static int minSteps = Integer.MAX_VALUE;
    boolean stop = false;

    // end point - all equal (or threshold)
    // how can you make it not recursive - iterative -
    // every coin is a start -
    // computation has condition end -
    // computation has a state - the targets state and current count
    //
    public static void compute(int[] target) {
        Arrays.sort(target);
        Queue<ComputationStep> queue = new LinkedList<>();
        queue.add(new ComputationStep(queue, target, 1, target[0], target.length-1));
        while (!queue.isEmpty()) {
            //System.out.println(queue.size());
            /*
            computationSteps++;
            if (computationSteps % 100 == 0){
                System.out.println(computationSteps);
            }
            */
            queue.remove().compute();
        }
    }

    static class ComputationStep {
        int[] coins = new int[]{5, 2, 1};
        int[] target;
        Queue<ComputationStep> queue;
        int computationStep;
        int maxIndex;
        int min = 0;

        public ComputationStep(Queue queue, int[] target, int computationStep,int min,int maxIndex) {
            this.queue = queue;
            this.target = target;
            this.computationStep = computationStep;
            this.maxIndex = maxIndex;
            this.min = min;
        }

        public void compute() {
            if (computationStep > minSteps) {
                return;
            }

            //System.out.println(Arrays.toString(target));
            //System.out.println(maxIndex);
            for (int coin : coins) {
                // do leaps - find the minimum - drop by multiples of 5 -  between min and max - and add computation step leasp - increasing by multiple factor
                //int leap = 1; // works for t1
                int leap = (target[maxIndex] - min) / coin; // doest not work at all for the [t1]
                if (leap > 0) {
                    int[] newTarget = Arrays.copyOf(target, target.length);
                    boolean equals=true;
                    min = Integer.MAX_VALUE;
                    int newMaxIndex = 0;
                    for (int colleagueIndex = 0; colleagueIndex < target.length; colleagueIndex++) {
                        if (colleagueIndex != maxIndex) {
                            newTarget[colleagueIndex] += coin * leap;
                        }
                        if (colleagueIndex!= 0 && newTarget[0]!=newTarget[colleagueIndex]){
                            equals=false;
                        }
                        min = Math.min(min, newTarget[colleagueIndex]);
                        if (newTarget[colleagueIndex] > newTarget[newMaxIndex]){
                            newMaxIndex = colleagueIndex;
                        }
                    }
                    //System.out.println(Arrays.toString(newTarget));
                    if (equals) {
                        //System.out.println(Arrays.toString(newTarget));
                        minSteps = Math.min(minSteps, computationStep);
                    } else {
                        queue.add(new ComputationStep(queue, newTarget, computationStep + leap, min, newMaxIndex));
                    }
                    break;
                }
            }
        }
    }

    private static boolean allEqual(int[] target) {
        for (int i = 1; i < target.length; i++) {
            if (target[i] != target[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private static int[] readArray(Scanner sc, int n) {
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }
        return ar;
    }

}
