import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainMenu extends JFrame implements ActionListener {
 public static ArrayList<Student> studentList = new ArrayList<Student>();
 public static ArrayList<Book> bookList = new ArrayList<Book>();
 private JLabel lblTitle;
 private JButton btnAddStudent, btnAddBook, btnBorrowBook;

 public MainMenu() {
  Container pane = getContentPane();
  pane.setLayout(new GridLayout(4,1,10,10));
  ((JPanel)pane).setBorder(BorderFactory.createEmptyBorder(15,20,15,20));
  lblTitle = new JLabel("~~ BORROW BOOK SYSTEM ~~", JLabel.CENTER);
  btnAddStudent = new JButton("Add Student Info");
  btnAddBook = new JButton("Add Book Info");
  btnBorrowBook = new JButton("Borrow Book");
  btnAddStudent.addActionListener(this);
  btnAddBook.addActionListener(this);
  btnBorrowBook.addActionListener(this);
  pane.add(lblTitle); pane.add(btnAddStudent); pane.add(btnAddBook); pane.add(btnBorrowBook);
  setTitle("Main Menu"); setSize(320,260);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setLocationRelativeTo(null); setVisible(true);
 }
 public void actionPerformed(ActionEvent e) {
  if(e.getSource()==btnAddStudent) new AddStudentGUI();
  else if(e.getSource()==btnAddBook) new AddBookGUI();
  else if(e.getSource()==btnBorrowBook) new BorrowBookGUI();
 }
 public static void main(String[] args) { new MainMenu(); }
}
