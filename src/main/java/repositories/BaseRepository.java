package repositories;

import com.mashape.unirest.http.Headers;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.body.Body;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;


public class BaseRepository
{



    public HttpResponse<String> post(String url,HashMap headers, Object requestBody)
    {
        HttpResponse<String> response = null;
        try
        {
            //Creating the ObjectMapper object
            ObjectMapper mapper = new ObjectMapper();
            //Converting the Object to JSONString
            String jsonString = mapper.writeValueAsString(requestBody);
            response =  Unirest.post(url)
                     .headers(headers)
                    .body(jsonString)
                    .asString();
        }
        catch (Exception ex)
        {

        }
        return response;
    }

}
