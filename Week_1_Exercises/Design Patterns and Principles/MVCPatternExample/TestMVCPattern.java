package MVCPatternExample;

public class TestMVCPattern {
 public static void main(String[] args) {

     Student student = new Student("101", "Student1", "C");

     StudentView view = new StudentView();

     StudentController controller = new StudentController(student, view);

     controller.updateView();

     controller.setStudentName("Student2");
     controller.setStudentGrade("A");

     controller.updateView();
 }
}

