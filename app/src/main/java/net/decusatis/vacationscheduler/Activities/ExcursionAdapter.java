package net.decusatis.vacationscheduler.Activities;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.decusatis.vacationscheduler.Entities.Excursion;
import net.decusatis.vacationscheduler.R;

import java.util.List;

public class ExcursionAdapter extends RecyclerView.Adapter<ExcursionAdapter.ExcursionViewHolder> {

    class ExcursionViewHolder extends RecyclerView.ViewHolder {
        private final TextView titleView;
        private final TextView dateView;

        private ExcursionViewHolder(View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.textView2);
            dateView = itemView.findViewById(R.id.textView3);
            itemView.setOnClickListener(view -> {
                int position = getAdapterPosition();
                final Excursion current = mExcursions.get(position);
                Intent intent = new Intent(context, ExcursionDetails.class);
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

    private List<Excursion> mExcursions;
    private final Context context;
    private final LayoutInflater mInflater;
    private final String vacationStartDate;
    private final String vacationEndDate;

    public ExcursionAdapter(Context context, String vacationStartDate, String vacationEndDate) {
        mInflater = LayoutInflater.from(context);
        this.context = context;
        this.vacationStartDate = vacationStartDate;
        this.vacationEndDate = vacationEndDate;
    }

    @NonNull
    @Override
    public ExcursionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.part_list_item, parent, false);
        return new ExcursionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExcursionViewHolder holder, int position) {
        if (mExcursions != null) {
            Excursion current = mExcursions.get(position);
            holder.titleView.setText(current.getTitle());
            holder.dateView.setText(current.getExcursionDate());
        } else {
            holder.titleView.setText("No excursion");
            holder.dateView.setText("");
        }
    }

    public void setExcursions(List<Excursion> excursions) {
        mExcursions = excursions;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mExcursions == null ? 0 : mExcursions.size();
    }
}
