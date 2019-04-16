package com.example.green.crmproject_android;

import org.junit.Assert;
import org.junit.Test;

import TaskPackage.Task;
import TaskPackage.TaskList;

import static org.junit.Assert.*;

public class TaskTests {

    @Test
    public void testTaskListSize() {
        TaskList list = new TaskList();

        list.addTask(new Task("doing a thing"));
        list.addTask(new Task("doing the next thing"));
        list.addTask(new Task("do it all"));

        assertEquals(3, list.size());
    }

    @Test
    public void testDeletion() {
        TaskList list2 = new TaskList();

        list2.addTask(new Task("doing a thing"));
        list2.addTask(new Task("doing the next thing"));
        list2.addTask(new Task("do it all"));

        list2.deleteTask(2);

        assertEquals(2, list2.size());
    }
}