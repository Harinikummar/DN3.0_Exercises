package MVCPatternExample;

public class StudentView {
 public void displayStudentDetails(String studentName, String studentId, String studentGrade) {
     System.out.println("Student Details:");
     System.out.println("Students's ID: " + studentId);
     System.out.println("Student's Name: " + studentName);
     System.out.println("Student's Grade: " + studentGrade);
     System.out.println();
 }
}
