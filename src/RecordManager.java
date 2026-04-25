import java.sql.SQLException;
import java.util.List;

public class RecordManager {

    public void addStudent(Student s) throws StudentException {
        try {
            if (DatabaseHandler.studentExists(s.getId()))
                throw new StudentException("Student ID " + s.getId() + " already exists.");
            DatabaseHandler.insertStudent(s);
            System.out.println("Student added successfully.");
        } catch (SQLException e) {
            throw new StudentException("Database error: " + e.getMessage());
        }
    }

    public void displayAll() throws StudentException {
        try {
            List<Student> students = DatabaseHandler.getAllStudents();
            if (students.isEmpty()) { System.out.println("No records found."); return; }
            System.out.println("\n--- All Students ---");
            for (Student s : students) System.out.println(s);
        } catch (SQLException e) {
            throw new StudentException("Database error: " + e.getMessage());
        }
    }

    public void searchById(int id) throws StudentException {
        try {
            for (Student s : DatabaseHandler.getAllStudents()) {
                if (s.getId() == id) { System.out.println("Found: " + s); return; }
            }
            System.out.println("No student found with ID: " + id);
        } catch (SQLException e) {
            throw new StudentException("Database error: " + e.getMessage());
        }
    }

    public void updateGrade(int id, String grade) throws StudentException {
        try {
            if (!DatabaseHandler.studentExists(id))
                throw new StudentException("Student ID " + id + " not found.");
            DatabaseHandler.updateGrade(id, grade);
            System.out.println("Grade updated successfully.");
        } catch (SQLException e) {
            throw new StudentException("Database error: " + e.getMessage());
        }
    }

    public void deleteStudent(int id) throws StudentException {
        try {
            if (!DatabaseHandler.studentExists(id))
                throw new StudentException("Student ID " + id + " not found.");
            DatabaseHandler.deleteStudent(id);
            System.out.println("Student deleted successfully.");
        } catch (SQLException e) {
            throw new StudentException("Database error: " + e.getMessage());
        }
    }
}
