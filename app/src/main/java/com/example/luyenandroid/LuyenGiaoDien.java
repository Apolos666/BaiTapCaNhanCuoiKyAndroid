package com.example.luyenandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LuyenGiaoDien extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.luyen_giao_dien_1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<CongViec> congViecList = new ArrayList<>();
        congViecList.add(new CongViec("Làm bài tập Android", "Google", "20/10/2021"));
        congViecList.add(new CongViec("Làm bài tập Java", "Oracle", "21/10/2021"));

        CongViecAdapter adapter = new CongViecAdapter(congViecList);
        recyclerView.setAdapter(adapter);

        RecyclerView recyclerView2 = findViewById(R.id.recyclerView2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));

        List<CongViec> congViecList2 = new ArrayList<>();
        congViecList2.add(new CongViec("Làm bài tập Android", "Google", "20/10/2021"));
        congViecList2.add(new CongViec("Làm bài tập Java", "Oracle", "21/10/2021"));

        CongViecAdapter adapter2 = new CongViecAdapter(congViecList2);
        recyclerView2.setAdapter(adapter2);

        Button button = findViewById(R.id.toNewMainActivityButton);

        button.setOnClickListener(v -> {
            Intent intent = new Intent(LuyenGiaoDien.this, MainActivity.class);
            intent.putExtra("extra_data", "Hello from LuyenGiaoDien");
            SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("name", "LuyenAndroid");
            editor.apply();
            startActivity(intent);
        });
    }

}
