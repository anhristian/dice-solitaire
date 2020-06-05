package edu.cnm.deepdive.dicesolitaire.model;

public enum GameState {
  /** Initial state before the first roll. */
  INITIAL,
  /** State startig with first roll, until maximum scratch count is reached. */
  IN_PROGRESS,
  /** State after maximum scratch count is reached. */
  TERMINAL;
}
