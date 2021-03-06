package es.ahs.geopoints.matcher;

import es.ahs.mygeopoints.web.json.JsonUtil;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

/**
 * Created by ahs on 30.05.16.
 */
abstract public class TestMatcher<T> extends BaseMatcher<String> {
    protected T expected;
    public TestMatcher(T expected) {
        this.expected = expected;
    }

    @Override
    public boolean matches(Object actual) {
        return compare(expected, (String) actual);
    }

    abstract protected boolean compare(T expected, String actual);

    @Override
    public void describeTo(Description description) {
        description.appendText(JsonUtil.writeValue(expected));
    }
}
