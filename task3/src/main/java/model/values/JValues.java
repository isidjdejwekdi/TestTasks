package model.values;

import java.util.List;

public class JValues {

    private List<Value> values;

    public JValues(List<Value> values) {
        this.values = values;
    }

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "JValues{" +
                "values=" + values +
                '}';
    }
}

