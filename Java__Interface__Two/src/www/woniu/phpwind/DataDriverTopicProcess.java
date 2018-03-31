package www.woniu.phpwind;

public class DataDriverTopicProcess {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		DataDriverTopicProcess ddtp= new DataDriverTopicProcess();
		//ddtp.dataDriverTopicAdd__ByOneUserToRandomSchool__One();
		//ddtp.dataDriverTopicAdd__RandomUserToRandomSchool__One();
		//ddtp.dataDriverTopicAdd__ByOneUserToRandomSchool__Two();
		ddtp.dataDriverTopicAdd__RandomUserToRandomSchool__Two();
	}
	
	//参数__贴__新增__固定用户对随机学校进行发帖
	private void dataDriverTopicAdd__ByOneUserToRandomSchool__One() throws Exception{
		// TODO Auto-generated method stub
		for(int i=0; i<10; i++) {
			new DriverTopicProcess().driverTopicAdd__ByOneUserToRandomSchool__One();
		}

	}
	//参数__贴__新增__固定用户对随机学校进行发帖
		private void dataDriverTopicAdd__ByOneUserToRandomSchool__Two() throws Exception{
			// TODO Auto-generated method stub
			for(int i=0; i<10; i++) {
				new DriverTopicProcess().driverTopicAdd__ByOneUserToRandomSchool__two();
			}

		}
	
	//参数__贴__新增__随机用户对随机学校进行发帖
	private void dataDriverTopicAdd__RandomUserToRandomSchool__One() throws Exception{
		// TODO Auto-generated method stub
		//随机的用户获取
		for(int i=0; i<10; i++) {
			new DriverTopicProcess().driverTopicAdd__ByRandomUserToRandomSchool__One();
		}

	}
	
	//参数__贴__新增__随机用户对随机学校进行发帖
		private void dataDriverTopicAdd__RandomUserToRandomSchool__Two() throws Exception{
			// TODO Auto-generated method stub
			//随机的用户获取
			for(int i=0; i<10; i++) {
				new DriverTopicProcess().driverTopicAdd__ByRandomUserToRandomSchool__Two();
			}

		}

}
