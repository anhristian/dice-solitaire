package edu.cnm.deepdive.dicesolitaire.model;

import java.util.Arrays;
import java.util.Random;

public class Roll {

  public static final int NUM_DICE = 5;
  public static final int NUM_FACES = 6;

  private final int[] dice;

  public Roll(Random rng) {
    dice = new int[NUM_DICE];
    for (int i = 0; i < NUM_DICE; i++) {
      dice[i] = 1 + rng.nextInt(NUM_FACES);
    }
    Arrays.sort(dice);
  }

  public int[] getDice() {
    return Arrays.copyOf(dice, NUM_DICE);
  }

}
