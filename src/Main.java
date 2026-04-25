import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RecordManager manager = new RecordManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Student Record Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student Grade");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice;
            try { choice = Integer.parseInt(sc.nextLine().trim()); }
            catch (NumberFormatException e) { System.out.println("Invalid input."); continue; }

            try {
                switch (choice) {
                    case 1:
                        System.out.print("ID: ");
                        int id = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Name: ");
                        String name = sc.nextLine().trim();
                        System.out.print("Age: ");
                        int age = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Grade (A/B/C/D/F): ");
                        String grade = sc.nextLine().trim();
                        manager.addStudent(new Student(id, name, age, grade));
                        break;
                    case 2: manager.displayAll(); break;
                    case 3:
                        System.out.print("Enter ID to search: ");
                        manager.searchById(Integer.parseInt(sc.nextLine().trim()));
                        break;
                    case 4:
                        System.out.print("Enter ID: ");
                        int uid = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("New Grade: ");
                        String ng = sc.nextLine().trim();
                        manager.updateGrade(uid, ng);
                        break;
                    case 5:
                        System.out.print("Enter ID to delete: ");
                        manager.deleteStudent(Integer.parseInt(sc.nextLine().trim()));
                        break;
                    case 6:
                        System.out.println("Goodbye!");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (StudentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number entered.");
            }
        }
    }
}
