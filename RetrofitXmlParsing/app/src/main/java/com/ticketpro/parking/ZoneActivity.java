package com.ticketpro.parking;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gdacciaro.iOSDialog.iOSDialog;
import com.gdacciaro.iOSDialog.iOSDialogBuilder;
import com.gdacciaro.iOSDialog.iOSDialogClickListener;
import com.ticketpro.parking.api.ApiRequest;
import com.ticketpro.parking.api.ServiceGenerator;
import com.ticketpro.parking.model.ArrayOfEnforcementZone;
import com.ticketpro.parking.model.ArrayOfParkingSpaces;
import com.ticketpro.parking.model.ArrayOfValidParkingData;
import com.ticketpro.parking.model.EnforcementZone;
import com.ticketpro.parking.model.ParkingSpaces;
import com.ticketpro.parking.model.ValidParkingData1;

import java.util.List;
import java.util.Random;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ZoneActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private MyAdapter mAdapter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView =  findViewById(R.id.my_recycler_view);


        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        _caleGetZone();

    }

    /*private void _caleGetZone() {

        if (isNetworkConnected()){
        progressDialog = new ProgressDialog(ZoneActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        progressDialog.show();
       *//* ApiRequest service = ServiceGenerator.createService(ApiRequest.class,"e_TurboData_1236","GuY;)8pW");
        service.getZone().enqueue(new Callback<ArrayOfEnforcementZone>() {
            @Override
            public void onResponse(Call<ArrayOfEnforcementZone> call, Response<ArrayOfEnforcementZone> response) {
                if (response.isSuccessful()){

                    List<EnforcementZone> enforcementZone = response.body().getEnforcementZone();

                    System.out.println(enforcementZone.toString());
                    if (enforcementZone.size() >0) {
                        mAdapter = new MyAdapter(enforcementZone);
                        mRecyclerView.setAdapter(mAdapter);
                        mAdapter.notifyDataSetChanged();
                    }
                    ZoneActivity.this.progressDialog.isShowing();
                    ZoneActivity.this.progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ArrayOfEnforcementZone> call, Throwable t) {
                ZoneActivity.this.progressDialog.isShowing();
                ZoneActivity.this.progressDialog.dismiss();
                System.out.println(t.getMessage());
            }
        });*//*

            // String url = "https://preproduction-svc-cwo2.calesystems.com/cwo2exportservice/Enforcement/1/EnforcementService.svc/get/" + s + "/5";
            String url = "https://preproduction-svc-cwo2.calesystems.com/cwo2exportservice/Enforcement/5/EnforcementService.svc/getallactivepurchases/Turbo A/5";
            ApiRequest service = ServiceGenerator.createService(ApiRequest.class, "e_TurboData_1236", "GuY;)8pW");
            service._validateParking(url).enqueue(new Callback<ArrayOfValidParkingData>() {

                @Override
                public void onResponse(Call<ArrayOfValidParkingData> call, Response<ArrayOfValidParkingData> response) {
                    if (response.isSuccessful()) {

                        List<ValidParkingData1> validParkingData = response.body().getValidParkingData();
                        if (validParkingData.size() > 0) {

                                mAdapter = new MyAdapter(validParkingData);
                                mRecyclerView.setAdapter(mAdapter);
                                mAdapter.notifyDataSetChanged();

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

    }else {
        Toast.makeText(getApplicationContext(),"",Toast.LENGTH_LONG).show();
    }
}
*/
    private void _caleGetZone() {

        if (isNetworkConnected()){
            progressDialog = new ProgressDialog(ZoneActivity.this);
            progressDialog.setMessage("Loading...");
            progressDialog.setCancelable(false);
            progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            progressDialog.show();
            ApiRequest service = ServiceGenerator.createService(ApiRequest.class,"","");
            service.getZone().enqueue(new Callback<ArrayOfEnforcementZone>() {
                @Override
                public void onResponse(Call<ArrayOfEnforcementZone> call, Response<ArrayOfEnforcementZone> response) {
                    if (response.isSuccessful()){

                        List<EnforcementZone> enforcementZone = response.body().getEnforcementZone();

                        System.out.println(enforcementZone.toString());
                        if (enforcementZone.size() >0) {
                            mAdapter = new MyAdapter(enforcementZone);
                            mRecyclerView.setAdapter(mAdapter);
                            mAdapter.notifyDataSetChanged();
                        }
                        ZoneActivity.this.progressDialog.isShowing();
                        ZoneActivity.this.progressDialog.dismiss();
                    }
                }

                @Override
                public void onFailure(Call<ArrayOfEnforcementZone> call, Throwable t) {
                    ZoneActivity.this.progressDialog.isShowing();
                    ZoneActivity.this.progressDialog.dismiss();
                    System.out.println(t.getMessage());
                }
            });

        }else {
            Toast.makeText(getApplicationContext(),"",Toast.LENGTH_LONG).show();
        }
    }

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private List<EnforcementZone> citationList;

        public MyAdapter(List<EnforcementZone> resposeHotlistListView) {
            this.citationList = resposeHotlistListView;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView txt_citation_no, mViolationTxt, mIssueDatetxt, mViolationCode, mViolDesc, mName;
            TextView mAddress;
            TextView mId;
            TextView mFine;
            TextView mCity;
            TextView mZip;
            LinearLayout mLyout;
            public ImageView img_id;

            public ViewHolder(View view) {
                super(view);
               // txt_citation_no = (TextView) view.findViewById(R.id.txt_citation_no);
                mAddress = (TextView) view.findViewById(R.id.txt_address);
                mLyout = (LinearLayout) view.findViewById(R.id.top2);
                //mId = (TextView) view.findViewById(R.id.txt_id);
               /* mIssueDatetxt = (TextView) view.findViewById(R.id.txt_issue_date);
                mViolationCode = (TextView) view.findViewById(R.id.txt_viol_code);
                mViolDesc = (TextView) view.findViewById(R.id.txt_viol_desc);
                img_id = (ImageView) view.findViewById(R.id.img_id);
                mFine = (TextView) view.findViewById(R.id.txt_fine);
                mCity = (TextView) view.findViewById(R.id.txt_address_city);
                mZip = (TextView) view.findViewById(R.id.txt_address_zip);
                mLyout = (LinearLayout) view.findViewById(R.id.ly_left);*/


            }
        }


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.rv_item_row, parent, false);

            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {

            try {

                String address = citationList.get(position).getName();
                if (address!=null){

                    holder.mAddress.setText(citationList.get(position).getName());
                }else {
                    holder.mAddress.setText("NA");
                }


                holder.mLyout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //_getZoneSpace(citationList.get(position).getName());
                        _initState("Turbo A");
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        @Override
        public int getItemCount() {
            return citationList.size();
        }
    }

    private void _getZoneSpace(String name) {

        if (isNetworkConnected()){

            {
                progressDialog = new ProgressDialog(ZoneActivity.this);
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(false);
                progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                progressDialog.show();

                String url = "";
                ApiRequest service = ServiceGenerator.createService(ApiRequest.class, "", "");
                service._getZoneSpace(url).enqueue(new Callback<ArrayOfParkingSpaces>() {

                    @Override
                    public void onResponse(Call<ArrayOfParkingSpaces> call, Response<ArrayOfParkingSpaces> response) {
                        if (response.isSuccessful()) {
                            if (response.body().getParkingSpaces().size() < 0) {

                                new iOSDialogBuilder(ZoneActivity.this)
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

                                List<ParkingSpaces> parkingSpaces = response.body().getParkingSpaces();
                                for (ParkingSpaces ps: parkingSpaces) {

                                    String id = ps.getId();
                                    bf.append("ID : " + id + "\n");

                                }

                                new iOSDialogBuilder(ZoneActivity.this)

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
                    public void onFailure(Call<ArrayOfParkingSpaces> call, Throwable t) {
                        progressDialog.isShowing();
                        progressDialog.dismiss();
                        System.out.println(t.getMessage());
                    }
                });

            }
        }
    }

    //
    private void _initState(String s) {


        if (isNetworkConnected()) {
            progressDialog = new ProgressDialog(ZoneActivity.this);
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
            String url = "";
            ApiRequest service = ServiceGenerator.createService(ApiRequest.class, "", "");
            service._validateParking(url).enqueue(new Callback<ArrayOfValidParkingData>() {

                @Override
                public void onResponse(Call<ArrayOfValidParkingData> call, Response<ArrayOfValidParkingData> response) {
                    if (response.isSuccessful()) {

                        List<ValidParkingData1> validParkingData = response.body().getValidParkingData();
                        if (validParkingData.size() < 0) {

                            new iOSDialogBuilder(ZoneActivity.this)
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
                            //txtView.setText(bf.toString());

                            // Use the Builder class for convenient dialog construction
                            final AlertDialog.Builder builder = new AlertDialog.Builder(ZoneActivity.this);
                            builder.setMessage(bf.toString())
                                    .setPositiveButton(R.string.fire, new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {


                                        }
                                    });

                            // Create the AlertDialog object and return it
                            builder.create();
                            builder.show();

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

    public boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
    }

    public int getRandomColor(){
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
}
