public class Book {
 private String title;
 private String author;
 private Student borrower;
 public Book(String title,String author) {
  this.title=title; this.author=author; this.borrower=null;
 }
 public String getTitle() { return title; }
 public String getAuthor() { return author; }
 public Student getBorrower() { return borrower; }
 public String borrowBy(Student student) {
  if(this.borrower!=null)
   return "Sorry, "+this.title+" is already borrowed by "+this.borrower.getName()+".";
  if(student.getBorrowedBook()!=null)
   return "Sorry, "+student.getName()+" has already borrowed a book.";
  this.borrower=student;
  student.setBorrowedBook(this);
  return student.getName()+" with matric number "+student.getMatric()
   +" has borrow a book with title "+this.title+".";
 }
 public String toString() { return title+" ("+author+")"; }
}
