package com.upc.aforofront.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.upc.aforofront.R;
import com.upc.aforofront.ui.dashboard.DashboardFragment;
import com.upc.aforofront.view.Marca;
import com.upc.aforofront.view.MarcaAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private List<Marca> MarcaList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MarcaAdapter mAdapter;

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardFragment dashboardFragment = new DashboardFragment();

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        
        recyclerView = (RecyclerView) root.findViewById(R.id.marcarecycler);

        mAdapter = new MarcaAdapter(MarcaList,getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(root.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.addItemDecoration(new DividerItemDecoration(this.getContext(), LinearLayoutManager.VERTICAL));

        mAdapter.setOnClicListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("idmarca",MarcaList.get(recyclerView.getChildAdapterPosition(view)).getId());
                Navigation.findNavController(root).navigate(R.id.navigation_dashboard, bundle);
            }
        });

        recyclerView.setAdapter(mAdapter);

        prepareMarcaData();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private void prepareMarcaData() {

        String url = "http://aforoactual.mypressonline.com/index.php/marcas";

        StringRequest stringRequest= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);

                    List<String> items = new ArrayList<>();
                    for (int i=0; i<jsonArray.length(); i++){
                        JSONObject object = jsonArray.getJSONObject(i);
                        MarcaList.add(new Marca(
                                object.getString("id"),
                                object.getString("nombre"),
                                object.getString("imagen")));
                    }

                    mAdapter.notifyDataSetChanged();


                } catch (JSONException e) {
                    Log.i("======>", e.getMessage());
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("======>", error.toString());
                    }
                }
        );
        RequestQueue requestQueue= Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);

    }
    
}