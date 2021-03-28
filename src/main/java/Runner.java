import util.InputUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Runner {

  public static void main(String[] args) {
    InputUtil util = new InputUtil();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    while(true) {
      try {
        String input = reader.readLine();
        util.handleInput(input);
      } catch (Exception ignore) {}
    }
  }
}
