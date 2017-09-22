package emissions;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pp on 21.09.17.
 */
@RestController
public class Controller {

    private SocrataApiService socrataApiService = new SocrataApiService();

    @RequestMapping("/emissions")
    public List<Response> getEmissions(@RequestParam(value="department", required = false) String department) {

        List<SocrataApiResponse> socrataApiResponses;

        if(department != null && department.length() > 0){
            socrataApiResponses = this.socrataApiService.getEmissionData(department);
        } else {
            socrataApiResponses = this.socrataApiService.getEmissionData();
        }

        List<Response> responses = new ArrayList<>();
        for(SocrataApiResponse socrataApiResponse : socrataApiResponses){
            if(socrataApiResponse.getEmissions() > 0){
                responses.add(new Response(socrataApiResponse.getDepartment(), socrataApiResponse.getSourceType(), socrataApiResponse.getEmissions()));
            }
        }

        return responses;
    }

}
