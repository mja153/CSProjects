
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test {

    private static int MemorySize;
    private static LinkedList<Integer> firstFitList = new LinkedList<>();
    private static LinkedList<Integer> bestFitList = new LinkedList<>();
    private static LinkedList<Integer> worstFitList = new LinkedList<>();
    private static LinkedList<Integer> previouslyLoadedJobs = new LinkedList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in).useDelimiter("\\n");
        int operatingSystemSize = 312;
        System.out.println("Please enter the size of your Memory.");
        MemorySize = in.nextInt();
        while (MemorySize < operatingSystemSize) {
            System.out.println("Your memory is too small to hold the O.S.. Please input a larger value:");
            MemorySize = in.nextInt();
        }
        System.out.println("Please choose one the follow options by entering the corresponding value:");
        System.out.println("1 - Print Allocation/Availability Tables & Memory Snapshots after the execution of EACH instruction");
        System.out.println("2 - Print Allocation/Availability Tables & Memory Snapshots after the execution of the sequence of instructions");
        int userOption = in.nextInt();
        while (userOption > 2) {
            System.out.println("Invalid option. Please try again.");
            userOption = in.nextInt();
        }

        firstFitList.add(0);  //base case
        firstFitList.add(0);
        firstFitList.add(0);
        firstFitList.add(0);    //os
        firstFitList.add(operatingSystemSize);
        firstFitList.add(0);
        bestFitList.add(0); //base case
        bestFitList.add(0);
        bestFitList.add(0);
        bestFitList.add(0); //os
        bestFitList.add(operatingSystemSize);
        bestFitList.add(0);
        worstFitList.add(0); //base case
        worstFitList.add(0);
        worstFitList.add(0);
        worstFitList.add(0); //os
        worstFitList.add(operatingSystemSize);
        worstFitList.add(0);


        System.out.println("Instruction formats:");
        System.out.println("To load a new job, type: (load, job #, [jobSize]k)");
        System.out.println("To remove a job, type: (remove, job #)");
        System.out.println("To reload a job, type: (reload, job #)");
        System.out.println("At this time you may input your sequence in the following format (please note brackets):");
        System.out.println("(instruction 1), (instruction 2), (instruction 3), ... ");
        String instructionList = in.next();


        System.out.println("Instructions accepted as: " + instructionList);
        instructionHandler(instructionList, userOption);
    }

    private static void instructionHandler(String instructionList, int userOption) {
        //try/catch in place to catch IndexOutOfBoundExceptions, as they indicate a user fault in instruction input format. Prompts them to try again.
        try {
            String[] instructions = instructionList.split("\\)");

            for (int x = 0; x < instructions.length; x++) {
                instructions[x] = instructions[x].substring((instructions[x].indexOf("(") + 1), instructions[x].length());
            }
            for(String x : instructions){
                System.out.println(x);
            }
            // for (String instruction : instructions) {
            //    boolean pass;
            //   String[] decider = instruction.split(",");
            //   String jobNumber = decider[1].substring(5, decider[1].length());
            //   if (decider[0].compareTo("load") == 0) {
            //     String jobSize = decider[2].substring(1, decider[2].length() - 1);

            //        firstFit(Integer.parseInt(jobNumber), Integer.parseInt(jobSize));
            //        bestFit(Integer.parseInt(jobNumber), Integer.parseInt(jobSize));
            //       worstFit(Integer.parseInt(jobNumber), Integer.parseInt(jobSize));
            //      previouslyLoadedJobs.add(Integer.parseInt(jobNumber));
            //      previouslyLoadedJobs.add(Integer.parseInt(jobSize));
            //  }
            //  }
            // if (decider[0].compareTo("remove") == 0) {
            //   removeJob(Integer.parseInt(jobNumber));
            //  }
            //  if (decider[0].compareTo("reload") == 0) {
            //       reloadJob(Integer.parseInt(jobNumber));
            // }

        } catch (IndexOutOfBoundsException e) {
        }
        //}


    }
}



