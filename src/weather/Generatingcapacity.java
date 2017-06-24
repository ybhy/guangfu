package weather;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Generatingcapacity {
	private String classString = "com.mysql.jdbc.Driver";
	private String username = "root";
	private String password = "123456";
	private String url = "jdbc:mysql://localhost:3306/weather?useSSL=false";
	private Connection con = null;
	private PreparedStatement statement = null;
	
	public Generatingcapacity() {
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
	
	public void process()
	{
		String sql = "SELECT * FROM weather.ddddd;";
		try{
			statement = con.prepareStatement(sql);
			ResultSet rset = statement.executeQuery();
			double[][] para = { {-473.9516, -0.9090, 21.6581, 12.3302, 1.9973},
					{-374.6653, -0.6780, 17.5334, 11.8666, 1.5389},
					{-797.9722, -1.4464, 36.9202, -2.0414, 3.4532},
					{-94.4907, -0.4802, 4.8052, -35.6489, 1.1354},
					{-181.5931, -0.3663, 6.8433, 10.6693, 0.9591},
					{-308.1057, -1.2549, 18.3306, -12.8789, 1.9734},
					{-213.9054, -0.6925, 11.6969, -7.8268, 1.4144}};
			String currentDate = "2015-9-1";
			System.out.print(currentDate + " ");
			double sum = 0.0;
			while(rset.next()){
				String tempDate = rset.getString(2);
				Double[] properties = new Double[5];
				properties[0] = 1.0;
				for(int i = 4; i < 8; i++){
					properties[i - 4 + 1] = rset.getDouble(i);
				}
				if(currentDate.equals(tempDate)){
					for(int i = 0; i < para.length; i++){
						for(int j = 0; j < para[0].length; j++){
							sum += para[i][j] * properties[j];
						}
					}
				}else{
					System.out.println("sum " + sum);
					System.out.print(rset.getString(2) + " ");
					currentDate = tempDate;
					sum = 0;
					for(int i = 0; i < para.length; i++){
						for(int j = 0; j < para[0].length; j++){
							sum += para[i][j] * properties[j];
						}
					}
				}
			}
			System.out.println("sum " + sum);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally
		{
		}
	}
	
	public static void main(String[] args){
		Generatingcapacity gc = new Generatingcapacity();
		gc.process();
		gc.close();
	}
}