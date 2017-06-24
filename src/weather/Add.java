//0~22点各数据相加
package weather;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Add {
	private String classString = "com.mysql.jdbc.Driver";
	private String username = "root";
	private String password = "123456";
	private String url = "jdbc:mysql://localhost:3306/weather?useSSL=false";
	private Connection con = null;
	private PreparedStatement  statement=null;
	public Add() {
		try {
			Class.forName(classString);
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Success!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void close(){
		if (con != null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	public void insert(String time, double one,
			double two, double three,
			double four, double five,
			double six, double seven, String date) {
		// TODO Auto-generated method stub
		String sql = "insert into generateelectricity(time,one,two,three,four,five,six,seven,date) values(?,?,?,?,?,?,?,?,?)";
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, time);
			statement.setDouble(2, one);
			statement.setDouble(3, two);
			statement.setDouble(4, three);
			statement.setDouble(5, four);
			statement.setDouble(6, five);
			statement.setDouble(7, six);
			statement.setDouble(8, seven);
			statement.setString(9,  date);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public void select()
	{
		String sql = "select * from weatherdata";
		try{
			statement = con.prepareStatement(sql);
			ResultSet rset = statement.executeQuery();
			int rowCount = 0; 
			int index = 0;
			boolean isFinish0 = false;
			boolean isFinish1 = false;
			boolean isFinish2 = false;
			boolean isFinish3 = false;
			boolean isFinish4 = false;
			boolean isFinish5 = false;
			boolean isFinish6 = false;
			boolean isFinish7 = false;
			boolean isFinish8 = false;
			boolean isFinish9 = false;
			boolean isFinish10 = false;
			boolean isFinish11 = false;
			boolean isFinish12 = false;
			boolean isFinish13 = false;
			boolean isFinish14 = false;
			boolean isFinish15 = false;
			boolean isFinish16 = false;
			boolean isFinish17 = false;
			boolean isFinish18 = false;
			boolean isFinish19 = false;
			boolean isFinish20 = false;
			boolean isFinish21 = false;
			boolean isFinish22 = false;
			boolean isFinish23 = false;
			boolean isFinish24 = false;
			int count0 = 0;
			int count1 = 0;
			int count2 = 0;
			int count3 = 0;
			int count4 = 0;
			int count5 = 0;
			int count6 = 0;
			int count7 = 0;
			int count8 = 0;
			int count9 = 0;
			int count10 = 0;
			int count11= 0;
			int count12 = 0;
			int count13 = 0;
			int count14 = 0;
			int count15 = 0;
			int count16 = 0;
			int count17 = 0;
			int count18 = 0;
			int count19 = 0;
			int count20 = 0;
			int count21 = 0;
			int count22 = 0;
			int count23 = 0;
			double sumWind = 0;
			double sumEnvironment = 0;
			double sumSpeed = 0;
			double sumCumulant = 0;
			double avgWind = 0;
			double avgEnvironment = 0;
			double avgSpeed = 0;
			double avgCumulant = 0;
			while(rset.next()) { 
			  String time = rset.getString("time");
			  String date = rset.getString("date");
			  double wind = rset.getDouble("wind");
			  double environment = rset.getDouble("environment");
			  double speed = rset.getDouble("speed");
			  double cumulant = rset.getDouble("cumulant");
			  
			  switch(time.substring(0, (time.indexOf(":"))))
			  {
				  case "0": 
					  if(!isFinish0)
					  {
						  sumWind += wind;
						  sumEnvironment += environment;
						  sumSpeed += speed;
						  sumCumulant += cumulant;
						  count0++;
					  }
					  
					  break;
				  case "1":
					  if(count0!= 0)
					  {
						  avgWind = sumWind / count0;
						  avgEnvironment = sumEnvironment / count0;
						  avgSpeed = sumSpeed / count0;
						  avgCumulant = sumCumulant / count0;
						  String sql0 = "update weathermodel set wind = '" + String.valueOf(avgWind) + 
								  "' where time='0:00' and date='" + date +"'";
						  String sql1 = "update weathermodel set environment = '" + String.valueOf(avgEnvironment) + 
								  "' where time='0:00' and date='" + date +"'";
						  String sql2 = "update weathermodel set speed = '" + String.valueOf(avgSpeed) + 
								  "' where time='0:00' and date='" + date +"'";
						  String sql3 = "update weathermodel set cumulant = '" + String.valueOf(sumCumulant) + 
								  "' where time='0:00' and date='" + date +"'";
						  System.out.println(sql0);
						  System.out.println(sql1);
						  System.out.println(sql2);
						  System.out.println(sql3);
						  statement = con.prepareStatement(sql0);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql1);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql2);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql3);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  sumWind = 0;
						  sumEnvironment=0;
						  sumSpeed=0;
						  sumCumulant=0;
					  }
					  count0 = 0;
					  if(!isFinish1)
					  {
						  sumWind += wind;
						  sumEnvironment += environment;
						  sumSpeed += speed;
						  sumCumulant += cumulant;
						  count1++;
					  }
					  break;
				  	
				  case "2": 
					  if(count1 != 0)
					  {
						  avgWind = sumWind / count1;
						  avgEnvironment = sumEnvironment / count1;
						  avgSpeed = sumSpeed / count1;
						  avgCumulant = sumCumulant / count1;
						  String sql0 = "update weathermodel set wind = '" + String.valueOf(avgWind) + 
								  "' where time='1:00' and date='" + date +"'";
						  String sql1 = "update weathermodel set environment = '" + String.valueOf(avgEnvironment) + 
								  "' where time='1:00' and date='" + date +"'";
						  String sql2 = "update weathermodel set speed = '" + String.valueOf(avgSpeed) + 
								  "' where time='1:00' and date='" + date +"'";
						  String sql3 = "update weathermodel set cumulant = '" + String.valueOf(sumCumulant) + 
								  "' where time='1:00' and date='" + date +"'";
						  System.out.println(sql0);
						  System.out.println(sql1);
						  System.out.println(sql2);
						  System.out.println(sql3);
						  statement = con.prepareStatement(sql0);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql1);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql2);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql3);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  sumWind = 0;
						  sumEnvironment=0;
						  sumSpeed=0;
						  sumCumulant=0;
					  }
					  count1 = 0;
					  if(!isFinish2)
					  {
						  sumWind += wind;
						  sumEnvironment += environment;
						  sumSpeed += speed;
						  sumCumulant += cumulant;
						  count2++;
					  }
					  break;
					  
				  case "3":
					  if(count2!= 0)
					  {
						  avgWind = sumWind / count2;
						  avgEnvironment = sumEnvironment / count2;
						  avgSpeed = sumSpeed / count2;
						  avgCumulant = sumCumulant / count2;
						  String sql0 = "update weathermodel set wind = '" + String.valueOf(avgWind) + 
								  "' where time='2:00' and date='" + date +"'";
						  String sql1 = "update weathermodel set environment = '" + String.valueOf(avgEnvironment) + 
								  "' where time='2:00' and date='" + date +"'";
						  String sql2 = "update weathermodel set speed = '" + String.valueOf(avgSpeed) + 
								  "' where time='2:00' and date='" + date +"'";
						  String sql3 = "update weathermodel set cumulant = '" + String.valueOf(sumCumulant) + 
								  "' where time='2:00' and date='" + date +"'";
						  System.out.println(sql0);
						  System.out.println(sql1);
						  System.out.println(sql2);
						  System.out.println(sql3);
						  statement = con.prepareStatement(sql0);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql1);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql2);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql3);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  sumWind = 0;
						  sumEnvironment=0;
						  sumSpeed=0;
						  sumCumulant=0;
					  }
					  count2 = 0;
					  if(!isFinish3)
					  {
						  sumWind += wind;
						  sumEnvironment += environment;
						  sumSpeed += speed;
						  sumCumulant += cumulant;
						  count3++;
					  }
					  break;
					  
				  case "4":
					  if(count3!= 0)
					  {
						  avgWind = sumWind / count3;
						  avgEnvironment = sumEnvironment / count3;
						  avgSpeed = sumSpeed / count3;
						  avgCumulant = sumCumulant / count3;
						  String sql0 = "update weathermodel set wind = '" + String.valueOf(avgWind) + 
								  "' where time='3:00' and date='" + date +"'";
						  String sql1 = "update weathermodel set environment = '" + String.valueOf(avgEnvironment) + 
								  "' where time='3:00' and date='" + date +"'";
						  String sql2 = "update weathermodel set speed = '" + String.valueOf(avgSpeed) + 
								  "' where time='3:00' and date='" + date +"'";
						  String sql3 = "update weathermodel set cumulant = '" + String.valueOf(sumCumulant) + 
								  "' where time='3:00' and date='" + date +"'";
						  System.out.println(sql0);
						  System.out.println(sql1);
						  System.out.println(sql2);
						  System.out.println(sql3);
						  statement = con.prepareStatement(sql0);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql1);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql2);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql3);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  sumWind = 0;
						  sumEnvironment=0;
						  sumSpeed=0;
						  sumCumulant=0;
					  }
					  count3 = 0;
					  if(!isFinish4)
					  {
						  sumWind += wind;
						  sumEnvironment += environment;
						  sumSpeed += speed;
						  sumCumulant += cumulant;
						  count4++;
					  }
					  break;
					  
				  case "5":
					  if(count4!= 0)
					  {
						  avgWind = sumWind / count4;
						  avgEnvironment = sumEnvironment / count4;
						  avgSpeed = sumSpeed / count4;
						  avgCumulant = sumCumulant / count4;
						  String sql0 = "update weathermodel set wind = '" + String.valueOf(avgWind) + 
								  "' where time='4:00' and date='" + date +"'";
						  String sql1 = "update weathermodel set environment = '" + String.valueOf(avgEnvironment) + 
								  "' where time='4:00' and date='" + date +"'";
						  String sql2 = "update weathermodel set speed = '" + String.valueOf(avgSpeed) + 
								  "' where time='4:00' and date='" + date +"'";
						  String sql3 = "update weathermodel set cumulant = '" + String.valueOf(sumCumulant) + 
								  "' where time='4:00' and date='" + date +"'";
						  System.out.println(sql0);
						  System.out.println(sql1);
						  System.out.println(sql2);
						  System.out.println(sql3);
						  statement = con.prepareStatement(sql0);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql1);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql2);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql3);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  sumWind = 0;
						  sumEnvironment=0;
						  sumSpeed=0;
						  sumCumulant=0;
					  }
					  count4 = 0;
					  if(!isFinish5)
					  {
						  sumWind += wind;
						  sumEnvironment += environment;
						  sumSpeed += speed;
						  sumCumulant += cumulant;
						  count5++;
					  }
					  break;
					  
				  case "6": 
					  if(count5!= 0)
					  {
						  avgWind = sumWind / count5;
						  avgEnvironment = sumEnvironment / count5;
						  avgSpeed = sumSpeed / count5;
						  avgCumulant = sumCumulant / count5;
						  String sql0 = "update weathermodel set wind = '" + String.valueOf(avgWind) + 
								  "' where time='5:00' and date='" + date +"'";
						  String sql1 = "update weathermodel set environment = '" + String.valueOf(avgEnvironment) + 
								  "' where time='5:00' and date='" + date +"'";
						  String sql2 = "update weathermodel set speed = '" + String.valueOf(avgSpeed) + 
								  "' where time='5:00' and date='" + date +"'";
						  String sql3 = "update weathermodel set cumulant = '" + String.valueOf(sumCumulant) + 
								  "' where time='5:00' and date='" + date +"'";
						  System.out.println(sql0);
						  System.out.println(sql1);
						  System.out.println(sql2);
						  System.out.println(sql3);
						  statement = con.prepareStatement(sql0);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql1);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql2);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql3);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  sumWind = 0;
						  sumEnvironment=0;
						  sumSpeed=0;
						  sumCumulant=0;
					  }
					  count5 = 0;
					  if(!isFinish6)
					  {
						  sumWind += wind;
						  sumEnvironment += environment;
						  sumSpeed += speed;
						  sumCumulant += cumulant;
						  count6++;
					  }
					  break;
					  
				  case "7":
					  if(count6!= 0)
					  {
						  avgWind = sumWind / count6;
						  avgEnvironment = sumEnvironment / count6;
						  avgSpeed = sumSpeed / count6;
						  avgCumulant = sumCumulant / count6;
						  String sql0 = "update weathermodel set wind = '" + String.valueOf(avgWind) + 
								  "' where time='6:00' and date='" + date +"'";
						  String sql1 = "update weathermodel set environment = '" + String.valueOf(avgEnvironment) + 
								  "' where time='6:00' and date='" + date +"'";
						  String sql2 = "update weathermodel set speed = '" + String.valueOf(avgSpeed) + 
								  "' where time='6:00' and date='" + date +"'";
						  String sql3 = "update weathermodel set cumulant = '" + String.valueOf(sumCumulant) + 
								  "' where time='6:00' and date='" + date +"'";
						  System.out.println(sql0);
						  System.out.println(sql1);
						  System.out.println(sql2);
						  System.out.println(sql3);
						  statement = con.prepareStatement(sql0);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql1);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql2);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql3);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  sumWind = 0;
						  sumEnvironment=0;
						  sumSpeed=0;
						  sumCumulant=0;
					  }
					  count6 = 0;
					  if(!isFinish7)
					  {
						  sumWind += wind;
						  sumEnvironment += environment;
						  sumSpeed += speed;
						  sumCumulant += cumulant;
						  count7++;
					  }
					  break;
					  
				  case "8":
					  if(count7!= 0)
					  {
						  avgWind = sumWind / count7;
						  avgEnvironment = sumEnvironment / count7;
						  avgSpeed = sumSpeed / count7;
						  avgCumulant = sumCumulant / count7;
						  String sql0 = "update weathermodel set wind = '" + String.valueOf(avgWind) + 
								  "' where time='7:00' and date='" + date +"'";
						  String sql1 = "update weathermodel set environment = '" + String.valueOf(avgEnvironment) + 
								  "' where time='7:00' and date='" + date +"'";
						  String sql2 = "update weathermodel set speed = '" + String.valueOf(avgSpeed) + 
								  "' where time='7:00' and date='" + date +"'";
						  String sql3 = "update weathermodel set cumulant = '" + String.valueOf(sumCumulant) + 
								  "' where time='7:00' and date='" + date +"'";
						  System.out.println(sql0);
						  System.out.println(sql1);
						  System.out.println(sql2);
						  System.out.println(sql3);
						  statement = con.prepareStatement(sql0);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql1);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql2);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql3);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  sumWind = 0;
						  sumEnvironment=0;
						  sumSpeed=0;
						  sumCumulant=0;
					  }
					  count7 = 0;
					  if(!isFinish8)
					  {
						  sumWind += wind;
						  sumEnvironment += environment;
						  sumSpeed += speed;
						  sumCumulant += cumulant;
						  count8++;
					  }
					  break;
					  
				  case "9":
					  if(count8!= 0)
					  {
						  avgWind = sumWind / count8;
						  avgEnvironment = sumEnvironment / count8;
						  avgSpeed = sumSpeed / count8;
						  avgCumulant = sumCumulant / count0;
						  String sql0 = "update weathermodel set wind = '" + String.valueOf(avgWind) + 
								  "' where time='8:00' and date='" + date +"'";
						  String sql1 = "update weathermodel set environment = '" + String.valueOf(avgEnvironment) + 
								  "' where time='8:00' and date='" + date +"'";
						  String sql2 = "update weathermodel set speed = '" + String.valueOf(avgSpeed) + 
								  "' where time='8:00' and date='" + date +"'";
						  String sql3 = "update weathermodel set cumulant = '" + String.valueOf(sumCumulant) + 
								  "' where time='8:00' and date='" + date +"'";
						  System.out.println(sql0);
						  System.out.println(sql1);
						  System.out.println(sql2);
						  System.out.println(sql3);
						  statement = con.prepareStatement(sql0);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql1);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql2);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql3);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  sumWind = 0;
						  sumEnvironment=0;
						  sumSpeed=0;
						  sumCumulant=0;
					  }
					  count8 = 0;
					  if(!isFinish9)
					  {
						  sumWind += wind;
						  sumEnvironment += environment;
						  sumSpeed += speed;
						  sumCumulant += cumulant;
						  count9++;
					  }
					  break;
					  
				  case "10":
					  if(count9!= 0)
					  {
						  avgWind = sumWind / count9;
						  avgEnvironment = sumEnvironment / count9;
						  avgSpeed = sumSpeed / count9;
						  avgCumulant = sumCumulant / count9;
						  String sql0 = "update weathermodel set wind = '" + String.valueOf(avgWind) + 
								  "' where time='9:00' and date='" + date +"'";
						  String sql1 = "update weathermodel set environment = '" + String.valueOf(avgEnvironment) + 
								  "' where time='9:00' and date='" + date +"'";
						  String sql2 = "update weathermodel set speed = '" + String.valueOf(avgSpeed) + 
								  "' where time='9:00' and date='" + date +"'";
						  String sql3 = "update weathermodel set cumulant = '" + String.valueOf(sumCumulant) + 
								  "' where time='9:00' and date='" + date +"'";
						  System.out.println(sql0);
						  System.out.println(sql1);
						  System.out.println(sql2);
						  System.out.println(sql3);
						  statement = con.prepareStatement(sql0);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql1);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql2);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql3);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  sumWind = 0;
						  sumEnvironment=0;
						  sumSpeed=0;
						  sumCumulant=0;
					  }
					  count9 = 0;
					  if(!isFinish10)
					  {
						  sumWind += wind;
						  sumEnvironment += environment;
						  sumSpeed += speed;
						  sumCumulant += cumulant;
						  count10++;
					  }
					  break;
					  
				  case "11":
					  if(count10!= 0)
					  {
						  avgWind = sumWind / count10;
						  avgEnvironment = sumEnvironment / count10;
						  avgSpeed = sumSpeed / count10;
						  avgCumulant = sumCumulant / count10;
						  String sql0 = "update weathermodel set wind = '" + String.valueOf(avgWind) + 
								  "' where time='10:00' and date='" + date +"'";
						  String sql1 = "update weathermodel set environment = '" + String.valueOf(avgEnvironment) + 
								  "' where time='10:00' and date='" + date +"'";
						  String sql2 = "update weathermodel set speed = '" + String.valueOf(avgSpeed) + 
								  "' where time='10:00' and date='" + date +"'";
						  String sql3 = "update weathermodel set cumulant = '" + String.valueOf(sumCumulant) + 
								  "' where time='10:00' and date='" + date +"'";
						  System.out.println(sql0);
						  System.out.println(sql1);
						  System.out.println(sql2);
						  System.out.println(sql3);
						  statement = con.prepareStatement(sql0);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql1);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql2);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql3);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  sumWind = 0;
						  sumEnvironment=0;
						  sumSpeed=0;
						  sumCumulant=0;
					  }
					  count10 = 0;
					  if(!isFinish11)
					  {
						  sumWind += wind;
						  sumEnvironment += environment;
						  sumSpeed += speed;
						  sumCumulant += cumulant;
						  count11++;
					  }
					  break;
					  
				  case "12":
					  if(count11!= 0)
					  {
						  avgWind = sumWind / count11;
						  avgEnvironment = sumEnvironment / count11;
						  avgSpeed = sumSpeed / count11;
						  avgCumulant = sumCumulant / count11;
						  String sql0 = "update weathermodel set wind = '" + String.valueOf(avgWind) + 
								  "' where time='11:00' and date='" + date +"'";
						  String sql1 = "update weathermodel set environment = '" + String.valueOf(avgEnvironment) + 
								  "' where time='11:00' and date='" + date +"'";
						  String sql2 = "update weathermodel set speed = '" + String.valueOf(avgSpeed) + 
								  "' where time='11:00' and date='" + date +"'";
						  String sql3 = "update weathermodel set cumulant = '" + String.valueOf(sumCumulant) + 
								  "' where time='11:00' and date='" + date +"'";
						  System.out.println(sql0);
						  System.out.println(sql1);
						  System.out.println(sql2);
						  System.out.println(sql3);
						  statement = con.prepareStatement(sql0);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql1);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql2);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql3);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  sumWind = 0;
						  sumEnvironment=0;
						  sumSpeed=0;
						  sumCumulant=0;
					  }
					  count11 = 0;
					  if(!isFinish12)
					  {
						  sumWind += wind;
						  sumEnvironment += environment;
						  sumSpeed += speed;
						  sumCumulant += cumulant;
						  count12++;
					  }
					  break;
					  
				  case "13":
					  if(count12!= 0)
					  {
						  avgWind = sumWind / count12;
						  avgEnvironment = sumEnvironment / count12;
						  avgSpeed = sumSpeed / count12;
						  avgCumulant = sumCumulant / count12;
						  String sql0 = "update weathermodel set wind = '" + String.valueOf(avgWind) + 
								  "' where time='12:00' and date='" + date +"'";
						  String sql1 = "update weathermodel set environment = '" + String.valueOf(avgEnvironment) + 
								  "' where time='12:00' and date='" + date +"'";
						  String sql2 = "update weathermodel set speed = '" + String.valueOf(avgSpeed) + 
								  "' where time='12:00' and date='" + date +"'";
						  String sql3 = "update weathermodel set cumulant = '" + String.valueOf(sumCumulant) + 
								  "' where time='12:00' and date='" + date +"'";
						  System.out.println(sql0);
						  System.out.println(sql1);
						  System.out.println(sql2);
						  System.out.println(sql3);
						  statement = con.prepareStatement(sql0);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql1);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql2);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql3);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  sumWind = 0;
						  sumEnvironment=0;
						  sumSpeed=0;
						  sumCumulant=0;
					  }
					  count12 = 0;
					  if(!isFinish13)
					  {
						  sumWind += wind;
						  sumEnvironment += environment;
						  sumSpeed += speed;
						  sumCumulant += cumulant;
						  count13++;
					  }
					  break;
					  
				  case "14":
					  if(count13!= 0)
					  {
						  avgWind = sumWind / count13;
						  avgEnvironment = sumEnvironment / count13;
						  avgSpeed = sumSpeed / count13;
						  avgCumulant = sumCumulant / count13;
						  String sql0 = "update weathermodel set wind = '" + String.valueOf(avgWind) + 
								  "' where time='13:00' and date='" + date +"'";
						  String sql1 = "update weathermodel set environment = '" + String.valueOf(avgEnvironment) + 
								  "' where time='13:00' and date='" + date +"'";
						  String sql2 = "update weathermodel set speed = '" + String.valueOf(avgSpeed) + 
								  "' where time='13:00' and date='" + date +"'";
						  String sql3 = "update weathermodel set cumulant = '" + String.valueOf(sumCumulant) + 
								  "' where time='13:00' and date='" + date +"'";
						  System.out.println(sql0);
						  System.out.println(sql1);
						  System.out.println(sql2);
						  System.out.println(sql3);
						  statement = con.prepareStatement(sql0);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql1);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql2);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql3);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  sumWind = 0;
						  sumEnvironment=0;
						  sumSpeed=0;
						  sumCumulant=0;
					  }
					  count13 = 0;
					  if(!isFinish14)
					  {
						  sumWind += wind;
						  sumEnvironment += environment;
						  sumSpeed += speed;
						  sumCumulant += cumulant;
						  count14++;
					  }
					  break;
					  
				  case "15":
					  if(count14!= 0)
					  {
						  avgWind = sumWind / count14;
						  avgEnvironment = sumEnvironment / count14;
						  avgSpeed = sumSpeed / count14;
						  avgCumulant = sumCumulant / count14;
						  String sql0 = "update weathermodel set wind = '" + String.valueOf(avgWind) + 
								  "' where time='14:00' and date='" + date +"'";
						  String sql1 = "update weathermodel set environment = '" + String.valueOf(avgEnvironment) + 
								  "' where time='14:00' and date='" + date +"'";
						  String sql2 = "update weathermodel set speed = '" + String.valueOf(avgSpeed) + 
								  "' where time='14:00' and date='" + date +"'";
						  String sql3 = "update weathermodel set cumulant = '" + String.valueOf(sumCumulant) + 
								  "' where time='14:00' and date='" + date +"'";
						  System.out.println(sql0);
						  System.out.println(sql1);
						  System.out.println(sql2);
						  System.out.println(sql3);
						  statement = con.prepareStatement(sql0);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql1);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql2);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql3);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  sumWind = 0;
						  sumEnvironment=0;
						  sumSpeed=0;
						  sumCumulant=0;
					  }
					  count14 = 0;
					  if(!isFinish15)
					  {
						  sumWind += wind;
						  sumEnvironment += environment;
						  sumSpeed += speed;
						  sumCumulant += cumulant;
						  count15++;
					  }
					  break;
					  
				  case "16":
					  if(count15!= 0)
					  {
						  avgWind = sumWind / count15;
						  avgEnvironment = sumEnvironment / count15;
						  avgSpeed = sumSpeed / count15;
						  avgCumulant = sumCumulant / count15;
						  String sql0 = "update weathermodel set wind = '" + String.valueOf(avgWind) + 
								  "' where time='15:00' and date='" + date +"'";
						  String sql1 = "update weathermodel set environment = '" + String.valueOf(avgEnvironment) + 
								  "' where time='15:00' and date='" + date +"'";
						  String sql2 = "update weathermodel set speed = '" + String.valueOf(avgSpeed) + 
								  "' where time='15:00' and date='" + date +"'";
						  String sql3 = "update weathermodel set cumulant = '" + String.valueOf(sumCumulant) + 
								  "' where time='15:00' and date='" + date +"'";
						  System.out.println(sql0);
						  System.out.println(sql1);
						  System.out.println(sql2);
						  System.out.println(sql3);
						  statement = con.prepareStatement(sql0);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql1);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql2);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql3);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  sumWind = 0;
						  sumEnvironment=0;
						  sumSpeed=0;
						  sumCumulant=0;
					  }
					  count15 = 0;
					  if(!isFinish16)
					  {
						  sumWind += wind;
						  sumEnvironment += environment;
						  sumSpeed += speed;
						  sumCumulant += cumulant;
						  count16++;
					  }
					  break;
					  
				  case "17":
					  if(count16!= 0)
					  {
						  avgWind = sumWind / count16;
						  avgEnvironment = sumEnvironment / count16;
						  avgSpeed = sumSpeed / count16;
						  avgCumulant = sumCumulant / count16;
						  String sql0 = "update weathermodel set wind = '" + String.valueOf(avgWind) + 
								  "' where time='16:00' and date='" + date +"'";
						  String sql1 = "update weathermodel set environment = '" + String.valueOf(avgEnvironment) + 
								  "' where time='16:00' and date='" + date +"'";
						  String sql2 = "update weathermodel set speed = '" + String.valueOf(avgSpeed) + 
								  "' where time='16:00' and date='" + date +"'";
						  String sql3 = "update weathermodel set cumulant = '" + String.valueOf(sumCumulant) + 
								  "' where time='16:00' and date='" + date +"'";
						  System.out.println(sql0);
						  System.out.println(sql1);
						  System.out.println(sql2);
						  System.out.println(sql3);
						  statement = con.prepareStatement(sql0);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql1);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql2);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql3);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  sumWind = 0;
						  sumEnvironment=0;
						  sumSpeed=0;
						  sumCumulant=0;
					  }
					  count16 = 0;
					  if(!isFinish17)
					  {
						  sumWind += wind;
						  sumEnvironment += environment;
						  sumSpeed += speed;
						  sumCumulant += cumulant;
						  count17++;
					  }
					  break;
					  
				  case "18":
					  if(count17!= 0)
					  {
						  avgWind = sumWind / count17;
						  avgEnvironment = sumEnvironment / count17;
						  avgSpeed = sumSpeed / count17;
						  avgCumulant = sumCumulant / count17;
						  String sql0 = "update weathermodel set wind = '" + String.valueOf(avgWind) + 
								  "' where time='17:00' and date='" + date +"'";
						  String sql1 = "update weathermodel set environment = '" + String.valueOf(avgEnvironment) + 
								  "' where time='17:00' and date='" + date +"'";
						  String sql2 = "update weathermodel set speed = '" + String.valueOf(avgSpeed) + 
								  "' where time='17:00' and date='" + date +"'";
						  String sql3 = "update weathermodel set cumulant = '" + String.valueOf(sumCumulant) + 
								  "' where time='17:00' and date='" + date +"'";
						  System.out.println(sql0);
						  System.out.println(sql1);
						  System.out.println(sql2);
						  System.out.println(sql3);
						  statement = con.prepareStatement(sql0);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql1);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql2);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql3);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  sumWind = 0;
						  sumEnvironment=0;
						  sumSpeed=0;
						  sumCumulant=0;
					  }
					  count17 = 0;
					  if(!isFinish18)
					  {
						  sumWind += wind;
						  sumEnvironment += environment;
						  sumSpeed += speed;
						  sumCumulant += cumulant;
						  count18++;
					  }
					  break;
					  
				  case "19":
					  if(count18!= 0)
					  {
						  avgWind = sumWind / count18;
						  avgEnvironment = sumEnvironment / count18;
						  avgSpeed = sumSpeed / count18;
						  avgCumulant = sumCumulant / count18;
						  String sql0 = "update weathermodel set wind = '" + String.valueOf(avgWind) + 
								  "' where time='18:00' and date='" + date +"'";
						  String sql1 = "update weathermodel set environment = '" + String.valueOf(avgEnvironment) + 
								  "' where time='18:00' and date='" + date +"'";
						  String sql2 = "update weathermodel set speed = '" + String.valueOf(avgSpeed) + 
								  "' where time='18:00' and date='" + date +"'";
						  String sql3 = "update weathermodel set cumulant = '" + String.valueOf(sumCumulant) + 
								  "' where time='18:00' and date='" + date +"'";
						  System.out.println(sql0);
						  System.out.println(sql1);
						  System.out.println(sql2);
						  System.out.println(sql3);
						  statement = con.prepareStatement(sql0);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql1);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql2);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql3);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  sumWind = 0;
						  sumEnvironment=0;
						  sumSpeed=0;
						  sumCumulant=0;
					  }
					  count18 = 0;
					  if(!isFinish19)
					  {
						  sumWind += wind;
						  sumEnvironment += environment;
						  sumSpeed += speed;
						  sumCumulant += cumulant;
						  count19++;
					  }
					  break;
					  
				  case "20": 
					  if(count19!= 0)
					  {
						  avgWind = sumWind / count19;
						  avgEnvironment = sumEnvironment / count19;
						  avgSpeed = sumSpeed / count19;
						  avgCumulant = sumCumulant / count19;
						  String sql0 = "update weathermodel set wind = '" + String.valueOf(avgWind) + 
								  "' where time='19:00' and date='" + date +"'";
						  String sql1 = "update weathermodel set environment = '" + String.valueOf(avgEnvironment) + 
								  "' where time='19:00' and date='" + date +"'";
						  String sql2 = "update weathermodel set speed = '" + String.valueOf(avgSpeed) + 
								  "' where time='19:00' and date='" + date +"'";
						  String sql3 = "update weathermodel set cumulant = '" + String.valueOf(sumCumulant) + 
								  "' where time='19:00' and date='" + date +"'";
						  System.out.println(sql0);
						  System.out.println(sql1);
						  System.out.println(sql2);
						  System.out.println(sql3);
						  statement = con.prepareStatement(sql0);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql1);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql2);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql3);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  sumWind = 0;
						  sumEnvironment=0;
						  sumSpeed=0;
						  sumCumulant=0;
					  }
					  count19 = 0;
					  if(!isFinish20)
					  {
						  sumWind += wind;
						  sumEnvironment += environment;
						  sumSpeed += speed;
						  sumCumulant += cumulant;
						  count20++;
					  }
					  break;
					  
				  case "21":
					  if(count20!= 0)
					  {
						  avgWind = sumWind / count20;
						  avgEnvironment = sumEnvironment / count20;
						  avgSpeed = sumSpeed / count20;
						  avgCumulant = sumCumulant / count20;
						  String sql0 = "update weathermodel set wind = '" + String.valueOf(avgWind) + 
								  "' where time='20:00' and date='" + date +"'";
						  String sql1 = "update weathermodel set environment = '" + String.valueOf(avgEnvironment) + 
								  "' where time='20:00' and date='" + date +"'";
						  String sql2 = "update weathermodel set speed = '" + String.valueOf(avgSpeed) + 
								  "' where time='20:00' and date='" + date +"'";
						  String sql3 = "update weathermodel set cumulant = '" + String.valueOf(sumCumulant) + 
								  "' where time='20:00' and date='" + date +"'";
						  System.out.println(sql0);
						  System.out.println(sql1);
						  System.out.println(sql2);
						  System.out.println(sql3);
						  statement = con.prepareStatement(sql0);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql1);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql2);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql3);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  sumWind = 0;
						  sumEnvironment=0;
						  sumSpeed=0;
						  sumCumulant=0;
					  }
					  count20 = 0;
					  if(!isFinish21)
					  {
						  sumWind += wind;
						  sumEnvironment += environment;
						  sumSpeed += speed;
						  sumCumulant += cumulant;
						  count21++;
					  }
					  break;
					  
				  case "22":
					  if(count21!= 0)
					  {
						  avgWind = sumWind / count21;
						  avgEnvironment = sumEnvironment / count21;
						  avgSpeed = sumSpeed / count21;
						  avgCumulant = sumCumulant / count21;
						  String sql0 = "update weathermodel set wind = '" + String.valueOf(avgWind) + 
								  "' where time='21:00' and date='" + date +"'";
						  String sql1 = "update weathermodel set environment = '" + String.valueOf(avgEnvironment) + 
								  "' where time='21:00' and date='" + date +"'";
						  String sql2 = "update weathermodel set speed = '" + String.valueOf(avgSpeed) + 
								  "' where time='21:00' and date='" + date +"'";
						  String sql3 = "update weathermodel set cumulant = '" + String.valueOf(sumCumulant) + 
								  "' where time='21:00' and date='" + date +"'";
						  System.out.println(sql0);
						  System.out.println(sql1);
						  System.out.println(sql2);
						  System.out.println(sql3);
						  statement = con.prepareStatement(sql0);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql1);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql2);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql3);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  sumWind = 0;
						  sumEnvironment=0;
						  sumSpeed=0;
						  sumCumulant=0;
					  }
					  count21 = 0;
					  if(!isFinish22)
					  {
						  sumWind += wind;
						  sumEnvironment += environment;
						  sumSpeed += speed;
						  sumCumulant += cumulant;
						  count22++;
					  }
					  break;
					  
				  case "23":
					  if(count22!= 0)
					  {
						  avgWind = sumWind / count22;
						  avgEnvironment = sumEnvironment / count22;
						  avgSpeed = sumSpeed / count22;
						  avgCumulant = sumCumulant / count22;
						  String sql0 = "update weathermodel set wind = '" + String.valueOf(avgWind) + 
								  "' where time='22:00' and date='" + date +"'";
						  String sql1 = "update weathermodel set environment = '" + String.valueOf(avgEnvironment) + 
								  "' where time='22:00' and date='" + date +"'";
						  String sql2 = "update weathermodel set speed = '" + String.valueOf(avgSpeed) + 
								  "' where time='22:00' and date='" + date +"'";
						  String sql3 = "update weathermodel set cumulant = '" + String.valueOf(sumCumulant) + 
								  "' where time='22:00' and date='" + date +"'";
						  System.out.println(sql0);
						  System.out.println(sql1);
						  System.out.println(sql2);
						  System.out.println(sql3);
						  statement = con.prepareStatement(sql0);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql1);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql2);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  statement = con.prepareStatement(sql3);
						  System.out.println("estsaerasraw" + statement.executeUpdate());
						  sumWind = 0;
						  sumEnvironment=0;
						  sumSpeed=0;
						  sumCumulant=0;
					  }
					  count22 = 0;
					  if(!isFinish23)
					  {
						  sumWind += wind;
						  sumEnvironment += environment;
						  sumSpeed += speed;
						  sumCumulant += cumulant;
						  count23++;
					  }
					  break;
				}
						  
			} 
			System.out.println(rowCount);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally
		{
		}
	}
}
