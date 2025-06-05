package com.example.demofollower.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demofollower.ProductListActivity;
import com.example.demofollower.R;
import com.example.demofollower.bean.ProductBean;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<ProductBean> productList;
    private final Context context;
    private int selectedPosition;

    public int getSelectedPosition(){
        return selectedPosition;
    }

    public ProductAdapter(List<ProductBean> productList, Context context) {
        this.productList = productList;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_item,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {
        ProductBean product = productList.get(position);
        holder.tvProductId.setText(String.valueOf(product.getId()));
        holder.tvProductName.setText(String.valueOf(product.getName()));
        holder.tvProductPrice.setText(String.valueOf(product.getPrice()));
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    public class ProductViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {
        private final TextView tvProductId;
        private final TextView tvProductName;
        private final TextView tvProductPrice;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            tvProductId = itemView.findViewById(R.id.ProductIdLbl);
            tvProductName = itemView.findViewById(R.id.ProductNameLbl);
            tvProductPrice = itemView.findViewById(R.id.ProductPriceLbl);
            tvProductName.setOnClickListener(this);
            ((ProductListActivity) context).registerForContextMenu(tvProductName);
        }

        @Override
        public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Confirmation");
            builder.setMessage("Are you sure you want to delete Product ID: " + tvProductId.getText() +
                    "Product Name: " + tvProductName.getText() + "Price: " + tvProductPrice.getText())
                    .setPositiveButton("OK", (dialog, which) -> {
                        productList.remove(getAdapterPosition());
                        notifyItemRemoved(getAdapterPosition());
                        dialog.dismiss();
                    }).setNegativeButton("Cancel", (dialog,which) ->{
                        dialog.dismiss();
                    });
            AlertDialog dialog = builder.create();
            dialog.show();
        }

        @Override
        public boolean onLongClick(View view) {
            return false;
        }
    }

}
