package com.douglasjing.expresstime.ui.station;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.douglasjing.expresstime.R;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MainFragment extends Fragment {

    private Handler handler;
    private Runnable runnable;

    String stationName;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_home, container, false);


        //获取当前站点
        stationName = getArguments().getString("stationName");
        //Toast.makeText(getActivity(),stationName,Toast.LENGTH_SHORT).show();
        TextView stationTV = (TextView)view.findViewById(R.id.station);
        stationTV.setText(stationName);

        //首次Fragment启动更新信息
        //获取当前站点东行快车时刻表
        timeComparsionEast(view,stationPickerEast(view,stationName));
        //获取当前站点西行快车时刻表
        timeComparsionWest(view,stationPickerWest(view,stationName));


        //确保信息自动更新（间隔30s）
        handler = new Handler(Looper.getMainLooper());
        runnable = new Runnable() {
            @Override
            public void run() {
                //更新UI或执行其他操作
                //获取当前站点东行快车时刻表
                timeComparsionEast(view,stationPickerEast(view,stationName));
                //获取当前站点西行快车时刻表
                timeComparsionWest(view,stationPickerWest(view,stationName));

                // 30秒后再次调用自身
                handler.postDelayed(this, 2000);
            }
        };

        // 第一次调用方法
        handler.postDelayed(runnable, 30000);



            return view;
        }

        //用于返回开往增城广场方向快车时刻表
        public String[] stationPickerEast(View v,String stationName){
        String[] trainTimeEast = new String[0];
            switch(stationName){
                case "员村":
                    String[] yuancun = new String[]
                     {"06:22","06:52","07:23","07:54","08:24","08:54","09:31","10:20","11:08","11:56","12:44",
                            "13:32","14:20","15:08","15:55","16:39","17:12","17:44","18:16","18:46","19:16","19:57","20:43","21:28"};
                    trainTimeEast = yuancun;
                    break;
                case "天河公园":
                    String[] tianhePark = new String[]
                     {"06:27","06:58","07:28","07:59","08:29","08:59","09:35","10:23","11:11","11:59","12:47","13:35","14:23","15:11","15:59","16:43","17:17","17:48","18:20","18:51"
                            ,"19:22","20:01","20:47","21:32"};
                    trainTimeEast = tianhePark;
                    break;

                case "棠东":
                    String[] tangdong = new String[]
                            {"06:31","07:02","07:23","08:03","08:33","09:03","09:39","10:28","11:16","12:04","12:52","13:40"
                            ,"14:28","15:16","16:03","16:47","17:21","17:52","18:24","18:55","19:26","20:05","20:51","21:36"};
                    trainTimeEast = tangdong;
                    break;

                case "黄村":
                    String[] huangcun = new String[]
                            {"06:34","07:05","07:35","08:06","08:36","09:06","09:42","10:31","11:19","12:07","12:55",
                            "13:43","14:31","15:19","16:06","16:50","17:24","17:55","18:27","18:58","19:29","20:08","20:54","21:39"};
                    trainTimeEast = huangcun;
                    break;

                case "天河智慧城":
                    String[] tianheSmartCity = new String[]
                            {"06:38","07:08","07:38","08:09","08:39","09:09","09:46","10:34","11:22","12:10","12:58","13:46","14:34",
                            "15:22","16:10","16:54","17:27","17:59","18:30","19:02","19:32","20:12","20:58","21:43"};
                    trainTimeEast = tianheSmartCity;
                    break;

                case "神舟路":
                    String[] shenzhouRoad = new String[]
                            {"06:41","07:12","07:42","08:13","08:43","09:13","09:50","10:38","11:26","12:14","13:02","13:50","14:38","15:26",
                                    "16:14","16:58","17:31","18:03","18:34","19:05","19:36","20:16","21:02","21:47"};
                    trainTimeEast = shenzhouRoad;
                    break;

                case "苏元":
                    String[] suyuan = new String[]
                            {"06:46","07:17","07:47","08:18","08:48","09:18","09:55","10:43","11:31","12:19","13:07","13:55","14:43","15:31",
                            "16:19","17:03","17:36","18:07","18:39","19:10","19:41","20:20","21:04","21:52"};
                    trainTimeEast = suyuan;
                    break;

                case "水西":
                    String[] shuixi = new String[]
                            {"06:49","07:20","07:50","08:21","08:51","09:21","09:58","10:47","11:35","12:23","13:11","13:59","14:47","15:35",
                            "16:22","17:06","17:39","18:10","18:42","19:13","19:44","20:24","21:10","21:55"};
                    trainTimeEast = shuixi;
                    break;

                case "镇龙":
                    String[] zhenlong = new String[]
                            {"07:01","07:32","08:03","08:35","09:05","09:35","10:12","11:00","11:48","12:36","13:24","14:12","15:00","15:48",
                            "16:36","17:21","17:51","18:24","18:55","19:26","19:56","20:33","21:15","22:03"};
                    trainTimeEast = zhenlong;
                    break;

                case "凤岗":
                    String[] fenggang = new String[]
                            {"07:09","07:39","08:10","08:41","09:11","09:41","10:19","11:08","11:56","12:44","13:32","14:20","15:08","15:56","16:44",
                                    "17:27","17:59","18:30","19:02","19:33","20:04","20:45","21:31","22:17"};
                    trainTimeEast = fenggang;
                    break;

                case "增城广场":

                    break;


            }
                return trainTimeEast;
        }


        //用于返回开往员村方向快车时刻表
         public String[] stationPickerWest(View v,String stationName){
            String[] trainTimeWest = new String[0];

             switch(stationName){
                 case "天河智慧城":
                     String[] tianheSmartCity = new String[]
                             {"07:06","07:36","08:07","08:37","09:07","09:38","10:08","10:46","11:34","12:22","13:10","13:58","14:46","15:34","16:23","17:07",
                             "17:37","18:08","18:38","19:09","19:39","20:10","20:53","21:40","22:29"};
                     trainTimeWest = tianheSmartCity;
                     break;

                 case "神舟路":
                     String[] shenzhouRoad = new String[]
                             {"07:02","07:32","08:03","08:33","09:03","09:34","10:04","10:42","11:30","12:18","13:06","13:54","14:42","15:30","16:19",
                             "17:03","17:33","18:04","18:34","19:05","19:35","20:06","20:49","21:36","22:25"};
                     trainTimeWest = shenzhouRoad;
                     break;

                 case "苏元":
                     String[] suyuan = new String[]
                             {"06:58","07:28","07:58","08:29","08:59","09:29","09:59","10:37","11:26","12:14","13:02","13:50","14:38","15:26","16:14",
                             "16:59","17:29","17:59","18:30","19:00","19:31","20:01","20:45","21:31","22:20"};
                     trainTimeWest = suyuan;
                     break;

                 case "水西":
                     String[] shuixi = new String[]
                             {"06:54","07:25","07:55","08:25","08:56","09:26","09:56","10:34","11:23","12:11","12:59","13:47","14:35","15:23","16:11",
                                     "16:55","17:26","17:56","18:27","18:57","19:27","19:58","20:41","21:28","22:17"};
                     trainTimeWest = shuixi;
                     break;

                 case "镇龙":
                     String[] zhenlong = new String[]
                             {"06:42","07:12","07:43","08:13","08:43","09:14","09:43","10:21","11:09","11:57","12:45","13:33","14:21","15:09","15:57",
                             "16:42","17:13","17:44","18:14","18:45","19:15","19:45","20:28","21:14","22:03"};
                     trainTimeWest = zhenlong;
                     break;

                 case "凤岗":
                     String[] fenggang = new String[]
                             {"06:35","07:05","07:36","08:06","08:36","09:07","09:35","10:13","11:01","11:49","12:37","13:25","14:13","15:01","15:50",
                             "16:34","17:06","17:36","18:07","18:37","19:08","19:38","20:20","21:07","21:55"};
                     trainTimeWest = fenggang;
                     break;

                 case "增城广场":
                     String[] zengchengSquare = new String[]
                             {"06:17","06:46","07:18","07:48","08:19","08:50","09:17","09:58","10:45","11:33","12:21","13:09","13:57","14:45","15:33","16:20",
                                     "16:52","17:26","17:57","18:27","19:00","19:31","20:06","20:52","21:38"};
                     trainTimeWest = zengchengSquare;
                     break;

                 default:

                     break;
             }




            return trainTimeWest;
            }




        //东行时间比较方法
        public void timeComparsionEast(View v,String[] trainTime){
        //若到站时间数组为空，则说明是终点站，显示不适用
            if(trainTime.length == 0){
                TextView nextTrainEast = (TextView) v.findViewById(R.id.nextTrainEast);
                nextTrainEast.setText("不适用");
        //若到站时间不为空，则显示最近的时间
            }else{
                TextView nextTrainEast = (TextView) v.findViewById(R.id.nextTrainEast);

                Calendar c = Calendar.getInstance();
                @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                String currentTime = sdf.format(c.getTime());




                for (int i = 0; i < trainTime.length; i++) {
                    //String time = sdf.format(trainTime[i]);
                    if (currentTime.compareTo(trainTime[i]) < 0) {
                        nextTrainEast.setText(trainTime[i]);
                        break;


                    }
                    else{
                        nextTrainEast.setText("今日快车末班车已过站");
                    }
                }
            }





    }

    //西行时间比较方法
    public void timeComparsionWest(View v,String[] trainTime){
        //若到站时间数组为空，则说明是终点站，显示不适用
        if(trainTime.length == 0){
            TextView nextTrainWest = (TextView) v.findViewById(R.id.nextTrainWest);
            nextTrainWest.setText("不适用");
            //若到站时间不为空，则显示最近的时间
        }else{
            TextView nextTrainWest = (TextView) v.findViewById(R.id.nextTrainWest);

            Calendar c = Calendar.getInstance();
            @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            String currentTime = sdf.format(c.getTime());




            for (int i = 0; i < trainTime.length; i++) {
                //String time = sdf.format(trainTime[i]);
                if (currentTime.compareTo(trainTime[i]) < 0) {
                    nextTrainWest.setText(trainTime[i]);
                    break;


                }
                else{
                    nextTrainWest.setText("今日快车末班车已过站");
                }
            }
        }





    }


        public void onResume() {
            super.onResume();
            //首次Fragment启动更新信息
            //获取当前站点东行快车时刻表
            timeComparsionEast(getView(), stationPickerEast(getView(), stationName));
            //获取当前站点西行快车时刻表
            timeComparsionWest(getView(), stationPickerWest(getView(), stationName));


            //确保信息自动更新（间隔30s）
            handler.postDelayed(runnable, 30000);
        }



        @Override
        public void onDestroyView () {
            super.onDestroyView();
            // 在Fragment销毁时移除Runnable，避免内存泄漏
            handler.removeCallbacks(runnable);


        }

    }



