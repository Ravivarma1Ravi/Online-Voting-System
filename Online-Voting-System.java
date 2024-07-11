import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OnlineVotingSystem {
    private static Map<String, Integer> candidates = new HashMap<>();
    private static Map<String, Boolean> votedUsers = new HashMap<>();

    public static void main(String[] args) {
        initializeCandidates();

        while (true) {
            displayMenu();

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showCandidates();
                    break;
                case 2:
                    vote();
                    break;
                case 3:
                    showResults();
                    break;
                case 4:
                    System.out.println("Exiting the Online Voting System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    private static void initializeCandidates() {
        candidates.put("Candidate 1", 0);
        candidates.put("Candidate 2", 0);
        candidates.put("Candidate 3", 0);
    }

    private static void displayMenu() {
        System.out.println("\nOnline Voting System Menu:");
        System.out.println("1. View Candidates");
        System.out.println("2. Vote");
        System.out.println("3. View Results");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void showCandidates() {
        System.out.println("\nCandidates:");
        for (String candidate : candidates.keySet()) {
            System.out.println(candidate);
        }
    }

    private static void vote() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nVote for a candidate:");
        showCandidates();
        System.out.print("Enter candidate's name: ");
        String candidateName = scanner.nextLine();

        if (candidates.containsKey(candidateName)) {
            if (!votedUsers.containsKey(candidateName)) {
                candidates.put(candidateName, candidates.get(candidateName) + 1);
                votedUsers.put(candidateName, true);
                System.out.println("Vote cast successfully!");
            } else {
                System.out.println("You have already voted for this candidate.");
            }
        } else {
            System.out.println("Invalid candidate name. Please choose a valid candidate.");
        }
    }

    private static void showResults() {
        System.out.println("\nVoting Results:");
        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }
}
