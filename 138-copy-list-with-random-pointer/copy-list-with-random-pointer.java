/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        //STEP 1: INSERTION
        Node temp = head;
        while(temp != null){
            Node n1 = new Node(temp.val);
            Node tempp1 = temp.next;
            temp.next = n1;
            n1.next = tempp1;
            temp = tempp1;
        }

        //STEP 2: SETTING THE RANDOM POINTER
        Node t = head;
        while(t != null){
            if(t.random != null){
                t.next.random = t.random.next;
            }
            t = t.next.next;
        }

        //SEPARATE NEW & OLD LL
        Node h2 = head.next;
        Node t1 = head;
        Node t2 = head.next;
        while(t1 != null){
            Node t1p1 = null;
            Node t2p1 = null;
            if(t1.next.next != null){
                t1p1 = t1.next.next;
            }
            if(t2.next != null){
                t2p1 = t2.next.next;
            }

            t1.next = t1p1;
            t2.next = t2p1;

            t1 = t1p1;
            t2 = t2p1;
        }
        return h2;

    }
}