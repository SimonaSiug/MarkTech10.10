package com.example.marktech1010;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText edUserInput;
    private TextView tvResult;
    Spinner spCountOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        this.edUserInput = findViewById(R.id.edUserInput);
        this.tvResult = findViewById(R.id.tvResult);
        this.spCountOptions = findViewById(R.id.spCountOptions);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.counting_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCountOptions.setAdapter(adapter);
    }

    public void onBtnCountClick(View view) {
        String userInputText = edUserInput.getText().toString().trim();

        if (userInputText.isEmpty()) {
            Toast.makeText(this, getString(R.string.toast_empty_input), Toast.LENGTH_SHORT).show();
            return;
        }
        String selectedOption = spCountOptions.getSelectedItem().toString();
        int result = 0;
        if (selectedOption.equals(getString(R.string.option_chars))) {
            result = TextCounter.getCount(userInputText, true);
        } else if (selectedOption.equals(getString(R.string.option_words))) {
            result = TextCounter.getCount(userInputText, false);
        }

        tvResult.setText(String.valueOf(result));
    }
}