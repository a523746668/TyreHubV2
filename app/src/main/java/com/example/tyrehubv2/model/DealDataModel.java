package com.example.tyrehubv2.model;

public class DealDataModel {


    /**
     * code : 0
     * data : {"chance":{"area":"","change_amount":0,"change_type":"3-tire","changed_time":"","create_time":"2019-10-25T17:55:47","device_time":"2019-10-21T16:39:49","id":282,"intention_time":"2019-10-26 17:55","manage_staff":"阿里","report_id":15721,"results":"intention","status":"track","update_time":"2019-10-25T17:55:47","uuid":"bc78126b-fb4a-4e56-994f-7b3b912a2873"}}
     * message : Success
     */

    public int code;
    public DataBean data;
    public String message;

    public static class DataBean {
        /**
         * chance : {"area":"","change_amount":0,"change_type":"3-tire","changed_time":"","create_time":"2019-10-25T17:55:47","device_time":"2019-10-21T16:39:49","id":282,"intention_time":"2019-10-26 17:55","manage_staff":"阿里","report_id":15721,"results":"intention","status":"track","update_time":"2019-10-25T17:55:47","uuid":"bc78126b-fb4a-4e56-994f-7b3b912a2873"}
         */

        public ChanceBean chance;

        public static class ChanceBean {
            /**
             * area :
             * change_amount : 0
             * change_type : 3-tire
             * changed_time :
             * create_time : 2019-10-25T17:55:47
             * device_time : 2019-10-21T16:39:49
             * id : 282
             * intention_time : 2019-10-26 17:55
             * manage_staff : 阿里
             * report_id : 15721
             * results : intention
             * status : track
             * update_time : 2019-10-25T17:55:47
             * uuid : bc78126b-fb4a-4e56-994f-7b3b912a2873
             */

            public String area;
            public int change_amount;
            public String change_type;
            public String changed_time;
            public String create_time;
            public String device_time;
            public int id;
            public String intention_time;
            public String manage_staff;
            public int report_id;
            public String results;
            public String status;
            public String update_time;
            public String uuid;
        }
    }
}
