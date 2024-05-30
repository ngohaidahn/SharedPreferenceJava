package com.example.saveobjecttosharedpreferences;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.saveobjecttosharedpreferences.data_local.DataLocalManager;
import com.example.saveobjecttosharedpreferences.model.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        TextView tvUserInfor = findViewById(R.id.tv_infor);
        List<User> userList = DataLocalManager.getListUser();
        tvUserInfor.setText(userList.get(0).toString() + "\n" + userList.get(1).toString() + "\n");


//        User user= DataLocalManager.getUser();
//        if (user !=null){
//            tvUserInfor.setText(user.toString());
//        }

    }
}