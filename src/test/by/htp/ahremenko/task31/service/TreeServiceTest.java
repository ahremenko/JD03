package by.htp.ahremenko.task31.service;

import by.htp.ahremenko.task31.domain.Tree;
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

    private Tree root = new Tree(7,
            new Tree(2,
                    new Tree(8),
                    new Tree(4,
                            new Tree(6),
                            new Tree(21,
                                    null,
                                    new Tree(1)
                            )
                    )
            ),
            new Tree(13,
                    null,
                    new Tree(12,
                            new Tree(24),
                            new Tree(48)
                    )
            )
    );

    @Test
    public void calcTreeNodeRecursive() {
        Integer actual = TreeService.getNodeAmountRecursive(root);
        Integer expected = 11;
        assertEquals(expected, actual);
    }

    @Test
    public void calcTreeNodeDeep() {
        Integer actual = TreeService.getNodeAmount(root.getLeft());
        Integer expected = 6;
        assertEquals(expected, actual);
    }
}