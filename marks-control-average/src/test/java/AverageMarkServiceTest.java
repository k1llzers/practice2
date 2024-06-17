import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AverageMarkServiceTest {
    @Test
    void testCalculateAverage() {
        Student testStudent = new Student("Тестов Тест Тестович");
        testStudent.addMark(new Subject("Тест1", 5.0), 90);
        testStudent.addMark(new Subject("Тест2", 4.0), 98);
        Double actual = AverageMarkService.getAverageMark(testStudent);
        double countOfCredits = testStudent.getSubjectToMarkMap().keySet().stream()
                .mapToDouble(Subject::getCountOfCredits)
                .sum();
        double markCountMultCredits = testStudent.getSubjectToMarkMap().entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getCountOfCredits() * entry.getValue())
                .sum();
        Double expected = markCountMultCredits / countOfCredits;
        assertEquals(expected, actual);
    }
}
