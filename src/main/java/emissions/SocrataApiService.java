package emissions;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * This service queries the Socrata Open Data API (SODA) for information about CO2 emissions of public buildings in
 * San Francisco. See https://dev.socrata.com/foundry/data.sfgov.org/y2ju-xyjc for details.
 *
 * Created by pp on 22.09.17.
 */
public class SocrataApiService {

    // Access without APP_TOKEN is possible, but limited, see https://dev.socrata.com/foundry/data.sfgov.org/y2ju-xyjc
    private static final String APP_TOKEN = "";
    private static final String BASE_URL = "https://data.sfgov.org/resource/y2ju-xyjc.json";

    /**
     * @return A list of {@link SocrataApiResponse}s. An empty list if no data is found.
     */
    public List<SocrataApiResponse> getEmissionData(){
        return this.getEmissionData(null);
    }

    /**
     *
     * @param departmentFilter If present, only data for the specified department will be returned.
     * @return A list of {@link SocrataApiResponse}s. An empty list if no data is found.
     */
    public List<SocrataApiResponse> getEmissionData(String departmentFilter){

        try {

            URL url;
            if(departmentFilter != null && departmentFilter.length() > 0){
                url = new URL(BASE_URL + "?department=" + URLEncoder.encode(departmentFilter, "UTF-8"));
            } else {
                url  = new URL(BASE_URL);
            }

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("X-App-Token", APP_TOKEN);

            BufferedReader inputStreamReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = inputStreamReader.readLine()) != null) {
                response.append(line);
            }
            inputStreamReader.close();

            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(response.toString(), new TypeReference<List<SocrataApiResponse>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

}
