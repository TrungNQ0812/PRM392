package com.example.demofollower;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demofollower.adapter.ProductAdapter;
import com.example.demofollower.bean.ProductBean;

import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity {

    private RecyclerView recyclerViewProductList;
    private ProductAdapter productAdapter;

    private final List<ProductBean> productList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerViewProductList = findViewById(R.id.recyclerViewProductList);
        productAdapter = new ProductAdapter(productList,this);
        recyclerViewProductList.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewProductList.setAdapter(productAdapter);
        fetchProductList();
    }

    public void fetchProductList(){
        for(int i = 1; i <= 50; i++){
            ProductBean productBean = new ProductBean();
            productBean.setId(i);
            productBean.setName("Product " + i);
            productBean.setPrice(i * 100.0);
            productList.add(productBean);
        }
        productAdapter.notifyDataSetChanged();
    }

//    public void onContextItemSelected(MenuItem item){
//        if(item.getItemId() == R.id){
//
//        }
//    }
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        super.onCreateContextMenu(menu, v, menuInfo);
//    }

    @Override
    public boolean  onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}