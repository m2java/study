package coursera.sandiego.basicdatastructures.week1;

import java.util.ArrayDeque;
import java.util.Deque;

public class CheckBrackets {

  public boolean check(String input) {
    Deque<Bracket> openingBracketStack = new ArrayDeque<>();
    for (int position = 0; position < input.length(); position++) {
      char next = input.charAt(position);
      if (next == '(' || next == '{' || next == '[') {
        openingBracketStack.push(new Bracket(next, position));
      }
      if (next == ')' || next == '}' || next == ']') {
        if (!openingBracketStack.isEmpty() && openingBracketStack.peek().match(next)) {
          openingBracketStack.pop();
        } else {
          System.out.println(openingBracketStack.size());
          return false;
        }
      }
    }
    System.out.println(openingBracketStack.size());
    return openingBracketStack.isEmpty();
  }
}
