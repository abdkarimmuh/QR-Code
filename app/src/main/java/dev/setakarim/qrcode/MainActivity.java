package dev.setakarim.qrcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import dev.setakarim.qrcode.Generate.GenerateActivity;
import dev.setakarim.qrcode.Scan.ScanActivity;

public class MainActivity extends AppCompatActivity {

    Button btn_generate, btn_scan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_generate = (Button) findViewById(R.id.btn_generate);
        btn_scan = (Button) findViewById(R.id.btn_scan);

        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ScanActivity.class);
                startActivity(intent);
            }
        });

        btn_generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GenerateActivity.class);
                startActivity(intent);
            }
        });
    }
}
