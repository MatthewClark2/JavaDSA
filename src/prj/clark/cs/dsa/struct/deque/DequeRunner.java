package prj.clark.cs.dsa.struct.deque;

import java.util.Scanner;

public class DequeRunner {
    public static void main(String[] args) {
        Deque<String> deque = new DoublyLinkedListDeque<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("How many items will you add?");
        int count = Integer.parseInt(sc.nextLine());

        while (count > 0) {
            System.out.println("Push to the left or right? (l/r)");
            String response = sc.nextLine();
            if (response.equalsIgnoreCase("l")) {
                deque.pushLeft(sc.nextLine());
            } else if (response.equalsIgnoreCase("r")) {
                deque.pushRight(sc.nextLine());
            } else {
                System.out.println("Unrecognized option.");
            }

            count--;
        }

        System.out.println("From left to right, you entered:");
        deque.forEach(System.out::println);
    }
}
