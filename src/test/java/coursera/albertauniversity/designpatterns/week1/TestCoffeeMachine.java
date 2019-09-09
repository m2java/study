package coursera.albertauniversity.designpatterns.week1;

import org.junit.Test;

public class TestCoffeeMachine {

  @Test
  public void testMain() {
    CoffeeTouchscreenAdapter coffee = new CoffeeTouchscreenAdapter(new OldCoffeeMachine());
    coffee.chooseFirstSelection();
    coffee.chooseSecondSelection();
  }
}
