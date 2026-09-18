package org.example.chapter05.task07;

public class Task07 {

//    public void close() {
//        if (closed)
//            return;
//        if (source instanceof Closeable) {
//            try {
//                ((Closeable)source).close();
//            } catch (IOException ioe) {
//                lastException = ioe;
//            }
//        }
//        sourceClosed = true;
//        source = null;
//        closed = true;
//    }

//    private void readInput() {
//        if (buf.limit() == buf.capacity())
//            makeSpace();
//
//        // Prepare to receive data
//        int p = buf.position();
//        buf.position(buf.limit());
//        buf.limit(buf.capacity());
//
//        int n = 0;
//        try {
//            n = source.read(buf);
//        } catch (IOException ioe) {
//            lastException = ioe;
//            n = -1;
//        }
//
//        if (n == -1) {
//            sourceClosed = true;
//            needInput = false;
//        }
//
//        if (n > 0)
//            needInput = false;
//
//        // Restore current position and limit for reading
//        buf.limit(buf.position());
//        buf.position(p);
//    }

//    Scanner самостоятельно перехватывает IOException, возникающий при закрытии его source, и сохраняет
//    его как lastException. Поэтому это исключение не передаётся механизму try-with-resources и не становится
//    suppressed exception. Его можно получить через Scanner.ioException()

//    Если при закрытии source возникнет IOException, Scanner перехватит его внутри своего close()
//    и сохранит в поле lastException. Исключение не будет выброшено дальше.

}
