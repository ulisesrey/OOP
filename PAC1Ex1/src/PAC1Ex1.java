import java.util.Scanner;

public class PAC1Ex1 {

    private static int motzkin(int n, int motzkinNMinus1, int motzkinNMinus2) {
        // Base cases
        if (n == 0 || n == 1) return 1;
        // Other cases
        return (int)(((2.0 * n + 1) * motzkinNMinus1) / (n + 2) + ((3.0 * n - 3) * motzkinNMinus2) / (n + 2));
    }

    public static void printMotzkin(int n) {
        int motzkin, motzkinNMinus1 = 1, motzkinNMinus2 = 1;

        for (int i = 0; i <= n; i++) {

            motzkin = motzkin(i, motzkinNMinus1, motzkinNMinus2);
            System.out.print(motzkin + ", ");

            motzkinNMinus2 = motzkinNMinus1;
            motzkinNMinus1 = motzkin;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        do {
            System.out.print("Enter the value of N (only whole numbers): ");
            n = scanner.nextInt();

            if (n <= 0) {
                System.out.print("The value of N must be a whole number. Try again.");
            }
        } while (n <= 0);

        printMotzkin(n);
    }
}
