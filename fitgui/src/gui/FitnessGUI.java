package gui;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
public final class FitnessGUI extends javax.swing.JFrame {

    public FitnessGUI() {
        initComponents();
        setupWorkoutTab(); }
    
    private final List<DayPlan> plans = new ArrayList<>();
    private List<String[]> currentRows;
        // ===================== แท็บ 4: ตารางออกกำลังกาย =====================
   static class DayPlan {
        String day;
        List<String[]> rows = new ArrayList<>();   // {ท่า, จำนวน, พัก, กล้ามเนื้อ, วิธีทำ}
        DayPlan(String day) { this.day = day; }
        DayPlan add(String name, String sets, String rest, String muscle, String how) {
            rows.add(new String[]{name, sets, rest, muscle, how});
            return this;}}



        private void buildPlans() {
            plans.add(new DayPlan("จันทร์ : อก + ไตรเซ็ป")
                .add("วิดพื้น", "3 x 12 ครั้ง", "60 วิ", "อก, ไหล่, ไตรเซ็ป",
                     "มือกว้างกว่าไหล่เล็กน้อย ลำตัวตรง ลดตัวลงจนอกเกือบถึงพื้น แล้วดันกลับ")
                .add("วิดพื้นเอียง", "3 x 10 ครั้ง", "60 วิ", "อกส่วนล่าง",
                     "วางมือบนเก้าอี้หรือขั้นบันได ลำตัวเป็นเส้นตรง")
                .add("ดิปส์ด้วยเก้าอี้", "3 x 10 ครั้ง", "60 วิ", "ไตรเซ็ป",
                     "มือเกาะขอบเก้าอี้ด้านหลัง งอศอกลง 90 องศา แล้วดันขึ้น")
                .add("วิดพื้นมือชิด", "3 x 8 ครั้ง", "60 วิ", "ไตรเซ็ป, อกด้านใน",
                     "มือทำเป็นรูปเพชรใต้อก ศอกแนบลำตัว")
                .add("แพลงก์", "3 x 30 วิ", "45 วิ", "แกนกลางลำตัว",
                     "ศอกอยู่ใต้ไหล่ ลำตัวเป็นเส้นตรง เกร็งหน้าท้องและก้น"));

            plans.add(new DayPlan("อังคาร : ขา + ก้น")
                .add("สควอท", "4 x 15 ครั้ง", "60 วิ", "ต้นขา, ก้น",
                     "ยืนกว้างเท่าไหล่ ย่อตัวให้ต้นขาขนานพื้น เข่าไม่เลยปลายเท้า")
                .add("ลันจ์", "3 x 12 ครั้ง/ข้าง", "60 วิ", "ต้นขา, ก้น",
                     "ก้าวขาไปข้างหน้า ย่อจนเข่าหลังเกือบแตะพื้น แล้วดันกลับ")
                .add("กลูทบริดจ์", "3 x 15 ครั้ง", "45 วิ", "ก้น, หลังส่วนล่าง",
                     "นอนหงายชันเข่า ยกสะโพกขึ้นจนลำตัวเป็นเส้นตรง บีบก้นค้างไว้ 1 วิ")
                .add("ยกส้นเท้า", "3 x 20 ครั้ง", "30 วิ", "น่อง",
                     "ยืนเขย่งปลายเท้าขึ้นให้สุด แล้วลดลงช้าๆ")
                .add("นั่งพิงกำแพง", "3 x 30 วิ", "45 วิ", "ต้นขาด้านหน้า",
                     "พิงหลังกับกำแพง ย่อเข่า 90 องศา ค้างไว้"));

            plans.add(new DayPlan("พุธ : คาร์ดิโอ")
                .add("กระโดดตบ", "3 x 45 วิ", "30 วิ", "ทั้งตัว",
                     "กระโดดพร้อมกางแขนขาออก แล้วหุบกลับ")
                .add("ยกเข่าสูง", "3 x 30 วิ", "30 วิ", "ขา, หัวใจ",
                     "วิ่งอยู่กับที่ ยกเข่าให้สูงระดับสะโพก")
                .add("เบอร์พี", "3 x 10 ครั้ง", "60 วิ", "ทั้งตัว",
                     "ย่อลงวิดพื้น 1 ครั้ง แล้วกระโดดขึ้นพร้อมยกมือเหนือหัว")
                .add("ปีนเขา", "3 x 30 วิ", "30 วิ", "แกนกลาง, ไหล่",
                     "ท่าวิดพื้น สลับดึงเข่าเข้าหาอกอย่างเร็ว")
                .add("วิ่งเหยาะๆ", "20 นาที", "-", "หัวใจ, ขา",
                     "วิ่งในความเร็วที่ยังพูดคุยได้"));

            plans.add(new DayPlan("พฤหัสบดี : หลัง + ไบเซ็ป")
                .add("ซูเปอร์แมน", "3 x 12 ครั้ง", "45 วิ", "หลังส่วนล่าง",
                     "นอนคว่ำ ยกแขนและขาขึ้นพร้อมกัน ค้าง 2 วิ")
                .add("ดัมเบลโรว์", "3 x 12 ครั้ง/ข้าง", "60 วิ", "หลังส่วนบน, ไบเซ็ป",
                     "โน้มตัว ดึงดัมเบล/ขวดน้ำเข้าหาเอว บีบสะบัก")
                .add("ไบเซ็ปเคิร์ล", "3 x 12 ครั้ง", "45 วิ", "ไบเซ็ป",
                     "ศอกแนบลำตัว งอข้อศอกยกขึ้น แล้วลดลงช้าๆ")
                .add("เบิร์ดด็อก", "3 x 10 ครั้ง/ข้าง", "30 วิ", "หลัง, แกนกลาง",
                     "คลานสี่ขา ยกแขนขวากับขาซ้ายพร้อมกัน สลับข้าง")
                .add("ยืดเหยียดหลัง", "2 x 30 วิ", "-", "หลัง",
                     "นั่งทับส้นเท้า ก้มตัวและเหยียดแขนไปข้างหน้า"));

            plans.add(new DayPlan("ศุกร์ : ไหล่ + หน้าท้อง")
                .add("ไพค์พุชอัพ", "3 x 10 ครั้ง", "60 วิ", "ไหล่",
                     "ตั้งสะโพกสูงเป็นรูปตัว V งอศอกให้หัวลงไปหาพื้น")
                .add("ยกแขนด้านข้าง", "3 x 12 ครั้ง", "45 วิ", "ไหล่",
                     "ถือน้ำหนัก ยกแขนออกข้างระดับไหล่ แล้วลดลงช้าๆ")
                .add("ครันช์", "3 x 20 ครั้ง", "30 วิ", "หน้าท้อง",
                     "นอนหงายชันเข่า ยกไหล่ขึ้นเล็กน้อย เกร็งหน้าท้อง")
                .add("ยกขา", "3 x 12 ครั้ง", "45 วิ", "หน้าท้องส่วนล่าง",
                     "นอนหงาย ยกขาตรงขึ้น 90 องศา แล้วลดลงไม่แตะพื้น")
                .add("รัสเซียนทวิสต์", "3 x 20 ครั้ง", "30 วิ", "หน้าท้องด้านข้าง",
                     "นั่งเอนตัว บิดลำตัวสลับซ้าย-ขวา"));

            plans.add(new DayPlan("เสาร์ : HIIT ทั้งตัว")
                .add("สควอทกระโดด", "4 รอบ x 40 วิ", "20 วิ", "ขา, ก้น",
                     "ย่อตัวแล้วกระโดดขึ้นสุดแรง ลงนุ่มนวล")
                .add("วิดพื้น", "4 รอบ x 40 วิ", "20 วิ", "อก, แขน",
                     "ทำให้ได้มากที่สุดในเวลาที่กำหนด")
                .add("เบอร์พี", "4 รอบ x 40 วิ", "20 วิ", "ทั้งตัว",
                     "ทำต่อเนื่องไม่หยุด")
                .add("ปีนเขา", "4 รอบ x 40 วิ", "20 วิ", "แกนกลาง",
                     "ท่าวิดพื้น สลับเข่าเร็วๆ")
                .add("แพลงก์", "4 รอบ x 40 วิ", "20 วิ", "แกนกลาง",
                     "ลำตัวตรง เกร็งหน้าท้อง"));

            plans.add(new DayPlan("อาทิตย์ : พักผ่อน / ยืดเหยียด")
                .add("เดินเล่น", "20-30 นาที", "-", "ทั้งตัว",
                     "เดินสบายๆ ผ่อนคลายกล้ามเนื้อ")
                .add("แคท-คาว", "2 x 10 ครั้ง", "-", "กระดูกสันหลัง",
                     "คลานสี่ขา สลับแอ่นหลังและโค้งหลัง")
                .add("ยืดเหยียดต้นขาหลัง", "2 x 30 วิ/ข้าง", "-", "ต้นขาด้านหลัง",
                     "นั่งเหยียดขาข้างเดียว โน้มตัวไปแตะปลายเท้า")
                .add("ยืดสะโพก", "2 x 30 วิ/ข้าง", "-", "สะโพก",
                     "ก้าวขาไปข้างหน้าในท่าลันจ์ ดันสะโพกลง")
                .add("นอนหายใจลึกๆ", "5 นาที", "-", "จิตใจ",
                     "นอนหงาย หายใจเข้า-ออกช้าๆ ผ่อนคลายทั้งตัว"));}

       
    private void setupWorkoutTab() {
        buildPlans();

        // รายการวัน
        DefaultListModel<String> lm = new DefaultListModel<>();
        for (DayPlan p : plans) lm.addElement(p.day);
        jList1.setModel(lm);
        jList1.setFixedCellHeight(40);
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        // ตาราง
        jTable1.setRowHeight(32);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        // ช่องวิธีทำ
        txtHow.setEnabled(true);
        txtHow.setEditable(false);
        txtHow.setLineWrap(true);
        txtHow.setWrapStyleWord(true);

        // เมื่อเลือกวัน ให้ตารางเปลี่ยนตาม
        jList1.addListSelectionListener(e -> { if (!e.getValueIsAdjusting()) 
            showDay(jList1.getSelectedIndex()); });

        // เมื่อเลือกท่า ให้แสดงวิธีทำ
        jTable1.getSelectionModel().addListSelectionListener(e -> {
            if (e.getValueIsAdjusting()) return;
            int r = jTable1.getSelectedRow();
            if (r >= 0 && currentRows != null && r < currentRows.size()) {
                String[] ex = currentRows.get(r);
                txtHow.setText(ex[0] + "\n" + ex[4]);
                txtHow.setCaretPosition(0);} 
            else {txtHow.setText(""); }});

        jList1.setSelectedIndex(0); }

    private void showDay(int idx) {
        if (idx < 0) return;
        currentRows = plans.get(idx).rows;
        DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
        tm.setRowCount(0);
        for (String[] r : currentRows) { tm.addRow(new Object[]{r[0], r[1], r[2], r[3]});}
        txtHow.setText("");
        if (!currentRows.isEmpty()) {jTable1.setRowSelectionInterval(0, 0);}}
    // ===================== ตรวจสอบตัวเลขจากช่องกรอก =====================
    private double readNumber(javax.swing.JTextField f, String name, double min, double max) {
        String text = f.getText().trim();
        if (text.isEmpty()) {
            f.requestFocusInWindow();
            throw new IllegalArgumentException("Please fill in \"" + name + "\""); }
        if (!text.matches("\\d+(\\.\\d+)?")) {
            f.requestFocusInWindow();
            f.selectAll();
            throw new IllegalArgumentException("\"" + name + "\" must be a number.");}
        double v = Double.parseDouble(text);
        if (v < min) {
            f.requestFocusInWindow();
            f.selectAll();
            throw new IllegalArgumentException(String.format("\"%s\" Too low (must not be less than %.0f)", name, min)); }
        if (v > max) {
            f.requestFocusInWindow();
            f.selectAll();
            throw new IllegalArgumentException(String.format( "\"%s\" Too high (must not exceed %.0f)", name, max));}
        return v;}
    @SuppressWarnings("unchecked")
    //แค่สร้างหน้าจอ 177-808
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblW = new javax.swing.JLabel();
        lblH = new javax.swing.JLabel();
        lblA = new javax.swing.JLabel();
        lblG = new javax.swing.JLabel();
        lblAct = new javax.swing.JLabel();
        txtWeight = new javax.swing.JTextField();
        txtHeight = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        cmbGender = new javax.swing.JComboBox<>();
        cmbActivity = new javax.swing.JComboBox<>();
        btnCalc = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        lblResult = new javax.swing.JTextArea();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtAgeHR = new javax.swing.JTextField();
        txtRestHR = new javax.swing.JTextField();
        btnHeart = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        lblHeartResult = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        txtWeight2 = new javax.swing.JTextField();
        txtMinutes = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbSport = new javax.swing.JComboBox<>();
        btnBurn = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lblBurnResult = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtHow = new javax.swing.JTextArea();

        jMenu1.setText("jMenu1");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel7.setText("jLabel7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FitnessPlanner");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Fitness Planner");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ข้อมูลร่างกาย", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblW.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblW.setText("น้ำหนัก (กก.)");

        lblH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblH.setText("ส่วนสูง (ซม.)");

        lblA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblA.setText("อายุ (ปี)");

        lblG.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblG.setText("เพศ");

        lblAct.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblAct.setText("กิจกรรม");

        txtWeight.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtWeight.addActionListener(this::txtWeightActionPerformed);

        txtHeight.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtHeight.addActionListener(this::txtHeightActionPerformed);

        txtAge.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtAge.addActionListener(this::txtAgeActionPerformed);

        cmbGender.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ชาย", "หญิง" }));

        cmbActivity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbActivity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "นั่งทำงานเป็นหลัก", "ออกกำลังกายเบา 1-3 วัน/สัปดาห์", "ออกกำลังกายปานกลาง 3-5 วัน/สัปดาห์", "ออกกำลังกายหนัก 6-7 วัน/สัปดาห์", "ออกกำลังกายหนักมาก" }));

        btnCalc.setBackground(new java.awt.Color(255, 112, 67));
        btnCalc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCalc.setForeground(new java.awt.Color(255, 255, 255));
        btnCalc.setText("คำนวน");
        btnCalc.setBorderPainted(false);
        btnCalc.setOpaque(true);
        btnCalc.addActionListener(this::btnCalcActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblW, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblH, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblA, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblG, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAct, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAge)
                            .addComponent(txtHeight)
                            .addComponent(cmbGender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbActivity, 0, 223, Short.MAX_VALUE))))
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCalc, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblW)
                            .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblH, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblA))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblG))
                        .addGap(18, 18, 18)
                        .addComponent(cmbActivity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblAct))
                .addGap(18, 18, 18)
                .addComponent(btnCalc, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(208, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(227, 242, 253));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ผลลัพธ์", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblResult.setEditable(false);
        lblResult.setBackground(new java.awt.Color(227, 242, 253));
        lblResult.setColumns(20);
        lblResult.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblResult.setLineWrap(true);
        lblResult.setRows(5);
        lblResult.setText("กรอกข้อมูลแล้วกดปุ่มคำนวน");
        lblResult.setWrapStyleWord(true);
        jScrollPane6.setViewportView(lblResult);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane6)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.add(jPanel8, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("BMI / BMR/TDEE", jPanel3);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ข้อมูลหัวใจ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("อายุ (ปี)");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("ชีพจรขณะพัก (ครั้ง/นาที)");

        txtAgeHR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtAgeHR.addActionListener(this::txtAgeHRActionPerformed);

        txtRestHR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnHeart.setBackground(new java.awt.Color(255, 112, 67));
        btnHeart.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnHeart.setForeground(new java.awt.Color(255, 255, 255));
        btnHeart.setText("คำนวนโซนหัวใจ");
        btnHeart.setBorderPainted(false);
        btnHeart.setOpaque(true);
        btnHeart.addActionListener(this::btnHeartActionPerformed);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(btnHeart))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRestHR, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAgeHR, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAgeHR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtRestHR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(btnHeart, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(302, Short.MAX_VALUE))
        );

        jPanel16.setBackground(new java.awt.Color(227, 242, 253));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ผลลัพธ์", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        lblHeartResult.setEditable(false);
        lblHeartResult.setBackground(new java.awt.Color(227, 242, 253));
        lblHeartResult.setColumns(20);
        lblHeartResult.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblHeartResult.setLineWrap(true);
        lblHeartResult.setRows(5);
        lblHeartResult.setText("กรอกข้อมูลแล้วกดปุ่มคำนวน");
        lblHeartResult.setWrapStyleWord(true);
        jScrollPane5.setViewportView(lblHeartResult);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("อัตตราการเต้นของหัวใจ", jPanel13);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new java.awt.GridLayout(1, 0));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ข้อมูลการออกกำลังกาย", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        txtWeight2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtMinutes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMinutes.addActionListener(this::txtMinutesActionPerformed);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("น้ำหนัก (กก.)");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("กิจกรรม");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("เวลา (นาที)");

        cmbSport.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbSport.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "เดินเร็ว", "วิ่ง (8 กม./ชม.)", "ปั่นจักรยาน", "ว่ายน้ำ", "เต้นแอโรบิก", "ยกน้ำหนัก", "โยคะ", "HIIT", "กระโดดเชือก", "แบดมินตัน" }));
        cmbSport.addActionListener(this::cmbSportActionPerformed);

        btnBurn.setBackground(new java.awt.Color(255, 112, 67));
        btnBurn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBurn.setForeground(new java.awt.Color(255, 255, 255));
        btnBurn.setText("คำนวณแคลอรี่");
        btnBurn.setBorderPainted(false);
        btnBurn.setOpaque(true);
        btnBurn.addActionListener(this::btnBurnActionPerformed);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtWeight2)
                            .addComponent(txtMinutes)
                            .addComponent(cmbSport, 0, 219, Short.MAX_VALUE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(btnBurn)))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(txtWeight2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMinutes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmbSport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addComponent(btnBurn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(277, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(227, 242, 253));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ผลลัพธ์", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        lblBurnResult.setEditable(false);
        lblBurnResult.setBackground(new java.awt.Color(227, 242, 253));
        lblBurnResult.setColumns(20);
        lblBurnResult.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblBurnResult.setLineWrap(true);
        lblBurnResult.setRows(5);
        lblBurnResult.setText("กรอกข้อมูลแล้วกดปุ่มคำนวน");
        lblBurnResult.setWrapStyleWord(true);
        jScrollPane4.setViewportView(lblBurnResult);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 861, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("แคลอรี่ที่เผาผลาญ", jPanel6);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ท่าออกกำลังกาย", "จำนวน", "พัก", "กล้ามเนื้อที่ใช้"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setOpaque(false);
        jScrollPane1.setViewportView(jTable1);

        jList1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        txtHow.setColumns(20);
        txtHow.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtHow.setRows(5);
        txtHow.setEnabled(false);
        jScrollPane3.setViewportView(txtHow);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ตารางออกกำลังกาย", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 889, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("empty-statement")
    private void btnBurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBurnActionPerformed
        btnBurn.setEnabled(false);
        try {
            double w = readNumber(txtWeight2, "Weight", 20, 300);
            double m = readNumber(txtMinutes, "Time", 1, 600);
            int i = cmbSport.getSelectedIndex();

            double kcal = Calculations.kcalBurned(i, w, m);
            double fatG = kcal / 7.7;

            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%s %.0f นาที\n", Calculations.SPORT_NAMES[i], m));
            sb.append(String.format("เผาผลาญประมาณ %.0f kcal\n\n", kcal));
            sb.append(String.format("เทียบเท่าไขมันประมาณ %.0f กรัม\n", fatG));
            sb.append(String.format("ค่า MET = %.1f\n\n", Calculations.SPORT_MET[i]));

            sb.append("เทียบกับอาหาร\n");
            sb.append(String.format("• ข้าวสวย 1 จาน (~250 kcal): %.1f จาน\n", kcal / 250));
            sb.append(String.format("• ชานมไข่มุก 1 แก้ว (~400 kcal): %.1f แก้ว\n\n", kcal / 400));

            sb.append(String.format("เทียบทุกกิจกรรม (%.0f นาที)\n", m));
            for (int k = 0; k < Calculations.SPORT_NAMES.length; k++) {
                sb.append(String.format("• %s: %.0f kcal\n",
                    Calculations.SPORT_NAMES[k], Calculations.kcalBurned(k, w, m)));}
        lblBurnResult.setText(sb.toString());
        } catch (IllegalArgumentException ex) { javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage());
        } finally {btnBurn.setEnabled(true);}
    }//GEN-LAST:event_btnBurnActionPerformed

    private void cmbSportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSportActionPerformed

    }//GEN-LAST:event_cmbSportActionPerformed

    private void txtMinutesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMinutesActionPerformed

    }//GEN-LAST:event_txtMinutesActionPerformed

    private void btnHeartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHeartActionPerformed
        btnHeart.setEnabled(false);
        try {
            double a = readNumber(txtAgeHR, "Age", 10, 100);
            double r = readNumber(txtRestHR, "Resting Heart Rate", 30, 120);
            double max = 220 - a;
            if (max - r <= 0) { throw new IllegalArgumentException("Resting heart rate must be lower than maximum heart rate.");}

            double[][] zones = Calculations.heartZones(a, r);

            StringBuilder sb = new StringBuilder();
            sb.append(String.format("อัตราการเต้นสูงสุด = %.0f bpm\n", max));
            sb.append("(สูตร Karvonen: ชีพจรเป้าหมาย = ชีพจรพัก + %HRR × (สูงสุด − พัก))\n\n");
            for (int i = 0; i < zones.length; i++) {
                sb.append(String.format("■ %s\n    %.0f - %.0f bpm (%.0f-%.0f%%)\n",
                    Calculations.HEART_ZONE_NAMES[i], zones[i][0], zones[i][1],
                    Calculations.HEART_ZONE_LO[i] * 100, Calculations.HEART_ZONE_HI[i] * 100));}
        lblHeartResult.setText(sb.toString());
        } catch (IllegalArgumentException ex) {javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage());
        } finally {btnHeart.setEnabled(true);}
    }//GEN-LAST:event_btnHeartActionPerformed

    private void txtAgeHRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgeHRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgeHRActionPerformed

    private void btnCalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcActionPerformed
        btnCalc.setEnabled(false);
        try {
            double w = readNumber(txtWeight, "Weight", 20, 300);
            double h = readNumber(txtHeight, "Height", 100, 250);
            double a = readNumber(txtAge, "Age", 10, 100);
            boolean male = cmbGender.getSelectedIndex() == 0;
            int activity = cmbActivity.getSelectedIndex();

            double bmi = Calculations.bmi(w, h);
            double bmr = Calculations.bmr(w, h, a, male);
            double tdee = Calculations.tdee(bmr, activity);
            double hm = h / 100.0;

            lblResult.setText(String.format("BMI = %.1f\n"
                + "%s\n\n"
                + "BMR (พลังงานขณะพัก): %.0f kcal/วัน\n"
                + "TDEE (พลังงานที่ใช้ต่อวัน): %.0f kcal/วัน\n\n"
                + "น้ำหนักที่เหมาะสม: %.1f - %.1f กก.\n\n"
                + "เป้าหมายแคลอรี่\n"
                + "• ลดน้ำหนัก: ~%.0f kcal/วัน\n"
                + "• คงน้ำหนัก: ~%.0f kcal/วัน\n"
                + "• เพิ่มกล้ามเนื้อ: ~%.0f kcal/วัน\n\n"
                + "BMR คำนวณด้วยสูตร Mifflin-St Jeor / เกณฑ์ BMI สำหรับคนเอเชีย",
                bmi, Calculations.bmiCategory(bmi),
                bmr, tdee,
                18.5 * hm * hm, 22.9 * hm * hm,
                Math.max(tdee - 500, bmr), tdee, tdee + 300));
        } catch (IllegalArgumentException ex) {javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage());
        } finally {btnCalc.setEnabled(true);}
    }//GEN-LAST:event_btnCalcActionPerformed

    private void txtAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgeActionPerformed

    }//GEN-LAST:event_txtAgeActionPerformed

    private void txtHeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHeightActionPerformed

    }//GEN-LAST:event_txtHeightActionPerformed

    private void txtWeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWeightActionPerformed

    }//GEN-LAST:event_txtWeightActionPerformed


   public static void main(String args[]) throws Exception {
    javax.swing.UIManager.setLookAndFeel(
            javax.swing.UIManager.getSystemLookAndFeelClassName());
    java.awt.EventQueue.invokeLater(() -> new FitnessGUI().setVisible(true));}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBurn;
    private javax.swing.JButton btnCalc;
    private javax.swing.JButton btnHeart;
    private javax.swing.JComboBox<String> cmbActivity;
    private javax.swing.JComboBox<String> cmbGender;
    private javax.swing.JComboBox<String> cmbSport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblA;
    private javax.swing.JLabel lblAct;
    private javax.swing.JTextArea lblBurnResult;
    private javax.swing.JLabel lblG;
    private javax.swing.JLabel lblH;
    private javax.swing.JTextArea lblHeartResult;
    private javax.swing.JTextArea lblResult;
    private javax.swing.JLabel lblW;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtAgeHR;
    private javax.swing.JTextField txtHeight;
    private javax.swing.JTextArea txtHow;
    private javax.swing.JTextField txtMinutes;
    private javax.swing.JTextField txtRestHR;
    private javax.swing.JTextField txtWeight;
    private javax.swing.JTextField txtWeight2;
    // End of variables declaration//GEN-END:variables
}
