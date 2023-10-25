/**
 * @author Sebastian Campos
 *
 * @description Main Java midterm program.
 * Maintains a ...
 *
 */
package JavaMidtermProject;

import java.util.Scanner;

public class Main {


    /**
     * Using the scanner receives and verifies a user input for an
     * option number in the main menu.
     * @param scanner instance of the Scanner class
     * @return the validated option number
     */
    public static int selectOptionPrompt(Scanner scanner)
    {
        int option = -1;
        System.out.println("Please select one of the following options by entering its corresponding number: ");
        System.out.println("1 Display Task Dequeue");
        System.out.println("2 Display Client Tasks");
        System.out.println("3 Add a client");
        System.out.println("4 Add a task");
        System.out.println("5 Complete a task");
        System.out.println("6 Exit");

        while (option == -1)
        {
            if (scanner.hasNextInt())
            {
                option = scanner.nextInt();
            }

            if (option < 1 || option > 6)
            {
                System.out.println("Please enter a valid option number");
                option = -1;
            }
            scanner.nextLine();
        }
        return option;
    }

    /**
     * Using the scanner requests a client name to create a new client with
     * @param scanner instance of the Scanner class
     * @return the user client name selection
     */
    public static String promptToGetClientName(Scanner scanner)
    {
        System.out.println("Please Enter a client name:");
        return scanner.nextLine();
    }


    /**
     * Using the scanner requests a priority number to assign to the new task
     * @param scanner instance of Scanner class
     * @return user priority selection as an int
     */
    public static int promptToGetTaskPriority(Scanner scanner)
    {
        System.out.println("Please enter the task priority (1-10) with 10 being the highest priority:");
        return scanner.nextInt();
    }

    /**
     * Outputs a String visual representation of the provided AVL Tree
     * @param clientTasks The AVLTree of any client
     */
    public static void printClientTree(AVLBSTClientTasks clientTasks)
    {
        System.out.println(BSTPrint.treeToString(clientTasks.getRoot()));
    }

    /**
     * Outputs the current items in the provided task dequeue
     * @param tasks instance of PriorityQueue
     */
    public static void printTasks(PriorityQueue tasks)
    {
        System.out.println(tasks);
    }


    /**
     * Outputs the current list of clients and the number of
     * tasks pending for each
     * @param clients instance of the Clients class
     */
    public static void printClients(Clients clients)
    {
        System.out.println(clients);
    }



    public static void main(String[] args)
    {
        // 2 new priority Queues, one for high and low priority
        PriorityQueue lowPriorityTasks = new PriorityQueue();
        PriorityQueue highPriorityTasks = new PriorityQueue();

        // new instance of the Clients class to manage all clients
        Clients clients = new Clients();

        // Scanner to get user input
        Scanner scanner = new Scanner(System.in);

        // used to collect name for different clients
        String clientName;

        // represents user selection
        int option;


        // collect option from user
        option = selectOptionPrompt(scanner);


        // quit if option selected becomes 6
        while (option != 6) {

            // logic for each option
            switch (option) {
                case 1:
                    // display tasks
                    if (!lowPriorityTasks.isEmpty() && !highPriorityTasks.isEmpty()) {
                        System.out.println("Low Priority tasks (1-6)");
                        printTasks(lowPriorityTasks);
                        System.out.println("High Priority tasks (7-10)");
                        printTasks(highPriorityTasks);
                    }
                    else if (!lowPriorityTasks.isEmpty()) {
                        System.out.println("Low Priority tasks (1-6)");
                        printTasks(lowPriorityTasks);
                    }
                    else if (!highPriorityTasks.isEmpty()) {
                        System.out.println("High Priority tasks (7-10)");
                        printTasks(highPriorityTasks);
                    }
                    else
                        printTasks(lowPriorityTasks);
                    break;
                case 2:
                    // display clients
                    printClients(clients);
                    break;
                case 3:
                    // get client name
                    clientName = promptToGetClientName(scanner);

                    // validate client name does not already exist
                    if (clients.clientsAndTasks.getOrDefault(clientName, null) == null) {
                        // add client name to Clients instance
                        clients.addAClient(clientName);
                        System.out.println("Client \"" + clientName + "\" added successfully");
                    } else {
                        // output Client already exists message
                        System.out.println("Client \"" + clientName + "\" already exists");
                    }
                    break;
                case 4:
                    // get client name to add a task to
                    clientName = promptToGetClientName(scanner);

                    // verify client name is known
                    if (clients.clientsAndTasks.getOrDefault(clientName, null) == null) {
                        // output no such client message
                        System.out.println("Client \"" + clientName + "\" Does not exist, please add client before adding tasks");
                    } else {

                        // request task priority number from user
                        int taskPriority = promptToGetTaskPriority(scanner);

                        // verify task priority number is in correct range
                        if (taskPriority < 1 || taskPriority > 10) {
                            System.out.println("Invalid Task priority, please use a number from 1-10 inclusive");
                            break;
                        }

                        // Clients class adds a task of task priority to client name and receive new client task id
                        int clientTaskId = clients.addATask(clientName, taskPriority);
                        System.out.println("Task Id after add a task " + clientTaskId);

                        // Create new PriorityQueue node with client name, task priority and client task id
                        PriorityQueueNode task = new PriorityQueueNode(clientName, taskPriority, clientTaskId);

                        // add new node to high or low priority queue based on task priority
                        if (taskPriority < 7) {
                            lowPriorityTasks.insertFront(task);
                        } else {
                            highPriorityTasks.insertFront(task);
                        }
                    }
                    break;
                case 5:
                    // complete a task
                    PriorityQueueNode taskToRemove;
                    int taskId;
                    int taskPriority;

                    // verify at lest one task queue is not empty
                    if (lowPriorityTasks.isEmpty() && highPriorityTasks.isEmpty()) {
                        System.out.println("task queue is empty");

                    // if the high priority queue is not emtpy start here
                    } else if (!highPriorityTasks.isEmpty()) {
                        // get the oldest task in the high priority queue and collect its id, priority, and name
                        taskToRemove = highPriorityTasks.getRear();
                        taskId = taskToRemove.getCurrentTaskId();
                        taskPriority = taskToRemove.getTaskPriority();
                        clientName = taskToRemove.getTaskClientName();

                        // output clients pending task tree before and after removal
                        System.out.println("Client \"" + clientName + "\" tasks before removal");
                        printClientTree(clients.clientsAndTasks.get(clientName));

                        // Clients instance completes the task
                        clients.completeTask(clientName, taskId, taskPriority);
                        System.out.println("Client \"" + clientName + "\" tasks  after removal");
                        printClientTree(clients.clientsAndTasks.get(clientName));
                        highPriorityTasks.deleteRear();

                    } else {
                        // get the oldest task in the low priority queue and collect its id, priority, and name
                        taskToRemove = lowPriorityTasks.getRear();
                        taskId = taskToRemove.getCurrentTaskId();
                        taskPriority = taskToRemove.getTaskPriority();
                        clientName = taskToRemove.getTaskClientName();

                        // output clients pending task tree before and after removal
                        System.out.println("Client \"" + clientName + "\" tasks before removal");
                        printClientTree(clients.clientsAndTasks.get(clientName));

                        // Clients instance completes the task
                        clients.completeTask(clientName, taskId, taskPriority);
                        System.out.println("Client \"" + clientName + "\" tasks  after removal");
                        printClientTree(clients.clientsAndTasks.get(clientName));
                        lowPriorityTasks.deleteRear();

                    }
                    break;

            }
            // loop
            option = selectOptionPrompt(scanner);
        }


    }



}
