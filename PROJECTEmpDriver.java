import java.util.Scanner;
public class PROJECTEmpDriver {

    public static void main(String[] args) {

        PROJECTEmpService e1 = new PROJECTEmpService();

        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("Welcome to the Employee Management Application");
            System.out.println("1 to add employee data");
            System.out.println("2 to update employee data");
            System.out.println("3 to delete employee data");
            System.out.println("4 to fetch all employee data");
            System.out.println("5 to exit the application");

            System.out.println("Enter your choice:");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    int res = e1.save();
                    if (res != 0) {
                        System.out.println("Data saved successfully");
                    } else {
                        System.out.println("Data not saved");
                    }
                    break;

                case 2:
                    int updateRes = e1.update();
                    if (updateRes != 0) {
                        System.out.println("Data updated successfully");
                    } else {
                        System.out.println("Data not updated");
                    }
                    break;

                case 3:
                    int deleteRes = e1.delete();
                    if (deleteRes != 0) {
                        System.out.println("Data deleted successfully");
                    } else {
                        System.out.println("Data not deleted");
                    }
                    break;

                case 4:
                    e1.fetchAll();
                    break;

                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
