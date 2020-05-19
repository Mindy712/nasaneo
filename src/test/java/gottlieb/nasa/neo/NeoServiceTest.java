package gottlieb.nasa.neo;

import org.junit.Test;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class NeoServiceTest {

    @Test
    public void getAsteroids() throws IOException {
        //given
        NeoService service = new NeoServiceFactory().getInstance();

        //when
        NeoFeed feed = service.getAsteroids("2020-04-28", "2020-04-29").execute().body();

        //then
        assertNotNull(feed);

        HashMap<String, List<NeoFeed.nearEarthObjects>> nearEarthObjects = feed.nearEarthObjects;
        assertFalse(nearEarthObjects.isEmpty());

        final NeoFeed.nearEarthObjects nearEarthObjects1 = nearEarthObjects.get("2020-04-28").get(0);
        assertNotNull(nearEarthObjects1.id);
        assertNotNull(nearEarthObjects1.name);
        assertNotNull(nearEarthObjects1.nasaJplUrl);
        assertNotNull(nearEarthObjects1.hazardous);
        List<NeoFeed.CloseApproachData> closeApproachData = nearEarthObjects1.closeApproachData;
        assertNotNull(closeApproachData);
        assertFalse(closeApproachData.isEmpty());
        NeoFeed.CloseApproachData closeApproachData1 = closeApproachData.get(0);
        assertNotNull(closeApproachData1.closeApproachDate);
        assertNotNull(closeApproachData1.missDistance);
        assertTrue(closeApproachData1.missDistance.lunar > 0);
    }

}