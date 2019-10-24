package com.example.primerapractica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main2Activity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

    RequestQueue rq;
    JsonRequest jrq;
    EditText email, pwd;
    Button btnConsultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    //public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.activity_main2, container, false);
        //View vista = inflater.inflate(R.layout.activity_main2, container, false);
        email = (EditText)findViewById(R.id.editText2);
        pwd = (EditText)findViewById(R.id.editText3);
        btnConsultar = (Button)findViewById(R.id.button);
        rq = Volley.newRequestQueue(this);

        btnConsultar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
              iniciarSesion();

            }
        });


    }



    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "No se encontró el usuario" + error.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        Users usuario = new Users();
        Toast.makeText(this, "Se ha encontrado el usuario" + email.getText().toString(), Toast.LENGTH_SHORT).show();

        JSONArray jsonArray = response.optJSONArray("datos");
        JSONObject jsonObject = null;

        try {
            jsonObject = jsonArray.getJSONObject(0);
            usuario.setEmail(jsonObject.optString("email"));
            usuario.setPassword(jsonObject.optString("password"));
            usuario.setName(jsonObject.optString("name"));
        } catch (JSONException e){
            e.printStackTrace();
        }

        Intent intencion = new Intent(this, Inicio_Sesion.class);
        intencion.putExtra(Inicio_Sesion.user, usuario.getName());
        startActivity(intencion);
    }




    private void iniciarSesion(){
        String url="http:///10.160.1.149:8080/practica_moviles/sesion.php?email="+email.getText().toString()+
                "$password"+pwd.getText().toString();
        jrq = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        rq.add(jrq);
    }


}
