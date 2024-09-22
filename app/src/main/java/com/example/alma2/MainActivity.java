package com.example.alma2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView txtView;
    EditText editTxt;
    Button btn;
    SharedPreferences sharedPreferences;
    EditText nameTxt;
    String fullİnfo;

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
        sharedPreferences = this.getSharedPreferences("com.example.alma", Context.MODE_PRIVATE);
        int storeAge = sharedPreferences.getInt("userAge", 0);
        String storeName=sharedPreferences.getString("name","Null");

        if(storeAge==0){
        }else{
            txtView.setText("Hoşgeldiniz: " +fullİnfo);
        }
        txtView=findViewById(R.id.txtWiewAge);
        editTxt=findViewById(R.id.ageTxt);
        btn=findViewById(R.id.signBtn);
        nameTxt=findViewById(R.id.editTextText);
    }

   public void save(View view){
    if(!editTxt.getText().toString().isEmpty() && !nameTxt.getText().toString().isEmpty()){
        int userAge = Integer.parseInt(editTxt.getText().toString());
        String name = nameTxt.getText().toString();
        fullİnfo = "Merhaba " + name + " Bey şu anda " + userAge + " yaşındasınız";
        txtView.setText("Hoşgeldiniz: " + fullİnfo);
        sharedPreferences.edit().putInt("userAge", userAge).apply();
        sharedPreferences.edit().putString("name", name).apply();
    } else {
        txtView.setText("Alanlar: Boş geçilemez");
        }
    }

    public void deleteData(View view){
        String storedData=sharedPreferences.getString("name","Null");
        if(storedData != ""){
            sharedPreferences.edit().remove("name").apply();
            sharedPreferences.edit().remove("userAge").apply();
            txtView.setText("Your İnfo: ");
        }
    }
}