package com.company;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class ProducerConsumer {
    /*
    global variables to be altered through the random calls of Producer and Consumer.
     */
    private static int sequenceValue = 1;
    private static Queue<Integer> RNGValues = new LinkedList<Integer>();
    private static Queue<Integer> sequenceValueArray = new LinkedList<Integer>();

    /*
    main method. gathers initial user input of desired Range, and prompts them to choose which Producer option they prefer
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the Range of the values generated for your sequence");
        int Range = in.nextInt();
        int userOption = UserProducerDecider();
        // ScheduledExecutorService allows the program to, on an interval, loop the call of a single function.
        final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

            // periodically (every 2 seconds) re-run the Scheduler() function until user inputs a value to stop the program.
            do {
                executorService.scheduleAtFixedRate(new Runnable() {
                    @Override
                    public void run() {
                        Scheduler(Range, userOption);
                    }
                }, 0, 2, TimeUnit.SECONDS);
            } while(!in.hasNext());
            if(in.hasNext()){
                Stop();
            }

    }

    // Function to gather the user's desired method of generating the global variable sequenceValue
    private static int UserProducerDecider() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please select one of the following options, by entering the corresponding integer value:");
        System.out.println("1 - increment the value of the global variable by 1 for each Producer call");
        System.out.println("2 - randomly generate the value of the global variable for each Producer call");
        int userOption = in.nextInt();
        // ensure that userOption is a valid selection
        while(userOption > 2) {
            System.out.println("Invalid selection. Please choose again.");
            userOption = in.nextInt();
        }
        // accept user input and move forward
        System.out.println("Thank you. You may type anything to end the program and print a summary of results; until then, the program will run continuously.");

        // return the user decision to userOption variable to begin Scheduler loop.
        return userOption;
    }

    /* Producer method will, depending on userOption, generate a new value of the global variable sequenceValue
    each time the function is called. Currently coded is the ability to increment the value by 1 each call,
    or to have the value be entirely random (still limited by the user inputted Range from before, to avoid
    overflow values).
    To add subsequent methods of generation, simply write another if-else statement with a userOption
    condition of 3 or greater, and have that value be passed into Producer() by adding a new prompt option in UserProducerDecider()
     */
    private static void Producer(int Range, int userOption) {

        if (userOption == 1) {
            sequenceValue++;

        } else if (userOption == 2) {
            /* seed is generated at random each call based off the current number of milliseconds on the system clock
            thus causing the sequenceValue to be inherently random.
            */
            long seed = System.currentTimeMillis();
            Random RNG = new Random(seed);
            sequenceValue = RNG.nextInt(Range);
        }
        // Alert the user that the Producer was called, so that they know the program is functioning behind the scene until they stop it
        System.out.println("Producer called. New sequence value: " + sequenceValue);
    }

    /*
    The consumer function is trivial. As the sequenceValue is stored globally, the Consumer doesn't accept any args.
    It simply calls the toString method with the 'sender' value of 2, alerting the toString method of what to
    do with the incoming sequenceValue.
     */
    private static void Consumer() {
        toString(2, sequenceValue);
    }

    /* The Scheduler() accepts both the userOption and Range, containing user inputted integers.
    This function is called on a two-second time interval, and controls the flow of the entire program.
    A random value is calculated, using a randomly generated seed, and based upon that value, the Producer or
    Consumer functions are called.
    The randomly generated numbers are also stored in an array, by calling the toString function below.
     */
    private static void Scheduler(int Range, int userOption) {
        /* seed is generated at random each call based off the current number of milliseconds on the system clock
        thus causing the sequenceValue to be inherently random.
         */
        long seed = System.currentTimeMillis();
        Random RNG = new Random(seed);
        int prodConDecider = RNG.nextInt(Range);

        if (prodConDecider % 2 == 0) {
            Producer(Range, userOption);
        } else Consumer();

        toString(1, prodConDecider);
    }

    /*
   The toString function is called from several different areas in the program, and based on where it
   is called from, it must print different fragments of data and store its arguments in different places,
   either global or local. Because of this, a sender argument is used, to determine what the toString method will do.
   It is contained in a single function because each and every sender value still causes it to output data to the User,
   just in different formats.
    */
    private static void toString(int sender, int sequenceValue) {
        // sender = 1 indicates the data is coming from the Scheduler. Thus, arg[1] is the RNG value to determine Producer/Consumer calls
        if (sender == 1) {
            RNGValues.add(sequenceValue);
        }
        /* sender = 2 indicates data is coming from the Consumer.
        The value of arg[1] is then the value of the sequenceValue global variable at the time of
        the Consumer() call, and is printed to the user immediately. It also, however, is stored in
        a sequenceValueArray (a queue), to be printed in order upon ending the program to the user.
         */
        else if (sender == 2) {
            sequenceValueArray.add(sequenceValue);
            System.out.println("Consumer called. Value: " + sequenceValue);
        }
        /* sender = 3 indicates the data is coming from the Stop() function.
        At this time, the user has demanded that the program terminate, and the results be printed in summary.
        The values of both the RNGValue and sequenceValue queues are printed in user-friendly format.
         */
        else if (sender == 3) {
            int seqArraySize = sequenceValueArray.size();
            int rngArraySize = RNGValues.size();
            System.out.println("The random values generated between 1 - Range were:  \n");
            for(int i=0; i<rngArraySize; i++) {
                int val = RNGValues.remove();
                System.out.print(val + " ");
            }
            System.out.println("\nThese values determined the order in which the Producer and Consumer were called. \n\n");
            System.out.println("The values generated, in order, by Consumer calls were:  \n");
            for(int i=0; i<seqArraySize; i++) {
                int val = sequenceValueArray.remove();
                System.out.print(val + " ");
            }
        }
    }
    // When this function is called, prompt the toString function to print results, then exit the program.
    private static void Stop() {
        toString(3, 0);
        System.exit(0);
    }
}