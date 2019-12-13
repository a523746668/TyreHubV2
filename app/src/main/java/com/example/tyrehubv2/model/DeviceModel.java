package com.example.tyrehubv2.model;

import java.util.List;

public class DeviceModel {

    /**
     * code : 0
     * data : {"device":[{"alias":"手持式轮胎检测仪_96","auto_update":true,"create_time":"2019-04-27T17:55:46","current_firmware":"TEST2.0.0_1912051220","first_bind_time":"2019-05-02T15:51:33","id":124,"last_active_time":"2019-12-06T15:24:22","last_bind_location":"","last_bind_time":"2019-11-27T11:40:50","last_recycle_time":"2019-10-22T17:17:19","last_test_time":"2019-07-02T08:34:36","last_unbind_time":"2019-11-04T11:38:21","latest_firmware":"TEST2.0.0_1912051220","mac":"04:CF:8C:02:3B:1F","merchant":16,"model":3,"model_name":"手持式轮胎检测仪","model_number":"michelin.tyrescan.ts003","number":"32417528","remark":null,"status":2,"store":14,"store_name":"店长测试号","token":"88dd4fce3034a749008e27205ae9d134","update_time":"2019-11-27T11:40:50","uuid":"baa8b329-dbc1-4f29-8a9a-52d0b1a8fca1"},{"alias":"手持式轮胎检测仪_99","auto_update":true,"create_time":"2019-05-16T10:08:59","current_firmware":"TEST2.0.0_1912051220","first_bind_time":"2019-05-18T18:20:23","id":139,"last_active_time":"2019-12-06T15:05:50","last_bind_location":"","last_bind_time":"2019-11-27T18:34:33","last_recycle_time":null,"last_test_time":"2019-12-06T15:05:50","last_unbind_time":"2019-11-27T18:30:42","latest_firmware":"TEST2.0.0_1912051220","mac":"04:CF:8C:02:12:7A","merchant":16,"model":3,"model_name":"手持式轮胎检测仪","model_number":"michelin.tyrescan.ts003","number":"32407123","remark":null,"status":2,"store":14,"store_name":"店长测试号","token":"01f12bab84fb97faf8d1b99b08adb946","update_time":"2019-11-27T18:34:33","uuid":"722c6329-b02d-43fd-a1db-c10e67a06b47"}],"total":2}
     * message : Success
     */

    public int code;
    public DataBean data;
    public String message;

    public static class DataBean {
        /**
         * device : [{"alias":"手持式轮胎检测仪_96","auto_update":true,"create_time":"2019-04-27T17:55:46","current_firmware":"TEST2.0.0_1912051220","first_bind_time":"2019-05-02T15:51:33","id":124,"last_active_time":"2019-12-06T15:24:22","last_bind_location":"","last_bind_time":"2019-11-27T11:40:50","last_recycle_time":"2019-10-22T17:17:19","last_test_time":"2019-07-02T08:34:36","last_unbind_time":"2019-11-04T11:38:21","latest_firmware":"TEST2.0.0_1912051220","mac":"04:CF:8C:02:3B:1F","merchant":16,"model":3,"model_name":"手持式轮胎检测仪","model_number":"michelin.tyrescan.ts003","number":"32417528","remark":null,"status":2,"store":14,"store_name":"店长测试号","token":"88dd4fce3034a749008e27205ae9d134","update_time":"2019-11-27T11:40:50","uuid":"baa8b329-dbc1-4f29-8a9a-52d0b1a8fca1"},{"alias":"手持式轮胎检测仪_99","auto_update":true,"create_time":"2019-05-16T10:08:59","current_firmware":"TEST2.0.0_1912051220","first_bind_time":"2019-05-18T18:20:23","id":139,"last_active_time":"2019-12-06T15:05:50","last_bind_location":"","last_bind_time":"2019-11-27T18:34:33","last_recycle_time":null,"last_test_time":"2019-12-06T15:05:50","last_unbind_time":"2019-11-27T18:30:42","latest_firmware":"TEST2.0.0_1912051220","mac":"04:CF:8C:02:12:7A","merchant":16,"model":3,"model_name":"手持式轮胎检测仪","model_number":"michelin.tyrescan.ts003","number":"32407123","remark":null,"status":2,"store":14,"store_name":"店长测试号","token":"01f12bab84fb97faf8d1b99b08adb946","update_time":"2019-11-27T18:34:33","uuid":"722c6329-b02d-43fd-a1db-c10e67a06b47"}]
         * total : 2
         */

        public int total;
        public List<DeviceBean> device;

        public static class DeviceBean {
            /**
             * alias : 手持式轮胎检测仪_96
             * auto_update : true
             * create_time : 2019-04-27T17:55:46
             * current_firmware : TEST2.0.0_1912051220
             * first_bind_time : 2019-05-02T15:51:33
             * id : 124
             * last_active_time : 2019-12-06T15:24:22
             * last_bind_location :
             * last_bind_time : 2019-11-27T11:40:50
             * last_recycle_time : 2019-10-22T17:17:19
             * last_test_time : 2019-07-02T08:34:36
             * last_unbind_time : 2019-11-04T11:38:21
             * latest_firmware : TEST2.0.0_1912051220
             * mac : 04:CF:8C:02:3B:1F
             * merchant : 16
             * model : 3
             * model_name : 手持式轮胎检测仪
             * model_number : michelin.tyrescan.ts003
             * number : 32417528
             * remark : null
             * status : 2
             * store : 14
             * store_name : 店长测试号
             * token : 88dd4fce3034a749008e27205ae9d134
             * update_time : 2019-11-27T11:40:50
             * uuid : baa8b329-dbc1-4f29-8a9a-52d0b1a8fca1
             */

            public String alias;
            public boolean auto_update;
            public String create_time;
            public String current_firmware;
            public String first_bind_time;
            public int id;
            public String last_active_time;
            public String last_bind_location;
            public String last_bind_time;
            public String last_recycle_time;
            public String last_test_time;
            public String last_unbind_time;
            public String latest_firmware;
            public String mac;
            public int merchant;
            public int model;
            public String model_name;
            public String model_number;
            public String number;
            public Object remark;
            public int status;
            public int store;
            public String store_name;
            public String token;
            public String update_time;
            public String uuid;
        }
    }
}
