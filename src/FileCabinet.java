import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class FileCabinet {

    Stack stack = new Stack();

    public static void main(String[] args) {
        FileCabinet fileCabApp = new FileCabinet();
        fileCabApp.startApp();
    }

    public void startApp () {
        // Create frame
        JFrame frame = new JFrame("File Cabinet");
        frame.setLayout(new GridLayout(10, 1));
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Create Labels and text fields
        JLabel nameLabel = new JLabel("name");
        JTextField name = new JTextField();

        JLabel emailLabel = new JLabel("email");
        JTextField email = new JTextField();

        JLabel phoneNumberLabel = new JLabel("phone number");
        JTextField phoneNumber = new JTextField();

        JLabel homeAddressLabel = new JLabel("home address");
        JTextField homeAddress = new JTextField();

        // Buttons
        JButton addButton = new JButton("Add To Cabinet");
        JButton removeButton = new JButton("Remove Last File");
        JButton viewLastButton = new JButton("View Last File");

        // Add to frame
        frame.add(nameLabel);
        frame.add(name);
        frame.add(emailLabel);
        frame.add(email);
        frame.add(phoneNumberLabel);
        frame.add(phoneNumber);
        frame.add(homeAddressLabel);
        frame.add(homeAddress);
        frame.add(addButton);
        frame.add(removeButton);
        frame.add(viewLastButton);

        // Set frame visibility to true
        frame.setVisible(true);

        // Add Button Functionalities
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check that all fields are not empty
                if (
                        name.getText().isBlank() ||
                        email.getText().isBlank() ||
                        phoneNumber.getText().isBlank() ||
                        homeAddress.getText().isBlank()
                ) {
                    JOptionPane.showMessageDialog(null, "No field should be empty. Don't you want this job");
                    return;
                }
                // write code here
                String[] userFile = {name.getText(), email.getText(), phoneNumber.getText(), homeAddress.getText()};
                stack.push(userFile);

                // empty input fields
                name.setText(""); email.setText(""); phoneNumber.setText(""); homeAddress.setText("");
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // write code here
                String[] removedFile = stack.pop();
                if (removedFile != null) {
                    JOptionPane.showMessageDialog(null, Arrays.toString(removedFile));
                } else {
                    JOptionPane.showMessageDialog(null, "This File Cabinet is Empty!");
                }
            }
        });

        viewLastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // write code here
                String[] lastFile = stack.peek();
                if (lastFile != null) {
                    JOptionPane.showMessageDialog(null, Arrays.toString(lastFile));
                } else {
                    JOptionPane.showMessageDialog(null, "This File Cabinet is Empty!");
                }
            }
        });
    }
}
