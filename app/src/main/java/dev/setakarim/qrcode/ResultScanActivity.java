package dev.setakarim.qrcode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultScanActivity extends AppCompatActivity {

    private TextView txtResult;

    private dev.setakarim.qrcode.Service.APIService APIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_scan);

        txtResult = (TextView) findViewById(R.id.txtResult);

        String result = getIntent().getStringExtra("result");

        txtResult.setText(result.toString());
    }


}
