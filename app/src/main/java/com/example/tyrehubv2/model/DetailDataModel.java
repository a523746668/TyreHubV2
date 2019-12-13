package com.example.tyrehubv2.model;

public class DetailDataModel {


    /**
     * code : 0
     * data : {"ecc__wear_high_reports":9,"ecc__wear_low_reports":0,"ecc__wear_middle_reports":1,"end_date":"2019-12-08T23:59:59.999999","start_date":"2019-12-02T00:00:00","total_reports":10,"transposition_reports":0,"un_transposition_reports":10,"wear_high_reports":1,"wear_low_reports":1,"wear_middle_reports":8}
     * message : Success
     */

    public int code;
    public DataBean data;
    public String message;

    public static class DataBean {
        /**
         * ecc__wear_high_reports : 9
         * ecc__wear_low_reports : 0
         * ecc__wear_middle_reports : 1
         * end_date : 2019-12-08T23:59:59.999999
         * start_date : 2019-12-02T00:00:00
         * total_reports : 10
         * transposition_reports : 0
         * un_transposition_reports : 10
         * wear_high_reports : 1
         * wear_low_reports : 1
         * wear_middle_reports : 8
         */

        public int ecc__wear_high_reports;
        public int ecc__wear_low_reports;
        public int ecc__wear_middle_reports;
        public String end_date;
        public String start_date;
        public int total_reports;
        public int transposition_reports;
        public int un_transposition_reports;
        public int wear_high_reports;
        public int wear_low_reports;
        public int wear_middle_reports;
    }
}
