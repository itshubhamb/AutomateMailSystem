import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Email {
    private String sender;
    private String subject;
    private String message;

    public Email(String sender, String subject, String message) {
        this.sender = sender;
        this.subject = subject;
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }
}

class Mailbox {
    private String owner;
    private List<Email> emails;

    public Mailbox(String owner) {
        this.owner = owner;
        emails = new ArrayList<>();
    }

    public void receiveEmail(Email email) {
        emails.add(email);
        System.out.println("New email received!");
        System.out.println("From: " + email.getSender());
        System.out.println("Subject: " + email.getSubject());
        System.out.println("Message: " + email.getMessage());
        System.out.println("---------------------------");
    }

    public void viewEmails() {
        if (emails.isEmpty()) {
            System.out.println("No emails found in the mailbox.");
        } else {
            System.out.println("--- Emails in Mailbox ---");
            for (Email email : emails) {
                System.out.println("From: " + email.getSender());
                System.out.println("Subject: " + email.getSubject());
                System.out.println("Message: " + email.getMessage());
                System.out.println("---------------------------");
            }
        }
    }
}

public class mailsystems {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String owner = scanner.nextLine();

        Mailbox mailbox = new Mailbox(owner);

        while (true) {
            System.out.println("\n==== Automated Mail System ====");
            System.out.println("1. Receive Email");
            System.out.println("2. View Emails");
            System.out.println("3. Exit");
            System.out.println("....................................");

            System.out.print("Enter your choice (1-3): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: {
                    System.out.print("Enter sender's email address: ");
                    String sender = scanner.nextLine();

                    System.out.print("Enter email subject: ");
                    String subject = scanner.nextLine();

                    System.out.print("Enter email message: ");
                    String message = scanner.nextLine();

                    Email email = new Email(sender, subject, message);
                    mailbox.receiveEmail(email);
                    break;
                }
                case 2:
                    mailbox.viewEmails();
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

