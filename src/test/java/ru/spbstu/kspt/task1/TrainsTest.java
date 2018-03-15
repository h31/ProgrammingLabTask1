import org.junit.jupiter.api.Test;
import ru.spbstu.kspt.task1.TimeTable;
import ru.spbstu.kspt.task1.Train;
import ru.spbstu.kspt.task1.Trains;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.*;

class TrainsTest {

    LinkedHashMap map = new LinkedHashMap() {{
        put("Kupchino", 15000);
        put("Nevsky", 20000);
        put("Gorkovsky", 30000);
        put("Lesnaya", 35000);

    }};
    LinkedHashMap map2 = new LinkedHashMap() {{
        put("Kupchino", 15000);
        put("Nevsky", 20000);
        put("Gorkovsky", 30000);
        put("Lesnaya", 31000);

    }};

    LinkedHashMap map3 = new LinkedHashMap() {{
        put("Kupchino", 15000);
        put("Nevsky", 20000);
        put("Gorkovsky", 30000);
        put("Lesnaya", 36000);

    }};
    LinkedHashMap map4 = new LinkedHashMap() {{
        put("Kupchino", 15000);
        put("Nevsky", 20000);
        put("Gorkovsky", 30000);
        put("Lesnaya", 51000);

    }};


    TimeTable timeTableResult = new TimeTable(map);
    TimeTable timeTableResult2 = new TimeTable(map2);
    TimeTable timeTableResult3 = new TimeTable(map3);
    TimeTable timeTableResult4 = new TimeTable(map4);

    Train trainResult = new Train("TEST", "DEVYATKINO", timeTableResult);
    Train trainResult2 = new Train("TEST2", "RYBACKOE", timeTableResult2);
    Train trainResult3 = new Train("TEST3", "VETERANOV", timeTableResult3);
    Train trainResult4 = new Train("TEST4", "LENINSKY", timeTableResult4);
    ArrayList<Train> list = new ArrayList() {{
        add(trainResult);
        add(trainResult2);
        add(trainResult3);
        add(trainResult4);
    }};


    Trains trainsTest = new Trains();
    Trains trainsResult = new Trains(list);
    Train trainTest = new Train();
    TimeTable timeTableTest = new TimeTable();


    @Test
    void setName() {
        trainTest.setName("TEST");
        assertEquals(trainTest.getName(), trainResult.getName());
    }

    @Test
    void setTerminal() {
        trainTest.setTerminal("DEVYATKINO");
        assertEquals(trainTest.getTerminal(), trainResult.getTerminal());
    }

    @Test
    void setTable() {
        timeTableTest.addStringToTable("Kupchino",15000);
        timeTableTest.addStringToTable("Nevsky", 20000);
        timeTableTest.addStringToTable("Gorkovsky", 30000);
        timeTableTest.addStringToTable("Lesnaya", 35000);

        assertEquals(timeTableTest, timeTableResult);
    }

    @Test
    void addTrain() {
        trainsTest.addTrain(trainResult);
        trainsTest.addTrain(trainResult2);
        trainsTest.addTrain(trainResult3);
        trainsTest.addTrain(trainResult4);
        assertEquals(trainsTest, trainsResult);
    }

    @Test
    void deleteTrain() {
        trainsTest.addTrain(trainResult);
        trainsTest.addTrain(trainResult2);
        trainsTest.addTrain(trainResult3);
        trainsTest.addTrain(trainResult4);
        trainsTest.addTrain(trainResult4);
        trainsTest.deleteTrain(trainsTest.size() - 1);

        assertEquals(trainsTest, trainsResult);
    }

    @Test
    void searchTrain() {
        Train finded = trainsResult.searchTrain(50000, "Lesnaya");

        assertEquals(finded, trainResult4);
    }
}
