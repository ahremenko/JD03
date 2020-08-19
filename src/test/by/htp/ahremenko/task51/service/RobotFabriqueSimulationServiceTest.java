package by.htp.ahremenko.task51.service;

import by.htp.ahremenko.task51.domain.BodyPart;
import by.htp.ahremenko.task51.domain.HardwarePart;
import by.htp.ahremenko.task51.domain.BodyType;
import by.htp.ahremenko.task51.domain.HardwareType;
import by.htp.ahremenko.task51.domain.Robot;

import junit.framework.TestCase;

public class RobotFabriqueSimulationServiceTest extends TestCase {

    public void testMakeRobotOK() {
        Robot robot = new Robot();
        robot.addPart(new BodyPart(BodyType.HEAD));
        robot.addPart(new BodyPart(BodyType.BODY));
        robot.addPart(new BodyPart(BodyType.LEFT_HAND));
        robot.addPart(new BodyPart(BodyType.RIGHT_HAND));
        robot.addPart(new BodyPart(BodyType.LEFT_FOOT));
        robot.addPart(new BodyPart(BodyType.RIGHT_FOOT));
        robot.addPart(new HardwarePart(HardwareType.CPU));
        robot.addPart(new HardwarePart(HardwareType.HDD));
        robot.addPart(new HardwarePart(HardwareType.RAM));
        boolean actual = robot.isReady();
        assertEquals(true, actual);
    }

    public void testMakeRobotFail() {
        Robot robot = new Robot();
        robot.addPart(new BodyPart(BodyType.HEAD));
        boolean actual = robot.isReady();
        assertEquals(false, actual);
    }

    public void testMakeRobotFailDoubleParts() {
        Robot robot = new Robot();
        robot.addPart(new BodyPart(BodyType.HEAD));
        boolean actual = robot.isPartSuitable(new BodyPart(BodyType.HEAD));
        assertEquals(false, actual);
    }

    public void testHandle() {
        Integer actual = RobotFabriqueSimulationService.handle();
        System.out.println("actual = " + actual);
        assertNotNull(actual);
    }
}