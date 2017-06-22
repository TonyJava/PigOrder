package daoimpl;

import dao.Price;
import po.Frequency;

public class HighSpeedRail implements Price {

	@Override
	public double getPrice(Frequency f) {
		double price=0;
		// TODO Auto-generated method stub
		Double km=f.getKilometers();
		if(km>0&&km<=200)
			price=km*0.05861*1.5;
		else if(km>200&&km<=500){
			price=(0.05861*0.9*1.5*(km-200)+200*0.05861*1.5);
		}else if(km>500&&km<=1000){
			price=(200*0.05861+300*0.9*1.5*0.05681+0.8*1.5*0.05681*(km-500));
		}else if(km>1000){
			price=(200*0.05861+300*0.9*1.5*0.05681+0.8*1.5*0.05681*500+0.6*1.5*0.05681*(km-1000));
		}
		return price;
	}

}
