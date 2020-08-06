package by.htp.ahremenko.task42.service;

import by.htp.ahremenko.common.TreeNode;
import by.htp.ahremenko.task41.BSTIterator;
import by.htp.ahremenko.task41.Strategy;
import by.htp.ahremenko.task42.domain.Student;
import by.htp.ahremenko.task42.domain.StudentCourseVisitor;
import by.htp.ahremenko.task42.domain.StudentMarksAsPercentVisitor;
import by.htp.ahremenko.task42.domain.StudentMarksVisitor;

import java.util.List;

public class TreeIteratorService {

    public List<Integer> handleMaxCourse(Strategy<Student> strategy, TreeNode<Student> root) {
        BSTIterator<Student> iterator = new BSTIterator<>(strategy, root);
        StudentCourseVisitor studentCourseVisitor = new StudentCourseVisitor();
        iterator.forEachRemaining( elem -> studentCourseVisitor.visitStudent(elem));
        return studentCourseVisitor.getList();
    }

    public List<Integer> handleAllMark(Strategy<Student> strategy, TreeNode<Student> root) {
        BSTIterator<Student> iterator = new BSTIterator<>(strategy, root);
        StudentMarksVisitor studentMarksVisitor = new StudentMarksVisitor();
        iterator.forEachRemaining( elem -> studentMarksVisitor.visitStudent(elem));
        return studentMarksVisitor.getList();
    }

    public List<Integer> handleAllMarkAsPercent(Strategy<Student> strategy, TreeNode<Student> root) {
        BSTIterator<Student> iterator = new BSTIterator<>(strategy, root);
        StudentMarksAsPercentVisitor studentMarksAsPercentVisitor = new StudentMarksAsPercentVisitor();
        iterator.forEachRemaining( elem -> studentMarksAsPercentVisitor.visitStudent(elem));
        return studentMarksAsPercentVisitor.getList();
    }

}
