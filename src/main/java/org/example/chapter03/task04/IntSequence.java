package org.example.chapter03.task04;

public interface IntSequence {
    int next();

    default boolean hasNext() {
        return true;
    }

    static IntSequence of(int... values) {
        return new IntSequence() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < values.length;
            }

            @Override
            public int next() {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException();
                }
                return values[index++];
            }
        };
    }

    static IntSequence constant(int value) {
        return new IntSequence() {
            @Override
            public int next() {
                return value;
            }
        };
    }

    static IntSequence constantLambda(int value) {
        return () -> value;
    }
}
