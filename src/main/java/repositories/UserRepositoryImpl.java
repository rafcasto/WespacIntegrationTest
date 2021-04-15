package repositories;

import com.mashape.unirest.http.Headers;
import com.mashape.unirest.http.HttpResponse;
import dto.BaseResponse;
import dto.TokenResponse;
import dto.UserRequest;
import helpers.ReadConfigHelper;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl extends BaseRepository implements  UserRepository
{
    private ReadConfigHelper readConfigHelper = new ReadConfigHelper();

    public BaseResponse createUser(UserRequest userRequest) {
        String url = readConfigHelper.readEndPointUrl()+"users";

        HttpResponse<String> response = post(url,getHeaders(),userRequest);

        return new BaseResponse(){{
            setStatus(response.getStatus());
        }};
    }

    public BaseResponse getCurrentUser() {
        return null;
    }

    public TokenResponse userLogin() {
        return null;
    }

    private HashMap<String,String> getHeaders()
    {
        HashMap<String,String> headers = new HashMap<String,String>();
        headers.put("accept", "*/*");
        headers.put("content-type", "application/json");
        headers.put("cache-control", "no-cache");
        return headers;
    }
}
