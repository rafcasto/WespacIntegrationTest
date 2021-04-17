package customs;


import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.UserRequest;
import helpers.ReadConfigHelper;
import io.cucumber.core.backend.ObjectFactory;
import io.cucumber.picocontainer.PicoFactory;
import repositories.UserRepositoryImpl;

public class CustomPicoFactory implements ObjectFactory
{
    private PicoFactory delegate = new PicoFactory();
    public CustomPicoFactory()
    {
        addClass(ReadConfigHelper.class);
        addClass(UserRepositoryImpl.class);
        addClass(UserRequest.class);
        addClass(SessionContext.class);

    }
    @Override
    public void start() {
        delegate.start();
    }

    @Override
    public void stop() {
        delegate.stop();
    }

    @Override
    public boolean addClass(Class<?> aClass) {
        return delegate.addClass(aClass);
    }

    @Override
    public <T> T getInstance(Class<T> aClass) {
        return delegate.getInstance(aClass);
    }
}
