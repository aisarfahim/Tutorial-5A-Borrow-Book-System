import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BorrowBookGUI extends JFrame implements ActionListener {
 private JLabel lblStudent,lblBook,lblInfoHeader,lblInfoResult;
 private JComboBox cmbStudent;
 private JComboBox cmbBook;
 private JButton btnBorrow;

 public BorrowBookGUI() {
  Container pane=getContentPane();
  pane.setLayout(new BorderLayout(10,10));
  ((JPanel)pane).setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
  JPanel pnlSelect=new JPanel(new GridLayout(2,2,10,8));
  lblStudent=new JLabel("Student Name & Matric:");
  cmbStudent=new JComboBox();
  for(Student s:MainMenu.studentList) cmbStudent.addItem(s);
  lblBook=new JLabel("Book Title & Author:");
  cmbBook=new JComboBox();
  for(Book b:MainMenu.bookList) cmbBook.addItem(b);
  pnlSelect.add(lblStudent); pnlSelect.add(cmbStudent);
  pnlSelect.add(lblBook); pnlSelect.add(cmbBook);
  JPanel pnlButton=new JPanel(new FlowLayout(FlowLayout.CENTER));
  btnBorrow=new JButton("Borrow"); btnBorrow.addActionListener(this); pnlButton.add(btnBorrow);
  JPanel pnlTop=new JPanel(new BorderLayout(5,10));
  pnlTop.add(pnlSelect,BorderLayout.CENTER); pnlTop.add(pnlButton,BorderLayout.SOUTH);
  JPanel pnlBottom=new JPanel(new GridLayout(2,1,5,5));
  lblInfoHeader=new JLabel("Borrow Information :"); lblInfoResult=new JLabel(" ");
  pnlBottom.add(lblInfoHeader); pnlBottom.add(lblInfoResult);
  pane.add(pnlTop,BorderLayout.NORTH); pane.add(pnlBottom,BorderLayout.SOUTH);
  setTitle("Borrow Book"); setSize(520,280);
  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  setLocationRelativeTo(null); setVisible(true);
 }
 public void actionPerformed(ActionEvent e) {
  if(e.getSource()==btnBorrow) {
   Student selectedStudent=(Student)cmbStudent.getSelectedItem();
   Book selectedBook=(Book)cmbBook.getSelectedItem();
   if(selectedStudent!=null && selectedBook!=null) {
    String message=selectedBook.borrowBy(selectedStudent);
    lblInfoResult.setText(message);
   } else JOptionPane.showMessageDialog(this,"Please add student and book information first.");
  }
 }
}
