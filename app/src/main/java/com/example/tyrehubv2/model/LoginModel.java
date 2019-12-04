package com.example.tyrehubv2.model;

public class LoginModel  {


    /**
     * code : 0
     * data : {"token":"sIfhqZCWqu9PAJZSuHHp5lyv5PFa8Dt//lDhpatWcpcBZ73VCUoWO01i4azcI47EDwEcelamGfQAQuY2YKilK/2UFx6+27WyIminCto27PA=","user":{"contact":"13472407283","create_time":"2019-10-23T17:03:42","department":null,"group":1,"id":108,"last_login_ip":"180.174.195.121","last_login_time":"2019-11-12T17:18:16.066059","merchant":{"address":"uuu","contact":"uuuuuu","create_time":"2019-10-23T10:09:20","id":50,"last_login_ip":"180.174.195.121","last_login_time":"2019-11-06T17:10:34","last_test_time":"2019-11-01T14:03:45","merchant_name":"尽力了","mobile":"13472407283","name":"哦哦哦","remark":null,"status":1,"update_time":"2019-10-23T10:09:20","uuid":"4fdcb249-2596-4f84-a44f-b41002201f5b"},"merchant_status":1,"name":"呃呃呃","number":"19510803","remark":null,"status":1,"store":{"address":"的","city":"东城区","contact":"13472407283","create_time":"2019-10-23T17:03:42","id":75,"merchant":50,"name":"呃呃呃","province":"北京市","remark":null,"status":1,"update_time":"2019-10-23T17:03:42","uuid":"09d387e6-c573-4d64-a73a-3e52082d6bec"},"store_status":1,"update_time":"2019-10-30T11:05:56","uuid":"a72b5187-217b-47bf-9839-410745e40741"},"user_type":2}
     * message : Success
     */

    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * token : sIfhqZCWqu9PAJZSuHHp5lyv5PFa8Dt//lDhpatWcpcBZ73VCUoWO01i4azcI47EDwEcelamGfQAQuY2YKilK/2UFx6+27WyIminCto27PA=
         * user : {"contact":"13472407283","create_time":"2019-10-23T17:03:42","department":null,"group":1,"id":108,"last_login_ip":"180.174.195.121","last_login_time":"2019-11-12T17:18:16.066059","merchant":{"address":"uuu","contact":"uuuuuu","create_time":"2019-10-23T10:09:20","id":50,"last_login_ip":"180.174.195.121","last_login_time":"2019-11-06T17:10:34","last_test_time":"2019-11-01T14:03:45","merchant_name":"尽力了","mobile":"13472407283","name":"哦哦哦","remark":null,"status":1,"update_time":"2019-10-23T10:09:20","uuid":"4fdcb249-2596-4f84-a44f-b41002201f5b"},"merchant_status":1,"name":"呃呃呃","number":"19510803","remark":null,"status":1,"store":{"address":"的","city":"东城区","contact":"13472407283","create_time":"2019-10-23T17:03:42","id":75,"merchant":50,"name":"呃呃呃","province":"北京市","remark":null,"status":1,"update_time":"2019-10-23T17:03:42","uuid":"09d387e6-c573-4d64-a73a-3e52082d6bec"},"store_status":1,"update_time":"2019-10-30T11:05:56","uuid":"a72b5187-217b-47bf-9839-410745e40741"}
         * user_type : 2
         */

        private String token;
        private UserBean user;
        private int user_type;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public int getUser_type() {
            return user_type;
        }

        public void setUser_type(int user_type) {
            this.user_type = user_type;
        }

        public static class UserBean {
            /**
             * contact : 13472407283
             * create_time : 2019-10-23T17:03:42
             * department : null
             * group : 1
             * id : 108
             * last_login_ip : 180.174.195.121
             * last_login_time : 2019-11-12T17:18:16.066059
             * merchant : {"address":"uuu","contact":"uuuuuu","create_time":"2019-10-23T10:09:20","id":50,"last_login_ip":"180.174.195.121","last_login_time":"2019-11-06T17:10:34","last_test_time":"2019-11-01T14:03:45","merchant_name":"尽力了","mobile":"13472407283","name":"哦哦哦","remark":null,"status":1,"update_time":"2019-10-23T10:09:20","uuid":"4fdcb249-2596-4f84-a44f-b41002201f5b"}
             * merchant_status : 1
             * name : 呃呃呃
             * number : 19510803
             * remark : null
             * status : 1
             * store : {"address":"的","city":"东城区","contact":"13472407283","create_time":"2019-10-23T17:03:42","id":75,"merchant":50,"name":"呃呃呃","province":"北京市","remark":null,"status":1,"update_time":"2019-10-23T17:03:42","uuid":"09d387e6-c573-4d64-a73a-3e52082d6bec"}
             * store_status : 1
             * update_time : 2019-10-30T11:05:56
             * uuid : a72b5187-217b-47bf-9839-410745e40741
             */

            private String contact;
            private String create_time;
            private Object department;
            private int group;
            private int id;
            private String last_login_ip;
            private String last_login_time;
            private MerchantBean merchant;
            private int merchant_status;
            private String name;
            private String number;
            private Object remark;
            private int status;
            private StoreBean store;
            private int store_status;
            private String update_time;
            private String uuid;

            public String getContact() {
                return contact;
            }

            public void setContact(String contact) {
                this.contact = contact;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public Object getDepartment() {
                return department;
            }

            public void setDepartment(Object department) {
                this.department = department;
            }

            public int getGroup() {
                return group;
            }

            public void setGroup(int group) {
                this.group = group;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getLast_login_ip() {
                return last_login_ip;
            }

            public void setLast_login_ip(String last_login_ip) {
                this.last_login_ip = last_login_ip;
            }

            public String getLast_login_time() {
                return last_login_time;
            }

            public void setLast_login_time(String last_login_time) {
                this.last_login_time = last_login_time;
            }

            public MerchantBean getMerchant() {
                return merchant;
            }

            public void setMerchant(MerchantBean merchant) {
                this.merchant = merchant;
            }

            public int getMerchant_status() {
                return merchant_status;
            }

            public void setMerchant_status(int merchant_status) {
                this.merchant_status = merchant_status;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getNumber() {
                return number;
            }

            public void setNumber(String number) {
                this.number = number;
            }

            public Object getRemark() {
                return remark;
            }

            public void setRemark(Object remark) {
                this.remark = remark;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public StoreBean getStore() {
                return store;
            }

            public void setStore(StoreBean store) {
                this.store = store;
            }

            public int getStore_status() {
                return store_status;
            }

            public void setStore_status(int store_status) {
                this.store_status = store_status;
            }

            public String getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(String update_time) {
                this.update_time = update_time;
            }

            public String getUuid() {
                return uuid;
            }

            public void setUuid(String uuid) {
                this.uuid = uuid;
            }

            public static class MerchantBean {
                /**
                 * address : uuu
                 * contact : uuuuuu
                 * create_time : 2019-10-23T10:09:20
                 * id : 50
                 * last_login_ip : 180.174.195.121
                 * last_login_time : 2019-11-06T17:10:34
                 * last_test_time : 2019-11-01T14:03:45
                 * merchant_name : 尽力了
                 * mobile : 13472407283
                 * name : 哦哦哦
                 * remark : null
                 * status : 1
                 * update_time : 2019-10-23T10:09:20
                 * uuid : 4fdcb249-2596-4f84-a44f-b41002201f5b
                 */

                private String address;
                private String contact;
                private String create_time;
                private int id;
                private String last_login_ip;
                private String last_login_time;
                private String last_test_time;
                private String merchant_name;
                private String mobile;
                private String name;
                private Object remark;
                private int status;
                private String update_time;
                private String uuid;

                public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
                }

                public String getContact() {
                    return contact;
                }

                public void setContact(String contact) {
                    this.contact = contact;
                }

                public String getCreate_time() {
                    return create_time;
                }

                public void setCreate_time(String create_time) {
                    this.create_time = create_time;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getLast_login_ip() {
                    return last_login_ip;
                }

                public void setLast_login_ip(String last_login_ip) {
                    this.last_login_ip = last_login_ip;
                }

                public String getLast_login_time() {
                    return last_login_time;
                }

                public void setLast_login_time(String last_login_time) {
                    this.last_login_time = last_login_time;
                }

                public String getLast_test_time() {
                    return last_test_time;
                }

                public void setLast_test_time(String last_test_time) {
                    this.last_test_time = last_test_time;
                }

                public String getMerchant_name() {
                    return merchant_name;
                }

                public void setMerchant_name(String merchant_name) {
                    this.merchant_name = merchant_name;
                }

                public String getMobile() {
                    return mobile;
                }

                public void setMobile(String mobile) {
                    this.mobile = mobile;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public Object getRemark() {
                    return remark;
                }

                public void setRemark(Object remark) {
                    this.remark = remark;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public String getUpdate_time() {
                    return update_time;
                }

                public void setUpdate_time(String update_time) {
                    this.update_time = update_time;
                }

                public String getUuid() {
                    return uuid;
                }

                public void setUuid(String uuid) {
                    this.uuid = uuid;
                }
            }

            public static class StoreBean {
                /**
                 * address : 的
                 * city : 东城区
                 * contact : 13472407283
                 * create_time : 2019-10-23T17:03:42
                 * id : 75
                 * merchant : 50
                 * name : 呃呃呃
                 * province : 北京市
                 * remark : null
                 * status : 1
                 * update_time : 2019-10-23T17:03:42
                 * uuid : 09d387e6-c573-4d64-a73a-3e52082d6bec
                 */

                private String address;
                private String city;
                private String contact;
                private String create_time;
                private int id;
                private int merchant;
                private String name;
                private String province;
                private Object remark;
                private int status;
                private String update_time;
                private String uuid;

                public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
                }

                public String getCity() {
                    return city;
                }

                public void setCity(String city) {
                    this.city = city;
                }

                public String getContact() {
                    return contact;
                }

                public void setContact(String contact) {
                    this.contact = contact;
                }

                public String getCreate_time() {
                    return create_time;
                }

                public void setCreate_time(String create_time) {
                    this.create_time = create_time;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getMerchant() {
                    return merchant;
                }

                public void setMerchant(int merchant) {
                    this.merchant = merchant;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getProvince() {
                    return province;
                }

                public void setProvince(String province) {
                    this.province = province;
                }

                public Object getRemark() {
                    return remark;
                }

                public void setRemark(Object remark) {
                    this.remark = remark;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public String getUpdate_time() {
                    return update_time;
                }

                public void setUpdate_time(String update_time) {
                    this.update_time = update_time;
                }

                public String getUuid() {
                    return uuid;
                }

                public void setUuid(String uuid) {
                    this.uuid = uuid;
                }
            }
        }
    }
}
