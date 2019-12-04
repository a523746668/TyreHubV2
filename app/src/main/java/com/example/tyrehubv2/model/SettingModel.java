package com.example.tyrehubv2.model;

public class SettingModel {

    /**
     * code : 0
     * data : {"model":{"create_time":"2019-03-27T12:45:16","id":3,"image":null,"invalid_reason":null,"invalid_time":null,"latest_app":"1.1.3","latest_app_md5sum":"133b4cda0c2860dd1f949c525511a2e0","latest_app_url":"https://static.interval.im/tyrehub/app_michelin.tyrescan.ts003_1.1.3test.apk","latest_firmware":"TEST2.0.0_1911260146","latest_firmware_md5sum":"0727ad9c7daeeaef32f0f936eefcdf27","latest_firmware_url":"https://static.interval.im/tyrehub/firmware_michelin.tyrescan.ts003_TEST2.0.0_1911260146","name":"手持式轮胎检测仪","number":"michelin.tyrescan.ts003","number_1":"michelin","number_2":"tyrescan","number_3":"ts003","remark":null,"status":0,"update_time":"2019-11-26T09:30:27","uuid":"18ec1529-f780-4723-a467-3aef5a556f16"}}
     * message : Success
     */

    public int code;
    public DataBean data;
    public String message;

    public static class DataBean {
        /**
         * model : {"create_time":"2019-03-27T12:45:16","id":3,"image":null,"invalid_reason":null,"invalid_time":null,"latest_app":"1.1.3","latest_app_md5sum":"133b4cda0c2860dd1f949c525511a2e0","latest_app_url":"https://static.interval.im/tyrehub/app_michelin.tyrescan.ts003_1.1.3test.apk","latest_firmware":"TEST2.0.0_1911260146","latest_firmware_md5sum":"0727ad9c7daeeaef32f0f936eefcdf27","latest_firmware_url":"https://static.interval.im/tyrehub/firmware_michelin.tyrescan.ts003_TEST2.0.0_1911260146","name":"手持式轮胎检测仪","number":"michelin.tyrescan.ts003","number_1":"michelin","number_2":"tyrescan","number_3":"ts003","remark":null,"status":0,"update_time":"2019-11-26T09:30:27","uuid":"18ec1529-f780-4723-a467-3aef5a556f16"}
         */

        public ModelBean model;

        public static class ModelBean {
            /**
             * create_time : 2019-03-27T12:45:16
             * id : 3
             * image : null
             * invalid_reason : null
             * invalid_time : null
             * latest_app : 1.1.3
             * latest_app_md5sum : 133b4cda0c2860dd1f949c525511a2e0
             * latest_app_url : https://static.interval.im/tyrehub/app_michelin.tyrescan.ts003_1.1.3test.apk
             * latest_firmware : TEST2.0.0_1911260146
             * latest_firmware_md5sum : 0727ad9c7daeeaef32f0f936eefcdf27
             * latest_firmware_url : https://static.interval.im/tyrehub/firmware_michelin.tyrescan.ts003_TEST2.0.0_1911260146
             * name : 手持式轮胎检测仪
             * number : michelin.tyrescan.ts003
             * number_1 : michelin
             * number_2 : tyrescan
             * number_3 : ts003
             * remark : null
             * status : 0
             * update_time : 2019-11-26T09:30:27
             * uuid : 18ec1529-f780-4723-a467-3aef5a556f16
             */

            public String create_time;
            public int id;
            public Object image;
            public Object invalid_reason;
            public Object invalid_time;
            public String latest_app;
            public String latest_app_md5sum;
            public String latest_app_url;
            public String latest_firmware;
            public String latest_firmware_md5sum;
            public String latest_firmware_url;
            public String name;
            public String number;
            public String number_1;
            public String number_2;
            public String number_3;
            public Object remark;
            public int status;
            public String update_time;
            public String uuid;
        }
    }
}
