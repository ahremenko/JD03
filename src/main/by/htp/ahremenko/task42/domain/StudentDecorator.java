package by.htp.ahremenko.task42.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentDecorator {
    private Student student;

    StudentDecorator(Student student) {
        this.student = student;
    }

    public List<Integer> getMarksAsPercent() {
        Map<String, Integer> marks = student.getMarks();
        return marks.keySet().stream()
                .map(key -> marks.get(key)*10)
                .collect(Collectors.toList());
    }
}
