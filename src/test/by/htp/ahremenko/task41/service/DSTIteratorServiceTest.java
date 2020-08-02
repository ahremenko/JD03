package by.htp.ahremenko.task41.service;

import by.htp.ahremenko.common.TreeNode;
import by.htp.ahremenko.task41.BreadthFirstSearchStrategy;
import by.htp.ahremenko.task41.DepthFirstSearchStrategy;
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
public class DSTIteratorServiceTest {
    private DSTIteratorService dSTIteratorService = new DSTIteratorService();

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
    public void handleDFSStrategy() throws IllegalAccessException, InstantiationException {
        DepthFirstSearchStrategy<String> searchStrategy = DepthFirstSearchStrategy.getInstance(DepthFirstSearchStrategy.class);
        String actual = dSTIteratorService.handle(searchStrategy, root);
        String expected = "dsaefmngtkr";
        assertEquals(expected, actual);
    }

    @Test
    public void handleBFSStrategy() throws IllegalAccessException, InstantiationException {
        BreadthFirstSearchStrategy<String> searchStrategy = BreadthFirstSearchStrategy.getInstance(BreadthFirstSearchStrategy.class);
        String actual = dSTIteratorService.handle(searchStrategy, root);
        String expected = "dsgaetfmkrn";
        assertEquals(expected, actual);
    }
}