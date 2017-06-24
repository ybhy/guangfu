package weather;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Connectmysql {
//	private static final double[] Distence = null;
	private String classString = "com.mysql.jdbc.Driver";
	private String username = "root";
	private String password = "123456";
	private String url = "jdbc:mysql://localhost:3306/weather?useSSL=false";
	private static Connection con = null;
	private static PreparedStatement statement = null;

	public Connectmysql() {
		try {
			Class.forName(classString);
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Success!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public void close() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
	}
	public void upDateTemp(String date, String time, Double onetemp, Double twotemp, 
			Double threetemp, Double fourtemp, Double fivetemp, Double sixtemp, Double seventemp) throws SQLException
	{
		try{
		String sql = "update weather.weathermodel set onetemp = " + onetemp + ", twotemp = " + twotemp + ","
				+ "threetemp = " + threetemp + ", fourtemp = " + fourtemp + ", fivetemp = " + fivetemp + ", "
						+ "sixtemp = " + sixtemp + ", seventemp = " + seventemp + " where time = '" + time + "' "
								+ "and date = '" + date + "'"   ;
		System.out.println(sql);
		statement = con.prepareStatement(sql);
		statement.execute();
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	public static List<List<String>> getdata() throws SQLException{
        String sql="SELECT * FROM weather.ddddd;";
        statement = con.prepareStatement(sql);
    	ResultSet rs = statement.executeQuery();			//得到结果集  
    	List<String> wind=new ArrayList<String>();			//创建数组  
    	List<String> environment=new ArrayList<String>();
    	List<String> speed=new ArrayList<String>();
    	List<String> cumulant=new ArrayList<String>();
    	List<String> one = new ArrayList<String>();
    	List<String> two = new ArrayList<String>();
    	List<String> three = new ArrayList<String>();
    	List<String> four = new ArrayList<String>();
    	List<String> five = new ArrayList<String>();
    	List<String> six = new ArrayList<String>();
    	List<String> seven = new ArrayList<String>();
    	List<String> time = new ArrayList<String>();
    	List<String> date = new ArrayList<String>();
     	List<List<String>> ret = new ArrayList<List<String>>();
    	while (rs.next())  
    	{
    		time.add(rs.getString("time"));
    		date.add(rs.getString("date"));
    		wind.add(rs.getString("wind"));
    		environment.add(rs.getString("environment"));
    		speed.add(rs.getString("speed"));
    		cumulant.add(rs.getString("cumulant"));
    		one.add(rs.getString("one"));
    		two.add(rs.getString("two"));
    		three.add(rs.getString("three"));
    		four.add(rs.getString("four"));
    		five.add(rs.getString("five"));
    		six.add(rs.getString("six"));
    		seven.add(rs.getString("seven"));
    	}
    	ret.add(date);
    	ret.add(time);
    	ret.add(wind);
    	ret.add(environment);
    	ret.add(speed);
    	ret.add(cumulant);
    	ret.add(one);
    	ret.add(two);
    	ret.add(three);
    	ret.add(four);
    	ret.add(five);
    	ret.add(six);
    	ret.add(seven);
    	return ret;
	}

	public void select() {
		try {
				Scanner input = new Scanner(System.in);
				System.out.println("输入4个气象数据，输入end结束：");
				double x1 = input.nextDouble();  		 //第一个数wind
				double x2 = input.nextDouble();   		 //第二个数environment
				double x3 = input.nextDouble();  		 //第三个数speed
				double x4 = input.nextDouble();   		 //第四个数cumulant
				String e = input.nextLine();
				if(!e.equals("end")) {
					e = input.nextLine();
					List<List<String>> ret = new ArrayList<List<String>>();
					ret = getdata();
					List<String> dateL = new ArrayList<String>();
					List<String> timeL = new ArrayList<String>();
					List<Double> windL = new ArrayList<Double>();
					List<Double> environmentL = new ArrayList<Double>();
					List<Double> speedL = new ArrayList<Double>();
					List<Double> cumulantL = new ArrayList<Double>();
					List<String> oneL = new ArrayList<String>();
					List<String> twoL = new ArrayList<String>();
					List<String> threeL = new ArrayList<String>();
					List<String> fourL = new ArrayList<String>();
					List<String> fiveL = new ArrayList<String>();
					List<String> sixL = new ArrayList<String>();
					List<String> sevenL = new ArrayList<String>();
					for(int i = 0; i < ret.get(0).size(); i++)
					{
						System.out.println(ret.get(0).get(i) + " " + 
								ret.get(1).get(i) + " " + ret.get(2).get(i) + " " + ret.get(3).get(i) + " " + ret.get(4).get(i) + " " +
								ret.get(5).get(i) + " " + ret.get(6).get(i) + " " + ret.get(7).get(i) + " " + ret.get(8).get(i) + " " +
								ret.get(9).get(i) + " " + ret.get(10).get(i) + " " + ret.get(11).get(i) + " " + ret.get(12).get(i));
						dateL.add(ret.get(0).get(i));
						timeL.add(ret.get(1).get(i));
						windL.add(Double.parseDouble(ret.get(2).get(i)));
						environmentL.add(Double.parseDouble(ret.get(3).get(i)));
						speedL.add(Double.parseDouble(ret.get(4).get(i)));
						cumulantL.add(Double.parseDouble(ret.get(5).get(i)));
						oneL.add(ret.get(6).get(i));
						twoL.add(ret.get(7).get(i));
						threeL.add(ret.get(8).get(i));
						fourL.add(ret.get(9).get(i));
						fiveL.add(ret.get(10).get(i));
						sixL.add(ret.get(11).get(i));
						sevenL.add(ret.get(12).get(i));
					}
					Double distance = 0.0;
					Double minDistance = 0.0;
					
					String date = "";
					String time = "";
					Double wind = 0.0;
					Double environment = 0.0;
					Double speed = 0.0;
					Double cumulant = 0.0;
					String one = "";
					String two = "";
					String three = "";
					String four = "";
					String five = "";
					String six = "";
					String seven = "";
					if(windL.size() != 0)
					{
						distance = Math.sqrt(Math.pow(windL.get(0) - x1, 2) + Math.pow(environmentL.get(0) - x2, 2) +
								Math.pow(speedL.get(0) - x3, 2) + Math.pow(cumulantL.get(0) - x4, 2));
						minDistance = distance;
						date = dateL.get(0);
						time = timeL.get(0);
						wind = windL.get(0);
						environment = environmentL.get(0);
						speed = speedL.get(0);
						cumulant = cumulantL.get(0);
						one = oneL.get(0);
						two = twoL.get(0);
						three =threeL.get(0);
						four = fourL.get(0);
						five = fiveL.get(0);
						six = sixL.get(0);
						seven = sevenL.get(0);
						
					}
					for (int i = 1; i < windL.size(); i++) {
						
						distance = Math.sqrt(Math.pow(windL.get(i) - x1, 2) +
								Math.pow(environmentL.get(i) - x2, 2) + 
								Math.pow(speedL.get(i) - x3, 2) +
								Math.pow(cumulantL.get(i) - x4, 2));      //开平方根
						if(distance < minDistance)
						{
							minDistance = distance;
							date = dateL.get(i);
							time = timeL.get(i);
							wind = windL.get(i);
							environment = environmentL.get(i);
							speed = speedL.get(i);
							cumulant = cumulantL.get(i);
							one = oneL.get(i);
							two = twoL.get(i);
							three =threeL.get(i);
							four = fourL.get(i);
							five = fiveL.get(i);
							six = sixL.get(i);
							seven = sevenL.get(i);		
						}
			        }
					
					System.out.println(minDistance);
					System.out.println("与它最接近的气象数据是：" + date + " " +  time + "; wind=" + String.valueOf(wind)
							+ "; environment=" + String.valueOf(environment) + "; speed=" + String.valueOf(speed)
							+ "; cumulant=" + String.valueOf(cumulant) + "; one=" + String.valueOf(one)
							+ "; two=" + String.valueOf(two) + "; three=" + String.valueOf(three)
							+ "; four=" + String.valueOf(four) + "; five=" + String.valueOf(five)
							+ "; six=" + String.valueOf(six) + "; seven=" + String.valueOf(seven));
				}
			}catch (Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
			} finally {
		}
	}
}
	
	