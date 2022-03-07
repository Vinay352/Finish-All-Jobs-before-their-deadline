/*
 * JobDetails.java
 *
 * Version:
 *     $2$
 */

/**
 * CSCI-665
 *
 *   @author: Omkar Morogiri,om5692
 *   @author: Vinay Jain,vj9898
 *
 *
 */

public class JobDetails {

    int taskDuration; // duration of the task
    int taskArrival; // arrival of the task
    int taskDeadline; // deadline of the task

    JobDetails( int taskArrival, int taskDeadline, int taskDuration ){
        this.taskArrival = taskArrival;
        this.taskDeadline = taskDeadline;
        this.taskDuration = taskDuration;
    }

}
