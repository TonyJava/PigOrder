package Factory;

import daoimpl.CarPrice;
import daoimpl.HighSpeedRail;
import daoimpl.NormalTrainPrice;
import daoimpl.PlanePrice;
import po.Frequency;

public class PriceFactory {
	
		public static Double getPrice(Frequency f){
			int type=f.getLevel();
			if(type==1){
				return new NormalTrainPrice().getPrice(f);
			}else if(type==2){
					return new CarPrice().getPrice(f);
				
			}else if(type==3){
				return new HighSpeedRail().getPrice(f);
			}else if(type==4){
				return new PlanePrice().getPrice(f);
			}
			return null;
		}

}
