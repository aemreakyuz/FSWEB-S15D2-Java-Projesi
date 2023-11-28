import com.workintech.model.Task;
import com.workintech.model.TaskData;
import com.workintech.model.enums.Priority;
import com.workintech.model.enums.Status;

import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Task taskForBob = new Task("S15D2", "letsgobob", "bob", Priority.HIGH, Status.ASSIGNED);
        Task taskForBob2 = new Task("S15D2", "badbob", "bob", Priority.LOW, Status.IN_PROGRESS);

        Task taskForAnn = new Task("S15D2", "letsgobob", "ann", Priority.HIGH, Status.ASSIGNED);
        Task taskForAnn2 = new Task("S15D2", "justann", "ann", Priority.LOW, Status.IN_QUEUE);

        Task taskForCarol = new Task("S15D2", "letsgocarol", "carol", Priority.HIGH, Status.ASSIGNED);
        Task taskForCarol2 = new Task("S15D2", "carolo", "carol", Priority.LOW, Status.IN_QUEUE);

        Task unassignedTask1 = new Task("S15D2", "letsgocarol", null, Priority.HIGH, Status.ASSIGNED);
        Task unassignedTask2 = new Task("S15D2", "carolo", null, Priority.LOW, Status.IN_QUEUE);

        Set<Task> annsTasks = new LinkedHashSet<>();
        annsTasks.add(taskForAnn);
        annsTasks.add(taskForAnn2);

        Set<Task> bobsTasks = new LinkedHashSet<>();
        bobsTasks.add(taskForBob);
        bobsTasks.add(taskForBob2);
        bobsTasks.add(taskForAnn);

        Set<Task> carolsTasks = new LinkedHashSet<>();
        carolsTasks.add(taskForCarol);
        carolsTasks.add(taskForCarol2);

        Set<Task> unassignedTasks = new LinkedHashSet<>();
        unassignedTasks.add(unassignedTask1);
        unassignedTasks.add(unassignedTask2);

        Set<Task> all = new LinkedHashSet<>();
        all.add(taskForAnn);
        all.add(taskForAnn2);
        all.add(taskForBob);
        all.add(taskForBob2);
        all.add(taskForCarol);
        all.add(taskForCarol2);
        all.add(unassignedTask1);
        all.add(unassignedTask2);

        TaskData taskData = new TaskData(annsTasks, bobsTasks, carolsTasks, unassignedTasks);

        System.out.println(taskData);

        Set<Task> allTasks = taskData.getTasks("all");

        System.out.println("All Tasks = " + allTasks);

        System.out.println("Bob's Tasks = " + taskData.getTasks("bob"));
        System.out.println("Ann's Tasks = " + taskData.getTasks("ann"));
        System.out.println("Carol's Tasks = " + taskData.getTasks("carol"));



        Set<Task> unassigned = taskData.getDifference(all, taskData.getTasks("all"));
        System.out.println("Unassigned Tasks = " + unassigned);

        Set<Task> intersectionBobAnn = taskData.getIntersection(bobsTasks, annsTasks);
        System.out.println("BOB VS ANN = " + intersectionBobAnn);
    }
}
