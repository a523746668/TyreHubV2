package com.example.tyrehubv2.model;

import java.util.List;

//转化趋势
public class TransformTrendModel {

    /**
     * code : 0
     * data : {"stats":[{"date":"2019-12-02","tire_sale":0,"tire_service":0},{"date":"2019-12-03","tire_sale":0,"tire_service":0},{"date":"2019-12-04","tire_sale":0,"tire_service":0},{"date":"2019-12-05","tire_sale":0,"tire_service":0},{"date":"2019-12-06","tire_sale":0,"tire_service":0}]}
     * message : Success
     */

    public int code;
    public DataBean data;
    public String message;

    public static class DataBean {
        public List<StatsBean> stats;

        public static class StatsBean {
            /**
             * date : 2019-12-02
             * tire_sale : 0
             * tire_service : 0
             */

            public String date;
            public int tire_sale;
            public int tire_service;
        }
    }
}
