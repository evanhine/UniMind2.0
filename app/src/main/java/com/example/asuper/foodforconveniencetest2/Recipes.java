package com.example.asuper.foodforconveniencetest2;

public class Recipes
{
    private int rid;
    private String rname;
    private int servings;
    private int prep_time;
    private int cook_time;
    private String method;

    public Recipes(int rid, String rname, int servings, int prep_time, int cook_time, String method)
    {
        this.rid = rid;
        this.rname = rname;
        this.prep_time = prep_time;
        this.cook_time = cook_time;
        this.method = method;
    }

    public int getRid()
    {
        return rid;
    }
    public String getRname()
    {
        return rname;
    }
    public int getServings()
    {
        return servings;
    }
    public int getPrep_time()
    {
        return prep_time;
    }
    public int getCook_time()
    {
        return cook_time;
    }
    public String getMethod()
    {
        return method;
    }
    public void setRid(int rid)
    {
        this.rid = rid;
    }
    public void setRname(String rname)
    {
        this.rname = rname;
    }
    public void setServings(int servings)
    {
        this.servings = servings;
    }
    public void setPrep_time(int prep_time)
    {
        this.prep_time = prep_time;
    }
    public void setCook_time(int cook_time)
    {
        this.cook_time = cook_time;
    }
    public void setMethod(String method)
    {
        this.method = method;
    }




}
