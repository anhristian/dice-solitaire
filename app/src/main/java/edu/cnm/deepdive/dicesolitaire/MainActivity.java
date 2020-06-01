package edu.cnm.deepdive.dicesolitaire;

import static edu.cnm.deepdive.dicesolitaire.model.Roll.NUM_FACES;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import edu.cnm.deepdive.dicesolitaire.model.Roll;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

  private static final String PAIR_LABEL_ID_FORMAT = "pair_%d_label";
  private static final String PAIR_COUNT_ID_FORMAT = "pair_%d_count";
  private static final String SCRATCH_LABEL_ID_FORMAT = "scratch_%d_label";
  private static final String SCRATCH_COUNT_ID_FORMAT = "scratch_%d_count";


  private int minPairValue = 2;
  private int maxPairValue = 2 * NUM_FACES;
  private TextView[] pairLabels;
  private ProgressBar[] pairCounts;
  private Button roller;
  private Random rng = new Random();
  private TextView[] scratchLabels;
  private ProgressBar[] scratchCounts;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setupIU();
  }

  private void setupIU() {
    setContentView(R.layout.activity_main);
    Resources res = getResources();
    NumberFormat formatter = NumberFormat.getInstance();
    setupPairControls(res, formatter);
    setupPlayControls();
    setupScratchControls(res, formatter);
  }

  private void setupScratchControls(Resources res, NumberFormat formatter) {
    scratchLabels = new TextView[NUM_FACES];
    scratchCounts = new ProgressBar[NUM_FACES];
    for ( int i = 1; i <= NUM_FACES; i++) {
      String scratchIdLabel = String.format(SCRATCH_LABEL_ID_FORMAT, i);
      int labelId = res.getIdentifier(scratchIdLabel, "id", getPackageName());
      scratchLabels[i - 1] = findViewById(labelId);
      scratchLabels[i - 1].setText(formatter.format(i));
      String scratchIdCount = String.format(SCRATCH_COUNT_ID_FORMAT, i);
      int countId = res.getIdentifier(scratchIdCount, "id", getPackageName());
      scratchCounts[i - 1] = findViewById(countId);
      scratchCounts[i - 1].setProgress(1 + rng.nextInt(7));

    }
  }

  private void setupPlayControls() {
    roller = findViewById(R.id.roller);
    //TODO find and wire uo dice ImageView objects.
    roller.setOnClickListener(new RollerListener());
  }

  private void setupPairControls(Resources res, NumberFormat formatter) {
    pairLabels = new TextView[maxPairValue - minPairValue + 1];
    pairCounts = new ProgressBar[maxPairValue - minPairValue +1];
    for (int i = minPairValue; i <= maxPairValue; i++) {
      String labelIdString = String.format(PAIR_LABEL_ID_FORMAT, i);
      int labelId = res.getIdentifier(labelIdString, "id", getPackageName());
      pairLabels[i - minPairValue] = findViewById(labelId);
      pairLabels[i - minPairValue].setText(formatter.format(i));
      String countIdString = String.format(PAIR_COUNT_ID_FORMAT, i);
      int countId = res.getIdentifier(countIdString, "id", getPackageName());
      pairCounts[i - minPairValue] = findViewById(countId);
      pairCounts[i - minPairValue].setProgress(1 + rng.nextInt(10));

    }
  }

  private class RollerListener implements OnClickListener {

    @Override
    public void onClick(View v) {
      Roll roll = new Roll(rng);
      //TODO Display dice images.
    }
  }
}
