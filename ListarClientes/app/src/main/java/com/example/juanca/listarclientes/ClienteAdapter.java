package com.example.juanca.listarclientes;

import android.app.Activity;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.juanca.entidades.Cliente;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juanca on 29/08/2016.
 */
public class ClienteAdapter extends BaseAdapter {

    private final Activity actividad;
    public List<Cliente> lista;

    public ClienteAdapter(Activity actividad) {
        this.actividad = actividad;
    }

    public List<Cliente> getLista() {
        return lista;
    }

    public void setLista(List<Cliente> lista) {
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        LayoutInflater inflater=actividad.getLayoutInflater();
        View vista = inflater.inflate(R.layout.elemento_cliente, null, true);

        TextView txtcodigo = (TextView) vista.findViewById(R.id.txtcodigo);
        txtcodigo.setText(lista.get(i).getCedula().toString());

        TextView txtnombre = (TextView) vista.findViewById(R.id.txtnombre);
        txtnombre.setText(lista.get(i).getNombre());

        return vista;






    }
}
