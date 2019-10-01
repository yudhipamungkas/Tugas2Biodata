package com.yudhipamungkas.tugas2biodata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView alamatYudhiMain;
    private TextView emailYudhiMain;
    private TextView phoneYudhiMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alamatYudhiMain = findViewById(R.id.alamatYudhi);
        phoneYudhiMain = findViewById(R.id.phoneYudhi);
        emailYudhiMain = findViewById(R.id.emailYudhi);
    }

    public void email(View view) {
        String email = emailYudhiMain.getText().toString();
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","email", null));
        startActivity(Intent.createChooser(emailIntent,"Feedback"));
    }

    public void phone(View view) {
        String nomer = phoneYudhiMain.getText().toString();
        Intent panggil = new Intent(Intent.ACTION_DIAL);
        panggil.setData(Uri.fromParts("tel",nomer,null));
        startActivity(panggil);
    }

    public void alamat(View view) {
        String loc = alamatYudhiMain.getText().toString();
        Uri addressUri = Uri.parse("geo:0,0?q="+loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }else{
            Log.d("ImplicitIntents","Alamat Kurang Jelas");
        }
    }
}
