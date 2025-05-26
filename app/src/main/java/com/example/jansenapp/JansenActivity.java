package com.example.jansenapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class JansenActivity extends AppCompatActivity {

    EditText input1, input2;
    TextView hasilText;
    Button tambahBtn, kaliBtn, bagiBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jansen);

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        hasilText = findViewById(R.id.hasilText);
        tambahBtn = findViewById(R.id.btnTambah);
        kaliBtn = findViewById(R.id.btnKali);
        bagiBtn = findViewById(R.id.btnBagi);

        tambahBtn.setOnClickListener(v -> hitung("+"));
        kaliBtn.setOnClickListener(v -> hitung("*"));
        bagiBtn.setOnClickListener(v -> hitung("/"));
    }

    private void hitung(String operasi) {
        String angka1Str = input1.getText().toString();
        String angka2Str = input2.getText().toString();

        if (!angka1Str.isEmpty() && !angka2Str.isEmpty()) {
            double angka1 = Double.parseDouble(angka1Str);
            double angka2 = Double.parseDouble(angka2Str);
            double hasil = 0.0;

            switch (operasi) {
                case "+":
                    hasil = angka1 + angka2;
                    break;
                case "*":
                    hasil = angka1 * angka2;
                    break;
                case "/":
                    if (angka2 != 0) {
                        hasil = angka1 / angka2;
                    } else {
                        hasilText.setText("Tidak bisa dibagi nol");
                        return;
                    }
                    break;
            }

            // Buang angka desimal jika hasil bulat
            if (hasil == (long) hasil) {
                hasilText.setText("Hasil: " + String.valueOf((long) hasil));
            } else {
                hasilText.setText("Hasil: " + hasil);
            }

        } else {
            hasilText.setText("Mohon isi semua angka");
        }
    }
}
