import java.util.Scanner;

public class CGPA {
    public static double calculateCGPA(Scanner sc, int T){
        double totalSum = 0;

        for(int i=0; i<T; i++){
            System.out.println("Enter Subject  Name" + ":");
            String subjects = sc.next();

            System.out.println("Enter Yes if " + subjects + " has EndsemPractical and " + subjects + " has Project else enter No:");
            String endpractical = sc.next();

            if (endpractical.equalsIgnoreCase("Yes")){
                //Sessional Marks
                double average_sessional = 0;
                for (int j = 0; j < 2; j++) {
                    System.out.println("Enter subject " + (j + 1) + " marks for " + subjects + " out of 100" + ":");
                    double se = sc.nextDouble();
                    double sessional_marks = se / 100 * 17.5;
                    average_sessional += sessional_marks;
                }
                System.out.println("Total Sessional Marks out of 35: " + average_sessional);

                //Midsem Check
                System.out.println("Enter Yes if " + subjects + " has midsem else enter No:");
                String midsem_check = sc.next();

                if (midsem_check.equalsIgnoreCase("Yes")){
                    //Midsem Marks
                    double[] marks = new double[4];
                    String[] prompts = {"Midsem", "Regular Performance", "Endsem Theoretical", "Endsem Practical"};
                    double[] weights = {10, 5, 35, 15};

                    for(int n = 0; n < 4; n++) {
                        System.out.println("Enter " + prompts[n] + " marks for " + subjects + " out of 100:");
                        marks[n] = sc.nextDouble() / 100 * weights[n];
                    }
                    
                    double midsem_marks = marks[0];
                    double regular_performance = marks[1];
                    double endsem_theory_marks = marks[2];
                    double endsem_practical_marks = marks[3];

                    //Total CGPA calculation
                    double subjectTotal = average_sessional + midsem_marks + regular_performance + endsem_theory_marks + endsem_practical_marks;
                    System.out.println("Total CGPA for " + subjects + " is: " + subjectTotal);
                    totalSum += subjectTotal;

                    Gradepoint(subjectTotal);
                    attendence(attendance_percentage);

                }else if (midsem_check.equalsIgnoreCase("no")){
                    double[] marks = new double[3];
                    String[] prompts = {"overall Regular Performance", "Endsem Theoretical", "Endsem Practical"};
                    double[] weights = {15, 35, 15};

                    for (int b = 0; b < 3; b++) {
                        System.out.println("Enter " + prompts[b] + " marks for " + subjects + " out of 100:");
                        marks[b] = sc.nextDouble() / 100 * weights[b];
                    }

                    double regular_performance = marks[0];
                    double endsem_theory_marks = marks[1];
                    double endsem_practical_marks = marks[2];

                    //Total CGPA calculation
                    double subjectTotal = average_sessional + regular_performance + endsem_theory_marks + endsem_practical_marks;
                    System.out.println("Total CGPA for " + subjects + " is: " + subjectTotal);
                    totalSum += subjectTotal;

                    Gradepoint(subjectTotal);
                    attendence(attendance_percentage);

                } else {
                    System.out.println("Invallid input try again!");
                }

            }else if (endpractical.equalsIgnoreCase("No")){
                //Sessional Marks
                double average_sessional = 0;
                for (int j = 0; j < 2; j++) {
                    System.out.println("Enter subject " + (j + 1) + " marks for " + subjects + " out of 100" + ":");
                    double se = sc.nextDouble();
                    double sessional_marks = se / 100 * 17.5;
                    average_sessional += sessional_marks;
                }
                System.out.println("Total Sessional Marks out of 35: " + average_sessional);

                // Midsem marks
                double[] marks = new double[3];
                String[] prompts = {"Midsem", "Regular Performance", "Endsem Theoretical"};
                double[] weights = {10, 5, 50};
                for (int l = 0; l < 3; l++) {
                    System.out.println("Enter " + prompts[l] + " marks for " + subjects + " out of 100:");
                    marks[l] = sc.nextDouble() / 100 * weights[l];
                }
                double midsem_marks = marks[0];
                double regular_performance = marks[1];
                double endsem_theory_marks = marks[2];
                
                //Total CGPA calculation
                double subjectTotal = average_sessional + midsem_marks + regular_performance + endsem_theory_marks;
                System.out.println("Total CGPA for " + subjects + " is: " + subjectTotal);
                totalSum += subjectTotal;

                Gradepoint(subjectTotal);
                attendence(attendance_percentage);

            }else if (endpractical.equalsIgnoreCase("Project")){
                //review marks
                double[] reviews = new double[3];
                String[] prompts = {"First Review", "Second Review", "Final Review"};
                double[] weights = {25, 25, 50};

                for (int a = 0; a < 3; a++) {
                    System.out.println("Enter " + prompts[a] + " marks for " + subjects + " out of 100:");
                    reviews[a] = sc.nextDouble() / 100 * weights[a];
                }
                double first_review = reviews[0];
                double second_review = reviews[1];
                double final_review = reviews[2];

                //Total CGPA calculation
                double subjectTotal = first_review + second_review + final_review;
                System.out.println("Total CGPA for " + subjects + " is: " + subjectTotal);
                totalSum += subjectTotal;

                Gradepoint(subjectTotal);
                attendence(attendance_percentage);

            }else{
                System.out.println("Invalid Input");
            }
        }
        return totalSum / T;
    }

    public static String Gradepoint(double Grade){
        String Gradepoint;
        if (Grade >= 90)
            Gradepoint = "S";
        else if (Grade >= 80)
            Gradepoint = "A";
        else if (Grade >= 70)
            Gradepoint = "B";
        else if (Grade >= 60)
            Gradepoint = "C";
        else if (Grade >= 50)
            Gradepoint = "D";
        else if (Grade >= 40)
            Gradepoint = "E";
        else
            Gradepoint = "U";
        System.out.println("Grade Point is: " + Gradepoint);
        return Gradepoint;
    }
    public static String attendence(double attendance_percentage){
        String attendance;
        if (attendance_percentage >= 90)
            attendance = "H";
        else if (attendance_percentage >= 88)
            attendance = "9";
        else if (attendance_percentage >= 80)
            attendance = "8";
        else
            attendance = "L";
        System.out.println("Attendance Grade is: " + attendance);
        return attendance;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Subjects:");
        int T = sc.nextInt();
        sc.nextLine();

        double average = calculateCGPA(sc, T);
        System.out.println("Average CGPA of all subjects is: " + average);

        System.out.println("Enter your attendance percentage for " + subjects + ":");
        double attendance_percentage = sc.nextDouble();
        attendence(attendance_percentage);
        sc.close();       
    }
}