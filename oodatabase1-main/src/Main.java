import javax.persistence.*;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            // Create a unique database file or use the existing one
            emf = Persistence.createEntityManagerFactory("objectdb:unique_test.odb");
            em = emf.createEntityManager();

            // Create entities
            em.getTransaction().begin();
            Student student1 = new Student("Alice", 20, "alice@example.com", "123 Main St");
            Student student2 = new Student("Bob", 22, "bob@example.com", "456 Elm St");

            Course course1 = new Course("Math", 4, "Dr. Smith", "Science");
            Course course2 = new Course("History", 3, "Prof. Johnson", "Arts");

            Enrollment enrollment1 = new Enrollment(student1, course1, "Fall 2024", 90.5, "Completed");
            Enrollment enrollment2 = new Enrollment(student1, course2, "Fall 2024", 88.0, "Completed");
            Enrollment enrollment3 = new Enrollment(student2, course1, "Fall 2024", 92.0, "Completed");

            em.persist(student1);
            em.persist(student2);
            em.persist(course1);
            em.persist(course2);
            em.persist(enrollment1);
            em.persist(enrollment2);
            em.persist(enrollment3);
            em.getTransaction().commit();

            // Query entities
            System.out.println("\nAll Students:");
            List<Student> students = em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
            for (Student s : students) {
                System.out.println(s.getName() + " (Age: " + s.getAge() + ", Email: " + s.getEmail() + ", Address: " + s.getAddress() + ")");
            }

            System.out.println("\nEnrollments for Alice:");
            List<Enrollment> enrollments = em.createQuery("SELECT e FROM Enrollment e WHERE e.student.name = :name", Enrollment.class)
                                             .setParameter("name", "Alice")
                                             .getResultList();
            for (Enrollment e : enrollments) {
                System.out.println(e.getCourse().getTitle() + " (Grade: " + e.getGrade() + ", Status: " + e.getStatus() + ")");
            }

        } catch (PersistenceException e) {
            System.err.println("Database error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
}