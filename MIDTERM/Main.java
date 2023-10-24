import java.util.Scanner;

class Student {
   private String firstName;
   private String middleName;
   private String lastName;
   private String suffix;
   
   public Student() {
      this.firstName = "";
      this.middleName = "";
      this.lastName = "";
      this.suffix = "";
   }
   
   public String getFirstName() {
      return firstName;
   }
   
   public String getMiddleName() {
      return middleName;
   }
   
   public String getLastName() {
      return lastName;
   }

   public String getSuffix() {
      return suffix;
   }

   public String getFullName() {
      StringBuilder fullName = new StringBuilder(firstName + "" + middleName + "" + lastName);
      if(!suffix.isEmpty()) {
         fullName.append(" ").append(suffix);
      }
      return fullName.toString(); 
   }
   
   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }
   
   public void setMiddleName(String middleName) {
      this.middleName = middleName;
   }
   
   public void setLastName(String lastName) {
      this.lastName = lastName;
   }
   
   public void setSuffix(String suffix) {
      this.suffix = suffix;
   }   
}

class StudentInterface {
   private Student student;
   
   public StudentInterface() {
      this.student = new Student();
   }
   
   public void inputDetails() {
      Scanner scanner = new Scanner(System.in);
      System.out.print("First Name: ");
      student.setFirstName(scanner.nextLine());

      System.out.print("Middle Name: ");
      student.setMiddleName(scanner.nextLine());

      System.out.print("Last Name: ");
      student.setLastName(scanner.nextLine());
      
      System.out.print("Suffix: ");
      student.setSuffix(scanner.nextLine());
   }
   
   public void displayDetails() {
   System.out.print("First Name: " + student.getFirstName());
   System.out.print("\nMiddle Name: " + student.getMiddleName());
   System.out.print("\nLast Name: " + student.getLastName());
   System.out.print("\nSuffix: " + student.getSuffix());
   System.out.print("\nFull Name: " + student.getFullName());
   }
}

public class Main {
   public static void main(String[] args) {
      StudentInterface studentInterface = new StudentInterface();
      studentInterface.inputDetails();
      studentInterface.displayDetails();
   }
}