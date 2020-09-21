package y2020;

import org.junit.Test;
import y2020.FindMergePoint.SinglyLinkedListNode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * /challenges/find-the-merge-point-of-two-joined-linked-lists/problem
 *
 */
public class FindMergePoint {

    private static final Scanner scanner = new Scanner(System.in);

    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        SinglyLinkedListNode nodeL1 = head1;

        int point = 1;
        while (nodeL1 != null) {
            point++;

            SinglyLinkedListNode nodeL2 = head2;
            while (nodeL2!=null) {

                if (nodeL1 == nodeL2) {
                    return nodeL1.data;
                }
                nodeL2 = nodeL2.next;
            }

            nodeL1 = nodeL1.next;
        }
        return -1;
    }


    @Test
    public void t1() {
        SinglyLinkedListNode common = new SinglyLinkedListNode(4, new SinglyLinkedListNode(5, new SinglyLinkedListNode(6,null)));

        SinglyLinkedListNode h1 = new SinglyLinkedListNode(1,
                new SinglyLinkedListNode(2,
                        common)
        );


        SinglyLinkedListNode h2 = new SinglyLinkedListNode(3,
                common
        );

        assertEquals(3, findMergeNode(h1, h2));
    }


    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        public SinglyLinkedListNode(int data, SinglyLinkedListNode next) {
            this.data = data;
            this.next = next;
        }

        public String toString(){
            return String.valueOf(data);
        }
    }
}
