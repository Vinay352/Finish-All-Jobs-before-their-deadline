/*
 * TheComparator.java
 *
 * Version:
 *     $2$
 */

/**
 * CSCI-665
 *
 *
 *   @author: Omkar Morogiri,om5692
 *   @author: Vinay Jain,vj9898
 *
 *
 */

import java.util.Comparator;

// A comparator to order JobDetails' objects in priority queue
// first compare based on deadline, then arrival, then duration
public class TheComparator implements Comparator<JobDetails> {
    @Override
    public int compare(JobDetails o1, JobDetails o2) {
        int val = 0;
        if( o1.taskDeadline < o2.taskDeadline ){
            val = 1;
        }
        else if( o1.taskDeadline > o2.taskDeadline ){
             val = -1;
        }
        else if( o1.taskDeadline == o2.taskDeadline ){
            if( o1.taskArrival < o2.taskArrival ){
                val = 1;
            }
            else if( o1.taskArrival > o2.taskArrival ){
                val = -1;
            }
            else if( o1.taskArrival == o2.taskArrival ){
                if( o1.taskDuration < o2.taskDuration ){
                    val = 1;
                }
                else if( o1.taskDuration > o2.taskDuration ){
                    val = -1;
                }
                else if( o1.taskDuration == o2.taskDuration ){
                    val = 0;
                }
            }
        }
        return -1 * val;
    }
}
