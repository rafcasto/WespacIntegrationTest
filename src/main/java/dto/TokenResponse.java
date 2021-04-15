package dto;

public class TokenResponse extends BaseResponse
{
    private String access_token;
    private String token_type;
    private String Bearer;
    private int expires_in;

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }


    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getBearer() {
        return Bearer;
    }

    public void setBearer(String bearer) {
        Bearer = bearer;
    }


}
