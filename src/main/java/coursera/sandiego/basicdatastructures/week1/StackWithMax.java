package coursera.sandiego.basicdatastructures.week1;

import java.util.*;
import java.io.*;

public class StackWithMax {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public void solve() throws IOException {
        FastScanner scanner = new FastScanner();
        int queries = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> auxiliaryStack = new Stack<>();

        for (int qi = 0; qi < queries; ++qi) {
            String operation = scanner.next();
            if ("push".equals(operation)) {
                int value = scanner.nextInt();
                if (auxiliaryStack.empty()) {
                    auxiliaryStack.push(0);
                } else {
                    if (stack.get(auxiliaryStack.peek()) < value) {
                        auxiliaryStack.push(stack.size());
                    } else {
                        auxiliaryStack.push(auxiliaryStack.peek());
                    }
                }
                stack.push(value);
            } else if ("pop".equals(operation)) {
                stack.pop();
                auxiliaryStack.pop();
            } else if ("max".equals(operation)) {
                System.out.println(stack.get(auxiliaryStack.peek()));
            }
        }
    }

    static public void main(String[] args) throws IOException {
        new StackWithMax().solve();
    }
}
