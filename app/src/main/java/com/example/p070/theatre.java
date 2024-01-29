package com.example.p070;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class theatre extends AppCompatActivity {
    TextView tvInfo;
    EditText tvName;
    theatre.MyTask mt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theatre);
        tvInfo = (TextView) findViewById(R.id.tvInfo);
        tvName = (EditText) findViewById(R.id.editTextTextPersonName);
    }
    public void onclick(View v) {
        mt = new theatre.MyTask();
        mt.execute(tvName.getText().toString());
    }
    public class MyTask extends AsyncTask<String, Void, ArrayList<String[]>> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tvInfo.setText("Begin");
        }

        @Override
        protected ArrayList<String[]> doInBackground(String... params) {
            ArrayList<String[]> res = new ArrayList<>();


            return res;
        }

        @Override
        protected void onPostExecute(ArrayList<String[]> result) {
            // super.onPostExecute(result);
            theatre.ClAdapter clAdapter = new theatre.ClAdapter(tvInfo.getContext(), result);
            ListView lvMain = (ListView) findViewById(R.id.lvMain);
            lvMain.setAdapter(clAdapter);
            tvInfo.setText("End");
        }
    }


    class ClAdapter extends BaseAdapter {
        Context ctx;
        LayoutInflater lInflater;
        List<String[]> lines;

        ClAdapter(Context context, List<String[]> elines) {
            ctx = context;
            lines = elines;
            lInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return lines.size();
        }

        @Override
        public Object getItem(int position) {
            return lines.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                view = lInflater.inflate(R.layout.item, parent, false);
            }
            String[] p = (String[]) getItem(position);
            ((TextView) view.findViewById(R.id.tvText)).setText(p[0]);
            ((TextView) view.findViewById(R.id.tvText1)).setText(p[1]);
            return view;
        }
    }
}




