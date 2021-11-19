/**
 * @Author Bryan Zen 113252725
 * @version 1.0
 * @since 2021-09-07
 */

import java.util.Scanner;

public class LunchLineSimulator {
    private static StudentLine realityA;
    private static StudentLine realityB;

    /**
     * This is the main method where the interface is run. User input determines
     * which case is preformed in the switch case.
     * @param args Unused.
     * @throws DeanException Throws exception when the Capacity of the line has
     * already reached its maximum
     * @throws EmptyLineException Throws exception when the Line is empty.
     */

    public static void main(String[] args) throws DeanException
            , EmptyLineException {
        realityA = new StudentLine();
        realityB = new StudentLine();
        StudentLine thisReality = realityA;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Middle School where you are " +
                "the master of the lunch line, and you may subject " +
                "your angsty kids to whatever form of culinary torture " +
                "best fits your mood. You are in Reality A.\n");
        System.out.println("Menu:\n" +
                "\n" +
                "     A) Add a student to the line at the end\n" +
                "\n" +
                "     C) Have a new student cut a friend\n" +
                "\n" +
                "     T) Have two students trade places\n" +
                "\n" +
                "     B) Have the bully remove a student\n" +
                "\n" +
                "     U) Update a student's money amount\n" +
                "\n" +
                "     S) Serve a student\n" +
                "\n" +
                "     P) Print the current reality's lunch line\n" +
                "\n" +
                "     O) Switch to the other reality\n" +
                "\n" +
                "     E) Check if the realities are equal\n" +
                "\n" +
                "     D) Duplicate this reality into the other reality\n" +
                "\n" +
                "     Q) Quit middle school and move on to real life.");
        boolean x = true;
        while(x == true) {
            System.out.println("\n" + "Please select an option: ");
            char choice = sc.next().charAt(0);
            switch (Character.toUpperCase(choice)) {
                case 'A':
                    System.out.println("Please enter student name: ");
                    sc.nextLine();
                    String nameA = sc.nextLine();
                    System.out.println("Please enter money amount: ");
                    double moneyA = sc.nextDouble();
                    Student studentA = new Student(nameA, moneyA);
                    int position = thisReality.numStudentCount() + 1;
                    thisReality.addStudent(position - 1, studentA);
                    System.out.printf("%s has dashed to the back of the " +
                            "line in position %d. %s checks their wallet " +
                            "to find $%.2f.", nameA, position, nameA, moneyA);
                    break;
                case 'C':
                    System.out.println("Please enter student name: ");
                    sc.nextLine();
                    String nameC = sc.nextLine();
                    System.out.println("Please enter money amount: ");
                    double moneyC = sc.nextDouble();
                    Student studentC = new Student(nameC, moneyC);
                    System.out.println("Please enter position: ");
                    int positionC = sc.nextInt();
                    int skipped = positionC - 1;
                    thisReality.addStudent(skipped, studentC);
                    String skippedName =
                            thisReality.getStudent(positionC).getName();
                    System.out.printf("%s has cut %s in exchange for social " +
                                    "approval and is now in position %d, what a " +
                                    "dork. %s has $%.2f for food."
                            , nameC, skippedName, positionC, nameC, moneyC);
                    break;
                case 'T':
                    System.out.println("Please enter student1 index: ");
                    int student1T = sc.nextInt() - 1;
                    String student1Name =
                            thisReality.getStudent(student1T).getName();
                    System.out.println("Please enter student2 index: ");
                    int student2T = sc.nextInt() - 1;
                    String student2Name =
                            thisReality.getStudent(student2T).getName();
                    thisReality.swapStudents(student1T, student2T);
                    System.out.printf("%s saw their friend and has traded " +
                                    "places with %s to chat with them."
                            , student1Name, student2Name);
                    break;
                case 'B':
                    System.out.println("Please enter student index: ");
                    int studentB = sc.nextInt() - 1;
                    String studentBName =
                            thisReality.getStudent(studentB).getName();
                    thisReality.removeStudent(studentB);
                    System.out.printf("The bully has stolen %s's lunch " +
                            "money, and %s has left the line after wetting " +
                            "their pants. The janitor can be seen cleaning " +
                            "up after them.", studentBName, studentBName);
                    break;
                case 'U':
                    System.out.println("Please enter student index: ");
                    int studentU = sc.nextInt() - 1;
                    String studentUName =
                            thisReality.getStudent(studentU).getName();
                    System.out.println("Please enter new money amount: ");
                    double moneyU = sc.nextDouble();
                    thisReality.getStudent(studentU).setMoney(moneyU);
                    System.out.printf("After kicking the vending machine, " +
                            "%s now has $%.2f.", studentUName, moneyU);
                    break;
                case 'S':
                    String firstStudent =
                            thisReality.getStudent(0).getName();
                    thisReality.removeStudent(0);
                    System.out.printf("%s has been served today's special: " +
                            "Cardboard Pizza and Soggy yet Stale Fries. " +
                            "All apart of the nation effort to keep " +
                            "American kids overweight!", firstStudent);
                    break;
                case 'P':
                    String reality = "";
                    if (thisReality == realityA)
                        reality = "A";
                    if (thisReality == realityB)
                        reality = "B";
                    System.out.printf("Lunch Line in Reality %s: %s"
                            , reality, thisReality.toString());
                    break;
                case 'O':
                    String originalO = "";
                    String newO = "";
                    if (thisReality == realityA) {
                        thisReality = realityB;
                        originalO = "A";
                        newO = "B";
                    }
                    else if (thisReality == realityB) {
                        thisReality = realityA;
                        originalO = "B";
                        newO = "A";
                    }
                    System.out.printf("You, the conscious observer is in " +
                                    "Reality %s. After a quick transfer of " +
                                    "consciousness, you are now in Reality %s."
                            , originalO, newO);
                    break;
                case 'E':
                    String optionE = "";
                    boolean equalE = false;
                    if (thisReality == realityA) {
                        equalE = realityA.equals(realityB);
                    } else if (thisReality == realityB)
                        equalE = realityB.equals(realityA);
                    if (!equalE)
                        optionE = "not equal";
                    else if (equalE) {
                        optionE = "equal";
                    }
                    System.out.printf("The realities are %s.", optionE);
                    break;
                case 'D':
                    String currentRealityD = "";
                    String oppositeRealityD = "";
                    if (thisReality == realityA) {
                        currentRealityD = "A";
                        oppositeRealityD = "B";
                    }
                    if (thisReality == realityB) {
                        currentRealityD = "B";
                        oppositeRealityD = "A";
                    }
                    StudentLine oppositeRealitySD = thisReality.clone();
                    if (thisReality == realityA)
                        realityB = oppositeRealitySD;
                    if (thisReality == realityB)
                        realityA = oppositeRealitySD;
                    System.out.printf("The students of the opposite " +
                                    "line vanish. As you glance to your own line, " +
                                    "the students in your line simultaneously " +
                                    "undergoes mitosis; the replicated beings stand " +
                                    "in the opposite line. Reality %s has been " +
                                    "copied into Reality %s.", currentRealityD,
                            oppositeRealityD);
                    break;
                case 'Q':
                    System.out.println("You are now leaving the Middle " +
                            "School Lunch Line Simulator. We congratulate " +
                            "you on your decision to do something more " +
                            "productive with your time. Anyways, stay tuned " +
                            "for High School Lunch Line Simulator.");
                    x = false;
                    break;
            }
        }
    }
}
