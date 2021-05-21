package com.example.flowerstore;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class searchadapter extends RecyclerView.Adapter<searchadapter.ViewHolder>
implements Filterable
{
    private Context context;
    private List<String> name;
   // private List<String> phone;
    private SearchsAdapterListener listener;




public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView namee;

    public ViewHolder(View view) {
        super(view);
        namee = view.findViewById(R.id.name);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onSelected(name.get(getAdapterPosition()));
            }
        });

    }
}

    public searchadapter(Context context, List<String> name, SearchsAdapterListener listener) {
        this.context = context;
        this.name = name;

        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.flowerlayout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final String namee = name.get(position);
        holder.namee.setText(namee);
    }
    @Override
    public int getItemCount() {
        return name.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {


            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String query = charSequence.toString();

                List<String> filtered = new ArrayList<>();

                if (query.isEmpty()) {
                    filtered = name;
                } else {
                    for (String movie : name) {
                        if (movie.toLowerCase().contains(query.toLowerCase())) {
                            filtered.add(movie);
                        }
                    }
                }

                FilterResults results = new FilterResults();
                results.count = filtered.size();
                results.values = filtered;
                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults results) {
                name = (ArrayList<String>) results.values;
                notifyDataSetChanged();
            }
        };

    }


    public interface SearchsAdapterListener {
        void onSelected(String item);
    }


}
