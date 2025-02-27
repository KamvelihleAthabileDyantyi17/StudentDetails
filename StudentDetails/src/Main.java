import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Create a JFrame for the Student Information form
        JFrame frame = new JFrame("Student Information");

        // Create an instance of the StudentInfo class
        StudentInfo studentInfo = new StudentInfo();
        frame.setContentPane(studentInfo.panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
