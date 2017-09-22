package emissions;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by pp on 22.09.17.
 */
public class SocrataApiServiceTest {

    private SocrataApiService socrataApiService;

    @Before
    public void prepare(){
        this.socrataApiService = new SocrataApiService();
    }

    @Test
    public void test(){
        List<SocrataApiResponse> responses = this.socrataApiService.getEmissionData();
        Assert.assertFalse(responses.isEmpty());
    }

    @Test
    public void testWithFilter() throws IOException {
        List<SocrataApiResponse> responses = this.socrataApiService.getEmissionData("311 Customer Service Center");

        for(SocrataApiResponse response : responses){
            Assert.assertEquals("311 Customer Service Center", response.getDepartment());
        }
    }
}
