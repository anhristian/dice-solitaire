package edu.cnm.deepdive.dicesolitaire;

import android.content.res.Resources;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import edu.cnm.deepdive.dicesolitaire.model.Roll;
import java.text.NumberFormat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

  private static final String LABEL_ID_FORMAT = "pair_%d_label";
  private static final String COUNT_ID_FORMAT = "pair_%d_count";

  private int minPairValue = 2;
  private int maxPairValue;
  private TextView[] labels;
  private ProgressBar[] counts;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    maxPairValue = 2 * Roll.NUM_FACES;
    labels = new TextView[maxPairValue - minPairValue + 1];
    counts = new ProgressBar[maxPairValue - minPairValue +1];
    Resources res = getResources();
    Random rng = new Random();
    NumberFormat formatter = NumberFormat.getInstance();
    for (int i = minPairValue; i <= maxPairValue; i++) {
      String labelIdString = String.format(LABEL_ID_FORMAT, i);
      int labelId = res.getIdentifier(labelIdString, "id", getPackageName());
      labels[i - minPairValue] = findViewById(labelId);
      labels[i - minPairValue].setText(formatter.format(i));
      String countIdString = String.format(COUNT_ID_FORMAT, i);
      int countId = res.getIdentifier(countIdString, "id", getPackageName());
      counts[i - minPairValue] = findViewById(countId);
      counts[i - minPairValue].setProgress(1 + rng.nextInt(10));

    }

  }
}
