package DataSort;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //private static Node mNode;

    private static ArrayList<Node> mNodeList = new ArrayList<Node>();
    private static Sorter mSorter = new Sorter();

    private static long mSortStartTime;
    private static long mSortEndTime;

    public static void main(String[] args) {
        mNodeList.add(new Node(0, 12));
        mNodeList.add(new Node(1, 11));
        mNodeList.add(new Node(2, 13));
        mNodeList.add(new Node(3, 5));
        mNodeList.add(new Node(4, 6));
        mNodeList.add(new Node(4, 7));

        boolean validUserInput = false;
        while(!validUserInput) {
            System.out.println("[0] Bubble Sort");
            System.out.println("[1] Heap Sort");
            System.out.print("Select Sort Method: ");

            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();
            switch (userInput) {
                case "0":
                    validUserInput = true;
                    System.out.println("\nRunning Bubble Sort");
                    printList(mNodeList);
                    StartTimer();
                    mSorter.bubbleSort(mNodeList);
                    StopTimer();
                    printList(mNodeList);
                    System.out.println("Time Elapsed: " + GetTimeElapsed() + " nanoseconds");
                    break;
                case "1":
                    validUserInput = true;
                    System.out.println("\nRunning Heap Sort");
                    printList(mNodeList);
                    StartTimer();
                    mSorter.heapSort(mNodeList);
                    StopTimer();
                    printList(mNodeList);
                    System.out.println("Time Elapsed: " + GetTimeElapsed() + " nanoseconds");
                    break;
                default:
                    System.out.println("Invalid Input\n");
                    break;
            }
        }
    }

    private static void printList(ArrayList<Node> nodeList) {
        for (int i = 0; i < nodeList.size(); i++) {
            System.out.print(nodeList.get(i).getNodeValue() + " ");
        }
        System.out.print("\n");
    }

    private static void StartTimer(){
        mSortStartTime = System.nanoTime();
    }

    private static void StopTimer(){
        mSortEndTime = System.nanoTime();
    }

    private static long GetTimeElapsed(){
        return mSortEndTime - mSortStartTime;
    }
}
