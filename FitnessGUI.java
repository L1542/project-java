package gui;
import javax.swing.UnsupportedLookAndFeelException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public final class FitnessGUI extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FitnessGUI.class.getName());

    public FitnessGUI() {
            initComponents();
            buildPlans();
            setupWorkoutTab();
    }
    static class Exercise {
        String name, sets, rest, muscle, how;
        boolean done;
        Exercise(String name, String sets, String rest, String muscle, String how) {
            this.name = name; this.sets = sets; this.rest = rest; this.muscle = muscle; this.how = how;}}

    static class DayPlan {
        String day, focus;
        List<Exercise> list = new ArrayList<>();
        DayPlan(String day, String focus) { this.day = day; this.focus = focus; }
        DayPlan add(String n, String s, String r, String m, String h) {
            list.add(new Exercise(n, s, r, m, h)); return this;}}
    final List<DayPlan> plans = new ArrayList<>();
    
    void buildPlans() {
        plans.add(new DayPlan("จันทร์", "อก + ไตรเซ็ป")
            .add("วิดพื้น (Push-up)", "3 x 12 ครั้ง", "60 วิ", "อก, ไหล่, ไตรเซ็ป", "มือกว้างกว่าไหล่เล็กน้อย ลำตัวตรง ลดตัวลงจนอกเกือบถึงพื้น แล้วดันกลับ")
            .add("วิดพื้นเอียง (Incline Push-up)", "3 x 10 ครั้ง", "60 วิ", "อกส่วนล่าง", "วางมือบนเก้าอี้หรือขั้นบันได ลำตัวเป็นเส้นตรง")
            .add("ดิปส์ด้วยเก้าอี้ (Chair Dips)", "3 x 10 ครั้ง", "60 วิ", "ไตรเซ็ป", "มือเกาะขอบเก้าอี้ด้านหลัง งอศอกลง 90 องศา แล้วดันขึ้น")
            .add("วิดพื้นมือชิด (Diamond Push-up)", "3 x 8 ครั้ง", "60 วิ", "ไตรเซ็ป, อกด้านใน", "มือทำเป็นรูปเพชรใต้อก ศอกแนบลำตัว")
            .add("แพลงก์ (Plank)", "3 x 30 วิ", "45 วิ", "แกนกลางลำตัว", "ศอกอยู่ใต้ไหล่ ลำตัวเป็นเส้นตรง เกร็งหน้าท้องและก้น"));

        plans.add(new DayPlan("อังคาร", "ขา + ก้น")
            .add("สควอท (Squat)", "4 x 15 ครั้ง", "60 วิ", "ต้นขา, ก้น", "ยืนกว้างเท่าไหล่ ย่อตัวให้ต้นขาขนานพื้น เข่าไม่เลยปลายเท้า")
            .add("ลันจ์ (Lunge)", "3 x 12 ครั้ง/ข้าง", "60 วิ", "ต้นขา, ก้น", "ก้าวขาไปข้างหน้า ย่อจนเข่าหลังเกือบแตะพื้น แล้วดันกลับ")
            .add("กลูทบริดจ์ (Glute Bridge)", "3 x 15 ครั้ง", "45 วิ", "ก้น, หลังส่วนล่าง", "นอนหงายชันเข่า ยกสะโพกขึ้นจนลำตัวเป็นเส้นตรง บีบก้นค้างไว้ 1 วิ")
            .add("ยกส้นเท้า (Calf Raise)", "3 x 20 ครั้ง", "30 วิ", "น่อง", "ยืนเขย่งปลายเท้าขึ้นให้สุด แล้วลดลงช้าๆ")
            .add("นั่งพิงกำแพง (Wall Sit)", "3 x 30 วิ", "45 วิ", "ต้นขาด้านหน้า", "พิงหลังกับกำแพง ย่อเข่า 90 องศา ค้างไว้"));

        plans.add(new DayPlan("พุธ", "คาร์ดิโอ")
            .add("กระโดดตบ (Jumping Jack)", "3 x 45 วิ", "30 วิ", "ทั้งตัว", "กระโดดพร้อมกางแขนขาออก แล้วหุบกลับ")
            .add("ยกเข่าสูง (High Knees)", "3 x 30 วิ", "30 วิ", "ขา, หัวใจ", "วิ่งอยู่กับที่ ยกเข่าให้สูงระดับสะโพก")
            .add("เบอร์พี (Burpee)", "3 x 10 ครั้ง", "60 วิ", "ทั้งตัว", "ย่อลงวิดพื้น 1 ครั้ง แล้วกระโดดขึ้นพร้อมยกมือเหนือหัว")
            .add("ปีนเขา (Mountain Climber)", "3 x 30 วิ", "30 วิ", "แกนกลาง, ไหล่", "ท่าวิดพื้น สลับดึงเข่าเข้าหาอกอย่างเร็ว")
            .add("วิ่งเหยาะๆ (Jogging)", "20 นาที", "-", "หัวใจ, ขา", "วิ่งในความเร็วที่ยังพูดคุยได้"));

        plans.add(new DayPlan("พฤหัสบดี", "หลัง + ไบเซ็ป")
            .add("ซูเปอร์แมน (Superman)", "3 x 12 ครั้ง", "45 วิ", "หลังส่วนล่าง", "นอนคว่ำ ยกแขนและขาขึ้นพร้อมกัน ค้าง 2 วิ")
            .add("ดัมเบลโรว์ (Dumbbell Row)", "3 x 12 ครั้ง/ข้าง", "60 วิ", "หลังส่วนบน, ไบเซ็ป", "โน้มตัว ดึงดัมเบล/ขวดน้ำเข้าหาเอว บีบสะบัก")
            .add("ไบเซ็ปเคิร์ล (Biceps Curl)", "3 x 12 ครั้ง", "45 วิ", "ไบเซ็ป", "ศอกแนบลำตัว งอข้อศอกยกขึ้น แล้วลดลงช้าๆ")
            .add("เบิร์ดด็อก (Bird Dog)", "3 x 10 ครั้ง/ข้าง", "30 วิ", "หลัง, แกนกลาง", "คลานสี่ขา ยกแขนขวากับขาซ้ายพร้อมกัน สลับข้าง")
            .add("ยืดเหยียดหลัง (Child's Pose)", "2 x 30 วิ", "-", "หลัง", "นั่งทับส้นเท้า ก้มตัวและเหยียดแขนไปข้างหน้า"));

        plans.add(new DayPlan("ศุกร์", "ไหล่ + หน้าท้อง")
            .add("ไพค์พุชอัพ (Pike Push-up)", "3 x 10 ครั้ง", "60 วิ", "ไหล่", "ตั้งสะโพกสูงเป็นรูปตัว V งอศอกให้หัวลงไปหาพื้น")
            .add("ยกแขนด้านข้าง (Lateral Raise)", "3 x 12 ครั้ง", "45 วิ", "ไหล่", "ถือน้ำหนัก ยกแขนออกข้างระดับไหล่ แล้วลดลงช้าๆ")
            .add("ครันช์ (Crunch)", "3 x 20 ครั้ง", "30 วิ", "หน้าท้อง", "นอนหงายชันเข่า ยกไหล่ขึ้นเล็กน้อย เกร็งหน้าท้อง")
            .add("ยกขา (Leg Raise)", "3 x 12 ครั้ง", "45 วิ", "หน้าท้องส่วนล่าง", "นอนหงาย ยกขาตรงขึ้น 90 องศา แล้วลดลงไม่แตะพื้น")
            .add("รัสเซียนทวิสต์ (Russian Twist)", "3 x 20 ครั้ง", "30 วิ", "หน้าท้องด้านข้าง", "นั่งเอนตัว บิดลำตัวสลับซ้าย-ขวา"));

        plans.add(new DayPlan("เสาร์", "HIIT ทั้งตัว")
            .add("สควอทกระโดด (Jump Squat)", "4 รอบ x 40 วิ", "20 วิ", "ขา, ก้น", "ย่อตัวแล้วกระโดดขึ้นสุดแรง ลงนุ่มนวล")
            .add("วิดพื้น (Push-up)", "4 รอบ x 40 วิ", "20 วิ", "อก, แขน", "ทำให้ได้มากที่สุดในเวลาที่กำหนด")
            .add("เบอร์พี (Burpee)", "4 รอบ x 40 วิ", "20 วิ", "ทั้งตัว", "ทำต่อเนื่องไม่หยุด")
            .add("ปีนเขา (Mountain Climber)", "4 รอบ x 40 วิ", "20 วิ", "แกนกลาง", "ท่าวิดพื้น สลับเข่าเร็วๆ")
            .add("แพลงก์ (Plank)", "4 รอบ x 40 วิ", "20 วิ", "แกนกลาง", "ลำตัวตรง เกร็งหน้าท้อง"));

        plans.add(new DayPlan("อาทิตย์", "พักผ่อน / ยืดเหยียด")
            .add("เดินเล่น", "20-30 นาที", "-", "ทั้งตัว", "เดินสบายๆ ผ่อนคลายกล้ามเนื้อ")
            .add("แคท-คาว (Cat-Cow)", "2 x 10 ครั้ง", "-", "กระดูกสันหลัง", "คลานสี่ขา สลับแอ่นหลังและโค้งหลัง")
            .add("ยืดเหยียดต้นขาหลัง", "2 x 30 วิ/ข้าง", "-", "ต้นขาด้านหลัง", "นั่งเหยียดขาข้างเดียว โน้มตัวไปแตะปลายเท้า")
            .add("ยืดสะโพก (Hip Flexor Stretch)", "2 x 30 วิ/ข้าง", "-", "สะโพก", "ก้าวขาไปข้างหน้าในท่าลันจ์ ดันสะโพกลง")
            .add("นอนหายใจลึกๆ", "5 นาที", "-", "จิตใจ", "นอนหงาย หายใจเข้า-ออกช้าๆ ผ่อนคลายทั้งตัว"));}
    
        static class ExerciseModel extends AbstractTableModel {
        final String[] cols = {"เสร็จ", "ท่าออกกำลังกาย", "จำนวน", "พัก", "กล้ามเนื้อที่ใช้"};
        List<Exercise> data = new ArrayList<>();
        Runnable onChange;

        @Override public int getRowCount() { return data.size(); }
        @Override public int getColumnCount() { return cols.length; }
        @Override public String getColumnName(int c) { return cols[c]; }
        @Override public Class<?> getColumnClass(int c) { return c == 0 ? Boolean.class : String.class; }
        @Override public boolean isCellEditable(int r, int c) { return c == 0; }
        @Override public Object getValueAt(int r, int c) {
            Exercise e = data.get(r);
            return switch (c) {
                case 0 -> e.done;
                case 1 -> e.name;
                case 2 -> e.sets;
                case 3 -> e.rest;
                default -> e.muscle;}; }
        @Override
        public void setValueAt(Object v, int r, int c) {
            if (c == 0) {
                data.get(r).done = (Boolean) v;
                fireTableCellUpdated(r, c);
                if (onChange != null) onChange.run(); }}}
        
        private final ExerciseModel model = new ExerciseModel();

        private void setupWorkoutTab() {
            // รายการวัน
            javax.swing.DefaultListModel<String> lm = new javax.swing.DefaultListModel<>();
            for (DayPlan p : plans) { lm.addElement(p.day + "  •  " + p.focus);}
            dayList.setModel(lm);
            dayList.setFixedCellHeight(44);
            dayList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

            // ตาราง
            tblExercise.setModel(model);
            tblExercise.setRowHeight(32);
            tblExercise.getColumnModel().getColumn(0).setMaxWidth(60);
            tblExercise.getColumnModel().getColumn(2).setPreferredWidth(110);
            tblExercise.getColumnModel().getColumn(3).setMaxWidth(70);
            DefaultTableCellRenderer center = new DefaultTableCellRenderer();
            center.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            tblExercise.getColumnModel().getColumn(2).setCellRenderer(center);
            tblExercise.getColumnModel().getColumn(3).setCellRenderer(center);
            tblExercise.getTableHeader().setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 14));

            // เมื่อติ๊กท่า ให้อัปเดตแถบ progress
            model.onChange = this::updateProgress;

            // เมื่อเลือกวัน ให้แสดงตารางของวันนั้น
            dayList.addListSelectionListener(e -> {
                if (!e.getValueIsAdjusting()) {
                    showDay(dayList.getSelectedIndex());}});

            // เมื่อเลือกท่า ให้แสดงวิธีทำ
            tblExercise.getSelectionModel().addListSelectionListener(e -> {
                int r = tblExercise.getSelectedRow();
                txtHow.setText(r >= 0 ? model.data.get(r).name + "\n" + model.data.get(r).how : ""); });
            // เลือกวันปัจจุบันเป็นค่าเริ่มต้น
            dayList.setSelectedIndex(LocalDate.now().getDayOfWeek().getValue() - 1);}

        private void showDay(int idx) {
            if (idx < 0) return;
            DayPlan p = plans.get(idx);
            lblDayTitle.setText("วัน" + p.day + " : " + p.focus);
            model.data = p.list;
            model.fireTableDataChanged();
            txtHow.setText("");
            if (!p.list.isEmpty()) {
                tblExercise.setRowSelectionInterval(0, 0);
            }
            updateProgress();}

        private void updateProgress() {
            int total = model.data.size(), done = 0;
            for (Exercise e : model.data) {
                if (e.done) done++;}
            progressBar.setValue(total == 0 ? 0 : done * 100 / total);
            lblProgress.setText("ทำแล้ว " + done + "/" + total + " ท่า");
            if (total > 0 && done == total) { progressBar.setString("ครบแล้ว เก่งมาก!"); } 
            else {progressBar.setString(progressBar.getValue() + "%");}}
        // อ่านตัวเลขจากช่องกรอก พร้อมตรวจช่วงที่ยอมรับ (min ถึง max)
        private double readNumber(javax.swing.JTextField f, String name, double min, double max) {
            String text = f.getText().trim();
            if (text.isEmpty()) {
                f.requestFocusInWindow();
                throw new IllegalArgumentException("กรุณากรอก \"" + name + "\"");}
            double v;
            try {
                v = Double.parseDouble(text);
            } catch (NumberFormatException ex) {
                f.requestFocusInWindow();
                f.selectAll();
                throw new IllegalArgumentException("\"" + name + "\" ต้องเป็นตัวเลขเท่านั้น");}
            if (Double.isNaN(v) || Double.isInfinite(v)) {   // กันพิมพ์ NaN หรือ Infinity
                f.requestFocusInWindow();
                f.selectAll();
                throw new IllegalArgumentException("\"" + name + "\" ต้องเป็นตัวเลขเท่านั้น"); }
            if (v < min) {
                f.requestFocusInWindow();
                f.selectAll();
                throw new IllegalArgumentException(String.format(
                    "\"%s\" น้อยเกินไป (ต้องไม่ต่ำกว่า %.0f)", name, min));}
            if (v > max) {
                f.requestFocusInWindow();
                f.selectAll();
                throw new IllegalArgumentException(String.format(
                    "\"%s\" มากเกินไป (ต้องไม่เกิน %.0f)", name, max));
            }
            return v; }

    @SuppressWarnings("unchecked")
    //แค่สร้างหน้าจอ 166 - 809
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
        lblResult = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtAgeHR = new javax.swing.JTextField();
        txtRestHR = new javax.swing.JTextField();
        btnHeart = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        lblHeartResult = new javax.swing.JLabel();
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
        lblBurnResult = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dayList = new javax.swing.JList<>();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtHow = new javax.swing.JTextArea();
        lblDayTitle = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblExercise = new javax.swing.JTable();
        lblProgress = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

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
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ทำข้อมูลร่างกาย", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
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
        btnCalc.setText("คำนวณ");
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(227, 242, 253));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ผลลัพธ์", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblResult.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblResult.setText("กรอกข้อมูลแล้วกดปุ่มคำนวน");
        lblResult.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblResult, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(lblResult, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
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
        btnHeart.setText("คำนวณโซนหัวใจ");
        btnHeart.setBorderPainted(false);
        btnHeart.setOpaque(true);
        btnHeart.addActionListener(this::btnHeartActionPerformed);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHeart)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtAgeHR)
                        .addComponent(txtRestHR, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)))
                .addContainerGap(63, Short.MAX_VALUE))
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

        lblHeartResult.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblHeartResult.setText("กรอกข้อมูลแล้วกดปุ่มคำนวน");
        lblHeartResult.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHeartResult, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(lblHeartResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap(105, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(227, 242, 253));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ผลลัพธ์", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        lblBurnResult.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblBurnResult.setText("กรอกข้อมูลแล้วกดปุ่มคำนวน");
        lblBurnResult.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBurnResult, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(lblBurnResult, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "เลือกวัน", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        dayList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dayList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "จันทร์  •  อก + ไตรเซ็ป", "อังคาร  •  ขา + ก้น", "พุธ  •  คาร์ดิโอ", "พฤหัสบดี  •  หลัง + ไบเซ็ป", "ศุกร์  •  ไหล่ + หน้าท้อง", "เสาร์  •  HIIT ทั้งตัว", "อาทิตย์  •  พักผ่อน / ยืดเหยียด" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(dayList);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "วิธีทำ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel17.setLayout(new java.awt.BorderLayout());

        txtHow.setEditable(false);
        txtHow.setBackground(new java.awt.Color(204, 217, 242));
        txtHow.setColumns(20);
        txtHow.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtHow.setLineWrap(true);
        txtHow.setRows(5);
        jScrollPane3.setViewportView(txtHow);

        jPanel17.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        lblDayTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        tblExercise.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblExercise.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblExercise);

        lblProgress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblProgress.setText("ทำแล้ว 0/0 ท่า");

        progressBar.setForeground(new java.awt.Color(67, 160, 71));
        progressBar.setStringPainted(true);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(lblDayTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(lblProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(lblDayTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblProgress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("ตารางออกกำลังกาย", jPanel18);

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

    private void txtMinutesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMinutesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMinutesActionPerformed

    private void cmbSportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSportActionPerformed

    private void btnBurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBurnActionPerformed
         // ชื่อกิจกรรมและค่า MET ต้องเรียงตรงกับรายการใน cmbSport
    String[] sportNames = {"เดินเร็ว", "วิ่ง (8 กม./ชม.)", "ปั่นจักรยาน", "ว่ายน้ำ",
            "เต้นแอโรบิก", "ยกน้ำหนัก", "โยคะ", "HIIT", "กระโดดเชือก", "แบดมินตัน"};
    double[] sportMet = {3.8, 8.3, 7.5, 6.0, 6.5, 5.0, 2.5, 8.0, 11.0, 5.5};

    btnBurn.setEnabled(false);
    try {
        double w = readNumber(txtWeight2, "น้ำหนัก", 20, 300);
        double m = readNumber(txtMinutes, "เวลา", 1, 600);
        if (w <= 0 || m <= 0){throw new IllegalArgumentException("ค่าต้องมากกว่า 0");}
        

        int i = cmbSport.getSelectedIndex();
        double kcal = sportMet[i] * w * (m / 60.0);   // kcal = MET x น้ำหนัก x ชั่วโมง
        double fatG = kcal / 7.7;                      // ไขมัน 1 กรัม ~ 7.7 kcal

        StringBuilder sb = new StringBuilder("<html><body style='width:320px'>");
        sb.append(String.format("<h2>%s %.0f นาที</h2>", sportNames[i], m));
        sb.append(String.format(
            "เผาผลาญประมาณ <b><font color='#F4511E' size='5'>%.0f kcal</font></b><br><br>", kcal));
        sb.append(String.format("เทียบเท่าไขมันประมาณ %.0f กรัม<br>", fatG));
        sb.append(String.format("ค่า MET = %.1f<br><br>", sportMet[i]));

        sb.append("<b>เทียบกับอาหาร</b><br>");
        sb.append(String.format("• ข้าวสวย 1 จาน (~250 kcal): %.1f จาน<br>", kcal / 250));
        sb.append(String.format("• ชานมไข่มุก 1 แก้ว (~400 kcal): %.1f แก้ว<br><br>", kcal / 400));

        sb.append(String.format("<b>เทียบทุกกิจกรรม (%.0f นาที)</b><br>", m));
        for (int k = 0; k < sportNames.length; k++) {
            sb.append(String.format("• %s: %.0f kcal<br>", sportNames[k], sportMet[k] * w * m / 60.0));}
        sb.append("</body></html>");

        lblBurnResult.setText(sb.toString());

    } catch (NumberFormatException ex) {   
        javax.swing.JOptionPane.showMessageDialog(this, "Please fill in the numbers correctly.,Please fill in the numbers correctly.");
    } catch (IllegalArgumentException ex) {
        javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage());
    } finally {
        btnBurn.setEnabled(true);}
    }//GEN-LAST:event_btnBurnActionPerformed

    private void btnCalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcActionPerformed
        btnCalc.setEnabled(false);
        try {
            double w = readNumber(txtWeight, "น้ำหนัก", 20, 300);
            double h = readNumber(txtHeight, "ส่วนสูง", 100, 250);
            double a = readNumber(txtAge, "อายุ", 10, 100);
            if (w <= 0 || h <= 0 || a <= 0) {throw new IllegalArgumentException("ค่าต้องมากกว่า 0");}

            double hm = h / 100.0;
            double bmi = w / (hm * hm);
            boolean male = cmbGender.getSelectedIndex() == 0;
            double bmr = 10 * w + 6.25 * h - 5 * a + (male ? 5 : -161);
            double[] mul = {1.2, 1.375, 1.55, 1.725, 1.9};
            double tdee = bmr * mul[cmbActivity.getSelectedIndex()];

            // หมวดหมู่ BMI และสี (เกณฑ์คนเอเชีย)
            String cat, col;
            if (bmi < 18.5)      { cat = "น้ำหนักต่ำกว่าเกณฑ์"; col = "#1E88E5"; }
            else if (bmi < 23)   { cat = "สมส่วน (ปกติ)";       col = "#43A047"; }
            else if (bmi < 25)   { cat = "น้ำหนักเกิน";          col = "#FB8C00"; }
            else if (bmi < 30)   { cat = "โรคอ้วนระดับ 1";       col = "#F4511E"; }
            else                 { cat = "โรคอ้วนระดับ 2";       col = "#C62828"; }

            // ช่วงน้ำหนักที่เหมาะสม (BMI 18.5 - 22.9)
            double minW = 18.5 * hm * hm;
            double maxW = 22.9 * hm * hm;

            lblResult.setText(String.format(
                "<html><body style='width:320px'>"
                + "<h2>BMI = %.1f</h2>"
                + "<b><font color='%s'>%s</font></b><br><br>"
                + "<b>BMR</b> (พลังงานขณะพัก): %.0f kcal/วัน<br>"
                + "<b>TDEE</b> (พลังงานที่ใช้ต่อวัน): %.0f kcal/วัน<br><br>"
                + "น้ำหนักที่เหมาะสม: %.1f - %.1f กก.<br><br>"
                + "<b>เป้าหมายแคลอรี่</b><br>"
                + "• ลดน้ำหนัก: ~%.0f kcal/วัน<br>"
                + "• คงน้ำหนัก: ~%.0f kcal/วัน<br>"
                + "• เพิ่มกล้ามเนื้อ: ~%.0f kcal/วัน<br><br>"
                + "<small>BMR คำนวณด้วยสูตร Mifflin-St Jeor / เกณฑ์ BMI สำหรับคนเอเชีย</small>"
                + "</body></html>",
                bmi, col, cat,
                bmr, tdee,
                minW, maxW,
                tdee - 500, tdee, tdee + 300));

        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please fill in the numbers correctly.,Please fill in the numbers correctly.");
        } catch (IllegalArgumentException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage());
        } finally {
            btnCalc.setEnabled(true); }
    }//GEN-LAST:event_btnCalcActionPerformed

    private void txtAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgeActionPerformed

    private void txtHeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHeightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHeightActionPerformed

    private void txtWeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWeightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWeightActionPerformed

    private void txtAgeHRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgeHRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgeHRActionPerformed

    private void btnHeartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHeartActionPerformed
        btnHeart.setEnabled(false);
    try {
        double a = readNumber(txtAgeHR, "อายุ", 10, 100);
        double r = readNumber(txtRestHR, "ชีพจรขณะพัก", 30, 120);
        if (a <= 0 || r <= 0) {throw new IllegalArgumentException("ค่าต้องมากกว่า 0");}
        double max = 220 - a;        // อัตราการเต้นสูงสุด
        double reserve = max - r;    // ช่วงสำรองของหัวใจ (Heart Rate Reserve)
        if (reserve <= 0) {throw new IllegalArgumentException("ชีพจรขณะพักต้องน้อยกว่าอัตราการเต้นสูงสุด");}

        String[] zn = {"โซน 1 - วอร์มอัพ/ฟื้นตัว", "โซน 2 - เผาผลาญไขมัน", "โซน 3 - แอโรบิก",
                       "โซน 4 - เพิ่มสมรรถภาพ", "โซน 5 - สูงสุด"};
        String[] col = {"#90A4AE", "#43A047", "#FDD835", "#FB8C00", "#E53935"};
        double[] lo = {0.50, 0.60, 0.70, 0.80, 0.90};
        double[] hi = {0.60, 0.70, 0.80, 0.90, 1.00};

        StringBuilder sb = new StringBuilder("<html><body style='width:320px'>");
        sb.append(String.format("<h3>อัตราการเต้นสูงสุด = %.0f bpm</h3>", max));
        sb.append("<small>(สูตร Karvonen: ชีพจรเป้าหมาย = ชีพจรพัก + %HRR × (สูงสุด − พัก))</small><br><br>");
        for (int i = 0; i < 5; i++) {
            sb.append(String.format(
                "<font color='%s'>■</font> <b>%s</b><br>&nbsp;&nbsp;&nbsp;%.0f - %.0f bpm (%.0f-%.0f%%)<br>",
                col[i], zn[i], r + lo[i] * reserve, r + hi[i] * reserve, lo[i] * 100, hi[i] * 100)); }
        sb.append("</body></html>");

        lblHeartResult.setText(sb.toString());

    } catch (NumberFormatException ex) {   // ต้องดักก่อน IllegalArgumentException
        javax.swing.JOptionPane.showMessageDialog(this, "Please fill in the numbers correctly.,Please fill in the numbers correctly.");
    } catch (IllegalArgumentException ex) {
        javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage());
    } finally {
        btnHeart.setEnabled(true);}
    }//GEN-LAST:event_btnHeartActionPerformed

    public static void main(String args[]) {
            try {
            javax.swing.UIManager.setLookAndFeel(
            javax.swing.UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
             logger.log(java.util.logging.Level.SEVERE, null, ex); }
        java.awt.EventQueue.invokeLater(() -> new FitnessGUI().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBurn;
    private javax.swing.JButton btnCalc;
    private javax.swing.JButton btnHeart;
    private javax.swing.JComboBox<String> cmbActivity;
    private javax.swing.JComboBox<String> cmbGender;
    private javax.swing.JComboBox<String> cmbSport;
    private javax.swing.JList<String> dayList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
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
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblA;
    private javax.swing.JLabel lblAct;
    private javax.swing.JLabel lblBurnResult;
    private javax.swing.JLabel lblDayTitle;
    private javax.swing.JLabel lblG;
    private javax.swing.JLabel lblH;
    private javax.swing.JLabel lblHeartResult;
    private javax.swing.JLabel lblProgress;
    private javax.swing.JLabel lblResult;
    private javax.swing.JLabel lblW;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JTable tblExercise;
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
