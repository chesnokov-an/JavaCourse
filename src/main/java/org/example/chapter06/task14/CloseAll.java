package org.example.chapter06.task14;

import java.util.ArrayList;

public class CloseAll {
    public static <T extends AutoCloseable> void closeAll(ArrayList<T> elems) throws Exception {
        Exception firstException = null;
        for (T elem : elems) {
            try {
                elem.close();
            } catch (Exception e) {
                if (firstException == null) {
                    firstException = e;
                } else {
                    firstException.addSuppressed(e);
                }
            }
        }

        if (firstException != null) {
            throw firstException;
        }
    }

    static class Resource implements AutoCloseable {
        private final String name;
        private final boolean throwOnClose;

        Resource(String name, boolean throwOnClose) {
            this.name = name;
            this.throwOnClose = throwOnClose;
        }

        @Override
        public void close() throws Exception {
            if (throwOnClose) {
                throw new Exception("ex on close " + name);
            }
        }
    }

    static void main() {
        ArrayList<Resource> resources = new ArrayList<>();
        resources.add(new Resource("A", false));
        resources.add(new Resource("B", true));
        resources.add(new Resource("C", true));
        resources.add(new Resource("D", false));

        try {
            closeAll(resources);
        } catch (Exception e) {
            for (Throwable suppressed : e.getSuppressed()) {
                System.out.println("  suppressed: " + suppressed.getMessage());
            }
        }
    }
}