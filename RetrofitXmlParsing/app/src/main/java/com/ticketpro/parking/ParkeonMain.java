package com.ticketpro.parking;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.ksoap2.HeaderProperty;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;
import java.util.List;

public class ParkeonMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parkeon_main);

        new Parkeon().execute();

    }

    private class Parkeon extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            final String SOAP_ACTION = "http://www.parkeonsmartcenter.com:90/pbp_enforcement_api/";
            final String METHOD_NAME = "pbp_enforcement_api";
            final String NAMESPACE = "http://www.parkeonsmartcenter.com:90";
            final String URL = "https://www.prm.parkeonsmartcenter.com:4443/pbp_enforcement_api/index.php";


            SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME);


            Request.addProperty("type","control_groups");
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(Request);
            //envelope.addMapping(NAMESPACE, "Bean",new Bean().getClass());
            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
            androidHttpTransport.debug = true;

            try
            {
                List<HeaderProperty> headerList = new ArrayList<HeaderProperty>();
                headerList.add(new HeaderProperty("Authorization", "Basic " + org.kobjects.base64.Base64.encode("turbodata_394_test:GeQgfyU7HB+7hkAT".getBytes())));

                androidHttpTransport.call(SOAP_ACTION, envelope, headerList);
                SoapObject response = (SoapObject)envelope.getResponse();
                response.getProperty(0).toString();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

            return null;
        }
    }
}
