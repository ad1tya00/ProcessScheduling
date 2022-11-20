import java.util.*;

public class Priority {     //Non Preemptive

    public static void main(String[] args) {

        System.out.print("Enter Number of Process: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int process[] = new int[n];

        System.out.print("Enter Burst Time for " + n + " process: ");

        int burstTime[] = new int[n];
        for (int i = 0; i < n; i++) {
            burstTime[i] = sc.nextInt();
        }

        System.out.print("Enter Priority for " + n + " process: ");

        int priority[] = new int[n];
        for (int i = 0; i < n; i++) {
            priority[i] = sc.nextInt();
        }

        // Sorting process & burst time by priority
        int temp;
        int temp2;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (priority[j] > priority[j + 1]) {
                    temp = priority[j];
                    priority[j] = priority[j + 1];
                    priority[j + 1] = temp;

                    temp = burstTime[j];
                    burstTime[j] = burstTime[j + 1];
                    burstTime[j + 1] = temp;

                    temp2 = process[j];
                    process[j] = process[j + 1];
                    process[j + 1] = temp2;

                }
            }
        }

        int TAT[] = new int[n + 1];
        int waitingTime[] = new int[n + 1];

        // Calculating Waiting Time & Turn Around Time
        for (int i = 0; i < n; i++) {
            TAT[i] = burstTime[i] + waitingTime[i];
            waitingTime[i + 1] = TAT[i];
        }

        int totalWT = 0;
        int totalTAT = 0;
        double avgWT;
        double avgTAT;

        System.out.println("Process     BT      WT        TAT");
        for (int i = 0; i < n; i++) {

            System.out.print((i + 1) + "\t");
            System.out.print(burstTime[i] + "\t");
            System.out.print(waitingTime[i] + "\t");
            System.out.print(TAT[i] + "\n");
            totalWT += waitingTime[i];
            totalTAT += TAT[i];

        }

        avgWT = totalWT / (double) n;
        avgTAT = totalTAT / (double) n;

        System.out.println("\n Average Wating Time: " + avgWT);
        System.out.println(" Average Turn Around Time: " + avgTAT);

        sc.close();

    }

}
