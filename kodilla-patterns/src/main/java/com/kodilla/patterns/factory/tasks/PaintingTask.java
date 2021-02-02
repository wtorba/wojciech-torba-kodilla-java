package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Task {

    private boolean isDone = false;
    private final String taskName;
    private final String color;
    private final String whatToPaint;

    public PaintingTask(String taskName, String color, String whatToPaint) {
        this.taskName=taskName;
        this.color=color;
        this.whatToPaint=whatToPaint;
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

