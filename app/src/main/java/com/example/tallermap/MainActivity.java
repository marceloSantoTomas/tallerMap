package com.example.tallermap;  // Declaración del paquete en el que se encuentra la clase.

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.VideoView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {
    // Declaración de la clase MainActivity que hereda de AppCompatActivity e implementa tres interfaces.

    EditText txt_Latitud, txt_Longitud;  // Declaración de campos de texto para mostrar coordenadas.
    GoogleMap mMap;  // Declaración de un objeto GoogleMap para representar el mapa.



    Button btnVideo;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnVideo = findViewById(R.id.btnVideo);
        videoView = findViewById(R.id.videoView);

        // Configuracion de la ubicación del video
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.tomas);

        videoView.setVideoURI(videoUri);

        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Se inicia la reproducción del video cuando se presiona el botón
                videoView.start();
            }
        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                // Aquí se ejecutará cuando el video haya terminado de reproducirse para posteriormente ocultarlo
                videoView.setVisibility(View.INVISIBLE); // Ocultar el VideoView
            }
        });





        // Configuración de la actividad y asignación del diseño de la interfaz de usuario.

        txt_Latitud = findViewById(R.id.txtLatitud);  // Asignación del campo de texto para latitud.
        txt_Longitud = findViewById(R.id.txtLongitud);  // Asignación del campo de texto para longitud.

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        // Obtención del fragmento del mapa desde el diseño de la interfaz.

        mapFragment.getMapAsync(this);  // Notificación de que la actividad está lista para recibir notificaciones cuando el mapa esté listo.
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;  // Configuración del objeto GoogleMap con el mapa proporcionado.

        this.mMap.setOnMapClickListener(this);  // Registro del evento de clic en el mapa.
        this.mMap.setOnMapLongClickListener(this);  // Registro del evento de clic largo en el mapa.

        LatLng temuco = new LatLng(-38.73385501470279, -72.60202086517344);  // Creación de una ubicación en Chile.
        mMap.addMarker(new MarkerOptions().position(temuco).title("Santo Tomas Temuco"));
        // Agregado de un marcador en la ubicación "temuco" con un título.


        mMap.moveCamera(CameraUpdateFactory.newLatLng(temuco));
        // Movimiento de la cámara para centrarla en la ubicación "temuco".


        LatLng arica = new LatLng(-17.69375825506076, -70.43197513197546);
        mMap.addMarker(new MarkerOptions().position(arica).title("Arica"));

        LatLng iquique = new LatLng(-20.239260088348672, -70.14477542412226);
        mMap.addMarker(new MarkerOptions().position(iquique).title("iquique"));

        LatLng antofagasta = new LatLng(-23.63363031846657, -70.39379516771194);
        mMap.addMarker(new MarkerOptions().position(antofagasta).title("antofagasta"));

        LatLng laSerena = new LatLng(-29.907772996858753, -71.25756958168336);
        mMap.addMarker(new MarkerOptions().position(laSerena).title("la Serena"));

        LatLng vinaDelMar = new LatLng(-33.03620217229466, -71.51734871214);
        mMap.addMarker(new MarkerOptions().position(vinaDelMar).title("vina Del Mar"));

        LatLng santiago = new LatLng(-33.448854768825605, -70.66221835428941);
        mMap.addMarker(new MarkerOptions().position(santiago).title("santiago"));

        LatLng puertoMontt = new LatLng(-41.47194504483459, -72.92891787832441);
        mMap.addMarker(new MarkerOptions().position(puertoMontt).title("puerto Montt"));

        LatLng talca = new LatLng(-41.371665248771606, -72.93092644891975);
        mMap.addMarker(new MarkerOptions().position(talca).title("talca"));

        LatLng concepcion = new LatLng(-36.82458623454118, -73.06168808274853);
        mMap.addMarker(new MarkerOptions().position(concepcion).title("concepcion"));

        LatLng losAngeles = new LatLng(-37.471442674571115, -72.35408078148828);
        mMap.addMarker(new MarkerOptions().position(losAngeles).title("los Angeles"));

        LatLng valdivia = new LatLng(-39.77270584688688, -73.23448056511639);
        mMap.addMarker(new MarkerOptions().position(valdivia).title("valdivia"));

        LatLng osorno = new LatLng(-40.57139916379145, -73.13758650234679);
        mMap.addMarker(new MarkerOptions().position(osorno).title("osorno"));
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        txt_Latitud.setText(String.valueOf(latLng.latitude));  // Muestra la latitud en el campo de texto.
        txt_Longitud.setText(String.valueOf(latLng.longitude));  // Muestra la longitud en el campo de texto.
    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        txt_Latitud.setText(String.valueOf(latLng.latitude));  // Muestra la latitud en el campo de texto.
        txt_Longitud.setText(String.valueOf(latLng.longitude));  // Muestra la longitud en el campo de texto.
    }
}