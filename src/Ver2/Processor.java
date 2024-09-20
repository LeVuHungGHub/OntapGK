package Ver2;
import java.util.*;

public class Processor {
    public static void main(String[] args) {
        StudentList studentList = new StudentList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Them moi sinh vien");
            System.out.println("2. Cap nhap moi sinh vien bang id");
            System.out.println("3. Xoa sinh vien bang ID");
            System.out.println("4. Hien thi tat ca sinh vien");
            System.out.println("5. Tim sinh vien co diem GPA cao nhat");
            System.out.println("6. Hien thi sinh vien co hoc bong");
            System.out.println("7. Hien thi hoc bong cua tat ca sinh vien");
            System.out.println("8. Thoat");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    System.out.println("Nhap ID:");
                    String studentId = scanner.nextLine();
                    System.out.println("Nhap ho va ten:");
                    String studentName = scanner.nextLine();
                    System.out.println("Diem GPA:");
                    float gpa = scanner.nextFloat();
                    scanner.nextLine();
                    System.out.println("Nganh hoc:");
                    String major = scanner.nextLine();
                    Student student = new Student(studentId, studentName, new Date(), gpa, major);
                    studentList.addStudent(student);
                    break;

                case 2:
                    System.out.println("Nhap ID sinh vien can cap nhap:");
                    String idToUpdate = scanner.nextLine();
                    Student studentToUpdate = studentList.findStudentById(idToUpdate);
                    if (studentToUpdate != null) {
                        System.out.println("Nhap diem GPA moi:");
                        float newGpa = scanner.nextFloat();
                        scanner.nextLine();  
                        studentToUpdate.setGpa(newGpa);
                        System.out.println("Thong tin sinh vien da cap nhap:");
                        studentToUpdate.displayInfo();
                    } else {
                        System.out.println("Khong tim thay sinh vien voi ID " + idToUpdate);
                    }
                    break;

                case 3:
                    System.out.println("Nhap Id sinh vien can xoa:");
                    String idToDelete = scanner.nextLine();
                    studentList.deleteStudentById(idToDelete);
                    break;

                case 4:
                    studentList.displayAllStudents();
                    break;

                case 5:
                    Student topStudent = studentList.findTopStudent();
                    if (topStudent != null) {
                        System.out.println("Sinh vien co GPA cao nhat la:");
                        topStudent.displayInfo();
                    } else {
                        System.out.println("Khong tim thay sinh vien nao.");
                    }
                    break;

                case 6:
                    ArrayList<Student> scholarshipStudents = studentList.findScholarshipStudents();
                    if (!scholarshipStudents.isEmpty()) {
                        System.out.println("Cac sinh vien co hoc bong la:");
                        for (Student s : scholarshipStudents) {
                            s.displayInfo();
                        }
                    } else {
                        System.out.println("Khong co sinh vien nao co hoc bong.");
                    }
                    break;

                case 7:
                    double totalTuition = studentList.calculateTuitionOfAllStudents();
                    System.out.println("Tong hoc phi cua tat ca sinh vien la: " + totalTuition);
                    break;

                case 8:
                    System.out.println("Out.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Tuy chon khong hop le.");
            }
        }
    }
}
