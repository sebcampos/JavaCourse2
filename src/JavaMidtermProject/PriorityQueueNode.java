package JavaMidtermProject;

public class PriorityQueueNode {



    // client id
    final private String clientId;

    // task id specific to this instance
    final private int taskId;

    // priority level
    final private int priority;

    PriorityQueueNode prev, next;

    PriorityQueueNode(String clientId, int priority, int taskId)
    {
        this.clientId = clientId;
        this.taskId = taskId;
        this.priority = priority;
    }

    public void setPrevious(PriorityQueueNode node) { prev = node;}

    public void setNext(PriorityQueueNode node) { next = node;}

    public int getCurrentTaskId() { return  taskId; }

    public int getTaskPriority() { return  priority; }

    public String getTaskClientName() { return  clientId; }

    @Override
    public String toString()
    {
        return "ClientID: " + clientId + "\n\tTask Id: " + taskId + "\n\tPriority: " + priority;
    }


}
