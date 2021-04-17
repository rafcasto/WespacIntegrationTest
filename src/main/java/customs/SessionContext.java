package customs;

import dto.UserRequest;
import io.cucumber.java8.En;
import repositories.UserRepository;

public class SessionContext implements En {
    public UserRequest userRequest;
    public UserRepository userRepository;
    public SessionContext(UserRequest userRequest, UserRepository userRepository)
    {
        this.userRequest = userRequest;
        this.userRepository = userRepository;
    }
}
