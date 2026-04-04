package net.decusatis.mybicycleshopflaming.Activities;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.decusatis.mybicycleshopflaming.Entities.Product;
import net.decusatis.mybicycleshopflaming.R;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    class ProductViewHolder extends RecyclerView.ViewHolder {
        private final TextView productItemView;

        private ProductViewHolder(View itemView) {
            super(itemView);
            productItemView = itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(view -> {
                int position = getAdapterPosition();
                final Product current = mVacations.get(position);
                Intent intent = new Intent(context, ProductDetails.class);
                intent.putExtra("id", current.getVacationID());
                intent.putExtra("name", current.getTitle());
                intent.putExtra("hotel", current.getHotel());
                intent.putExtra("startDate", current.getStartDate());
                intent.putExtra("endDate", current.getEndDate());
                context.startActivity(intent);
            });
        }
    }

    private List<Product> mVacations;
    private final Context context;
    private final LayoutInflater mInflater;

    public ProductAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.product_list_item, parent, false);
        return new ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        if (mVacations != null) {
            Product current = mVacations.get(position);
            holder.productItemView.setText(current.getTitle());
        } else {
            holder.productItemView.setText("No vacations");
        }
    }

    public void setProducts(List<Product> vacations) {
        mVacations = vacations;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mVacations == null ? 0 : mVacations.size();
    }
}
