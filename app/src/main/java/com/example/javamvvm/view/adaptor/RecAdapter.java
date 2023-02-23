package com.example.javamvvm.view.adaptor;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.javamvvm.R;
import com.example.javamvvm.model.User;

import java.util.List;

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.ViewHolderUser> {

    private final List<User> localDataSet;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */

    //item_title
    public static class ViewHolderUser extends RecyclerView.ViewHolder {
        private final TextView textName, textEmail;

        public ViewHolderUser(View view) {
            super(view);

            textName = view.findViewById(R.id.textName);
            textEmail = view.findViewById(R.id.textEmail);
        }

    }

    /**
     * Initialize the dataset of the Adapter
     *
     * @param dataSet ArrayList<String> containing the data to populate views to be used
     *                by RecyclerView
     */
    public RecAdapter(List<User> dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    // RecyclerView calls this method whenever it needs to create a new ViewHolder.
    // The method creates and initializes the ViewHolder and its associated View,
    // but does not fill in the view's contents—the ViewHolder has not yet been bound to specific data.
    @NonNull
    @Override
    public ViewHolderUser onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_title, viewGroup, false);

        return new ViewHolderUser(view);
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolderUser viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        viewHolder.textName.setText(String.format("%s %s", localDataSet.get(position).getFirstName(), localDataSet.get(position).getLastName()));
        viewHolder.textEmail.setText(localDataSet.get(position).getEmail());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

}
