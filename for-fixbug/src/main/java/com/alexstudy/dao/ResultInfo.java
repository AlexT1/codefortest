package com.alexstudy.dao;

/**
 * @author AlexTong
 * @ClassName ResultInfo
 * @Description TODO()
 * @date 2018/2/7 15:03:12
 */
public class ResultInfo {
    private Integer result_code;
    private String result_detail;
    private String result_data;

    public Integer getResult_code() {
        return result_code;
    }

    public void setResult_code(Integer result_code) {
        this.result_code = result_code;
    }

    public String getResult_detail() {
        return result_detail;
    }

    public void setResult_detail(String result_detail) {
        this.result_detail = result_detail;
    }

    public String getResult_data() {
        return result_data;
    }

    public void setResult_data(String result_data) {
        this.result_data = result_data;
    }
}
