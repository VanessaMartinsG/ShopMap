package com.example.prototipo_shop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.prototipo_shop.ShoppingValue;
import com.example.prototipo_shop.ShoppingDAO;
import com.example.prototipo_shop.lineHolder;
import com.example.prototipo_shop.LineAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link pgFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class pgFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    RecyclerView mRecyclerView;
    private  LineAdapter mAdapter;
    private View rootView;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public pgFragment() {
        // Required empty public constructor
    }



    // TODO: Rename and change types and number of parameters
    public static pgFragment newInstance() {
        pgFragment fragment = new pgFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView= inflater.inflate(R.layout.fragment_pg, container, false);
        ShoppingDAO shoppingdao = new ShoppingDAO(rootView.getContext());

        //shoppingdao.drop();
       /*ShoppingValue shoppingvalue = new ShoppingValue();
        shoppingvalue.setNome("Shopping Salvador");
        shoppingvalue.setFav(0);
        shoppingdao.CadastrarShop(shoppingvalue);


        ShoppingValue shoppingvalue2 = new ShoppingValue();
        shoppingvalue2.setNome("Shopping da Bahia");
        shoppingvalue2.setFav(0);
        shoppingdao.CadastrarShop(shoppingvalue2);


        ShoppingValue shoppingvalue3 = new ShoppingValue();
        shoppingvalue3.setNome("Shopping Bella Vista");
        shoppingvalue3.setFav(0);
        shoppingdao.CadastrarShop(shoppingvalue3);
        shoppingdao.close();*/
        this.setupRecycler();
        return rootView;
    }

    private void setupRecycler() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.favPlacesRView);

        mRecyclerView.setLayoutManager(layoutManager);

        ShoppingDAO shoppingDAO = new ShoppingDAO(this.getContext());
        shoppingDAO.todos();

        //ArrayList<ShoppingValue> shoppingvalue = (ArrayList<ShoppingValue>) new ArrayList(shoppingDAO.todos());

        /*shoppingDAO.close();
        LineAdapter lineradapter = new LineAdapter(shoppingvalue, (LineAdapter.ItemClickListener) this);
        mRecyclerView.setAdapter(lineradapter);*/
    }

}