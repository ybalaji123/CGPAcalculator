
import java.util.Scanner;

class CGPA {
    private static String Gradepoint(double Grade){
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
    private static String attendence(double attendance_percentage){
        String attendance;
        if (attendance_percentage >= 95)
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
    private static double calculateCGPA(Scanner sc, int T){
        double totalSum = 0;

        for(int i=0; i<T; i++){
            System.out.println("Enter Subject  Name" + ":");
            String subjects = sc.next();

            System.out.println("Enter if "+ subjects + " has Endsem Practical (Yes/No/Project/online/NPTEL):");
            String endpractical = sc.next();

            if (endpractical.equalsIgnoreCase("Yes")){
                //Sessional Marks
                double average_sessional = 0;
                for (int j = 0; j < 2; j++) {
                    System.out.println("Enter sessional " + (j + 1) + " marks for " + subjects + " out of 100" + ":");
                    double se = sc.nextDouble();
                    double sessional_marks = se / 100 * 17.5;
                    average_sessional += sessional_marks;
                }
                System.out.println("Total Sessional Marks out of 35: " + average_sessional);

                //Midsem Check
                System.out.println("Enter Yes if " + subjects + " has midsem elesif (direct) else enter No:");
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
                    //Total CGPA calculation
                    double subjectTotal = average_sessional + marks[0] + marks[1] + marks[2] + marks[3];
                    System.out.println("Total CGPA for " + subjects + " is: " + subjectTotal);
                    totalSum += subjectTotal;

                    Gradepoint(subjectTotal);


                }else if (midsem_check.equalsIgnoreCase("no")){
                    double[] marks = new double[3];
                    String[] prompts = {"overall Regular Performance", "Endsem Theoretical", "Endsem Practical"};
                    double[] weights = {15, 35, 15};

                    for (int b = 0; b < 3; b++) {
                        System.out.println("Enter " + prompts[b] + " marks for " + subjects + " out of 100:");
                        marks[b] = sc.nextDouble() / 100 * weights[b];
                    }
                    //Total CGPA calculation
                    double subjectTotal = average_sessional + marks[0] + marks[1] + marks[2];
                    System.out.println("Total CGPA for " + subjects + " is: " + subjectTotal);
                    totalSum += subjectTotal;

                    Gradepoint(subjectTotal);

                } else {
                    System.out.println("Invallid input try again!");
                }

            }else if (endpractical.equalsIgnoreCase("No")){
                //Sessional Marks
                double average_sessional = 0;
                for (int j = 0; j < 2; j++) {
                    System.out.println("Enter sessional " + (j + 1) + " marks for " + subjects + " out of 100" + ":");
                    double se = sc.nextDouble();
                    double sessional_marks = se / 100 * 17.5;
                    average_sessional += sessional_marks;
                }
                System.out.println("Total Sessional Marks out of 35: " + average_sessional);

                // Midsem marks
                double[] marks = new double[2];
                String[] prompts = {"assessment", "performace marks"};
                double[] weights = {15, 50};
                for (int l = 0; l < 2; l++) {
                    System.out.println("Enter " + prompts[l] + " marks for " + subjects + " out of 100:");
                    marks[l] = sc.nextDouble() / 100 * weights[l];
                }
                //Total CGPA calculation
                double subjectTotal = average_sessional + marks[0] + marks[1];
                System.out.println("Total CGPA for " + subjects + " is: " + subjectTotal);
                totalSum += subjectTotal;

                Gradepoint(subjectTotal);

            }else if (endpractical.equalsIgnoreCase("Project")){
                //review marks
                double[] reviews = new double[3];
                String[] prompts = {"First Review", "Second Review", "Final Review"};
                double[] weights = {25, 25, 50};

                for (int a = 0; a < 3; a++) {
                    System.out.println("Enter " + prompts[a] + " marks for " + subjects + " out of 100:");
                    reviews[a] = sc.nextDouble() / 100 * weights[a];
                }
                //Total CGPA calculation
                double subjectTotal = reviews[0] + reviews[1] + reviews[2];
                System.out.println("Total CGPA for " + subjects + " is: " + subjectTotal);
                totalSum += subjectTotal;

                Gradepoint(subjectTotal);

            }else if (endpractical.equalsIgnoreCase("online")){
                double[] internals = new double[5];
                String[] prompts = {"Internal marks", "Regular Laboratory Performance", "Mid Sem Practical", "Quiz", "Mini Project"};
                double[] weights = {20, 20, 15, 15, 30};

                for (int r = 0; r < internals.length; r++) {
                    System.out.println("Enter " + prompts[r] + " marks out of 100:");
                    double mark = sc.nextDouble();
                    internals[r] = mark / 100.0 * weights[r];
                    System.out.println("average marks:" + internals[r]);
                }
                double subjectTotal = internals[0] + internals[1] + internals[2] + internals[3] + internals[4];
                System.out.println("Average marks: " + subjectTotal);
                totalSum += subjectTotal;

                Gradepoint(subjectTotal);

            }else if(endpractical.equalsIgnoreCase("NPTEL")){

                double[] nptel = new double[2];
                String[] prompts = {"assignment marks", "NPTEL Exam"};
                double[] weights = {25, 75};
                double[] vlaues = {0.25, 0.75};
                for (int z = 0; z < nptel.length; z++) {
                    System.out.println("Enter " + prompts[z] + " out of 100:");
                    double mark = sc.nextDouble();
                    double converstion = (mark / vlaues[z]);
                    nptel[z] = (converstion) / 100 * weights[z];
                    System.out.println(nptel[z]);
                }
                double subjectTotal = nptel[0] + nptel[1];
                System.out.println("Overall average is: " + subjectTotal);
                totalSum += subjectTotal;

                Gradepoint(subjectTotal);

            }else{
                System.out.println("Invalid Input");
            }
        }
        return totalSum / T;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Subjects:");
        int T = sc.nextInt();
        sc.nextLine();
//
//        System.out.println("Enter your attendance percentage for " + ":");
//        double attendance_percentage = sc.nextDouble();

        double average = calculateCGPA(sc, T);
        System.out.println("Your overall CGPA is: " + average);
        sc.close();
    }
}