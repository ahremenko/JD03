package by.htp.ahremenko.task51.service;

import by.htp.ahremenko.task51.domain.Fabrique;
import by.htp.ahremenko.task51.domain.Assistant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 5.1 Фабрика роботов
 * Двое безумных учёных устроили соревнование, кто из них соберёт больше роботов за 100 ночей.
 *
 * Для этого каждую ночь каждый из них отправляет своего прислужника на свалку фабрики роботов за деталями. Чтобы собрать одного робота им нужно:
 *
 * Голова, Тело, Левая рука, Правая рука, Левая нога, Правая, Нога, CPU, RAM, HDD.
 *
 * В первую ночь на свалке находится 20 случайных деталей.
 *
 * Каждую ночь фабрика выбрасывает на свалку от 1 до 4 случайных деталей.
 *
 * В то же самое время прислужники обоих учёных отправляются на свалку, и каждый собирает от 1 до 4 случайных деталей. Если на свалке деталей нет – прислужник уходит ни с чем. Затем они возвращаются домой и отдают детали хозяевам.
 *
 * Учёные пытаются собрать как можно больше роботов из деталей, которые они получили.
 *
 *
 *
 * Задача - Написать программу, симулирующую этот процесс. Для симуляции принять, что каждая ночь наступает через 100мс. Фабрика и два прислужника действуют в одно и то же время.
 *
 * После 100 ночей (около 10 секунд) определить победителя соревнования.
 *
 * Примечание: при решение данной задачи использовать только стандартные средства языка (нельзя использовать классы из пакета java.util.concurrent).7
 */
public class RobotFabriqueSimulationService {

    public static final int MAX_GENERATED_PARTS = 4;
    public static final int MAX_PERIODS = 100;
    public static final int INITIAL_PARTS = 20;
    public static final int NIGHT_DURATION_MS = 100;

    public static String handle() {
        Fabrique fabrique = Fabrique.getInstance();

        Assistant assistant1 = new Assistant("Vasya");  // just for debug
        Assistant assistant2 = new Assistant("Lena");
        fabrique.setAssistants(new ArrayList<>(List.of(assistant1,assistant2)));
        try {
            Thread fabriqueThread = new Thread(fabrique);
            fabriqueThread.start();
            fabriqueThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (assistant1.getAmountFinishedRobots() > assistant2.getAmountFinishedRobots()) {
            return assistant1.getAssistantName() + "(" + assistant1.getAmountFinishedRobots() + ">" + assistant2.getAmountFinishedRobots() + ")";
        } else if (assistant1.getAmountFinishedRobots() < assistant2.getAmountFinishedRobots()) {
            return assistant2.getAssistantName() + "(" + assistant2.getAmountFinishedRobots() + ">" + assistant1.getAmountFinishedRobots() + ")";
        }
        return "No WINNER!";
    }
}
