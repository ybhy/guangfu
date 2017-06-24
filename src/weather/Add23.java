//23点各数据相加
package weather;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Add23 {
	private String classString = "com.mysql.jdbc.Driver";
	private String username = "root";
	private String password = "123456";
	private String url = "jdbc:mysql://localhost:3306/weather?useSSL=false";
	private Connection con = null;
	private PreparedStatement  statement=null;
	public Add23() {
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
			double[] sumWind = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
			double[] sumEnvironment = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
			double[] sumSpeed = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
			double[] sumCumulant = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
			double avgWind = 0.0;
			double avgEnvironment = 0.0;
			double avgSpeed = 0.0;
			double avgCumulant = 0.0;
			String currentDate = "";
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
				  isFinish23 = true;
				  if(count23!= 0 && isFinish23)
				  {
					  System.out.println("sumWind : " + sumWind[23] + " count23 : " + count23);
					  avgWind = sumWind[23] / count23;
					  avgEnvironment = sumEnvironment[23] / count23;
					  avgSpeed = sumSpeed[23] / count23;
					  avgCumulant = sumCumulant[23];
					  String sql0 = "update weathermodel set wind = '" + String.valueOf(avgWind) + 
							  "' where time='23:00' and date='" + currentDate +"';";
					  String sql1 = "update weathermodel set environment = '" + String.valueOf(avgEnvironment) + 
							  "' where time='23:00' and date='" + currentDate +"';";
					  String sql2 = "update weathermodel set speed = '" + String.valueOf(avgSpeed) + 
							  "' where time='23:00' and date='" + currentDate +"';";
					  String sql3 = "update weathermodel set cumulant = '" + String.valueOf(avgCumulant) + 
							  "' where time='23:00' and date='" + currentDate +"';";
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
					  
				  }
				  
				  sumWind[23] = 0.0;
				  sumEnvironment[23] = 0.0;
				  sumSpeed[23] = 0.0;
				  sumCumulant[23] = 0.0;
				  count23 = 0;
				  
				  isFinish0 = false;
				  if(!isFinish0)
				  {
					  sumWind[0] += wind;
					  sumEnvironment[0] += environment;
					  sumSpeed[0] += speed;
					  sumCumulant[0] += cumulant;
					  count0++;
				  }
				  break;
			  case "1":
				  isFinish0 = true;
				  if(count0!= 0 && isFinish0)
				  {
					  System.out.println("sumWind : " + sumWind[0] + " count0 : " + count23);
					  avgWind = sumWind[0] / count0;
					  avgEnvironment = sumEnvironment[0] / count0;
					  avgSpeed = sumSpeed[0] / count0;
					  avgCumulant = sumCumulant[0];
					  String sql0 = "update weathermodel set wind = '" + String.valueOf(avgWind) + 
							  "' where time='0:00' and date='" + date +"';";
					  String sql1 = "update weathermodel set environment = '" + String.valueOf(avgEnvironment) + 
							  "' where time='0:00' and date='" + date +"';";
					  String sql2 = "update weathermodel set speed = '" + String.valueOf(avgSpeed) + 
							  "' where time='0:00' and date='" + date +"';";
					  String sql3 = "update weathermodel set cumulant = '" + String.valueOf(avgCumulant) + 
							  "' where time='0:00' and date='" + date +"';";
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
					  
				  }
				  
				  sumWind[0] = 0.0;
				  sumEnvironment[0] = 0.0;
				  sumSpeed[0] = 0.0;
				  sumCumulant[0] = 0.0;
				  count0 = 0;
				  
				  isFinish1 = false;
				  if(!isFinish1)
				  {
					  sumWind[1] += wind;
					  sumEnvironment[1] += environment;
					  sumSpeed[1] += speed;
					  sumCumulant[1] += cumulant;
					  count1++;
				  }
				  break;
			  case "2":
				  isFinish1 = true;
				  if(count1!= 0 && isFinish1)
				  {
					  System.out.println("sumWind : " + sumWind[1] + " count1 : " + count1);
					  avgWind = sumWind[1] / count1;
					  avgEnvironment = sumEnvironment[1] / count1;
					  avgSpeed = sumSpeed[1] / count1;
					  avgCumulant = sumCumulant[1];
					  String sql0 = "update weathermodel set wind = '" + String.valueOf(avgWind) + 
							  "' where time='1:00' and date='" + date +"';";
					  String sql1 = "update weathermodel set environment = '" + String.valueOf(avgEnvironment) + 
							  "' where time='1:00' and date='" + date +"';";
					  String sql2 = "update weathermodel set speed = '" + String.valueOf(avgSpeed) + 
							  "' where time='1:00' and date='" + date +"';";
					  String sql3 = "update weathermodel set cumulant = '" + String.valueOf(avgCumulant) + 
							  "' where time='1:00' and date='" + date +"';";
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
					  
				  }
				  
				  sumWind[1] = 0;
				  sumEnvironment[1] = 0;
				  sumSpeed[1] = 0;
				  sumCumulant[1] = 0;
				  count1 = 0;
				  
				  isFinish2 = false;
				  if(!isFinish2)
				  {
					  sumWind[2] += wind;
					  sumEnvironment[2] += environment;
					  sumSpeed[2] += speed;
					  sumCumulant[2] += cumulant;
					  count2++;
				  }
				  break;
			  case "23":
				  isFinish23 = false;
				  if(!isFinish23)
				  {
					  sumWind[23] += wind;
					  sumEnvironment[23] += environment;
					  sumSpeed[23] += speed;
					  sumCumulant[23] += cumulant;
					  count23++;
				  }
				  currentDate = date;
				  break;
					 
				}
//			  System.out.println(rowCount);
			  }
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally
		{
		}
	}
}