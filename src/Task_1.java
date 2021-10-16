import java.util.Scanner;


public class Task_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] arr = str.split(" +");
        int[] scores = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            scores[i] = Integer.parseInt(arr[i]);
        }

        double avg_score = average(scores);
        System.out.println(avg_score);

        int index = index_of_max(scores);
        System.out.println(index);

    }

    // method 1
    public static double average(int[] scores) {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.length;
    }

    // method 2
    public static int index_of_max(int[] scores) {
        int index = -1;
        int max = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
                index = i;
            }
        }
        return index;
    }
}
