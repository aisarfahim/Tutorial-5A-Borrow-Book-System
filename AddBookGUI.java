import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddBookGUI extends JFrame implements ActionListener {
 private JLabel lblTitle,lblAuthor,lblBooks;
 private JTextField txtTitle,txtAuthor;
 private JButton btnAdd,btnList;
 private JTextArea txtAreaBooks;

 public AddBookGUI() {
  Container pane=getContentPane();
  pane.setLayout(new BorderLayout(10,10));
  ((JPanel)pane).setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
  JPanel pnlForm=new JPanel(new GridLayout(2,2,10,8));
  lblTitle=new JLabel("Book Title:"); txtTitle=new JTextField(20);
  lblAuthor=new JLabel("Author:"); txtAuthor=new JTextField(20);
  pnlForm.add(lblTitle); pnlForm.add(txtTitle); pnlForm.add(lblAuthor); pnlForm.add(txtAuthor);
  JPanel pnlButtons=new JPanel(new FlowLayout(FlowLayout.CENTER,10,5));
  btnAdd=new JButton("Add"); btnList=new JButton("List");
  btnAdd.addActionListener(this); btnList.addActionListener(this);
  pnlButtons.add(btnAdd); pnlButtons.add(btnList);
  JPanel pnlTop=new JPanel(new BorderLayout(5,5));
  pnlTop.add(pnlForm,BorderLayout.CENTER); pnlTop.add(pnlButtons,BorderLayout.SOUTH);
  JPanel pnlBottom=new JPanel(new BorderLayout(5,5));
  lblBooks=new JLabel("Books:"); txtAreaBooks=new JTextArea(6,30);
  txtAreaBooks.setEditable(false);
  JScrollPane scrollPane=new JScrollPane(txtAreaBooks);
  pnlBottom.add(lblBooks,BorderLayout.NORTH); pnlBottom.add(scrollPane,BorderLayout.CENTER);
  pane.add(pnlTop,BorderLayout.NORTH); pane.add(pnlBottom,BorderLayout.CENTER);
  setTitle("Add Book Info"); setSize(450,300);
  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  setLocationRelativeTo(null); setVisible(true);
 }
 public void actionPerformed(ActionEvent e) {
  if(e.getSource()==btnAdd) {
   String title=txtTitle.getText().trim(), author=txtAuthor.getText().trim();
   if(!title.isEmpty() && !author.isEmpty()) {
    MainMenu.bookList.add(new Book(title,author));
    txtTitle.setText(""); txtAuthor.setText("");
   } else JOptionPane.showMessageDialog(this,"Please enter book title and author.");
  } else if(e.getSource()==btnList) {
   txtAreaBooks.setText("");
   for(Book b:MainMenu.bookList)
    txtAreaBooks.append("Book title : "+b.getTitle()+" (Author : "+b.getAuthor()+")\n");
  }
 }
}
