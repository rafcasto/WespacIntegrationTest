package repositories;

import com.mashape.unirest.http.Headers;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.body.Body;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.HeaderConstants;
import dto.BaseResponse;
import dto.TokenResponse;
import dto.UserRequest;

import java.util.HashMap;


public class BaseRepository
{
    private ObjectMapper mapper = new ObjectMapper();


    public HttpResponse<String> post(String url,HashMap headers, String requestBody)
    {
        HttpResponse<String> response = null;
        try
        {
            response =  Unirest.post(url)
                     .headers(headers)
                    .body(requestBody)
                    .asString();
        }
        catch (Exception ex)
        {

        }
        return response;
    }

    public <T> T convertToObject(String json, Class<T> t1){
        try
        {
            return (T) mapper.readValue( json,t1);
        }catch (Exception ex){
            System.out.println(ex.getStackTrace());
        }
        return null;
    }

    public String convertObjectToString(Object userRequest)
    {
        String jsonString = null;
        try
        {
             jsonString = mapper.writeValueAsString(userRequest);

        }catch (Exception ex)
        {
            jsonString = "";
        }
        return jsonString;
    }

    public HashMap<String,String> getHeaders()
    {
        HashMap<String,String> headers = new HashMap<String,String>();
        headers.put(HeaderConstants.ACCEPT, "*/*");
        headers.put(HeaderConstants.CONTENT_TYPE, "application/json");
        headers.put(HeaderConstants.CACHE_CONTROL, "no-cache");
        return headers;
    }



}
