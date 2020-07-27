package by.htp.ahremenko.task33.service;

import by.htp.ahremenko.task33.domain.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreeServiceTest {

    public TreeNode root = new TreeNode("d",
            new TreeNode("s",
                    new TreeNode("a"),
                    new TreeNode("e",
                            new TreeNode("f"),
                            new TreeNode("m",
                                    null,
                                    new TreeNode("n")
                            )
                    )
            ),
            new TreeNode("g",
                    null,
                    new TreeNode("t",
                            new TreeNode("k"),
                            new TreeNode("r")
                    )
            )
    );
    
    @Test
    public void getTraversalInOrder() {
        String actual = TreeService.getTraversalInOrder(root);
        String expected = "asfemndgktr";
        assertEquals(expected, actual);
    }

    @Test
    public void getTraversalPreOrder() {
        String actual = TreeService.getTraversalPreOrder(root);
        String expected = "dsaefmngtkr";
        assertEquals(expected, actual);
    }

    @Test
    public void getTraversalPostOrder() {
        String actual = TreeService.getTraversalPostOrder(root);
        String expected = "afnmeskrtgd";
        assertEquals(expected, actual);
    }
}