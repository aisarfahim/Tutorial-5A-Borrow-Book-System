import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddStudentGUI extends JFrame implements ActionListener {
 private JLabel lblName,lblMatric,lblStudents;
 private JTextField txtName,txtMatric;
 private JButton btnAdd,btnList;
 private JTextArea txtAreaStudents;

 public AddStudentGUI() {
  Container pane=getContentPane();
  pane.setLayout(new BorderLayout(10,10));
  ((JPanel)pane).setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
  JPanel pnlForm=new JPanel(new GridLayout(2,2,10,8));
  lblName=new JLabel("Name:"); txtName=new JTextField(20);
  lblMatric=new JLabel("Matric:"); txtMatric=new JTextField(20);
  pnlForm.add(lblName); pnlForm.add(txtName); pnlForm.add(lblMatric); pnlForm.add(txtMatric);
  JPanel pnlButtons=new JPanel(new FlowLayout(FlowLayout.CENTER,10,5));
  btnAdd=new JButton("Add"); btnList=new JButton("List");
  btnAdd.addActionListener(this); btnList.addActionListener(this);
  pnlButtons.add(btnAdd); pnlButtons.add(btnList);
  JPanel pnlTop=new JPanel(new BorderLayout(5,5));
  pnlTop.add(pnlForm,BorderLayout.CENTER); pnlTop.add(pnlButtons,BorderLayout.SOUTH);
  JPanel pnlBottom=new JPanel(new BorderLayout(5,5));
  lblStudents=new JLabel("Students:"); txtAreaStudents=new JTextArea(6,30);
  txtAreaStudents.setEditable(false);
  JScrollPane scrollPane=new JScrollPane(txtAreaStudents);
  pnlBottom.add(lblStudents,BorderLayout.NORTH); pnlBottom.add(scrollPane,BorderLayout.CENTER);
  pane.add(pnlTop,BorderLayout.NORTH); pane.add(pnlBottom,BorderLayout.CENTER);
  setTitle("Add Student Info"); setSize(450,300);
  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  setLocationRelativeTo(null); setVisible(true);
 }
 public void actionPerformed(ActionEvent e) {
  if(e.getSource()==btnAdd) {
   String name=txtName.getText().trim(), matric=txtMatric.getText().trim();
   if(!name.isEmpty() && !matric.isEmpty()) {
    MainMenu.studentList.add(new Student(name,matric));
    txtName.setText(""); txtMatric.setText("");
   } else JOptionPane.showMessageDialog(this,"Please enter name and matric number.");
  } else if(e.getSource()==btnList) {
   txtAreaStudents.setText("");
   for(Student s:MainMenu.studentList) txtAreaStudents.append("Name : "+s.toString()+"\n");
  }
 }
}
