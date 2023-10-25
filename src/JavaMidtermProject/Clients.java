/**
 * @author Sebastian Campos
 * @description Clients class manages a hashmap of clients. It adds clients and empty BST's to
 * the hashmap if that client doesn't already exist, then used to call add or delete methods
 * for specified clients in the hashmap.
 */

package JavaMidtermProject;

import java.util.HashMap;
import java.util.Map;

public class Clients {

    // hashmap to manage all clients
    HashMap<String, AVLBSTClientTasks> clientsAndTasks = new HashMap<>();

    /**
     * Places a new client and empty BST pair into the hashmap
     * @param clientName The name / Key identifier for the client
     */
    public void addAClient(String clientName)
    {
        clientsAndTasks.put(clientName, new AVLBSTClientTasks());
    }

    /**
     * Completes a task for a specified client by finding the client and calling the removeKey method
     * for that clients BST
     * @param clientName Identifier / Name of the client to find
     * @param taskId Task id integer of the task to be removed from the clients BST
     * @param taskPriority the task priority number to be output upon removal
     */
    public void completeTask(String clientName, int taskId, int taskPriority)
    {
        // output task id, client name, and priority level
        System.out.println("Removing task: " + taskId + ", From client " + clientName + " of priority level: " + taskPriority);

        // remove the client
        boolean removed = clientsAndTasks.get(clientName).removeKey(taskId);

        // output value for successful removal
        System.out.println("Successfully removed " + removed);

    }

    /**
     * Ads a new task of a given priority to the provided client.
     * Once the task is created in the client tree we return the unique id
     * associated with the newly created task
     * @param clientName String client name to add a task to
     * @param priority the priority to create for the new task
     * @return integer new task id
     */
    public int addATask(String clientName, int priority)
    {
        // collect the task id for the new task to create
        int taskId = clientsAndTasks.get(clientName).getCurrentTaskId();

        // create a new task node using task id and the provided priority
        AVLNode newTask = new AVLNode(taskId, priority);

        // insert the task into the clients BST
        clientsAndTasks.get(clientName).insert(newTask);

        // increment the task id for future tasks
        clientsAndTasks.get(clientName).incrementTaskId();
        return taskId;
    }

    /**
     * toString override to output a summary of all clients and their current number of
     * pending tasks
     * @return String summary of clients
     */
    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder();
        if (clientsAndTasks.isEmpty())
        {
            return result.toString();
        }
        for (Map.Entry<String, AVLBSTClientTasks> entry : clientsAndTasks.entrySet()) {
            String key = entry.getKey();
            AVLBSTClientTasks value = entry.getValue();
            result.append("Client: \"").append(key).append("\", Tasks Pending: ").append(value.getSize()).append("\n");
        }
        return result.toString();
    }

}
