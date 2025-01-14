package onerme.utilities;

import java.util.Arrays;
import java.util.List;


public class FakeInputProvider implements InputProvider {
    private final List<String> inputs;
    private int currentIndex = 0;

    public FakeInputProvider(String... inputs) {
        this.inputs = Arrays.asList(inputs);
    }

    @Override
    public String getInput() {
        if (currentIndex >= inputs.size()) {
            return inputs.get(inputs.size() - 1);
        }
        return inputs.get(currentIndex++);
    }
}
