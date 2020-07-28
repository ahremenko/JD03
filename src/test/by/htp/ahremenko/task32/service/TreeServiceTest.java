package by.htp.ahremenko.task32.service;

import by.htp.ahremenko.task32.domain.Tree;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Тестируем на примере дерева след. вида:
 * .....................
 * ....7................
 * ..|....\.............
 * .2........13.........
 * |..\........\........
 * 8....4.........12....
 * ....|.\.......|...\..
 * ...6...21....24...48.
 * .......\.............
 * ........1............
 * .....................
 */
public class TreeServiceTest {

    private Tree<Integer> root = new Tree<>(7,
            new Tree<>(2,
                    new Tree<>(8),
                    new Tree<>(4,
                            new Tree<>(6),
                            new Tree<>(21,
                                    null,
                                    new Tree<>(1)
                            )
                    )
            ),
            new Tree<>(13,
                    null,
                    new Tree<>(12,
                            new Tree<>(24),
                            new Tree<>(48)
                    )
            )
    );

    @Test
    public void getTreeHeight() {
        Integer actual = TreeService.getTreeHeight(root);
        Integer expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void getTreeHeight2() {
        Integer actual = TreeService.getTreeHeight(root.getLeft().getRight());
        Integer expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void getTreeHeight3() {
        Integer actual = TreeService.getTreeHeight(root.getLeft().getLeft().getLeft());
        Integer expected = 0;
        assertEquals(expected, actual);
    }
}