import java.util.*;

public class RoundRobin {       //Preemptive
    static int n;
    static int quantum;
    static int t = 0;

    static void waiting(int bt[], int wt[], int quantum) {
        // Make a copy of burst times bt[] to store remaining burst times.
        int rem_bt[] = new int[n];
        for (int i = 0; i < n; i++)
            rem_bt[i] = bt[i];

        // Keep traversing processes in round robin manner until all of them are not
        // done.
        while (true) {
            boolean done = true;
            // Traverse all processes one by one repeatedly
            for (int i = 0; i < n; i++) {
                // If burst time of a process is greater than 0 then only need to process
                // further
                if (rem_bt[i] > 0) {
                    done = false; // There is a pending process
                    if (rem_bt[i] > quantum) {
                        // Increase the value of t i.e. shows how much time a process has been processed
                        t += quantum;
                        // Decrease the burst_time of current process by quantum
                        rem_bt[i] -= quantum;
                    }
                    // If burst time is smaller than or equal to quantum. Last cycle for this
                    // process
                    else {
                        // Increase the value of t i.e. shows how much time a process has been processed
                        t = t + rem_bt[i];
                        // Waiting time is current time minus time used by this process
                        wt[i] = t - bt[i];
                        // As the process gets fully executed make its remaining burst time = 0
                        rem_bt[i] = 0;
                    }
                }
            }
            // If all processes are done
            if (done == true)
                break;
        }
    }

    static void findTurnAroundTime(int bt[], int wt[], int tat[]) {
        for (int i = 0; i < n; i++)
            tat[i] = bt[i] + wt[i];
    }

    static void completion(int tat[], int ct[]) {
        for (int i = 0; i < n; i++)
            ct[i] = tat[i];
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of processes: ");
        n = sc.nextInt();
        System.out.println("Enter Time Quantum: ");
        quantum = sc.nextInt();

        int[] bt = new int[n];
        int[] ct = new int[n];
        int[] tat = new int[n];
        int[] wt = new int[n];

        System.out.println("Enter Burst Time: ");
        for (int i = 0; i < n; i++) {
            bt[i] = sc.nextInt();
        }

        waiting(bt, wt, quantum);
        findTurnAroundTime(bt, wt, tat);
        completion(tat, ct);

        System.out.println("PID " + " BT " + " CT " + " TAT " + " WT ");
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + "\t");
            System.out.print(bt[i] + "\t");
            System.out.print(ct[i] + "\t");
            System.out.print(tat[i] + "\t");
            System.out.print(wt[i] + "\n");
        }
        sc.close();
    }
}