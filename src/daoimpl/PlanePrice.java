package daoimpl;

import dao.Price;
import po.Frequency;

public class PlanePrice implements Price {

	@Override
	public double getPrice(Frequency f) {
		double price=0;
		double km=f.getKilometers();
		if(km>0&&km<=200){
			price=km+50;
		}else if(km>200&km<=800){
			price=km*0.85+130;
		}else if(km>800){
			price=800*0.85+200;
		}
		return price;
	}

}
