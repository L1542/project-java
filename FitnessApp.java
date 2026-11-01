package fitnessapp;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class FitnessApp extends JFrame {

    // ---------- สี / ฟอนต์ ----------
    static final Color PRIMARY = new Color(0x1E88E5);
    static final Color ACCENT = new Color(0xFF7043);
    static final Color BG = new Color(0xF5F7FA);
    static final Font F_NORMAL = new Font("Tahoma", Font.PLAIN, 14);
    static final Font F_BOLD = new Font("Tahoma", Font.BOLD, 14);
    static final Font F_TITLE = new Font("Tahoma", Font.BOLD, 22);

    // ---------- ข้อมูลท่าออกกำลังกาย ----------
    static class Exercise {
        String name, sets, rest, muscle, how;
        boolean done;
        Exercise(String name, String sets, String rest, String muscle, String how) {
            this.name = name; this.sets = sets; this.rest = rest; this.muscle = muscle; this.how = how;
        }
    }

    static class DayPlan {
        String day, focus;
        List<Exercise> list = new ArrayList<>();
        DayPlan(String day, String focus) { this.day = day; this.focus = focus; }
        DayPlan add(String n, String s, String r, String m, String h) {
            list.add(new Exercise(n, s, r, m, h)); return this;
        }
    }

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
            .add("นอนหายใจลึกๆ", "5 นาที", "-", "จิตใจ", "นอนหงาย หายใจเข้า-ออกช้าๆ ผ่อนคลายทั้งตัว"));
    }

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
                default -> e.muscle;
            };
        }
        @Override
        public void setValueAt(Object v, int r, int c) {
            if (c == 0) {
                data.get(r).done = (Boolean) v;
                fireTableCellUpdated(r, c);
                if (onChange != null) onChange.run();
            }
        }
    }

    // ---------- UI ส่วนตารางออกกำลังกาย ----------
    JList<String> dayList;
    JLabel dayTitle = new JLabel();
    JLabel progressLabel = new JLabel();
    JProgressBar progressBar = new JProgressBar(0, 100);
    JTable table;
    ExerciseModel model = new ExerciseModel();
    JTextArea howTo = new JTextArea();

    public FitnessApp() {
        super("Fitness Planner - โปรแกรมออกกำลังกาย");
        buildPlans();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(960, 640);
        setMinimumSize(new Dimension(820, 560));
        setLocationRelativeTo(null);

        JTabbedPane tabs = new JTabbedPane();
        tabs.setFont(F_BOLD);
        tabs.addTab(" ตารางออกกำลังกาย", buildWorkoutTab());
        tabs.addTab(" BMI / BMR / TDEE", buildBodyTab());
        tabs.addTab(" แคลอรี่ที่เผาผลาญ", buildCalorieTab());
        tabs.addTab(" อัตราการเต้นหัวใจ", buildHeartTab());

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(PRIMARY);
        header.setBorder(new EmptyBorder(12, 20, 12, 20));
        JLabel title = new JLabel("Fitness Planner");
        title.setFont(F_TITLE);
        title.setForeground(Color.WHITE);
        header.add(title, BorderLayout.WEST);
        add(header, BorderLayout.NORTH);
        add(tabs, BorderLayout.CENTER);
    }

    String thaiDayName(int idx) { return plans.get(idx).day; }

    JPanel buildWorkoutTab() {
        JPanel root = new JPanel(new BorderLayout(12, 12));
        root.setBorder(new EmptyBorder(12, 12, 12, 12));
        root.setBackground(BG);

        // รายการวัน (ซ้าย)
        DefaultListModel<String> lm = new DefaultListModel<>();
        for (DayPlan p : plans) lm.addElement(p.day + "  •  " + p.focus);
        dayList = new JList<>(lm);
        dayList.setFont(F_NORMAL);
        dayList.setFixedCellHeight(44);
        dayList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        dayList.setSelectionBackground(PRIMARY);
        dayList.setSelectionForeground(Color.WHITE);
        JScrollPane leftScroll = new JScrollPane(dayList);
        leftScroll.setPreferredSize(new Dimension(230, 0));
        leftScroll.setBorder(BorderFactory.createTitledBorder("เลือกวัน"));

        // ตาราง (กลาง)
        table = new JTable(model);
        table.setFont(F_NORMAL);
        table.setRowHeight(32);
        table.getTableHeader().setFont(F_BOLD);
        table.setSelectionBackground(new Color(0xBBDEFB));
        table.setSelectionForeground(Color.BLACK);
        table.getColumnModel().getColumn(0).setMaxWidth(60);
        table.getColumnModel().getColumn(2).setPreferredWidth(110);
        table.getColumnModel().getColumn(3).setMaxWidth(70);
        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(SwingConstants.CENTER);
        table.getColumnModel().getColumn(2).setCellRenderer(center);
        table.getColumnModel().getColumn(3).setCellRenderer(center);

        // หัวข้อ + progress
        dayTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
        dayTitle.setForeground(PRIMARY);
        progressLabel.setFont(F_NORMAL);
        progressBar.setStringPainted(true);
        progressBar.setForeground(new Color(0x43A047));
        JPanel top = new JPanel(new BorderLayout(8, 4));
        top.setOpaque(false);
        top.add(dayTitle, BorderLayout.NORTH);
        JPanel pg = new JPanel(new BorderLayout(8, 0));
        pg.setOpaque(false);
        pg.add(progressLabel, BorderLayout.WEST);
        pg.add(progressBar, BorderLayout.CENTER);
        top.add(pg, BorderLayout.SOUTH);

        // วิธีทำ (ล่าง)
        howTo.setFont(F_NORMAL);
        howTo.setEditable(false);
        howTo.setLineWrap(true);
        howTo.setWrapStyleWord(true);
        howTo.setBackground(new Color(0xFFF8E1));
        howTo.setBorder(new EmptyBorder(6, 8, 6, 8));
        JScrollPane howScroll = new JScrollPane(howTo);
        howScroll.setPreferredSize(new Dimension(0, 90));
        howScroll.setBorder(BorderFactory.createTitledBorder("วิธีทำ"));

    

        JPanel center2 = new JPanel(new BorderLayout(8, 8));
        center2.setOpaque(false);
        center2.add(top, BorderLayout.NORTH);
        center2.add(new JScrollPane(table), BorderLayout.CENTER);
        center2.add(howScroll, BorderLayout.SOUTH);

        root.add(leftScroll, BorderLayout.WEST);
        root.add(center2, BorderLayout.CENTER);

        // events
        model.onChange = this::updateProgress;
        dayList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) showDay(dayList.getSelectedIndex());
        });
        table.getSelectionModel().addListSelectionListener(e -> {
            int r = table.getSelectedRow();
            howTo.setText(r >= 0 ? model.data.get(r).name + "\n" + model.data.get(r).how : "");
        });

        // เลือกวันปัจจุบันเป็นค่าเริ่มต้น
        dayList.setSelectedIndex(LocalDate.now().getDayOfWeek().getValue() - 1);
        return root;
    }

    void showDay(int idx) {
        if (idx < 0) return;
        DayPlan p = plans.get(idx);
        dayTitle.setText("วัน" + p.day + " : " + p.focus);
        model.data = p.list;
        model.fireTableDataChanged();
        howTo.setText("");
        if (!p.list.isEmpty()) table.setRowSelectionInterval(0, 0);
        updateProgress();
    }

    void updateProgress() {
        int total = model.data.size(), done = 0;
        for (Exercise e : model.data) if (e.done) done++;
        progressBar.setValue(total == 0 ? 0 : done * 100 / total);
        progressLabel.setText("ทำแล้ว " + done + "/" + total + " ท่า");
        if (total > 0 && done == total) progressBar.setString("🎉 ครบแล้ว เก่งมาก!");
        else progressBar.setString(progressBar.getValue() + "%");
    }

    // ---------- helper สร้างฟอร์ม ----------
    JPanel formPanel() {
        JPanel p = new JPanel(new GridBagLayout());
        p.setBorder(new EmptyBorder(16, 16, 16, 16));
        p.setBackground(Color.WHITE);
        return p;
    }

    int row = 0;
    void addRow(JPanel p, String label, JComponent comp) {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 4, 6, 4);
        c.gridy = row++;
        c.gridx = 0; c.anchor = GridBagConstraints.WEST;
        JLabel l = new JLabel(label); l.setFont(F_NORMAL);
        p.add(l, c);
        c.gridx = 1; c.fill = GridBagConstraints.HORIZONTAL; c.weightx = 1;
        comp.setFont(F_NORMAL);
        p.add(comp, c);
    }

    JTextField num(String init) {
        JTextField t = new JTextField(init, 8);
        return t;
    }

    JButton calcButton(String text) {
        JButton b = new JButton(text);
        b.setFont(F_BOLD);
        b.setBackground(ACCENT);
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        b.setOpaque(true);
        b.setBorderPainted(false);
        b.setBorder(new EmptyBorder(10, 20, 10, 20));
        return b;
    }

    JLabel resultLabel() {
        JLabel r = new JLabel("<html><i>กรอกข้อมูลแล้วกดปุ่มคำนวณ</i></html>");
        r.setFont(F_NORMAL);
        r.setVerticalAlignment(SwingConstants.TOP);
        r.setBorder(new EmptyBorder(16, 16, 16, 16));
        return r;
    }

    JPanel twoColumn(JPanel form, JLabel result, String formTitle) {
        JPanel root = new JPanel(new GridLayout(1, 2, 12, 12));
        root.setBorder(new EmptyBorder(12, 12, 12, 12));
        root.setBackground(BG);
        form.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(formTitle), new EmptyBorder(8, 8, 8, 8)));
        JPanel resWrap = new JPanel(new BorderLayout());
        resWrap.setBackground(new Color(0xE3F2FD));
        resWrap.setBorder(BorderFactory.createTitledBorder("ผลลัพธ์"));
        resWrap.add(result, BorderLayout.NORTH);
        root.add(form);
        root.add(resWrap);
        return root;
    }

        // อ่านตัวเลขจากช่องกรอก พร้อมตรวจช่วงที่ยอมรับ (min ถึง max)
    static double parse(JTextField f, String name, double min, double max) {
        String text = f.getText().trim();
        if (text.isEmpty()) {
            f.requestFocusInWindow();
            throw new IllegalArgumentException("กรุณากรอก \"" + name + "\"");}
        double v;
        try {
            v = Double.parseDouble(text);
        } catch (NumberFormatException ex) {
            v = Double.NaN;}
        if (Double.isNaN(v) || Double.isInfinite(v)) {   // ไม่ใช่ตัวเลข / NaN / Infinity
            f.requestFocusInWindow();
            f.selectAll();
            throw new IllegalArgumentException("\"" + name + "\" ต้องเป็นตัวเลขเท่านั้น");}
        if (v < min) {
            f.requestFocusInWindow();
            f.selectAll();
            throw new IllegalArgumentException(String.format(
                    "\"%s\" น้อยเกินไป (ต้องไม่ต่ำกว่า %.0f)", name, min));}
        if (v > max) {
            f.requestFocusInWindow();
            f.selectAll();
            throw new IllegalArgumentException(String.format(
                    "\"%s\" มากเกินไป (ต้องไม่เกิน %.0f)", name, max));}
        return v; }

    void error(String msg) {
        JOptionPane.showMessageDialog(this, msg, "ข้อมูลไม่ถูกต้อง", JOptionPane.WARNING_MESSAGE);
    }

    // ---------- แท็บ BMI / BMR / TDEE ----------
    JPanel buildBodyTab() {
        row = 0;
        JPanel form = formPanel();
        JTextField weight = num("65"), height = num("170"), age = num("25");
        JComboBox<String> gender = new JComboBox<>(new String[]{"ชาย", "หญิง"});
        String[] actNames = {
            "นั่งทำงานเป็นหลัก (ไม่ออกกำลังกาย)",
            "ออกกำลังกายเบา 1-3 วัน/สัปดาห์",
            "ออกกำลังกายปานกลาง 3-5 วัน/สัปดาห์",
            "ออกกำลังกายหนัก 6-7 วัน/สัปดาห์",
            "ออกกำลังกายหนักมาก / งานใช้แรง"};
        double[] actMul = {1.2, 1.375, 1.55, 1.725, 1.9};
        JComboBox<String> act = new JComboBox<>(actNames);
        act.setSelectedIndex(2);
        addRow(form, "น้ำหนัก (กก.)", weight);
        addRow(form, "ส่วนสูง (ซม.)", height);
        addRow(form, "อายุ (ปี)", age);
        addRow(form, "เพศ", gender);
        addRow(form, "กิจกรรม", act);
        JButton b = calcButton("คำนวณ");
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = row++; c.gridx = 0; c.gridwidth = 2; c.insets = new Insets(16, 4, 4, 4);
        form.add(b, c);
        c.gridy = row; c.weighty = 1; form.add(Box.createGlue(), c);

        JLabel result = resultLabel();
        b.addActionListener(e -> {
            try {
                double w = parse(weight, "น้ำหนัก", 20, 300);
                double h = parse(height, "ส่วนสูง", 100, 250);
                double a = parse(age, "อายุ", 10, 100);
                double hm = h / 100.0;
                double bmi = w / (hm * hm);
                String cat; String col;
                if (bmi < 18.5) { cat = "น้ำหนักต่ำกว่าเกณฑ์"; col = "#1E88E5"; }
                else if (bmi < 23) { cat = "สมส่วน (ปกติ)"; col = "#43A047"; }
                else if (bmi < 25) { cat = "น้ำหนักเกิน"; col = "#FB8C00"; }
                else if (bmi < 30) { cat = "โรคอ้วนระดับ 1"; col = "#F4511E"; }
                else { cat = "โรคอ้วนระดับ 2"; col = "#C62828"; }
                boolean male = gender.getSelectedIndex() == 0;
                double bmr = 10 * w + 6.25 * h - 5 * a + (male ? 5 : -161);
                double tdee = bmr * actMul[act.getSelectedIndex()];
                double minW = 18.5 * hm * hm, maxW = 22.9 * hm * hm;
                result.setText(String.format(
                    "<html><div style='width:300px'>"
                  + "<h3>BMI = %.1f</h3>"
                  + "<p style='color:%s'><b>%s</b></p><br>"
                  + "<b>BMR</b> (พลังงานขณะพัก): %.0f kcal/วัน<br>"
                  + "<b>TDEE</b> (พลังงานที่ใช้ต่อวัน): %.0f kcal/วัน<br><br>"
                  + "น้ำหนักที่เหมาะสม: %.1f - %.1f กก.<br><br>"
                  + "<b>เป้าหมายแคลอรี่</b><br>"
                  + "• ลดน้ำหนัก: ~%.0f kcal/วัน<br>"
                  + "• คงน้ำหนัก: ~%.0f kcal/วัน<br>"
                  + "• เพิ่มกล้ามเนื้อ: ~%.0f kcal/วัน<br>"
                  + "<br><small>BMR คำนวณด้วยสูตร Mifflin-St Jeor / เกณฑ์ BMI สำหรับคนเอเชีย</small>"
                  + "</div></html>",
                    bmi, col, cat, bmr, tdee, minW, maxW, tdee - 500, tdee, tdee + 300));
            } catch (IllegalArgumentException ex) { error(ex.getMessage()); }
        });
        return twoColumn(form, result, "ข้อมูลร่างกาย");
    }

    // ---------- แท็บแคลอรี่ ----------
    JPanel buildCalorieTab() {
        row = 0;
        JPanel form = formPanel();
        String[] names = {"เดินเร็ว", "วิ่ง (8 กม./ชม.)", "ปั่นจักรยาน", "ว่ายน้ำ", "เต้นแอโรบิก",
                "ยกน้ำหนัก", "โยคะ", "HIIT", "กระโดดเชือก", "แบดมินตัน"};
        double[] met = {3.8, 8.3, 7.5, 6.0, 6.5, 5.0, 2.5, 8.0, 11.0, 5.5};
        JComboBox<String> sport = new JComboBox<>(names);
        JTextField weight = num("65"), minutes = num("30");
        addRow(form, "กิจกรรม", sport);
        addRow(form, "น้ำหนัก (กก.)", weight);
        addRow(form, "เวลา (นาที)", minutes);
        JButton b = calcButton("คำนวณแคลอรี่");
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = row++; c.gridx = 0; c.gridwidth = 2; c.insets = new Insets(16, 4, 4, 4);
        form.add(b, c);
        c.gridy = row; c.weighty = 1; form.add(Box.createGlue(), c);

        JLabel result = resultLabel();
        b.addActionListener(e -> {
            try {
                double w = parse(weight, "น้ำหนัก", 20, 300);
                double m = parse(minutes, "เวลา", 1, 600);
                int i = sport.getSelectedIndex();
                double kcal = met[i] * w * (m / 60.0);
                double fatG = kcal / 7.7; // ~7.7 kcal ต่อไขมัน 1 กรัม
                StringBuilder sb = new StringBuilder("<html><div style='width:300px'>");
                sb.append(String.format("<h3>%s %.0f นาที</h3>", names[i], m));
                sb.append(String.format("เผาผลาญประมาณ <b style='color:#F4511E;font-size:18px'>%.0f kcal</b><br><br>", kcal));
                sb.append(String.format("เทียบเท่าไขมันประมาณ %.0f กรัม<br>", fatG));
                sb.append(String.format("ค่า MET = %.1f<br><br>", met[i]));
                sb.append("<b>เทียบกับอาหาร</b><br>");
                sb.append(String.format("• ข้าวสวย 1 จาน (~250 kcal): %.1f จาน<br>", kcal / 250));
                sb.append(String.format("• ชานมไข่มุก 1 แก้ว (~400 kcal): %.1f แก้ว<br>", kcal / 400));
                sb.append("<br><b>เทียบทุกกิจกรรม (").append((int) m).append(" นาที)</b><br>");
                for (int k = 0; k < names.length; k++)
                    sb.append(String.format("• %s: %.0f kcal<br>", names[k], met[k] * w * m / 60.0));
                sb.append("</div></html>");
                result.setText(sb.toString());
            } catch (IllegalArgumentException ex) { error(ex.getMessage()); }
        });
        return twoColumn(form, result, "ข้อมูลการออกกำลังกาย");
    }

    // ---------- แท็บอัตราการเต้นหัวใจ ----------
    JPanel buildHeartTab() {
        row = 0;
        JPanel form = formPanel();
        JTextField age = num("25"), rest = num("70");
        addRow(form, "อายุ (ปี)", age);
        addRow(form, "ชีพจรขณะพัก (ครั้ง/นาที)", rest);
        JButton b = calcButton("คำนวณโซนหัวใจ");
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = row++; c.gridx = 0; c.gridwidth = 2; c.insets = new Insets(16, 4, 4, 4);
        form.add(b, c);
        c.gridy = row; c.weighty = 1; form.add(Box.createGlue(), c);

        JLabel result = resultLabel();
        b.addActionListener(e -> {
            try {
                double a = parse(age, "อายุ", 10, 100);
                double r = parse(rest, "ชีพจรขณะพัก", 30, 120);
                double max = 220 - a, reserve = max - r;
                if (reserve <= 0) throw new IllegalArgumentException("ชีพจรขณะพักต้องน้อยกว่าอัตราการเต้นสูงสุด");
                String[] zn = {"โซน 1 - วอร์มอัพ/ฟื้นตัว", "โซน 2 - เผาผลาญไขมัน", "โซน 3 - แอโรบิก",
                        "โซน 4 - เพิ่มสมรรถภาพ", "โซน 5 - สูงสุด"};
                String[] col = {"#90A4AE", "#43A047", "#FDD835", "#FB8C00", "#E53935"};
                double[] lo = {0.50, 0.60, 0.70, 0.80, 0.90};
                double[] hi = {0.60, 0.70, 0.80, 0.90, 1.00};
                StringBuilder sb = new StringBuilder("<html><div style='width:320px'>");
                sb.append(String.format("<h3>อัตราการเต้นสูงสุด = %.0f bpm</h3>", max));
                sb.append("<small>(สูตร Karvonen: ชีพจรเป้าหมาย = ชีพจรพัก + %HRR × (สูงสุด − พัก))</small><br><br>");
                for (int i = 0; i < 5; i++) {
                    sb.append(String.format("<span style='color:%s'>■</span> <b>%s</b><br>&nbsp;&nbsp;&nbsp;%.0f - %.0f bpm (%.0f-%.0f%%)<br>",
                            col[i], zn[i], r + lo[i] * reserve, r + hi[i] * reserve, lo[i] * 100, hi[i] * 100));
                }
                sb.append("</div></html>");
                result.setText(sb.toString());
            } catch (IllegalArgumentException ex) { error(ex.getMessage()); }
        });
        return twoColumn(form, result, "ข้อมูลหัวใจ");
    }

    // ---------- main ----------
    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ignored) {}
        SwingUtilities.invokeLater(() -> new FitnessApp().setVisible(true));
    }
}