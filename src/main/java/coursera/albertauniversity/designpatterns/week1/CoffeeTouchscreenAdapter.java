package coursera.albertauniversity.designpatterns.week1;

public class CoffeeTouchscreenAdapter implements CoffeeMachineInterface {

  private OldCoffeeMachine oldCoffeeMachine;

  public CoffeeTouchscreenAdapter(OldCoffeeMachine oldCoffeeMachine) {
    this.oldCoffeeMachine = new OldCoffeeMachine();
  }

  @Override
  public void chooseFirstSelection() {
    oldCoffeeMachine.selectA();
  }

  @Override
  public void chooseSecondSelection() {
    oldCoffeeMachine.selectB();
  }
}
