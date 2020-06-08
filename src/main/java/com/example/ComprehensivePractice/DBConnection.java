package com.example.ComprehensivePractice;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class DBConnection {
    Connection connection = null;
    Statement statement = null;
    ResultSet rs = null;
    public  JSONArray selectuser(String userid,String pass)
    {
        JSONArray result = new JSONArray();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //adb_url是AnalyticDB for MySQL集群的连接地址URL，可以在控制台的集群信息页面获取连接URL，3306是端口号。
            //db_name是AnalyticDB for MySQL集群中的数据库名称。
            String url = "jdbc:mysql://120.78.226.183:3306/1?useSSL=false&autoReconnect=true&failOverReadOnly=false" +
                    "&useUnicode=true&characterEncoding=UTF-8";
            Properties connectionProps = new Properties();
            //account_name是AnalyticDB for MySQL集群中的用户账号：高权限账号或者普通账号。
            connectionProps.put("user", "root");
            //account_password是AnalyticDB for MySQL集群中用户账号对应的密码。
            connectionProps.put("password", "qhq123456");
            connection = (Connection) DriverManager.getConnection(url, connectionProps);
            statement = (Statement) connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            String query = "select * from 账号信息 where 账号="+"'"+userid+"'";
            //System.out.println(query);
            rs = statement.executeQuery(query);
            rs.last();
            int row=rs.getRow();
            //System.out.println(row);
            rs.beforeFirst();
            //row=rs.getRow();
            //System.out.println(row);
            if(row==0)
            {
                JSONObject obj=new JSONObject();
                obj.put("type","wu");
                result.add(obj);
            }
            else
            {
                while (rs.next()) {
                    String password=rs.getString(2);
                    if(!password.equals(pass))
                    {
                        JSONObject obj=new JSONObject();
                        obj.put("type","wp");
                        result.add(obj);
                    }
                    else
                    {
                        JSONObject obj=new JSONObject();
                        obj.put("userid",rs.getString(1));
                        obj.put("type",rs.getString(3));
                        result.add(obj);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
    public JSONArray selectbooktable()
    {
        JSONArray result = new JSONArray();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //adb_url是AnalyticDB for MySQL集群的连接地址URL，可以在控制台的集群信息页面获取连接URL，3306是端口号。
            //db_name是AnalyticDB for MySQL集群中的数据库名称。
            String url = "jdbc:mysql://120.78.226.183:3306/1?useSSL=false&autoReconnect=true&failOverReadOnly=false" +
                    "&useUnicode=true&characterEncoding=UTF-8";
            Properties connectionProps = new Properties();
            //account_name是AnalyticDB for MySQL集群中的用户账号：高权限账号或者普通账号。
            connectionProps.put("user", "root");
            //account_password是AnalyticDB for MySQL集群中用户账号对应的密码。
            connectionProps.put("password", "qhq123456");
            connection = (Connection) DriverManager.getConnection(url, connectionProps);
            statement = (Statement) connection.createStatement();
            String query = "select * from 教材信息";
            //System.out.println(query);
            rs = statement.executeQuery(query);
            while (rs.next()) {
                JSONObject obj=new JSONObject();
                obj.put("booknum",rs.getString(1));
                obj.put("title",rs.getString(2));
                obj.put("writer",rs.getString(3));
                obj.put("press",rs.getString(4));
                obj.put("date",rs.getString(5));
                obj.put("price",rs.getString(6));
                obj.put("description",rs.getString(7));
                obj.put("count",rs.getString(8));
                result.add(obj);
                //System.out.println(obj.toJSONString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
    public JSONArray insertbookorder(String booknum,String ordernum,String count)
    {
        JSONArray result = new JSONArray();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //adb_url是AnalyticDB for MySQL集群的连接地址URL，可以在控制台的集群信息页面获取连接URL，3306是端口号。
            //db_name是AnalyticDB for MySQL集群中的数据库名称。
            String url = "jdbc:mysql://120.78.226.183:3306/1?useSSL=false&autoReconnect=true&failOverReadOnly=false" +
                    "&useUnicode=true&characterEncoding=UTF-8";
            Properties connectionProps = new Properties();
            //account_name是AnalyticDB for MySQL集群中的用户账号：高权限账号或者普通账号。
            connectionProps.put("user", "root");
            //account_password是AnalyticDB for MySQL集群中用户账号对应的密码。
            connectionProps.put("password", "qhq123456");
            connection = (Connection) DriverManager.getConnection(url, connectionProps);
            statement = (Statement) connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            String query = "select * from 教材信息 where 书号="+"'"+booknum+"'";
            float flocount=Float.parseFloat(count);
            if(flocount<=0)
            {
                JSONObject obj=new JSONObject();
                obj.put("statu","wc2");
                //System.out.println(obj.toJSONString());
                result.add(obj);
            }
            else
            {
                //System.out.println(query);
                rs = statement.executeQuery(query);
                rs.last();
                int row=rs.getRow();
                //System.out.println(row);
                rs.beforeFirst();
                //row=rs.getRow();
                //System.out.println(row);
                if(row==0)
                {
                    JSONObject obj=new JSONObject();
                    obj.put("statu","wn");
                    //System.out.println(obj.toJSONString());
                    result.add(obj);
                }
                else
                {
                    String insertorder="",insertbook="",insertdate="",insertoderbuyer="",insertcount="",inserttprice = "";
                    insertbook=booknum;
                    Date date=new Date();
                    SimpleDateFormat simpledateformat=new SimpleDateFormat("yyyy-MM-dd");
                    insertdate=simpledateformat.format(date);
                    insertoderbuyer=ordernum;
                    insertcount= count;
                    insertorder= new SimpleDateFormat("yyyyMMddHHmmss").format(date)+insertoderbuyer;
                    while (rs.next()) {
                        inserttprice= String.valueOf(Float.parseFloat(rs.getString(6))*flocount);
                        JSONObject obj=new JSONObject();
                        obj.put("statu","t");
                        obj.put("tprice",inserttprice);
                        obj.put("title",rs.getString(2));
                        //System.out.println(obj.toJSONString());
                        result.add(obj);
                    }

                    String query2 = "insert into 订购单 values("+"'"+insertorder+"'"+","+"'"+insertbook+"'"+","+"'"+insertdate+"'"+","+
                            "'"+insertoderbuyer+"'"+","+ insertcount+","+inserttprice+","+0+")";
                    //System.out.println(query2);
                    int res = statement.executeUpdate(query2);
                }
            }
        }
        catch(NumberFormatException e)
        {

            JSONObject obj=new JSONObject();
            obj.put("statu","wc1");
            System.out.println(obj.toJSONString());
            result.add(obj);
            return result;
        }
        catch(SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
    public JSONArray selectordertable(String userid)
    {
        JSONArray result = new JSONArray();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //adb_url是AnalyticDB for MySQL集群的连接地址URL，可以在控制台的集群信息页面获取连接URL，3306是端口号。
            //db_name是AnalyticDB for MySQL集群中的数据库名称。
            String url = "jdbc:mysql://120.78.226.183:3306/1?useSSL=false&autoReconnect=true&failOverReadOnly=false" +
                    "&useUnicode=true&characterEncoding=UTF-8";
            Properties connectionProps = new Properties();
            //account_name是AnalyticDB for MySQL集群中的用户账号：高权限账号或者普通账号。
            connectionProps.put("user", "root");
            //account_password是AnalyticDB for MySQL集群中用户账号对应的密码。
            connectionProps.put("password", "qhq123456");
            connection = (Connection) DriverManager.getConnection(url, connectionProps);
            statement = (Statement) connection.createStatement();
            String query="";
            if (userid.equals("anyone")) query="select * from 订购单";
            else query = "select * from 订购单 where 订购者编号="+"'"+userid+"'";
            //System.out.println(query);
            rs = statement.executeQuery(query);
            while (rs.next()) {
                JSONObject obj=new JSONObject();
                obj.put("orderid",rs.getString(1));
                obj.put("bookid",rs.getString(2));
                obj.put("buydate",rs.getString(3));
                obj.put("buyerid",rs.getString(4));
                obj.put("count",rs.getString(5));
                obj.put("tprice",rs.getString(6));
                obj.put("statu",rs.getString(7));
                result.add(obj);
                //System.out.println(obj.toJSONString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
    public JSONArray selecttaketable(String userid)
    {
        JSONArray result = new JSONArray();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //adb_url是AnalyticDB for MySQL集群的连接地址URL，可以在控制台的集群信息页面获取连接URL，3306是端口号。
            //db_name是AnalyticDB for MySQL集群中的数据库名称。
            String url = "jdbc:mysql://120.78.226.183:3306/1?useSSL=false&autoReconnect=true&failOverReadOnly=false" +
                    "&useUnicode=true&characterEncoding=UTF-8";
            Properties connectionProps = new Properties();
            //account_name是AnalyticDB for MySQL集群中的用户账号：高权限账号或者普通账号。
            connectionProps.put("user", "root");
            //account_password是AnalyticDB for MySQL集群中用户账号对应的密码。
            connectionProps.put("password", "qhq123456");
            connection = (Connection) DriverManager.getConnection(url, connectionProps);
            statement = (Statement) connection.createStatement();
            String query = "";
            if(userid.equals("anyone"))query = "select * from 领书单";
            else query = "select * from 领书单 where 订购者编号="+"'"+userid+"'";
            //Syustem.out.println(query);
            rs = statement.executeQuery(query);
            while (rs.next()) {
                JSONObject obj=new JSONObject();
                obj.put("takeid",rs.getString(1));
                obj.put("buyerid",rs.getString(2));
                obj.put("takedate",rs.getString(3));
                obj.put("buyid",rs.getString(4));
                obj.put("buydate",rs.getString(5));
                obj.put("sellerid",rs.getString(6));
                obj.put("statu",rs.getString(7));
                result.add(obj);
                //System.out.println(obj.toJSONString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
    public JSONArray insertbooktake(String orderid,String sellerid,String takedate,String bookid,String count)
    {
        JSONArray result = new JSONArray();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //adb_url是AnalyticDB for MySQL集群的连接地址URL，可以在控制台的集群信息页面获取连接URL，3306是端口号。
            //db_name是AnalyticDB for MySQL集群中的数据库名称。
            String url = "jdbc:mysql://120.78.226.183:3306/1?useSSL=false&autoReconnect=true&failOverReadOnly=false" +
                    "&useUnicode=true&characterEncoding=UTF-8";
            Properties connectionProps = new Properties();
            //account_name是AnalyticDB for MySQL集群中的用户账号：高权限账号或者普通账号。
            connectionProps.put("user", "root");
            //account_password是AnalyticDB for MySQL集群中用户账号对应的密码。
            connectionProps.put("password", "qhq123456");
            connection = (Connection) DriverManager.getConnection(url, connectionProps);
            statement = (Statement) connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            String query = "select * from 订购单 where 购书单号="+"'"+orderid+"'";
            rs = statement.executeQuery(query);
            String inserttakeid="",insertbuyerid="",inserttakedate="",insertorderid="",insertbuydate="",insertsellerid = "";
            insertorderid=orderid;
            insertsellerid=sellerid;
            Date date=new Date();
            SimpleDateFormat simpledateformat=new SimpleDateFormat("yyyy-MM-dd");
            inserttakeid= new SimpleDateFormat("yyyyMMddHHmmss").format(date)+insertsellerid;
            inserttakedate=new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("yyyyMMdd").parse(takedate));
            while (rs.next())
            {
                insertbuyerid= String.valueOf(rs.getString(4));
                insertbuydate= String.valueOf(rs.getString(3));
            }

            String query11 = "select * from 教材信息 where 书号="+"'"+bookid+"'";
            rs = statement.executeQuery(query11);
            int store=0;
            while (rs.next())
            {
                store= rs.getInt(8);
            }
            if(Integer.parseInt(count)>store)
            {
                JSONObject obj=new JSONObject();
                obj.put("statu","lack");
                //System.out.println(obj.toJSONString());
                result.add(obj);
            }
            else
            {
                String query2 = "insert into 领书单 values("+"'"+inserttakeid+"'"+","+"'"+insertbuyerid+"'"+","+"'"+inserttakedate+"'"+","+
                        "'"+insertorderid+"'"+","+"'"+insertbuydate+"'"+","+"'"+insertsellerid+"'"+","+0+")";
                //System.out.println(query2);
                int res = statement.executeUpdate(query2);
                String query3 = "update 订购单 set 是否处理="+1+" where 购书单号="+"'"+orderid+"'";
                //System.out.println(query3);
                int res2 = statement.executeUpdate(query3);
                String query4 = "update 教材信息 set 库存="+(store-Integer.parseInt(count))+" where 书号="+"'"+bookid+"'";
                //System.out.println(query3);
                int res3 = statement.executeUpdate(query4);
                /*String query3 = "update 订购单 set 是否处理="+1+" where 购书单号="+"'"+orderid+"'";
                //System.out.println(query3);
                int res2 = statement.executeUpdate(query3);*/

                JSONObject obj=new JSONObject();
                obj.put("statu","ok");
                //System.out.println(obj.toJSONString());
                result.add(obj);
            }
        }
        catch(SQLException | ClassNotFoundException e)
        {
        e.printStackTrace();
        } catch (ParseException e)
        {
            JSONObject obj=new JSONObject();
            obj.put("statu","wd");
            //System.out.println(obj.toJSONString());
            result.add(obj);
        }
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
    public JSONArray updatetake(String buyid)
    {
        JSONArray result = new JSONArray();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //adb_url是AnalyticDB for MySQL集群的连接地址URL，可以在控制台的集群信息页面获取连接URL，3306是端口号。
            //db_name是AnalyticDB for MySQL集群中的数据库名称。
            String url = "jdbc:mysql://120.78.226.183:3306/1?useSSL=false&autoReconnect=true&failOverReadOnly=false" +
                    "&useUnicode=true&characterEncoding=UTF-8";
            Properties connectionProps = new Properties();
            //account_name是AnalyticDB for MySQL集群中的用户账号：高权限账号或者普通账号。
            connectionProps.put("user", "root");
            //account_password是AnalyticDB for MySQL集群中用户账号对应的密码。
            connectionProps.put("password", "qhq123456");
            connection = (Connection) DriverManager.getConnection(url, connectionProps);
            statement = (Statement) connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            String query3 = "update 领书单 set 是否领书="+1+" where 购书单号="+"'"+buyid+"'";
            //System.out.println(query3);
            int res3 = statement.executeUpdate(query3);
            String query4 = "update 订购单 set 是否处理="+2+" where 购书单号="+"'"+buyid+"'";
            //System.out.println(query3);
            int res4 = statement.executeUpdate(query4);
            JSONObject obj=new JSONObject();
            obj.put("statu","ok");
            //System.out.println(obj.toJSONString());
            result.add(obj);
        }
        catch(SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
    public JSONArray selectlacktable()
    {
        JSONArray result = new JSONArray();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //adb_url是AnalyticDB for MySQL集群的连接地址URL，可以在控制台的集群信息页面获取连接URL，3306是端口号。
            //db_name是AnalyticDB for MySQL集群中的数据库名称。
            String url = "jdbc:mysql://120.78.226.183:3306/1?useSSL=false&autoReconnect=true&failOverReadOnly=false" +
                    "&useUnicode=true&characterEncoding=UTF-8";
            Properties connectionProps = new Properties();
            //account_name是AnalyticDB for MySQL集群中的用户账号：高权限账号或者普通账号。
            connectionProps.put("user", "root");
            //account_password是AnalyticDB for MySQL集群中用户账号对应的密码。
            connectionProps.put("password", "qhq123456");
            connection = (Connection) DriverManager.getConnection(url, connectionProps);
            statement = (Statement) connection.createStatement();
            String query = "select * from 缺书单";
            //System.out.println(query);
            rs = statement.executeQuery(query);
            while (rs.next()) {
                JSONObject obj=new JSONObject();
                obj.put("lackid",rs.getString(1));
                obj.put("bookid",rs.getString(2));
                obj.put("lackcount",rs.getString(3));
                obj.put("statu",rs.getInt(4));
                result.add(obj);
                //System.out.println(obj.toJSONString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
    public JSONArray insertbooklack(String bookid,String count)
    {
        JSONArray result = new JSONArray();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //adb_url是AnalyticDB for MySQL集群的连接地址URL，可以在控制台的集群信息页面获取连接URL，3306是端口号。
            //db_name是AnalyticDB for MySQL集群中的数据库名称。
            String url = "jdbc:mysql://120.78.226.183:3306/1?useSSL=false&autoReconnect=true&failOverReadOnly=false" +
                    "&useUnicode=true&characterEncoding=UTF-8";
            Properties connectionProps = new Properties();
            //account_name是AnalyticDB for MySQL集群中的用户账号：高权限账号或者普通账号。
            connectionProps.put("user", "root");
            //account_password是AnalyticDB for MySQL集群中用户账号对应的密码。
            connectionProps.put("password", "qhq123456");
            connection = (Connection) DriverManager.getConnection(url, connectionProps);
            statement = (Statement) connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            String query = "select * from 教材信息 where 书号="+"'"+bookid+"'";
            float flocount=Float.parseFloat(count);
            if(flocount<=0)
            {
                JSONObject obj=new JSONObject();
                obj.put("statu","wc2");
                //System.out.println(obj.toJSONString());
                result.add(obj);
            }
            else
            {
                //System.out.println(query);
                rs = statement.executeQuery(query);
                rs.last();
                int row=rs.getRow();
                //System.out.println(row);
                rs.beforeFirst();
                //row=rs.getRow();
                //System.out.println(row);
                if(row==0)
                {
                    JSONObject obj=new JSONObject();
                    obj.put("statu","wn");
                    //System.out.println(obj.toJSONString());
                    result.add(obj);
                }
                else
                {
                    String insertlack="",insertbookid="",insertcount="";
                    insertbookid=bookid;
                    Date date=new Date();
                    insertcount= count;
                    insertlack= new SimpleDateFormat("yyyyMMddHHmmss").format(date)+insertbookid;
                    while (rs.next()) {
                        JSONObject obj=new JSONObject();
                        obj.put("statu","t");
                        //System.out.println(obj.toJSONString());
                        result.add(obj);
                    }
                    String query2 = "insert into 缺书单 values("+"'"+insertlack+"'"+","+"'"+insertbookid+"'"+","+"'"+insertcount+"'"+","+0+")";
                    System.out.println(query2);
                    int res = statement.executeUpdate(query2);
                }
            }
        }
        catch(NumberFormatException e)
        {

            JSONObject obj=new JSONObject();
            obj.put("statu","wc1");
            System.out.println(obj.toJSONString());
            result.add(obj);
            return result;
        }
        catch(SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
    public JSONArray updatelack(String lackid,String bookid,String lackcount)
    {
        JSONArray result = new JSONArray();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //adb_url是AnalyticDB for MySQL集群的连接地址URL，可以在控制台的集群信息页面获取连接URL，3306是端口号。
            //db_name是AnalyticDB for MySQL集群中的数据库名称。
            String url = "jdbc:mysql://120.78.226.183:3306/1?useSSL=false&autoReconnect=true&failOverReadOnly=false" +
                    "&useUnicode=true&characterEncoding=UTF-8";
            Properties connectionProps = new Properties();
            //account_name是AnalyticDB for MySQL集群中的用户账号：高权限账号或者普通账号。
            connectionProps.put("user", "root");
            //account_password是AnalyticDB for MySQL集群中用户账号对应的密码。
            connectionProps.put("password", "qhq123456");
            connection = (Connection) DriverManager.getConnection(url, connectionProps);
            statement = (Statement) connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            /*String query11 = "select * from 教材信息 where 书号="+"'"+bookid+"'";
            rs = statement.executeQuery(query11);
            int store=0;
            while (rs.next())
            {
                store= rs.getInt(8);
            }*/
            String query3 = "update 缺书单 set 是否处理="+1+" where 缺书单号="+"'"+lackid+"'";
            //System.out.println(query3);
            int res3 = statement.executeUpdate(query3);
            //String query4 = "update 教材信息 set 库存="+(store+Integer.parseInt(lackcount))+" where 书号="+"'"+bookid+"'";
            //int res4 = statement.executeUpdate(query4);
            JSONObject obj=new JSONObject();
            obj.put("statu","ok");
            //System.out.println(obj.toJSONString());
            result.add(obj);
        }
        catch(SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
    public JSONArray selectintable()
    {
        JSONArray result = new JSONArray();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //adb_url是AnalyticDB for MySQL集群的连接地址URL，可以在控制台的集群信息页面获取连接URL，3306是端口号。
            //db_name是AnalyticDB for MySQL集群中的数据库名称。
            String url = "jdbc:mysql://120.78.226.183:3306/1?useSSL=false&autoReconnect=true&failOverReadOnly=false" +
                    "&useUnicode=true&characterEncoding=UTF-8";
            Properties connectionProps = new Properties();
            //account_name是AnalyticDB for MySQL集群中的用户账号：高权限账号或者普通账号。
            connectionProps.put("user", "root");
            //account_password是AnalyticDB for MySQL集群中用户账号对应的密码。
            connectionProps.put("password", "qhq123456");
            connection = (Connection) DriverManager.getConnection(url, connectionProps);
            statement = (Statement) connection.createStatement();
            String query = "select * from 进书单";
            //System.out.println(query);
            rs = statement.executeQuery(query);
            while (rs.next()) {
                JSONObject obj=new JSONObject();
                obj.put("inid",rs.getString(1));
                obj.put("bookid",rs.getString(2));
                obj.put("inerid",rs.getString(3));
                obj.put("indate",rs.getString(4));
                obj.put("incount",rs.getString(5));
                obj.put("inprice",rs.getString(6));
                result.add(obj);
                //System.out.println(obj.toJSONString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
    public JSONArray insertbookin(String bookid, String incount,String inerid) {
        JSONArray result = new JSONArray();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //adb_url是AnalyticDB for MySQL集群的连接地址URL，可以在控制台的集群信息页面获取连接URL，3306是端口号。
            //db_name是AnalyticDB for MySQL集群中的数据库名称。
            String url = "jdbc:mysql://120.78.226.183:3306/1?useSSL=false&autoReconnect=true&failOverReadOnly=false" +
                    "&useUnicode=true&characterEncoding=UTF-8";
            Properties connectionProps = new Properties();
            //account_name是AnalyticDB for MySQL集群中的用户账号：高权限账号或者普通账号。
            connectionProps.put("user", "root");
            //account_password是AnalyticDB for MySQL集群中用户账号对应的密码。
            connectionProps.put("password", "qhq123456");
            connection = (Connection) DriverManager.getConnection(url, connectionProps);
            statement = (Statement) connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            int store=0;
            String query = "select * from 教材信息 where 书号=" + "'" + bookid + "'";
            float flocount = Float.parseFloat(incount);
            if (flocount <= 0) {
                JSONObject obj = new JSONObject();
                obj.put("statu", "wc2");
                //System.out.println(obj.toJSONString());
                result.add(obj);
            } else {
                //System.out.println(query);
                rs = statement.executeQuery(query);
                rs.last();
                int row = rs.getRow();
                //System.out.println(row);
                rs.beforeFirst();
                //row=rs.getRow();
                //System.out.println(row);
                if (row == 0) {
                    JSONObject obj = new JSONObject();
                    obj.put("statu", "wn");
                    //System.out.println(obj.toJSONString());
                    result.add(obj);
                } else {
                    String insertinid = "", insertbookid = "", insertinerid = "", insertindate = "", insertincount = "", insertinprice = "";
                    insertbookid = bookid;
                    Date date = new Date();
                    SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd");
                    insertindate = simpledateformat.format(date);
                    insertinerid = inerid;
                    insertincount = incount;
                    insertinid = new SimpleDateFormat("yyyyMMddHHmmss").format(date) + insertinerid;
                    while (rs.next()) {
                        insertinprice = String.valueOf(rs.getFloat(6) * flocount);
                        store= rs.getInt(8);
                        JSONObject obj = new JSONObject();
                        obj.put("statu", "t");
                        //System.out.println(obj.toJSONString());
                        result.add(obj);
                    }

                    String query2 = "insert into 进书单 values(" + "'" + insertinid + "'" + "," + "'" + insertbookid + "'" + "," + "'" + insertinerid + "'" + "," +
                            "'" + insertindate + "'" + "," + insertincount + "," + insertinprice + ")";
                    //System.out.println(query2);
                    int res = statement.executeUpdate(query2);
                    String query4 = "update 教材信息 set 库存="+(store+Integer.parseInt(incount))+" where 书号="+"'"+bookid+"'";
                    int res4 = statement.executeUpdate(query4);
                }
            }
        } catch (NumberFormatException e) {

            JSONObject obj = new JSONObject();
            obj.put("statu", "wc1");
            System.out.println(obj.toJSONString());
            result.add(obj);
            return result;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
