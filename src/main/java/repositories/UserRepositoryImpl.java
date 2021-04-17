package repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.mashape.unirest.http.Headers;
import com.mashape.unirest.http.HttpResponse;
import commons.HeaderConstants;
import dto.BaseResponse;
import dto.TokenResponse;
import dto.UserRequest;
import helpers.ReadConfigHelper;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl extends BaseRepository implements  UserRepository
{
    private ReadConfigHelper readConfigHelper;
    ObjectMapper mapper = new ObjectMapper();
    public UserRepositoryImpl(ReadConfigHelper readConfigHelper)
    {

        this.readConfigHelper = readConfigHelper;


    }
    public BaseResponse createUser(UserRequest userRequest) {
        String url = readConfigHelper.readEndPointUrl()+"users";
        HttpResponse<String> response = post(url,getHeaders(),convertObjectToString(userRequest));
        return new BaseResponse(){{
            setStatus(response.getStatus());
        }};
    }

    public BaseResponse getCurrentUser() {
        return null;
    }

    public TokenResponse userLogin(UserRequest userRequest)
    {
        String url = readConfigHelper.readEndPointUrl()+"oauth/token";
        HashMap headers = getHeaders();
        headers.replace(HeaderConstants.CONTENT_TYPE,"application/x-www-form-urlencoded");

        HttpResponse<String> response = post(url,headers,buildFormUncodedBody(userRequest));
        TokenResponse resp = convertToObject(response.getBody(),TokenResponse.class);
        if(resp != null){
            resp.setStatus(response.getStatus());
            return resp;
        }
        return new TokenResponse(){{
            setStatus(response.getStatus());
            setMessage(response.getBody());
        }};

    }

    private String buildFormUncodedBody(UserRequest userRequest)
    {
        return String.format("grant_type=password&username=%s&password=%s",userRequest.getUsername(),userRequest.getPassword());
    }
}
