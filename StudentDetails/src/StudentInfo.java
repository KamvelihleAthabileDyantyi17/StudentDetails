import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentInfo {

    public Container panel;
    private JLabel studentNoLabel;
    private JLabel assignmentLabel;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel mark1Label;
    private JLabel mark2Label;
    private JLabel examMarkLabel;
    private JLabel dpMarkLabel;
    private JButton calculateButton;
    private JTextField textField1;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextArea resultArea;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JButton selectGenderButton;
    private String Male, Female;
    private JTextArea displayGenderTextArea;

    public StudentInfo() {
        JFrame frame = new JFrame("Student Information");
        panel = frame.getContentPane();
        panel.setLayout(new GridLayout(10, 2));

        // Initialize components
        nameLabel = new JLabel("Name:");
        textField4 = new JTextField();
        surnameLabel = new JLabel("Surname:");
        textField5 = new JTextField();
        assignmentLabel = new JLabel("Assignment Mark:");
        textField6 = new JTextField();
        examMarkLabel = new JLabel("Exam Mark:");
        textField7 = new JTextField();
        resultArea = new JTextArea(5, 20);

        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        selectGenderButton = new JButton("Select Gender");
        displayGenderTextArea = new JTextArea(1, 20);

        calculateButton = new JButton("Calculate");

        // Add components to the panel
        panel.add(nameLabel);
        panel.add(textField4);
        panel.add(surnameLabel);
        panel.add(textField5);
        panel.add(assignmentLabel);
        panel.add(textField6);
        panel.add(examMarkLabel);
        panel.add(textField7);
        panel.add(maleRadioButton);
        panel.add(femaleRadioButton);
        panel.add(selectGenderButton);
        panel.add(displayGenderTextArea);
        panel.add(calculateButton);
        panel.add(new JScrollPane(resultArea));

        // Calculate button action listener
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Parse input values
                    String name = textField4.getText();
                    String surname = textField5.getText();
                    double assignment = Double.parseDouble(textField6.getText());
                    double examMark = Double.parseDouble(textField7.getText());

                    // Calculate DP Mark (40% Assignment, 60% Exam)
                    double dpMark = (assignment * 0.40) + (examMark * 0.60);

                    // Determine the result classification
                    String classification;
                    if (dpMark <= 46) {
                        classification = "Fail";
                    } else if (dpMark >= 47 && dpMark <= 49) {
                        classification = "Supp";
                    } else if (dpMark >= 50 && dpMark <= 74) {
                        classification = "Pass";
                    } else {
                        classification = "Distinction";
                    }

                    // Display the result in resultArea
                    resultArea.setText("Student: " + name + " " + surname + "\n"
                            + "DP Mark: " + dpMark + "\n"
                            + "Result: " + classification);
                } catch (NumberFormatException ex) {
                    // Error handling for invalid input
                    resultArea.setText("Please enter valid numbers for marks.");
                }
            }
        });

        // Gender selection action listener
        selectGenderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (maleRadioButton.isSelected()){
                    Male = "Male is selected";
                    displayGenderTextArea.setText(Male);
                } else if (femaleRadioButton.isSelected()) {
                    Female = "Female is selected";
                    displayGenderTextArea.setText(Female);
                }
            }
        });

        // Frame settings
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new StudentInfo();
    }
}
