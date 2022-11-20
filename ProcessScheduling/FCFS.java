import java.util.*;

public class FCFS {     //Non Preemptive
    static int time = 0;
    static int n;

    static void completion(int ct[], int at[], int bt[]) {
        for (int i = 0; i < n; i++) {
            int temp;
            while (time < at[i]) {
                time++;
            }
            temp = time + bt[i];
            time = time + bt[i];
            ct[i] = temp;
        }
    }

    static void turnAround(int tat[], int ct[], int at[]) {
        int temp;
        for (int i = 0; i < n; i++) {
            temp = ct[i] - at[i];
            tat[i] = temp;
        }
    }

    static void wait(int wt[], int tat[], int bt[]) {
        int temp;
        for (int i = 0; i < n; i++) {
            temp = tat[i] - bt[i];
            wt[i] = temp;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of processes: ");
        n = sc.nextInt();

        int[] arrivalTime = new int[n];
        int[] burstTime = new int[n];
        int[] completionTime = new int[n];
        int[] turnAroundTime = new int[n];
        int[] waitTime = new int[n];

        System.out.println("Enter Arrival Time: ");
        for (int i = 0; i < n; i++) {
            arrivalTime[i] = sc.nextInt();
        }
        System.out.println("Enter Burst Time: ");

        for (int i = 0; i < n; i++) {
            burstTime[i] = sc.nextInt();
        }

        completion(completionTime, arrivalTime, burstTime);
        turnAround(turnAroundTime, completionTime, arrivalTime);
        wait(waitTime, turnAroundTime, burstTime);

        for (int i = 0; i < n; i++) {
            System.out.print(arrivalTime[i] + "\t");
            System.out.print(burstTime[i] + "\t");
            System.out.print(completionTime[i] + "\t");
            System.out.print(turnAroundTime[i] + "\t");
            System.out.print(waitTime[i]);
            System.out.println("");
        }
        sc.close();
    }
}