package com.example.juanca.listarclientes;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import com.example.juanca.entidades.Cliente;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juanca on 28/08/2016.
 */
public class ListarClientes extends ListActivity {

    private ClienteAdapter clienteAdapter;
    private List<Cliente> listado = new ArrayList<>();

    // Progress Dialog Object
    ProgressDialog prgDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.listar_clientes);

        //AsyncCallWS async=new AsyncCallWS();
        //async.execute();

        clienteAdapter=new ClienteAdapter(this);

        prgDialog = new ProgressDialog(this);
        // Set Progress Dialog Text
        prgDialog.setMessage("Please wait...");
        // Set Cancelable as False
        prgDialog.setCancelable(false);

        RequestParams params = new RequestParams();
        invokeWS(params);



    }

    private class AsyncCallWS extends AsyncTask<String, Void, Void>{
            @Override
            protected Void doInBackground(String... params){

                listado=WebService.listarClientes("ListarClientes");
                return null;
            }
            @Override
            protected void onPostExecute(Void result){
                clienteAdapter.setLista(listado);
                setListAdapter(clienteAdapter);

            }

            @Override
            protected void  onPreExecute(){


            }
            @Override
            protected void onProgressUpdate(Void... values){


            }





    }


    /**
     * Method that performs RESTful webservice invocations
     *
     * @param params
     */
    public void invokeWS(RequestParams params){
        // Show Progress Dialog
        prgDialog.show();
        // Make RESTful webservice call using AsyncHttpClient object
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://10.0.2.2:8080/Lavacor/webresources/lavacor.entidades.cliente",params ,
                new AsyncHttpResponseHandler() {
                    // When the response returned by REST has Http response code '200'
                    @Override
                    public void onSuccess(String response) {
                        // Hide Progress Dialog

                        try {
                            // JSON Object
                            JSONArray arreglo= new JSONArray(response);


                            for(int i=0;i<arreglo.length();i++)
                            {
                                JSONObject obj = arreglo.getJSONObject(i);
                                Cliente cliente= new Cliente(obj.getString("cedula"), obj.getString("nombre"));

                                listado.add(cliente);
                            }

                            clienteAdapter.setLista(listado);
                            setListAdapter(clienteAdapter);


                        } catch (JSONException e) {
                            // TODO Auto-generated catch block
                            Toast.makeText(getApplicationContext(), "Error Occured [Server's JSON response might be invalid]!", Toast.LENGTH_LONG).show();
                            e.printStackTrace();

                        }
                        prgDialog.hide();
                    }
                    // When the response returned by REST has Http response code other than '200'
                    @Override
                    public void onFailure(int statusCode, Throwable error,
                                          String content) {
                        // Hide Progress Dialog
                        prgDialog.hide();
                        // When Http response code is '404'
                        if(statusCode == 404){
                            Toast.makeText(getApplicationContext(), "Requested resource not found", Toast.LENGTH_LONG).show();
                        }
                        // When Http response code is '500'
                        else if(statusCode == 500){
                            Toast.makeText(getApplicationContext(), "Something went wrong at server end", Toast.LENGTH_LONG).show();
                        }
                        // When Http response code other than 404, 500
                        else{
                            Toast.makeText(getApplicationContext(), "Unexpected Error occcured! [Most common Error: Device might not be connected to Internet or remote server is not up and running]", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }



}
