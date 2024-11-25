package com.example.luyenandroid;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.ViewGroup;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.luyenandroid.custom.CustomBottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class BaiTap extends AppCompatActivity {
    private CustomBottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai_tap);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Bookmark> bookmarks = new ArrayList<>();
        bookmarks.add(new Bookmark("Bookmark 1", "Description 1"));
        bookmarks.add(new Bookmark("Bookmark 2", "Description 2"));

        BookmarkAdapter adapter = new BookmarkAdapter(bookmarks);
        recyclerView.setAdapter(adapter);

        initializeNavigation();
    }

    private void initializeNavigation() {
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.navigation_home) {
                    return true;
                } else if (itemId == R.id.navigation_tv) {
//                    startActivity(new Intent(HomePageActivity.this, ExploreActivity.class));
                    return true;
                } else if (itemId == R.id.navigation_book) {
//                    startActivity(new Intent(HomePageActivity.this, SettingsActivity.class));
                    return true;
                } else if (itemId == R.id.navigation_avatar) {
                    startActivity(new Intent(BaiTap.this, Profile.class));
                    return true;
                } else if (itemId == R.id.navigation_search) {
                    return true;
                }

                return false;
            }
        });
    }
}
