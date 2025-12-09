import javax.persistence.*;
import java.util.List;
@Entity
class Enrollment {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;

    private String semester;
    private double grade;
    private String status;

    public Enrollment() {}

    public Enrollment(Student student, Course course, String semester, double grade, String status) {
        this.student = student;
        this.course = course;
        this.semester = semester;
        this.grade = grade;
        this.status = status;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
    public String getSemester() { return semester; }
    public void setSemester(String semester) { this.semester = semester; }
    public double getGrade() { return grade; }
    public void setGrade(double grade) { this.grade = grade; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}