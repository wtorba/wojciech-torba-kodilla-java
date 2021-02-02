package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Task {

    private boolean isDone = false;
    private final String taskName;
    private final String where;
    private final String using;

    public DrivingTask(String taskName, String where, String using) {
        this.taskName=taskName;
        this.where=where;
        this.using=using;
    }

    public String getTaskName() {
        return taskName;
    }

    public void executeTask() {
        this.isDone=true;
    }

    public boolean isTaskExecuted() {
        return this.isDone;
    }

}
