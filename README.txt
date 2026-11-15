BORROW BOOK SYSTEM - JAVA 1.6 / JCREATOR

Files:
MainMenu.java
AddStudentGUI.java
AddBookGUI.java
BorrowBookGUI.java
Student.java
Book.java

IMPORTANT:
This version uses the non-generic JComboBox syntax required by older Java Swing/JDK 1.6:
JComboBox cmbStudent = new JComboBox();
JComboBox cmbBook = new JComboBox();

HOW TO RUN:
1. Keep all six .java files in the same folder.
2. Open the folder/project in JCreator.
3. Compile all six Java files.
4. Run MainMenu.java.

The two unchecked warnings sometimes shown by newer javac versions are related to
using the raw JComboBox API for compatibility with older Java versions. They are
not compilation errors. The files compile successfully with the compiler available
in this environment.
