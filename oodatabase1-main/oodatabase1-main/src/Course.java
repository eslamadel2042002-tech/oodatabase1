
import javax.persistence.*;
import java.util.List;
@Entity
class Course {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private int credits;
    private String instructor;
    private String department;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Enrollment> enrollments;

    public Course() {}

    public Course(String title, int credits, String instructor, String department) {
        this.title = title;
        this.credits = credits;
        this.instructor = instructor;
        this.department = department;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public int getCredits() { return credits; }
    public void setCredits(int credits) { this.credits = credits; }
    public String getInstructor() { return instructor; }
    public void setInstructor(String instructor) { this.instructor = instructor; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public List<Enrollment> getEnrollments() { return enrollments; }
    public void setEnrollments(List<Enrollment> enrollments) { this.enrollments = enrollments; }
}
