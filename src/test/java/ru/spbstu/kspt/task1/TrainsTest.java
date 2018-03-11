import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.spbstu.kspt.task1.Table;
import ru.spbstu.kspt.task1.Train;
import ru.spbstu.kspt.task1.Trains;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.*;

class TrainsTest {

    LinkedHashMap map = new LinkedHashMap() {{
        put("Kupchino", "15000");
        put("Nevsky", "20000");
        put("Gorkovsky", "30000");
        put("Lesnaya", "35000");

    }};
    LinkedHashMap map2 = new LinkedHashMap() {{
        put("Kupchino", "15000");
        put("Nevsky", "20000");
        put("Gorkovsky", "30000");
        put("Lesnaya", "31000");

    }};

    LinkedHashMap map3 = new LinkedHashMap() {{
        put("Kupchino", "15000");
        put("Nevsky", "20000");
        put("Gorkovsky", "30000");
        put("Lesnaya", "36000");

    }};
    LinkedHashMap map4 = new LinkedHashMap() {{
        put("Kupchino", "15000");
        put("Nevsky", "20000");
        put("Gorkovsky", "30000");
        put("Lesnaya", "51000");

    }};


    Table tableResult = new Table(map);
    Table tableResult2 = new Table(map2);
    Table tableResult3 = new Table(map3);
    Table tableResult4 = new Table(map4);

    Train trainResult = new Train("TEST", "DEVYATKINO", tableResult);
    Train trainResult2 = new Train("TEST2", "RYBACKOE", tableResult2);
    Train trainResult3 = new Train("TEST3", "VETERANOV", tableResult3);
    Train trainResult4 = new Train("TEST4", "LENINSKY", tableResult4);
    ArrayList<Train> list = new ArrayList() {{
        add(trainResult);
        add(trainResult2);
        add(trainResult3);
        add(trainResult4);
    }};


    Trains trainsTest = new Trains();
    Trains trainsResult = new Trains(list);
    Train trainTest = new Train();
    Table tableTest = new Table();


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
        tableTest.addObjToTable("Kupchino","15000");
        tableTest.addObjToTable("Nevsky", "20000");
        tableTest.addObjToTable("Gorkovsky", "30000");
        tableTest.addObjToTable("Lesnaya", "35000");

        assertEquals(tableTest, tableResult);
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
        Train finded = trainsResult.searchTrain("50000", "Lesnaya");

        assertEquals(finded, trainResult4);
    }
}
