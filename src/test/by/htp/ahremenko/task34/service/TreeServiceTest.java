package by.htp.ahremenko.task34.service;

import by.htp.ahremenko.task34.domain.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Тестируем на примере дерева след. вида:
 * ..................
 * ....d.............
 * ..|....\..........
 * .s........g.......
 * |..\........\.....
 * a....e........t...
 * ....|.\......|.\..
 * ...f...m....k...r.
 * .......\..........
 * ........n.........
 * ..................
 */
public class TreeServiceTest {

    private TreeNode<String> root = new TreeNode("d",
            new TreeNode<>("s",
                    new TreeNode<>("a"),
                    new TreeNode<>("e",
                            new TreeNode<>("f"),
                            new TreeNode<>("m",
                                    null,
                                    new TreeNode<>("n")
                            )
                    )
            ),
            new TreeNode<>("g",
                    null,
                    new TreeNode<>("t",
                            new TreeNode<>("k"),
                            new TreeNode<>("r")
                    )
            )
    );

    @Test
    public void getBreadthFirstSearch() {
        String actual = TreeService.getBreadthFirstSearch(root);
        String expected = "dsgaetfmkrn";
        assertEquals(expected, actual);
    }

    @Test
    public void getBreadthFirstSearch2() {
        String actual = TreeService.getBreadthFirstSearch(root.getRight().getRight().getRight());
        String expected = "r";
        assertEquals(expected, actual);
    }

    @Test
    public void getBreadthFirstSearchNull() {
        String actual = TreeService.getBreadthFirstSearch(null);
        String expected = "";
        assertEquals(expected, actual);
    }
}