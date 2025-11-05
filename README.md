# KARE CGPA Calculator 

# About:
The CGPA Calculator is a simple Java program made to help students calculate their grades and performance easily. It asks for marks in different parts like sessionals, midsem, endsem, practicals, and projects, depending on the subject type. The program then applies the correct weightage to each part and finds the total marks for every subject. It also assigns a grade based on the marks scored and calculates the average CGPA for all subjects. In addition, it checks attendance percentage and gives an attendance grade. This calculator helps students understand their academic progress clearly and saves time in manual calculations.

# programming language used:
Java 

# compiler:
inttelliJ Idea

# working process
- The program starts by asking how many subjects the student has.

Then, it goes through each subject one by one.

For each subject, the program first asks for the subject name.

Next, it asks whether the subject has Endsem Practical and Project — you must answer Yes, No, or Project.

If you answer Yes, the program will first ask for two sessional marks out of 100.

It then converts each sessional mark into a 17.5-mark scale and adds them together for a total of 35 marks.

After that, it checks if the subject has a Midsem exam.

If Midsem = Yes, it collects marks for Midsem, Regular Performance, Endsem Theory, and Endsem Practical.

Each mark is weighted differently (like 10, 5, 35, and 15 marks) and converted into the final score.

If Midsem = No, it only takes Regular Performance, Endsem Theory, and Endsem Practical marks.

If the subject has No Endsem Practical, it calculates using Midsem, Regular Performance, and Endsem Theory only.

If the subject type is Project, it takes marks for three reviews (First, Second, and Final) and averages them based on their weight (25, 25, 50).

For every subject, the total marks are added to find the Total CGPA for that subject.

The program then assigns a Grade Point (S, A, B, C, D, E, or U) based on the score.

After all subjects are processed, it calculates the average CGPA across all subjects.

Finally, it asks for your attendance percentage and gives an Attendance Grade (H, 9, 8, or L).

The output shows each subject’s total marks, grade, and the final average CGPA with the attendance grade.

# Conclusion:
The CGPA Calculator helps students find their overall grades easily. It takes marks for each subject, including sessional, midsem, endsem, practical, and project marks, and calculates the total score based on given weightages. It also gives a grade (like S, A, B, etc.) for each subject and finds the average CGPA for all subjects. Along with that, it checks attendance and gives an attendance grade. Overall, the program makes it simple for students to know their subject-wise performance and total CGPA in one place.
