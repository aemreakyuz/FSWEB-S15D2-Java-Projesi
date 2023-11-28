package com.workintech.model;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks ;
    private Set<Task> bobsTasks ;
    private Set<Task> carolsTasks ;
    private Set<Task> unassignedTasks;


    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getUnassignedTasks() {
        return unassignedTasks;
    }

    public Set<Task> getAnnsTasks() {
        return annsTasks;
    }

    public Set<Task> getBobsTasks() {
        return bobsTasks;
    }

    public Set<Task> getCarolsTasks() {
        return carolsTasks;
    }

    public Set<Task> getTasks(String employee){
        switch(employee){
            case "ann":
                return annsTasks;
            case "bob":
                return bobsTasks;
            case "carol":
                return carolsTasks;
            case "all":
                return getUnion(annsTasks, bobsTasks, carolsTasks);
            default:
                return new HashSet<>();
        }
    }



    public Set<Task> getUnion(Set<Task>... taskSets){
        HashSet<Task> all = new LinkedHashSet<>();

        for (Set<Task> taskSet : taskSets){
            all.addAll(taskSet);
        }
        return all;
    }

    public Set<Task> getIntersection(Set<Task> task1, Set<Task> task2) {
        Set<Task> intersections = new HashSet<>(task1);
        intersections.retainAll(task2);
        return intersections;
    }

    public Set<Task> getDifference(Set<Task> task1, Set<Task> task2){
        Set<Task> differences = new HashSet<>(task1);
        differences.removeAll(task2);
        return differences;
    }

    public String toString() {
        return "TaskData{" +
                "annsTasks=" + annsTasks +
                ", bobsTasks=" + bobsTasks +
                ", carolsTasks=" + carolsTasks +
                ", unassignedTasks=" + unassignedTasks +
                '}';
    }
}
