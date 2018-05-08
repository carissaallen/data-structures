package Queue;

public class Queue {

    /* Queue class defines methods to add and remove items from the queue */
    public class Queue {
        private QueueNode front; //Reference to the job record in front
        private QueueNode rear; //Reference to the job record behind

        //Accessor methods are used to return value of the private data members.
        public QueueNode getFront() {
            return front;
        }
        public QueueNode getRear() {
            return rear;
        }

        //Mutator methods are used to set value for the private data members.
        public void setFront(QueueNode newJob) {
            front = newJob;
        }
        public void setRear(QueueNode newJob) {
            rear = newJob;
        }

        //The method Queue() initializes pointers front and rear of the job queue.
        public void Queue() {
            setFront(null);
            setRear(null);
        }

        //The method insert() adds a job to the queue.
        public void insert(int data) {
            //Create object
            QueueNode newItem = new QueueNode();
            //Create reference variable and allocate memory
            newItem.data = data;
            newItem.prev = rear;
            newItem.next = null;

            //Check whether the queue is empty or not. If the queue is empty, add one job to the queue.
            if (getFront() == null)
                setFront(newItem);
            else
                getRear().next = newItem;
            setRear(newItem);
        }

        //The method remove() is defined to remove the first job from the queue.
        public int remove() {
            //Declare and initialize the variable
            int data = getFront().data;

            //Set the value of item to remove from the queue
            setFront(getFront().next);

            //Check whether queue is null, if it is null set the rear end of the queue as null.
            if (getFront() == null)     //Condition to check the queue
                setRear(null);          //Set the rear end of the queue as null
            else
                getFront().prev = null;
            return data;               //Return item number
        }

        //The method printQueue() is defined to print the elements present in the queue.
        public void printQueue() {
            //Create a temp variable and assign the element to it
            QueueNode temp = getFront();
            //Using while loop, check the queue is not null.
            System.out.println("The queue contains: ");
            //Using a while loop, check that the queue is not null
            while(temp != null) {
                //Print the item numbers in the queue
                System.out.println(temp.data);
                //Assign the next item number in the queue to the variable
                temp = temp.next;
            }
        }
    }
}
