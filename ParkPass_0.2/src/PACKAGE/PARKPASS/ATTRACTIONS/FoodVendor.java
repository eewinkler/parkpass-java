package PACKAGE.PARKPASS.ATTRACTIONS;

import java.util.ArrayList; 

//import PACKAGE.PARKPASS.PEOPLE.Custodian;
//import PACKAGE.PARKPASS.PEOPLE.FoodService;
 
public abstract class FoodVendor extends Attraction {
 
//    private ArrayList<FoodService> workingVendor;
//    private ArrayList<Custodian> workingCustodians;
    private ArrayList<String> menu;
    private String FoodSupply;
    private String DrinkSupply;
    
    public FoodVendor() {
//    	workingVendor = new ArrayList<FoodService>();
//    	workingCustodians = new ArrayList<Custodian>();
    	menu = new ArrayList<String>();
    	FoodSupply = "Empty";
    	DrinkSupply = "Empty";
    }
    
    public void setFoodSupply(String food) {
    	FoodSupply = food;
    }
    
    public String getFoodSupply() {
    	return FoodSupply;
    }
 
    public void setWaterSupply(String water) {
    	DrinkSupply = water;
    }
    
    public String getWaterSupply() {
    	return DrinkSupply;
    }
    
//    public void addVendor(FoodService food) {
//    	workingVendor.add(food);
//    }
//    
//    public void removeStaff(FoodService food) {
//    	if (isInVendor(food) == true) {
//    		workingVendor.remove(food);
//    	}
//    }
//    
//    public ArrayList<FoodService> getVendors() {
//    	return workingVendor;
//    }
//    
//    public boolean isInVendor(FoodService food) {
//		for (int i = 0; i < workingVendor.size(); i++) {
//			if (workingVendor.get(i) == food) {
//				return true;
//			}
//		}
//    	return false;
//    }
//    
//    public void addCustodians(Custodian cust) {
//    	workingCustodians.add(cust);
//    }
//    
//    public void removeCustodian(Custodian cust) {
//    	if (isInCustodian(cust) == true) {
//    		workingCustodians.remove(cust);
//    	}
//    }
//    
//    public ArrayList<Custodian> getCustodian() {
//    	return workingCustodians;
//    }
//    
//    public boolean isInCustodian(Custodian cust) {
//		for (int i = 0; i < workingCustodians.size(); i++) {
//			if (workingCustodians.get(i) == cust) {
//				return true;
//			}
//		}
//    	return false;
//    }
//    
    public void addMenuItem(String item) {
    	menu.add(item);
    }
    
    public void removeStaff(String item) {
    	if (isInMenu(item) == true) {
    		menu.remove(item);
    	}
    }
    
    public ArrayList<String> getStaff() {
    	return menu;
    }
    
    public boolean isInMenu(String item) {
		for (int i = 0; i < menu.size(); i++) {
			if (menu.get(i) == item) {
				return true;
			}
		}
    	return false;
    }
    
    
    
}
 
 
