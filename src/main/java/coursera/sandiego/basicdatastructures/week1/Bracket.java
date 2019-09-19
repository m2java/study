package coursera.sandiego.basicdatastructures.week1;

public class Bracket {
  private char type;
  private int position;

  public Bracket(char type, int position) {
    this.type = type;
    this.position = position;
  }

  public boolean match(char input) {
    if (this.type == '[' && input == ']') {
      return true;
    }

    if (this.type == '{' && input == '}') {
      return true;
    }
    if (this.type == '(' && input == ')') {
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    return "Bracket{" + "type=" + type + ", position=" + position + '}';
  }
}
