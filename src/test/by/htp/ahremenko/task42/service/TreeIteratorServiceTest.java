package by.htp.ahremenko.task42.service;

import by.htp.ahremenko.common.TreeNode;
import by.htp.ahremenko.task41.DepthFirstSearchStrategy;
import by.htp.ahremenko.task42.domain.Student;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

/**
 * Тестируем на примере дерева след. вида:
 * .................................................................................................................
 * ............................Ivan,1,{a:7}.............................................................
 * ..........................|............\...............................................................
 * ................Peter,2,{a:9,b:10}...........Helen,2,{a:7,b:8}.......................................
 * ................|..............\..........................\....................................
 * .Mark,3,{a:10,b:3,c:7}....Mira,3,{a:5,b:3,c:7}.......Andrew,3,{a:9,b:8,c:6,d:7}.................
 * ...............|.................................................................................................
 * ......Alex,4,{a:6,b:7,c:4,d:3,e:8}..................................................................
 * .................................................................................................................
 */
public class TreeIteratorServiceTest {

    private TreeIteratorService treeIteratorService = new TreeIteratorService();

    private TreeNode<Student> root = new TreeNode(new Student("Ivan",1, new HashMap<String,Integer>(){{put("a",7);}}),
            new TreeNode<>(new Student("Peter",2, new HashMap<String,Integer>(){{put("a",9);put("b",10);}}),
                    new TreeNode<>(new Student("Mark",3, new HashMap<String,Integer>(){{put("a",10);put("b",3);put("c",7);}}),
                            new TreeNode<>(new Student("Alex",4, new HashMap<String,Integer>(){{put("a",6);put("b",7);put("c",4);put("d",3);put("e",8);}})),
                            null
                    ),
                    new TreeNode<>(new Student("Mira",3, new HashMap<String,Integer>(){{put("a",5);put("b",3);put("c",7);}}))
            ),
            new TreeNode<>(new Student("Helen",2, new HashMap<String,Integer>(){{put("a",7);put("b",8);}}),
                    null,
                    new TreeNode<>(new Student("Andrew",3, new HashMap<String,Integer>(){{put("a",9);put("b",8);put("c",6);put("d",7);}}))
            )
    );

    @Test
    public void handleMaxCourse() throws IllegalAccessException, InstantiationException {
        DepthFirstSearchStrategy<Student> searchStrategy = DepthFirstSearchStrategy.getInstance(DepthFirstSearchStrategy.class);
        List<Integer> allCourses = treeIteratorService.handleMaxCourse(searchStrategy, root);
        Integer actual = allCourses
                .stream()
                .mapToInt(v -> v)
                .max().orElseThrow(NoSuchElementException::new);
        Integer expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void handleAllMark() throws IllegalAccessException, InstantiationException {
        DepthFirstSearchStrategy<Student> searchStrategy = DepthFirstSearchStrategy.getInstance(DepthFirstSearchStrategy.class);
        List<Integer> actualList = treeIteratorService.handleAllMark(searchStrategy, root);
        List<Integer> expectedList = Arrays.asList(7,9,10,10,3,7,6,7,4,3,8,5,3,7,7,8,9,8,6,7);
        assertEquals(expectedList, actualList);
    }
}