package com.yunbocheng.vo;

/**
 * 声明一个类，用于创建这个类的实现类，
 * 向 mapper文件中传递参数。
 */
public class QueryParam {
    private String paramName;
    private Integer paramAge;

    public QueryParam() {
    }

    public QueryParam(String paramName, Integer paramAge) {
        this.paramName = paramName;
        this.paramAge = paramAge;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public Integer getParamAge() {
        return paramAge;
    }

    public void setParamAge(Integer paramAge) {
        this.paramAge = paramAge;
    }

    @Override
    public String toString() {
        return "QueryParam{" +
                "paramName='" + paramName + '\'' +
                ", paramAge=" + paramAge +
                '}';
    }
}
