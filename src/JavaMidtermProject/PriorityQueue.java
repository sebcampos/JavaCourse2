/**
 * Code repurposed from: https://www.programiz.com/dsa/priority-queue#:~:text=Priority%20queue%20can%20be%20implemented,efficient%20implementation%20of%20priority%20queues.
 */
package JavaMidtermProject;


public class PriorityQueue {
    PriorityQueueNode front, rear;
    int dequeueSize;

    PriorityQueue()
    {
        front = rear = null;
        dequeueSize = 0;
    }

    @Override
    public String toString()
    {
        StringBuilder string = new StringBuilder();
        if (isEmpty())
            return "Empty Queue no tasks to work on";

        PriorityQueueNode currentNode = front;
        while (currentNode != null)
        {
            string.append(currentNode).append("\n");
            currentNode = currentNode.next;
        }
        return string.toString();
    }

    // Function to check whether deque
    // is empty or not
    boolean isEmpty() { return (front == null); }

    // Function to return the number of
    // elements in the deque
    int size() { return dequeueSize; }

    // Function to insert an element
    // at the front end
    void insertFront(PriorityQueueNode newNode)
    {
        // If true then new element cannot be added
        // and it is an 'Overflow' condition
        if (newNode == null)
            System.out.print("OverFlow\n");
        else {
            // If deque is empty
            if (front == null)
                rear = front = newNode;

                // Inserts node at the front end
            else {
                newNode.next = front;
                front.prev = newNode;
                front = newNode;
            }

            // Increments count of elements by 1
            dequeueSize++;
        }
    }

    // Function to insert an element
    // at the rear end
    void insertRear(PriorityQueueNode newNode)
    {
        if (newNode == null)
            System.out.print("OverFlow\n");
        else {
            // If deque is empty
            if (rear == null)
                front = rear = newNode;

                // Inserts node at the rear end
            else {
                newNode.prev = rear;
                rear.next = newNode;
                rear = newNode;
            }

            dequeueSize++;
        }
    }

    // Function to delete the element
    // from the front end
    void deleteFront()
    {
        // If deque is empty then
        // 'Underflow' condition
        if (isEmpty())
            System.out.print("UnderFlow\n");

            // Deletes the node from the front end and makes
            // the adjustment in the links
        else {
            PriorityQueueNode temp = front;
            front = front.next;

            // If only one element was present
            if (front == null)
                rear = null;
            else
                front.prev = null;

            // Decrements count of elements by 1
            dequeueSize--;
        }
    }

    // Function to delete the element
    // from the rear end
    void deleteRear()
    {
        // If deque is empty then
        // 'Underflow' condition
        if (isEmpty())
            System.out.print("UnderFlow\n");

            // Deletes the node from the rear end and makes
            // the adjustment in the links
        else {
            PriorityQueueNode temp = rear;
            rear = rear.prev;

            // If only one element was present
            if (rear == null)
                front = null;
            else
                rear.next = null;

            // Decrements count of elements by 1
            dequeueSize--;
        }
    }

    // Function to return the element
    // at the front end
    PriorityQueueNode getFront()
    {
        // If deque is empty, then returns
        // garbage value
        if (isEmpty())
            return null;
        return front;
    }

    // Function to return the element
    // at the rear end
    PriorityQueueNode getRear()
    {

        // If deque is empty, then returns
        // garbage value
        if (isEmpty())
            return null;
        return rear;
    }




// This code is contributed by gauravrajput1

}