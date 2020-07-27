package by.htp.ahremenko.task32.service;

import by.htp.ahremenko.task32.domain.Tree;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreeServiceTest {

    public Tree root = new Tree(new Integer(7),
            new Tree(new Integer(2),
                    new Tree(new Integer(8)),
                    new Tree(new Integer(4),
                            new Tree(new Integer(6)),
                            new Tree(new Integer(21),
                                    null,
                                    new Tree(new Integer(1))
                            )
                    )
            ),
            new Tree(new Integer(13),
                    null,
                    new Tree(new Integer(12),
                            new Tree(new Integer(24)),
                            new Tree(new Integer(48))
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