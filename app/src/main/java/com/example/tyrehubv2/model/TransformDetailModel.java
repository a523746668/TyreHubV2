package com.example.tyrehubv2.model;

public class TransformDetailModel {

    /**
     * code : 0
     * data : {"chances_num":10,"dynamic_balance":0,"ecc_reports":10,"end_date":"2019-12-08T23:59:59.999999","other":0,"position_wheel":0,"start_date":"2019-12-02T00:00:00","tire_sale":0,"total_transform":0,"tra_reports":0,"wear_reports":9}
     * message : Success
     */

    public int code;
    public DataBean data;
    public String message;

    public static class DataBean {
        /**
         * chances_num : 10
         * dynamic_balance : 0
         * ecc_reports : 10
         * end_date : 2019-12-08T23:59:59.999999
         * other : 0
         * position_wheel : 0
         * start_date : 2019-12-02T00:00:00
         * tire_sale : 0
         * total_transform : 0
         * tra_reports : 0
         * wear_reports : 9
         */

        public int chances_num;
        public int dynamic_balance;
        public int ecc_reports;
        public String end_date;
        public int other;
        public int position_wheel;
        public String start_date;
        public int tire_sale;
        public int total_transform;
        public int tra_reports;
        public int wear_reports;
    }
}
