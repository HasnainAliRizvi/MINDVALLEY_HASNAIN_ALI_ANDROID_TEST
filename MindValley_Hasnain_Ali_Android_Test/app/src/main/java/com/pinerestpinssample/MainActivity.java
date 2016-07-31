package com.pinerestpinssample;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.Display;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.etsy.android.grid.StaggeredGridView;
import com.pinerestpinssample.adt.AdtPinterestDetail;
import com.pinerestpinssample.utils.PinterestData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener {

    private Context context;
    private StaggeredGridView mGridViewDetail;
    private AdtPinterestDetail adtPintrestDetail;

    private JsonArrayRequest jsonObjReq;
    private HashMap<String, String> hashmapPintDetail;
    private ArrayList<PinterestData> listPinterestDetail = new ArrayList<PinterestData>();

    private String  urlUSOCPinterestDetail = "http://pastebin.com/raw/wgkJgazE";

    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        context = MainActivity.this;
        getScreenWidth();
        setFindVByID();
        swipeRefreshLayout.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        makeJsonReqDetail(urlUSOCPinterestDetail, 0);
                                    }
                                }
        );

    }

    private void getScreenWidth() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        Constants.screenHeight = size.y;
        Constants.screenWidth = size.x;
    }


    private void setFindVByID() {
        mGridViewDetail = (StaggeredGridView) findViewById(R.id.grid_view_details);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setColorSchemeResources(R.color.background_color_blue,R.color.red,R.color.green);
        swipeRefreshLayout.setOnRefreshListener(this);

    }

    @Override
    public void onRefresh() {
        makeJsonReqDetail(urlUSOCPinterestDetail, 2);
    }

    private void makeJsonReqDetail(final String url, final int state) {

        swipeRefreshLayout.setRefreshing(true);



        jsonObjReq = new JsonArrayRequest( url,
                new com.android.volley.Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {

                        try {
                            if(state==0 || state ==2)
                                listPinterestDetail.clear();


                            for (int i = 0; i < response.length(); i++) {
                                PinterestData pinterestData=new PinterestData();

                                pinterestData.Setname(response.getJSONObject(i).getJSONObject("user").getString(
                                        "name"));


                                pinterestData.SetColor(response.getJSONObject(i).getString(
                                        "color"));

                                try {
                                    Constants.dimensionReturner(response.getJSONObject(i)
                                            .getString("width"), response.getJSONObject(i)
                                            .getString("height"));

                                    int height = (int) (Integer
                                            .parseInt(Constants.socialImageHeight) / 2);

                                    pinterestData.SetHeight(height);
                                    int width = (int) (Integer
                                            .parseInt(Constants.socialImagewidth) / 2);

                                    pinterestData.SetWidth(width);

                                } catch (Exception e) {

                                }

                                pinterestData.SetUrlsfull(
                                        response.getJSONObject(i)
                                                .getJSONObject("user")
                                                .getJSONObject("profile_image")
                                                .getString("large"));

                                listPinterestDetail.add(pinterestData);

                            }

                            adtPintrestDetail = new AdtPinterestDetail(context,
                                    listPinterestDetail);
                            mGridViewDetail.setAdapter(adtPintrestDetail);

                            swipeRefreshLayout.setRefreshing(false);
                        } catch (Exception e) {
                                swipeRefreshLayout.setRefreshing(false);
                        }

                    }
                }, new com.android.volley.Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                swipeRefreshLayout.setRefreshing(false);

                Toast.makeText(context, error.getMessage(),
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq);

    }


}
