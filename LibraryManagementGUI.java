import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Book {

    private String title;
    private String author;
    private double price;
    private boolean available;

    public Book(String title, String author, double price) {

        this.title = title;
        this.author = author;
        this.price = price;
        this.available = true;
    }

    public String borrowBook() {

        if (available) {
            available = false;
            return "Book Borrowed Successfully!";
        } else {
            return "Book Already Borrowed!";
        }
    }

    public String returnBook() {

        available = true;
        return "Book Returned Successfully!";
    }

    public String displayBook() {

        return "===== BOOK DETAILS =====\n\n" +
                "Title       : " + title + "\n" +
                "Author      : " + author + "\n" +
                "Price       : ₹" + price + "\n" +
                "Availability: " + (available ? "Available" : "Borrowed");
    }
}

public class LibraryManagementGUI extends JFrame implements ActionListener {

    JLabel titleLabel, authorLabel, priceLabel;

    JTextField titleField, authorField, priceField;

    JButton createButton, borrowButton, returnButton, displayButton;

    JTextArea resultArea;

    Book book;

    public LibraryManagementGUI() {

        setTitle("Library Management System");
        setSize(550, 550);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(new Color(240, 248, 255));

        JLabel heading = new JLabel("LIBRARY MANAGEMENT SYSTEM");
        heading.setFont(new Font("Arial", Font.BOLD, 22));
        heading.setBounds(80, 20, 400, 30);
        add(heading);

        titleLabel = new JLabel("Book Title:");
        titleLabel.setBounds(50, 90, 100, 25);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(titleLabel);

        titleField = new JTextField();
        titleField.setBounds(180, 90, 250, 30);
        add(titleField);

        authorLabel = new JLabel("Author:");
        authorLabel.setBounds(50, 140, 100, 25);
        authorLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(authorLabel);

        authorField = new JTextField();
        authorField.setBounds(180, 140, 250, 30);
        add(authorField);

        priceLabel = new JLabel("Price:");
        priceLabel.setBounds(50, 190, 100, 25);
        priceLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(priceLabel);

        priceField = new JTextField();
        priceField.setBounds(180, 190, 250, 30);
        add(priceField);

        createButton = new JButton("Create Book");
        createButton.setBounds(50, 260, 150, 40);
        createButton.addActionListener(this);
        add(createButton);

        borrowButton = new JButton("Borrow Book");
        borrowButton.setBounds(230, 260, 150, 40);
        borrowButton.addActionListener(this);
        add(borrowButton);

        returnButton = new JButton("Return Book");
        returnButton.setBounds(50, 320, 150, 40);
        returnButton.addActionListener(this);
        add(returnButton);

        displayButton = new JButton("Display Book");
        displayButton.setBounds(230, 320, 150, 40);
        displayButton.addActionListener(this);
        add(displayButton);

        resultArea = new JTextArea();
        resultArea.setBounds(50, 390, 380, 100);
        resultArea.setFont(new Font("Monospaced", Font.BOLD, 15));
        resultArea.setEditable(false);
        add(resultArea);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            if (e.getSource() == createButton) {

                String title = titleField.getText();
                String author = authorField.getText();
                double price = Double.parseDouble(priceField.getText());

                book = new Book(title, author, price);

                resultArea.setText("Book Created Successfully!");
            }
            else if (e.getSource() == borrowButton) {

                if (book != null) {
                    resultArea.setText(book.borrowBook());
                } else {
                    resultArea.setText("Please Create a Book First!");
                }
            }
            else if (e.getSource() == returnButton) {

                if (book != null) {
                    resultArea.setText(book.returnBook());
                } else {
                    resultArea.setText("Please Create a Book First!");
                }
            }

            else if (e.getSource() == displayButton) {

                if (book != null) {
                    resultArea.setText(book.displayBook());
                } else {
                    resultArea.setText("Please Create a Book First!");
                }
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(this,
                    "Please Enter Valid Details!");
        }
    }

    public static void main(String[] args) {

        new LibraryManagementGUI();
    }
}