package gui;
public class Calculations {
    public static final String[] SPORT_NAMES = {
        "เดินเร็ว", "วิ่ง (8 กม./ชม.)", "ปั่นจักรยาน", "ว่ายน้ำ",
        "เต้นแอโรบิก", "ยกน้ำหนัก", "โยคะ", "HIIT", "กระโดดเชือก", "แบดมินตัน"};
    public static final double[] SPORT_MET = {3.8, 8.3, 7.5, 6.0, 6.5, 5.0, 2.5, 8.0, 11.0, 5.5};

    // ค่าโซนหัวใจ (สัดส่วนของ HRR) ต้องมีจำนวนเท่ากันทั้ง 3 array
    public static final String[] HEART_ZONE_NAMES = {
        "โซน 1 (ฟื้นฟู)", "โซน 2 (เผาผลาญไขมัน)", "โซน 3 (แอโรบิก)",
        "โซน 4 (เกณฑ์ความทนทาน)", "โซน 5 (สูงสุด)"};
    public static final double[] HEART_ZONE_LO = {0.50, 0.60, 0.70, 0.80, 0.90};
    public static final double[] HEART_ZONE_HI = {0.60, 0.70, 0.80, 0.90, 1.00};

    public static double bmi(double w, double h) {
        double hm = h / 100.0;
        return w / (hm * hm);}

    public static double bmr(double w, double h, double a, boolean male) {
        double sexConstant;
        if (male) {sexConstant = 5;} 
        else { sexConstant = -161; }
        return 10 * w + 6.25 * h - 5 * a + sexConstant;}

    public static double tdee(double bmr, int activityIndex) {
        double[] mul = {1.2, 1.375, 1.55, 1.725, 1.9};
        return bmr * mul[activityIndex];}

    public static String bmiCategory(double bmi) {
        if (bmi < 18.5) return "น้ำหนักต่ำกว่าเกณฑ์";
        if (bmi < 23)   return "สมส่วน (ปกติ)";
        if (bmi < 25)   return "น้ำหนักเกิน";
        if (bmi < 30)   return "โรคอ้วนระดับ 1";
        return "โรคอ้วนระดับ 2"; }

    public static double kcalBurned(int sportIndex, double weight, double minutes) { 
        return SPORT_MET[sportIndex] * weight * (minutes / 60.0);}

    public static double[][] heartZones(double age, double restHR) {
        double max = 220 - age;
        double reserve = max - restHR;
        double[][] zones = new double[HEART_ZONE_LO.length][2];
        for (int i = 0; i < HEART_ZONE_LO.length; i++) {
            zones[i][0] = restHR + HEART_ZONE_LO[i] * reserve;
            zones[i][1] = restHR + HEART_ZONE_HI[i] * reserve;}
        return zones; }}