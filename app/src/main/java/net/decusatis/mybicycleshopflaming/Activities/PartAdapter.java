package net.decusatis.mybicycleshopflaming.Activities;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.decusatis.mybicycleshopflaming.Entities.Part;
import net.decusatis.mybicycleshopflaming.R;

import java.util.List;

public class PartAdapter extends RecyclerView.Adapter<PartAdapter.PartViewHolder> {

    class PartViewHolder extends RecyclerView.ViewHolder {
        private final TextView titleView;
        private final TextView dateView;

        private PartViewHolder(View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.textView2);
            dateView = itemView.findViewById(R.id.textView3);
            itemView.setOnClickListener(view -> {
                int position = getAdapterPosition();
                final Part current = mExcursions.get(position);
                Intent intent = new Intent(context, PartDetails.class);
                intent.putExtra("id", current.getExcursionID());
                intent.putExtra("name", current.getTitle());
                intent.putExtra("excursionDate", current.getExcursionDate());
                intent.putExtra("vacationID", current.getVacationID());
                intent.putExtra("vacationStartDate", vacationStartDate);
                intent.putExtra("vacationEndDate", vacationEndDate);
                context.startActivity(intent);
            });
        }
    }

    private List<Part> mExcursions;
    private final Context context;
    private final LayoutInflater mInflater;
    private final String vacationStartDate;
    private final String vacationEndDate;

    public PartAdapter(Context context, String vacationStartDate, String vacationEndDate) {
        mInflater = LayoutInflater.from(context);
        this.context = context;
        this.vacationStartDate = vacationStartDate;
        this.vacationEndDate = vacationEndDate;
    }

    @NonNull
    @Override
    public PartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.part_list_item, parent, false);
        return new PartViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PartViewHolder holder, int position) {
        if (mExcursions != null) {
            Part current = mExcursions.get(position);
            holder.titleView.setText(current.getTitle());
            holder.dateView.setText(current.getExcursionDate());
        } else {
            holder.titleView.setText("No excursion");
            holder.dateView.setText("");
        }
    }

    public void setParts(List<Part> excursions) {
        mExcursions = excursions;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mExcursions == null ? 0 : mExcursions.size();
    }
}
