package daoimpl;

import dao.Price;
import po.Frequency;

public class CarPrice implements Price {

	@Override
	public double getPrice(Frequency f) {
		double price=0;
		// TODO Auto-generated method stub
		Double km=f.getKilometers();
		if(km>0&&km<=200)
			price=km*0.05861*1.2;
		else if(km>200&&km<=500){
			price=(0.05861*1.2*0.9*(km-200)+200*0.05861*1.2);
		}
		return price;
	}

}
