package LLL;

public class LLL {

    /* Linear Linked List */
    public class LLL {
        protected Node start;
        protected Node end;
        public int size;

        /* Constructor */
        public LLL() {
            start = null;
            end = null;
            size = 0;
        }

        /* Function to check if list is empty */
        public boolean isEmpty() {
            return start == null;
        }

        /* Function to get size of list */
        public int getSize() {
            return size;
        }

        /* Function to insert an element at beginning */
        public void insertAtStart(int val) {
            Node ptr = new Node(null, val);
            ++size;
            if (start == null) {
                start = ptr;
                end = start;
            } else {
                ptr.set_next(start);
                start = ptr;
            }
        }

        /* Function to insert an element at end */
        public void insertAtEnd(int val) {
            Node ptr = new Node(null, 2);
            if (start == null) {
                start = ptr;
                end = start;
            } else {
                ptr.set_next(start);
                end = ptr;
            }
        }

        /* Function to build a LLL */
        public void build() {
            LLL.LLL list = new LLL.LLL();
            list.insertAtStart(10);
            list.insertAtStart(3);
            list.insertAtStart(2);
            list.insertAtStart(8);
            list.insertAtStart(10);
            list.insertAtStart(2);
            list.insertAtStart(10);
            list.insertAtStart(9);
            list.insertAtStart(2);
            list.insertAtStart(1);
            list.insertAtStart(1);
            list.display();
        }

    /* Function to delete a LLL */

        /* Function to display elements */
        public void display() {
            System.out.print("\nLinked List = ");
            if (size == 0)
            {
                System.out.print("empty\n");
                return;
            }
            if (start.get_next() == null)
            {
                System.out.println(start.get_data());
                return;
            }
            Node ptr = start;
            System.out.print(start.get_data()+ " -> ");
            ptr = start.get_next();
            while (ptr.get_next() != null)
            {
                System.out.print(ptr.get_data()+ " -> ");
                ptr = ptr.get_next();
            }
            System.out.print(ptr.get_data()+ "\n");
        }

        /* Wrapper function to reverse a LLL */
        public Node reverse() {
            return recurseReverse(start);
        }

        /* Function to reverse a LLL */
        protected Node recurseReverse(Node start) {
            if (start == null || start.next == null)
                return start;
            //get second node
            Node second = start.next;
            //set first's next to be null
            Node rest = recurseReverse(second);
            second.next = start;
            return rest;
        }

        /* Return the middle element of a LLL (helper function) */
        Node findMiddle(Node mid) {
            if (mid == null) {
                return mid;
            }
            Node fast = mid.next;
            Node slow = mid;
            while (fast != null) {
                fast = fast.next;
                if(fast != null) {
                    slow = slow.next;
                    fast = fast.next;
                }
            }
            return slow;
        }

        /* Sort a LLL using Merge Sort method */
        Node sorted(Node a, Node b) {
            Node result = null;
            if (a == null) {
                return b;
            }
            if (b == null) {
                return a;
            }
            if (a.data <= b.data) {
                result = a;
                result.next = sorted(a.next, b);
            }
            else {
                result = b;
                result.next = sorted(a, b.next);
            }
            return result;
        }

        public Node mergeSort(Node a) {
            if (a == null || a.next == null) {
                return a;
            }
            Node middle = findMiddle(a);
            Node nextMiddle = middle.next;
            middle.next = null;
            Node left = mergeSort(a);
            Node right = mergeSort(nextMiddle);
            Node sortedList = sorted(left, right);
            return sortedList;
        }
    }
}
