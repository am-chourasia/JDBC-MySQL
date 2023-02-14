import com.tekion.jdbc.Student;
import com.tekion.jdbc.doa.StudentDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("1 to Add Student");
            System.out.println("2 to Delete Student");
            System.out.println("3 to Display Student");
            System.out.println("4 to Exit");
            int choice = Integer.parseInt(br.readLine());
            if (choice == 1) {
                System.out.println("Enter student name: ");
                String name = br.readLine();
                System.out.println("Enter student phoneNo. : ");
                String phone = br.readLine();
                System.out.println("Enter student city: ");
                String city = br.readLine();
                Student student = new Student(name, phone, city);
                if (StudentDAO.insert(student)) {
                    System.out.println("Student Added Successfully");
                } else {
                    System.out.println("Problem inserting the student");
                }
            } else if (choice == 2) {
                System.out.println("Enter student Id to delete: ");
                int id = Integer.parseInt(br.readLine());
                if(StudentDAO.delete(id)) {
                    System.out.println("Student Deleted Successfully.");
                } else {
                    System.out.println("Problem deleting the student");
                }
            } else if (choice == 3) {
                StudentDAO.display();
            } else if (choice == 4) {
                break;
            }
        }


    }
}