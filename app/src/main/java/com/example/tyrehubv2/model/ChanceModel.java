package com.example.tyrehubv2.model;

import java.util.List;

public class ChanceModel {


    /**
     * code : 0
     * data : {"reports":[{"brake_type":7,"car":null,"car_image_size":4,"car_image_url":"https://static.interval.im/tyrehub/car/SH452626_2019-09-24T18:33:12.jpg","conclusion":[{"describe":"建议进一步进行四轮定位或底盘检测","title":"右前胎中间比两侧磨损严重"}],"create_time":"2019-09-24T18:33:13","device":125,"device_number":"32413729","device_time":"2019-09-24T18:33:12","ecc_wear_lb_degree":"low","ecc_wear_lb_pos":"none","ecc_wear_lb_value":0,"ecc_wear_lf_degree":"low","ecc_wear_lf_pos":"none","ecc_wear_lf_value":0,"ecc_wear_rb_degree":"low","ecc_wear_rb_pos":"none","ecc_wear_rb_value":0,"ecc_wear_rf_degree":"high","ecc_wear_rf_pos":"middle","ecc_wear_rf_value":55,"ecc_wear_threshold":{"high":25,"low":15},"id":15564,"is_chance":"yes","language":"zh","lb_lifetime":15,"lf_lifetime":15,"merchant":44,"mobile":null,"model":3,"model_name":"手持式轮胎检测仪","model_number":"michelin.tyrescan.ts003","n_ecc_wear_high":1,"n_ecc_wear_low":3,"n_ecc_wear_middle":0,"n_wear_high":1,"n_wear_low":3,"n_wear_middle":0,"odometer":0,"plate_img":null,"plate_no":"SH452626","purpose":"purp_maintain","rb_lifetime":15,"remark":"里程：0公里","rf_lifetime":15,"staff":94,"staff_number":"15213785","store":67,"suggestion":[{"describe":"有轮胎磨损需要立即更换；存在偏磨情况，建议四轮定位；","title":"轮胎"}],"transposition":"none","trauma_lb_img":null,"trauma_lf_img":null,"trauma_rb_img":null,"trauma_rf_img":null,"tyre_lb":null,"tyre_lf":null,"tyre_rb":null,"tyre_rf":null,"update_time":"2019-09-24T18:33:13","uuid":"0e011918-0bb8-41eb-811b-f05f1fbcfad2","wear_coordinate_max":{"x":1000,"y":120},"wear_lb_data":null,"wear_lb_degree":"low","wear_lb_value":null,"wear_lf_data":null,"wear_lf_degree":"low","wear_lf_value":null,"wear_rb_data":null,"wear_rb_degree":"low","wear_rb_value":null,"wear_rf_data":"0215,26,0206,26,0372,11,0436,11,0687,26,0691,26","wear_rf_degree":"high","wear_rf_value":11,"wear_threshold":{"high":45,"low":25}}]}
     */

    public int code;
    public DataBean data;

    public static class DataBean {
        public List<ReportsBean> reports;

        public static class ReportsBean {
            /**
             * brake_type : 7
             * car : null
             * car_image_size : 4
             * car_image_url : https://static.interval.im/tyrehub/car/SH452626_2019-09-24T18:33:12.jpg
             * conclusion : [{"describe":"建议进一步进行四轮定位或底盘检测","title":"右前胎中间比两侧磨损严重"}]
             * create_time : 2019-09-24T18:33:13
             * device : 125
             * device_number : 32413729
             * device_time : 2019-09-24T18:33:12
             * ecc_wear_lb_degree : low
             * ecc_wear_lb_pos : none
             * ecc_wear_lb_value : 0
             * ecc_wear_lf_degree : low
             * ecc_wear_lf_pos : none
             * ecc_wear_lf_value : 0
             * ecc_wear_rb_degree : low
             * ecc_wear_rb_pos : none
             * ecc_wear_rb_value : 0
             * ecc_wear_rf_degree : high
             * ecc_wear_rf_pos : middle
             * ecc_wear_rf_value : 55
             * ecc_wear_threshold : {"high":25,"low":15}
             * id : 15564
             * is_chance : yes
             * language : zh
             * lb_lifetime : 15
             * lf_lifetime : 15
             * merchant : 44
             * mobile : null
             * model : 3
             * model_name : 手持式轮胎检测仪
             * model_number : michelin.tyrescan.ts003
             * n_ecc_wear_high : 1
             * n_ecc_wear_low : 3
             * n_ecc_wear_middle : 0
             * n_wear_high : 1
             * n_wear_low : 3
             * n_wear_middle : 0
             * odometer : 0
             * plate_img : null
             * plate_no : SH452626
             * purpose : purp_maintain
             * rb_lifetime : 15
             * remark : 里程：0公里
             * rf_lifetime : 15
             * staff : 94
             * staff_number : 15213785
             * store : 67
             * suggestion : [{"describe":"有轮胎磨损需要立即更换；存在偏磨情况，建议四轮定位；","title":"轮胎"}]
             * transposition : none
             * trauma_lb_img : null
             * trauma_lf_img : null
             * trauma_rb_img : null
             * trauma_rf_img : null
             * tyre_lb : null
             * tyre_lf : null
             * tyre_rb : null
             * tyre_rf : null
             * update_time : 2019-09-24T18:33:13
             * uuid : 0e011918-0bb8-41eb-811b-f05f1fbcfad2
             * wear_coordinate_max : {"x":1000,"y":120}
             * wear_lb_data : null
             * wear_lb_degree : low
             * wear_lb_value : null
             * wear_lf_data : null
             * wear_lf_degree : low
             * wear_lf_value : null
             * wear_rb_data : null
             * wear_rb_degree : low
             * wear_rb_value : null
             * wear_rf_data : 0215,26,0206,26,0372,11,0436,11,0687,26,0691,26
             * wear_rf_degree : high
             * wear_rf_value : 11
             * wear_threshold : {"high":45,"low":25}
             */

            public int brake_type;
            public Object car;
            public int car_image_size;
            public String car_image_url;
            public String create_time;
            public int device;
            public String device_number;
            public String device_time;
            public String ecc_wear_lb_degree;
            public String ecc_wear_lb_pos;
            public int ecc_wear_lb_value;
            public String ecc_wear_lf_degree;
            public String ecc_wear_lf_pos;
            public int ecc_wear_lf_value;
            public String ecc_wear_rb_degree;
            public String ecc_wear_rb_pos;
            public int ecc_wear_rb_value;
            public String ecc_wear_rf_degree;
            public String ecc_wear_rf_pos;
            public int ecc_wear_rf_value;
            public EccWearThresholdBean ecc_wear_threshold;
            public int id;
            public String is_chance;
            public String language;
            public int lb_lifetime;
            public int lf_lifetime;
            public int merchant;
            public Object mobile;
            public int model;
            public String model_name;
            public String model_number;
            public int n_ecc_wear_high;
            public int n_ecc_wear_low;
            public int n_ecc_wear_middle;
            public int n_wear_high;
            public int n_wear_low;
            public int n_wear_middle;
            public int odometer;
            public Object plate_img;
            public String plate_no;
            public String purpose;
            public int rb_lifetime;
            public String remark;
            public int rf_lifetime;
            public int staff;
            public String staff_number;
            public int store;
            public String transposition;
            public Object trauma_lb_img;
            public Object trauma_lf_img;
            public Object trauma_rb_img;
            public Object trauma_rf_img;
            public Object tyre_lb;
            public Object tyre_lf;
            public Object tyre_rb;
            public Object tyre_rf;
            public String update_time;
            public String uuid;
            public WearCoordinateMaxBean wear_coordinate_max;
            public Object wear_lb_data;
            public String wear_lb_degree;
            public Object wear_lb_value;
            public Object wear_lf_data;
            public String wear_lf_degree;
            public Object wear_lf_value;
            public Object wear_rb_data;
            public String wear_rb_degree;
            public Object wear_rb_value;
            public String wear_rf_data;
            public String wear_rf_degree;
            public int wear_rf_value;
            public WearThresholdBean wear_threshold;
            public List<ConclusionBean> conclusion;
            public List<SuggestionBean> suggestion;

            public static class EccWearThresholdBean {
                /**
                 * high : 25
                 * low : 15
                 */

                public int high;
                public int low;
            }

            public static class WearCoordinateMaxBean {
                /**
                 * x : 1000
                 * y : 120
                 */

                public int x;
                public int y;
            }

            public static class WearThresholdBean {
                /**
                 * high : 45
                 * low : 25
                 */

                public int high;
                public int low;
            }

            public static class ConclusionBean {
                /**
                 * describe : 建议进一步进行四轮定位或底盘检测
                 * title : 右前胎中间比两侧磨损严重
                 */

                public String describe;
                public String title;
            }

            public static class SuggestionBean {
                /**
                 * describe : 有轮胎磨损需要立即更换；存在偏磨情况，建议四轮定位；
                 * title : 轮胎
                 */

                public String describe;
                public String title;
            }
        }
    }
}
