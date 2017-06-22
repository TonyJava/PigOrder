package daoimpl;

import dao.Price;
import po.Frequency;

public class NormalTrainPrice implements Price {

	@Override
	public double getPrice(Frequency f) {
		double price=0;
		// TODO Auto-generated method stub
		Double km=f.getKilometers();
		if(km>0&&km<=200)
			price=km*0.05861;
		else if(km>200&&km<=500){
			price=(0.05861*0.9*(km-200)+200*0.05861);
		}else if(km>500){
			price=(200*0.05861+300*0.9*0.05681+0.8*0.05681*(km-500));
		}
		return price;
	}

}
