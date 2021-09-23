package y2020;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * /challenges/beautiful-pairs/problem
 */
public class BeautifulPairs {

    static int beautifulPairs(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int count = 0;


            int aIndex = 0;
            int bIndex = 0;

            boolean countOnce = false;
            for(int i = aIndex ; aIndex < A.length && bIndex < B.length ; ){
                if (A[aIndex] == B[bIndex]){
                    aIndex++;
                    bIndex++;
                    count++;
                }else if (B[bIndex] < A[aIndex]){
                    bIndex++;
                }else{
                    aIndex++;
                }
            }
        return count < A.length ? count+1 : count -1 ;
    }

    static int rank(int[] a, int k){
        int lo = 0;
        int hi = a.length-1;
        while(hi >= lo){
            int mid = (lo + hi) / 2;
            if (k < a[mid]) hi = mid-1;
            else if  ( k > a[mid]) lo = mid+1;
            else {
                while(mid > 0 && a[mid-1] == k) mid--;
                return mid;
            }
        }
        return -1;
    }

    @Test
    public void t(){
        assertEquals(4,
        beautifulPairs(
                Arrays.stream("1 2 3 4".split(" ")).mapToInt(Integer::valueOf).toArray(),
                Arrays.stream("1 2 3 3".split(" ")).mapToInt(Integer::valueOf).toArray()
        ));
    }

    @Test
    public void t2(){
        assertEquals(6,
        beautifulPairs(
                Arrays.stream("3 5 7 11 5 8".split(" ")).mapToInt(Integer::valueOf).toArray(),
                Arrays.stream("5 7 11 10 5 8".split(" ")).mapToInt(Integer::valueOf).toArray()
        ));
    }

    @Test
    public void t3(){
        assertEquals(203,
                beautifulPairs(
                        Arrays.stream("75 159 824 977 856 195 276 841 506 173 533 248 36 294 978 37 375 483 271 265 249 18 258 312 16 887 325 757 654 121 458 232 118 452 279 157 418 182 645 498 342 779 16 417 551 778 865 763 991 619 51 186 406 526 163 973 592 820 942 520 274 618 196 516 787 966 561 344 300 596 316 602 887 603 50 359 955 116 694 82 28 5 33 611 367 928 238 687 297 729 388 88 723 911 716 309 513 172 609 657 692 41 285 244 533 796 539 207 170 203 714 636 833 388 243 135 60 485 339 189 960 838 251 368 171 563 108 895 166 458 719 735 506 25 192 500 798 483 499 90 8 295 119 965 528 671 363 885 265 196 161 800 351 178 29 431 460 338 10 408 410 647 396 131 941 375 89 955 474 550 190 345 444 247 118 151 287 194 828 982 708 625 518 559 309 923 939 728 933 744 145 621 624 906 220 163 994 761 507 626 708 26 789 541 282 677 194 789 482 672 786 946 348 524 474 362 236 407 232 195 755 794 338 879 863 641 852 671 376 62 75 914 912 136 196 93 806 492 541 365 353 498 832 387 540 781 871 535 903 246 929 573 999 407 179 281 709 702 943 893 346 580 958 736 813 919 403 485 610 133 573 746 71 419 971 688 154 590 531 638 671 212 63 499 52 852 766 804 235 337 227 864 892 135 994 494 375 74 412 865 763 555 520 754 477 65 127 42 929 663 27 673 809 400 203 739 896 793 521 800 12 574 68 997 151 8 168 262 211 945 849 867 499 117 801 388 15 841 681 18 943 127 80 418 102 857 579 95 958 415 106 188 482 127 174 241 586 81 980 885 42 448 912 411 794 355 410 231 447 469 231 461 316 839 914 187 646 751 811 392 42 305 84 637 644 916 259 373 469 391 296 311 162 467 711 647 93 971 383 831 15 382 655 27 727 634 421 509 778 791 10 582 861 961 617 790 959 998 752 843 989 354 696 927 30 784 660 702 208 66 544 784 383 63 5 558 490 298 842 660 97 151 327 961 326 232 725 10 831 179 690 314 826 682 569 606 806 80 377 55 466 580 535 89 808 926 467 24 268 146 486 53 427 771 837 594 305 994 380 779 389 750 238 363 903 29 423 372 922 382 652 417 448 403 156 687 153 155 675 593 177 636 794 325 881 22 132 912 826 819 952 948 140 991 652 173 528 554 459 382 412 256 776 153 533 522 460 715 266 132 488 160 757 331 999 876 820 374 468 172 509 364 70 147 341 540 328 479 165 656 724 389 47 731 838 585 12 103 839 874 340 934 361 571 769 705 707 214 698 968 761 303 771 124 489 533 407 475 144 505 975 247 731 630 849 556".split(" ")).mapToInt(Integer::valueOf).toArray(),
                        Arrays.stream("238 734 971 126 66 430 463 519 429 268 157 636 819 752 244 332 725 287 845 135 764 96 376 611 444 464 759 785 977 646 768 955 71 513 64 396 547 450 824 662 632 673 826 921 20 351 98 675 235 892 119 317 824 215 706 673 340 110 391 562 824 64 918 612 448 374 805 421 797 352 139 316 582 598 433 795 336 487 64 437 618 341 921 273 438 534 800 401 698 667 894 580 896 541 611 767 894 311 314 971 413 358 486 122 144 632 953 184 63 489 372 681 896 699 886 280 919 636 140 630 124 883 440 150 289 913 107 710 182 22 453 130 273 965 164 761 891 640 617 592 729 374 643 890 323 702 105 697 611 386 374 794 129 583 744 960 876 427 632 621 616 670 615 51 434 108 814 59 714 349 428 315 454 173 708 663 503 600 611 413 306 403 771 589 102 717 232 962 261 756 196 630 712 177 645 690 523 927 533 39 798 980 914 948 232 219 122 138 774 655 63 59 868 750 669 512 656 237 433 643 876 283 526 946 275 970 619 490 815 145 426 264 623 967 302 93 753 429 440 883 419 433 684 778 737 451 48 631 630 953 725 486 324 928 951 187 905 4 188 275 585 275 670 629 352 832 798 92 356 990 437 712 582 486 727 973 923 529 379 919 151 945 77 586 898 991 646 453 583 680 452 110 657 164 961 450 464 429 762 260 287 169 654 19 353 227 554 350 282 154 378 196 445 542 583 864 924 365 262 894 585 26 914 440 883 90 895 359 347 757 622 285 837 501 900 436 632 148 319 541 165 895 414 284 783 131 721 215 715 864 98 89 374 525 27 963 369 162 617 733 82 128 617 308 902 990 861 53 812 815 877 735 266 997 265 908 81 5 732 532 533 824 788 657 560 769 431 190 532 922 473 394 659 113 774 522 526 794 608 586 907 450 532 730 58 669 810 46 390 438 790 795 900 821 292 431 15 514 660 866 656 82 51 730 110 503 825 866 353 775 434 721 135 886 694 792 813 435 943 169 627 360 165 895 966 950 704 783 313 343 349 591 648 616 393 752 834 338 736 379 510 470 325 134 678 35 245 536 339 525 454 145 239 647 208 425 188 302 830 792 385 310 832 486 378 875 683 291 179 939 837 386 981 163 234 455 650 614 864 582 530 806 535 843 857 976 117 567 654 165 147 554 742 617 182 815 599 875 425 896 934 415 841 230 976 1000 341 962 744 686 794 676 711 97 410 866 145 544 253 66 288 519 975 701 733 601 32 195 162 869 588 519 320 252 220 484 530 682 878 119 51 98 712 400 248 997 895 421 872 695 428 736 974 199 356 539 470 417 784 632 236 451 435 822 694 247".split(" ")).mapToInt(Integer::valueOf).toArray()
                ));
    }

    @Test
    public void t4(){
        assertEquals(999,
                beautifulPairs(
                        Arrays.stream("354 616 541 886 402 696 998 271 60 771 54 743 446 865 74 190 479 328 570 972 953 99 124 252 282 551 941 158 818 141 875 103 9 553 373 486 919 737 523 161 611 904 770 666 383 385 112 498 830 861 379 322 391 197 533 203 687 14 870 562 708 835 466 489 121 525 643 12 504 238 293 816 911 777 331 392 857 461 781 714 509 562 598 493 47 487 672 363 177 985 733 9 214 109 723 810 916 590 395 868 850 692 230 254 139 394 194 785 573 916 620 589 76 75 358 740 366 682 662 12 892 524 500 785 368 193 415 22 705 974 688 847 487 536 129 385 880 42 18 10 139 415 256 570 835 832 168 340 453 279 418 400 784 618 41 117 81 155 892 282 745 985 498 865 251 558 526 45 964 739 494 425 973 507 507 191 856 160 936 270 593 881 842 486 302 540 378 455 919 1 517 149 103 51 181 50 778 918 189 608 465 22 802 895 269 198 654 636 22 836 591 830 49 14 588 49 751 30 313 478 286 967 506 157 578 534 834 307 672 189 780 45 9 43 741 704 300 873 585 997 854 658 934 516 103 232 77 641 414 35 851 201 353 290 860 31 291 716 556 759 165 534 908 410 825 523 168 718 703 745 584 784 831 834 16 629 112 690 30 901 405 257 207 712 985 865 92 202 829 802 932 325 959 212 463 659 521 668 891 471 189 765 549 472 376 626 103 598 733 878 93 254 63 349 509 223 212 749 593 502 13 465 458 325 68 396 321 837 186 979 268 821 384 487 839 616 432 258 317 25 406 305 765 509 313 272 309 674 356 395 206 699 738 554 270 964 674 424 651 476 886 867 257 217 344 544 16 473 804 55 903 67 837 848 187 506 672 517 936 833 98 697 334 100 133 863 593 533 120 647 415 24 959 227 390 291 286 217 514 400 635 900 56 509 977 852 383 215 876 847 148 719 532 913 669 984 565 53 863 997 112 240 978 605 24 948 976 861 422 228 630 650 204 750 611 795 696 263 644 445 338 516 842 325 718 736 696 419 762 58 239 402 282 315 104 794 47 627 915 476 663 107 458 469 630 571 7 232 468 14 954 465 38 319 99 726 638 706 736 515 410 104 319 944 870 966 24 374 385 71 870 337 845 193 741 106 425 868 428 871 366 196 527 138 790 745 194 310 273 916 748 35 912 77 708 569 313 894 990 696 487 977 4 223 766 246 746 967 989 214 457 544 677 365 727 543 466 308 962 997 425 793 713 732 521 329 964 66 631 476 954 624 57 691 271 103 954 743 652 41 692 164 252 802 389 739 121 374 48 547 432 421 898 986 2 110 102 509 223 61 986 515 374 937 432 400 115 410 631 800 864 940 486 851 224 469 817 927 228 710 94 153 749 109 247 819 561 396 297 265 23 491 293 520 685 792 174 928 61 256 211 666 983 82 8 800 148 432 558 980 655 45 338 322 556 306 16 733 322 881 709 902 612 513 694 116 222 247 311 7 837 668 11 966 115 637 224 581 138 141 34 667 414 372 446 500 191 556 257 643 634 20 233 865 469 291 468 226 325 708 624 156 385 298 807 84 1000 361 689 735 249 879 85 700 115 396 448 46 403 556 990 937 980 587 615 65 458 959 451 738 663 561 80 797 561 397 9 188 259 157 929 342 116 2 465 930 233 979 677 112 99 150 817 139 127 866 449 920 838 21 797 647 499 676 281 938 297 103 543 883 730 58 116 611 133 641 509 600 544 637 805 412 60 749 947 746 266 337 388 923 85 675 384 485 537 436 434 572 688 949 18 397 119 192 437 562 147 266 714 164 415 243 583 47 340 365 426 27 704 142 654 843 594 649 334 59 190 466 579 387 382 205 69 926 720 806 633 917 748 576 980 252 776 39 882 945 452 408 225 109 706 511 768 8 876 2 259 875 137 784 530 768 942 410 42 303 53 197 961 528 989 427 512 862 958 437 911 345 102 580 263 298 151 859 968 923 695 49 254 516 354 548 431 128 365 607 752 144 131 912 569 870 863 484 315 284 430 791 142 70 859 757 641 181 64 44 813 384 186 615 499 508 810 960 122 207 779 381 962 671 557 286 338 969 725 359 481 770 625 1 962 207 319 982 775 428 636 282 710 925 693 652 931 681 625 540 315 56 581 894 371 766 636 88 924 885 596 583 724 561 578 566 761 856 883 531 921 924 308 12 308 472 634 446 437 306 485 42 303 74 777 72 362 990 923 135 347 244 945 323 19 174 782 821 649 25 886 192 817 618 232 974 139 113 726 7 559 851 507 556".split(" ")).mapToInt(Integer::valueOf).toArray(),
                        Arrays.stream("556 507 851 559 7 726 113 139 974 232 618 817 192 886 25 649 821 782 174 19 323 945 244 347 135 923 990 362 72 777 74 303 42 485 306 437 446 634 472 308 12 308 924 921 531 883 856 761 566 578 561 724 583 596 885 924 88 636 766 371 894 581 56 315 540 625 681 931 652 693 925 710 282 636 428 775 982 319 207 962 1 625 770 481 359 725 969 338 286 557 671 962 381 779 207 122 960 810 508 499 615 186 384 813 44 64 181 641 757 859 70 142 791 430 284 315 484 863 870 569 912 131 144 752 607 365 128 431 548 354 516 254 49 695 923 968 859 151 298 263 580 102 345 911 437 958 862 512 427 989 528 961 197 53 303 42 410 942 768 530 784 137 875 259 2 876 8 768 511 706 109 225 408 452 945 882 39 776 252 980 576 748 917 633 806 720 926 69 205 382 387 579 466 190 59 334 649 594 843 654 142 704 27 426 365 340 47 583 243 415 164 714 266 147 562 437 192 119 397 18 949 688 572 434 436 537 485 384 675 85 923 388 337 266 746 947 749 60 412 805 637 544 600 509 641 133 611 116 58 730 883 543 103 297 938 281 676 499 647 797 21 838 920 449 866 127 139 817 150 99 112 677 979 233 930 465 2 116 342 929 157 259 188 9 397 561 797 80 561 663 738 451 959 458 65 615 587 980 937 990 556 403 46 448 396 115 700 85 879 249 735 689 361 1000 84 807 298 385 156 624 708 325 226 468 291 469 865 233 20 634 643 257 556 191 500 446 372 414 667 34 141 138 581 224 637 115 966 11 668 837 7 311 247 222 116 694 513 612 902 709 881 322 733 16 306 556 322 338 45 655 980 558 432 148 800 8 82 983 666 211 256 61 928 174 792 685 520 293 491 23 265 297 396 561 819 247 109 749 153 94 710 228 927 817 469 224 851 486 940 864 800 631 410 115 400 432 937 374 515 986 61 223 509 102 110 2 986 898 421 432 547 48 374 121 739 389 802 252 164 692 41 652 743 954 103 271 691 57 624 954 476 631 66 964 329 521 732 713 793 425 997 962 308 466 543 727 365 677 544 457 214 989 967 746 246 766 223 4 977 487 696 990 894 313 569 708 77 912 35 748 916 273 310 194 745 790 138 527 196 366 871 428 868 425 106 741 193 845 337 870 71 385 374 24 966 870 944 319 104 410 515 736 706 638 726 99 319 38 465 954 14 468 232 7 571 630 469 458 107 663 476 915 627 47 794 104 315 282 402 239 58 762 419 696 736 718 325 842 516 338 445 644 263 696 795 611 750 204 650 630 228 422 861 976 948 24 605 978 240 112 997 863 53 565 984 669 913 532 719 148 847 876 215 383 852 977 509 56 900 635 400 514 217 286 291 390 227 959 24 415 647 120 533 593 863 133 100 334 697 98 833 936 517 672 506 187 848 837 67 903 55 804 473 16 544 344 217 257 867 886 476 651 424 674 964 270 554 738 699 206 395 356 674 309 272 313 509 765 305 406 25 317 258 432 616 839 487 384 821 268 979 186 837 321 396 68 325 458 465 13 502 593 749 212 223 509 349 63 254 93 878 733 598 103 626 376 472 549 765 189 471 891 668 521 659 463 212 959 325 932 802 829 202 92 865 985 712 207 257 405 901 30 690 112 629 16 834 831 784 584 745 703 718 168 523 825 410 908 534 165 759 556 716 291 31 860 290 353 201 851 35 414 641 77 232 103 516 934 658 854 997 585 873 300 704 741 43 9 45 780 189 672 307 834 534 578 157 506 967 286 478 313 30 751 49 588 14 49 830 591 836 22 636 654 198 269 895 802 22 465 608 189 918 778 50 181 51 103 149 517 1 919 455 378 540 302 486 842 881 593 270 936 160 856 191 507 507 973 425 494 739 964 45 526 558 251 865 498 985 745 282 892 155 81 117 41 618 784 400 418 279 453 340 168 832 835 570 256 415 139 10 18 42 880 385 129 536 487 847 688 974 705 22 415 193 368 785 500 524 892 12 662 682 366 740 358 75 76 589 620 916 573 785 194 394 139 254 230 692 850 868 395 590 916 810 723 109 214 9 733 985 177 363 672 487 47 493 598 562 509 714 781 461 857 392 331 777 911 816 293 238 504 12 643 525 121 489 466 835 708 562 870 14 687 203 533 197 391 322 379 861 830 498 112 385 383 666 770 904 611 161 523 737 919 486 373 553 9 103 875 141 818 158 941 551 282 252 124 99 953 972 570 328 479 190 74 865 446 743 54 771 60 271 998 696 402 886 541 616 354".split(" ")).mapToInt(Integer::valueOf).toArray()
                ));
    }
}