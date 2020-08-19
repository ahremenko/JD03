package by.htp.ahremenko.task51.domain;

import by.htp.ahremenko.task51.service.RobotFabriqueSimulationService;
import lombok.Getter;

import java.util.*;

public class Fabrique implements Runnable {

    private static volatile Fabrique instance;

    private List<Part> allParts = new ArrayList<>();
    private Random random = new Random();
    private volatile Queue<Part> enabledParts = new LinkedList<>();

    @Getter
    private List<Assistant> assistants = new ArrayList<>();

    {
        BodyType[] bodyPartTypes = BodyType.values();
        for (int i = 0; i < bodyPartTypes.length; i++) {
            allParts.add(new BodyPart(bodyPartTypes[i]));
        }
        HardwareType[] hardwareTypes = HardwareType.values();
        for (int i = 0; i < hardwareTypes.length; i++) {
            allParts.add(new HardwarePart(hardwareTypes[i]));
        }
        enabledParts.addAll(generateParts(RobotFabriqueSimulationService.INITIAL_PARTS));
    }

    public static Fabrique getInstance() {
        Fabrique localInstance = instance;
        if (localInstance == null) {
            synchronized (Fabrique.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Fabrique();
                }
            }
        }

        return localInstance;
    }

    public List<Part> generateParts(Integer amountToGenerate) {
        int amount = amountToGenerate == null ? random.nextInt(RobotFabriqueSimulationService.MAX_GENERATED_PARTS) + 1 : amountToGenerate;
        List<Part> result = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            result.add(getRandomPart());
        }
        System.out.println("Fabrique generates " + result.size() + " parts.");
        return result;
    }

    private Part getRandomPart() {
        return allParts.get(random.nextInt(allParts.size()));
    }

    public synchronized List<Part> gatherParts(int count) {
        List<Part> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(enabledParts.remove());
        }
        return result;
    }

    @Override
    public void run() {
        //Random random = new Random();
        for (int i = 0; i < RobotFabriqueSimulationService.MAX_PERIODS; i++) {
            System.out.println("i=" + i);
            enabledParts.addAll(generateParts(null));
            sleep(100L);
        }
    }

    private void sleep(long ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
