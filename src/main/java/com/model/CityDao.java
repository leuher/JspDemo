package com.model;

import com.dbutil.Dbconn;
import com.entity.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ray on 2018/3/18 0018.
 **/
public class CityDao {

    Dbconn dbconn = new Dbconn();
    Connection conn = null;
    PreparedStatement ps;
    ResultSet rs;

    public List<City> listAlias(String alias){
        List citylist = new ArrayList();
        City city = null;
        try{
            conn = dbconn.getConnection();
            String sql = "select * from city where alias = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,alias);
            rs = ps.executeQuery();
            while (rs.next()){
                city = new City();
                city.setId(rs.getInt("id"));
                city.setName(rs.getString("name"));
                city.setAlias(rs.getString("alias"));
                citylist.add(city);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return citylist;
    }
}
