package ServiceTests;

import com.iotproject.iotservice.service.ReadingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = ReadingService.class)
public class ServiceUnitTests {

    @Autowired
    ReadingService service;

    @Test
    public void testGetLatestReadingByID(){
        long expectedReadingStationID = 1232;
        assertEquals(expectedReadingStationID, service.getLatestReadingByID(1522).getStationId());
    }
}
