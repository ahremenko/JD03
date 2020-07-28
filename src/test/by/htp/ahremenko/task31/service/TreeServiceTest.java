package by.htp.ahremenko.task31.service;

import by.htp.ahremenko.task31.domain.Tree;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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