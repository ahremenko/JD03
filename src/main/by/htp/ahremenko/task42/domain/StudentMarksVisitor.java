package by.htp.ahremenko.task42.domain;

import by.htp.ahremenko.task42.Visitor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class StudentMarksVisitor implements Visitor<Student> {
    @Getter
    private List<Integer> list = new ArrayList<>();

    @Override
    public void visitStudent(Student student) {
        list.addAll(student.getMarks().values());
    }
}
