package com.ticketpro.parking;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gdacciaro.iOSDialog.iOSDialog;
import com.gdacciaro.iOSDialog.iOSDialogBuilder;
import com.gdacciaro.iOSDialog.iOSDialogClickListener;
import com.ticketpro.parking.api.ApiRequest;
import com.ticketpro.parking.api.ServiceGenerator;
import com.ticketpro.parking.model.ArrayOfPlaveSearch;
import com.ticketpro.parking.model.ArrayOfValidParkingData;
import com.ticketpro.parking.model.ValidParkingData;
import com.ticketpro.parking.model.ValidParkingData1;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlateSearch extends AppCompatActivity implements View.OnClickListener {

    private ProgressDialog progressDialog;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private EditText editText;
    private Button buttonSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plate_search);

        _initializeView();

    }

    private void _initializeView() {

        editText = (EditText) findViewById(R.id.editText);
        buttonSearch = (Button) findViewById(R.id.button);
        buttonSearch.setOnClickListener(this);

        //_initState("SS");
    }

    private void _initState(String s) {


        if (isNetworkConnected()) {
            progressDialog = new ProgressDialog(PlateSearch.this);
            progressDialog.setMessage("Loading...");
            progressDialog.setCancelable(false);
            progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            progressDialog.show();

           // String url = "https://preproduction-svc-cwo2.calesystems.com/cwo2exportservice/Enforcement/1/EnforcementService.svc/get/" + s + "/5";
            String url = "https://preproduction-svc-cwo2.calesystems.com/cwo2exportservice/Enforcement/5/EnforcementService.svc/getallactivepurchases/Turbo A/5";
            ApiRequest service = ServiceGenerator.createService(ApiRequest.class, "e_TurboData_1236", "GuY;)8pW");
            service._validateParking(url).enqueue(new Callback<ArrayOfValidParkingData>() {

                @Override
                public void onResponse(Call<ArrayOfValidParkingData> call, Response<ArrayOfValidParkingData> response) {
                    if (response.isSuccessful()) {

                        List<ValidParkingData1> validParkingData = response.body().getValidParkingData();
                        if (validParkingData.size() < 0) {

                            new iOSDialogBuilder(PlateSearch.this)
                                    .setSubtitle("No Record Found!!")
                                    .setCancelable(true)
                                    .setPositiveListener(getString(R.string._ok), new iOSDialogClickListener() {
                                        @Override
                                        public void onClick(iOSDialog dialog) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .build().show();
                        } else {
                            StringBuffer bf = new StringBuffer();
                            for (int i = 0; i <validParkingData.size() ; i++) {
                                ValidParkingData1 validParkingData1 = validParkingData.get(i);

                                bf.append("Plate : " + validParkingData1.getCode() + "\n");
                                bf.append("StartDate : " + validParkingData1.getStartDateUtc() + "\n");
                                bf.append("EndDate : " + validParkingData1.getEndDateUtc() + "\n");
                                bf.append("IsExpired : " + validParkingData1.getIsExpired() + "\n");
                                bf.append("------------------------------"+"\n");

                            }
                          // txtView.setText(bf.toString());

                        }
                        progressDialog.isShowing();
                        progressDialog.dismiss();
                    }
                }

                @Override
                public void onFailure(Call<ArrayOfValidParkingData> call, Throwable t) {
                    progressDialog.isShowing();
                    progressDialog.dismiss();
                    System.out.println(t.getMessage());
                }
            });

        } else {
            Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button:
                if (!TextUtils.isEmpty(editText.getText().toString())) {
                    _plateSearch(editText.getText().toString());
                }
                break;
        }
    }


    public boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
    }


    private void _plateSearch(String s) {


        if (isNetworkConnected()) {
            progressDialog = new ProgressDialog(PlateSearch.this);
            progressDialog.setMessage("Loading...");
            progressDialog.setCancelable(false);
            progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            progressDialog.show();

            String url = "https://preproduction-svc-cwo2.calesystems.com/cwo2exportservice/Enforcement/1/EnforcementService.svc/get/"+s+"/5";
            ApiRequest service = ServiceGenerator.createService(ApiRequest.class, "e_TurboData_1236", "GuY;)8pW");
            service._serchPlate(url).enqueue(new Callback<ArrayOfPlaveSearch>() {

                @Override
                public void onResponse(Call<ArrayOfPlaveSearch> call, Response<ArrayOfPlaveSearch> response) {
                    if (response.isSuccessful()) {
                        if (response.body().getValidParkingData() == null) {

                            new iOSDialogBuilder(PlateSearch.this)
                                    .setSubtitle("No Record Found!!")
                                    .setCancelable(false)
                                    .setPositiveListener(getString(R.string._ok), new iOSDialogClickListener() {
                                        @Override
                                        public void onClick(iOSDialog dialog) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .build().show();
                        } else {
                            StringBuffer bf = new StringBuffer();
                            bf.append("Code : " + response.body().getValidParkingData().getCode() + "\n");
                            bf.append("StartDate : " + response.body().getValidParkingData().getStartDateUtc() + "\n");
                            bf.append("EndDate : " + response.body().getValidParkingData().getEndDateUtc() + "\n");
                            bf.append("IsExpired : " + response.body().getValidParkingData().getIsExpired() + "\n");
                            new iOSDialogBuilder(PlateSearch.this)

                                    .setSubtitle(bf.toString())
                                    .setCancelable(false)
                                    .setPositiveListener(getString(R.string._ok), new iOSDialogClickListener() {
                                        @Override
                                        public void onClick(iOSDialog dialog) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .build().show();
                        }
                        progressDialog.isShowing();
                        progressDialog.dismiss();
                    }
                }

                @Override
                public void onFailure(Call<ArrayOfPlaveSearch> call, Throwable t) {
                    progressDialog.isShowing();
                    progressDialog.dismiss();
                    System.out.println(t.getMessage());
                }
            });

        } else {
            Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();
        }
    }

}
