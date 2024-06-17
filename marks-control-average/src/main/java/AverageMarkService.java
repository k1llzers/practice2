import java.io.BufferedReader;
import java.io.FileReader;

public class AverageMarkService {
    public static Double getAverageMark(Student student) {
        double countOfCredits = student.getSubjectToMarkMap().keySet().stream()
                .mapToDouble(Subject::getCountOfCredits)
                .sum();
        double markCountMultCredits = student.getSubjectToMarkMap().entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getCountOfCredits() * entry.getValue())
                .sum();
        return markCountMultCredits / countOfCredits;
    }

    public static boolean isScholarship(Student student) {
        Double averageMark = getAverageMark(student);
        return getMinMarkForScholarship() <= averageMark;
    }

    private static double getMinMarkForScholarship() {
        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\Users\\Sasha\\university_projects\\Automation java\\marks-control\\marks-control-average\\src\\main\\resources\\minMarkForScholarship.txt"))) {
            return Integer.parseInt(reader.readLine());
        } catch (Exception ex) {
            return 0;
        }
    }
}
