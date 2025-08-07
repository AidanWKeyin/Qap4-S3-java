package entities;

public class Drug {
    private int drugId;
    private String drugName;
    private double drugCost;
    private String dosage;

    public Drug(int id, String name, int dosage, float price) {

        this.drugId = id;
        this.drugName = name;
        this.drugCost = price;
        this.dosage = dosage + "mg";
    }

    @Override
    public String toString() {
        return drugId + "," + drugName + "," + drugCost + "," + dosage;
    }

    public static Drug fromString(String line) {
        String[] parts = line.split(",");
        if (parts.length != 4) {
            throw new IllegalArgumentException("Invalid drug data format");
        }
        
        return new Drug(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[3].replace("mg", "")), Float.parseFloat(parts[2]));
    }
}

