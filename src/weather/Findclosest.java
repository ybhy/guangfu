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

public class Findclosest {
	private String classString = "com.mysql.jdbc.Driver";
	private String username = "root";
	private String password = "123456";
	private String url = "jdbc:mysql://localhost:3306/weather?useSSL=false";
	private static Connection con = null;
	private static PreparedStatement statement = null;

	public Findclosest() {
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
	
	public static List<List<String>> getdatan() throws SQLException{
        String sql="SELECT * FROM weather.ddddd;";			//取得九月的四个属性值
        statement = con.prepareStatement(sql);
    	ResultSet rs = statement.executeQuery();			//得到结果集  
    	List<String> windn=new ArrayList<String>();			//创建数组  
    	List<String> environmentn=new ArrayList<String>();
    	List<String> speedn = new ArrayList<String>();
    	List<String> cumulantn = new ArrayList<String>();
    	List<String> timen = new ArrayList<String>();
    	List<String> daten = new ArrayList<String>();
     	List<List<String>> retn = new ArrayList<List<String>>();
    	while (rs.next())  
    	{
    		timen.add(rs.getString("time"));
    		daten.add(rs.getString("date"));
    		windn.add(rs.getString("wind"));
    		environmentn.add(rs.getString("environment"));
    		speedn.add(rs.getString("speed"));
    		cumulantn.add(rs.getString("cumulant"));
    	}
    	retn.add(daten);
    	retn.add(timen);
    	retn.add(windn);
    	retn.add(environmentn);
    	retn.add(speedn);
    	retn.add(cumulantn);
    	return retn;
	}

	public static List<List<String>> getdata() throws SQLException{
        String sql = "SELECT * FROM weather.aaaaa;";		//取得所有的数据
        statement = con.prepareStatement(sql);
    	ResultSet rs = statement.executeQuery();			//得到结果集  
    	List<String> winda = new ArrayList<String>();			//创建数组  
    	List<String> environmenta = new ArrayList<String>();
    	List<String> speeda = new ArrayList<String>();
    	List<String> cumulanta = new ArrayList<String>();
    	List<String> onetemp = new ArrayList<String>();
    	List<String> twotemp = new ArrayList<String>();
    	List<String> threetemp = new ArrayList<String>();
    	List<String> fourtemp = new ArrayList<String>();
    	List<String> fivetemp = new ArrayList<String>();
    	List<String> sixtemp = new ArrayList<String>();
    	List<String> seventemp = new ArrayList<String>();
    	List<String> time = new ArrayList<String>();
    	List<String> date = new ArrayList<String>();
     	List<List<String>> ret = new ArrayList<List<String>>();
    	while (rs.next())  
    	{
    		time.add(rs.getString("time"));
    		date.add(rs.getString("date"));
    		winda.add(rs.getString("wind"));
    		environmenta.add(rs.getString("environment"));
    		speeda.add(rs.getString("speed"));
    		cumulanta.add(rs.getString("cumulant"));
    		onetemp.add(rs.getString("onetemp"));
    		twotemp.add(rs.getString("twotemp"));
    		threetemp.add(rs.getString("threetemp"));
    		fourtemp.add(rs.getString("fourtemp"));
    		fivetemp.add(rs.getString("fivetemp"));
    		sixtemp.add(rs.getString("sixtemp"));
    		seventemp.add(rs.getString("seventemp"));
    	}
    	ret.add(date);
    	ret.add(time);
    	ret.add(winda);
    	ret.add(environmenta);
    	ret.add(speeda);
    	ret.add(cumulanta);
    	ret.add(onetemp);
    	ret.add(twotemp);
    	ret.add(threetemp);
    	ret.add(fourtemp);
    	ret.add(fivetemp);
    	ret.add(sixtemp);
    	ret.add(seventemp);
    	return ret;
	}

	public void select() {
		try {
				List<List<String>> ret = new ArrayList<List<String>>();
				List<List<String>> retn = new ArrayList<List<String>>();
				ret = getdata();
				retn = getdatan();
				List<String> dateA = new ArrayList<String>();		//所有的数据的列表
				List<String> timeA = new ArrayList<String>();
				List<Double> windA = new ArrayList<Double>();
				List<Double> environmentA = new ArrayList<Double>();
				List<Double> speedA = new ArrayList<Double>();
				List<Double> cumulantA = new ArrayList<Double>();
				List<Double> onetempA = new ArrayList<Double>();
				List<Double> twotempA = new ArrayList<Double>();
				List<Double> threetempA = new ArrayList<Double>();
				List<Double> fourtempA = new ArrayList<Double>();
				List<Double> fivetempA = new ArrayList<Double>();
				List<Double> sixtempA = new ArrayList<Double>();
				List<Double> seventempA = new ArrayList<Double>();
				List<String> dateN = new ArrayList<String>();		//九月的数据的列表
				List<String> timeN = new ArrayList<String>();
				List<Double> windN = new ArrayList<Double>();
				List<Double> environmentN = new ArrayList<Double>();
				List<Double> speedN = new ArrayList<Double>();
				List<Double> cumulantN = new ArrayList<Double>();
				for(int i = 0; i < ret.get(0).size(); i++)
				{
					System.out.println(ret.get(0).get(i) + " " + 
							ret.get(1).get(i) + " " + ret.get(2).get(i) + " " + ret.get(3).get(i) + " " + ret.get(4).get(i) + " " +
							ret.get(5).get(i) + " " + ret.get(6).get(i) + " " + ret.get(7).get(i) + " " + ret.get(8).get(i) + " " +
							ret.get(9).get(i) + " " + ret.get(10).get(i) + " " + ret.get(11).get(i) + " " + ret.get(12).get(i));
					dateA.add(ret.get(0).get(i));
					timeA.add(ret.get(1).get(i));
					windA.add(Double.parseDouble(ret.get(2).get(i)));
					environmentA.add(Double.parseDouble(ret.get(3).get(i)));
					speedA.add(Double.parseDouble(ret.get(4).get(i)));
					cumulantA.add(Double.parseDouble(ret.get(5).get(i)));
					onetempA.add(Double.parseDouble(ret.get(6).get(i)));
					twotempA.add(Double.parseDouble(ret.get(7).get(i)));
					threetempA.add(Double.parseDouble(ret.get(8).get(i)));
					fourtempA.add(Double.parseDouble(ret.get(9).get(i)));
					fivetempA.add(Double.parseDouble(ret.get(10).get(i)));
					sixtempA.add(Double.parseDouble(ret.get(11).get(i)));
					seventempA.add(Double.parseDouble(ret.get(12).get(i)));
				}
				for(int j = 0; j < retn.get(0).size(); j++)
				{
					dateN.add(retn.get(0).get(j));
					timeN.add(retn.get(1).get(j));
					windN.add(Double.parseDouble(retn.get(2).get(j)));
					environmentN.add(Double.parseDouble(retn.get(3).get(j)));
					speedN.add(Double.parseDouble(retn.get(4).get(j)));
					cumulantN.add(Double.parseDouble(retn.get(5).get(j)));
				}
				Double distance = 0.0;
				Double minDistance = 10000000000.0;
				Double timeall = 0.0;		//每点钟七个的总量
				Double dayall = 0.0;		//每天七个的总量
				String currentDate = "2015-9-1";
				String date = "";
				String time = "";
				Double wind = 0.0;
				Double environment = 0.0;
				Double speed = 0.0;
				Double cumulant = 0.0;
				Double one = 0.0;
				Double two = 0.0;
				Double three = 0.0;
				Double four = 0.0;
				Double five = 0.0;
				Double six = 0.0;
				Double seven = 0.0;
//				if(windA.size() != 0)
//				{
//					distance = Math.sqrt(Math.pow(windA.get(0) - windN.get(0), 2) + 
//							Math.pow(environmentA.get(0) - environmentN.get(0), 2) +
//							Math.pow(speedA.get(0) - speedN.get(0), 2) +
//							Math.pow(cumulantA.get(0) - cumulantN.get(0), 2));
//					minDistance = distance;
//					date = dateA.get(0);
//					time = timeA.get(0);
//					wind = windA.get(0);
//					environment = environmentA.get(0);
//					speed = speedA.get(0);
//					cumulant = cumulantA.get(0);
//					one = onetempA.get(0);
//					two = twotempA.get(0);
//					three =threetempA.get(0);
//					four = fourtempA.get(0);
//					five = fivetempA.get(0);
//					six = sixtempA.get(0);
//					seven = seventempA.get(0);
//				}
				for (int j = 0; j < windN.size(); j++) 
				{
					minDistance = 10000000000.0;
					for (int i = 0; i < windA.size(); i++) 
					{
						if(((dateA.get(i)!=(dateN.get(j)) && (timeA.get(i))!=timeN.get(j))))
						{
							distance = Math.sqrt(Math.pow(windA.get(i) - windN.get(j), 2) +
									Math.pow(environmentA.get(i) - windN.get(j), 2) + 
									Math.pow(speedA.get(i) - speedN.get(j), 2) +
									Math.pow(cumulantA.get(i) - cumulantN.get(j), 2));      //欧式距离；开平方根
							if(distance < minDistance)
							{
								minDistance = distance;
								date = dateA.get(i);
								time = timeA.get(i);
								wind = windA.get(i);
								environment = environmentA.get(i);
								speed = speedA.get(i);
								cumulant = cumulantA.get(i);
								one = onetempA.get(i);
								two = twotempA.get(i);
								three =threetempA.get(i);
								four = fourtempA.get(i);
								five = fivetempA.get(i);
								six = sixtempA.get(i);
								seven = seventempA.get(i);	
							}
							
						}
					}
					if(dateN.get(j).equals(currentDate))
					{
						
						dayall += (one + two +three + four + five + six + seven);
//						System.out.println("与它最接近的气象数据是：" + date + " " +  time + "; wind=" + String.valueOf(wind)
//								+ "; environment=" + String.valueOf(environment) + "; speed=" + String.valueOf(speed)
//								+ "; cumulant=" + String.valueOf(cumulant) + "; one=" + String.valueOf(one)
//								+ "; two=" + String.valueOf(two) + "; three=" + String.valueOf(three)
//								+ "; four=" + String.valueOf(four) + "; five=" + String.valueOf(five)
//								+ "; six=" + String.valueOf(six) + "; seven=" + String.valueOf(seven));
					}else{
						System.out.println(currentDate + "发电总量:" + dayall);
						currentDate = dateN.get(j);
						dayall = 0.0;
						dayall += (one + two +three + four + five + six + seven);
//						System.out.println("与它最接近的气象数据是：" + date + " " +  time + "; wind=" + String.valueOf(wind)
//								+ "; environment=" + String.valueOf(environment) + "; speed=" + String.valueOf(speed)
//								+ "; cumulant=" + String.valueOf(cumulant) + "; one=" + String.valueOf(one)
//								+ "; two=" + String.valueOf(two) + "; three=" + String.valueOf(three)
//								+ "; four=" + String.valueOf(four) + "; five=" + String.valueOf(five)
//								+ "; six=" + String.valueOf(six) + "; seven=" + String.valueOf(seven));
					}
					
		        }
//				dayall += (one + two +three + four + five + six + seven);
				System.out.println(currentDate + "发电总量:" + dayall);
			}catch (Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
			} finally {
		}
	}
	public static void main(String[] args){
		Findclosest gc = new Findclosest();
		gc.select();
		gc.close();
	}
}
	
	