package by.htp.ahremenko.task42.domain;

import by.htp.ahremenko.task42.Visitable;
import by.htp.ahremenko.task42.Visitor;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class Student implements Visitable {

    private String name;
    private int courseNumber;
    private Map<String, Integer> marks = new HashMap<>();

    @Override
    public void accept(Visitor visitor) {
        visitor.visitStudent(this);
    }
}
