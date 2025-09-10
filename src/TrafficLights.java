import java.io.*;
import java.util.*;

public class TrafficLights {
    public static void main(String[] args) throws IOException {
        Reader in = new Reader();
        StringBuilder sb = new StringBuilder();

        int x = in.nextInt();
        int n = in.nextInt();

        TreeSet<Integer> lights = new TreeSet<>();
        lights.add(0);
        lights.add(x);

        TreeMap<Integer, Integer> segments = new TreeMap<>();
        segments.put(x, 1);

        for (int i = 0; i < n; i++) {
            int pos = in.nextInt();

            int left = lights.lower(pos);
            int right = lights.higher(pos);

            int oldSegment = right - left;
            // remove old segment
            if (segments.get(oldSegment) == 1) {
                segments.remove(oldSegment);
            } else {
                segments.put(oldSegment, segments.get(oldSegment) - 1);
            }

            // add new segments
            int seg1 = pos - left;
            int seg2 = right - pos;
            segments.put(seg1, segments.getOrDefault(seg1, 0) + 1);
            segments.put(seg2, segments.getOrDefault(seg2, 0) + 1);

            lights.add(pos);

            sb.append(segments.lastKey()).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    // Fast Input Reader
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }
    }
}
