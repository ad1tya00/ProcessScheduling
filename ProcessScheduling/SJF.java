import java.util.*;

public class SJF {      //Preemptive
    static int n;
    static int t = 0;

    static void waiting(int at[], int[] bt, int wt[]) {
        int rt[] = new int[n];

        for (int i = 0; i < n; i++)
            rt[i] = bt[i];

        int complete = 0, t = 0, minm = Integer.MAX_VALUE;
        int shortest = 0, finish_time;
        boolean check = false;

        while (complete != n) {

            for (int j = 0; j < n; j++) {
                if ((at[j] <= t) && (rt[j] < minm) && rt[j] > 0) {
                    minm = rt[j];
                    shortest = j;
                    check = true;
                }
            }

            if (check == false) {
                t++;
                continue;
            }

            rt[shortest]--;

            minm = rt[shortest];
            if (minm == 0)
                minm = Integer.MAX_VALUE;

            if (rt[shortest] == 0) {

                complete++;
                check = false;

                finish_time = t + 1;

                wt[shortest] = finish_time - bt[shortest] - at[shortest];

                if (wt[shortest] < 0)
                    wt[shortest] = 0;
            }
            t++;
        }
    }

    static void findTurnAroundTime(int bt[], int wt[], int tat[]) {

        for (int i = 0; i < n; i++)
            tat[i] = bt[i] + wt[i];
    }

    static void completion(int[] at, int tat[], int ct[]) {
        for (int i = 0; i < n; i++)
            ct[i] = at[i] + tat[i];
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of processes: ");
        n = sc.nextInt();

        int[] at = new int[n];
        int[] bt = new int[n];
        int[] ct = new int[n];
        int[] tat = new int[n];
        int[] wt = new int[n];

        System.out.println("Enter Arrival Time: ");
        for (int i = 0; i < n; i++) {
            at[i] = sc.nextInt();
        }
        System.out.println("Enter Burst Time: ");

        for (int i = 0; i < n; i++) {
            bt[i] = sc.nextInt();
        }

        waiting(at, bt, wt);
        findTurnAroundTime(bt, wt, tat);
        completion(at, tat, ct);

        System.out.println("PID " + " AT " + " BT " + " CT " + " TAT " + " WT ");
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + "\t\t");
            System.out.print(at[i] + "\t\t");
            System.out.print(bt[i] + "\t\t");
            System.out.print(ct[i] + "\t\t");
            System.out.print(tat[i] + "\t\t");
            System.out.print(wt[i] + "\n");

        }
        sc.close();

    }
}
