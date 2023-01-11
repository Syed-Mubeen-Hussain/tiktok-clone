package com.example.tiktok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;

import com.example.tiktok.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ArrayList<Model> arrayList=new ArrayList<>();
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        arrayList.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.short1,R.drawable.man,"Mubeen"));
        arrayList.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.short2,R.drawable.man,"Mubeen"));
        arrayList.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.short3,R.drawable.man,"Mubeen"));
        arrayList.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.short4,R.drawable.man,"Mubeen"));
        adapter = new Adapter(MainActivity.this,arrayList);
        binding.Vpg2.setAdapter(adapter);
    }
}