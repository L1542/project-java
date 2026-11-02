package gui; // ประกาศว่าคลาสนี้อยู่ในแพ็กเกจ gui
import javax.swing.UnsupportedLookAndFeelException; // exception ของการตั้งธีม (ยังไม่ได้ใช้ในโค้ดนี้)
import java.util.ArrayList; // ArrayList ใช้เก็บรายการข้อมูล
import java.util.List; // List อินเทอร์เฟซของรายการ
import javax.swing.table.AbstractTableModel; // คลาสแม่สำหรับสร้างโมเดลข้อมูลของตาราง
import javax.swing.table.DefaultTableCellRenderer; // ตัววาดเซลล์ตาราง ใช้จัดข้อความกึ่งกลาง

public final class FitnessGUI extends javax.swing.JFrame { // คลาสหลัก เป็นหน้าต่าง (JFrame) และห้ามสืบทอดต่อ (final)

private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FitnessGUI.class.getName()); // ตัวบันทึก log ของคลาสนี้

public FitnessGUI() { // constructor ทำงานตอนสร้างหน้าต่าง
        initComponents(); // สร้างคอมโพเนนต์ทั้งหมด (ปุ่ม ช่องกรอก ตาราง)
        buildPlans(); // สร้างข้อมูลแผนออกกำลังกาย 7 วัน
        setupWorkoutTab(); // ผูกข้อมูลเข้ากับ list/ตาราง และตั้ง listener
} // จบ constructor
static class Exercise { // คลาสเก็บข้อมูลท่าออกกำลังกาย 1 ท่า
    String name, sets, rest, muscle, how; // ชื่อท่า, จำนวนเซ็ต, เวลาพัก, กล้ามเนื้อที่ใช้, วิธีทำ
    boolean done; // ติ๊กว่าทำแล้วหรือยัง (ค่าเริ่มต้น false)
    Exercise(String name, String sets, String rest, String muscle, String how) { // constructor รับค่า 5 ตัว
        this.name = name; // เก็บชื่อท่าลงฟิลด์
        this.sets = sets; // เก็บจำนวนเซ็ต
        this.rest = rest; // เก็บเวลาพัก
        this.muscle = muscle; // เก็บกล้ามเนื้อที่ใช้
        this.how = how;}} // เก็บวิธีทำ แล้วปิด constructor และคลาส Exercise

static class DayPlan { // คลาสเก็บแผนของ 1 วัน
    String day, focus; // ชื่อวัน และหัวข้อโฟกัสของวันนั้น
    List<Exercise> list = new ArrayList<>(); // รายการท่าของวันนั้น
    DayPlan(String day, String focus) { this.day = day; this.focus = focus; } // constructor ตั้งวันและโฟกัส
    DayPlan add(String n, String s, String r, String m, String h) { // เมธอดเพิ่มท่าเข้าแผน
        list.add(new Exercise(n, s, r, m, h)); return this;}} // สร้าง Exercise ใส่ list แล้วคืนตัวเอง (ต่อ .add() เป็นสายได้)
final List<DayPlan> plans = new ArrayList<>(); // รายการแผนทั้งสัปดาห์


void buildPlans() { // เมธอดสร้างข้อมูลแผน 7 วัน
    plans.add(new DayPlan("จันทร์", "อก + ไตรเซ็ป") // สร้างแผนวันจันทร์ แล้วเพิ่มเข้า plans
        .add("วิดพื้น (Push-up)", "3 x 12 ครั้ง", "60 วิ", "อก, ไหล่, ไตรเซ็ป", "มือกว้างกว่าไหล่เล็กน้อย ลำตัวตรง ลดตัวลงจนอกเกือบถึงพื้น แล้วดันกลับ") // ท่าที่ 1
        .add("วิดพื้นเอียง (Incline Push-up)", "3 x 10 ครั้ง", "60 วิ", "อกส่วนล่าง", "วางมือบนเก้าอี้หรือขั้นบันได ลำตัวเป็นเส้นตรง") // ท่าที่ 2
        .add("ดิปส์ด้วยเก้าอี้ (Chair Dips)", "3 x 10 ครั้ง", "60 วิ", "ไตรเซ็ป", "มือเกาะขอบเก้าอี้ด้านหลัง งอศอกลง 90 องศา แล้วดันขึ้น") // ท่าที่ 3
        .add("วิดพื้นมือชิด (Diamond Push-up)", "3 x 8 ครั้ง", "60 วิ", "ไตรเซ็ป, อกด้านใน", "มือทำเป็นรูปเพชรใต้อก ศอกแนบลำตัว") // ท่าที่ 4
        .add("แพลงก์ (Plank)", "3 x 30 วิ", "45 วิ", "แกนกลางลำตัว", "ศอกอยู่ใต้ไหล่ ลำตัวเป็นเส้นตรง เกร็งหน้าท้องและก้น")); // ท่าที่ 5 และปิดการเพิ่มแผน

    plans.add(new DayPlan("อังคาร", "ขา + ก้น") // แผนวันอังคาร
        .add("สควอท (Squat)", "4 x 15 ครั้ง", "60 วิ", "ต้นขา, ก้น", "ยืนกว้างเท่าไหล่ ย่อตัวให้ต้นขาขนานพื้น เข่าไม่เลยปลายเท้า") // ท่าที่ 1
        .add("ลันจ์ (Lunge)", "3 x 12 ครั้ง/ข้าง", "60 วิ", "ต้นขา, ก้น", "ก้าวขาไปข้างหน้า ย่อจนเข่าหลังเกือบแตะพื้น แล้วดันกลับ") // ท่าที่ 2
        .add("กลูทบริดจ์ (Glute Bridge)", "3 x 15 ครั้ง", "45 วิ", "ก้น, หลังส่วนล่าง", "นอนหงายชันเข่า ยกสะโพกขึ้นจนลำตัวเป็นเส้นตรง บีบก้นค้างไว้ 1 วิ") // ท่าที่ 3
        .add("ยกส้นเท้า (Calf Raise)", "3 x 20 ครั้ง", "30 วิ", "น่อง", "ยืนเขย่งปลายเท้าขึ้นให้สุด แล้วลดลงช้าๆ") // ท่าที่ 4
        .add("นั่งพิงกำแพง (Wall Sit)", "3 x 30 วิ", "45 วิ", "ต้นขาด้านหน้า", "พิงหลังกับกำแพง ย่อเข่า 90 องศา ค้างไว้")); // ท่าที่ 5 และปิดแผน

    plans.add(new DayPlan("พุธ", "คาร์ดิโอ") // แผนวันพุธ
        .add("กระโดดตบ (Jumping Jack)", "3 x 45 วิ", "30 วิ", "ทั้งตัว", "กระโดดพร้อมกางแขนขาออก แล้วหุบกลับ") // ท่าที่ 1
        .add("ยกเข่าสูง (High Knees)", "3 x 30 วิ", "30 วิ", "ขา, หัวใจ", "วิ่งอยู่กับที่ ยกเข่าให้สูงระดับสะโพก") // ท่าที่ 2
        .add("เบอร์พี (Burpee)", "3 x 10 ครั้ง", "60 วิ", "ทั้งตัว", "ย่อลงวิดพื้น 1 ครั้ง แล้วกระโดดขึ้นพร้อมยกมือเหนือหัว") // ท่าที่ 3
        .add("ปีนเขา (Mountain Climber)", "3 x 30 วิ", "30 วิ", "แกนกลาง, ไหล่", "ท่าวิดพื้น สลับดึงเข่าเข้าหาอกอย่างเร็ว") // ท่าที่ 4
        .add("วิ่งเหยาะๆ (Jogging)", "20 นาที", "-", "หัวใจ, ขา", "วิ่งในความเร็วที่ยังพูดคุยได้")); // ท่าที่ 5 และปิดแผน

    plans.add(new DayPlan("พฤหัสบดี", "หลัง + ไบเซ็ป") // แผนวันพฤหัสบดี
        .add("ซูเปอร์แมน (Superman)", "3 x 12 ครั้ง", "45 วิ", "หลังส่วนล่าง", "นอนคว่ำ ยกแขนและขาขึ้นพร้อมกัน ค้าง 2 วิ") // ท่าที่ 1
        .add("ดัมเบลโรว์ (Dumbbell Row)", "3 x 12 ครั้ง/ข้าง", "60 วิ", "หลังส่วนบน, ไบเซ็ป", "โน้มตัว ดึงดัมเบล/ขวดน้ำเข้าหาเอว บีบสะบัก") // ท่าที่ 2
        .add("ไบเซ็ปเคิร์ล (Biceps Curl)", "3 x 12 ครั้ง", "45 วิ", "ไบเซ็ป", "ศอกแนบลำตัว งอข้อศอกยกขึ้น แล้วลดลงช้าๆ") // ท่าที่ 3
        .add("เบิร์ดด็อก (Bird Dog)", "3 x 10 ครั้ง/ข้าง", "30 วิ", "หลัง, แกนกลาง", "คลานสี่ขา ยกแขนขวากับขาซ้ายพร้อมกัน สลับข้าง") // ท่าที่ 4
        .add("ยืดเหยียดหลัง (Child's Pose)", "2 x 30 วิ", "-", "หลัง", "นั่งทับส้นเท้า ก้มตัวและเหยียดแขนไปข้างหน้า")); // ท่าที่ 5 และปิดแผน

    plans.add(new DayPlan("ศุกร์", "ไหล่ + หน้าท้อง") // แผนวันศุกร์
        .add("ไพค์พุชอัพ (Pike Push-up)", "3 x 10 ครั้ง", "60 วิ", "ไหล่", "ตั้งสะโพกสูงเป็นรูปตัว V งอศอกให้หัวลงไปหาพื้น") // ท่าที่ 1
        .add("ยกแขนด้านข้าง (Lateral Raise)", "3 x 12 ครั้ง", "45 วิ", "ไหล่", "ถือน้ำหนัก ยกแขนออกข้างระดับไหล่ แล้วลดลงช้าๆ") // ท่าที่ 2
        .add("ครันช์ (Crunch)", "3 x 20 ครั้ง", "30 วิ", "หน้าท้อง", "นอนหงายชันเข่า ยกไหล่ขึ้นเล็กน้อย เกร็งหน้าท้อง") // ท่าที่ 3
        .add("ยกขา (Leg Raise)", "3 x 12 ครั้ง", "45 วิ", "หน้าท้องส่วนล่าง", "นอนหงาย ยกขาตรงขึ้น 90 องศา แล้วลดลงไม่แตะพื้น") // ท่าที่ 4
        .add("รัสเซียนทวิสต์ (Russian Twist)", "3 x 20 ครั้ง", "30 วิ", "หน้าท้องด้านข้าง", "นั่งเอนตัว บิดลำตัวสลับซ้าย-ขวา")); // ท่าที่ 5 และปิดแผน

    plans.add(new DayPlan("เสาร์", "HIIT ทั้งตัว") // แผนวันเสาร์
        .add("สควอทกระโดด (Jump Squat)", "4 รอบ x 40 วิ", "20 วิ", "ขา, ก้น", "ย่อตัวแล้วกระโดดขึ้นสุดแรง ลงนุ่มนวล") // ท่าที่ 1
        .add("วิดพื้น (Push-up)", "4 รอบ x 40 วิ", "20 วิ", "อก, แขน", "ทำให้ได้มากที่สุดในเวลาที่กำหนด") // ท่าที่ 2
        .add("เบอร์พี (Burpee)", "4 รอบ x 40 วิ", "20 วิ", "ทั้งตัว", "ทำต่อเนื่องไม่หยุด") // ท่าที่ 3
        .add("ปีนเขา (Mountain Climber)", "4 รอบ x 40 วิ", "20 วิ", "แกนกลาง", "ท่าวิดพื้น สลับเข่าเร็วๆ") // ท่าที่ 4
        .add("แพลงก์ (Plank)", "4 รอบ x 40 วิ", "20 วิ", "แกนกลาง", "ลำตัวตรง เกร็งหน้าท้อง")); // ท่าที่ 5 และปิดแผน

    plans.add(new DayPlan("อาทิตย์", "พักผ่อน / ยืดเหยียด") // แผนวันอาทิตย์
        .add("เดินเล่น", "20-30 นาที", "-", "ทั้งตัว", "เดินสบายๆ ผ่อนคลายกล้ามเนื้อ") // ท่าที่ 1
        .add("แคท-คาว (Cat-Cow)", "2 x 10 ครั้ง", "-", "กระดูกสันหลัง", "คลานสี่ขา สลับแอ่นหลังและโค้งหลัง") // ท่าที่ 2
        .add("ยืดเหยียดต้นขาหลัง", "2 x 30 วิ/ข้าง", "-", "ต้นขาด้านหลัง", "นั่งเหยียดขาข้างเดียว โน้มตัวไปแตะปลายเท้า") // ท่าที่ 3
        .add("ยืดสะโพก (Hip Flexor Stretch)", "2 x 30 วิ/ข้าง", "-", "สะโพก", "ก้าวขาไปข้างหน้าในท่าลันจ์ ดันสะโพกลง") // ท่าที่ 4
        .add("นอนหายใจลึกๆ", "5 นาที", "-", "จิตใจ", "นอนหงาย หายใจเข้า-ออกช้าๆ ผ่อนคลายทั้งตัว"));} // ท่าที่ 5 ปิดแผน และปิดเมธอด buildPlans

    static class ExerciseModel extends AbstractTableModel { // โมเดลบอกตารางว่าข้อมูลคืออะไรและแสดงอย่างไร
    final String[] cols = {"เสร็จ", "ท่าออกกำลังกาย", "จำนวน", "พัก", "กล้ามเนื้อที่ใช้"}; // ชื่อหัวคอลัมน์ 5 ช่อง
    List<Exercise> data = new ArrayList<>(); // ข้อมูลที่กำลังแสดง (เปลี่ยนตามวันที่เลือก)
    Runnable onChange; // โค้ดที่จะถูกเรียกเมื่อมีการติ๊ก (ใช้อัปเดต progress)

    @Override public int getRowCount() { return data.size(); } // จำนวนแถว = จำนวนท่า
    @Override public int getColumnCount() { return cols.length; } // จำนวนคอลัมน์ = 5
    @Override public String getColumnName(int c) { return cols[c]; } // คืนชื่อหัวคอลัมน์ที่ c
    @Override public Class getColumnClass(int c) {return c == 0 ? Boolean.class : String.class;} // คอลัมน์ 0 เป็น Boolean (แสดงเป็น checkbox) ที่เหลือเป็นข้อความ
    @Override public boolean isCellEditable(int r, int c) { return c == 0; } // แก้ไขได้เฉพาะคอลัมน์ติ๊ก
    @Override public Object getValueAt(int r, int c) { // ตารางถามค่าของแถว r คอลัมน์ c
        Exercise e = data.get(r); // ดึงท่าของแถวนั้น
        return switch (c) { // เลือกค่าตามคอลัมน์ (switch expression Java 14+)
            case 0 -> e.done; // คอลัมน์ 0: สถานะติ๊ก
            case 1 -> e.name; // คอลัมน์ 1: ชื่อท่า
            case 2 -> e.sets; // คอลัมน์ 2: จำนวน
            case 3 -> e.rest; // คอลัมน์ 3: เวลาพัก
            default -> e.muscle;}; } // คอลัมน์ 4: กล้ามเนื้อ แล้วปิด switch และเมธอด
    @Override // ทับเมธอดของคลาสแม่
    public void setValueAt(Object v, int r, int c) { // ถูกเรียกเมื่อผู้ใช้แก้ค่าในเซลล์ (ติ๊ก)
        if (c == 0) { // ทำเฉพาะคอลัมน์ checkbox
            data.get(r).done = (Boolean) v; // เก็บสถานะติ๊กใหม่
            fireTableCellUpdated(r, c); // แจ้งตารางให้วาดเซลล์นี้ใหม่
            if (onChange != null) onChange.run(); }}} // ถ้ามี callback ให้เรียก แล้วปิด if, เมธอด, คลาส ExerciseModel
    
    private final ExerciseModel model = new ExerciseModel(); // สร้างโมเดลตารางไว้ใช้ตลอด

    private void setupWorkoutTab() { // ผูก UI เข้ากับข้อมูล
        // รายการวัน
        javax.swing.DefaultListModel<String> lm = new javax.swing.DefaultListModel<>(); // โมเดลของ JList
        for (DayPlan p : plans) { lm.addElement(p.day + "  •  " + p.focus);} // เพิ่มข้อความ "วัน • โฟกัส" ทุกวัน
        dayList.setModel(lm); // ใส่โมเดลให้ list
        dayList.setFixedCellHeight(44); // ความสูงแต่ละแถว 44 px
        dayList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION); // เลือกได้ทีละวัน

        // ตาราง
        tblExercise.setModel(model); // ผูกโมเดลกับตาราง
        tblExercise.setRowHeight(32); // ความสูงแถว 32 px
        tblExercise.getColumnModel().getColumn(0).setMaxWidth(60); // คอลัมน์ติ๊กกว้างไม่เกิน 60
        tblExercise.getColumnModel().getColumn(2).setPreferredWidth(110); // คอลัมน์จำนวน กว้างที่ต้องการ 110
        tblExercise.getColumnModel().getColumn(3).setMaxWidth(70); // คอลัมน์พัก กว้างไม่เกิน 70
        DefaultTableCellRenderer center = new DefaultTableCellRenderer(); // ตัววาดเซลล์
        center.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); // จัดข้อความกึ่งกลาง
        tblExercise.getColumnModel().getColumn(2).setCellRenderer(center); // ใช้กับคอลัมน์จำนวน
        tblExercise.getColumnModel().getColumn(3).setCellRenderer(center); // ใช้กับคอลัมน์พัก
        tblExercise.getTableHeader().setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 14)); // หัวตารางใช้ Tahoma ตัวหนา 14

        // เมื่อติ๊กท่า ให้อัปเดตแถบ progress
        model.onChange = this::updateProgress; // ผูก callback ให้เรียก updateProgress

        // เมื่อเลือกวัน ให้แสดงตารางของวันนั้น
        dayList.addListSelectionListener(e -> { // listener ตอนเลือกวัน
            if (!e.getValueIsAdjusting()) { // ทำเมื่อการเลือกนิ่งแล้ว (กันทำซ้ำ 2 ครั้ง)
                showDay(dayList.getSelectedIndex());}}); // แสดงตารางของวันที่เลือก

        // เมื่อเลือกท่า ให้แสดงวิธีทำ
        tblExercise.getSelectionModel().addListSelectionListener(e -> { // listener ตอนเลือกแถวในตาราง
            int r = tblExercise.getSelectedRow(); // แถวที่เลือก (-1 ถ้าไม่มี)
            txtHow.setText(r >= 0 ? model.data.get(r).name + "\n" + model.data.get(r).how : ""); }); // แสดงชื่อท่า+วิธีทำ ถ้าไม่เลือกให้ว่าง
        // เลือกวันปัจจุบันเป็นค่าเริ่มต้น
        dayList.setSelectedIndex(0);} // เลือกวันแรก (จันทร์) จะกระตุ้น showDay(0) เอง

    private void showDay(int idx) { // แสดงแผนของวันลำดับ idx
        if (idx < 0) return; // ไม่มีการเลือก ให้ออกเลย
        DayPlan p = plans.get(idx); // ดึงแผนวันนั้น
        lblDayTitle.setText("วัน" + p.day + " : " + p.focus); // ตั้งหัวข้อ เช่น "วันจันทร์ : อก + ไตรเซ็ป"
        model.data = p.list; // เปลี่ยนข้อมูลโมเดลเป็นท่าของวันนั้น (สถานะติ๊กถูกจำไว้)
        model.fireTableDataChanged(); // แจ้งตารางให้วาดใหม่ทั้งหมด
        txtHow.setText(""); // เคลียร์ช่องวิธีทำ
        if (!p.list.isEmpty()) { // ถ้ามีท่าอย่างน้อย 1 ท่า
            tblExercise.setRowSelectionInterval(0, 0); // เลือกท่าแรกอัตโนมัติ
        } // จบ if
        updateProgress();} // คำนวณ progress ใหม่

    private void updateProgress() { // อัปเดตแถบความคืบหน้า
        int total = model.data.size(), done = 0; // จำนวนท่าทั้งหมด และตัวนับท่าที่ทำแล้ว
        for (Exercise e : model.data) { // วนทุกท่า
            if (e.done) done++;} // ถ้าติ๊กแล้วนับเพิ่ม
        progressBar.setValue(total == 0 ? 0 : done * 100 / total); // คำนวณ % (กันหารศูนย์)
        lblProgress.setText("ทำแล้ว " + done + "/" + total + " ท่า"); // แสดงข้อความ x/y ท่า
        if (total > 0 && done == total) { progressBar.setString("ครบแล้ว เก่งมาก!"); }  // ถ้าครบทุกท่า แสดงคำชม
        else {progressBar.setString(progressBar.getValue() + "%");}} // ไม่งั้นแสดงเปอร์เซ็นต์
    
    // อ่านตัวเลขจากช่องกรอก พร้อมตรวจช่วงที่ยอมรับ (min ถึง max)
    private double readNumber(javax.swing.JTextField f, String name, double min, double max) { // รับช่องกรอก ชื่อช่อง ค่าต่ำสุด ค่าสูงสุด
        String text = f.getText().trim(); // อ่านข้อความและตัดช่องว่างหัวท้าย
        if (text.isEmpty()) { // กรณีช่องว่าง
            f.requestFocusInWindow(); // ย้ายเคอร์เซอร์ไปช่องนั้น
            throw new IllegalArgumentException("Please fill in \"" + name + "\"");} // โยน error บอกให้กรอก
        if (!text.matches("\\d+(\\.\\d+)?")) { // ถ้าไม่ใช่เลขจำนวนเต็ม/ทศนิยม (regex)
            f.requestFocusInWindow(); // โฟกัสช่องนั้น
            f.selectAll(); // คลุมข้อความทั้งหมดให้แก้ง่าย
            throw new IllegalArgumentException("\"" + name + "\" must be a number.");} // โยน error ว่าต้องเป็นตัวเลข
        double v = Double.parseDouble(text); // แปลงข้อความเป็นตัวเลข
        if (v < min) { // ต่ำกว่าค่าต่ำสุด
            f.requestFocusInWindow(); // โฟกัสช่อง
            f.selectAll(); // คลุมข้อความ
            throw new IllegalArgumentException(String.format( // โยน error พร้อมบอกขอบเขตล่าง
                "\"%s\" Too low (must not be less than %.0f)", name, min));} // ข้อความ error ค่าต่ำเกิน
        if (v > max) { // สูงกว่าค่าสูงสุด
            f.requestFocusInWindow(); // โฟกัสช่อง
            f.selectAll(); // คลุมข้อความ
            throw new IllegalArgumentException(String.format( // โยน error พร้อมบอกขอบเขตบน
                "\"%s\" Too high (must not exceed %.0f)", name, max)); // ข้อความ error ค่าสูงเกิน
        } // จบ if
        return v; } // คืนค่าตัวเลขที่ผ่านการตรวจแล้ว
         private void initComponents() { // ปกติ NetBeans สร้างคอมโพเนนต์ตรงนี้ (ในไฟล์นี้ว่างเปล่า)
}// </editor-fold>//GEN-END:initComponents

private void txtMinutesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMinutesActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_txtMinutesActionPerformed

private void cmbSportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSportActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_cmbSportActionPerformed

@SuppressWarnings("empty-statement") // ปิด warning เรื่อง statement ว่าง
private void btnBurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBurnActionPerformed
         // ชื่อกิจกรรมและค่า MET ต้องเรียงตรงกับรายการใน cmbSport
    String[] sportNames = {"เดินเร็ว", "วิ่ง (8 กม./ชม.)", "ปั่นจักรยาน", "ว่ายน้ำ", // ชื่อกีฬา (ครึ่งแรก)
            "เต้นแอโรบิก", "ยกน้ำหนัก", "โยคะ", "HIIT", "กระโดดเชือก", "แบดมินตัน"}; // ชื่อกีฬา (ครึ่งหลัง)
    double[] sportMet = {3.8, 8.3, 7.5, 6.0, 6.5, 5.0, 2.5, 8.0, 11.0, 5.5}; // ค่า MET (ความหนักของกิจกรรม) เรียงตรงกับชื่อกีฬา

    btnBurn.setEnabled(false); // ปิดปุ่มชั่วคราว กันกดซ้ำ
    try { // เริ่มส่วนที่อาจเกิด error
        double w = readNumber(txtWeight2, "Weight", 20, 300); // อ่านน้ำหนัก 20-300 กก.
        double m = readNumber(txtMinutes, "Time", 1, 600); // อ่านเวลา 1-600 นาที

        int i = cmbSport.getSelectedIndex(); // ลำดับกีฬาที่เลือก
        double kcal = sportMet[i] * w * (m / 60.0);   // kcal = MET x น้ำหนัก x ชั่วโมง
        double fatG = kcal / 7.7;                      // ไขมัน 1 กรัม ~ 7.7 kcal

        StringBuilder sb = new StringBuilder(); // ตัวสร้างข้อความผลลัพธ์
        sb.append(String.format("%s %.0f นาที\n", sportNames[i], m)); // บรรทัดชื่อกีฬาและเวลา
        sb.append(String.format("เผาผลาญประมาณ %.0f kcal\n\n", kcal)); // แคลอรี่ที่เผาผลาญ
        sb.append(String.format("เทียบเท่าไขมันประมาณ %.0f กรัม\n", fatG)); // ไขมันเทียบเท่า
        sb.append(String.format("ค่า MET = %.1f\n\n", sportMet[i])); // แสดงค่า MET

        sb.append("เทียบกับอาหาร\n"); // หัวข้อเทียบอาหาร
        sb.append(String.format("• ข้าวสวย 1 จาน (~250 kcal): %.1f จาน\n", kcal / 250)); // เทียบเป็นจำนวนจานข้าว
        sb.append(String.format("• ชานมไข่มุก 1 แก้ว (~400 kcal): %.1f แก้ว\n\n", kcal / 400)); // เทียบเป็นแก้วชานม

        sb.append(String.format("เทียบทุกกิจกรรม (%.0f นาที)\n", m)); // หัวข้อเทียบทุกกิจกรรม
        for (int k = 0; k < sportNames.length; k++) { // วนทุกกีฬา
            sb.append(String.format("• %s: %.0f kcal\n", sportNames[k], sportMet[k] * w * m / 60.0)); // แคลอรี่ของแต่ละกีฬา เวลาและน้ำหนักเท่ากัน
        } // จบ for
        lblBurnResult.setText(sb.toString()); // แสดงผลบน label
    } catch (IllegalArgumentException ex) { // ถ้าอินพุตไม่ถูกต้อง
        javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage()); // แสดงกล่องข้อความแจ้ง error
    } finally {btnBurn.setEnabled(true);} // ไม่ว่าสำเร็จหรือพลาด เปิดปุ่มคืนเสมอ
}//GEN-LAST:event_btnBurnActionPerformed

private void btnCalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcActionPerformed
       btnCalc.setEnabled(false); // ปิดปุ่มชั่วคราว
    try { // เริ่มส่วนที่อาจเกิด error
        double w = readNumber(txtWeight, "Weight", 20, 300); // อ่านน้ำหนัก กก.
        double h = readNumber(txtHeight, "Height", 100, 250); // อ่านส่วนสูง ซม.
        double a = readNumber(txtAge, "Age", 10, 100); // อ่านอายุ

        double hm = h / 100.0; // แปลงส่วนสูงเป็นเมตร
        double bmi = w / (hm * hm); // BMI = น้ำหนัก / ส่วนสูง^2
        boolean male = cmbGender.getSelectedIndex() == 0; // ช่องแรกคือเพศชาย
        double bmr = 10 * w + 6.25 * h - 5 * a + (male ? 5 : -161); // BMR สูตร Mifflin-St Jeor
        double[] mul = {1.2, 1.375, 1.55, 1.725, 1.9}; // ตัวคูณระดับกิจกรรม 5 ระดับ
        double tdee = bmr * mul[cmbActivity.getSelectedIndex()]; // TDEE = พลังงานที่ใช้ต่อวัน

        // หมวดหมู่ BMI (เกณฑ์คนเอเชีย)
        String cat; // ตัวแปรเก็บหมวด
        if (bmi < 18.5)    cat = "น้ำหนักต่ำกว่าเกณฑ์"; // BMI < 18.5
        else if (bmi < 23) cat = "สมส่วน (ปกติ)"; // 18.5 - 22.9
        else if (bmi < 25) cat = "น้ำหนักเกิน"; // 23 - 24.9
        else if (bmi < 30) cat = "โรคอ้วนระดับ 1"; // 25 - 29.9
        else               cat = "โรคอ้วนระดับ 2"; // 30 ขึ้นไป

        // ช่วงน้ำหนักที่เหมาะสม (BMI 18.5 - 22.9)
        double minW = 18.5 * hm * hm; // น้ำหนักต่ำสุดที่เหมาะสม
        double maxW = 22.9 * hm * hm; // น้ำหนักสูงสุดที่เหมาะสม

        lblResult.setText(String.format("BMI = %.1f\n" // เริ่มสร้างข้อความ: บรรทัด BMI
              + "%s\n\n" // บรรทัดหมวด BMI
              + "BMR (พลังงานขณะพัก): %.0f kcal/วัน\n" // บรรทัด BMR
              + "TDEE (พลังงานที่ใช้ต่อวัน): %.0f kcal/วัน\n\n" // บรรทัด TDEE
              + "น้ำหนักที่เหมาะสม: %.1f - %.1f กก.\n\n" // ช่วงน้ำหนักที่เหมาะสม
              + "เป้าหมายแคลอรี่\n" // หัวข้อเป้าหมาย
              + "• ลดน้ำหนัก: ~%.0f kcal/วัน\n" // ลดน้ำหนัก = TDEE - 500
              + "• คงน้ำหนัก: ~%.0f kcal/วัน\n" // คงน้ำหนัก = TDEE
              + "• เพิ่มกล้ามเนื้อ: ~%.0f kcal/วัน\n\n" // เพิ่มกล้าม = TDEE + 300
              + "BMR คำนวณด้วยสูตร Mifflin-St Jeor / เกณฑ์ BMI สำหรับคนเอเชีย", // บรรทัดบอกที่มาของสูตร
                bmi, cat, // ค่าที่แทน %.1f และ %s แรก
                bmr, tdee, // ค่าที่แทน BMR และ TDEE
                minW, maxW, // ค่าที่แทนช่วงน้ำหนัก
                tdee - 500, tdee, tdee + 300)); // ค่าที่แทนเป้าหมายแคลอรี่ 3 แบบ

    } catch (IllegalArgumentException ex) { // ถ้าอินพุตไม่ถูกต้อง
        javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage()); // แสดงกล่องข้อความแจ้ง error
    } finally {btnCalc.setEnabled(true);} // เปิดปุ่มคืนเสมอ
}//GEN-LAST:event_btnCalcActionPerformed

private void txtAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgeActionPerformed

}//GEN-LAST:event_txtAgeActionPerformed

private void txtHeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHeightActionPerformed

}//GEN-LAST:event_txtHeightActionPerformed

private void txtWeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWeightActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_txtWeightActionPerformed

private void txtAgeHRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgeHRActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_txtAgeHRActionPerformed

private void btnHeartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHeartActionPerformed
        btnHeart.setEnabled(false); // ปิดปุ่มชั่วคราว
    try { // เริ่มส่วนที่อาจเกิด error
        double a = readNumber(txtAgeHR, "Age", 10, 100); // อ่านอายุ
        double r = readNumber(txtRestHR, "Resting Heart Rate", 30, 120); // อ่านชีพจรขณะพัก
        double max = 220 - a;        // อัตราการเต้นสูงสุด
        double reserve = max - r;    // ช่วงสำรองของหัวใจ (Heart Rate Reserve)
        if (reserve <= 0) { // ถ้าชีพจรพักสูงกว่าหรือเท่าชีพจรสูงสุด คำนวณไม่ได้
            throw new IllegalArgumentException("Resting heart rate must be lower than maximum heart rate."); // โยน error
        } // จบ if

        String[] zn = {"โซน 1 - วอร์มอัพ/ฟื้นตัว", "โซน 2 - เผาผลาญไขมัน", "โซน 3 - แอโรบิก", // ชื่อโซน 1-3
                       "โซน 4 - เพิ่มสมรรถภาพ", "โซน 5 - สูงสุด"}; // ชื่อโซน 4-5
        double[] lo = {0.50, 0.60, 0.70, 0.80, 0.90}; // เปอร์เซ็นต์ต่ำสุดของแต่ละโซน
        double[] hi = {0.60, 0.70, 0.80, 0.90, 1.00}; // เปอร์เซ็นต์สูงสุดของแต่ละโซน

        StringBuilder sb = new StringBuilder(); // ตัวสร้างข้อความผลลัพธ์
        sb.append(String.format("อัตราการเต้นสูงสุด = %.0f bpm\n", max)); // แสดงชีพจรสูงสุด
        sb.append("(สูตร Karvonen: ชีพจรเป้าหมาย = ชีพจรพัก + %HRR × (สูงสุด − พัก))\n\n"); // บอกสูตรที่ใช้
        for (int i = 0; i < 5; i++) { // วนทั้ง 5 โซน
            sb.append(String.format("■ %s\n    %.0f - %.0f bpm (%.0f-%.0f%%)\n", // รูปแบบข้อความของแต่ละโซน (%% คือเครื่องหมาย % จริง)
                zn[i], r + lo[i] * reserve, r + hi[i] * reserve, lo[i] * 100, hi[i] * 100));} // ชื่อโซน, ชีพจรต่ำ-สูงตามสูตร Karvonen, และ % ของโซน

        lblHeartResult.setText(sb.toString()); // แสดงผลบน label

    } catch (IllegalArgumentException ex) { // ถ้าอินพุตไม่ถูกต้อง
        javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage()); // แสดงกล่องข้อความแจ้ง error
    } finally {btnHeart.setEnabled(true);} // เปิดปุ่มคืนเสมอ
}
