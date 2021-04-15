package repositories;

import com.mashape.unirest.http.Headers;
import com.mashape.unirest.http.HttpResponse;
import dto.BaseResponse;
import dto.TokenResponse;
import dto.UserRequest;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl extends BaseRepository implements  UserRepository
{

    public BaseResponse createUser(UserRequest userRequest) {
        String url = "https://k51qryqov3.execute-api.ap-southeast-2.amazonaws.com/prod/users";
        HashMap<String,String> headers = new HashMap<String,String>();
        headers.put("accept", "*/*");
        headers.put("content-type", "application/json");
        headers.put("cache-control", "no-cache");
        HttpResponse<String> response = post(url,headers,userRequest);

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
}
