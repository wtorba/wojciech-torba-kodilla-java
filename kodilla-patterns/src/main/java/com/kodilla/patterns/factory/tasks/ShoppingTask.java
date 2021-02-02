package com.kodilla.patterns.factory.tasks;

public final class ShoppingTask implements Task {

    private boolean isDone = false;
    private final String taskName;
    private final String whatToBuy;
    private final double quantity;

    public ShoppingTask(String taskName, String whatToBuy, double quantity) {
        this.taskName=taskName;
        this.whatToBuy=whatToBuy;
        this.quantity=quantity;
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
