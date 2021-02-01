package com.upc.aforofront.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.upc.aforofront.R;
import com.upc.aforofront.recycler.Listado;
import com.upc.aforofront.recycler.ListadoAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private List<Listado> listadoList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ListadoAdapter mAdapter;


    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        recyclerView = (RecyclerView) root.findViewById(R.id.establecimientorecycler);

        mAdapter = new ListadoAdapter(listadoList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(root.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.addItemDecoration(new DividerItemDecoration(this.getContext(), LinearLayoutManager.VERTICAL));


        recyclerView.setAdapter(mAdapter);

        prepareListadoData();

        return root;
    }

    private void prepareListadoData() {
        Listado listado = new Listado();

        listado = new Listado("1","Metro","URL");
        listadoList.add(listado);

        listado = new Listado("2","Plaza Vea","URL");
        listadoList.add(listado);

        listado = new Listado("3","Precio Uno","URL");
        listadoList.add(listado);

        listado = new Listado("4","Tottus","URL");
        listadoList.add(listado);

        listado = new Listado("5","Vivanda","URL");
        listadoList.add(listado);listado = new Listado("1","Metro","URL");

        listado = new Listado("6","Wong","URL");
        listadoList.add(listado);

        mAdapter.notifyDataSetChanged();
    }

}