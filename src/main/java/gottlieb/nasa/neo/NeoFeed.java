package gottlieb.nasa.neo;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.List;

public class NeoFeed {

    @SerializedName("near_earth_objects")
    HashMap<String, List<nearEarthObjects>> nearEarthObjects;

    class nearEarthObjects
    {
        String id;
        String name;
        @SerializedName("nasa_jpl_url")
        String nasaJplUrl;
        @SerializedName("is_potentially_hazardous_asteroid")
        boolean hazardous;
    }

}
