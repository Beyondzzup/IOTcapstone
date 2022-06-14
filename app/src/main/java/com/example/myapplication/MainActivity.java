package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText etToken;
    private WebView webView;
    private String url =" ";

    int day1;
    int day2;
    int day3;
    int day4;

    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;

    LinearLayout linearLayout1;
    LinearLayout linearLayout2;
    LinearLayout linearLayout3;
    LinearLayout linearLayout4;

    TextView Shake1;
    TextView Shake2;
    TextView Shake3;
    TextView Shake4;

    Calendar shaked1 = Calendar.getInstance();
    Calendar shaked2 = Calendar.getInstance();
    Calendar shaked3 = Calendar.getInstance();
    Calendar shaked4 = Calendar.getInstance();

    Calendar shaked11 = Calendar.getInstance();
    Calendar shaked22 = Calendar.getInstance();
    Calendar shaked33 = Calendar.getInstance();
    Calendar shaked44 = Calendar.getInstance();

    String shared1="file";
    String shared2="file";
    String shared3="file";
    String shared4="file";
    String shared5="file";
    String shared6="file";
    String shared7="file";
    String shared8="file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            System.out.println("Fetching FCM registration token failed");
                            return;
                        }

                        // Get new FCM registration token
                        String token = task.getResult();

                        // Log and toast
                        System.out.println(token);

                    }
                });

        webView=(WebView)findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClientClass());

        imageView1=findViewById(R.id.imageview);
        imageView2=findViewById(R.id.imageview2);
        imageView3=findViewById(R.id.imageview3);
        imageView4=findViewById(R.id.imageview4);

        Shake1=findViewById(R.id.shake1);
        Shake2=findViewById(R.id.shake2);
        Shake3=findViewById(R.id.shake3);
        Shake4=findViewById(R.id.shake4);

        linearLayout1=findViewById(R.id.linearLayout1);
        linearLayout2=findViewById(R.id.linearLayout2);
        linearLayout3=findViewById(R.id.linearLayout3);
        linearLayout4=findViewById(R.id.linearLayout4);

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String strDate=df.format(cal.getTime());
        Shake1.setText(strDate);
        Shake2.setText(strDate);
        Shake3.setText(strDate);
        Shake4.setText(strDate);

        SharedPreferences sharedPreferences1 = getSharedPreferences(shared1,0);
        SharedPreferences sharedPreferences2 = getSharedPreferences(shared2,0);
        SharedPreferences sharedPreferences3 = getSharedPreferences(shared3,0);
        SharedPreferences sharedPreferences4 = getSharedPreferences(shared4,0);
        SharedPreferences sharedPreferences5 = getSharedPreferences(shared5,0);
        SharedPreferences sharedPreferences6 = getSharedPreferences(shared6,0);
        SharedPreferences sharedPreferences7 = getSharedPreferences(shared7,0);
        SharedPreferences sharedPreferences8 = getSharedPreferences(shared8,0);

        String value1 = sharedPreferences1.getString("sshake1","");
        String value2 = sharedPreferences2.getString("sshake2","");
        String value3 = sharedPreferences3.getString("sshake3","");
        String value4 = sharedPreferences4.getString("sshake4","");
        int value5 = sharedPreferences5.getInt("sshake5", 0);
        int value6 = sharedPreferences6.getInt("sshake6", 0);
        int value7 = sharedPreferences7.getInt("sshake7", 0);
        int value8 = sharedPreferences8.getInt("sshake8", 0);

        Shake1.setText(value1);
        Shake2.setText(value2);
        Shake3.setText(value3);
        Shake4.setText(value4);

        day1=value5;
        day2=value6;
        day3=value7;
        day4=value8;

    }

    public boolean onKeyDown(int keyCode, KeyEvent event){
        if((keyCode == KeyEvent.KEYCODE_BACK)&&webView.canGoBack()){
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }
    private class WebViewClientClass extends WebViewClient{
        public boolean shouldOverrideUrlLoading(WebView view,String url){
            view.loadUrl(url);
            return true;
        }
    }

    public void onButton1clicked(View view) {
        imageView1.setVisibility(View.VISIBLE);
        imageView2.setVisibility(View.INVISIBLE);
        imageView3.setVisibility(View.INVISIBLE);
        imageView4.setVisibility(View.INVISIBLE);
        linearLayout1.setVisibility(View.VISIBLE);
        linearLayout2.setVisibility(View.INVISIBLE);
        linearLayout3.setVisibility(View.INVISIBLE);
        linearLayout4.setVisibility(View.INVISIBLE);
        Calendar cale = Calendar.getInstance();
        int sibal=(cale.get(Calendar.YEAR)*365)+cale.get(Calendar.DAY_OF_YEAR);
        int result=day1-sibal;
        if(result<0){
        Shake1.setTextColor(Color.parseColor("#FF0000"));
        }

    }
    public void onButton2clicked(View view) {
        imageView1.setVisibility(View.INVISIBLE);
        imageView2.setVisibility(View.VISIBLE);
        imageView3.setVisibility(View.INVISIBLE);
        imageView4.setVisibility(View.INVISIBLE);
        linearLayout1.setVisibility(View.INVISIBLE);
        linearLayout2.setVisibility(View.VISIBLE);
        linearLayout3.setVisibility(View.INVISIBLE);
        linearLayout4.setVisibility(View.INVISIBLE);
        Calendar cale = Calendar.getInstance();
        int sibal=(cale.get(Calendar.YEAR)*365)+cale.get(Calendar.DAY_OF_YEAR);
        int result=day2-sibal;
        if(result<0){
            Shake2.setTextColor(Color.parseColor("#FF0000"));
        }

    }
    public void onButton3clicked(View view) {
        imageView1.setVisibility(View.INVISIBLE);
        imageView2.setVisibility(View.INVISIBLE);
        imageView3.setVisibility(View.VISIBLE);
        imageView4.setVisibility(View.INVISIBLE);
        linearLayout1.setVisibility(View.INVISIBLE);
        linearLayout2.setVisibility(View.INVISIBLE);
        linearLayout3.setVisibility(View.VISIBLE);
        linearLayout4.setVisibility(View.INVISIBLE);
        Calendar cale = Calendar.getInstance();
        int sibal=(cale.get(Calendar.YEAR)*365)+cale.get(Calendar.DAY_OF_YEAR);
        int result=day3-sibal;
        if(result<0){
            Shake3.setTextColor(Color.parseColor("#FF0000"));
        }
        }
    public void onButton4clicked(View view) {
        imageView1.setVisibility(View.INVISIBLE);
        imageView2.setVisibility(View.INVISIBLE);
        imageView3.setVisibility(View.INVISIBLE);
        imageView4.setVisibility(View.VISIBLE);
        linearLayout1.setVisibility(View.INVISIBLE);
        linearLayout2.setVisibility(View.INVISIBLE);
        linearLayout3.setVisibility(View.INVISIBLE);
        linearLayout4.setVisibility(View.VISIBLE);
        Calendar cale = Calendar.getInstance();
        int sibal=(cale.get(Calendar.YEAR)*365)+cale.get(Calendar.DAY_OF_YEAR);
        int result=day4-sibal;
        if(result<0){
            Shake4.setTextColor(Color.parseColor("#FF0000"));
        }
        }
    public void onupdatebtnclicked1(View view){
        Calendar cal = Calendar.getInstance();
        day1=(cal.get(Calendar.YEAR)*365)+cal.get(Calendar.DAY_OF_YEAR)+30;
        cal.setTime(new Date());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String strDate=df.format(new Date());
        Shake1.setText(strDate);
        Shake1.setTextColor(Color.parseColor("#FFFFFF"));

    }
    public void onupdatebtnclicked2(View view){
        Calendar cal = Calendar.getInstance();
        day2=(cal.get(Calendar.YEAR)*365)+cal.get(Calendar.DAY_OF_YEAR)+30;
        cal.setTime(new Date());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String strDate=df.format(new Date());
        Shake2.setText(strDate);
        Shake2.setTextColor(Color.parseColor("#FFFFFF"));
    }
    public void onupdatebtnclicked3(View view){
        Calendar cal = Calendar.getInstance();
        day3=(cal.get(Calendar.YEAR)*365)+cal.get(Calendar.DAY_OF_YEAR)+30;
        cal.setTime(new Date());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String strDate=df.format(new Date());
        Shake3.setText(strDate);
        Shake3.setTextColor(Color.parseColor("#FFFFFF"));
    }
    public void onupdatebtnclicked4(View view) {
        Calendar cal = Calendar.getInstance();
        day4=(cal.get(Calendar.YEAR)*365)+cal.get(Calendar.DAY_OF_YEAR)+30;
        cal.setTime(new Date());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String strDate=df.format(new Date());
        Shake4.setText(strDate);
        Shake4.setTextColor(Color.parseColor("#FFFFFF"));
    }

    public void onDestroy(){
        super.onDestroy();

        SharedPreferences sharedPreferences1 = getSharedPreferences(shared1,0);
        SharedPreferences sharedPreferences2 = getSharedPreferences(shared2,0);
        SharedPreferences sharedPreferences3 = getSharedPreferences(shared3,0);
        SharedPreferences sharedPreferences4 = getSharedPreferences(shared4,0);
        SharedPreferences sharedPreferences5 = getSharedPreferences(shared5,0);
        SharedPreferences sharedPreferences6 = getSharedPreferences(shared6,0);
        SharedPreferences sharedPreferences7 = getSharedPreferences(shared7,0);
        SharedPreferences sharedPreferences8 = getSharedPreferences(shared8,0);

        SharedPreferences.Editor editor1 = sharedPreferences1.edit();
        SharedPreferences.Editor editor2 = sharedPreferences2.edit();
        SharedPreferences.Editor editor3 = sharedPreferences3.edit();
        SharedPreferences.Editor editor4 = sharedPreferences4.edit();
        SharedPreferences.Editor editor5 = sharedPreferences5.edit();
        SharedPreferences.Editor editor6 = sharedPreferences6.edit();
        SharedPreferences.Editor editor7 = sharedPreferences7.edit();
        SharedPreferences.Editor editor8 = sharedPreferences8.edit();

        String value1 = Shake1.getText().toString();
        String value2 = Shake2.getText().toString();
        String value3 = Shake3.getText().toString();
        String value4 = Shake4.getText().toString();
        int value5 = day1;
        int value6 = day2;
        int value7 = day3;
        int value8 = day4;


        editor1.putString("sshake1",value1);
        editor2.putString("sshake2",value2);
        editor3.putString("sshake3",value3);
        editor4.putString("sshake4",value4);
        editor5.putInt("sshake5",value5);
        editor6.putInt("sshake6",value6);
        editor7.putInt("sshake7",value7);
        editor8.putInt("sshake8",value8);
        editor1.commit();
        editor2.commit();
        editor3.commit();
        editor4.commit();
        editor5.commit();
        editor6.commit();
        editor7.commit();
        editor8.commit();

    }

}