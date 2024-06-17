import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Student {
    @NonNull
    private String pib;
    private Map<Subject, Integer> subjectToMarkMap = new HashMap<>();

    public void addMark(Subject subject, Integer mark) {
        if (mark < 1 || mark > 100) throw new IllegalArgumentException("Mark can`t be less than 1 or greater than 100");
        subjectToMarkMap.put(subject, mark);
    }
}
