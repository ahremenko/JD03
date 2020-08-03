package by.htp.ahremenko.task42.domain;

import by.htp.ahremenko.task42.Visitor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class StudentCourseVisitor implements Visitor {
    @Getter
    private List<Integer> list = new ArrayList<>();

    @Override
    public void visitStudent(Student student) {
        list.add(student.getCourseNumber());
    }
}
