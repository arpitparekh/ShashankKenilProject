package mridul.rathore.shashankkenilproject.recyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import mridul.rathore.shashankkenilproject.databinding.EmpRowItemBinding;

public class EmpAdapter extends RecyclerView.Adapter<EmpAdapter.EmpViewHolder> implements Filterable {


    ArrayList<Employee> list = new ArrayList<>();
    ArrayList<Employee> copyList = new ArrayList<>();
    OnClickInterface onClickInterface;

    public void setOnClickInterface(OnClickInterface onClickInterface) {
        this.onClickInterface = onClickInterface;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.list = employees;
        copyList = new ArrayList<>(employees);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                ArrayList<Employee>tempList = new ArrayList<>();

                if(constraint.toString().isEmpty() && list.isEmpty()){

                    tempList.addAll(copyList);
                }
                for(Employee e : copyList){

                    if(e.name.toLowerCase().contains(constraint.toString().toLowerCase())) {

                        tempList.add(e);

                    }
                }
                FilterResults results = new FilterResults();
                results.values = tempList;

                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                list.clear();

                ArrayList<Employee> newList = (ArrayList<Employee>) results.values;

                list = newList;

                notifyDataSetChanged();

            }
        };
    }

    public interface OnClickInterface{   // click event

        void onClick(int position);
        void onLongClick(int position);
    }

    @NonNull
    @Override  // handles individual list item view
    public EmpViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

//        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        EmpRowItemBinding binding = EmpRowItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        EmpViewHolder viewHolder = new EmpViewHolder(binding);
        return viewHolder;
    }

    public class EmpViewHolder extends RecyclerView.ViewHolder {
        private EmpRowItemBinding binding;
        public EmpViewHolder(@NonNull EmpRowItemBinding binding) {  // handles child's view
            super(binding.getRoot());
            this.binding=binding;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull EmpViewHolder holder, int position) {  // bind data with view

        Employee employee = list.get(position);
        holder.binding.setEmp(employee);   // dataBinding

        holder.itemView.setOnClickListener(v -> {
            onClickInterface.onClick(position);
        });

        holder.itemView.setOnLongClickListener(v -> {

            onClickInterface.onLongClick(position);

            return true;
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
