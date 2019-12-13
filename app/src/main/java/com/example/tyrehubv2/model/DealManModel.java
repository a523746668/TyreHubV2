package com.example.tyrehubv2.model;

import java.util.List;

public class DealManModel {


    /**
     * code : 0
     * data : {"staffs":[{"group":1,"id":30,"name":"店长1"},{"group":2,"id":31,"name":"ceshi"},{"group":2,"id":91,"name":"阿里"}]}
     * message : Success
     */

    public int code;
    public DataBean data;
    public String message;

    public static class DataBean {
        public List<StaffsBean> staffs;

        public static class StaffsBean {
            /**
             * group : 1
             * id : 30
             * name : 店长1
             */

            public int group;
            public int id;
            public String name;
        }
    }
}
