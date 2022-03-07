/*
 * Boss.java
 *
 * Version:
 *     $2$
 */

/**
 * CSCI-665
 *
 *  Aim:  An algorithm to order scheduling of jobs and find
 *          whether it is possible to complete every job in the
 *          schedule before its deadline or not
 *
 *   Complexity of our Implementation: O( n * log(n) )
 *
 *
 *   @author: Omkar Morogiri,om5692
 *   @author: Vinay Jain,vj9898
 *
 *
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.PriorityQueue;

public class Boss {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        // input for number of jobs to do
        int n = Integer.parseInt( br.readLine() );
        JobDetails[] jobs = new JobDetails[n]; // array to store details of every job

        // priority queue - inbuilt library
        // poll or extract operation - O(log n) : constant time
        // add operation - O( log(n) )
        PriorityQueue<JobDetails> prQueue = new PriorityQueue<JobDetails>(n, new TheComparator());

        // variable to keep track of whether we can successfully achieve our target criteria or not
        boolean isItPossible = true;

        // store job details in array
        for( int i = 0; i < n; i++ ){
            String[] temp = br.readLine().strip().split(" ");

            jobs[i] = new JobDetails( Integer.parseInt( temp[0] ), Integer.parseInt( temp[1] ), Integer.parseInt( temp[2] ) );
        }

        // add first job to priority queue - O( log(n) )
        prQueue.add( jobs[0] );
        int currentTime = 0, i = 0;

        while( i < n ){

            JobDetails head = prQueue.poll(); // extract the head of the priority queue - O(log n) operation
            // currentTime = head.taskArrival;
            if( currentTime + head.taskDuration > head.taskDeadline ){ // check if current task can be completed before deadline or not
                isItPossible = false;
                break;
            }

            // if next job's arrival time is before the completion of current task
            if( i + 1 < n && jobs[i + 1].taskArrival < currentTime + head.taskDuration ){
                head.taskDuration -= Math.abs( ( currentTime - jobs[i + 1].taskArrival ) );
                currentTime = jobs[i + 1].taskArrival;
                prQueue.add( head ); // O(log n)
                prQueue.add( jobs[i + 1] ); // O(log n)
                i += 1;
            }
            else{ // if the next job's arrival time is after completion of current task
                // check if current task can be completed before deadline or not
                if( !( currentTime + head.taskDuration > head.taskDeadline ) ){
                    currentTime += head.taskDuration;
                }
                else{
                    isItPossible = false;
                    break;
                }
            }
            // if there are no elements in the priority queue as of now
            // add next element, if it exists and update current time
            if( prQueue.isEmpty() ){
                i += 1;
                if( i < n ){
                    prQueue.add( jobs[i] ); // O(log n)
                    currentTime = jobs[i].taskArrival;
                }
            }
        }

        System.out.println( isItPossible ? "YES" : "NO" );

    }

}
