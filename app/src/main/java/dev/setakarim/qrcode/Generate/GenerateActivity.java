package dev.setakarim.qrcode.Generate;

import android.graphics.Bitmap;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import dev.setakarim.qrcode.R;

public class GenerateActivity extends AppCompatActivity {

    private ImageView imgQRCode;
    private EditText txtContent;
    private Button btnGenerate;

    public final static int QRCodeWidth = 500;
    Bitmap result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate);

        txtContent = findViewById(R.id.content_qrcode);
        imgQRCode = findViewById(R.id.image_qrcode);
        btnGenerate = findViewById(R.id.generate_qrcode);

        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = txtContent.getText().toString();
                try {
                    result = generate(content);
                    imgQRCode.setImageBitmap(result);
                    store(content,result);
                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private Bitmap generate(String value) throws WriterException {
        BitMatrix bitMatrix;
        try {
            bitMatrix = new MultiFormatWriter().encode(
                    value,
                    BarcodeFormat.DATA_MATRIX.QR_CODE,
                    QRCodeWidth, QRCodeWidth, null
            );

        } catch (IllegalArgumentException Illegalargumentexception) {

            return null;
        }
        int bitMatrixWidth = bitMatrix.getWidth();
        int bitMatrixHeight = bitMatrix.getHeight();
        int[] pixels = new int[bitMatrixWidth * bitMatrixHeight];
        for (int y = 0; y < bitMatrixHeight; y++) {
            int offset = y * bitMatrixWidth;
            for (int x = 0; x < bitMatrixWidth; x++) {
                pixels[offset + x] = bitMatrix.get(x, y) ?
                        ContextCompat.getColor(getApplicationContext(),R.color.black):
                        ContextCompat.getColor(getApplicationContext(),R.color.white);
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(bitMatrixWidth, bitMatrixHeight, Bitmap.Config.ARGB_4444);
        bitmap.setPixels(pixels, 0, 500, 0, 0, bitMatrixWidth, bitMatrixHeight);
        return bitmap;
    }

    private void store(String content, Bitmap qrcode){

    }
}
