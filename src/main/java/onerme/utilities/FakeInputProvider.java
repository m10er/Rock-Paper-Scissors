package onerme.utilities;

import java.util.Queue;
import java.util.LinkedList;

public class FakeInputProvider implements InputProvider {
    private final Queue<String> inputs;

    public FakeInputProvider(String... inputs) {
        this.inputs = new LinkedList<>();
        for (String input : inputs) {
            this.inputs.add(input);
        }
    }

    @Override
    public String getInput() {
        return inputs.poll();
    }
}
