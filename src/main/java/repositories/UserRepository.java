package repositories;

import dto.BaseResponse;
import dto.TokenResponse;
import dto.UserRequest;

public interface UserRepository
{
    BaseResponse createUser(UserRequest userRequest);
    BaseResponse getCurrentUser();
    TokenResponse userLogin();
}
