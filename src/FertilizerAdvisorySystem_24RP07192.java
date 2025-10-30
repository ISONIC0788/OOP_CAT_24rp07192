/**
 * Main class for the Fertilizer Advisory System with registration number 24RP07192.
 * Handles soil sample processing, reports, and fertilizer recommendations.
 */
public class FertilizerAdvisorySystem_24RP07192 {

    /**
     * Processes an array of SoilAnalysis objects, generates reports, and handles exceptions.
     */
    public static void processSamples(SoilAnalysis[] samples) {
        int balancedCount = 0;
        int deficientCount = 0;
        int totalValidSamples = 0;

        System.out.println("\n=======================================================");
        System.out.println("            IHINDUKA CONNECT - ADVISORY REPORT");
        System.out.println("=======================================================");

        for (SoilAnalysis sample : samples) {
            try {
                // Validate nutrient levels (positive values only)
                if (sample.getNitrogenLevel() <= 0 || sample.getPhosphorusLevel() <= 0 || sample.getPotassiumLevel() <= 0) {
                    throw new IllegalArgumentException("Invalid nutrient reading: One or more levels are non-positive.");
                }

                // Calculate fertilizer recommendations
                String nitrogenRec = sample.calculateFertilizerNeeded("Nitrogen");
                String phosphorusRec = sample.calculateFertilizerNeeded("Phosphorus");
                String potassiumRec = sample.calculateFertilizerNeeded("Potassium");

                // Print farmer information and recommendations
                System.out.println("\n--- Valid Sample Processed ---");
                System.out.println("Farmer ID: " + sample.getFarmerId());
                System.out.println("District: " + sample.getDistrictName());
                System.out.println("Crop Type: " + sample.getCropType());
                System.out.println("  Nitrogen Recommendation: " + nitrogenRec);
                System.out.println("  Phosphorus Recommendation: " + phosphorusRec);
                System.out.println("  Potassium Recommendation: " + potassiumRec);

                // Update counts
                if (sample.isBalanced()) {
                    balancedCount++;
                } else if (nitrogenRec.contains("DEFICIENT") || phosphorusRec.contains("DEFICIENT") || potassiumRec.contains("DEFICIENT")) {
                    deficientCount++;
                }
                totalValidSamples++;

            } catch (IllegalArgumentException e) {
                System.err.println("\n!!! ERROR Processing Sample for Farmer ID: " + sample.getFarmerId() + " !!!");
//                System.err.println("  Reason: " + e.getMessage());
//                System.err.println("  Action: Error printed. Continuing to next sample.");
            }
        }

        System.out.println("\n=======================================================");
        System.out.println("ADVISORY SUMMARY (from " + totalValidSamples + " valid samples):");
        System.out.println("  Total Balanced Samples: " + balancedCount);
        System.out.println("  Total Deficient Samples: " + deficientCount);
        System.out.println("=======================================================");
    }

    public static void main(String[] args) {
        SoilAnalysis[] testSamples = {
            new SoilAnalysis("F001", "Kirehe", 50.0, 75.0, 99.0, "Maize"),
            new SoilAnalysis("F002", "Bugesera", 60.0, 15.0, 80.0, "Rice"),
            new SoilAnalysis("F003", "Nyagatare", 110.0, 50.0, 30.0, "Beans"),
            new SoilAnalysis("F004_ERROR", "Rwamagana", 45.0, 70.0, -5.0, "Sorghum"),
            new SoilAnalysis("F005", "Musanze", 10.0, 12.0, 18.0, "Irish Potatoes"),
            new SoilAnalysis("F006", "Huye", 150.0, 120.0, 105.0, "Coffee")
        };

        processSamples(testSamples);
    }
}
